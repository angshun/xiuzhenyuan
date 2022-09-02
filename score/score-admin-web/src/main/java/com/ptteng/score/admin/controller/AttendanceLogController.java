package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.AttendanceLog;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.AttendanceLogService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/attendanceLog", method = RequestMethod.GET)
    public String getattendanceLogList(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, Integer page, Integer size, String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:审批日志列表
         */
        log.info("入参：" + "name" + name + "departmentId" + departmentId + "positionId" + positionId + "startAt" + startAt + "endAt" + endAt);
        try {
            //拼接动态查询条件
            Map<String, Object> map = DynamicSQLUtil.searchAttendanceLog(name, departmentId, positionId, startAt, endAt);
            List<Long> attendancIdList = attendanceLogService.getIdsByDynamicCondition(AttendanceLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get attendancIdList is: " + attendancIdList);

            //分页，page，size判空处理
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = attendancIdList.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询考勤日志相关信息
            List<AttendanceLog> attendancList = attendanceLogService.getObjectsByIds(pageList);
            log.info("get attendancList.size is: " + attendancList.size());

            List<Long> longs = new ArrayList<>();
            Set<Long> set=new HashSet<>();
            for (AttendanceLog scoreLog : attendancList) {
                set.add(scoreLog.getStaffId());
            }
            longs.addAll(set);
            //匹配考勤记录和员工信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);
            log.info("get staffList is: " + staffList.size());


            List<List> list = new ArrayList<>();
            log.info("log size" + attendancList.size() + "staff size" + staffList.size());

            for (AttendanceLog scoreLog : attendancList) {
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
            model.addAttribute("total", attendancIdList.size());
            model.addAttribute("list", list);
            return "json/attendanceLog/json/attendanceLogListJson";


        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get attendanceLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

}

