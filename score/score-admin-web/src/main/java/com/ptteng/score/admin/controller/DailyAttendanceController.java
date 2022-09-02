package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.DailyAttendance;
import com.ptteng.score.admin.service.DailyAttendanceService;
import com.ptteng.score.admin.util.ControllerAnnotation;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DailyAttendance  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class DailyAttendanceController {
    private static final Log log = LogFactory.getLog(DailyAttendanceController.class);

    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @Autowired
    private CookieUtil cookieUtil;


    /**
     * 1.考勤、爱心、工作日志设置
     *
     * @param request
     * @param response
     * @param model
     * @param dailyAttendance
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("041")
    @RequestMapping(value = "/a/u/dailyAttendance", method = RequestMethod.PUT)
    public String updateDailyAttendanceJson(HttpServletRequest request,
                                            HttpServletResponse response, ModelMap model, @RequestBody DailyAttendance dailyAttendance) throws Exception {


        if (DataUtils.isNullOrEmpty(dailyAttendance)) {
            log.info("get dailyAttendance is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("update dailyAttendance : dailyAttendance= " + dailyAttendance);
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {

            dailyAttendance.setUpdateBy(adminId);
            boolean result = dailyAttendanceService.update(dailyAttendance);
            log.info("update id: " + dailyAttendance.getId() + " result is: " + result);
            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update dailyAttendance error,id is  " + dailyAttendance.getId());
            model.addAttribute("code", -100000);

        }

        return "/data/json";
    }

    /**
     * 2.详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/dailyAttendance/{id}", method = RequestMethod.GET)
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
            if (DataUtils.isNullOrEmpty(dailyAttendance)) {
                log.info("get allTypeScore is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
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




}

