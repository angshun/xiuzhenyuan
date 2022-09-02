package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.responseStructure.ResponseInfo;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DateUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * Task  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class TaskController {
    private static final Log log = LogFactory.getLog(TaskController.class);
    @Autowired
    private CopyRelationService copyRelationService;

    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private StaffTaskRelationService staffTaskRelationService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private EnterpriseApprovalService enterpriseApprovalService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreLogService scoreLogService;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/a/u/mytask/{id}", method = RequestMethod.GET)
    public String getTaskList(HttpServletRequest request,
                              HttpServletResponse response, @PathVariable Long id, ModelMap model, Integer taskType) throws Exception {
        /**
         *@Description:查询我的任务
         */
        log.info("id:" + id + "taskType" + taskType);
        if (null == id || null == taskType) {
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        List<StaffTaskRelation> staffTaskRelations;
        List<Task> tasks;
        try {
            //拼装动态查询
            Map<String, Object> map = DynamicSQLUtil.searchMyTask(id, taskType);
            List<Long> count = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("count size:" + count);
            staffTaskRelations = staffTaskRelationService.getObjectsByIds(count);
            log.info("get staffTaskRelations is: " + staffTaskRelations);

            List<Long> longs = new ArrayList<>();
            //获取任务id
            for (StaffTaskRelation staffTaskRelation : staffTaskRelations) {
                longs.add(staffTaskRelation.getTaskId());
            }
            tasks = taskService.getObjectsByIds(longs);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 1");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        //组装出参
        List<Task> list = new ArrayList<>();
        for (StaffTaskRelation staffTaskRelation : staffTaskRelations) {
            for (Task task : tasks) {
                if (staffTaskRelation.getTaskId() == task.getId().longValue()) {
                    task.setTaskStatus(staffTaskRelation.getAttendanceType());
                    list.add(task);
                }
            }
        }
        ResponseInfo taskList = new ResponseInfo(tasks);
        //返回出参
        model.addAttribute("objectsByIds1", taskList);
        return "json/task/json/newJsp";
    }

    @RequestMapping(value = "/a/u/task/{id}", method = RequestMethod.GET)
    public String getAllTaskList(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Integer id) throws Exception {
        /**
         *@Description:悬赏任务
         */
        log.info("id:" + id);
        if (null == id) {
            model.addAttribute("code", ConstantItem.ONE_THOUSAND);
            return "common/fail";
        }
        Set<Task> set = new HashSet<>();
        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            Staff staff = staffService.getObjectById(adminId);
//            if (null == staff) {
//                model.addAttribute("code", ConstantItem.ONE_THOUSAND);
//                return "common/fail";
//            }
            //所有的该类型的任务,选择可见任务
            Map<String, Object> map1 = DynamicSQLUtil.searchOnlyTask(id, staff.getDepartmentId());
            List<Long> count = taskService.getIdsByDynamicCondition(Task.class, map1, 0, Integer.MAX_VALUE);
            List<Task> tasks = taskService.getObjectsByIds(count);
            //查询我参加的任务
            Map<String, Object> map = DynamicSQLUtil.searchThisisMyTask(adminId, id);
            List<Long> idsByDynamicCondition = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> staffTaskRelationList = staffTaskRelationService.getObjectsByIds(idsByDynamicCondition);
            //获取我参加的任务
            List<Long> longs = new ArrayList<>();
            for (StaffTaskRelation staffTaskRelation : staffTaskRelationList) {
                longs.add(staffTaskRelation.getTaskId());
            }
            log.info("get list size:" + longs.size());
            //获取我参加的任务实体
            List<Task> taskList = taskService.getObjectsByIds(longs);
            for (Task task : taskList) {
                for (StaffTaskRelation staffTaskRelation : staffTaskRelationList) {
                    if (task.getId() == staffTaskRelation.getTaskId().longValue()) {
                        task.setTaskStatus(staffTaskRelation.getAttendanceType());
                        task.setApproveStatus(staffTaskRelation.getApproveStatus());
                    }
                }
            }
            log.info("get task size:" + taskList.size());
            set.addAll(taskList);
            set.addAll(tasks);
        } catch (Exception t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 2");
            log.info("导出异常！         " + t.getMessage());
            log.error(printStackTraceToString(t));

            model.addAttribute("code", -100000);
            return "common/fail";
        }
        List<Task> list = new ArrayList<>();
        list.addAll(set);
        //冒泡排序
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                Task task = list.get(i);
                Task task1 = list.get(j);
                long createAt1 = task.getCreateAt();
                long createAt2 = task1.getCreateAt();
                if (createAt1 < createAt2) {
                    list.set(i, task1);
                    list.set(j, task);
                }
            }
        }

        model.addAttribute("code", ConstantItem.ZERO);
        model.addAttribute("objectsByIds1", new ResponseInfo(list));
        return "json/task/json/newJsp";
    }

    private String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }

    @RequestMapping(value = "/a/u/task", method = RequestMethod.POST)
    public String addTask(HttpServletRequest request,
                          HttpServletResponse response, ModelMap model,
                          String title, String content, Integer taskScore, Integer number, Integer scoreType, int[] visualDepartment, Long createBy)
            throws Exception {
        /**
         *@Description:新增任务
         */

        try {
            log.info("title:" + title + "content:" + content + "taskScore:" + taskScore);
            //判断任务类型
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));

            log.info("get adminId is: " + adminId);
            Staff staff = staffService.getObjectById(adminId);
            //判断是否是管理员
            if (ConstantItem.ONE != staff.getRole()) {
                model.addAttribute("code", -105);
                return "common/fail";
            }
            log.info("get CommendScore is: " + staff.getCommendScore());
            if ((taskScore * number) > staff.getCommendScore()) {
                log.info("表扬积分不足！");
                model.addAttribute("code", -9000);
                return "common/fail";
            }
            log.info("comm");

            //减去发布任务积分
            staff.setCommendScore(staff.getCommendScore() - taskScore * number);
            //拼装任务实体
            Task taskJson = new Task();
            taskJson.setTitle(title);
            taskJson.setContent(content);
            taskJson.setTaskScore(taskScore);
            taskJson.setNumber(number);
            taskJson.setScoreType(scoreType);
            StringBuilder stringBuilder = new StringBuilder();

            if (null == visualDepartment || ConstantItem.ZERO == visualDepartment.length) {
                List<Long> departmentIds = departmentService.getDepartmentIds(0, Integer.MAX_VALUE);
                for (Long i : departmentIds) {
                    stringBuilder.append(i);
                    stringBuilder.append(",");
                }
            } else {
                //设置可见部门
                for (int i : visualDepartment) {
                    stringBuilder.append(i);
                    stringBuilder.append(",");
                }
            }

            String str = stringBuilder.toString();
            String substring = str.substring(ConstantItem.ZERO, str.length() - ConstantItem.ONE);
            taskJson.setVisualDepartment(substring);
            taskJson.setCreateBy(createBy);
            //拼装其他属性
            taskJson.setId(ConstantItem.ZEROL);
            taskJson.setCreateBy(adminId);
            taskJson.setUpdateBy(adminId);
            taskJson.setJoinNum(ConstantItem.ZERO);
            taskJson.setStatus(ConstantItem.ONE);
            taskJson.setApproveStatus(ConstantItem.ZERO);
            taskJson.setTaskType(ConstantItem.ONE);
            taskJson.setTaskStatus(ConstantItem.ZERO);
            taskJson.setTimes(ConstantItem.ZERO);
            taskJson.setProject(0);
            //只允许添加抢单任务
            if (ConstantItem.ONE == taskJson.getTaskType()) {
                taskJson.setStartAt(null);
                taskJson.setEndAt(null);
            } else {
                model.addAttribute("code", ConstantItem.ONE_HUNDRED_THOUSAND);
                return "common/fail";
            }
            log.info("get task list size:" + taskJson.getName());
            log.info("参数：task=" + taskJson.getId() + taskJson.getTitle());
            //插入数据库
            Long id = taskService.insert(taskJson);
            log.info("add task id: " + id);

            boolean result = staffService.update(staff);
            log.info("update staffId: " + staff.getId() + " result is: " + result);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add TaskList error ");
            model.addAttribute("code", ConstantItem.ONE_HUNDRED_THOUSAND);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/joinTask", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String joinTask(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model,
                           Long staffId, Long taskId)
            throws Exception {
        /**

         *@Description:参加任务
         */
        try {
            log.info("staffId:" + staffId + "taskId:" + taskId);
            //参数判空
            if (null == taskId || null == staffId) {
                model.addAttribute("code", ConstantItem.ONE_THOUSAND);
                return "common/fail";
            }
            Task task = taskService.getObjectById(taskId);
            Integer project = task.getProject();
            Long time = 0L;
            if (null == project && 5 != project && 6 != project) {
                switch (project) {
                    case 0:
                        time = DateUtil.timeUtil(0);
                        break;
                    case 1:
                        time = DateUtil.timeUtil(7);
                        break;
                    case 2:
                        time = DateUtil.getCurrentMonthLastDay();
                        break;
                    case 3:
                        time = DateUtil.getQuarterByMonth(false);
                        break;
                    case 5:
                        time = System.currentTimeMillis();
                        break;
                    case 4:
                        time = DateUtil.getQuarterByMonth(true);
                        break;
                        default:
                }




                Map<String, Object> map = DynamicSQLUtil.searchSingleScoreLogInTime(staffId, taskId, time);
                List<Long> ids = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
                if (ConstantItem.ZERO < ids.size()) {
                    model.addAttribute("code", -167);
                    return "common/fail";
                }



            }
            if (null != project && 6 == project) {
                Map<String, Object> map = DynamicSQLUtil.searchSingleScoreLogInTime(staffId, taskId, 0L);
                List<Long> ids = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, 0, Integer.MAX_VALUE);
                if (ConstantItem.ZERO < ids.size()) {
                    model.addAttribute("code", -167);
                    return "common/fail";
                }
            }
            //插入员工任务关系实体
            StaffTaskRelation staffTaskRelation = new StaffTaskRelation();
            staffTaskRelation.setTaskId(taskId);
            staffTaskRelation.setStaffId(staffId);
            staffTaskRelation.setTaskType(task.getTaskType());
            staffTaskRelation.setAttendanceType(ConstantItem.ONE);
            staffTaskRelation.setApproveStatus(ConstantItem.ZERO);
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            staffTaskRelation.setCreateBy(adminId);
            staffTaskRelation.setUpdateBy(adminId);
            //设置加入人数
            if (ConstantItem.ZERO != task.getTaskType()) {
                if (task.getJoinNum() == null || task.getJoinNum() >= task.getNumber().longValue()) {
                    model.addAttribute("code", ConstantItem.MAX_PEOPLE);
                    return "common/fail";
                } else {
                    task.setJoinNum(task.getJoinNum() == null ? ConstantItem.ZERO : task.getJoinNum() + ConstantItem.ONE);
                    taskService.update(task);
                }
            }
            Long id = staffTaskRelationService.insert(staffTaskRelation);
            log.info("add staffTaskRelation id is: " + id);

            model.addAttribute("code", ConstantItem.ZERO);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add TaskList error ");
            model.addAttribute("code", ConstantItem.ONE_HUNDRED_THOUSAND);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/applyTaskScore", method = RequestMethod.POST)
    public String updateScoreTypeDetail(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, Long applyId, Long taskId, String content, String img, Long approvalId, Long[] copyId)
            throws Exception {
        /**
         *@Description:任务完成，申报积分
         */
        try {
            log.info("applyId:" + applyId + "taskId:" + approvalId);
            if (null == applyId || null == approvalId) {
                model.addAttribute("code", ConstantItem.ONE_THOUSAND);
                return "common/fail";
            }
            //查询是否已经申报该积分
            Map<String, Object> searcppproval = DynamicSQLUtil.searcppproval(taskId, applyId);
            List<Long> count = enterpriseApprovalService.getIdsByDynamicCondition(EnterpriseApproval.class, searcppproval, ConstantItem.ZERO, Integer.MAX_VALUE);
            //若已经申报过了
            if (null == count || ConstantItem.ZERO == count.size()) {
                model.addAttribute("code", ConstantItem.HAS_BEEN_APPROVED);
                return "common/fail";
            }
            //组装申报记录实体
            Task task = taskService.getObjectById(taskId);
            EnterpriseApproval enterpriseApproval = new EnterpriseApproval();
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            enterpriseApproval.setCreateBy(adminId);
            enterpriseApproval.setUpdateBy(adminId);
            enterpriseApproval.setStatus(ConstantItem.ZERO);
            enterpriseApproval.setScoreType(ConstantItem.SERVEN);
            enterpriseApproval.setApplyId(applyId);
            enterpriseApproval.setApprovalId(approvalId);
            enterpriseApproval.setScore(task.getTaskScore());
            enterpriseApproval.setPicture(img);
            enterpriseApproval.setTitle(task.getTitle());
            enterpriseApproval.setContent(content);
            //更新员工任务关系表状态
            Map<String, Object> map = DynamicSQLUtil.searType(taskId, applyId);
            List<Long> count1 = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            StaffTaskRelation staffTaskRelation = staffTaskRelationService.getObjectById(count1.get(ConstantItem.ZERO));
            staffTaskRelation.setAttendanceType(ConstantItem.TWO);
            staffTaskRelation.setApproveStatus(ConstantItem.ONE);


            boolean result = staffTaskRelationService.update(staffTaskRelation);
            log.info("update staffTaskRelation id: " + staffTaskRelation.getId() + " result is: " + result);
            //插入审批记录
            Long insert = enterpriseApprovalService.insert(enterpriseApproval);
            //设置抄送关系
            if (null != copyId && copyId.length > ConstantItem.ZERO) {
                List<Long> longs = Arrays.asList(copyId);
                //组装抄送人实体
                StringBuilder stringBuilder = new StringBuilder();
                for (Long id : longs) {
                    stringBuilder.append(id + ",");
                }
                String string = stringBuilder.toString();
                String substring = string.substring(ConstantItem.ZERO, string.length() - ConstantItem.ONE);
                CopyRelation copyRelation = new CopyRelation();
                copyRelation.setCopyId(substring);
                copyRelation.setRecordId(insert);
                copyRelation.setCreateBy(adminId);
                copyRelation.setUpdateBy(adminId);
                //插入抄送关系实体
                Long id = copyRelationService.insert(copyRelation);
                log.info("add copyRelation id: " + id);
            } else {
                model.addAttribute("code", ConstantItem.NO_COPY);
                return "common/fail";
            }
            model.addAttribute("code", ConstantItem.ZERO);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", ConstantItem.ONE_HUNDRED_THOUSAND);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/getMyScore", method = RequestMethod.GET)
    public String geb(HttpServletRequest request,
                      HttpServletResponse response, ModelMap model, Long id) throws Exception {
        /**
         *@Description:可用积分
         */
        try {
            //入参判空
            if (null == id) {
                model.addAttribute("code", ConstantItem.ONE_THOUSAND);
                return "common/fail";
            }
            //组装hashmap
            Staff staff = staffService.getObjectById(id);
            log.info("get staff object:" + staff);
            model.addAttribute("code", ConstantItem.ZERO);
            model.addAttribute("staff", staff);
            return "json/othersJsp/json/MyScore";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 3");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
}



