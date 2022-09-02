package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.ScoreLog;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.ScoreLogService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.util.resources.cldr.lg.LocaleNames_lg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/scoreLog", method = RequestMethod.GET)
    public String getscoreLogList(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, Integer page, Integer size, String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:员工积分日志
         */
        log.info("=========get scoreLog list =========");

        if (page == null) {
            page = ConstantItem.ONE;
        }
        if (size == null) {
            size = ConstantItem.FIFTY;
        }
        int start = (page - ConstantItem.ONE) * size;
        if (start < ConstantItem.ZERO) {
            start = ConstantItem.ZERO;
        }

        log.info("pageList : page= " + start + " , size=" + size);

        log.info("入参：" + "name" + name + "departmentId" + departmentId + "positionId" + positionId + "startAt" + startAt + "endAt" + endAt);
        try {
            //拼接动态查询条件
            Map<String, Object> map = DynamicSQLUtil.searchScoreLog(name, departmentId, positionId, startAt, endAt);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            //分页，page，size判空处理
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询积分日志相关信息
            List<ScoreLog> scoreLogList = scoreLogService.getObjectsByIds(pageList);

            log.info("get scoreLogList.size is: " + scoreLogList.size());
            List<Long> longs = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (ScoreLog scoreLog : scoreLogList) {
                set.add(scoreLog.getStaffId());
            }
            longs.addAll(set);
            //匹配积分记录和员工信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);

            log.info("get staffList.size is: " + staffList.size());
            List<List> list = new ArrayList<>();
            for (ScoreLog scoreLog : scoreLogList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == scoreLog.getStaffId().longValue()) {
                        List<Object> list1 = new ArrayList<>();
                        list1.add(staff);
                        list1.add(scoreLog);
                        list.add(list1);
                    }
                }
            }
            log.info("get list.size is: " + list.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("entryList", list);
            return "json/othersJsp/json/scoreLog";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("007")
    @RequestMapping(value = "/a/u/scoreLog", method = RequestMethod.DELETE)
    public String getScoreLog(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, Long id)
            throws Exception {
        /**
         *@Description:撤销积分操作
         */

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            log.info("入参：" + id);
            ScoreLog scoreLog = scoreLogService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(scoreLog)) {
                log.error("get scoreLog is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get scoreLogId is: " + scoreLog.getId());
            if (DataUtils.isNullOrEmpty(scoreLog.getScoreChange())) {
                log.error("get scoreChange is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            if (DataUtils.isNullOrEmpty(scoreLog.getStaffId())) {
                log.error("get staffId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get scoreChange is: " + scoreLog.getScoreChange());
            log.info("get staffId is: " + scoreLog.getStaffId());
            String scoreChange = scoreLog.getScoreChange();
            //字符串截取
            String substring = scoreChange.substring(ConstantItem.ZERO, ConstantItem.ONE);
            String substring1 = scoreChange.substring(ConstantItem.ONE, scoreChange.length());
            log.info("subHeader" + substring + "/subTail" + substring1);


            Staff staff = staffService.getObjectById(scoreLog.getStaffId());
            if (DataUtils.isNullOrEmpty(staff)) {
                log.error("get staff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staff is: " + staff.getId());
            //撤销加分操作
            if (substring.equals("+")) {
                //更新员工表三个字段
                staff.setAddScore(staff.getAddScore() - Integer.valueOf(substring1));
                staff.setTotalScore(staff.getTotalScore() - Integer.valueOf(substring1));
                boolean result = staffService.update(staff);
                log.info("update staffId is: " + staff.getId() + " result is: " + result);
                //撤销减分操作
            } else if (substring.equals("-")) {
                //更新员工表三个字段
                staff.setSubScore(staff.getAddScore() - Integer.valueOf(substring1));
                staff.setTotalScore(staff.getTotalScore() + Integer.valueOf(substring1));
                boolean result = staffService.update(staff);
                log.info("udate staffId is: " + staff.getId() + " result is: " + result);
                //字段数据异常
            } else {
                staff.setAddScore(staff.getAddScore() - Integer.valueOf(scoreChange));
                staff.setTotalScore(staff.getTotalScore() - Integer.valueOf(scoreChange));
                boolean result = staffService.update(staff);
            }
            //删除该积分记录
            boolean result = scoreLogService.delete(id);
            log.info("delete id: " + id + " result is: " + result);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    /**
     * Excel导出所有员工积分日志使用
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/scoreLogs", method = RequestMethod.GET)
    public String getscoreLogLists(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Description:员工积分日志
         */
        log.info("=========get scoreLog list =========");


        try {
            //拼接动态查询条件
            List<Long> count = scoreLogService.getScoreLogIds(0, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            //查询积分日志相关信息
            List<ScoreLog> scoreLogList = scoreLogService.getObjectsByIds(count);

            log.info("get scoreLogList.size is: " + scoreLogList.size());
            List<Long> longs = new ArrayList<>();
            Set<Long> set = new HashSet<>();
            for (ScoreLog scoreLog : scoreLogList) {
                set.add(scoreLog.getStaffId());
            }
            longs.addAll(set);
            //匹配积分记录和员工信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);

            log.info("get staffList.size is: " + staffList.size());
            List<List> list = new ArrayList<>();
            for (ScoreLog scoreLog : scoreLogList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == scoreLog.getStaffId().longValue()) {
                        List<Object> list1 = new ArrayList<>();
                        list1.add(staff);
                        list1.add(scoreLog);
                        list.add(list1);
                    }
                }
            }
            log.info("get list.size is: " + list.size());
            model.addAttribute("code", 0);
            model.addAttribute("total", count.size());
            model.addAttribute("entryList", list);
            return "json/othersJsp/json/scoreLog";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }




}

