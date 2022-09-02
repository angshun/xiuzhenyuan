package com.ptteng.score.home.controller;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.PhilosophyService;
import com.ptteng.score.home.service.ScoreLogService;
import com.ptteng.score.home.service.StaffPhilosophyRelationService;
import com.ptteng.score.home.service.StaffService;
import com.ptteng.score.home.util.DateUtil;
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
import java.util.*;

import static com.ptteng.score.home.util.DynamicSQLUtil.searchStaffPhilosophyRelation;

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
    @Autowired
    private StaffPhilosophyRelationService staffPhilosophyRelationService;
    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private StaffService staffService;

    /**
     * @param
     * @return
     */

    @RequestMapping(value = "/a/u/philosophyList/{id}", method = RequestMethod.GET)
    public String getphilosophyList(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id) throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:企业哲学列表
         *@Date: 15:43 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param project
         * @param startAt
         * @param endAt
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            Map<String, Object> map1 = DynamicSQLUtil.searchStaffPhilosophy();
            List<Long> philosophyIds = philosophyService.getIdsByDynamicCondition(Philosophy.class, map1, ConstantItem.ZERO, Integer.MAX_VALUE);
            List<Philosophy> philosophies = philosophyService.getObjectsByIds(philosophyIds);
            Map<String, Object> map = searchStaffPhilosophyRelation(id);
            List<Long> count = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);

            List<StaffPhilosophyRelation> staffPhilosophyRelationList = staffPhilosophyRelationService.getObjectsByIds(count);
            List<Philosophy> list = new ArrayList<>();
            for (Philosophy philosophy : philosophies) {
                philosophy.setArticleStatus(ConstantItem.ZERO);
                for (StaffPhilosophyRelation staffPhilosophyRelation : staffPhilosophyRelationList) {
                    if (philosophy.getId() == staffPhilosophyRelation.getPhilosophyId().longValue()) {
                        philosophy.setArticleStatus(ConstantItem.ONE);
                        list.add(philosophy);

                    }
                }
            }
            Set<Philosophy> set = new HashSet<>();
            set.addAll(philosophies);
            set.addAll(list);
            list.clear();
            list.addAll(set);

            //冒泡排序
            for (int i = 0; i < list.size(); i++) {
                for (int j = i; j < list.size(); j++) {
                    Philosophy philosophy = list.get(i);
                    Philosophy philosophy1 = list.get(j);
                    long createAt1 = philosophy.getCreateAt();
                    long createAt2 = philosophy1.getCreateAt();
                    if (createAt1 < createAt2) {
                        list.set(i, philosophy1);
                        list.set(j, philosophy);
                    }
                }
            }

            model.addAttribute("code", 0);
            model.addAttribute("philosophyList", list);
            return "json/philosophy/json/philosophyListJson";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 13");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/philosophy/{id}", method = RequestMethod.GET)
    public String addPhilosophy(HttpServletRequest request,
                                HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:企业哲学详情
         *@Date: 15:54 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param philosophy
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        log.info("get id is: " + id);
        try {
            Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
            Map<String, Object> map = DynamicSQLUtil.searelation(adminId, id);
            List<Long> count = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);

            Philosophy philosophy = philosophyService.getObjectById(id);
            if (count == null || count.size() == ConstantItem.ZERO) {
                philosophy.setArticleStatus(ConstantItem.ZERO);
                model.addAttribute("code", 0);
                model.addAttribute("philosophy", philosophy);
                return "json/philosophy/json/philosophyDetailJson";
            } else {
                philosophy.setArticleStatus(ConstantItem.ONE);
                model.addAttribute("code", 0);
                model.addAttribute("philosophy", philosophy);
                return "json/philosophy/json/philosophyDetailJson";
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 14");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/philosophy", method = RequestMethod.PUT)
    public String updatePhilosophy(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model, Long staffId, Long philosophyId)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:阅读企业哲学
         *@Date: 15:54 2017/9/27
         * @param request
         * @param response
         * @param model
         * @param philosophy
         */
        if (DataUtils.isNullOrEmpty(staffId)) {
            log.info("get staffId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get staffId is: " + philosophyId);
        if (DataUtils.isNullOrEmpty(philosophyId)) {
            log.info("get philosophyId is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + philosophyId);

        Philosophy philosophy = philosophyService.getObjectById(philosophyId);
        Integer project = philosophy.getProject();
        Long time = 0L;
        //申请方式，每年每月每日
        if (null != project) {
            switch (project) {
                case 0:
                    time = DateUtil.timeUtil(0);
                    break;
                case 1:
                    time = DateUtil.timeUtil(7);
                    break;
                case 2:
                    time = DateUtil.getCurrentMonthLastDay();
                    break;
                case 3:
                    time = DateUtil.getQuarterByMonth(false);
                    break;
                case 4:
                    time = DateUtil.getQuarterByMonth(true);
                    break;
                //无限制
                case 5:
                    time = System.currentTimeMillis();
                    break;
                //仅限一次
                case 6:
                    time = 0L;
                    break;
            }
            Map<String, Object> map = DynamicSQLUtil.searchStaffPhilosophyRelationByTime(staffId, philosophyId, time);
            List<Long> count = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            if (count.size() > ConstantItem.ZERO) {
                model.addAttribute("code", -167);
                return "common/fail";
            }
        }
        try {
            philosophy.setReadNum(philosophy.getReadNum() + ConstantItem.ONE);
            boolean result = philosophyService.update(philosophy);
            log.info("update id: " + philosophy.getId() + " result is: " + result);
            StaffPhilosophyRelation staffPhilosophyRelation = new StaffPhilosophyRelation();
            staffPhilosophyRelation.setPhilosophyId(philosophyId);
            staffPhilosophyRelation.setStaffId(staffId);

            Long staffPhilosophyRelationId = staffPhilosophyRelationService.insert(staffPhilosophyRelation);
            if (5 == project) {
                staffPhilosophyRelationService.delete(staffPhilosophyRelationId);
            }
            log.info("add staffPhilosophyRelation is: " + staffPhilosophyRelationId);

            Staff staff = staffService.getObjectById(staffId);
            log.info("get staffId is: " + staff.getId());

            staff.setTotalScore(staff.getTotalScore() + philosophy.getReward());


            staff.setAddScore(staff.getAddScore() + philosophy.getReward());
            boolean resultt = staffService.update(staff);
            log.info("update id: " + staff.getId() + " resultt is: " + resultt);

            ScoreLog scoreLog = new ScoreLog();
            scoreLog.setSpecialId(philosophyId);
            scoreLog.setScoreType(ConstantItem.PHILOSOPHY);
            scoreLog.setScoreReason("阅读"+philosophy.getTitle());
            scoreLog.setScoreChange("+" + philosophy.getReward());
            scoreLog.setStaffId(staffId);
            Long scoreLogId = scoreLogService.insert(scoreLog);
            log.info("add scoreLog id is: " + scoreLogId);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 15");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }
}

