package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.EnterpriseLog;
import com.ptteng.score.admin.model.RewardLog;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.RewardLogService;
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
 * RewardLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class RewardLogController {
    private static final Log log = LogFactory.getLog(RewardLogController.class);

    @Autowired
    private RewardLogService rewardLogService;
    @Autowired
    private StaffService staffService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/rewardLog", method = RequestMethod.GET)
    public String getrewardLogList(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Integer page, Integer size, String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:管理员表扬日志
         */
        log.info("入参：" + "name" + name + "departmentId" + departmentId + "positionId" + positionId + "startAt" + startAt + "endAt" + endAt);
        try {
            //拼接动态查询条件
            Map<String, Object> map = DynamicSQLUtil.searchRewardLog(name, departmentId, positionId, startAt, endAt);
            List<Long> count = rewardLogService.getIdsByDynamicCondition(RewardLog.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            //分页，page，size判空处理
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());

            List<RewardLog> rewardLogList = rewardLogService.getObjectsByIds(pageList);

            log.info("get rewardLogList.size is: " + rewardLogList.size());

            List<Long> lists = new ArrayList<>();
            Set<Long> set=new HashSet<>();
            log.info("=================="+rewardLogList.size());
            for (RewardLog rewardLog : rewardLogList) {
                set.add(rewardLog.getStaffId());
            }
            lists.addAll(set);
            //查询员工相关信息
            List<Staff> staffList = staffService.getObjectsByIds(lists);
            log.info("get staffList.size is: "+staffList.size());

            List<List> entryList = new ArrayList<>();
            //匹配表扬记录和员工信息
            for (RewardLog rewardLog : rewardLogList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == rewardLog.getStaffId().longValue()) {
                        List<Object> list = new ArrayList<>();
                        list.add(staff);
                        list.add(rewardLog);
                        entryList.add(list);
                    }
                }
            }

            //冒泡排序
            for (int i = 0; i < entryList.size(); i++) {
                for (int j = i; j < entryList.size(); j++) {
                    List list = entryList.get(i);
                    List list1 = entryList.get(j);
                    RewardLog enterpriseLog= (RewardLog) list.get(1);
                    RewardLog enterpriseLog1= (RewardLog) list1.get(1);
                    long createAt1 = enterpriseLog.getCreateAt();
                    long createAt2 = enterpriseLog1.getCreateAt();
                    if (createAt1 < createAt2) {
                        entryList.set(i, list1);
                        entryList.set(j, list);
                    }
                }
            }

            log.info("get lists1.size is: " + entryList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("entryList", entryList);
            return "json/othersJsp/json/rewardLogList";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add rewardLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/rewardLog/{id}", method = RequestMethod.GET)
    public String getRewardLog(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Description:单个管理员表扬日志
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        try {
            RewardLog rewardLog = rewardLogService.getObjectById(id);
            log.info("get rewardLog is: " + rewardLog);

            if (DataUtils.isNullOrEmpty(rewardLog.getStaffId())) {
                log.info("get staffId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Staff staff = staffService.getObjectById(rewardLog.getStaffId());
            if (DataUtils.isNullOrEmpty(staff)) {
                log.error("get staff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staff id: "+staff.getId());
            //员工信息和日志信息加入list列表
            List<Object> list = new ArrayList<>();
            list.add(staff);
            list.add(rewardLog);
            List list1=new ArrayList();
            list1.add(list);
            log.info("get list1.size" + list.size());
            model.addAttribute("code", 0);
            model.addAttribute("entryList", list1);
            return "json/othersJsp/json/rewardLogDetail";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add rewardLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    /**
     * Excel导出所有管理员表扬日志用
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/rewardLogs", method = RequestMethod.GET)
    public String getrewardLogLists(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Description:管理员表扬日志
         */
        try {
            //拼接动态查询条件
            List<Long> count = rewardLogService.getRewardLogIds(0, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            List<RewardLog> rewardLogList = rewardLogService.getObjectsByIds(count);

            log.info("get rewardLogList.size is: " + rewardLogList.size());

            List<Long> lists = new ArrayList<>();
            Set<Long> set=new HashSet<>();
            log.info("=================="+rewardLogList.size());
            for (RewardLog rewardLog : rewardLogList) {
                set.add(rewardLog.getStaffId());
            }
            lists.addAll(set);
            //查询员工相关信息
            List<Staff> staffList = staffService.getObjectsByIds(lists);
            log.info("get staffList.size is: "+staffList.size());

            List<List> entryList = new ArrayList<>();
            //匹配表扬记录和员工信息
            for (RewardLog rewardLog : rewardLogList) {
                for (Staff staff : staffList) {
                    if (staff.getId() == rewardLog.getStaffId().longValue()) {
                        List<Object> list = new ArrayList<>();
                        list.add(staff);
                        list.add(rewardLog);
                        entryList.add(list);
                    }
                }
            }

            //冒泡排序
            for (int i = 0; i < entryList.size(); i++) {
                for (int j = i; j < entryList.size(); j++) {
                    List list = entryList.get(i);
                    List list1 = entryList.get(j);
                    RewardLog enterpriseLog= (RewardLog) list.get(1);
                    RewardLog enterpriseLog1= (RewardLog) list1.get(1);
                    long createAt1 = enterpriseLog.getCreateAt();
                    long createAt2 = enterpriseLog1.getCreateAt();
                    if (createAt1 < createAt2) {
                        entryList.set(i, list1);
                        entryList.set(j, list);
                    }
                }
            }

            log.info("get lists1.size is: " + entryList.size());
            model.addAttribute("code", 0);
            model.addAttribute("total", count.size());
            model.addAttribute("entryList", entryList);
            return "json/othersJsp/json/rewardLogList";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add rewardLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


}

