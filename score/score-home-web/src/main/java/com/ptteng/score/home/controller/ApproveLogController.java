package com.ptteng.score.home.controller;


import com.gemantic.common.util.MyMapUtil;
import com.google.gson.reflect.TypeToken;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.ptteng.score.home.util.GsonUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.collections.CollectionUtils;
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
import java.lang.reflect.Type;
import java.util.*;

/**
 * ApproveLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ApproveLogController {
    private static final Log log = LogFactory.getLog(ApproveLogController.class);

    @Autowired
    private ApproveLogService approveLogService;


    @Autowired
    private StaffService staffService;
    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @Autowired
    private ScoreLogService scoreLogService;

    @Autowired
    private EnterpriseLogService enterpriseLogService;

    @Autowired
    private CookieUtil cookieUtil;



    /**
     * 1.点赞
     *
     * @param request
     * @param response
     * @param model
     * @param approveLog
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/approve", method = RequestMethod.POST)
    public String addApproveLogJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @RequestBody ApproveLog approveLog) throws Exception {


        log.info("get approveLog is: " + approveLog);
        if (DataUtils.isNullOrEmpty(approveLog)) {
            log.info("get approveLog is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        DailyAttendance dailyAttendance = null;
        Staff staff = null;
        ScoreLog scoreLog = new ScoreLog();
        Staff user = null;
        Long scoreLogId = null;
        EnterpriseLog enterpriseLog = null;
        Long approveLogId = null;

        Map<String, Object> param = null;

        List<Long> longList = null;
        if (DataUtils.isNullOrEmpty(approveLog.getStaffId())) {
            log.info("get staffId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get staffId is: " + approveLog.getStaffId());

        approveLog.setCreateBy(approveLog.getStaffId());
        approveLog.setUpdateBy(approveLog.getStaffId());


        if (DataUtils.isNullOrEmpty(approveLog.getType())) {
            log.info("get type is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(approveLog.getPraiseId())) {
            log.info("get praiseId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get praiseId is: " + approveLog.getPraiseId());
        log.info("get type is: " + approveLog.getType());
        log.info("get approveLogId is: " + approveLog.getLogId());
        try {
            dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.LOVE_PRAISE);
            log.info("get dailyattendance is: " + dailyAttendance.getId());
            user = staffService.getObjectById(approveLog.getStaffId());
            log.info("get user is: " + user.getId());


            //判断点赞类型0日志1人
            if (ConstantItem.PRAISE_LOG == approveLog.getType()) {
                if (DataUtils.isNullOrEmpty(approveLog.getLogId())) {
                    log.info("get approveLogId is null！");
                    model.addAttribute("code", -1000);
                    return "common/fail";
                }
                enterpriseLog = enterpriseLogService.getObjectById(approveLog.getLogId());
                if (user.getId().longValue() == enterpriseLog.getStaffId()) {
                    model.addAttribute("code", -9005);
                    return "common/fail";
                }
                param = DynamicSQLUtil.getEnterpriseApproveList(approveLog.getStaffId(), approveLog.getLogId(), approveLog.getType());
                longList = approveLogService.getIdsByDynamicCondition(ApproveLog.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
                log.info("get longList is：" + longList);
                if (longList.size() >= ConstantItem.ONE) {
                    model.addAttribute("code", -9006);
                    return "common/fail";
                }


                log.info("给id为：" + approveLog.getLogId() + "日志点赞");
                if (user.getIniScore() >= dailyAttendance.getLoveScore()) {
                    user.setIniScore(user.getIniScore() - dailyAttendance.getLoveScore());

                    staff = staffService.getObjectById(approveLog.getPraiseId());
                    staff.setTotalScore(staff.getTotalScore() + dailyAttendance.getLoveScore());
                    staff.setAddScore(staff.getAddScore() + dailyAttendance.getLoveScore());
                    staff.setLoveScore(staff.getLoveScore() + dailyAttendance.getLoveScore());


                    //积分记录添加
                    scoreLog.setStaffId(staff.getId());
                    scoreLog.setCreateBy(staff.getId());
                    scoreLog.setUpdateBy(staff.getId());
                    scoreLog.setScoreReason(ConstantItem.LOG_PRAISE);
                    scoreLog.setScoreChange(ConstantItem.ADD + dailyAttendance.getLoveScore());
                    scoreLog.setScoreType(ConstantItem.LOG);


                    //点赞数加1
                    int sum = enterpriseLog.getApproveNum();
                    enterpriseLog.setApproveNum(++sum);
                    //给日志点赞 添加点赞人头像
                    String list = enterpriseLog.getPraise();
                    String s = null;
                    if (null != list && !"".equals(list)) {
                        Type type = new TypeToken<List<String>>() {
                        }.getType();
                        List<String> praises = GsonUtil.getUnerializeNullsGson().fromJson(list, type);
                        praises.add(user.getImg());
                        s = GsonUtil.getUnerializeNullsGson().toJson(praises);
                    } else {
                        List<String> praises = new ArrayList<>();
                        praises.add(user.getImg());
                        s = GsonUtil.getUnerializeNullsGson().toJson(praises);
                    }
                    enterpriseLog.setPraise(s);


                    model.addAttribute("code", 0);
                    model.addAttribute("message", "送出心" + dailyAttendance.getLoveScore() + "分");

                    boolean userResult = staffService.update(user);
                    log.info("update user id: " + user.getId() + " userResult is: " + userResult);
                    //更新积分
                    boolean staffResult = staffService.update(staff);
                    log.info("update staff id: " + staff.getId() + " staffResult is: " + staffResult);


                    boolean enterpriseLogResult = enterpriseLogService.update(enterpriseLog);
                    log.info("update enterpriseLog id: " + enterpriseLog.getId() + " enterpriseLogResult is: " + enterpriseLogResult);

                    //点赞记录添加
                    approveLog.setScore(dailyAttendance.getLoveScore());
                    approveLogId = approveLogService.insert(approveLog);
                    log.info("add approveLog id is: " + approveLogId);


                    scoreLog.setSpecialId(approveLog.getLogId());

                    scoreLogId = scoreLogService.insert(scoreLog);
                    log.info("add scoreLogId is: " + scoreLogId);

                } else {
                    model.addAttribute("code", -9000);
                    return "common/fail";
                }
            } else {


                staff = staffService.getObjectById(approveLog.getPraiseId());
                if (user.getId().longValue() == staff.getId()) {
                    model.addAttribute("code", -9005);
                    return "common/fail";
                }

                log.info("给员工id为：" + approveLog.getStaffId() + "点赞");
                // /判断点赞太阳/爱心 0太阳1爱心
                if (ConstantItem.PRAISE_LOG == approveLog.getScoreType()) {
                    //判断可用积分是否剩余
                    if (user.getIniScore() >= dailyAttendance.getSunScore()) {
                        log.info("点赞太阳");
                        user.setIniScore(user.getIniScore() - dailyAttendance.getSunScore());

                        staff.setTotalScore(staff.getTotalScore() + dailyAttendance.getSunScore());
                        staff.setAddScore(staff.getAddScore() + dailyAttendance.getSunScore());
                        staff.setSunScore(staff.getSunScore() + dailyAttendance.getSunScore());
                        //更新积分


                        //积分添加记录
                        scoreLog.setStaffId(staff.getId());
                        scoreLog.setCreateBy(staff.getId());
                        scoreLog.setUpdateBy(staff.getId());
                        scoreLog.setScoreReason(ConstantItem.PRAISE_SUN);
                        scoreLog.setScoreChange(ConstantItem.ADD + dailyAttendance.getSunScore());
                        scoreLog.setScoreType(ConstantItem.PRAISE);


                        model.addAttribute("code", 0);
                        model.addAttribute("message", "送出太阳" + dailyAttendance.getSunScore() + "分");

                        boolean userResult = staffService.update(user);
                        log.info("update user id: " + user.getId() + " userResult is: " + userResult);
                        //更新积分
                        boolean staffResult = staffService.update(staff);
                        log.info("update staff id: " + staff.getId() + " staffResult is: " + staffResult);


                        //点赞添加记录
                        approveLog.setScore(dailyAttendance.getSunScore());
                        approveLogId = approveLogService.insert(approveLog);
                        log.info("add approveLog id is: " + approveLogId);
                        scoreLog.setSpecialId(approveLogId);
                        scoreLogId = scoreLogService.insert(scoreLog);
                        log.info("add scoreLogId is :" + scoreLogId);
                    } else {
                        model.addAttribute("code", -9000);
                        return "common/fail";
                    }


                } else {
                    if (user.getIniScore() >= dailyAttendance.getLoveScore()) {
                        log.info("点赞爱心");
                        user.setIniScore(user.getIniScore() - dailyAttendance.getLoveScore());


                        staff = staffService.getObjectById(approveLog.getPraiseId());
                        log.info("get staffId is: " + staff.getId());
                        staff.setTotalScore(staff.getTotalScore() + dailyAttendance.getLoveScore());
                        staff.setAddScore(staff.getAddScore() + dailyAttendance.getLoveScore());
                        staff.setLoveScore(staff.getLoveScore() + dailyAttendance.getLoveScore());


                        //积分添加记录
                        scoreLog.setStaffId(staff.getId());
                        scoreLog.setCreateBy(staff.getId());
                        scoreLog.setUpdateBy(staff.getId());
                        scoreLog.setScoreReason(ConstantItem.PRAISE_LOVE);
                        scoreLog.setScoreChange(ConstantItem.ADD + dailyAttendance.getLoveScore());
                        scoreLog.setScoreType(ConstantItem.PRAISE);


                        model.addAttribute("code", 0);
                        model.addAttribute("message", "送出心" + dailyAttendance.getLoveScore() + "分");
                        boolean userResult = staffService.update(user);
                        log.info("update user id: " + user.getId() + " userResult is: " + userResult);
                        //更新积分
                        boolean staffResult = staffService.update(staff);
                        log.info("update staff id: " + staff.getId() + " staffResult is: " + staffResult);


                        //点赞记录添加
                        approveLog.setScore(dailyAttendance.getLoveScore());
                        approveLogId = approveLogService.insert(approveLog);
                        log.info("add approveLog id is: " + approveLogId);

                        scoreLog.setSpecialId(approveLogId);
                        scoreLogId = scoreLogService.insert(scoreLog);
                        log.info("add scoreLogId is: " + scoreLogId);


                    } else {
                        model.addAttribute("code", -9000);
                        return "common/fail";
                    }
                }
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
            model.addAttribute("code", -100000);
        }

        model.addAttribute("code", 0);
        return "/data/log";
    }


    /**
     * 2.爱心点赞列表
     *
     * @param request
     * @param response
     * @param model
     * @param departmentName
     * @param positionName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/approve", method = RequestMethod.GET)
    public String getMultiApproveLogJson(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model,
                                         String departmentName, String positionName)
            throws Exception {


        log.info("param = departmentName is: " + departmentName + " positionName is: " + positionName);
        List<Long> staffIdList = null;
        List<Staff> staffList = null;
        Map<String, Object> param = null;
        DailyAttendance dailyAttendance = null;


        try {
            param = DynamicSQLUtil.getStaffList(departmentName, positionName);
            staffIdList = staffService.getIdsByDynamicCondition(Staff.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIdList is: " + staffIdList);
            staffList = staffService.getObjectsByIds(staffIdList);
            log.info("get staffList.size id: " + staffIdList.size());

            dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.LOVE_PRAISE);
            if (DataUtils.isNullOrEmpty(dailyAttendance)) {
                log.info("get dailyAttendance is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get dailyAttendance is: " + dailyAttendance.getId());

            model.addAttribute("code", 0);
            model.addAttribute("staffList", staffList);
            model.addAttribute("dailyAttendance", dailyAttendance);


        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get approveLog error,id is  ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        return "/json/approveLog/json/approveLogListJson";


    }


    /**
     * 3.点赞详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/approve/{id}", method = RequestMethod.GET)
    public String getApproveLogJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("param id is: " + id);
        List<Map> approveList = new ArrayList<>();
        Map<String, Object> param = null;
        Map<Long, Integer> staffScoreMap = new HashMap<>();
        try {
            param = DynamicSQLUtil.getApproveListByPraiseId(id);
            List<Long> approveLogIdList = approveLogService.getIdsByDynamicCondition(ApproveLog.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<ApproveLog> approveLogList = approveLogService.getObjectsByIds(approveLogIdList);
            log.info("get approveLogList is: " + approveLogList.size());

            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            List<Staff> staffList = staffService.getObjectsByIds(staffIds);


            Integer score;
            //遍历list把相同元素合并，指定属性相加
            for (ApproveLog a : approveLogList) {
                Long staffId = a.getStaffId();
                if (staffScoreMap.containsKey(staffId)) {
                    score = staffScoreMap.get(staffId) + a.getScore();
                    staffScoreMap.put(staffId, score);
                } else {
                    staffScoreMap.put(staffId, a.getScore());
                }

            }

            staffScoreMap = MyMapUtil.sortMapKeyByValue(staffScoreMap, new Comparator<Integer>() {
                @Override
                public int compare(Integer score, Integer anotherScore) {
                    return anotherScore - score;
                }
            });

            Set<Long> staffIdSet = staffScoreMap.keySet();

            List staffIdList = new ArrayList(staffIdSet);
            List staffListApprove = staffService.getObjectsByIds(staffIdList);


//            log.info("=============approveList>>" + approveList);


//            if (staffListApprove.size() == 0) {
//                log.error("get staffListApprove is null！");
//                model.addAttribute("code", -1000);
//                return "common/fail";
//            }
//            log.info("get staffListApprove.size is: " + staffListApprove.size());
//            if (staffList.size() == 0) {
//                log.error("get staffList is null！");
//                model.addAttribute("code", -1000);
//                return "common/fail";
//            }
            model.addAttribute("staffList", staffListApprove);
            model.addAttribute("staffScoreMap", staffScoreMap);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get approveLog error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        model.addAttribute("code", 0);

        model.addAttribute("list", approveList);
        return "/json/approveLog/json/approveList";

    }


}

