package com.ptteng.score.admin.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.responseStructure.*;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ExportExcelUtil;
import com.ptteng.score.admin.util.GsonUtil;
import com.ptteng.score.admin.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/28
 */
@Controller
public class ExcelController {
    private static final org.apache.commons.logging.Log log = LogFactory.getLog(ExcelController.class);

    @Autowired
    private ExportExcelUtil exportExcelUtil;
    @Autowired
    private StaffService staffService;

    @Value(value = "${server.ipconfig}")
    private String ip;


    @RequestMapping(value = "/a/u/excelExport", method = RequestMethod.GET)
    public void getMultiArticleJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Integer id)
            throws Exception {
        /**
         *@Description:根据类型，自动导出4种excel/0企业员工列表/1员工总积分榜/2员工积分日志/3管理员表扬日志
         */
        log.info("========export typr>>" + id);
        switch (id) {
            //选择导出类型
            case 0:
                List<Long> staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
                log.info("get staffIds is: " + staffIds);

                List<Staff> staffList = staffService.getObjectsByIds(staffIds);

                log.info("get size>>" + staffList.size());
                List<NewExcelStaff> list = new ArrayList<>();
                for (Staff staff : staffList) {
                    NewExcelStaff newExcelStaff = new NewExcelStaff();
                    newExcelStaff.setId(staff.getId());
                    newExcelStaff.setImg(staff.getImg());
                    newExcelStaff.setName(staff.getName());
                    newExcelStaff.setPhone(staff.getPhone());
//                    String password = newExcelStaff.getPassword();
//                    if (password.contains("\\.")) {
//                        staff.setPwd(password.substring(0, password.length() - 2));
//                    }else {
//                        staff.setPwd(password);
//                    }
                    newExcelStaff.setPassword(staff.getPwd());
                    list.add(newExcelStaff);
                }

                exportExcelUtil.exportExcel(ConstantItem.NEW_STAFF, list, ConstantItem.STAFF_TABLE_NAME, response);
                break;
            case 1:
                ExportExcelUtil.outputScoreRankList(response);
                break;
            case 2:
                ExportExcelUtil.outputStaffScoreLog(response);
                break;
            case 3:
                ExportExcelUtil.outputRewardLog(response);
                break;
            default:
        }
    }

    @RequestMapping(value = "/a/u/excelRead", method = RequestMethod.POST)
    public String excelRead(@RequestParam("file") MultipartFile file, ModelMap model) throws ServiceException, ServiceDaoException {
        /**
         *@Description:excel导入数据库接口
         */


        try {

            List<NewExcelStaff> list = exportExcelUtil.readXls(NewExcelStaff.class, file);
            log.info("去重前表格有多少数据：" + list.size());

            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            List<Staff> staffList1 = staffService.getObjectsByIds(staffIds);
            for (Staff s : staffList1) {
                Iterator<NewExcelStaff> list1 = list.iterator();
                while (list1.hasNext()) {
                    NewExcelStaff newExcelStaff = list1.next();
                    if (newExcelStaff.getPhone().equals(s.getPhone())) {
                        list1.remove();
                    }
                }
            }

            log.info("去重后表格还剩多少数据：" + list.size());
            List<Staff> staffList = new ArrayList<>();
            for (NewExcelStaff newExcelStaff : list) {
                Staff staff = new Staff();
                staff.setId(newExcelStaff.getId());
                staff.setName(newExcelStaff.getName());
                String phone = newExcelStaff.getPhone();
                if (phone.contains("E")) {
                    int length = phone.length();
                    staff.setPhone(phone.substring(0, 1) + phone.substring(2, 12));
                } else {
                    staff.setPhone(phone);
                }
                staff.setImg(newExcelStaff.getImg());

                String password = newExcelStaff.getPassword();
                if (password.contains(".0")) {
                    staff.setPwd(password.substring(0, password.length() - 2));
                } else {
                    staff.setPwd(password);
                }
                staff.setSubScore(ConstantItem.ZERO);
                staff.setTotalScore(ConstantItem.ZERO);
                staff.setRanking(ConstantItem.ZERO);
                staff.setJoinRank(ConstantItem.ONE);
                staff.setAddScore(ConstantItem.ZERO);
                staff.setApprovalLogNum(ConstantItem.ZERO);
                staff.setBaseScore(ConstantItem.ZERO);
                staff.setCommendScore(ConstantItem.ZERO);
                staff.setCreateAt(System.currentTimeMillis());
                staff.setCreateBy(ConstantItem.ZERO_ID);
                staff.setDegreeId(ConstantItem.ZERO_ID);
                staff.setDegreeScore(ConstantItem.ZERO);
                staff.setDepartmentId(ConstantItem.MINUS_ID);
                staff.setDepartmentName(ConstantItem.DEPARTMENT_INI);
//                staff.setEntryAt(0L);
                staff.setHonorId(ConstantItem.ZERO_ID);
                staff.setHonorScore(ConstantItem.ZERO);
                staff.setIncumbency(ConstantItem.ZERO);
                staff.setIniScore(ConstantItem.ZERO);
                staff.setJopId(ConstantItem.ZERO_ID);
                staff.setJopScore(ConstantItem.ZERO);
                staff.setLoveScore(ConstantItem.ZERO);
                staff.setMyApprovalNum(ConstantItem.ZERO);
                staff.setMyCopyNum(ConstantItem.ZERO);
                staff.setPositionId(ConstantItem.ZERO_ID);
                staff.setPositionName(ConstantItem.POSITION_INI);
                staff.setPositionScore(ConstantItem.ZERO);

                staff.setRole(ConstantItem.ZERO);
                staff.setScoreSituation(ConstantItem.ZERO);
                staff.setSeniority(ConstantItem.ZERO);
                staff.setSeniorityScore(ConstantItem.ZERO);
                staff.setSpecialityId(ConstantItem.ZERO_ID);
                staff.setSpecialityScore(ConstantItem.ZERO);
                staff.setStar(ConstantItem.ZERO);
                staff.setStarId(ConstantItem.ZERO_ID);
                staff.setStarScore(ConstantItem.ZERO);
                staff.setSunScore(ConstantItem.ZERO);
                staff.setUpdateAt(System.currentTimeMillis());
                staff.setUpdateBy(ConstantItem.ZERO_ID);
                staff.setWaitApprovalNum(ConstantItem.ZERO);
                staffList.add(staff);
            }
            log.info("=============model list size>>" + list.size());
            staffService.insertList(staffList);
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get attendanceLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping("/qq")
    public String ddd() {
        return "test";
    }

}
