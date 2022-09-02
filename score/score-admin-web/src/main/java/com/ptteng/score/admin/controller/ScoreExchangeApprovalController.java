package com.ptteng.score.admin.controller;

import com.gemantic.common.util.MyListUtil;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.*;
import com.ptteng.score.admin.service.GoodsService;
import com.ptteng.score.admin.service.ScoreExchangeApprovalService;
import com.ptteng.score.admin.service.ScoreLogService;
import com.ptteng.score.admin.service.StaffService;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ScoreExchangeApproval  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ScoreExchangeApprovalController {
    private static final Log log = LogFactory.getLog(ScoreExchangeApprovalController.class);
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreExchangeApprovalService scoreExchangeApprovalService;
    @Autowired
    private ScoreLogService scoreLogService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/scoreAttendance", method = RequestMethod.GET)
    public String getscoreExchangeApprovalList(HttpServletRequest request,
                                               HttpServletResponse response, ModelMap model, Integer page, Integer size) throws Exception {
        /**
         *@Description:积分商品审核列表
         */
        log.info("=========get scoreAttendance list =========");

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

        log.info("pageList : page= " + start + " , size=" + size);

        try {
            log.info("page" + page + "size" + size);
            //拼接查询参数
            Map<String, Object> map = DynamicSQLUtil.searchScoreExchagngeList();
            List<Long> count = scoreExchangeApprovalService.getIdsByDynamicCondition(ScoreExchangeApproval.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Long> pageList = count.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //查询
            List<ScoreExchangeApproval> scoreExchangeApprovalList = scoreExchangeApprovalService.getObjectsByIds(pageList);


            List<Long> staffIds = staffService.getStaffIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIds is: " + staffIds);
            List<Staff> staffList = staffService.getObjectsByIds(staffIds);


            List<Long> goodsIds = goodsService.getGoodsIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get goodsIds is:" + goodsIds);
            List<Goods> goodsList = goodsService.getObjectsByIds(goodsIds);


            Map<Long, String> staffId_alias = MyListUtil.convert2Map(Staff.class.getDeclaredField("id"), Staff.class.getDeclaredField("name"), staffList);
            Map<Long, String> goodsId_alias = MyListUtil.convert2Map(Goods.class.getDeclaredField("id"), Goods.class.getDeclaredField("name"), goodsList);
            Map<Long, String> goodsId_imgs = MyListUtil.convert2Map(Goods.class.getDeclaredField("id"), Goods.class.getDeclaredField("img"), goodsList);


            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());

            model.addAttribute("scoreExchangeApprovalList", scoreExchangeApprovalList);
            model.addAttribute("staffId_alias", staffId_alias);
            model.addAttribute("goodsId_alias", goodsId_alias);
            model.addAttribute("goodsId_imgs", goodsId_imgs);
            return "json/othersJsp/json/goodsList";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add scoreExchangeApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/scoreAttendance", method = RequestMethod.PUT)
    public String updateScoreExchangeList(HttpServletRequest request,
                                          HttpServletResponse response, ModelMap model, Long id, Integer status) throws Exception {
        /**
         *@Description:审核通过/不通过
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(status)) {
            log.info("get status is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        log.info("get status is: " + id);
        try {
            log.info("===========id，status>>" + id + "," + status);
            ScoreExchangeApproval scoreExchangeApproval = scoreExchangeApprovalService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(scoreExchangeApproval)) {
                log.error("get scoreExchangeApproval is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            if (DataUtils.isNullOrEmpty(scoreExchangeApproval.getGoodsId())) {
                log.error("get goodId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            if (DataUtils.isNullOrEmpty(scoreExchangeApproval.getStaffId())) {
                log.error("get staffId is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }


            if (status == ConstantItem.STATUS_PASS) {
                scoreExchangeApproval.setExchangeStatus(ConstantItem.STATUS_PASS);
                Goods goods = goodsService.getObjectById(scoreExchangeApproval.getGoodsId());
                log.info("get goodsId is: " + goods.getId());

                ScoreLog scoreLog = new ScoreLog();
                scoreLog.setStaffId(scoreExchangeApproval.getStaffId());
                scoreLog.setScoreChange("-" + goods.getScore());
                scoreLog.setScoreReason("兑换商品");
                scoreLog.setScoreType(ConstantItem.GOODS_EXCHANGE);
                scoreLog.setSpecialId(id);
                Long scoreLogId = scoreLogService.insert(scoreLog);
                log.info("add scoreLogId is: " + scoreLogId);
                if (DataUtils.isNullOrEmpty(goods.getScore())) {
                    log.error("get score is null！");
                    model.addAttribute("code", -1000);
                    return "common/fail";
                }

            } else if (status == ConstantItem.STATUS_NO_PASS) {
                Staff staff = staffService.getObjectById(scoreExchangeApproval.getStaffId());
                Goods goods = goodsService.getObjectById(scoreExchangeApproval.getGoodsId());

                goods.setNumber(goods.getNumber()+ConstantItem.ONE);
                scoreExchangeApproval.setExchangeStatus(ConstantItem.STATUS_NO_PASS);
                staff.setSubScore(staff.getSubScore() - goods.getScore());
                staff.setTotalScore(staff.getTotalScore() + goods.getScore());
                staffService.update(staff);
                goodsService.update(goods);
            } else {
                log.error("get status invalid");
                model.addAttribute("code", -100000);
                return "common/fail";
            }
            boolean result = scoreExchangeApprovalService.update(scoreExchangeApproval);
            log.info("update scoreEcchangeApprovalId is: " + scoreExchangeApproval.getId() + " result is: " + result);

            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("get enterpriseApproval error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @ControllerAnnotation("017")
    @RequestMapping(value = "/a/u/scoreAttendance", method = RequestMethod.DELETE)
    public String deleteeGoodsJson(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long[] id) throws Exception {
        /**
         *@Description:删除审核
         */

        if (id != null && id.length == 0) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }


        log.info("get id is: " + id);
        try {
            //数组转为list
            List<Long> list = Arrays.asList(id);
            scoreExchangeApprovalService.deleteList(ScoreExchangeApproval.class, list);
            log.info("delete ScoreExchangeApproval : id= " + list.size());
            model.addAttribute("code", 0);
            return "data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add goods error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }

}




