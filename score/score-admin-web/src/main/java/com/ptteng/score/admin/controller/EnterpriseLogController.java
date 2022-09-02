package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.EnterpriseLog;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.EnterpriseLogService;
import com.ptteng.score.admin.service.StaffService;
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
    private StaffService staffService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/enterpriseLog", method = RequestMethod.GET)
    public String getenterpriseLogList(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, Integer page, Integer size, String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:查询企业日志列表
         */
        log.info("入参：" + "name" + name + "departmentId" + departmentId + "positionId" + positionId + "startAt" + startAt + "endAt" + endAt);
        try {
            Map<String, Object> map = DynamicSQLUtil.searchEnterpriseLog(name, departmentId, positionId, startAt, endAt);
            List<Long> count = enterpriseLogService.getIdsByDynamicCondition(EnterpriseLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get conut.size is: " + count.size());

            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            List<EnterpriseLog> enterpriseLogList = enterpriseLogService.getObjectsByIds(pageList);
            log.info("get enterpriseLogList.size is: " + enterpriseLogList.size());
            //取出员工id
            Set<Long> set = new HashSet<>();
            for (EnterpriseLog enterpriseLog : enterpriseLogList) {
                set.add(enterpriseLog.getStaffId());
            }
            List<Long> longs = new ArrayList<>();
            longs.addAll(set);
            //两层for循环匹配日志信息和员工信息
            List<Staff> staffList = staffService.getObjectsByIds(longs);
            log.info("get staffList.size is: " + staffList.size());

            List<List> entryList = new ArrayList<>();
            for (EnterpriseLog enterpriseLog : enterpriseLogList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == enterpriseLog.getStaffId().longValue()) {
                        List<Object> list = new ArrayList<>();
                        list.add(staff);
                        list.add(enterpriseLog);
                        entryList.add(list);
                    }
                }
            }

            //冒泡排序
            for (int i = 0; i < entryList.size(); i++) {
                for (int j = i; j < entryList.size(); j++) {
                    List list = entryList.get(i);
                    List list1 = entryList.get(j);
                    EnterpriseLog enterpriseLog= (EnterpriseLog) list.get(1);
                    EnterpriseLog enterpriseLog1= (EnterpriseLog) list1.get(1);
                    long createAt1 = enterpriseLog.getCreateAt();
                    long createAt2 = enterpriseLog1.getCreateAt();
                    if (createAt1 < createAt2) {
                        entryList.set(i, list1);
                        entryList.set(j, list);
                    }
                }
            }
            log.info("data size:" + entryList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("entryList", entryList);
            return "json/enterpriseLog/json/enterpriseLogListJson";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 5");
            model.addAttribute("code", -100000);
            return "common/fail";

        }
    }


    @RequestMapping(value = "/a/u/enterpriseLog/{id}", method = RequestMethod.GET)
    public String getEnterpriseLog(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Description:查询单个企业详情
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        try {
            //查询日志和员工对象
            EnterpriseLog enterpriseLog = enterpriseLogService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(enterpriseLog)) {
                log.info("get enterpriseLog is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            if (DataUtils.isNullOrEmpty(enterpriseLog.getStaffId())) {
                log.info("get staffId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Staff staff = staffService.getObjectById(enterpriseLog.getStaffId());
            if (DataUtils.isNullOrEmpty(staff)) {
                log.info("get statff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            List<Object> list = new ArrayList<>();
            list.add(staff);
            list.add(enterpriseLog);
            log.info("data size:" + list.size());
            model.addAttribute("code", 0);
            model.addAttribute("entry", list);
            return "json/enterpriseLog/json/enterpriseLogDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseLog error 6");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

}

