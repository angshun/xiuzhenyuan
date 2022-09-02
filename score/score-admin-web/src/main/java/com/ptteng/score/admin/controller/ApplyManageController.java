package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.ApplyManage;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.service.ApplyManageService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
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
import java.util.Map;

/**
 * ApplyManage  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ApplyManageController {
    private static final Log log = LogFactory.getLog(ApplyManageController.class);

    @Autowired
    private ApplyManageService applyManageService;

    @Autowired
    private CookieUtil cookieUtil;

    /**
     * 企业日常应用展示
     * 固定10个功能，对应数据库id 1-10
     *
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/applyManage", method = RequestMethod.GET)
    public String getMultiApplyManageJson(HttpServletRequest request,
                                          HttpServletResponse response, ModelMap model)
            throws Exception {

        List<Long> applyManageIdList = null;

        List<ApplyManage> applyManageList = null;

        Map<String, Object> param = null;
        try {
            param = DynamicSQLUtil.getApplyManageList();
            applyManageIdList = applyManageService.getIdsByDynamicCondition(ApplyManage.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get applyManageIdList is: " + applyManageIdList);

            applyManageList = applyManageService.getObjectsByIds(applyManageIdList);
            log.info("get  applyManage.size is " + applyManageList.size());

            if (applyManageList.size() == 0) {
                log.info("get applyManageList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            model.addAttribute("code", 0);
            model.addAttribute("total", applyManageIdList.size());
            model.addAttribute("applyManageList", applyManageList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get applyManage error,id is  ");
            model.addAttribute("code", -100000);
        }

        return "/json/applyManage/json/applyManageListJson";
    }


    /**
     * 1.企业日常应用状态修改
     *
     * @param request
     * @param response
     * @param model
     * @param status
     * @param id
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("040")
    @RequestMapping(value = "/a/u/applyManage", method = RequestMethod.PUT)
    public String updateApplyManageJson(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, Integer status, Long id) throws Exception {

        log.info("update id is: " + id + " status is: " + status);

        if (DataUtils.isNullOrEmpty(status)) {
            log.info("get status is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }


        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {
            ApplyManage applyManage = applyManageService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(applyManage)) {
                log.info("get applyManage is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get applyManageId is: " + applyManage);
            applyManage.setStatus(status);
            applyManage.setUpdateBy(adminId);

            boolean result = applyManageService.update(applyManage);
            log.info("update id is: " + id + " status result: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update applyManage error,id is  " + id);
            model.addAttribute("code", -6003);
            return "common/fail";


        }

        return "/data/json";
    }


    /**
     * 3.企业日常应用修改
     * 页面没有编辑需求，只能postman测
     *
     * @param request
     * @param response
     * @param model
     * @param applyManage
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/applyManageSet", method = RequestMethod.PUT)
    public String updateApplyManageSet(HttpServletRequest request,
                                       HttpServletResponse response, ModelMap model, @RequestBody ApplyManage applyManage) throws Exception {

        if (DataUtils.isNullOrEmpty(applyManage)) {
            log.info("get applyManage is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {
            applyManage.setUpdateBy(adminId);

            boolean result = applyManageService.update(applyManage);
            log.info("update id: " + applyManage.getId() + " result is: " + result);
            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update applyManage error,id is  " + applyManage.getId());
            model.addAttribute("code", -100000);
            return "common/fail";


        }

        return "/data/json";
    }


    @RequestMapping(value = "/a/u/applyManage/{id}", method = RequestMethod.GET)
    public String getApplyManageJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {
            ApplyManage applyManage = applyManageService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(applyManage)) {
                log.info("get applyManage is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get applyManage data is " + applyManage.getId());

            model.addAttribute("code", 0);

            model.addAttribute("applyManage", applyManage);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get applyManage error,id is  " + id);
            model.addAttribute("code", -100000);
        }

        return "/json/applyManage/json/applyManageDetailJson";
    }


}

