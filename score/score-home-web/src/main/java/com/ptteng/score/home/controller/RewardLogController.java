package com.ptteng.score.home.controller;

import com.google.gson.Gson;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.RewardLog;
import com.ptteng.score.home.model.ScoreLog;
import com.ptteng.score.home.model.Staff;
import com.ptteng.score.home.responseStructure.ResponseInfo;
import com.ptteng.score.home.responseStructure.RewardStructure;
import com.ptteng.score.home.service.RewardLogService;
import com.ptteng.score.home.service.ScoreLogService;
import com.ptteng.score.home.service.StaffService;
import com.qding.common.util.DataUtils;
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

/**
 * RewardLog  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class RewardLogController {
    private static final Log log = LogFactory.getLog(RewardLogController.class);

    @Autowired
    private RewardLogService rewardLogService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreLogService scoreLogService;

    /**
     * @param
     * @return
     */


    @RequestMapping(value = "/a/u/rewardLog/{id}", method = RequestMethod.GET)
    public String getRewardLog(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        /**
         *@Author hfismyangel@163.com
         *@Description:领导表扬接口返回积分
         *@Date: 11:18 2017/9/28
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
        log.info("get id is: " + id);
        try {
            Staff staff = staffService.getObjectById(id);
            if (staff.getCommendScore() == null) {
                staff.setCommendScore(ConstantItem.ZERO);
            }
            model.addAttribute("code", 0);
            model.addAttribute("commendScore", staff.getCommendScore());
            return "json/othersJsp/json/recommendScore";
        } catch (Exception e) {

            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add rewardLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    /**
     *@Author hfismyangel@163.com
     *@Description:领导表扬
     *@Date: 11:18 2017/9/28
     * @param request
     * @param response
     * @param model
     * @param id
     */
    @RequestMapping(value = "/a/u/rewardLog", method = RequestMethod.POST)
    public String getRewardLog(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @RequestBody RewardStructure rewardStructure)
            throws Exception {

        Long id = rewardStructure.getId();
        String title = rewardStructure.getTitle();
        String content = rewardStructure.getContent();
        Integer scoreType = rewardStructure.getScoreType();
        String img = rewardStructure.getImg();
        Long[] rewardId = rewardStructure.getRewardId();
        Integer[] score = rewardStructure.getScore();
        Integer type = rewardStructure.getType();


        log.info("get content is: " + content);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get content is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get content is: " + scoreType);


        try {
            Staff staff = staffService.getObjectById(id);
            if (null == staff.getCommendScore() || staff.getRole() == 0) {
                log.info("not manager！");
                model.addAttribute("code", -105);
                return "common/fail";
            }
            List<Integer> list = Arrays.asList(score);
            int total = 0;
            for (Integer longId : list) {
                total += longId;
            }
            if (DataUtils.isNullOrEmpty(staff)) {
                log.info("get staff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            log.info("get staff is: " + staff.getId());
            if (DataUtils.isNullOrEmpty(staff.getCommendScore())) {
                log.info("get commendScore is null！");
                model.addAttribute("code", -105);
                return "common/fail";
            }
            log.info("get commendScore is: " + staff.getCommendScore());
            if (total > staff.getCommendScore()) {
                model.addAttribute("code", -104);
                return "common/fail";
            }


            staff.setCommendScore(staff.getCommendScore() - total);
            boolean result = staffService.update(staff);
            log.info("update staffId is: " + staff.getId() + " result is: " + result);
            List<Long> longs = Arrays.asList(rewardId);
            List<Staff> objectsByIds = staffService.getObjectsByIds(longs);
            //更新被表扬员工加分情况
            int j = 0;
            for (Staff staff1 : objectsByIds) {
                staff1.setAddScore(staff1.getAddScore() + score[j]);
                staff1.setTotalScore(staff1.getTotalScore() + score[j]);
                j++;
            }
            staffService.updateList(objectsByIds);

            List<RewardLog> logs = new ArrayList<>();
            for (int i = 0; i < rewardId.length; i++) {
                RewardLog rewardLog = new RewardLog();
                rewardLog.setAdminName(staff.getName());
                rewardLog.setAdminPhoto(staff.getImg());
                rewardLog.setCreateBy(id);
                rewardLog.setUpdateBy(id);
                rewardLog.setScoreType(scoreType);
                //新加字段 领导表扬ABC三种类型
                rewardLog.setType(type);
                rewardLog.setImg(img);
                rewardLog.setRewardContent(content);
                rewardLog.setRewardScore(score[i].toString());
                rewardLog.setStaffId(rewardId[i]);
                rewardLog.setRewardTitle(title);
                rewardLog.setRewardRemark("1");
                rewardLog.setScoreType(ConstantItem.LEADER_PRAISE);
                logs.add(rewardLog);
            }
            List<RewardLog> logs1 = rewardLogService.insertList(logs);

            List<Staff> objectsByIds1 = staffService.getObjectsByIds(longs);

            List<ScoreLog> scoreLogs = new ArrayList<>();
            int i = 0;
            for (Staff staff1 : objectsByIds1) {
                ScoreLog scoreLog = new ScoreLog();
                scoreLog.setStaffId(rewardId[i]);
                scoreLog.setScoreChange("+" + score[i].toString());
                scoreLog.setScoreReason("领导表扬");
                scoreLog.setScoreType(ConstantItem.LEADER_PRAISE);
                scoreLog.setCreateBy(rewardId[i]);
                scoreLog.setUpdateBy(rewardId[i]);
                scoreLog.setSpecialId(logs1.get(i).getId());
                scoreLogs.add(scoreLog);

                i++;
            }
            scoreLogService.insertList(scoreLogs);
            model.addAttribute("code", 0);
            return "/data/json";
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("add rewardLog error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


}

