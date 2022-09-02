package com.ptteng.score.home.controller;

import com.gemantic.common.util.MyListUtil;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
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
import java.util.*;

/**
 * EnterpriseApproval  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class EnterpriseApprovalController {
    private static final Log log = LogFactory.getLog(EnterpriseApprovalController.class);
    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private EnterpriseApprovalService enterpriseApprovalService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private CopyRelationService copyRelationService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StaffTaskRelationService staffTaskRelationService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/attendanceManage/{id}", method = RequestMethod.GET)
    public String getEnterpriseApprovalList(HttpServletRequest request,
                                            HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:我的审批日志
         *@Date: 16:17 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param name
         * @param account
         * @param departmentId
         * @param positionId
         * @param status
         * @param startAt
         * @param endAt
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        List<Map> mapList = new ArrayList<>();
        try {
            Map<String, Object> map = DynamicSQLUtil.searchEnterpriseApproval(id);
            List<Long> count = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);

            log.info("get enterpriseApprovalService size :" + count.size());
            //查询我的审批记录
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(count);

            //取出申请人id
            List<Long> longs = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                set.add(enterpriseApproval.getApplyId());
            }
            longs.addAll(set);

            log.info("get idList size:" + longs.size());
            //两层for循环匹配审批信息和申请人信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);

            Map<Long, String> staff_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> staff_img = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("img"), staffList);

            model.addAttribute("code", 0);
            model.addAttribute("enterpriseApprovalList", enterpriseApprovalList);
            model.addAttribute("staff_alias", staff_alias);
            model.addAttribute("staff_img", staff_img);
            log.info(count.size());
            log.info("get entryList size:" + mapList.size());
            return "json/enterpriseApproval/json/enterpriseApprovalListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -10000);
            return "common/fail";

        }
    }


    @RequestMapping(value = "/a/u/my/approval/{id}", method = RequestMethod.GET)
    public String getWaitApprovalList(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:待我审批列表
         *@Date: 16:17 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param name
         * @param account
         * @param departmentId
         * @param positionId
         * @param status
         * @param startAt
         * @param endAt
         */

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            Map<String, Object> map = DynamicSQLUtil.searchWaitEnterpriseApproval(id);
            List<Long> count = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);

            //查询积分类型实体
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(count);
            log.info("get enterpriseApprovalList size is: " + enterpriseApprovalList);
            //取出申请人id
            List<Long> longs = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                set.add(enterpriseApproval.getApplyId());
            }
            longs.addAll(set);
            //两层for循环匹配审批信息和申请人信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);

            log.info("get staffList.size is: " + staffList.size());
            Map<Long, String> staff_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> staff_img = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("img"), staffList);


            model.addAttribute("code", 0);
            model.addAttribute("staff_alias", staff_alias);
            model.addAttribute("staff_img", staff_img);
            model.addAttribute("enterpriseApprovalList", enterpriseApprovalList);
            return "json/enterpriseApproval/json/enterpriseApprovalListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/approval/{id}", method = RequestMethod.GET)
    public String getEnterpriseApproval(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:查询单个审批日志详情
         *@Date: 16:40 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param id
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            EnterpriseApproval enterpriseApproval = enterpriseApprovalService.getObjectById(id);
            if (null == enterpriseApproval) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Staff staff = staffService.getObjectById(enterpriseApproval.getApplyId());
            Map<String, Object> map1 = new HashMap<>();
            map1.put("enterpriseApproval", enterpriseApproval);
            map1.put("staff", staff);

            log.info("get map1 is: " + map1);
            model.addAttribute("code", 0);
            model.addAttribute("enterpriseApproval", map1);
            return "json/enterpriseApproval/json/enterpriseApprovalListJsons";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

    }

    @RequestMapping(value = "/a/u/my/approval", method = RequestMethod.PUT)
    public String changeEnterpriseStatus(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model, Long id, Integer status)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:是否审批通过
         *@Date: 16:40 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param id
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            EnterpriseApproval enterpriseApproval = enterpriseApprovalService.getObjectById(id);
            if (null == enterpriseApproval) {
                log.info("get id is null！");
                model.addAttribute("code", -100000);
                return "common/fail";
            }

            //审批通过
            if (status == ConstantItem.ONE) {
                //更改状态为通过
                enterpriseApproval.setStatus(ConstantItem.ONE);
                boolean result = enterpriseApprovalService.update(enterpriseApproval);
                //为员工加分/减分
                Staff objectById2 = staffService.getObjectById(enterpriseApproval.getApplyId());
                objectById2.setAddScore(objectById2.getAddScore() + enterpriseApproval.getScore());
                objectById2.setTotalScore(objectById2.getTotalScore() + enterpriseApproval.getScore());
                staffService.update(objectById2);
                //记录积分日志
                ScoreLog scoreLog = new ScoreLog();
                scoreLog.setSpecialId(id);
                scoreLog.setStaffId(enterpriseApproval.getApplyId());
                scoreLog.setScoreChange(enterpriseApproval.getScore().toString());
                scoreLog.setScoreReason(enterpriseApproval.getTitle());
                scoreLog.setScoreType(enterpriseApproval.getScoreType());
                scoreLogService.insert(scoreLog);
                if (null != enterpriseApproval.getTaskId()) {
                    //记录任务完成次数
                    Task task = taskService.getObjectById(enterpriseApproval.getTaskId());
                    task.setTimes(null == task.getTimes() ? 1 : task.getTimes() + 1);
                    boolean resultt = taskService.update(task);

                    //更新员工任务关系
                    Map<String, Object> map = DynamicSQLUtil.searchTaskInTime(enterpriseApproval.getApplyId(), enterpriseApproval.getTaskId());
                    List<Long> idsByDynamicCondition = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, 0, Integer.MAX_VALUE);
                    List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(idsByDynamicCondition);
                    StaffTaskRelation staffTaskRelation = taskRelations.get(0);
                    staffTaskRelation.setAttendanceType(2);
                    boolean resultttt = staffTaskRelationService.update(staffTaskRelation);
                    log.info("update staffTaskRelationId is: "+staffTaskRelation.getId()+" resultttt is: "+resultttt);



                    //即时刷新不限制任务
                    if (5 == task.getProject()) {
                        boolean resulttt = staffTaskRelationService.delete(staffTaskRelation.getId());
                        log.info("update staffTaskRelationId is: " + staffTaskRelation.getId() + " resulttt is: " + resulttt);

                    }
                    log.info("update taksId: " + task.getId() + " resultt is: " + resultt);
                }

            } else if (status == ConstantItem.ZERO) {
                //审批积分审核
                if (DataUtils.isNullOrEmpty(enterpriseApproval.getTaskId())) {
                    enterpriseApproval.setStatus(ConstantItem.ZERO);
                    boolean relust = enterpriseApprovalService.update(enterpriseApproval);
                    log.info("update enterpriseApprovalId is: "+enterpriseApproval.getId()+" relust is: "+relust);
                } else {
                    //审批任务审核
                    enterpriseApproval.setStatus(ConstantItem.ZERO);
                    //修改拒绝后状态未更新bug添加内容
                    boolean relust =  enterpriseApprovalService.update(enterpriseApproval);
                    log.info("update enterpriseApprovalId is: "+enterpriseApproval.getId()+" result is: "+relust);
                    //更新员工任务关系
                    Map<String, Object> map = DynamicSQLUtil.searchTaskInTime(enterpriseApproval.getApplyId(), enterpriseApproval.getTaskId());
                    List<Long> idsByDynamicCondition = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, 0, Integer.MAX_VALUE);
                    List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(idsByDynamicCondition);
                    StaffTaskRelation staffTaskRelation = taskRelations.get(0);
                    staffTaskRelation.setAttendanceType(2);
                    boolean resultt = staffTaskRelationService.update(staffTaskRelation);
                    log.info("update staffTaskRelationId is: "+staffTaskRelation.getId()+" resultt is: "+resultt);


                    //即时刷新不限制任务
                    Task task = taskService.getObjectById(enterpriseApproval.getTaskId());
                    if (5 == task.getProject()) {
                        staffTaskRelationService.delete(staffTaskRelation.getId());
                    }

                }


            } else {
                log.error("get status invalid");
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/my/beapproval/{id}", method = RequestMethod.GET/*, produces = "application/json; charset=utf-8"*/)
    public String getMyApprovalList(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:我发起的审批列表
         *@Date: 16:17 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param name
         * @param account
         * @param departmentId
         * @param positionId
         * @param status
         * @param startAt
         * @param endAt
         */
        List<Map> mapList = new ArrayList<>();

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            log.info("入参：" + "id" + id);
            Map<String, Object> map = DynamicSQLUtil.searchMyEnterpriseApproval(id);
            List<Long> idsByDynamicCondition = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map, 0, Integer.MAX_VALUE);

            //查询积分类型实体
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(idsByDynamicCondition);
            //取出申请人id
            List<Long> longs = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                set.add(enterpriseApproval.getApplyId());
            }
            log.info("get enterpriseApprovalList.size is: " + enterpriseApprovalList.size());
            longs.addAll(set);
            //两层for循环匹配审批信息和申请人信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);
            log.info("get staffList.size is: " + staffList.size());
            Map<Long, String> staff_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> staff_img = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("img"), staffList);


            model.addAttribute("code", 0);
            model.addAttribute("staff_alias", staff_alias);
            model.addAttribute("staff_img", staff_img);
            model.addAttribute("enterpriseApprovalList", enterpriseApprovalList);

            return "json/enterpriseApproval/json/enterpriseApprovalListJson";


        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/my/copy/{id}", method = RequestMethod.GET)
    public String getCopyMyApprovalList(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:抄送我的列表
         *@Date: 16:17 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param name
         * @param account
         * @param departmentId
         * @param positionId
         * @param status
         * @param startAt
         * @param endAt
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            log.info("入参：" + "id" + id);

            Map<String, Object> map = DynamicSQLUtil.searchCopyEnterpriseApproval(id);
            List<Long> count = copyRelationService.getIdsByDynamicCondition(ScoreType.class, map, 0, Integer.MAX_VALUE);
            List<CopyRelation> copyRelationList = copyRelationService.getObjectsByIds(count);
            List<Long> longs = new ArrayList<>();
            for (CopyRelation copyRelation : copyRelationList) {
                longs.add(copyRelation.getRecordId());
            }
            //查询积分类型实体
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(longs);
            log.info("get enterpriseApprovalList.size is: " + enterpriseApprovalList);
            //取出申请人id
            List<Long> longs1 = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                set.add(enterpriseApproval.getApplyId());
            }
            longs1.addAll(set);
            //两层for循环匹配审批信息和申请人信息
            List<Staff> staffList = staffService.getObjectsByIds(longs1);
            log.info("get staff.size is: " + staffList.size());

            Map<Long, String> staff_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> staff_img = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("img"), staffList);


            model.addAttribute("code", 0);
            model.addAttribute("staff_alias", staff_alias);
            model.addAttribute("staff_img", staff_img);
            model.addAttribute("enterpriseApprovalList", enterpriseApprovalList);
            return "json/enterpriseApproval/json/enterpriseApprovalListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }
}

