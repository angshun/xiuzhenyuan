package com.ptteng.score.admin.controller;

import com.google.gson.Gson;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.Goods;
import com.ptteng.score.admin.model.Task;
import com.ptteng.score.admin.responseStructure.ResponseInfo;
import com.ptteng.score.admin.service.GoodsService;
import com.ptteng.score.admin.util.ControllerAnnotation;
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
import java.util.stream.Collectors;

/**
 * Goods  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class GoodsController {
    private static final Log log = LogFactory.getLog(GoodsController.class);

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CookieUtil cookieUtil;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/goods", method = RequestMethod.GET)
    public String getgoodsList(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, Integer page, Integer size) throws Exception {
        /**
         *@Description:查询所有商品
         */

        try {
            log.info("=========page,size>>" + page + "," + size);
            List<Long> count = goodsService.getGoodsIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count.size());

            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询
            List<Goods> goodsList = goodsService.getObjectsByIds(pageList);

            if (goodsList.size() == 0) {
                log.info("get goodsList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get goodsList.size is: " + goodsList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("objectsByIds", goodsList);
            return "json/goods/json/goodsListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("011")
    @RequestMapping(value = "/a/u/goods", method = RequestMethod.POST)
    public String addGoods(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model, @RequestBody String goods)
            throws Exception {
        /**
         *@Description:插入商品
         */
        if (DataUtils.isNullOrEmpty(goods)) {
            log.info("get goods is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get goods is: " + goods);


        try {
            //拼装商品实体
            Goods taskJson = GsonUtil.getUnerializeNullsGson().fromJson(goods, Goods.class);
            log.info("参数：goods="+taskJson.getName());
            //插入数据库
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            taskJson.setCreateBy(adminId);
            taskJson.setUpdateBy(adminId);
            Long insert = goodsService.insert(taskJson);
            log.info("get add taskJson id: " + insert);
            model.addAttribute("code", 0);
            return "data/json";

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("012")
    @RequestMapping(value = "/a/u/goods", method = RequestMethod.PUT)
    public String updateGoodsJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @RequestBody String goods)
            throws Exception {
        /**
         *@Description:编辑商品信息
         */
        if (DataUtils.isNullOrEmpty(goods)) {
            log.info("get goods is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get goods is: " + goods);

        try {
            //拼装商品实体
            Goods taskJson = GsonUtil.getUnerializeNullsGson().fromJson(goods, Goods.class);
            log.info("参数：goods=" + taskJson.getId() + taskJson.getName());
            //插入数据库
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            taskJson.setUpdateBy(adminId);
            boolean result = goodsService.update(taskJson);
            if (!result) {
                model.addAttribute("code", -10000);
                return "common/fail";
            }
            log.info("update id: "+taskJson.getId()+" result is: "+result);
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @ControllerAnnotation("013")
    @RequestMapping(value = "/a/u/goods", method = RequestMethod.DELETE)
    public String deleteeGoodsJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**

         *@Description:删除商品
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
            log.info("delete goods : id= " + list.size());
            goodsService.deleteList(Goods.class, list);
            log.info("delete idList: "+list+" is success");
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/goods/{id}", method = RequestMethod.GET)
    public String getGoodsJson(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Description:单个商品详情
         */

        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get goods : goods id= " + id);
        try {
            Goods goods = goodsService.getObjectById(id);
            if (goods == null) {
                model.addAttribute("code", -10000);
                return "common/fail";
            }
            log.info("get goods is: " + goods);
            model.addAttribute("code", 0);
            model.addAttribute("goods", goods);
            return "json/goods/json/goodsDetailJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
}

