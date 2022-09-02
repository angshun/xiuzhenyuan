package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.ScoreType;
import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.ScoreTypeService;
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
 * ScoreType  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ScoreTypeController {
    private static final Log log = LogFactory.getLog(ScoreTypeController.class);

    @Autowired
    private ScoreTypeService scoreTypeService;
    @Autowired
    private CookieUtil cookieUtil;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/scoreType", method = RequestMethod.GET)
    public String getScoreTypeList(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Integer page, Integer size, Integer scoreType, Integer project, Long startAt, Long endAt) throws Exception {
        /**
         *@Description:查询积分类型管理
         */
        log.info("=========get scoreType list =========" );

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

        try {
            log.info("page" + page + "size" + size + "tasktype" + scoreType + "project" + project + "startAt" + startAt + "endAt" + endAt);
            Map<String, Object> map = DynamicSQLUtil.searchScoreType(scoreType, project, startAt, endAt);
            List<Long> count = scoreTypeService.getIdsByDynamicCondition(ScoreType.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询积分类型实体
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(pageList);
            log.info("===========size>>" + scoreTypeList.size());

            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("scoreTypeList", scoreTypeList);
            return "json/scoreType/json/scoreTypeListJson";
        } catch (Exception e) {

            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("004")
    @RequestMapping(value = "/a/u/scoreType", method = RequestMethod.POST)
    public String addScoreType(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @RequestBody String scoreType)
            throws Exception {
        /**
         *@Description:添加积分类型
         */
        if (DataUtils.isNullOrEmpty(scoreType)) {
            log.info("get scoreType is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get scoreType is: " + scoreType);
        try {
            ScoreType scoreType1 = GsonUtil.getUnerializeNullsGson().fromJson(scoreType, ScoreType.class);
            log.info("add scoreType" + scoreType1.getId() + " ");
            //添加更新人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            scoreType1.setCreateBy(adminId);
            scoreType1.setUpdateBy(adminId);
            scoreType1.setStatus(ConstantItem.ACHIEVEMENT);
            //添加数据
            Long insert = scoreTypeService.insert(scoreType1);
            if (insert < ConstantItem.ONE) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("005")
    @RequestMapping(value = "/a/u/scoreType", method = RequestMethod.PUT)
    public String updateScoreType(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @RequestBody ScoreType scoreType)
            throws Exception {
        /**
         *@Description:修改积分类型
         */

        if (DataUtils.isNullOrEmpty(scoreType)) {
            log.info("get scoreType is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get scoreType is: " + scoreType);
        try {
            ScoreType scoreType1 = scoreType;
            log.info("update scoreType" + scoreType1.getId() + " ");
            //获取更新人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            scoreType1.setUpdateBy(adminId);
            boolean update = scoreTypeService.update(scoreType1);
            if (!update) {
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("006")
    @RequestMapping(value = "/a/u/scoreType", method = RequestMethod.DELETE)
    public String deleteScoreType(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除积分类型
         */
        try {
            if (id != null && id.length == ConstantItem.ZERO) {
                log.info("get id is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //数组转为list
            List<Long> list = Arrays.asList(id);
            //删除列表
            scoreTypeService.deleteList(ScoreType.class, list);
            log.info("delete scoreType : scoreType id= " + list.size());
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/scoreType/{id}", method = RequestMethod.GET)
    public String getScoreType(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:查询单个积分类型详情
         */
        try {
            log.info("get scoreType : scoreType id= " + id);
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //执行查询
            ScoreType scoreType = scoreTypeService.getObjectById(id);

            if (DataUtils.isNullOrEmpty(scoreType)) {
                log.error("get scoreType is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            model.addAttribute("code", 0);
            model.addAttribute("scoreType", scoreType);
            return "json/scoreType/json/scoreTypeDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreType error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("000")
    @RequestMapping(value = "/a/u/scoreType/status/{id}", method = RequestMethod.PUT)
    public String updateScoreTypeStatus(HttpServletRequest request,
                                        HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:修改任务状态
         */
        try {
            //数组转为list
            log.info("put task status : task= " + id);
            if (null == id) {
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            //修改状态
            ScoreType scoreType = scoreTypeService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(scoreType)) {
                log.error("get scoreList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            if (DataUtils.isNullOrEmpty(scoreType.getStatus())) {
                log.error("get status is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get status is: " + scoreType.getStatus());
            if (scoreType.getStatus() == ConstantItem.STATUS_USE) {
                scoreType.setStatus(ConstantItem.STATUS_CEASE);
            } else {
                scoreType.setStatus(ConstantItem.STATUS_USE);
            }
            //获取修改人
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            scoreType.setUpdateBy(adminId);
            boolean result = scoreTypeService.update(scoreType);
            log.info("update id: " + id + " result is: " + result);
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

