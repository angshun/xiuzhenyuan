package com.ptteng.score.home.controller;

import com.gemantic.common.util.MyListUtil;
import com.google.gson.reflect.TypeToken;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DateUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.ptteng.score.home.util.GsonUtil;
import com.ptteng.score.home.vo.Comment;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.collections.ListUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EnterpriseLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class EnterpriseLogController {
    private static final Log log = LogFactory.getLog(EnterpriseLogController.class);

    @Autowired
    private EnterpriseLogService enterpriseLogService;

    @Autowired
    private ScoreLogService scoreLogService;

    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ScoreTypeService scoreTypeService;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private ApproveLogService approveLogService;

    /**
     * 1.企业日志列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */


    @RequestMapping(value = "/a/u/worklog", method = RequestMethod.GET)
    public String getScoreLog(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model,
                              Integer size, Integer page)
            throws Exception {

        log.info("param=  + page is: " + page + " size is: " + size);

        if (page == null || page <= ConstantItem.ZERO) {
            page = ConstantItem.ONE;
        }
        if (size == null || size <= ConstantItem.ZERO) {
            size = ConstantItem.TWENTY;
        }
        int start = (page - ConstantItem.ONE) * size;
        if (start < ConstantItem.ZERO) {
            start = ConstantItem.ZERO;
        }
        List<Map<String, Object>> worklogMap = new ArrayList<>();

        List<Long> count = null;


        try {

            Map<String, Object> map = DynamicSQLUtil.searchEnterpriseLog();
            List<Long> epLogIdList = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, map, start, size);
            log.info("get idList is: " + epLogIdList);

            List<EnterpriseLog> epLogList = enterpriseLogService.getObjectsByIds(epLogIdList);
            log.info("data size:" + epLogList.size());

            List<Long> staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds is: " + staffIds.size());

            count = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is: " + count.size());

            List<Staff> staffList = staffService.getObjectsByIds(staffIds);
            log.info("get staffList.size is: " + staffList.size());

            Map<Long, String> staff_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> staff_img = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("img"), staffList);
            Map<Long, String> staff_departmentName = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("departmentName"), staffList);
            Map<Long, String> staff_staffId = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("id"), staffList);

            /*
            * 所有的 workIdList    当前登录用户点过赞的 wordIdList
            * */
