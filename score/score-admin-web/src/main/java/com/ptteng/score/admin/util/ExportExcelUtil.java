package com.ptteng.score.admin.util;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.controller.ExcelController;
import com.ptteng.score.admin.responseStructure.ExcelRewareLog;
import com.ptteng.score.admin.responseStructure.ExcelScoreLog;
import com.ptteng.score.admin.responseStructure.ExcelTotalScore;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.*;
import org.restlet.data.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title:    excelOutputTest
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/22
 */
public class ExportExcelUtil<T> {

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(ExportExcelUtil.class);
    public static HttpClientUtil httpClientUtil = new HttpClientUtil();
    private static ThreadLocal<SimpleDateFormat> df4 = new ThreadLocal<>();

    public void exportExcel(String[] headers, Collection<T> dataset, String fileName, HttpServletResponse response) {
        /**
         *@Author hfismyangel@163.com
         *@Description:excel导出功能
         *@Date: 16:08 2017/9/29
         * @param headers
         * @param dataset
         * @param fileName
         * @param response
         */
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(fileName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        log.info("==============这里进不去吗？");
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        log.info("==============这里进不去吗？");
        try {
            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                //T为通用类型参数，其下有原生类型，参数化类型，数组类型，类型变量和原始类型。
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < headers.length; i++) {
                    XSSFCell cell = row.createCell(i);
                    Field field = fields[i];
                    //使用get/set取private字段值其实无需访问权限，但加上可以规避java安全检查，提高反射运行速度
//                    field.setAccessible(true);
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // 其它数据类型都当作字符串简单处理
                    if (value != null && value != "") {
                        textValue = value.toString();
                    }
                    if (textValue != null) {
                        XSSFRichTextString richString = new XSSFRichTextString(textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
            log.info("=======>>进来了，下面写入response");
            getExportedFile(workbook, fileName, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("导出异常！         " + e.getMessage());
            log.error(printStackTraceToString(e));

        }
    }

    private String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }

    /**
     * 方法说明: 写入response
     *
     * @return
     */
    public void getExportedFile(XSSFWorkbook workbook, String name, HttpServletResponse response) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:将excel写入response
         *@Date: 16:09 2017/9/29
         * @param workbook
         * @param name
         * @param response
         */
        BufferedOutputStream fos = null;
        try {
            log.info("============>>写入response，应该返回了");
            String fileName = name + ".xlsx";
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
            fos = new BufferedOutputStream(response.getOutputStream());
            log.info("=============>>可以了吗？");
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }


    //注意，如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
    public List<T> readXls(Class classes, MultipartFile file) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         *@Author hfismyangel@163.com
         *@Description:通用excel导入模板
         *@Date: 16:09 2017/9/29
         * @param classes
         * @param file
         */
        InputStream is = file.getInputStream();
        XSSFWorkbook XSSFWorkbook = new XSSFWorkbook(is);

        List<Object> list = new ArrayList<>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < XSSFWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = XSSFWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    Object o = classes.newInstance();
                    //getDeclaredFields获取所有private/protect/public字段。getFields获取所有公共字段
                    Field[] fields = classes.getDeclaredFields();
                    /*
                    Arrays.asList() 返回java.util.Arrays$ArrayList， 而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList
                    remove，add等 method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
                    ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove(int)，add(int)等
                    所以throw UnsupportedOperationException。
                    总之，如果不使用add/remove/addAll等等改变元素的方法，可以用Arrays转换数组，其他情况用迭代器遍历
                     */
                    List<Field> list1 = new ArrayList<>();
                    for (Field field : fields) {
                        list1.add(field);
                    }
//                    list1.remove(0);
                    log.info("===============>>" + list1.size());
                    int i = 0;
                    for (Field field : list1) {
                        String fieldName = field.getName();
                        //这里可以做性能优化，改为StringBuilder，多次append拼接.不要在循环里拼接string
                        String getMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        log.debug("=================>>method name:" + getMethodName);
                        //根据字段类型不同选择注入类型
                        if (field.getType() == Integer.class) {
                            Method getMethod = classes.getMethod(getMethodName, Integer.class);
                            XSSFCell xss = hssfRow.getCell(i);
                            String string;
                            //非空及非空字符串判断
                            string = null == xss ? "0" : xss.toString();
                            string = string.equals("") ? "0" : string;
                            getMethod.invoke(o, Integer.valueOf(string));
                        } else if (field.getType() == String.class) {
                            Method getMethod = classes.getMethod(getMethodName, String.class);
                            XSSFCell xss = hssfRow.getCell(i);
                            String string;
                            //非空及非空字符串判断
                            string = null == xss ? "" : xss.toString();
                            string = string.equals("") ? "" : string;

                            getMethod.invoke(o, string);
                        } else if (field.getType() == Long.class) {
                            Method getMethod = classes.getMethod(getMethodName, Long.class);
                            XSSFCell xss = hssfRow.getCell(i);
                            String string;
                            //非空及非空字符串判断
                            string = null == xss ? "0" : xss.toString();
                            string = string.equals("") ? "0" : string;
                            if (string.contains(".")) {
                                String[] split = string.split("\\.");
                                log.info(split[0] + "+++" + split[1]);
                                getMethod.invoke(o, Long.valueOf(split[0]));
                            } else {
                                getMethod.invoke(o, Long.valueOf(string));
                            }

                        }
                        i++;
                    }
                    log.error(o.toString());
                    list.add(o);
                }
            }
        }
        return (List<T>) list;
    }

    public static void main(String[] args) {
        String string = "550.0";
        String[] split = string.split("\\.");
        System.out.println(string.contains("."));
        System.out.println(split.length);
        System.out.println(split[0] + "+++" + split[1]);
    }

    @SuppressWarnings("static-access")
    public static String getValue(XSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }

    }

    public static String formatTime(String string) {
        //时间格式化，使用ThreadLocal实现无锁
        if (df4.get() == null) {
            df4.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
        String createAt = df4.get().format(new Date(Long.parseLong(string)));
        df4.remove();
        return createAt;
    }


    public static void outputRewardLog(HttpServletResponse response) throws ServiceException, ServiceDaoException {
        //回调相应后端接口获取数据进行处理
        String result = httpClientUtil.doGet("http://127.0.0.1:10962/a/u/rewardLogs");
        JSONObject jsonObject = JSONObject.fromObject(result);
        JSONArray data = jsonObject.getJSONArray("data");
        List<ExcelRewareLog> logs = new ArrayList<>();
        //使用jsonObject拼接Excel model
        for (int i = data.size(); i >= 1; i--) {
//            JSONArray jsonArray = data.getJSONArray(0);//修改重复bug
            JSONArray jsonArray = data.getJSONArray(i - 1);
            JSONObject recode = jsonArray.getJSONObject(0);
            JSONObject staff = jsonArray.getJSONObject(1);
            ExcelRewareLog excelRewareLog = new ExcelRewareLog();

            excelRewareLog.setId(staff.getString("id"));
            excelRewareLog.setStaffName(staff.getString("name"));
            excelRewareLog.setDepartment(staff.getString("departmentName"));
            excelRewareLog.setPosition(staff.getString("positionName"));

            excelRewareLog.setAdminName(recode.getString("adminName"));
            excelRewareLog.setTitle(recode.getString("rewardTitle"));
            excelRewareLog.setContent(recode.getString("rewardContent"));
            excelRewareLog.setScore(recode.getString("rewardScore"));
//            excelRewareLog.setScoreType(recode.getString("scoreType"));
            excelRewareLog.setScoreType("领导表扬");
            String date = formatTime(recode.getString("createAt"));
            excelRewareLog.setRewardTime(date);
            logs.add(excelRewareLog);
        }
        new ExportExcelUtil().exportExcel(ConstantItem.REWARD_FIELD, logs, ConstantItem.REWARD_TABLE_NAME, response);
    }

    public static void outputStaffScoreLog(HttpServletResponse response) throws ServiceException, ServiceDaoException {
        //回调相应后端接口获取数据进行处理
        String result = httpClientUtil.doGet("http://127.0.0.1:10962/a/u/scoreLogs");
        JSONObject jsonObject = JSONObject.fromObject(result);
        JSONArray data = jsonObject.getJSONArray("data");
        List<ExcelScoreLog> logs = new ArrayList<>();
        for (int i = data.size(); i >= 1; i--) {
//            JSONArray jsonArray = data.getJSONArray(0);
            JSONArray jsonArray = data.getJSONArray(i - 1);
            JSONObject recode = jsonArray.getJSONObject(0);
            JSONObject staff = jsonArray.getJSONObject(1);

            ExcelScoreLog excelScoreLog = new ExcelScoreLog();
            excelScoreLog.setId(staff.getString("id"));
            excelScoreLog.setDepartment(staff.getString("departmentName"));
            excelScoreLog.setPosition(staff.getString("positionName"));
            excelScoreLog.setName(staff.getString("name"));
            excelScoreLog.setScoreReason(recode.getString("scoreReason"));
            int type = Integer.parseInt(recode.getString("scoreType"));
            switch (type) {
                case 0:
//               scoreType约定：0品德/1业绩/2行为/3点赞/4日志/5企业哲学/6领导表扬/7任务积分/8考勤/9商品
                    excelScoreLog.setScoreType("品德A");
                    break;
                case 1:
                    excelScoreLog.setScoreType("业绩B");
                    break;
                case 2:
                    excelScoreLog.setScoreType("行为C");
                    break;
                case 3:
                    excelScoreLog.setScoreType("点赞");
                    break;
                case 4:
                    excelScoreLog.setScoreType("发表日志");
                    break;
                case 5:
                    excelScoreLog.setScoreType("企业哲学");
                    break;
                case 6:
                    excelScoreLog.setScoreType("领导表扬");
                    break;
                case 7:
                    excelScoreLog.setScoreType("任务积分");
                    break;
                case 8:
                    excelScoreLog.setScoreType("考勤");
                    break;
                case 9:
                    excelScoreLog.setScoreType("商品兑换");
                    break;
                default:

            }

            excelScoreLog.setScoreChange(recode.getString("scoreChange"));

            String date = formatTime(recode.getString("createAt"));
            excelScoreLog.setCreateAt(date);
            logs.add(excelScoreLog);
        }
        new ExportExcelUtil().exportExcel(ConstantItem.SCORE_FIELD, logs, ConstantItem.SCORE_TABLE_NAME, response);
    }

    public static void outputScoreRankList(HttpServletResponse response) throws ServiceException, ServiceDaoException {
        //回调相应后端接口获取数据进行处理
        String result = httpClientUtil.doGet("http://127.0.0.1:10962/a/u/scoreRank");
        JSONObject jsonObject = JSONObject.fromObject(result);
        JSONArray data = jsonObject.getJSONArray("data");
        List<ExcelTotalScore> logs = new ArrayList<>();
        for (int i = data.size() - 1; i >= 0; i--) {
            JSONObject jsonArray = data.getJSONObject(i);
            ExcelTotalScore excelScoreLog = new ExcelTotalScore();
            excelScoreLog.setAddScore(jsonArray.getString("addScore"));
            excelScoreLog.setBaseScore(jsonArray.getString("baseScore"));
            excelScoreLog.setCommendScore(jsonArray.getString("commendScore"));
            excelScoreLog.setDegreeScore(jsonArray.getString("degreeScore"));
            excelScoreLog.setDepartmentName(jsonArray.getString("departmentName"));
            excelScoreLog.setHonorScore(jsonArray.getString("honorScore"));
            excelScoreLog.setId(jsonArray.getString("id"));
            excelScoreLog.setIncumbency(jsonArray.getString("incumbency"));
            excelScoreLog.setJopScore(jsonArray.getString("jopScore"));
            excelScoreLog.setLoveScore(jsonArray.getString("loveScore"));
            excelScoreLog.setName(jsonArray.getString("name"));
            excelScoreLog.setPositionName(jsonArray.getString("positionName"));
            excelScoreLog.setRanking(jsonArray.getString("ranking"));
            excelScoreLog.setScoreSituation(jsonArray.getString("scoreSituation"));
            excelScoreLog.setSeniority(jsonArray.getString("seniority"));
            excelScoreLog.setSpecialityScore(jsonArray.getString("specialityScore"));
            excelScoreLog.setStar(jsonArray.getString("star"));
            excelScoreLog.setSubScore(jsonArray.getString("subScore"));
            excelScoreLog.setSunScore(jsonArray.getString("sunScore"));
            excelScoreLog.setTotalScore(jsonArray.getString("totalScore"));

            logs.add(excelScoreLog);
        }
        new ExportExcelUtil().exportExcel(ConstantItem.SCORE_RANK_FIELD, logs, ConstantItem.SCORE_RANK_TABLE_NAME, response);
    }


}
