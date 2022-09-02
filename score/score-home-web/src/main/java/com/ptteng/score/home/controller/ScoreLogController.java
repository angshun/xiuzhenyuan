package com.ptteng.score.home.controller;

import com.gemantic.common.util.MyListUtil;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.responseStructure.TimeScoreLogCatagory;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DateUtil;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.ptteng.score.home.util.HttpClientUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ScoreLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ScoreLogController {
    private static final Log log = LogFactory.getLog(ScoreLogController.class);

    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private RewardLogService rewardLogService;
    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private StaffPhilosophyRelationService staffPhilosophyRelationService;
    @Autowired
    private PhilosophyService philosophyService;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/a/u/detail/scoreLog", method = RequestMethod.GET)
    public String getscoreLogList(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:个人中心积分日志列表
         *@Date: 16:10 2017/10/3
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
        List<ScoreLog> scoreLogList;
        try {
            List<Long> scoreLogIds = scoreLogService.getScoreLogIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get scoreLogIds is: " + scoreLogIds);
            scoreLogList = scoreLogService.getObjectsByIds(scoreLogIds);
            log.info("get scoreLogList.size is: " + scoreLogList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 4");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        List<ScoreLog> list = new ArrayList<>();
        for (ScoreLog scoreLog : scoreLogList) {
            if (scoreLog.getStaffId() == id.longValue()) {
                list.add(scoreLog);
            }
        }

        log.info("===============>>" + list.size());
        log.info(list.toString());
        List<TimeScoreLogCatagory> logCatagories = new ArrayList<>();


        Set<String> strings = new HashSet<>();
        for (ScoreLog scoreLog2 : list) {
            strings.add(DateUtil.formatTime(scoreLog2.getCreateAt().toString()));
        }

        log.info("=============count size>>" + strings.size());
        for (String str : strings) {
            TimeScoreLogCatagory timeScoreLogCatagory1 = new TimeScoreLogCatagory();
            timeScoreLogCatagory1.setFormatTime(str);
            List<ScoreLog> logCatagories1 = new ArrayList<>();
            for (ScoreLog scoreLog3 : list) {
                String format = DateUtil.formatTime(scoreLog3.getCreateAt().toString());
                if (str.equals(format)) {
                    logCatagories1.add(scoreLog3);
                }
            }
            timeScoreLogCatagory1.setScoreLogList(logCatagories1);
            logCatagories.add(timeScoreLogCatagory1);
        }
        Collections.reverse(logCatagories);
        model.addAttribute("code", 0);
        model.addAttribute("categoryList", logCatagories);
        return "json/othersJsp/json/scoreLogListByGroup";
    }

    @RequestMapping(value = "/a/u/detail/scoreLogs", method = RequestMethod.GET)
    public String getscoreLog(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, Integer time) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:积分明细列表1（按时间统计积分情况）
         *@Date: 16:10 2017/10/3
         * @param request
         * @param response
         * @param model
         * @param id
         */
        if (DataUtils.isNullOrEmpty(time)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get time is: " + time);
        Long startTime = 0L;
        switch (time) {
            case 0:
                startTime = DateUtil.timeUtil(ConstantItem.ZERO);
                break;
            case 1:
                startTime = DateUtil.getCurrentMonthLastDay();
                break;
            case 2:
                startTime = DateUtil.getQuarterByMonth(false);
                break;
            case 3:
                startTime = 0L;
                break;
            default:
        }
        List<ScoreLog> scoreLogList;
        Staff staff;
        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            log.info("get adminId is: " + adminId);
            staff = staffService.getObjectById(adminId);
            log.info("get staff is: " + staff.getId());
            Long endTime = System.currentTimeMillis();
            Map<String, Object> map = DynamicSQLUtil.seareLo(startTime, endTime, adminId);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            scoreLogList = scoreLogService.getObjectsByIds(count);
            log.info("get scoreLogList.size is: " + scoreLogList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 5");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        model.addAttribute("code", 0);
        model.addAttribute("scoreLogList", scoreLogList);
        model.addAttribute("staff", staff);
        return "json/othersJsp/json/scoreLogListJsons";
    }


    @RequestMapping(value = "/a/u/detail/scoreLogs/addSub", method = RequestMethod.GET)
    public String ge(HttpServletRequest request,
                     HttpServletResponse response, ModelMap model, Integer type) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:积分明细列表2（积分加减情况）
         *@Date: 16:10 2017/10/3
         * @param request
         * @param response
         * @param model
         * @param id
         */
        if (DataUtils.isNullOrEmpty(type)) {
            log.info("get type is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get type is: " + type);
        List<ScoreLog> scoreLogList;
        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, com.qding.common.util.http.cookie.CookieUtil.USER_ID));
            log.info("get adminId is: " + adminId);
            Map<String, Object> map = DynamicSQLUtil.searchSingleScoreLog(adminId);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, 0, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            scoreLogList = scoreLogService.getObjectsByIds(count);
            log.info("get scoreLogList.size is: " + scoreLogList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 6");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        List<ScoreLog> addList = new ArrayList<>();
        List<ScoreLog> subList = new ArrayList<>();

        for (ScoreLog scoreLog : scoreLogList) {
            if ("+".equals(scoreLog.getScoreChange().substring(ConstantItem.ZERO, ConstantItem.ONE))) {
                addList.add(scoreLog);
            } else {
                subList.add(scoreLog);
            }
        }
        if (type == 1) {
            model.addAttribute("code", 0);
            model.addAttribute("scoreLogList", addList);
            return "json/scoreLog/json/scoreLogListJson";
        } else {
            model.addAttribute("code", 0);
            model.addAttribute("scoreLogList", subList);
            return "json/scoreLog/json/scoreLogListJson";
        }

    }

    /**
     * @param request
     * @param response
     * @param model
     * @Author hfismyangel@163.com
     * @Description:首页全部积分日志列表
     * @Date: 16:10 2017/10/3
     */
    @RequestMapping(value = "/a/u/detail/allScoreLogs", method = RequestMethod.GET)
    public String getscoreog(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, Long startTime) throws Exception {


        if (null == startTime) {
            startTime = ConstantItem.ZERO_ID;
        }
        log.info("get startTime is: " + startTime);
        List<Staff> staffList;
        List<ScoreLog> scoreLogList;
        Long endTime = startTime + 24 * 60 * 60 * 1000L;
        try {
            Map<String, Object> map = DynamicSQLUtil.searchSinglenewScoreLo(startTime, endTime);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            scoreLogList = scoreLogService.getObjectsByIds(count);
            log.info("get scoreLogList.size is: " + scoreLogList.size());
            List<Long> staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds is: " + staffIds);
            staffList = staffService.getObjectsByIds(staffIds);
            log.info("get staffList.size is: " + staffList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 7");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        List<Map<String, Object>> list = new ArrayList<>();
        log.info(scoreLogList.size());

        Map staffId_class = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), staffList);

        model.addAttribute("code", 0);
        model.addAttribute("staffId_class", staffId_class);
        model.addAttribute("scoreLogList", scoreLogList);
        return "json/othersJsp/json/scoreLogListJson";
    }


    @RequestMapping(value = "/a/u/personalLogDetail", method = RequestMethod.GET)
    public String getscoreLogAddOrSub(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, Long id, Integer status) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:个人积分日志详情(加/减分)
         *@Date: 16:10 2017/10/3
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
        if (DataUtils.isNullOrEmpty(status)) {
            log.info("get status is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get status is: " + id);
        List<ScoreLog> scoreLogList;
        try {
            Map<String, Object> map = DynamicSQLUtil.searchMyScoreLog(id);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, 0, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            scoreLogList = scoreLogService.getObjectsByIds(count);
            log.info("get scoreLogList.size is: " + scoreLogList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 8");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        List<ScoreLog> logs = new ArrayList<>();
        if (status == ConstantItem.ONE) {
            for (ScoreLog scoreLog : scoreLogList) {
                if (scoreLog.getScoreChange().substring(ConstantItem.ZERO, ConstantItem.ONE).equals("+")) {
                    logs.add(scoreLog);
                } else if (!scoreLog.getScoreChange().substring(ConstantItem.ZERO, ConstantItem.ONE).equals("-")) {
                    logs.add(scoreLog);
                }
            }
        } else {
            for (ScoreLog scoreLog : scoreLogList) {
                if (scoreLog.getScoreChange().substring(ConstantItem.ZERO, ConstantItem.ONE).equals("-")) {
                    logs.add(scoreLog);
                }
            }
        }
        model.addAttribute("code", 0);
        model.addAttribute("scoreLogList", logs);
        return "json/scoreLog/json/scoreLogListJson";
    }

    @RequestMapping(value = "/a/u/detail/detailScorelog", method = RequestMethod.GET)
    public String getdetailScorelog(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:个人积分日志详情
         *@Date: 16:10 2017/10/3
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
        ScoreLog scoreLog = null;
        try {
            scoreLog = scoreLogService.getObjectById(id);

            if (DataUtils.isNullOrEmpty(scoreLog)) {
                log.info("get scoreLog is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get scoreLog is: " + scoreLog);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get person score log error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        log.info("get scoreLog is: " + scoreLog);
        model.addAttribute("code", 0);
        model.addAttribute("scoreLog", scoreLog);
        return "json/scoreLog/json/scoreLogDetailJson";
    }


    //,produces = "application/json; charset=utf-8"去掉后返回数据会有？？？
    @RequestMapping(value = "/a/u/dispatcher", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String disPatcherSwitch(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Integer typeId, Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:跳转前端控制器
         * 0发布日志被点赞
         * 1阅读企业文档
         * 2获取领导表扬
         * 3审批获得通过
         *@Date: 16:10 2017/10/3
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
        if (DataUtils.isNullOrEmpty(typeId)) {
            log.info("get typeId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get typeId is: " + id);
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String result = "";
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        switch (typeId) {
            case 0:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/approval/" + id);
                break;
            case 1:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/approval/" + id);
                break;
            case 2:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/approval/" + id);
                break;
            case 3:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/approve/" + id);
                break;
            case 7:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/approve/" + id);
                break;
            case 4:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/worklog/" + id);
                break;
            case 5:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/philo/" + id + "/" + adminId);
                break;
            case 6:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/dispatcherReward/" + id);
                break;
            case 8:
                result = httpClientUtil.doGet("http://127.0.0.1:10961/a/u/clock/" + id + "?scoreType=8");
                break;
            default:
        }
        return result;
    }

    @RequestMapping(value = "/a/u/philo/{id}/{adminId}", method = RequestMethod.GET)
    public String addPhilosophy(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @PathVariable Long id, @PathVariable Long adminId)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:企业哲学详情特殊
         *@Date: 15:54 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param philosophy
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        if (DataUtils.isNullOrEmpty(adminId)) {
            log.info("get adminId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get adminId is: " + id);
        try {
            Map<String, Object> map = DynamicSQLUtil.searelation(adminId, id);
            List<Long> count = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            Philosophy philosophy = philosophyService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(philosophy)) {
                log.info("get philosophy is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get philosophy is: " + id);
            if (count == null || count.size() == ConstantItem.ZERO) {
                philosophy.setArticleStatus(ConstantItem.ZERO);
            } else {
                philosophy.setArticleStatus(ConstantItem.ONE);
            }
            model.addAttribute("code", 0);
            model.addAttribute("philosophy", philosophy);
            return "json/philosophy/json/philosophyDetailJson";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 9");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/dispatcherReward/{id}", method = RequestMethod.GET)
    public String disPtch(HttpServletRequest request,
                          HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:领导表扬详情
         *@Date: 16:10 2017/10/3
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
            RewardLog rewardLog = rewardLogService.getObjectById(id);
            log.info("get rewardLog is: " + rewardLog.getId());

            if (DataUtils.isNullOrEmpty(rewardLog.getStaffId())) {
                log.info("get staffId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staffId is: " + rewardLog.getStaffId());

            Long staffId = rewardLog.getStaffId();
            Staff staff = staffService.getObjectById(staffId);

            log.info("get staffId is: " + staff.getId());

            model.addAttribute("code", 0);
            model.addAttribute("staff", staff);
            model.addAttribute("rewardLog", rewardLog);
            return "json/rewardLog/json/rewardLogDetailJson";

        } catch (Exception t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get ranking error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
}

