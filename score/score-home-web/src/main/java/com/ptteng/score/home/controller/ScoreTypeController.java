package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.responseStructure.ApplyScoreStructure;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DateUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ScoreType  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ScoreTypeController {
    private static final Log log = LogFactory.getLog(ScoreTypeController.class);
    @Autowired
    private StaffTaskRelationService staffTaskRelationService;
    @Autowired
    private EnterpriseApprovalService enterpriseApprovalService;
    @Autowired
    private CopyRelationService copyRelationService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ScoreTypeService scoreTypeService;


    /**
     * @param
     * @return
     */


    @RequestMapping(value = "/a/u/applyScoreInfo/{id}", method = RequestMethod.GET)
    public String updateScoreType(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Description:积分申报显示
         */
        try {
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get scoreType id :" + id);
            Map<String, Object> map = DynamicSQLUtil.searchScoreType(id);
            List<Long> idsByDynamicCondition = scoreTypeService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<ScoreType> objectsByIds = scoreTypeService.getObjectsByIds(idsByDynamicCondition);

            log.info("get result size: :" + objectsByIds.size());
            model.addAttribute("code", 0);
            model.addAttribute("dataList", objectsByIds);
            return "json/othersJsp/json/scoreTypeDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get applyScoreInfo error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


//    @RequestMapping(value = "/a/u/scoreApply", method = RequestMethod.POST)
//    public String ScoreApply(HttpServletResponse response, HttpServletRequest request, ModelMap model,
//                             @RequestBody ScoreType scoreType) {
//
//        log.info("get scoreType is: " + scoreType);
//        if (DataUtils.isNullOrEmpty(scoreType)) {
//                model.addAttribute("code", -1000);
//                return "common/fail";
//        }
//
//
//
//
//        return null;
//    }


    @RequestMapping(value = "/a/u/applyScore", method = RequestMethod.POST)
    public String updateScoreTypeDetail(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @RequestBody ApplyScoreStructure applyScoreStructure)
            throws Exception {

        /**
         *@Description:申报积分
         */
        Long taskId = applyScoreStructure.getTaskId();//任务id
        Integer scoreType = applyScoreStructure.getScoreType();//积分类型
        Long[] staffId = applyScoreStructure.getStaffId();//添加员工数组
        Long applyId = applyScoreStructure.getApplyId();//审报人id
        Long approvalId = applyScoreStructure.getApprovalId();//申批人id
        String content = applyScoreStructure.getContent();//申报详情
        String picture = applyScoreStructure.getPicture();//申报图片
        Integer score = applyScoreStructure.getScore();//申报积分
        Long[] copyId = applyScoreStructure.getCopyId();//抄送人id
        String title = applyScoreStructure.getTitle();//标题
        Integer project = applyScoreStructure.getProject();//可申请方式
        Long scoreId = applyScoreStructure.getScoreId();//可申请方式

        String s = Arrays.toString(staffId);
        String staffIdList = s.substring(1, s.length() - 1);
        Map<String, Object> paramm = null;

        try {
            log.info("param = taskId is: " + applyScoreStructure.getTaskId() + " scoreType is: " + applyScoreStructure.getScoreType() + " staffId is: " + applyScoreStructure.getStaffId() +
                    " approvalId is: " + applyScoreStructure.getApprovalId() + " content is: " + applyScoreStructure.getContent() + " picture is: " + applyScoreStructure.getPicture() + " score is: " +
                    applyScoreStructure.getScore() + " copyId is: " + applyScoreStructure.getCopyId() + " title is: " + applyScoreStructure.getTitle() + " scoreId is: " + scoreId);
            Task task = taskService.getObjectById(taskId);

            //条件判空
            if (scoreType == null) {
                scoreType = task.getTaskType();
            }
            if (score == null) {
                score = task.getTaskScore();
            }

            if (null == taskId) {

                /**
                 * 积分申报/申报减分/申报加分
                 */
                //判断审批人和员工是否相同
                List<Long> longList = Arrays.asList(staffId);
                List<Long> staffs = Arrays.asList(staffId);
                if (longList.contains(approvalId)) {
                    model.addAttribute("code", -166);
                    return "common/fail";
                }


                if (null != title) {
                    //处理scoreType关系

                    Long time = 0L;
                    if (null != project) {
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
                            case 4:
                                time = DateUtil.getQuarterByMonth(true);
                                break;
                            //无限制
                            case 5:
                                time = System.currentTimeMillis();
                                break;
                            //仅限一次
                            case 6:
                                time = 0L;
                                break;
                            default:
                        }


                        paramm = DynamicSQLUtil.getenterpriaeApproval(staffIdList, time, scoreId);
                        List<Long> enterpriseApprovalIds = enterpriseApprovalService.getIdsByDynamicCondition(EnterpriseApproval.class, paramm, 0, Integer.MAX_VALUE);
                        log.info("get enterpriseApprovalIds is: " + enterpriseApprovalIds);

                        List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);

                        for (EnterpriseApproval ea : enterpriseApprovalList) {

                            Long currentTime = System.currentTimeMillis();
                            if (staffs.contains(ea.getApplyId()) && (currentTime < (ea.getCreateAt() + time) || 6 == project)) {

                                model.addAttribute("code", -167);
                                return "common/fail";
//                                }
                            }

                        }


//                        if (enterpriseApprovalIds.size() != 0) {
//                            EnterpriseApproval enterpriseApproval = enterpriseApprovalService.getObjectById(enterpriseApprovalIds.get(0));
//                            log.info("最新记录的创建时间是： " + enterpriseApproval.getCreateAt());
//                            log.info("申请方式" + project + ": " + time);
//                            Long newTime = System.currentTimeMillis();
//                            log.info("当前时间是: " + newTime);
////                            if (newTime > (enterpriseApproval.getCreateAt() + time) && enterpriseApproval.getApprovalId() != approvalId.longValue()) {
//                            if (newTime > (enterpriseApproval.getCreateAt() + time) /*&& !staffIds.contains(enterpriseApproval.getApprovalId())*/) {
//
//                                log.info("恭喜你可以继续申请！");
//                            } else {
//                                model.addAttribute("code", -167);
//                                return "common/fail";
//                            }
//                        }
                    }
                }
                List<EnterpriseApproval> enterpriseApprovalList = new ArrayList<>();
                for (Long id : staffs) {
                    EnterpriseApproval enterpriseApproval = new EnterpriseApproval();
                    enterpriseApproval.setCreateBy(ConstantItem.ZEROL);
                    enterpriseApproval.setUpdateBy(ConstantItem.ZEROL);
                    enterpriseApproval.setStatus(ConstantItem.TWO);
                    enterpriseApproval.setScoreType(scoreType);
                    enterpriseApproval.setApplyId(id);
                    enterpriseApproval.setTaskId(taskId);
                    enterpriseApproval.setApprovalId(approvalId);
                    enterpriseApproval.setScore(score);
                    enterpriseApproval.setPicture(picture);
                    enterpriseApproval.setContent(content);
                    enterpriseApproval.setTitle(title);
                    enterpriseApproval.setScoreId(scoreId);
                    enterpriseApprovalList.add(enterpriseApproval);
                }


                //插入审批信息
                List<EnterpriseApproval> idList = enterpriseApprovalService.insertList(enterpriseApprovalList);
                //设置抄送人抄送数量
                if (null != copyId && copyId.length > ConstantItem.ZERO) {
                    List<Long> longs = Arrays.asList(copyId);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Long id : longs) {
                        stringBuilder.append(id + ",");
                    }
                    //将审批关系插入关系表
                    String string = stringBuilder.toString();
                    String substring = string.substring(ConstantItem.ZERO, string.length() - ConstantItem.ONE);
                    int num = 0;
                    List<CopyRelation> list = new ArrayList<>();
                    for (Long id : staffs) {
                        CopyRelation copyRelation = new CopyRelation();
                        copyRelation.setCopyId(substring);
                        copyRelation.setRecordId(idList.get(num).getId());
                        copyRelation.setCreateBy(ConstantItem.ZEROL);
                        copyRelation.setUpdateBy(ConstantItem.ZEROL);
                        list.add(copyRelation);
                        num++;
                    }
                    copyRelationService.insertList(list);
                }
            } else {
                /**
                 * 任务积分申报
                 */

                //更该任务状态为审批中
                Map<String, Object> param = DynamicSQLUtil.searchTaskRelation(applyId, taskId);
                List<Long> taskIds = staffTaskRelationService.getIdsByDynamicCondition(StaffTaskRelation.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
                List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(taskIds);

                if (ConstantItem.ZERO < taskRelations.size()) {
                    StaffTaskRelation staffTaskRelation = taskRelations.get(ConstantItem.ZERO);
                    staffTaskRelation.setAttendanceType(ConstantItem.THREE);
                    staffTaskRelationService.update(staffTaskRelation);
                } else {
                    model.addAttribute("code", -1000);
                    return "common/fail";
                }

                //添加审批记录
                EnterpriseApproval enterpriseApproval = new EnterpriseApproval();
                enterpriseApproval.setCreateBy(ConstantItem.ZEROL);
                enterpriseApproval.setUpdateBy(ConstantItem.ZEROL);
                enterpriseApproval.setStatus(ConstantItem.TWO);
                enterpriseApproval.setScoreType(scoreType);
                enterpriseApproval.setApplyId(applyId);
                enterpriseApproval.setTaskId(taskId);
                enterpriseApproval.setApprovalId(approvalId);
                enterpriseApproval.setScore(score);
                enterpriseApproval.setTitle(title);
                enterpriseApproval.setPicture(picture);
                enterpriseApproval.setContent(content);
                enterpriseApproval.setScoreId(scoreId);

                //插入审批信息
                Long idInsert = enterpriseApprovalService.insert(enterpriseApproval);
                //设置抄送人抄送数量
                if (null != copyId && copyId.length > ConstantItem.ZERO) {
                    List<Long> longs = Arrays.asList(copyId);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Long id : longs) {
                        stringBuilder.append(id + ",");
                    }
                    //将审批关系插入关系表
                    String string = stringBuilder.toString();
                    String substring = string.substring(ConstantItem.ZERO, string.length() - ConstantItem.ONE);
                    //插入关系表
                    List<CopyRelation> list = new ArrayList<>();
                    CopyRelation copyRelation = new CopyRelation();
                    copyRelation.setCopyId(substring);
                    copyRelation.setRecordId(idInsert);
                    copyRelation.setCreateBy(ConstantItem.ZEROL);
                    copyRelation.setUpdateBy(ConstantItem.ZEROL);
                    list.add(copyRelation);
                    copyRelationService.insertList(list);
                }
            }


            model.addAttribute("code", 0);
            return "/data/json";
        } catch (
                Exception e)

        {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("applyScore error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


}

