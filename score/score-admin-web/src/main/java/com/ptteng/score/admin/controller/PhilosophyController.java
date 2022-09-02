package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Philosophy;
import com.ptteng.score.admin.model.ScoreType;
import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.PhilosophyService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.GsonUtil;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Philosophy  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class PhilosophyController {
    private static final Log log = LogFactory.getLog(PhilosophyController.class);

    @Autowired
    private PhilosophyService philosophyService;
    @Autowired
    private CookieUtil cookieUtil;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/philosophy", method = RequestMethod.GET)
    public String getphilosophyList(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Integer page, Integer size, Integer project, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:企业哲学列表
         */
        log.info("入参：" + "project" + project + "startAt" + startAt + "endAt" + endAt);
        try {
            Map<String, Object> map = DynamicSQLUtil.searchPhilosophy(project, startAt, endAt);
            List<Long> count = philosophyService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            log.info("get pageList.size is: " + pageList);
            //查询积分类型实体
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(pageList);
            if (DataUtils.isNullOrEmpty(philosophyList)) {
                log.error("get philosophyList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get philosophyList.size is: " + philosophyList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("philosophyList", philosophyList);
            return "json/philosophy/json/philosophyListJson";
        } catch (Throwable t) {

            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get operationLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("008")
    @RequestMapping(value = "/a/u/philosophy", method = RequestMethod.POST)
    public String addPhilosophy(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @RequestBody String philosophy)
            throws Exception {
        /**
         *@Description:添加企业哲学
         */

        if (DataUtils.isNullOrEmpty(philosophy)) {
            log.info("get philosophy is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get philosophy is: " + philosophy);


        try {
            Philosophy philosophy1 = GsonUtil.getUnerializeNullsGson().fromJson(philosophy, Philosophy.class);
            //获取操作人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            philosophy1.setCreateBy(adminId);
            philosophy1.setUpdateBy(adminId);
            philosophy1.setStatus(ConstantItem.ONE);
            philosophy1.setReadNum(ConstantItem.ZERO);
            //插入数据
            Long id = philosophyService.insert(philosophy1);
            log.info("add philosophy1 is: " + id);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("009")
    @RequestMapping(value = "/a/u/philosophy", method = RequestMethod.PUT)
    public String updatePhilosophy(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, @RequestBody Philosophy philosophy)
            throws Exception {
        /**
         *@Description:编辑企业哲学
         */
        if (DataUtils.isNullOrEmpty(philosophy)) {
            log.info("get philosophy is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get philosophy is: " + philosophy);

        try {
            log.info(philosophy);
//            Philosophy philosophy1 = GsonUtil.getUnerializeNullsGson().fromJson(philosophy, Philosophy.class);
            log.info("add philosophy" + philosophy.getId() + " ");
            //插入更新人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            philosophy.setUpdateBy(adminId);
            boolean result = philosophyService.update(philosophy);
            log.info("update id: " +  " result is: " + result);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
    @ControllerAnnotation("010")
    @RequestMapping(value = "/a/u/philosophy", method = RequestMethod.DELETE)
    public String deletePhilosophy(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除企业哲学
         */

        if (id != null && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        try {
            //数组转为list
            List<Long> list = Arrays.asList(id);
            log.info("delete PhilosophyType : id= " + list.size());
            //删除数据
            philosophyService.deleteList(Philosophy.class, list);
            log.info("delete idList is: " + list);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/philosophy/{id}", method = RequestMethod.GET)
    public String getPhilosophyJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:单个企业哲学详情
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        try {
            log.info("get PhilosophyType : id= " + id);
            Philosophy philosophy = philosophyService.getObjectById(id);
            log.info("get philosophy is: " + philosophy.getId());
            if (philosophy == null) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            model.addAttribute("philosophy", philosophy);
            return "json/philosophy/json/philosophyDetailJson";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
    @ControllerAnnotation("000")
    @RequestMapping(value = "/a/u/philosophy/status/{id}", method = RequestMethod.PUT)
    public String updatePhilosophyStatus(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:修改上架状态
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        try {
            log.info("put task status : task= " + id);
            Philosophy philosophy = philosophyService.getObjectById(id);
            log.info("get philsosphy is: " + philosophy);
            if (philosophy.getStatus() == ConstantItem.ONE) {
                philosophy.setStatus(ConstantItem.ZERO);
            } else {
                philosophy.setStatus(ConstantItem.ONE);
            }
            //获取修改人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            philosophy.setUpdateBy(adminId);
            boolean result = philosophyService.update(philosophy);
            log.info("update id: " + philosophy.getId() + " result is: " + result);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add TaskList error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

}

