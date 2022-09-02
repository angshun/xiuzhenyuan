package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.AttendanceLog;
import com.ptteng.score.home.model.DailyAttendance;
import com.ptteng.score.home.model.ScoreLog;
import com.ptteng.score.home.model.Staff;
import com.ptteng.score.home.service.AttendanceLogService;
import com.ptteng.score.home.service.DailyAttendanceService;
import com.ptteng.score.home.service.ScoreLogService;
import com.ptteng.score.home.service.StaffService;
import com.ptteng.score.home.util.DateUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
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
import java.util.List;
import java.util.Map;

import static com.ptteng.score.home.constant.ConstantItem.CLOCKK;

/**
 * AttendanceLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class AttendanceLogController {
    private static final Log log = LogFactory.getLog(AttendanceLogController.class);

    @Autowired
    private AttendanceLogService attendanceLogService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ScoreLogService scoreLogService;

    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @Autowired
    private CookieUtil cookieUtil;


    /**
     * 1.签到
     *
     * @param request
     * @param response
     * @param model
     * @param attendanceLog
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/clock", method = RequestMethod.POST)
    public String addAttendanceLogJson(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model,
                                       @RequestBody AttendanceLog attendanceLog) throws Exception {
        log.info("服务器时间：" + System.currentTimeMillis());
        Long punchTime = attendanceLog.getTime();
        log.info("打卡时间: " + punchTime);

        if (DataUtils.isNullOrEmpty(attendanceLog)) {
            log.info("get attendanceLog is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("add attendanceLog : attendanceLog= " + attendanceLog);


        ScoreLog scoreLog = new ScoreLog();
        Staff staff = null;
        Long time = 0L;
        time = DateUtil.timeUtil(ConstantItem.ONE);
        Map<String, Object> param = null;


        try {
            param = DynamicSQLUtil.getAttendanceLog(attendanceLog.getStaffId());
            List<Long> ids = attendanceLogService.getIdsByDynamicCondition(AttendanceLog.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            if (ids.size() >= ConstantItem.TWO) {
                model.addAttribute("code", 0);
                model.addAttribute("message", "今天已经打卡");
                return "data/log";
            }

            staff = staffService.getObjectById(attendanceLog.getStaffId());

            Long staffId = staff.getId(); // 员工Id
            Integer staffAddScore = staff.getAddScore(); // 员工已有加分
            Integer staffTotalScore = staff.getTotalScore();  // 员工当前总分


            DailyAttendance dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.CLOCK);

            Long workTime = dailyAttendance.getWorkTime();    // 内勤上班时间
            Long closingTime = dailyAttendance.getClosingTime();   // 内勤下班时间
            Long outsideWorkTime = dailyAttendance.getOutsideWorkTime();  // 外勤上班时间
            Long outsideClosingTime = dailyAttendance.getOutsideClosingTime();  // 外勤下班时间

            Integer outsideWorkTimeScore = dailyAttendance.getOutsideWorkTimeScore();  // 外勤准时上班奖励分
            Integer outsideClosingTimeScore = dailyAttendance.getOutsideClosingTimeScore();  // 外勤按时下班奖励分
            Integer attendanceType = attendanceLog.getAttendanceType();
            log.info("=========== attendanceType ============ is :" + attendanceType);

            switch (attendanceType) {
                //内勤上班
                case 1:
                    //正常
                    if (0 <= workTime) {
                        dailyAttendance.setWorkTime(workTime + ConstantItem.TIME);
                    } else {
                        dailyAttendance.setWorkTime(ConstantItem.TIME - workTime);
                    }

                    if (0 <= closingTime) {
                        dailyAttendance.setClosingTime(closingTime + ConstantItem.TIME);
                    } else {
                        dailyAttendance.setClosingTime(ConstantItem.TIME - closingTime);
                    }

                    if (punchTime <= workTime && punchTime > workTime - ConstantItem.MINUTES) {

                        //考勤状态见约定
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_RIGHT);

                        staff.setAddScore(staffAddScore + dailyAttendance.getNormalScore());
                        staff.setTotalScore(staffTotalScore + dailyAttendance.getNormalScore());


                        //积分记录添加
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + dailyAttendance.getNormalScore());
                        //积分类型见约定
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "内勤上班打卡获得" + dailyAttendance.getNormalScore() + "分");


                        //早到  上班时间前40分钟打卡为早到
                    } else if (punchTime <= workTime - ConstantItem.MINUTES) {
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_ARRIVE_EARLY);
                        staff.setTotalScore(staffTotalScore + dailyAttendance.getMorningScore());
                        staff.setAddScore(staffAddScore + dailyAttendance.getMorningScore());
                        //积分记录添加
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + dailyAttendance.getMorningScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "上班早到奖励" + dailyAttendance.getMorningScore() + "分");

                        //迟到  大于上班时间小于下班时间 按迟到
                    } else if (punchTime > workTime && punchTime < closingTime) {

                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_LATE);

                        staff.setSubScore(staff.getSubScore() + dailyAttendance.getLateScore());
                        staff.setTotalScore(staffTotalScore - dailyAttendance.getLateScore());

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("-" + dailyAttendance.getLateScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "上班迟到减去" + dailyAttendance.getLateScore() + "分");
                    } else if (punchTime > closingTime) {
                        //缺勤 大于上班时间
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_ABSENCE);

                        staff.setTotalScore(staffTotalScore - dailyAttendance.getAbsenceScore());
                        staff.setSubScore(staff.getSubScore() + dailyAttendance.getAbsenceScore());

//                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("-" + dailyAttendance.getAbsenceScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "上班缺勤减去" + dailyAttendance.getAbsenceScore() + "分");
                    }
                    break;
                //内勤下班
                case 2:
                    //正常 大于下班时间，小于开始加班时间
                    if (0 <= closingTime) {
                        dailyAttendance.setClosingTime(closingTime + ConstantItem.TIME);
                    } else {
                        dailyAttendance.setClosingTime(ConstantItem.TIME - closingTime);
                    }


                    if (punchTime >= closingTime && punchTime < closingTime + ConstantItem.HOUR) {
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_RIGHT);

                        staff.setAddScore(staffAddScore + dailyAttendance.getNormalScore());
                        staff.setTotalScore(staffTotalScore + dailyAttendance.getNormalScore());

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + dailyAttendance.getNormalScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);

                        model.addAttribute("message", "内勤下班打卡获得" + dailyAttendance.getNormalScore() + "分");
                        //早退
                    } else if (punchTime < closingTime) {
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_LEAVE_EARLY);

                        staff.setSubScore(staff.getSubScore() + dailyAttendance.getLeftEarlyScore());
                        staff.setTotalScore(staffTotalScore - dailyAttendance.getLeftEarlyScore());

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("-" + dailyAttendance.getLeftEarlyScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "早退减去" + dailyAttendance.getLeftEarlyScore() + "分");

                        //加班
                    } else if (punchTime >= closingTime + ConstantItem.HOUR && punchTime < time - ConstantItem.ONE_MINUTES) {
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_OVERTIME);

                        staff.setAddScore(staffAddScore + dailyAttendance.getOvertimeScore());
                        staff.setTotalScore(staffTotalScore + dailyAttendance.getOvertimeScore());

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + dailyAttendance.getOvertimeScore());
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);

                        model.addAttribute("message", "内勤加班打卡获得" + dailyAttendance.getOvertimeScore() + "分");
                    }


                    break;
                //外勤上班
                case 3:
                    //外勤没有迟到、早到、早退、加班限制
                    if (0 <= outsideWorkTime) {
                        outsideWorkTime = outsideWorkTime + ConstantItem.TIME;
                    } else {
                        outsideWorkTime = ConstantItem.TIME - outsideWorkTime;
                    }

                    if (0 <= outsideClosingTime) {
                        outsideClosingTime = (outsideClosingTime + ConstantItem.TIME);
                    } else {
                        outsideClosingTime = (ConstantItem.TIME - outsideClosingTime);
                    }


                    log.info("3 外勤上班 punchTime is " + punchTime + "; outsideWorkTime is " + outsideWorkTime);
                    if (punchTime <= outsideWorkTime) {

                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_RIGHT);

                        staff.setAddScore(staffAddScore + outsideWorkTimeScore);
                        staff.setTotalScore(staffTotalScore + outsideWorkTimeScore);

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + outsideWorkTimeScore);
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                        model.addAttribute("message", "外勤上班打卡获得" + outsideWorkTimeScore + "分");
                    } else {
                        model.addAttribute("message", "外勤出差请注意安全");

                    }

                    break;
                //外勤下班
                case 4:
                    //正常
                    if (0 <= outsideClosingTime) {
                        outsideClosingTime = (outsideClosingTime + ConstantItem.TIME);
                    } else {
                        outsideClosingTime = (ConstantItem.TIME - outsideClosingTime);
                    }


                    log.info("4 外勤下班 punchTime is " + punchTime + "; outsideWorkTime is " + outsideWorkTime);
                    if (punchTime > outsideClosingTime) {
                        attendanceLog.setAttendanceStatus(ConstantItem.STATUS_RIGHT);

                        staff.setAddScore(staffAddScore + outsideClosingTimeScore);
                        staff.setTotalScore(staffTotalScore + outsideClosingTimeScore);

                        //积分添加记录
                        scoreLog.setStaffId(staffId);
                        scoreLog.setCreateBy(staffId);
                        scoreLog.setUpdateBy(staffId);
                        scoreLog.setScoreReason(CLOCKK);
                        scoreLog.setScoreChange("+" + outsideClosingTimeScore);
                        scoreLog.setScoreType(ConstantItem.ATTENDANCE);

                        model.addAttribute("message", "外勤下班打卡获得" + outsideClosingTimeScore + "分");
                    } else {
                        model.addAttribute("message", "外勤出差请注意安全");

                    }

                    break;
                default:

            }


            attendanceLog.setCreateBy(attendanceLog.getStaffId());
            attendanceLog.setUpdateBy(attendanceLog.getStaffId());
            Long id = attendanceLogService.insert(attendanceLog);
            log.info("add attendanceLog id is: " + id);
            boolean result = staffService.update(staff);
            log.info("update id: " + staffId + " result is: " + result);
            scoreLog.setSpecialId(id);
            Long scoreLogId = scoreLogService.insert(scoreLog);
            log.info("add scoreLogId is: " + scoreLogId);


            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add attendanceLog error ");
            model.addAttribute("code", -6002);
        }

        return "/data/log";
    }


    /**
     * 2.获取考勤参数
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/clockset/{id}", method = RequestMethod.GET)
    public String getDailyAttendanceJson(HttpServletRequest request,
                                         HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get data : id= " + id);
        try {
            DailyAttendance dailyAttendance = dailyAttendanceService.getObjectById(id);
            log.info("get dailyAttendance data is " + dailyAttendance);

            model.addAttribute("code", 0);

            model.addAttribute("dailyAttendance", dailyAttendance);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get dailyAttendance error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/json/dailyAttendance/json/dailyAttendanceDetailJson";
    }


    /**
     * 3.获取考勤记录
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/clock", method = RequestMethod.GET)
    public String getMultiAttendanceLogJson(HttpServletRequest request,
                                            HttpServletResponse response, ModelMap model/*, Integer attendanceType*/)
            throws Exception {

//        log.info("get attendanceType is:" + attendanceType);

        Map<String, Object> param = null;
        List<Long> ids = null;
        List<AttendanceLog> list = null;
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));

        try {
//            if (null == attendanceType) {
//                log.error("get attendanceType is null ");
//                model.addAttribute("code", -1000);
//            }
            param = DynamicSQLUtil.getAttendanceLogList(adminId/*, attendanceType*/);

            ids = attendanceLogService.getIdsByDynamicCondition(AttendanceLog.class, param, 0, Integer.MAX_VALUE);
            log.info("get ids is: " + ids.size());

            list = attendanceLogService.getObjectsByIds(ids);
            log.info("get list.size is: " + list.size());

            model.addAttribute("code", 0);

            model.addAttribute("list", list);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get attendanceLog error,id is  ");
            t.printStackTrace();
            model.addAttribute("code", -100000);
        }

        return "/json/attendanceLog/json/attendanceLogListJson";
    }


    /**
     * 4.考勤记录详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param scoreType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/clock/{id}", method = RequestMethod.GET)
    public String getClockJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable Long id, Integer scoreType) throws Exception {

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        log.info("param scoreLogId is: " + id);
        if (DataUtils.isNullOrEmpty(scoreType)) {
            log.info("get scoreType is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get scoreType is: " + scoreType);


        Map<String, Object> param = null;
        try {


            AttendanceLog attendanceLog = attendanceLogService.getObjectById(id);
            if (attendanceLog == null) {

                model.addAttribute("code", -9004);
                return "common/fail";
            }

            Staff staff = staffService.getObjectById(attendanceLog.getStaffId());
            log.info("get staffId is: " + staff.getId());


            param = DynamicSQLUtil.getScoreList(id, scoreType);

            List<Long> ids = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, param, 0, Integer.MAX_VALUE);
            log.info("get ids is: " + ids.size());
            ScoreLog scoreLog = scoreLogService.getObjectById(ids.get(0));
            log.info("get scoreLog is: " + scoreLog);


            model.addAttribute("staff", staff);
            model.addAttribute("attendanceLog", attendanceLog);
            model.addAttribute("scoreLog", scoreLog);
            model.addAttribute("code", 0);

            return "json/attendanceLog/json/attendanceLogDetailJson";


        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get attendanceLog error,id is  " + id);
            t.printStackTrace();
            model.addAttribute("code", -100000);
            return "common/fail";

        }

    }
}