//            Long staffId = cookieUtil.getID(request);
            Long staffId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));

            Map<String, Object> approveParams = DynamicSQLUtil.getApproveListByStaffId(staffId);
            List<Long> workLogIdByPraiseIdList = approveLogService.getIdsByDynamicCondition(ApproveLog.class, approveParams, 0, Integer.MAX_VALUE);

            List<ApproveLog> wkLogByPraiseIdList = approveLogService.getObjectsByIds(workLogIdByPraiseIdList);

            // 查出全部的 enterpriseLogList
            List<Long> epLogIdListAll = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, map, start, Integer.MAX_VALUE);
            log.info("get idList is: " + epLogIdList);

            List<EnterpriseLog> epLogListAll = enterpriseLogService.getObjectsByIds(epLogIdListAll);

            List<Long> lwIdList = MyListUtil.getFieldValueListFromModelList(epLogListAll, false, EnterpriseLog.class.getDeclaredField("id"));
            List<Long> lwpIdList = MyListUtil.getFieldValueListFromModelList(wkLogByPraiseIdList, true, ApproveLog.class.getDeclaredField("logId"));


            List<Long> workLogListNoPraise = ListUtils.removeAll(lwIdList, lwpIdList);

            Map<Long, Integer> isPraiseMap = new HashMap<>();

            for (Long wkLogId : lwIdList) {
                isPraiseMap.put(wkLogId, 1);
            }
            for (Long wkLogId : workLogListNoPraise) {
                isPraiseMap.put(wkLogId, 0);
            }

            model.addAttribute("code", 0);
            model.addAttribute("epLogList", epLogList);
            model.addAttribute("staff_img", staff_img);
            model.addAttribute("staff_alias", staff_alias);
            model.addAttribute("staff_staffId", staff_staffId);
            model.addAttribute("staff_departmentName", staff_departmentName);
            model.addAttribute("isPraiseMap", isPraiseMap);

            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());


            return "json/enterpriseLog/json/enterpriseLogListJson";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 1");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    /**
     * 2.日志详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/worklog/{id}", method = RequestMethod.GET)
    public String getScoreLogId(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        Map<String, Object> param = null;

        Integer isPraise = null;
        try {

            Long staffId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));


            param = DynamicSQLUtil.getPraiseIdList(id,staffId);
            List<Long> longList = approveLogService.getIdsByDynamicCondition(ApproveLog.class, param, 0, Integer.MAX_VALUE);
            if (longList.size() > 0) {
                isPraise = ConstantItem.ONE;
            } else {
                isPraise = ConstantItem.ZERO;
            }


            EnterpriseLog enterpriseLog = enterpriseLogService.getObjectById(id);
            Type type = new TypeToken<List<Comment>>() {
            }.getType();
            String comment = enterpriseLog.getComment();
            List<Comment> comments = GsonUtil.getUnerializeNullsGson().fromJson(comment, type);
            log.info("get comments is: " + comment);


            Type type1 = new TypeToken<List<String>>() {
            }.getType();
            String praise = enterpriseLog.getPraise();
            List<String> praises = GsonUtil.getUnerializeNullsGson().fromJson(praise, type1);
            log.info("get praises is: " + praises);

            log.info("get workLog id is: " + enterpriseLog.getStaffId());

            Staff staff = staffService.getObjectById(enterpriseLog.getStaffId());
            log.info("get staffId is: " + staff.getId());






            Map<String, Object> data = new HashMap<>();
            data.put("staff", staff);
            data.put("enterpriseLog", enterpriseLog);
            data.put("praise", praises);
            data.put("commentList", comments);
            data.put("isPraise", isPraise);
            log.info("get data is: " + data);


            model.addAttribute("code", 0);
            model.addAttribute("data", data);
            return "json/enterpriseLog/json/enterpriseLogDetailJson";
        } catch (Exception e) {


            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 2");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }

    /**
     * 3.发布日志
     *
     * @param request
     * @param response
     * @param enterpriseLog
     * @return
     */
    @RequestMapping(value = "/a/u/worklog", method = RequestMethod.POST)
    public String addWorklog(HttpServletRequest request, HttpServletResponse response,
                             @RequestBody EnterpriseLog enterpriseLog, ModelMap model) throws Exception {
        if (DataUtils.isNullOrEmpty(enterpriseLog)) {
            log.info("get enterpriseLog is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("add worklog is: " + enterpriseLog);

        //判断日志发布次数
        Long staffId = enterpriseLog.getStaffId();
        Long zero = DateUtil.timeUtill(ConstantItem.ZERO);
        Long time = DateUtil.timeUtill(ConstantItem.TWENTY_FOUR);
        Map<String, Object> param = null;
        List<Long> idList = null;
        Long enterpriseLogId = null;
        Long scoreLogId = null;
        DailyAttendance dailyAttendance = null;


        Map<String, Object> param1 = null;
        List<Long> staffIdList = null;

        param = DynamicSQLUtil.getEnterpriseLogList(staffId, zero, time);
        try {
            idList = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get idList: " + idList);
            //获取日志设置
            dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.WORL_LOG);
            //判断日志发布次数
            if (idList.size() >= dailyAttendance.getLogReleaseTime()) {
                model.addAttribute("code", -9002);
                return "common/fail";
            }
            enterpriseLog.setUpdateBy(staffId);
            enterpriseLog.setCreateBy(staffId);
            enterpriseLog.setCommentNum(ConstantItem.ZERO);
            enterpriseLog.setApproveNum(ConstantItem.ZERO);
            //发布日志奖励积分汇总到总积分
            param1 = DynamicSQLUtil.getStaffLogList(staffId);
            staffIdList = staffService.getIdsByDynamicCondition(Staff.class, param1, ConstantItem.ZERO, Integer.MAX_VALUE);
            Staff staff = staffService.getObjectById(staffIdList.get(0));
            staff.setAddScore(staff.getAddScore() + dailyAttendance.getNormalScore());
            staff.setTotalScore(staff.getTotalScore() + dailyAttendance.getNormalScore());
            log.info("汇总到总积分");

            //新增积分记录
            ScoreLog scoreLog = new ScoreLog();
            scoreLog.setStaffId(staffId);
            scoreLog.setCreateBy(staffId);
            scoreLog.setUpdateBy(staffId);
            scoreLog.setScoreReason(ConstantItem.NOTE);
            scoreLog.setScoreChange("+" + dailyAttendance.getNormalScore());
            scoreLog.setScoreType(ConstantItem.LOG);


            boolean result = staffService.update(staff);
            log.info("update id: " + staff.getId() + " result is: " + result);

            enterpriseLogId = enterpriseLogService.insert(enterpriseLog);
            log.info("add enterpriseLogId is: " + enterpriseLogId);
            scoreLog.setSpecialId(enterpriseLogId);
            log.info("add enterpriseLog is: " + enterpriseLogId);
            scoreLogId = scoreLogService.insert(scoreLog);
            log.info("add scoreLogId is: " + scoreLogId);

        } catch (Throwable e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add enterpriseLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        model.addAttribute("code", 0);
        model.addAttribute("message", "发布日志获得" + dailyAttendance.getNormalScore() + "分");
        return "data/log";
    }

    /**
     * 4.获得发布日志状态
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/worklog/status", method = RequestMethod.GET)
    public String getLogStatus(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model)
            throws Exception {


        log.info("get /a/u/worklog/status ");
        //判断今日是否发布日志
        Long staffId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get staffId is : " + staffId);

        Long zero = DateUtil.timeUtill(ConstantItem.ZERO);
        Long time = DateUtil.timeUtill(ConstantItem.TWENTY_FOUR);
        Map<String, Object> param = null;
        List<Long> epLogIds = null;
        DailyAttendance dailyAttendance = null;
        Map<String, Object> logStatus = new HashMap<>();

        Integer status = 0;
        Integer score = 0;

        param = DynamicSQLUtil.getEnterpriseLogList(staffId, zero, time);
        try {
            epLogIds = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, param, 0, Integer.MAX_VALUE);
            log.info("get idList: " + epLogIds.size());
            //获取日志设置
            dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.WORL_LOG);
            score = dailyAttendance.getNormalScore();

            //封装日志奖励积分和发布日志状态
            logStatus.put("score", score);
            logStatus.put("id", staffId);
            if (epLogIds.size() >= dailyAttendance.getLogReleaseTime() || epLogIds.size() >= ConstantItem.ONE) {
                status = ConstantItem.ONE;
                logStatus.put("status", status);
            } else {
                status = ConstantItem.ZERO;
                logStatus.put("status", status);
            }


        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 3");
            return "common/fail";
        }

        model.addAttribute("code", 0);
        model.addAttribute("logStatus", logStatus);
        return "data/logStatus";

    }

    /**
     * 5.发布评论
     *
     * @param request
     * @param response
     * @param comment
     * @return
     */
    @RequestMapping(value = "/a/u/comment", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request, HttpServletResponse response,
                             @RequestBody Comment comment, ModelMap model) throws Exception {
        if (DataUtils.isNullOrEmpty(comment)) {
            log.info("get comment is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("add comment is: " + comment);
        int sum = 0;
        try {

            EnterpriseLog enterpriseLog = enterpriseLogService.getObjectById(comment.getLogId());
            comment.setCreateAt(System.currentTimeMillis());

            String list = enterpriseLog.getComment();
            String s = null;
            if (null != list && !"".equals(list)) {
                Type type = new TypeToken<List<Comment>>() {
                }.getType();
                List<Comment> comments = GsonUtil.getUnerializeNullsGson().fromJson(list, type);
                comments.add(comment);
                s = GsonUtil.getUnerializeNullsGson().toJson(comments);
            } else {
                List<Comment> comments1 = new ArrayList<>();
                comments1.add(comment);
                s = GsonUtil.getUnerializeNullsGson().toJson(comments1);
            }
            sum = enterpriseLog.getCommentNum();
            log.info("get sum is: " + sum);
            enterpriseLog.setComment(s);
            enterpriseLog.setCommentNum(++sum);
            log.info("get commentNum is: " + enterpriseLog.getCommentNum());
            enterpriseLogService.update(enterpriseLog);
        } catch (Throwable e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add enterpriseLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        model.addAttribute("code", 0);
        model.addAttribute("message", "发布评论成功！");
        return "data/log";


    }


    @RequestMapping(value = "/a/u/detail/worklog", method = RequestMethod.GET)
    public String getEnterpriseLog(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long id)
            throws Exception {

        /**
         *@Description:工作日志/个人日志
         */

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            Map<String, Object> map = DynamicSQLUtil.searchPersonalLog(id);
            List<Long> count = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<EnterpriseLog> enterpriseLogList = enterpriseLogService.getObjectsByIds(count);

            log.info("data objectById size: " + enterpriseLogList.size());
            model.addAttribute("code", 0);
            model.addAttribute("worklog", enterpriseLogList);
            return "json/enterpriseLog/json/enterpriseLogListJsons";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 4");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

}

