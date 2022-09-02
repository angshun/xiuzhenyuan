package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.Goods;
import com.ptteng.score.home.model.ScoreExchangeApproval;
import com.ptteng.score.home.model.Staff;
import com.ptteng.score.home.service.GoodsService;
import com.ptteng.score.home.service.ScoreExchangeApprovalService;
import com.ptteng.score.home.service.StaffService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreExchangeApprovalService scoreExchangeApprovalService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/goodsList", method = RequestMethod.GET)
    public String getgoodsList(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:积分商城列表及我的积分
         *@Date: 22:05 2017/9/27
         * @param request
         * @param response
         * @param model
         */

        log.info("get /a/u/goodsList :");

        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            List<Long> goodsIds = goodsService.getGoodsIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<Goods> goodsList = goodsService.getObjectsByIds(goodsIds);
            List<Goods> list = new ArrayList<>();
            for (Goods goods : goodsList) {
                if (goods.getNumber() > 0) {
                    list.add(goods);
                }
            }
            Staff staff = staffService.getObjectById(adminId);

            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("totalScore", staff.getTotalScore());


            model.addAttribute("code", 0);
            model.addAttribute("totalScore", objectObjectHashMap);
            model.addAttribute("goodsList", list);
            return "json/othersJsp/json/goodsListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/goodsDetail", method = RequestMethod.GET)
    public String addGoods(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model, Long goodsId, Long staffId)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:单个商品详情
         *@Date: 23:58 2017/9/29
         * @param request
         * @param response
         * @param model
         * @param goods
         */

        if (DataUtils.isNullOrEmpty(goodsId)) {
            log.info("get goodsId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get goodsId is: " + goodsId);
        if (DataUtils.isNullOrEmpty(staffId)) {
            log.info("get staffId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get staffId is: " + staffId);

        try {
            Goods goods = goodsService.getObjectById(goodsId);
            Staff staff = staffService.getObjectById(staffId);
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("totalScore", staff.getTotalScore());
            List list = new ArrayList();
            list.add(goods);

            model.addAttribute("code", 0);
            model.addAttribute("totalScore", objectObjectHashMap);
            model.addAttribute("goodsList", list);
            return "json/othersJsp/json/goodsDetail";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";

        }
    }


    @RequestMapping(value = "/a/u/exchangeLog/{id}", method = RequestMethod.GET)
    public String updateGoodsJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:商品兑换记录
         *@Date: 22:08 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param goods
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            Map<String, Object> map = DynamicSQLUtil.searchScoreExchangeLog(id);
            List<Long> count = scoreExchangeApprovalService.getIdsByDynamicCondition(ScoreExchangeApproval.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<ScoreExchangeApproval> scoreExchangeApprovalList = scoreExchangeApprovalService.getObjectsByIds(count);
            model.addAttribute("code", 0);
            model.addAttribute("scoreExchangeApprovalList", scoreExchangeApprovalList);
            return "json/scoreExchangeApproval/json/scoreExchangeApprovalListJson";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/goodsExchange", method = RequestMethod.PUT)
    public String updateGoodsExchange(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, Long goodsId, Long staffId)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:兑换商品
         *@Date: 22:08 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param goods
         */

        if (DataUtils.isNullOrEmpty(goodsId)) {
            log.info("get goodsId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get goodsId is: " + goodsId);
        if (DataUtils.isNullOrEmpty(staffId)) {
            log.info("get staffId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get staffId is: " + staffId);
        try {
            Goods goods = goodsService.getObjectById(goodsId);
            if (ConstantItem.ZERO == goods.getNumber()) {
                model.addAttribute("code", -101);
                return "common/fail";
            }

            goods.setNumber(goods.getNumber() - ConstantItem.ONE);

            Staff staff = staffService.getObjectById(staffId);
            if (staff.getTotalScore() < goods.getScore()) {
                model.addAttribute("code", -102);
                return "common/fail";
            }
            //减积分
            staff.setSubScore(staff.getSubScore() + goods.getScore());
            staff.setTotalScore(staff.getTotalScore() - goods.getScore());
            staffService.update(staff);


            ScoreExchangeApproval scoreExchangeApproval = new ScoreExchangeApproval();
            scoreExchangeApproval.setExchangeStatus(ConstantItem.TWO);
            scoreExchangeApproval.setGoodsId(goodsId);
            scoreExchangeApproval.setStaffId(staffId);
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            scoreExchangeApproval.setCreateBy(adminId);
            scoreExchangeApproval.setUpdateBy(adminId);
            goodsService.update(goods);
            scoreExchangeApprovalService.insert(scoreExchangeApproval);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -100000);
            return "common/fail";

        }
    }


}

