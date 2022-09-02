package com.ptteng.score.home.controller;

import com.gemantic.common.util.MyListUtil;
import com.gemantic.common.util.MyTimeUtil;
import com.ptteng.score.home.constant.ConstantItem;
import com.ptteng.score.home.model.*;
import com.ptteng.score.home.service.*;
import com.ptteng.score.home.util.DynamicSQLUtil;
import com.ptteng.score.home.util.ScoreHandlerUtil;
import com.qding.common.util.DataUtils;
import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.collections.CollectionUtils;
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

/**
 * Staff  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class StaffController {
    private static final Log log = LogFactory.getLog(StaffController.class);
    @Autowired
    private CopyRelationService copyRelationService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private ScoreLogService scoreLogService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AllTypeScoreService allTypeScoreService;
    @Autowired
    private EnterpriseApprovalService enterpriseApprovalService;
    @Autowired
    private CookieUtil cookieUtil;

    @RequestMapping(value = "/a/u/scoreRank", method = RequestMethod.GET)
    public String getScoreRank(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, Integer time, Integer department, Integer position, Integer type)
            throws Exception {
        /**
         *@Description:动态查询积分榜单
         */

        log.info("get /a/u/scoreRank");
        log.info("param = time is: " + time + " department is: " + department + " position is: " + position + " type is: " + type);
        try {
            Long countTime = 0L;
            switch (time) {
                case 0:
                    countTime = ScoreHandlerUtil.timeUtil(ConstantItem.ZERO);
                    break;
                case 1:
                    countTime = ScoreHandlerUtil.getCurrentMonthLastDay();
                    break;
                case 2:
                    countTime = ScoreHandlerUtil.getQuarterByMonth(false);
                    break;
                case 3:
                    countTime = 0L;
                    break;
                default:
            }


            log.info("get time" + countTime);
            Map<String, Object> map1 = DynamicSQLUtil.searchScoreLog(countTime, type);
            List<Long> count = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map1, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            List<ScoreLog> scoreLogList = scoreLogService.getObjectsByIds(count);
            log.info("get scoreLogList.size is: " + scoreLogList.size());

            Map<String, Object> map2 = DynamicSQLUtil.searchPhilosophy(department, position);
            List<Long> staffIdList = staffService.getIdsByDynamicCondition(Staff.class, map2, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get staffIdList is: " + staffIdList);
            List<Staff> staffList = staffService.getObjectsByIds(staffIdList);
            log.info("get staffList.size is: " + staffList.size());

            List<Staff> list = new ArrayList<>();
            for (Staff staff : staffList) {
                int accumuation = 0;
                if (DataUtils.isNotNullOrEmpty(scoreLogList)) {

                    for (ScoreLog scoreLog : scoreLogList) {

                        Long scoreLogStaffId = scoreLog.getStaffId();
                        if (DataUtils.isNotNullOrEmpty(scoreLogStaffId)) {

                            if (staff.getId() == scoreLogStaffId) {
                                String scoreChangeR = scoreLog.getScoreChange();
                                if (DataUtils.isNotNullOrEmpty(scoreChangeR)) {
                                    accumuation += ScoreHandlerUtil.countScore(scoreChangeR);
                                }
                            }
                        }
                    }
                }

                staff.setSubScore(accumuation);
                list.add(staff);
            }
            if (countTime == ConstantItem.ZERO) {
                Collections.sort(list, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff one, Staff another) {
                        return another.getTotalScore() - one.getTotalScore();
                    }
                });
            } else {
                //根据总积分排序
                Collections.sort(list, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff one, Staff another) {
                        //这个比较器args0-args1就是升序，args1-args0就是降序。
                        return another.getSubScore() - one.getSubScore();
                    }
                });
            }

            List<Map> maps = new ArrayList<>();
            int i = 1;
            for (Staff staff : list) {
                staff.setRanking(i);
                i++;
                Map map = new HashMap();
                map.put("map", staff);
                maps.add(map);
            }
            model.addAttribute("code", 0);
            model.addAttribute("staffList", maps);
            return "json/othersJsp/json/staffListJson";
        } catch (Exception t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get ranking error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    /**
     * @Description:饼形图，没有按月统计
     */
    @RequestMapping(value = "/a/u/scoreCount", method = RequestMethod.GET)
    public String getCountDetail(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, Long id, Integer type, Integer time) {


        Staff staff = null;
        List<Long> scoreLogIds = null;
        List<ScoreLog> scoreLogList = null;
        try {
            staff = staffService.getObjectById(id);
            Map<String, Object> scoreLogParam = DynamicSQLUtil.searchSingleScoreLog(id);

            scoreLogIds = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, scoreLogParam, 0, Integer.MAX_VALUE);
            scoreLogList = scoreLogService.getObjectsByIds(scoreLogIds);

            List<Long> createAtList = MyListUtil.getFieldValueListFromModelList(scoreLogList, true, ScoreLog.class.getDeclaredField("createAt"));

            List<Date> dateList = new ArrayList<>();

            for (Long createAt : createAtList) {

                dateList.add(MyTimeUtil.convertLong2Date(createAt));

            }


        } catch (Exception t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get ranking error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(scoreLogIds)) {
            log.error("no score operation log ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        if (ConstantItem.ZERO == type) {
            List<ScoreLog> scoreLogList1 = null;
            Long createTime = 0L;
            try {
                switch (time) {
                    case 0:
                        createTime = ScoreHandlerUtil.timeUtil(ConstantItem.ZERO);
                        break;
                    case 1:
                        createTime = ScoreHandlerUtil.getCurrentMonthLastDay();
                        break;
                    case 2:
                        createTime = ScoreHandlerUtil.getQuarterByMonth(false);
                        break;
                    case 3:
                        createTime = ConstantItem.ZEROL;
                        break;
                    default:
                }
                Map<String, Object> map2 = DynamicSQLUtil.searchSinglenewScoreLog(id, createTime);
                List<Long> scoreLogIdList = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, map2, ConstantItem.ZERO, Integer.MAX_VALUE);
                log.info("get scoreList size:" + scoreLogIdList.size());
                scoreLogList1 = scoreLogService.getObjectsByIds(scoreLogIdList);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //初始化积分类型
            int scoreA = 0;
            int scoreB = 0;
            int scoreC = 0;
            int baseScore = staff.getBaseScore();
            int approveScore = 0;

            for (ScoreLog scoreLog : scoreLogList1) {
                Integer scoreType = scoreLog.getScoreType();
                String scoreChange = scoreLog.getScoreChange();
                switch (scoreType) {
                    case 0:
                        scoreA += ScoreHandlerUtil.countScore(scoreChange);
                        break;
                    case 1:
                        scoreB += ScoreHandlerUtil.countScore(scoreChange);
                        break;
                    case 2:
                        scoreC += ScoreHandlerUtil.countScore(scoreChange);
                        break;
                    case 6:
                        approveScore += ScoreHandlerUtil.countScore(scoreChange);
                        break;
                    default:
                }
            }

            model.addAttribute("code", 0);
            model.addAttribute("scoreA", scoreA);
            model.addAttribute("scoreB", scoreB);
            model.addAttribute("scoreC", scoreC);
            model.addAttribute("baseScore", baseScore);
            model.addAttribute("approveScore", approveScore);
            return "json/othersJsp/json/scoreCount";
        }

        if (type == ConstantItem.ONE) {

            //初始化积分时限
            int monthAdd = 0;
            int monthSub = 0;
            int quarterAdd = 0;
            int quarterSub = 0;
            int yearAdd = 0;
            int yearSub = 0;
            int dayAdd = 0;
            int daySub = 0;

            for (ScoreLog scoreLog : scoreLogList) {
                Long createAt = scoreLog.getCreateAt();
                String scoreChange = scoreLog.getScoreChange();
                //本日
                if (ScoreHandlerUtil.timeUtil(0) < createAt && createAt < ScoreHandlerUtil.timeUtil(ConstantItem.MINUS_ONE)) {
                    dayAdd += ScoreHandlerUtil.countScore(scoreChange, true);
                    daySub += ScoreHandlerUtil.countScore(scoreChange, false);
                }
                //本月
                if (ScoreHandlerUtil.getCurrentMonthLastDay() < createAt) {
                    monthAdd += ScoreHandlerUtil.countScore(scoreChange, true);
                    monthSub += ScoreHandlerUtil.countScore(scoreChange, false);
                }
                //本季度
                if (ScoreHandlerUtil.getQuarterByMonth(false) < createAt) {
                    quarterAdd += ScoreHandlerUtil.countScore(scoreChange, true);
                    quarterSub += ScoreHandlerUtil.countScore(scoreChange, false);
                }
                //本年
                if (ScoreHandlerUtil.getQuarterByMonth(true) < createAt) {
                    yearAdd += ScoreHandlerUtil.countScore(scoreChange, true);
                    yearSub += ScoreHandlerUtil.countScore(scoreChange, false);
                    //管理员表扬积分
                }
            }


            model.addAttribute("code", 0);
            model.addAttribute("dayAdd", dayAdd);
            model.addAttribute("daySub", daySub);
            model.addAttribute("monthAdd", monthAdd);
            model.addAttribute("monthSub", monthSub);
            model.addAttribute("quarterAdd", quarterAdd);
            model.addAttribute("quarterSub", quarterSub);
            model.addAttribute("yearAdd", yearAdd);
            model.addAttribute("yearSub", yearSub);
            return "json/othersJsp/json/scoreCountByTime";
        } else {
            log.error("no score operation log ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }


    @RequestMapping(value = "/a/u/organize/{id}", method = RequestMethod.GET)
    public String getPersonDetail(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @PathVariable Long id) {
        /**
         *@Description:根据部门id查询旗下员工
         *
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);

        List<Long> longList = null;
        try {

            Map<String, Object> map = DynamicSQLUtil.searchStaffByDepartment(id);
            longList = staffService.getIdsByDynamicCondition(Staff.class, map, 0, Integer.MAX_VALUE);
            List<Staff> staffList = staffService.getObjectsByIds(longList);

            model.addAttribute("code", 0);
            model.addAttribute("staffList", staffList);
            return "json/staff/json/staffListJson";
        } catch (Exception t) {
            t.getMessage();
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/detail", method = RequestMethod.GET)
    public String getDetail(HttpServletRequest request,
                            HttpServletResponse response, ModelMap model, Long id) {
        /**
         *@Description:员工详情
         *
         */
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        try {
            Staff staff = staffService.getObjectById(id);
            log.info("get staff:" + staff);
            if (staff == null) {
                throw new Exception("no data");
            }
            model.addAttribute("code", 0);
            model.addAttribute("staff", staff);
            return "json/staff/json/staffDetailJson";
        } catch (Exception t) {
            t.getMessage();
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/department", method = RequestMethod.GET)
    public String getAllDepartment(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Description:回返所有部门
         */
        List<Department> departmentList = null;
        try {
            List<Long> departmentIds = departmentService.getDepartmentIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            departmentList = departmentService.getObjectsByIds(departmentIds);
            log.info("get list size:" + departmentIds.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 10");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        model.addAttribute("code", 0);
        model.addAttribute("departmentList", departmentList);
        return "json/othersJsp/json/allDepartment";
    }

    @RequestMapping(value = "/a/u/position", method = RequestMethod.GET)
    public String getAllPosition(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Description:回返所有职位
         */
        log.info("get /a/u/position");
        Map<String, Object> map1 = DynamicSQLUtil.searchAllPosition();
        List<AllTypeScore> allTypeScoreList = null;
        try {
            List<Long> count = allTypeScoreService.getIdsByDynamicCondition(AllTypeScore.class, map1, 0, Integer.MAX_VALUE);
            allTypeScoreList = allTypeScoreService.getObjectsByIds(count);

            log.info("get list size:" + count.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get philosophy error 11");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        model.addAttribute("code", 0);
        model.addAttribute("positionList", allTypeScoreList);
        return "json/othersJsp/json/allPosition";
    }

    /**
     *@Description:回返所有员工
     */
    @RequestMapping(value = "/a/u/staff", method = RequestMethod.GET)
    public String getPersonPosition(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model) throws Exception {

        log.info("get /a/u/staff :");
        List<Staff> staffList;
        try {
            List<Long> staffIds = staffService.getStaffIds(0, Integer.MAX_VALUE);
            staffList = staffService.getObjectsByIds(staffIds);
            Collections.sort(staffList, new Comparator<Staff>() {
                @Override
                public int compare(Staff one, Staff another) {
                    return another.getStar() - one.getStar();
                }
            });

            log.info("get list size:" + staffIds.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get all staff error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        model.addAttribute("code", 0);
        model.addAttribute("staffList", staffList);
        return "json/othersJsp/json/staffList";
    }


    @RequestMapping(value = "/a/u/staffimg/{id}", method = RequestMethod.PUT)
    public String getStaffImg(HttpServletResponse response, HttpServletRequest request, ModelMap model, @PathVariable Long id,
                              String img) throws Exception {
        /**
         *@Description:更改头像
         */
        log.info("change user img ");
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get id is: " + id);
        Staff staff = null;
        try {
            staff = staffService.getObjectById(id);
            staff.setImg(img);
            staffService.update(staff);

        } catch (Throwable t) {
            t.getMessage();
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update staff error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
        model.addAttribute("code", 0);
        return "data/json";
    }

    /**
     *@Description:工作台审批日志、待我审批、我发起的、抄送我的
     */
    @RequestMapping(value = "/a/u/staff/work", method = RequestMethod.GET)
    public String getStaff(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model) throws Exception {

        try {
            String keyIdentity = cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID);
            Long id = Long.valueOf(keyIdentity);
            log.info("get adminId is : " + id);
            //审批日志
            Map<String, Object> map = DynamicSQLUtil.searchEnterpriseApproval(id);
            List<Long> approvalLogNum = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map, 0, Integer.MAX_VALUE);
            //待我审批
            Map<String, Object> map1 = DynamicSQLUtil.searchWaitEnterpriseApproval(id);
            List<Long> waitApprovalNum = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map1, 0, Integer.MAX_VALUE);
            //我发起的
            Map<String, Object> map2 = DynamicSQLUtil.searchMyEnterpriseApproval(id);
            List<Long> myApprovalNum = enterpriseApprovalService.getIdsByDynamicCondition(ScoreType.class, map2, 0, Integer.MAX_VALUE);
            //我的抄送
            Map<String, Object> map3 = DynamicSQLUtil.searchCopyEnterpriseApproval(id);
            List<Long> myCopyNum = copyRelationService.getIdsByDynamicCondition(ScoreType.class, map3, 0, Integer.MAX_VALUE);


            Staff staff = staffService.getObjectById(id);
            staff.setApprovalLogNum(approvalLogNum.size());
            staff.setWaitApprovalNum(waitApprovalNum.size());
            staff.setMyApprovalNum(myApprovalNum.size());
            staff.setMyCopyNum(myCopyNum.size());
            staffService.update(staff);


            log.info("get four number is:" + approvalLogNum.size() + "---" + waitApprovalNum.size() + "---" + myApprovalNum.size() + "----" + myCopyNum.size());
            model.addAttribute("code", 0);
            model.addAttribute("staff", staff);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("注销重新登录");
            model.addAttribute("code", -100001);
            return "common/fail";
        }
        return "/json/staff/json/work";
    }


    // 修改密码
    @RequestMapping(value = "/a/password/change", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request, HttpServletResponse response, String phone, String oldPwd, String newPwd, ModelMap model) {


        if (DataUtils.isNullOrEmpty(oldPwd) || DataUtils.isNullOrEmpty(newPwd)) {
            model.addAttribute("code", -2005);
            return "/common/success";
        }

        if (DataUtils.isNullOrEmpty(phone)) {
            model.addAttribute("code", -5023);
            return "/common/success";
        }


        Map<String, Object> loginParam = DynamicSQLUtil.getLogin(phone);

        try {
            List<Long> staffList = staffService.getIdsByDynamicCondition(Staff.class, loginParam, 0, Integer.MAX_VALUE);
            if (CollectionUtils.isEmpty(staffList)) {
                // 手机号不存在
                model.addAttribute("code", -5024);
                return "/common/success";
            }
            Long staffId = staffList.get(0);

            Staff staff = staffService.getObjectById(staffId);
            if (DataUtils.isNullOrEmpty(staff)) {
                // 用户不存在
                model.addAttribute("code", -5003);
                return "/common/success";
            }

            if (oldPwd.equals(staff.getPwd())) {

                staff.setPwd(newPwd);
                boolean result = staffService.update(staff);
                log.info("update pwd result is: " + result);
                model.addAttribute("code", 0);

            } else {
                model.addAttribute("code", -2004);
            }


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            model.addAttribute("code", -100001);
            return "common/fail";
        }


        return "/common/success";
    }


}

