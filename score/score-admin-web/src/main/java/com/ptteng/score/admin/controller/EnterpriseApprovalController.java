package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.*;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.*;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
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
import java.util.stream.Collectors;

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
    private EnterpriseApprovalService enterpriseApprovalService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private StaffTaskRelationService staffTaskRelationService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/attendanceManage", method = RequestMethod.GET)
    public String getEnterpriseApprovalList(HttpServletRequest request,
                                            HttpServletResponse response, ModelMap model, Integer page, Integer size, String name, Long account, Long departmentId, Long positionId,
                                            Long status, Long startAt, Long endAt, Integer scoreType) throws Exception {
        /**
         *@Description:查询企业审批列表
         */
        try {
            log.info("入参：" + "name" + name + "departmentId" + departmentId + "positionId" + positionId + "account" + account + "status" + status + "startAt" + startAt + "endAt" + endAt);
            Map<String, Object> map = DynamicSQLUtil.searchEnterpriseApproval(name, account, departmentId, positionId, status, startAt, endAt, scoreType);
            List<Long> count = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is: " + count.size());
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询积分类型实体
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(pageList);
            log.info("get enterpriseApprovaList.size is: " + enterpriseApprovalList.size());

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
            List entryList = new ArrayList();
            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == enterpriseApproval.getApplyId().longValue()) {
                        List<Object> list = new ArrayList<>();
                        list.add(staff);
                        list.add(enterpriseApproval);
                        entryList.add(list);
                    }
                }
            }
            log.info("result size" + entryList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("list", entryList);
            return "json/enterpriseApproval/json/enterpriseApprovalListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/attendanceManage/{id}", method = RequestMethod.GET)
    public String getEnterpriseApproval(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Description:查询单个审批日志详情
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {
            //查询日志和员工对象
            EnterpriseApproval enterpriseApproval = enterpriseApprovalService.getObjectById(id);
            log.info("get enterpriseApproval id is: " + enterpriseApproval);
            if (DataUtils.isNullOrEmpty(enterpriseApproval.getApplyId())) {
                log.info("get applyId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Staff staff = staffService.getObjectById(enterpriseApproval.getApplyId());
            if (DataUtils.isNullOrEmpty(staff)) {
                log.info("get staff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staff id is: " + staff.getId());
            List list = new ArrayList();
            list.add(staff);
            list.add(enterpriseApproval);
            model.addAttribute("code", 0);
            model.addAttribute("entry", list);
            return "json/enterpriseApproval/json/enterpriseApprovalDetailJson";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/attendanceManage/status", method = RequestMethod.PUT)
    public String changeEnterpriseStatus(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model, Long id, Integer status)
            throws Exception {
        /**
         *@Description:是否审批通过
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        if (DataUtils.isNullOrEmpty(status)) {
            log.info("get status is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        try {
            EnterpriseApproval enterpriseApproval = enterpriseApprovalService.getObjectById(id);
            if (null == enterpriseApproval) {
                log.info("get id is null！");
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            //审批通过
            if (status == 1) {
                //更改状态为通过

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
                    taskService.update(task);
                    //更新员工任务关系
                    Map<String, Object> map = DynamicSQLUtil.searchTaskInTime(enterpriseApproval.getApplyId(), enterpriseApproval.getTaskId());
                    List<Long> idsByDynamicCondition = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, 0, Integer.MAX_VALUE);
                    List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(idsByDynamicCondition);
                    StaffTaskRelation staffTaskRelation = taskRelations.get(0);
                    staffTaskRelation.setAttendanceType(2);
                    staffTaskRelationService.update(staffTaskRelation);

                    enterpriseApproval.setStatus(1);
                    enterpriseApprovalService.update(enterpriseApproval);

                    //即时刷新不限制任务
                    Task task1 = taskService.getObjectById(enterpriseApproval.getTaskId());
                    if (5 == task1.getProject()) {
                        staffTaskRelationService.delete(staffTaskRelation.getId());
                    }
                } else {
                    enterpriseApproval.setStatus(ConstantItem.ONE);
                    boolean result = enterpriseApprovalService.update(enterpriseApproval);
                    log.info("update enterpriseApprovalId :" + enterpriseApproval.getId() + " result is: " + result);
                }



            } else if (status == ConstantItem.ZERO) {

                //积分审批审核
                if (DataUtils.isNullOrEmpty(enterpriseApproval.getTaskId())) {
                    enterpriseApproval.setStatus(ConstantItem.ZERO);
                    enterpriseApprovalService.update(enterpriseApproval);
                } else {
                    //任务审批审核
                    //修改拒绝后状态未更新bug添加内容
                    enterpriseApproval.setStatus(ConstantItem.ZERO);
                    enterpriseApprovalService.update(enterpriseApproval);
                    //更新员工任务关系
                    Map<String, Object> map = DynamicSQLUtil.searchTaskInTime(enterpriseApproval.getApplyId(), enterpriseApproval.getTaskId());
                    List<Long> idsByDynamicCondition = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, map, 0, Integer.MAX_VALUE);
                    List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(idsByDynamicCondition);
                    StaffTaskRelation staffTaskRelation = taskRelations.get(0);
                    staffTaskRelation.setAttendanceType(2);
                    staffTaskRelationService.update(staffTaskRelation);
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

    @ControllerAnnotation("013")
    @RequestMapping(value = "/a/u/attendanceManage/status", method = RequestMethod.DELETE)
    public String deleteeGoodsJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除审核
         */

        if (id != null && id.length == 0) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }


        log.info("get id is: " + id);
        try {
            //数组转为list
            List<Long> list = Arrays.asList(id);
            enterpriseApprovalService.deleteList(EnterpriseApproval.class, list);
            log.info("delete goods : id= " + list.size());
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }
}

