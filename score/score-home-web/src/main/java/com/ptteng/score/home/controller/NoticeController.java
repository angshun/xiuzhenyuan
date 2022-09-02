package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Manager;
import com.ptteng.score.home.model.Notice;
import com.ptteng.score.home.service.ManagerService;
import com.ptteng.score.home.service.NoticeService;
import com.ptteng.score.home.util.DynamicSQLUtil;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    private ManagerService managerService;

    @Autowired
    private CookieUtil cookieUtil;


    @RequestMapping(value = "/a/u/enterpriseNotice", method = RequestMethod.GET)
    public String getnoticeList(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:查询企业通知
         *@Date: 20:50 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param page
         * @param size
         * @param startAt
         * @param endAt
         */

        log.info("get /a/u/enterpriseNotice ");
        try {
            //拼接动态条件
            Map<String, Object> map = DynamicSQLUtil.searchNotice();
            List<Long> count = noticeService.getIdsByDynamicCondition(Notice.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get id is: " + count);

            //查询通知实体
            List<Notice> noticeList = noticeService.getObjectsByIds(count);
            log.info("get List.size is: " + noticeList.size());

            model.addAttribute("code", 0);
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


    @RequestMapping(value = "/a/u/enterpriseNotice/{id}", method = RequestMethod.GET)
    public String getNoticeJson(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Date: 20:50 2017/9/27
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
        try {
            log.info("get enterpriseNotice : Id= " + id);
            Notice notice = noticeService.getObjectById(id);
            if (notice == null) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            Manager manager = managerService.getObjectById(notice.getCreateBy());
            String creator = manager.getName();
            model.addAttribute("code", 0);
            model.addAttribute("creator", creator);
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

