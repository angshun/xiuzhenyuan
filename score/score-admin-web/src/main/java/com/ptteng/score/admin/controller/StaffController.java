package com.ptteng.score.admin.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.score.admin.constant.ConstantItem;
import com.ptteng.score.admin.model.*;
import com.ptteng.score.admin.service.*;
import com.ptteng.score.admin.util.ControllerAnnotation;
import com.ptteng.score.admin.util.DynamicSQLUtil;
import com.ptteng.score.admin.util.PageUtil;
import com.ptteng.score.admin.util.ScoreHandlerUtil;
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
import java.util.*;
import java.util.stream.Collectors;

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
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AllTypeScoreService allTypeScoreService;

    @Autowired
    private StarService starService;

    @Autowired
    private StaffTaskRelationService staffTaskRelationService;

    @Autowired
    private StaffPhilosophyRelationService staffPhilosophyRelationService;

    @Autowired
    private ScoreLogService scoreLogService;

    @Autowired
    private ScoreExchangeApprovalService scoreExchangeApprovalService;

    @Autowired
    private RewardLogService rewardLogService;

    @Autowired
    private EnterpriseLogService enterpriseLogService;

    @Autowired
    private AttendanceLogService attendanceLogService;

    @Autowired
    private CookieUtil cookieUtil;

    /**
     * 1.新增
     *
     * @param request
     * @param response
     * @param model
     * @param staff
     * @return
     * @throws Exception
     */
    @ControllerAnnotation("110")
    @RequestMapping(value = "/a/u/staff", method = RequestMethod.POST)
    public String addStaffJson(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @RequestBody Staff staff) throws Exception {

        if (null == staff) {
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        log.info("get staff:" + staff);
        //判断手机号是否重复
        Map<String, Object> phoneParam = DynamicSQLUtil.getPhoneList(staff.getPhone());
        List<Long> phoneIdList = null;
        try {
            phoneIdList = staffService.getIdsByDynamicCondition(Staff.class, phoneParam, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get phoneIdList.size is :" + phoneIdList.size());
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("查询员工手机号错误 ！");
            model.addAttribute("code", -5026);
            return "common/fail";

        }

        if (phoneIdList.size() != 0) {
            model.addAttribute("code", -5021);
            return "common/fail";
        }

        log.info("add staff:  " + staff);
        if (DataUtils.isNullOrEmpty(staff)) {
            log.info("get staff is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        //基础积分
        int baseScore = staff.getPositionScore();
        Long starId = staff.getStarId();


        if (DataUtils.isNotNullOrEmpty(staff.getEntryAt())) {
            //获得工龄
            Long newTime = System.currentTimeMillis();
            staff.setSeniority((int) ((newTime - staff.getEntryAt()) / ConstantItem.YEAR));

            //获得工龄积分
            Integer level = staff.getSeniority();
            Integer gradeType = ConstantItem.STAR;
            int seniorityScore = ConstantItem.SENIORITY;

            Map<String, Object> starParam = DynamicSQLUtil.getStarScoreList(level, gradeType);
            try {
                List<Long> starIdList = starService.getIdsByDynamicCondition(Star.class, starParam, 0, Integer.MAX_VALUE);
                log.info("get starIdList is: " + starIdList);

                Star star = starService.getObjectById(starIdList.get(0));
                log.info("get ================================= star is: " + star);

                seniorityScore = star.getScore();

                log.info("seniorityScore score is " + seniorityScore);
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("获取工龄积分错误 ！");
                model.addAttribute("code", -5025);
                return "common/fail";
            }


            staff.setSeniorityScore(seniorityScore);

            log.info("baseScore before sernority score" + baseScore);
            baseScore += seniorityScore;
            log.info("baseScore after sernority score" + baseScore);

            log.info("seniority score is : " + seniorityScore);

        }

        if (DataUtils.isNotNullOrEmpty(staff.getStarScore())) {

            log.info("IS NULL OR EMPTY star score is " + staff.getStarScore());
            baseScore += staff.getStarScore();
        }
        if (DataUtils.isNullOrEmpty(staff.getStarScore())) {
            staff.setStarScore(ConstantItem.ZERO);
        }
        if (DataUtils.isNullOrEmpty(staff.getDegreeScore())) {
            staff.setDegreeScore(ConstantItem.ZERO);
        }
        if (DataUtils.isNotNullOrEmpty(staff.getDegreeScore())) {
            baseScore += staff.getDegreeScore();
        }
        if (DataUtils.isNullOrEmpty(staff.getHonorScore())) {
            staff.setHonorScore(ConstantItem.ZERO);
        }
        if (DataUtils.isNotNullOrEmpty(staff.getHonorScore())) {
            baseScore += staff.getHonorScore();
        }
        if (DataUtils.isNotNullOrEmpty(staff.getJopScore())) {
            baseScore += staff.getJopScore();
        }
        if (DataUtils.isNullOrEmpty(staff.getJopScore())) {
            staff.setJopScore(ConstantItem.ZERO);
        }
        if (DataUtils.isNotNullOrEmpty(staff.getSpecialityScore())) {
            baseScore += staff.getSpecialityScore();
        }
        if (DataUtils.isNullOrEmpty(staff.getSpecialityScore())) {
            staff.setSpecialityScore(ConstantItem.ZERO);
        }
        if (DataUtils.isNullOrEmpty(staff.getStarId())) {
            staff.setStarId(ConstantItem.ZERO_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getDegreeId())) {
            staff.setDegreeId(ConstantItem.ZERO_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getHonorId())) {
            staff.setHonorId(ConstantItem.ZERO_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getJopId())) {
            staff.setJopId(ConstantItem.ZERO_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getSpecialityId())) {
            staff.setSpecialityId(ConstantItem.ZERO_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getStar())) {
            staff.setStar(ConstantItem.ZERO);
        }
        if (DataUtils.isNullOrEmpty(staff.getDepartmentId())) {
            staff.setDepartmentId(ConstantItem.MINUS_ID);
        }
        if (DataUtils.isNullOrEmpty(staff.getSeniority())) {
            staff.setSeniority(ConstantItem.ZERO);
        }
        if (DataUtils.isNullOrEmpty(staff.getMyCopyNum())) {
            staff.setMyCopyNum(ConstantItem.ZERO);
        }
        staff.setApprovalLogNum(ConstantItem.ZERO);
        staff.setMyCopyNum(ConstantItem.ZERO);
        staff.setMyApprovalNum(ConstantItem.ZERO);
        staff.setWaitApprovalNum(ConstantItem.ZERO);

        staff.setBaseScore(baseScore);
        log.info("get baseScore is: " + baseScore);
        //总积分
        staff.setTotalScore(baseScore);
        log.info("get totalScore is: " + staff.getTotalScore());


        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        Long id = null;
        try {

            staff.setSubScore(ConstantItem.ZERO);
            staff.setUpdateBy(adminId);
            staff.setCreateBy(adminId);
            staff.setIncumbency(ConstantItem.INCUMBERCY);
            staff.setJoinRank(ConstantItem.PARTICIPATE);
            staff.setRanking(ConstantItem.ZERO);
            staff.setAddScore(ConstantItem.ZERO);
            staff.setLoveScore(ConstantItem.ZERO);
            staff.setIniCommendScore(staff.getCommendScore());
            staff.setIniApproveScore(staff.getIniScore());
            staff.setSunScore(ConstantItem.ZERO);
            id = staffService.insert(staff);
            log.info("insert staff id is: " + id);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add staff error ");
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
    @ControllerAnnotation("112")
    @RequestMapping(value = "/a/u/staff", method = RequestMethod.DELETE)
    public String deleteStaffJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, Long[] id)
            throws Exception {
        if (id != null && id.length == ConstantItem.ZERO) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        log.info("delete staff id: " + id);
        List<Long> list = Arrays.asList(id);
        try {

            List<Long> idList = new ArrayList<>();


            //员工任务关系表
            List<Long> staffTaskRelationIds = staffTaskRelationService.getStaffTaskRelationIds(0, Integer.MAX_VALUE);
            List<StaffTaskRelation> staffTaskRelationList = staffTaskRelationService.getObjectsByIds(staffTaskRelationIds);
            for (StaffTaskRelation taskRelation : staffTaskRelationList) {
                for (Long l : list) {
                    if (taskRelation.getStaffId() == l.longValue()) {
                        idList.add(taskRelation.getId());
                    }
                }
            }
            staffTaskRelationService.deleteList(StaffTaskRelation.class, idList);
            log.info("delete taskRelation idList is: " + idList);
            idList.clear();


            //员工阅读关系表
            List<Long> staffPhilosophyRelationIds = staffPhilosophyRelationService.getStaffPhilosophyRelationIds(0, Integer.MAX_VALUE);
            List<StaffPhilosophyRelation> staffPhilosophyRelationList = staffPhilosophyRelationService.getObjectsByIds(staffPhilosophyRelationIds);
            for (StaffPhilosophyRelation philosophyRelation : staffPhilosophyRelationList) {
                for (Long l : list) {
                    if (philosophyRelation.getStaffId() == l.longValue()) {
                        idList.add(philosophyRelation.getId());
                    }
                }
            }
            staffPhilosophyRelationService.deleteList(StaffPhilosophyRelation.class, idList);
            log.info("delete StaffPhilosophyRelation idList is: " + idList);
            idList.clear();


            //积分日志表
            List<Long> scoreLogIds = scoreLogService.getScoreLogIds(0, Integer.MAX_VALUE);
            List<ScoreLog> scoreLogList = scoreLogService.getObjectsByIds(scoreLogIds);
            for (ScoreLog scoreLog : scoreLogList) {
                for (Long l : list) {
                    if (scoreLog.getStaffId() == l.longValue()) {
                        idList.add(scoreLog.getId());
                    }
                }
            }
            scoreLogService.deleteList(ScoreLog.class, idList);
            log.info("delete scoreLog idList is: " + idList);
            idList.clear();

            //积分兑换审核
            List<Long> scoreExchangeApprovalIds = scoreExchangeApprovalService.getScoreExchangeApprovalIds(0, Integer.MAX_VALUE);
            List<ScoreExchangeApproval> scoreExchangeApprovalList = scoreExchangeApprovalService.getObjectsByIds(scoreExchangeApprovalIds);
            for (ScoreExchangeApproval scoreExchangeApproval : scoreExchangeApprovalList) {
                for (Long l : list) {
                    if (scoreExchangeApproval.getStaffId() == l.longValue()) {
                        idList.add(scoreExchangeApproval.getId());
                    }
                }
            }
            scoreExchangeApprovalService.deleteList(ScoreExchangeApproval.class, idList);
            log.info("delete scoreExchangeApproval idList is: " + idList);
            idList.clear();

            //管理员表扬日志
            List<Long> rewardLogIds = rewardLogService.getRewardLogIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<RewardLog> rewardLogList = rewardLogService.getObjectsByIds(rewardLogIds);
            for (RewardLog rewardLog : rewardLogList) {
                for (Long l : list) {
                    if (rewardLog.getStaffId() == l.longValue()) {
                        idList.add(rewardLog.getId());
                    }
                }
            }
            rewardLogService.deleteList(RewardLog.class, idList);
            log.info("delete rewardLog idList is: " + idList);
            idList.clear();

            //企业日志
            List<Long> enterpriseLogIds = enterpriseLogService.getEnterpriseLogIds(0, Integer.MAX_VALUE);
            List<EnterpriseLog> enterpriseLogList = enterpriseLogService.getObjectsByIds(enterpriseLogIds);
            for (EnterpriseLog enterpriseLog : enterpriseLogList) {
                for (Long l : list) {
                    if (enterpriseLog.getStaffId() == l.longValue()) {
                        idList.add(enterpriseLog.getId());
                    }
                }
            }
            enterpriseLogService.deleteList(EnterpriseLog.class, idList);
            log.info("delete enterpriseLog idList is: " + idList);
            idList.clear();

            //考勤记录管理
            List<Long> attendanceLogIds = attendanceLogService.getAttendanceLogIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            List<AttendanceLog> attendanceLogList = attendanceLogService.getObjectsByIds(attendanceLogIds);
            for (AttendanceLog attendanceLog : attendanceLogList) {
                for (Long l : list) {
                    if (attendanceLog.getStaffId() == l.longValue()) {
                        idList.add(attendanceLog.getId());
                    }
                }
            }
            attendanceLogService.deleteList(AttendanceLog.class, idList);
            log.info("delete attendanceLog idList is: " + idList);
            idList.clear();


            staffService.deleteList(Staff.class, list);
            log.info("delete staff id: " + list);
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete staff error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";


        }

        return "/data/json";
    }


    public Integer getScoreChangeForUser(Long staffId) throws ServiceException, ServiceDaoException {


        // 统计积分历史积分增减
        Map<String, Object> scoreLogParam = DynamicSQLUtil.getScoreLogByStaffId(staffId);
        List<Long> scoreLogIds = null;
        scoreLogIds = scoreLogService.getIdsByDynamicCondition(ScoreLog.class, scoreLogParam, 0, Integer.MAX_VALUE);
        List<ScoreLog> scoreLogs = scoreLogService.getObjectsByIds(scoreLogIds);
        int scoreChange = 0;

        for (ScoreLog scoreLog : scoreLogs) {
            String scoreChangeR = scoreLog.getScoreChange();
            if (DataUtils.isNotNullOrEmpty(scoreChangeR)) {
                scoreChange += ScoreHandlerUtil.countScore(scoreChangeR);
            }
        }
        return scoreChange;

    }


    /**
     * 3.修改
     *
     * @param request
     * @param response
     * @param model
     * @param staff
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/a/u/staff", method = RequestMethod.PUT)
    public String updateStaffJson(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody Staff staff) throws Exception {


        log.info("update staff:  " + staff);
        if (DataUtils.isNullOrEmpty(staff)) {
            log.info("get staff is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        //判断手机号是否重复
        Map<String, Object> phoneParam = DynamicSQLUtil.getPhoneList(staff.getPhone());
        List<Long> phoneIdList = null;
        try {
            phoneIdList = staffService.getIdsByDynamicCondition(Staff.class, phoneParam, 0, Integer.MAX_VALUE);
            log.info("get phoneIdList.size is :" + phoneIdList.size());
            if (phoneIdList.size() > ConstantItem.ONE) {
                model.addAttribute("code", -5021);
                return "common/fail";
            }

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("查询员工手机号错误 ！");
            model.addAttribute("code", -5026);
            return "common/fail";

        }

        Integer scoreChange = getScoreChangeForUser(staff.getId());  // 历史积分增减
        Integer baseScore = getBaseScoreForUser(staff);//基础积分 （职位，学历，荣誉，职称，特长，职位星级，入职日期）

        staff.setSeniorityScore(getSenorityScoreForUser(staff));
        staff.setBaseScore(baseScore + staff.getSeniorityScore());

        setIdForUser(staff);


        log.info("get baseScore is: " + staff.getBaseScore());

        staff.setTotalScore(baseScore + scoreChange);   //总积分
        log.info("get totalScore is: " + staff.getTotalScore());


        try {
            staff.setUpdateBy(Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID)));
            boolean result = staffService.update(staff);
            log.info("update staffId is: " + staff.getId() + " result is: " + result);
            model.addAttribute("code", 0);

        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("update staff error,id is  " + staff.getId());
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/data/json";
    }

    //设置基础积分
    public Integer getBaseScoreForUser(Staff staff) {

        Integer baseScore = staff.getPositionScore();

        if (DataUtils.isNotNullOrEmpty(staff.getStarScore())) {    //星级
            baseScore += staff.getStarScore();
        }
        if (DataUtils.isNotNullOrEmpty(staff.getDegreeScore())) {    //学历
            baseScore += staff.getDegreeScore();
        }
        if (DataUtils.isNotNullOrEmpty(staff.getHonorScore())) {     // 荣誉
            baseScore += staff.getHonorScore();
        }
        if (DataUtils.isNotNullOrEmpty(staff.getJopScore())) {       // 职位
            baseScore += staff.getJopScore();
        }
        if (DataUtils.isNotNullOrEmpty(staff.getSpecialityScore())) {    // 特长
            baseScore += staff.getSpecialityScore();
        }
        return baseScore;
    }

    public void setIdForUser(Staff staff) {

        Long starId = staff.getStarId();
        if (DataUtils.isNullOrEmpty(starId)) {
            staff.setStarId(starId);
        }
        if (DataUtils.isNullOrEmpty(staff.getDegreeId())) {
            staff.setDegreeId(staff.getDegreeId());
        }
        if (DataUtils.isNullOrEmpty(staff.getHonorId())) {
            staff.setHonorId(staff.getHonorId());
        }
        if (DataUtils.isNullOrEmpty(staff.getJopId())) {
            staff.setJopId(staff.getJopId());
        }
        if (DataUtils.isNullOrEmpty(staff.getSpecialityId())) {
            staff.setSpecialityId(staff.getSpecialityId());
        }
        if (DataUtils.isNotNullOrEmpty(starId)) {
            staff.setSeniority(starId.intValue());
        }

        if (DataUtils.isNullOrEmpty(staff.getDepartmentId())) {
            staff.setDepartmentId(staff.getDepartmentId());
        }

        staff.setIniApproveScore(staff.getIniScore());
        staff.setIniCommendScore(staff.getCommendScore());
    }


    // 统计工龄积分
    public Integer getSenorityScoreForUser(Staff staff) throws ServiceException, ServiceDaoException {

        //获得工龄
        Long nowTime = System.currentTimeMillis();

        Long staffSeniority = (nowTime - staff.getEntryAt()) / ConstantItem.YEAR;

        log.info("staffSeniority: " + staffSeniority);
        staff.setSeniority(staffSeniority.intValue());


        //获得工龄积分
        Integer gradeType = ConstantItem.ONE;
        int seniorityScore = 0;

        Map<String, Object> seniorParam = DynamicSQLUtil.getStarScoreList(staff.getSeniority(), gradeType);

        List<Long> starIds = starService.getIdsByDynamicCondition(Star.class, seniorParam, 0, Integer.MAX_VALUE);
        log.info("get starIdList is: " + starIds);

        Star star = starService.getObjectById(starIds.get(0));
        log.info("=========== get star is: " + star);

        log.info("=========== get s is: " + star.getScore());

        seniorityScore = star.getScore();

        return seniorityScore;


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
    @RequestMapping(value = "/a/u/staff/{id}", method = RequestMethod.GET)
    public String getStaffJson(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {

        log.info("get data : id= " + id);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";

        }
        try {
            Staff staff = staffService.getObjectById(id);
            if (DataUtils.isNullOrEmpty(staff)) {
                log.error("get staff is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staff data is " + staff);

            model.addAttribute("code", 0);

            model.addAttribute("staff", staff);

        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get staff error,id is  " + id);
            model.addAttribute("code", -100000);
            return "common/fail";

        }

        return "/json/staff/json/staffDetailJson";
    }

    /**
     * 5.列表
     *
     * @param request
     * @param response
     * @param model
     * @param name
     * @param phone
     * @param departmentName
     * @param positionName
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/a/u/staff", method = RequestMethod.GET/*,produces = "application/json; charset=utf-8"*/)
    public String getStaffList(HttpServletRequest request, HttpServletResponse response,
                               ModelMap model, String name, String phone, String departmentName, String positionName,
                               Integer page, Integer size) {
        log.info("param = name is: " + name + " phone is: " + phone + " departmentName is: " + departmentName + " positionName is: "
                + positionName + " page is: " + page + " size is: " + size);

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


        Map<String, Object> param = null;

        List<Long> staffIdList = null;

        List<Staff> staffList = null;

        List<Long> count = null;

        param = DynamicSQLUtil.getStaffList(name, phone, departmentName, positionName);

        try {
            staffIdList = staffService.getIdsByDynamicCondition(Staff.class, param, start, size);
            log.info("get staffIdList is: " + staffIdList);
            if (DataUtils.isNullOrEmpty(staffIdList)) {
                log.info("get staffIdList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            count = staffService.getIdsByDynamicCondition(Staff.class, param, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count.size());
            if (DataUtils.isNullOrEmpty(count)) {
                log.info("get count is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            staffList = staffService.getObjectsByIds(staffIdList);
            log.info("get staffList is: " + staffList.size());
            if (DataUtils.isNullOrEmpty(staffList)) {
                log.info("get staffList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }

            if (staffList.size() == 0) {
                log.error("get staffList.size is null！");
                model.addAttribute("code", -1000);
                return "common/fail";
            }
            log.info("get staffList.size is: " + staffList.size());
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", count.size());
            model.addAttribute("staffList", staffList);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get staffList error");
            model.addAttribute("code", -100000);
            return "common/fail";
        }

        return "json/staff/json/staffListJson";

    }


    /**
     * 6.在职修改
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param joinRank
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/staff/joinRank", method = RequestMethod.PUT)
    public String joinRank(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model, Long id, Integer joinRank) throws Exception {

        log.info("param= id is: " + id + " joinRank is: " + joinRank);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(joinRank)) {
            log.info("get joinRank is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Staff staff = staffService.getObjectById(id);
        if (DataUtils.isNullOrEmpty(staff)) {
            log.info("get staff is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {

            staff.setJoinRank(joinRank);


            staff.setUpdateBy(adminId);

            boolean result = staffService.update(staff);
            log.info("update staffId is: " + staff.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update staff error,id is  " + staff.getId());
            model.addAttribute("code", -100000);
            return "common/fail";


        }

        return "/data/json";
    }

    /**
     * 7.积分排行
     *
     * @param request
     * @param response
     * @param model
     * @param id
     * @param incumbency
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/staff/incumbency", method = RequestMethod.PUT)
    public String incumbency(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, Long id, Integer incumbency) throws Exception {

        log.info("update staff:  " + id);
        if (DataUtils.isNullOrEmpty(id)) {
            log.info("get id is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }
        if (DataUtils.isNullOrEmpty(incumbency)) {
            log.info("get incumbency is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Staff staff = staffService.getObjectById(id);
        if (DataUtils.isNullOrEmpty(staff)) {
            log.info("get staff is null！");
            model.addAttribute("code", -1000);
            return "common/fail";
        }

        Long adminId = Long.valueOf(cookieUtil.getKeyIdentity(request, CookieUtil.USER_ID));
        log.info("get adminId is : " + adminId);

        try {

            staff.setIncumbency(incumbency);


            staff.setUpdateBy(adminId);

            boolean result = staffService.update(staff);
            log.info("update staffId is: " + staff.getId() + " result is: " + result);

            model.addAttribute("code", 0);


        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update staff error,id is  " + staff.getId());
            model.addAttribute("code", -10000);
            return "common/fail";


        }

        return "/data/json";
    }


    @RequestMapping(value = "/a/u/scoreRank", method = RequestMethod.GET)
    public String getScoreRank(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, String name, Integer departmentId, Integer positionId, Long startAt, Long endAt, Integer page, Integer size)
            throws Exception {
        /**
         *@Description:查询员工积分榜单
         */
        try {
            log.info(" get name,departmentId,positionId, startAt, endAt, page, size：" + name + "+" + departmentId + "+" + positionId + "+" + startAt + "+" + endAt + "+" + page + "+" + size);
            //执行查询
            Map<String, Object> map = DynamicSQLUtil.searchStaffByCondition(name, departmentId, positionId, startAt, endAt);
            List<Long> count = staffService.getIdsByDynamicCondition(Staff.class, map, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);
            List<Staff> staffList = staffService.getObjectsByIds(count);
            log.info("get statList.size is： " + staffList.size());
            List<Staff> list = new ArrayList<>();
            //查询参加积分排行的员工
            for (Staff staff : staffList) {
                if (staff.getJoinRank() == ConstantItem.PARTICIPATE) {
                    list.add(staff);
                }
            }
            //根据总积分排序
            Collections.sort(list, new Comparator<Staff>() {
                @Override
                public int compare(Staff one, Staff another) {
                    //这个比较器args0-args1就是升序，args1-args0就是降序。
                    return another.getTotalScore() - one.getTotalScore();
                }
            });
            //循环设置员工排行
            int i = 1;
            for (Staff staff : list) {
                staff.setRanking(i);
                i++;
            }
            //分页
            PageUtil pageUtil = new PageUtil(page, size);
            List<Staff> pageList = list.stream().skip(pageUtil.getStart()).limit(pageUtil.getSize()).collect(Collectors.toList());
            //出参返回
            model.addAttribute("code", 0);
            model.addAttribute("page", pageUtil.getPage());
            model.addAttribute("size", pageUtil.getSize());
            model.addAttribute("total", count.size());
            model.addAttribute("staffList", pageList);
            return "json/staff/json/staffListJson";
        } catch (Throwable t) {
            t.getMessage();
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get ranking error ");
            model.addAttribute("code", -100000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/departmentAll", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getAllDepartment(HttpServletRequest request,
                                   HttpServletResponse response, ModelMap model) throws Exception {
        /**
         @Description:回返所有部门
         */
        try {
            //动态查询
            List<Long> departmentIds = departmentService.getDepartmentIds(ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get departmentIds is :" + departmentIds);
            List<Department> departmentList = departmentService.getObjectsByIds(departmentIds);
            if (departmentList.size() == 0) {
                log.error("get departmentLsit is null！");
                model.addAttribute("code", -1000);
                return "common/fail";

                //出参返回
            }
            log.info("get departmentList.size is: " + departmentList.size());
            model.addAttribute("code", 0);
            model.addAttribute("departmentList", departmentList);
            return "json/othersJsp/json/allDepartment";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add star error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }
    }

    @RequestMapping(value = "/a/u/position", method = RequestMethod.GET)
    public String getAllPosition(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model) throws Exception {
        /**
         *@Description:回返所有职位
         */
        //动态查询
        try {
            Map<String, Object> map1 = DynamicSQLUtil.searchAllPosition();
            List<Long> count = allTypeScoreService.getIdsByDynamicCondition(AllTypeScore.class, map1, ConstantItem.ZERO, Integer.MAX_VALUE);
            log.info("get count is: " + count);

            List<AllTypeScore> allTypeScoreList = allTypeScoreService.getObjectsByIds(count);
            if (allTypeScoreList.size() == 0) {
                log.error("get attTypeScoreList is null！");
                model.addAttribute("code", -1000);
                return "common/fail";

            }
            log.info("get allTypeScoreList.size is: " + allTypeScoreList.size());
            //出参返回
            model.addAttribute("code", 0);
            model.addAttribute("positionList", allTypeScoreList);
            return "json/othersJsp/json/allPosition";
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add star error ");
            model.addAttribute("code", -10000);
            return "common/fail";
        }

    }
}

