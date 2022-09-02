package com.ptteng.score.admin.controller;

import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Staff;
import com.ptteng.score.admin.model.Star;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.service.StarService;
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
 * Star  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class StarController {
    private static final Log log = LogFactory.getLog(StarController.class);

    @Autowired
    private StarService starService;

    @Autowired
    private StaffService staffService;


    @Autowired
    private CookieUtil cookieUtil;


    /**
     * 1.新增
     *
     * @param request
     * @param response
     * @param model
     * @param star
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("121")
    @RequestMapping(value = "/a/u/star", method = RequestMethod.POST)
    public String addStarJson(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, @RequestBody Star star) throws Exception {

        log.info("add star= " + star);
        if (DataUtils.isNullOrEmpty(star)) {
            log.info("get star is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        Long id = null;

        try {

            star.setCreateBy(adminId);
            star.setUpdateBy(adminId);
            id = starService.insert(star);
            log.info("add star id is: " + id);

            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add star error ");
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/data/json";
    }

    /**
     * 2.删除
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("123")
    @RequestMapping(value = "/a/u/star", method = RequestMethod.DELETE)
    public String deleteStarJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, Long[] id)
            throws Exception {

        if (null == id && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        List<Long> list = Arrays.asList(id);
        log.info("delete star : id= " + list);

        //判断是否有员工使用工龄设置
        List<Star> starList = null;
        List<Long> staffIdList = staffService.getStaffIds(0, Integer.MAX_VALUE);
        log.info("get staffIdList.size is: " + staffIdList);

        List<Staff> staffList = staffService.getObjectsByIds(staffIdList);
        log.info("get staffList.size is: " + staffList.size());
        try {
            starList = starService.getObjectsByIds(list);

            for (Star s : starList) {
                for (Staff st : staffList) {

                    if (st.getIncumbency() == s.getLevel() || st.getStar() == s.getLevel()) {
                        model.addAttribute("code", -7005);
                        return "common/fail";
                    }
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get star error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";
        }


        try {
            starService.deleteList(Star.class, list);
            log.info("delete star success");
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete star error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/data/json";
    }


    /**
     * 3.修改
     *
     * @param request
     * @param response
     * @param model
     * @param star
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("122")
    @RequestMapping(value = "/a/u/star", method = RequestMethod.PUT)
    public String updateStarJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @RequestBody Star star) throws Exception {

        log.info("update star : star= " + star);
        if (DataUtils.isNullOrEmpty(star)) {
            log.info("get star is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        Long adminId = null;

        String userKeyIdentity = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
        if (DataUtils.isNotNullOrEmpty(userKeyIdentity)) {
            adminId = Long.valueOf(userKeyIdentity);

        }

        log.info("get adminId is : " + adminId);

        try {

            star.setUpdateBy(adminId);
            boolean result = starService.update(star);
            log.info("update starId is: " + star.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update star error,id is  " + star.getId());
            model.addAttribute("code", -100000);
            return "common/fail";


        }

        return "/data/json";
    }

    /**
     * 4.详情
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/star/{id}", method = RequestMethod.GET)
    public String getStarJson(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        try {
            Star star = starService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(star)) {
                log.error("get star is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get star data is " + star);

            model.addAttribute("code", 0);

            model.addAttribute("star", star);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get star error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/json/star/json/starDetailJson";
    }

    /**
     * 5.列表
     *
     * @param request
     * @param response
     * @param model
     * @param page
     * @param size
     * @param gradeType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/star", method = RequestMethod.GET)
    public String getMultiStarJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model,
                                   Integer page, Integer size, Integer gradeType)
            throws Exception {
        log.info("param= size is: " + size + " page is: " + page);
        if (page == null || page <= ConstantItem.ZERO) {
            page = ConstantItem.ONE;
        }
        if (size == null || size <= ConstantItem.ZERO) {
            size = ConstantItem.FIFTY;
        }
        int start = (page - ConstantItem.ONE) * size;
        if (start < ConstantItem.ZERO) {
            start = ConstantItem.ZERO;
        }

        List<Long> starIdList = null;

        List<Star> starList = null;

        List<Long> count = null;

        Map<String, Object> param = null;


        try {
            param = DynamicSQLUtil.getStarList(gradeType);

            starIdList = starService.getIdsByDynamicCondition(Star.class, param, start, size);
            log.info("get starIdList is: " + starIdList);

            count = starService.getIdsByDynamicCondition(Star.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count.size is: " + count.size());

            starList = starService.getObjectsByIds(starIdList);
            log.info("get starList.size is: " + starList.size());

            if (starList.size() == 0) {
                log.error("get starList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get starList.size is: " + starList.size());


            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());

            model.addAttribute("starList", starList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get star error,id is  ");
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/json/star/json/starListJson";
    }


    @RequestMapping(value = "/a/multi/star", method = RequestMethod.GET)
    public String getMultiStarJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] ids)
            throws Exception {

        List<Long> idList = new ArrayList();
        if (ids == null) {

        } else {
            idList = Arrays.asList(ids);
        }
        try {


            List<Star> starList = starService.getObjectsByIds(idList);
            log.info("get  star data is " + starList);

            model.addAttribute("code", 0);
            model.addAttribute("total", starList.size());

            model.addAttribute("starList", starList);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get star error,id is  " + idList);
            model.addAttribute("code", -100000);
        }

        return "/score-home-service/star/json/starListJson";
    }


}

