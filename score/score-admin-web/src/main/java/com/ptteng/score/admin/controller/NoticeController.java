package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Notice;
import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.NoticeService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Notice  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class NoticeController {
    private static final Log log = LogFactory.getLog(NoticeController.class);

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private Gson gson;
    @Autowired
    private CookieUtil cookieUtil;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/enterpriseNotice", method = RequestMethod.GET)
    public String getnoticeList(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, Integer page, Integer size, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:查询企业通知
         */
        log.info("param = page is: " + page + " size is: " + size + " startAt is: " + startAt + " endAt is: " + endAt);
        try {
            //拼接动态条件
            Map<String, Object> map = DynamicSQLUtil.searchNotice(startAt, endAt);
            List<Long> count = noticeService.getIdsByDynamicCondition(Notice.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is: " + count.size());
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询通知实体
            List<Notice> noticeList = noticeService.getObjectsByIds(pageList);
            log.info("get noticeList.size is: " + noticeList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("noticeList", noticeList);
            return "json/notice/json/noticeListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get notice error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("014")
    @RequestMapping(value = "/a/u/enterpriseNotice", method = RequestMethod.POST)
    public String addNotice(HttpServletRequest request,
                            HttpServletResponse response, ModelMap model, @RequestBody String notice)
            throws Exception {
        /**
         *@Description:新增企业日志
         */
        if (DataUtils.isNullOrEmpty(notice)) {
            log.error("参数为空！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get notice is: " + notice);
        try {
            //拼装任务实体
            Notice notice1 = gson.fromJson(notice, Notice.class);
            log.info("参数：notice=" + notice1.getId());
            //插入数据库
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            notice1.setCreateBy(adminId);
            notice1.setUpdateBy(adminId);
            Long insert = noticeService.insert(notice1);
            log.info("add  notice1 id is: " + insert);

            model.addAttribute("code", 0);
            return "data/json";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get notice error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("015")
    @RequestMapping(value = "/a/u/enterpriseNotice", method = RequestMethod.PUT)
    public String updateNoticeJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, @RequestBody String notice)
            throws Exception {
        /**
         *@Description:修改企业日志
         */
        if (DataUtils.isNullOrEmpty(notice)) {

            log.error("参数为空！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get notice is: " + notice);
        try {
            //拼装任务实体
            Notice notice1 = gson.fromJson(notice, Notice.class);
            log.info("参数：notice=" + notice1.getId());
            //插入数据库
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            notice1.setUpdateBy(adminId);
            boolean insert = noticeService.update(notice1);
            if (!insert) {
                model.addAttribute("code", -10000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "data/json";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get notice error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("016")
    @RequestMapping(value = "/a/u/enterpriseNotice", method = RequestMethod.DELETE)
    public String deleteNoticeJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除企业日志
         */

        if (id != null && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        log.info("get id is: " + id);
        try {
            //数组转为list
            List<Long> list = Arrays.asList(id);
            log.info("delete enterpriseNotice : id= " + list.size());
            noticeService.deleteList(Notice.class, list);
            log.info("delete idList is: " + list+" success");
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get notice error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/enterpriseNotice/{id}", method = RequestMethod.GET)
    public String getNoticeJson(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:查询单个企业日志
         */

        if (DataUtils.isNullOrEmpty(id)) {

            log.error("参数为空！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            log.info("get enterpriseNotice : Id= " + id);
            Notice notice = noticeService.getObjectById(id);
            if (notice == null) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            model.addAttribute("notice", notice);
            return "json/notice/json/noticeDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get notice error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

}

