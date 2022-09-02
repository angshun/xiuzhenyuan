package com.ptteng.score.home.util;

import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.sleepycat.je.LogScanConfig;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/10/18
 */
@Component
public class AttendanceJudge {

    private static final Log log = LogFactory.getLog(AttendanceJudge.class);

    @Autowired
    private StaffTaskRelationService staffTaskRelationService;
    @Autowired
    private DailyAttendanceService dailyAttendanceService;
    @Autowired
    private AttendanceLogService attendanceLogService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private PhilosophyService philosophyService;
    @Autowired
    private StaffPhilosophyRelationService staffPhilosophyRelationService;

    @Autowired
    private EnterpriseApprovalService enterpriseApprovalService;

    @Autowired
    private ScoreTypeService scoreTypeService;

    @Scheduled(cron = "00 59 23 * * ?")
//    @Scheduled(cron = "00 51 10 * * ?")
    private void timer() {
        //spring timer定时提交任务
        try {
            /**
             * 每日统计缺勤
             */
            long startTime = DateUtil.timeUtil(0, true);
//            long endTime = DateUtil.timeUtil(2, false);
            long endTime = DateUtil.timeUtil(-1);
            Map<String, Object> map = DynamicSQLUtil.searchSingleScdsoreLog(startTime, endTime);

            //查询当天所有考勤记录
            List<Long> idsByDynamicCondition = attendanceLogService.getIdsByDynamicCondition(AttendanceLog.class, map, 0, Integer.MAX_VALUE);
            List<AttendanceLog> objectsByIds = attendanceLogService.getObjectsByIds(idsByDynamicCondition);
            //查询所有员工
            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            log.info("得到所有员工id：" + staffIds);
            List<Long> staffIdList1 = new ArrayList<>();
            //得到所有打过卡员工
            for (AttendanceLog attendanceLog : objectsByIds) {
                staffIdList1.add(attendanceLog.getStaffId());
            }
            log.info("所有打过卡的员工id： " + staffIdList1);
            //过滤未打卡员工
            List<Long> staffIdList = new ArrayList<>();
            for (Long id : staffIds) {
                if (!staffIdList1.contains(id)) {
                    staffIdList.add(id);
                }
            }
            if (staffIdList.size() != 0) {
                log.info("所有未打卡员工id： " + staffIdList);
                List<Staff> staffs = new ArrayList<>();
                //规定时间内未考勤，设为缺勤
                DailyAttendance dailyAttendance = dailyAttendanceService.getObjectById(ConstantItem.CLOCK);
                for (Long id : staffIdList) {
                    AttendanceLog attendanceLog = new AttendanceLog();
                    attendanceLog.setStaffId(id);
                    attendanceLog.setAttendanceStatus(5);
                    attendanceLog.setAttendanceType(0);
                    attendanceLog.setAttendanceAddress("今日缺勤");
                    Long insert = attendanceLogService.insert(attendanceLog);
                    log.info("今日未打卡员工id: " + id);

                    Staff staff = staffService.getObjectById(id);
                    staff.setTotalScore(staff.getTotalScore() - dailyAttendance.getAbsenceScore());
                    staff.setSubScore(staff.getSubScore() + dailyAttendance.getAbsenceScore());
                    staffs.add(staff);

                    ScoreLog scoreLog = new ScoreLog();
                    //积分添加记录
                    scoreLog.setStaffId(staff.getId());
                    scoreLog.setCreateBy(staff.getId());
                    scoreLog.setUpdateBy(staff.getId());
                    scoreLog.setScoreReason(ConstantItem.CLOCKK);
                    scoreLog.setScoreChange("-" + dailyAttendance.getAbsenceScore());
                    scoreLog.setScoreType(ConstantItem.ATTENDANCE);
                    scoreLog.setSpecialId(insert);
                    scoreLogService.insert(scoreLog);
                }
                boolean result = staffService.updateList(staffs);
                log.info("未打卡员工扣分结果：" + result);
            }
            log.info("今日所有员工已打卡");


            /**
             * 刷新每日任务
             */
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            List<Long> list = new ArrayList<>();
            for (StaffTaskRelation relation : taskRelations) {
                if (0 == relation.getTaskType()) {
                    list.add(relation.getId());
                }
            }

            staffTaskRelationService.deleteList(StaffTaskRelation.class, list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每日企业哲学
         */
        try {
            List<Long> philosophyIds = philosophyService.getPhilosophyIds(0, Integer.MAX_VALUE);
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(philosophyIds);

            StringBuilder stringBuilder = new StringBuilder();
            for (Philosophy philosophy : philosophyList) {
                if (0 == philosophy.getProject()) {
                    stringBuilder.append(philosophy.getId());
                    stringBuilder.append(",");
                }
            }
            String string = stringBuilder.toString();
            String substring = string.substring(0, string.length() - 1);
            Map<String, Object> map = DynamicSQLUtil.searchListPhilosophyRelation(substring);
            List<Long> idsByDynamicCondition = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idsByDynamicCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每日积分类型
         */
        try {

            List<Long> enterpriseApprovalIds = enterpriseApprovalService.getEnterpriseApprovalIds(0, Integer.MAX_VALUE);
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);
            List<Long> scoreTypeIds = scoreTypeService.getScoreTypeIds(0, Integer.MAX_VALUE);
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(scoreTypeIds);
            List<Long> longs = new ArrayList<>();


            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (ScoreType s : scoreTypeList) {
                    if (s.getProject() == 0) {
                        if (s.getId().equals(enterpriseApproval.getScoreId())) {
                            longs.add(enterpriseApproval.getId());
                        }
                    }

                }
                enterpriseApprovalService.deleteList(EnterpriseApproval.class, longs);
                log.info("delete Ids is: " + longs);
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
        }
    }

    @Scheduled(cron = "0 0 6 ? * MON")
    private void iniTaskByWeek() {
        /**
         * 刷新每周任务
         */
        try {
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            List<Long> list = new ArrayList<>();
            for (StaffTaskRelation relation : taskRelations) {
                if (1 == relation.getTaskType()) {
                    list.add(relation.getId());
                }
            }
            staffTaskRelationService.deleteList(StaffTaskRelation.class, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 刷新每周企业哲学
         */
        try {
            List<Long> philosophyIds = philosophyService.getPhilosophyIds(0, Integer.MAX_VALUE);
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(philosophyIds);

            StringBuilder stringBuilder = new StringBuilder();
            for (Philosophy philosophy : philosophyList) {
                if (1 == philosophy.getProject()) {
                    stringBuilder.append(philosophy.getId());
                    stringBuilder.append(",");
                }
            }
            String string = stringBuilder.toString();
            String substring = string.substring(0, string.length() - 1);
            Map<String, Object> map = DynamicSQLUtil.searchListPhilosophyRelation(substring);
            List<Long> idsByDynamicCondition = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idsByDynamicCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每周积分类型
         */
        try {

            List<Long> enterpriseApprovalIds = enterpriseApprovalService.getEnterpriseApprovalIds(0, Integer.MAX_VALUE);
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);
            List<Long> scoreTypeIds = scoreTypeService.getScoreTypeIds(0, Integer.MAX_VALUE);
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(scoreTypeIds);
            List<Long> longs = new ArrayList<>();

            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (ScoreType s : scoreTypeList) {
                    if (s.getProject() == 1) {
                        if (s.getId().equals(enterpriseApproval.getScoreId())) {
                            longs.add(enterpriseApproval.getId());
                        }
                    }
                }
                enterpriseApprovalService.deleteList(EnterpriseApproval.class, longs);
                log.info("delete Ids is: " + longs);
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
        }
    }


    @Scheduled(cron = "0 0 1 1 * ?")
    private void iniScore() {
        /**
         * 每月初始化积分
         */
        try {
            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            List<Staff> staffs = staffService.getObjectsByIds(staffIds);
            for (Staff staff : staffs) {
                staff.setCommendScore(staff.getIniCommendScore());
                staff.setIniScore(staff.getIniApproveScore());
            }
            staffService.updateList(staffs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每月任务
         */
        try {
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            List<Long> list = new ArrayList<>();
            for (StaffTaskRelation relation : taskRelations) {
                if (2 == relation.getTaskType()) {
                    list.add(relation.getId());
                }
            }
            staffTaskRelationService.deleteList(StaffTaskRelation.class, list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每月企业哲学
         */
        try {
            List<Long> philosophyIds = philosophyService.getPhilosophyIds(0, Integer.MAX_VALUE);
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(philosophyIds);

            StringBuilder stringBuilder = new StringBuilder();
            for (Philosophy philosophy : philosophyList) {
                if (2 == philosophy.getProject()) {
                    stringBuilder.append(philosophy.getId());
                    stringBuilder.append(",");
                }
            }
            String string = stringBuilder.toString();
            String substring = string.substring(0, string.length() - 1);
            Map<String, Object> map = DynamicSQLUtil.searchListPhilosophyRelation(substring);
            List<Long> idsByDynamicCondition = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idsByDynamicCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每月积分类型
         */
        try {

            List<Long> enterpriseApprovalIds = enterpriseApprovalService.getEnterpriseApprovalIds(0, Integer.MAX_VALUE);
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);
            List<Long> scoreTypeIds = scoreTypeService.getScoreTypeIds(0, Integer.MAX_VALUE);
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(scoreTypeIds);
            List<Long> longs = new ArrayList<>();

            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (ScoreType s : scoreTypeList) {
                    if (s.getProject() == 2) {
                        if (s.getId().equals(enterpriseApproval.getScoreId())) {
                            longs.add(enterpriseApproval.getId());
                        }
                    }
                }
                enterpriseApprovalService.deleteList(EnterpriseApproval.class, longs);
                log.info("delete Ids is: " + longs);
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
        }
    }


    @Scheduled(cron = "0 0 1 1 1/30 ?")
    private void iniTaskBySeason() {
        /**
         * 刷新每季度任务
         */
        try {
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            List<Long> list = new ArrayList<>();
            for (StaffTaskRelation relation : taskRelations) {
                if (3 == relation.getTaskType()) {
                    list.add(relation.getId());
                }
            }
            staffTaskRelationService.deleteList(StaffTaskRelation.class, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 刷新每季度企业哲学
         */
        try {
            List<Long> philosophyIds = philosophyService.getPhilosophyIds(0, Integer.MAX_VALUE);
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(philosophyIds);

            StringBuilder stringBuilder = new StringBuilder();
            for (Philosophy philosophy : philosophyList) {
                if (3 == philosophy.getProject()) {
                    stringBuilder.append(philosophy.getId());
                    stringBuilder.append(",");
                }
            }
            String string = stringBuilder.toString();
            String substring = string.substring(0, string.length() - 1);
            Map<String, Object> map = DynamicSQLUtil.searchListPhilosophyRelation(substring);
            List<Long> idsByDynamicCondition = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idsByDynamicCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每季度积分类型
         */
        try {

            List<Long> enterpriseApprovalIds = enterpriseApprovalService.getEnterpriseApprovalIds(0, Integer.MAX_VALUE);
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);
            List<Long> scoreTypeIds = scoreTypeService.getScoreTypeIds(0, Integer.MAX_VALUE);
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(scoreTypeIds);
            List<Long> longs = new ArrayList<>();

            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (ScoreType s : scoreTypeList) {
                    if (s.getProject() == 3) {
                        if (s.getId().equals(enterpriseApproval.getScoreId())) {
                            longs.add(enterpriseApproval.getId());
                        }
                    }
                }
                enterpriseApprovalService.deleteList(EnterpriseApproval.class, longs);
                log.info("delete Ids is: " + longs);
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
        }
    }


    @Scheduled(cron = "0 0 1 1 1 ?")
    private void addSeniority() {
        /**
         * 每年工龄自增
         */
        try {
            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            List<Staff> staffs = staffService.getObjectsByIds(staffIds);
            for (Staff staff : staffs) {
                staff.setSeniority(staff.getSeniority() + 1);
            }
            staffService.updateList(staffs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每年任务
         */

        try {
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<StaffTaskRelation> taskRelations = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            List<Long> list = new ArrayList<>();
            for (StaffTaskRelation relation : taskRelations) {
                if (4 == relation.getTaskType()) {
                    list.add(relation.getId());
                }
            }
            staffTaskRelationService.deleteList(StaffTaskRelation.class, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 刷新每年企业哲学
         */
        try {
            List<Long> philosophyIds = philosophyService.getPhilosophyIds(0, Integer.MAX_VALUE);
            List<Philosophy> philosophyList = philosophyService.getObjectsByIds(philosophyIds);

            StringBuilder stringBuilder = new StringBuilder();
            for (Philosophy philosophy : philosophyList) {
                if (4 == philosophy.getProject()) {
                    stringBuilder.append(philosophy.getId());
                    stringBuilder.append(",");
                }
            }
            String string = stringBuilder.toString();
            String substring = string.substring(0, string.length() - 1);
            Map<String, Object> map = DynamicSQLUtil.searchListPhilosophyRelation(substring);
            List<Long> idsByDynamicCondition = staffPhilosophyRelationService.getIdsByDynamicCondition(StaffPhilosophyRelation.class, map, 0, Integer.MAX_VALUE);
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idsByDynamicCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 刷新每年积分类型
         */
        try {

            List<Long> enterpriseApprovalIds = enterpriseApprovalService.getEnterpriseApprovalIds(0, Integer.MAX_VALUE);
            List<EnterpriseApproval> enterpriseApprovalList = enterpriseApprovalService.getObjectsByIds(enterpriseApprovalIds);
            List<Long> scoreTypeIds = scoreTypeService.getScoreTypeIds(0, Integer.MAX_VALUE);
            List<ScoreType> scoreTypeList = scoreTypeService.getObjectsByIds(scoreTypeIds);
            List<Long> longs = new ArrayList<>();

            for (EnterpriseApproval enterpriseApproval : enterpriseApprovalList) {
                for (ScoreType s : scoreTypeList) {
                    if (s.getProject() == 4) {
                        if (s.getId().equals(enterpriseApproval.getScoreId())) {
                            longs.add(enterpriseApproval.getId());
                        }
                    }
                }
                enterpriseApprovalService.deleteList(EnterpriseApproval.class, longs);
                log.info("delete Ids is: " + longs);
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add approveLog error ");
        }
    }
}



