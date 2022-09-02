package com.ptteng.score.home.util;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:    carrot
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/8/10
 */
public class DynamicSQLUtil {
    private static final Logger log = Logger.getLogger(DynamicSQLUtil.class);

    public static Map<String, Object> searchSingleScoreLog(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchSScoreLog(String title) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("moral & =", "'" + title + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_type ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchSingleScoreLogInTime(Long id, Long taskId, Long time) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("task_id & =", "'" + taskId + "'");
        map.put("create_at & >", "'" + time + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchTaskInTime(Long id, Long taskId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(taskId)) {
            map.put("task_id & =", "'" + taskId + "'");
        }
        map.put("staff_id & =", "'" + id + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchSingleScdsoreLog(Long startTime, Long endTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("create_at & >", "'" + startTime + "'");
        map.put("create_at & <", "'" + endTime + "'");
//        map.put("attendance_type & =", "'(1,3)'");
        map.put("attendance_type & in ", "(0,1,3)");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " attendance_log ");
        log.info("==================================>>get attendance_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchSinglenewScoreLog(Long id, Long time) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("create_at & >", "'" + time + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchSinglenewScoreLo(Long time, Long endTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("create_at & >", "'" + time + "'");
        map.put("create_at & <", "'" + endTime + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> seareLo(Long time, Long endTime, Long adminId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("create_at & >", "'" + time + "'");
        map.put("create_at & <", "'" + endTime + "'");
        map.put("staff_id & =", "'" + adminId + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searcheLog(Long time) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("create_at & >", "'" + time + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchSingleScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchScoreLog(Long time, Integer scoreType) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != scoreType) {
            map.put("score_type & =", "'" + scoreType + "'");
        }
        if (null != time) {
            map.put("create_at & >", "'" + time + "'");
        }
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get searchScoreLog sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchPhilosophy(Integer department, Integer position) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("join_rank & =", "'" + "1" + "'");
        if (null != department) {
            map.put("department_id & =", "'" + department + "'");
        }
        if (null != position) {
            map.put("position_id & =", "'" + position + "'");
        }
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff ");
        log.info("==================================>>get staff sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchEnterpriseApproval(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            map.put(" approval_id & =", "'" + id + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        log.info("==================================>>get  enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searcppproval(Long taskId, Long applyId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(applyId)) {
            map.put(" apply_id & =", "'" + applyId + "'");
        }
        map.put(" task_id & =", "'" + taskId + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        log.info("==================================>>get  enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchWaitEnterpriseApproval(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            map.put(" approval_id & =", "'" + id + "'");
        }
        map.put(" status & =", "'" + "2" + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        log.info("==================================>>get  enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchMyEnterpriseApproval(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            map.put("apply_id", id);
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        log.info("==================================>>get  enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchCopyEnterpriseApproval(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            map.put("copy_id & like", "'%" + id + "%'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " copy_relation ");
        log.info("==================================>>get  copy_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchStaffByDepartment(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("department_id & =", "'" + id + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff ");
        log.info("==================================>>get staff sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchMyTask(Long id, Integer taskType) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("task_type & =", "'" + taskType + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchMyScoreLog(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get score_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchAllPosition() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("@order", " update_at desc ");
        map.put("type & =", "'" + "0" + "'");
        map.put("@query", " id ");
        map.put("@table", " all_type_score ");
        log.info("==================================>>get all_type_score sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchStaffPhilosophyRelation(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("staff_id & =", "'" + id + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_philosophy_relation ");
        log.info("==================================>>get staff_philosophy_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchListPhilosophyRelation(String ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != ids) {
            map.put("philosophy_id & in", "(" + ids + ")");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_philosophy_relation ");
        log.info("==================================>>get staff_philosophy_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchStaffPhilosophyRelationByTime(Long id, Long philosophyId, Long time) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("staff_id & =", "'" + id + "'");
        }
        map.put("philosophy_id & =", "'" + philosophyId + "'");
        map.put("create_at & >", "'" + time + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_philosophy_relation ");
        log.info("==================================>>get staff_philosophy_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }


    public static Map<String, Object> searchStaffPhilosophy() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status & =", "'1'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " philosophy ");
        log.info("==================================>>get philosophy sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searelation(Long id, Long articleId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("staff_id & =", "'" + id + "'");
        }
        map.put("philosophy_id & =", "'" + articleId + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_philosophy_relation ");
        log.info("==================================>>get staff_philosophy_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchPersonalLog(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_log ");
        log.info("==================================>>get enterprise_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchPersonalScoreLog(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("staff_id & =", "'" + id + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_log ");
        log.info("==================================>>get score_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchScoreExchangeLog(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("staff_id & =", "'" + id + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_exchange_approval ");
        log.info("==================================>>get score_exchange_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchScoreType(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("score_type & =", "'" + id + "'");
        }
        map.put("status & =", "'1'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_type ");
        log.info("==================================>>get score_type sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searType(Long id, Long applyId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != id) {
            map.put("task_id & =", "'" + id + "'");
        }
        map.put("staff_id & =", "'" + applyId + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchEnterLog(Long applyId, Long taskId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("apply_id & =", "'" + applyId + "'");
        map.put("task_id & =", "'" + taskId + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        log.info("==================================>>get enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchTaskRelation(Long applyId, Long taskId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + applyId + "'");
        map.put("task_id & =", "'" + taskId + "'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchThisisMyTask(Long id, Integer taskType) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("task_type & =", "'" + taskType + "'");
//        map.put("task_id & =", "'" + taskId + "'");
        map.put("@order", " update_at desc ");

        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchOnlyTask(Integer taskType, Long department) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("task_type & =", "'" + taskType + "'");
        map.put("visual_department & like", "'%" + department + "%'");

        map.put("status & =", "'1'");
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " task ");
        log.info("==================================>>get task sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }


//===============================================以下为后台复制过来的===================================


    /**
     * manager列表搜索
     *
     * @param roleId
     * @param name
     * @return
     */
    public static Map<String, Object> getManagerList(Integer roleId, String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", " distinct m.id");
        params.put("@table", "manager m,role r");
        params.put("m.role_id", "r.id");
        params.put("@order", "m.create_at desc");
        if (DataUtils.isNotNullOrEmpty(name)) {

            params.put("m.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(roleId)) {
            params.put("m.roleId", roleId);

        }

        log.info(SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }

    /**
     * 登录
     *
     * @param phone
     * @return
     */
    public static Map<String, Object> getLogin(String phone) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", "id");
        params.put("@table", "staff");
        params.put("phone", "'" + phone + "'");

        log.info(SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }


    public static Map<String, Object> getStaffList(String departmentName, String positionName/*,Integer time*/) {
        Map<String, Object> param = new HashMap<>();

        if (DataUtils.isNotNullOrEmpty(departmentName)) {
            param.put("department_name", "'" + departmentName + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionName)) {
            param.put("position_name", "'" + positionName + "'");
        }
//        Long countTime = 0L;
//        countTime = DateUtil.getCurrentMonthLastDay();
//        countTime = DateUtil.getQuarterByMonth(false);
//        param.put("create_at & >=", countTime);
        param.put("sun_score+love_score & ", "");
        param.put("@query", "id");
        param.put("@table", "staff");
        param.put("@order", "sun_score+love_score desc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getArticleList(Integer type) {
        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(type)) {
            param.put("type", type);
        }
        param.put("@query", "id");
        param.put("@table", "article");
        param.put("@order", " create_at desc ");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getStarList(Integer gradeType) {
        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(gradeType)) {
            param.put("grade_type", gradeType);
        }
        param.put("@query", "id");
        param.put("@table", "star");
        param.put("@order", " create_at desc ");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }


    public static Map<String, Object> searchNotice() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " notice ");
        log.info("==================================>>get notice sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> getApplyManageList() {
        Map<String, Object> param = new HashMap<>();
        param.put("@order", "id asc");
        param.put("status", "1");
        param.put("@query", "id");
        param.put("@table", "apply_manage");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> searchEnterpriseLog() {
        Map<String, Object> map = new HashMap<String, Object>();
//        Long time = 0L;
//        time = DateUtil.timeUtil(3);
        map.put("@order", "create_at desc");
        map.put("@query", "id");
        map.put("@table", "enterprise_log");
        log.info(SQLUtil.convert2Sql(map, 0, Integer.MAX_VALUE));

        return map;
    }


    public static Map<String, Object> getEnterpriseLogList(Long staffId, Long zero, Long time) {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "enterprise_log");
        param.put("create_by", staffId);
        param.put("create_at & >= ", zero);
        param.put("create_at & <= ", time);
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getStaffLogList(Long adminId) {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "staff");
        param.put("id", adminId);
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getApproveListByPraiseId(Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("praise_id", id);
        param.put("@query", "id");
        param.put("@table", "approve_log");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getApproveListByStaffId(Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("staff_id", id);
        param.put("@query", "id");
        param.put("@table", "approve_log");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getAttendanceLogList(Long adminId/*, Integer attendanceType*/) {
        Map<String, Object> param = new HashMap<>();
//        if (attendanceType == 1) {
//            param.put("attendance_type & in", " (1,2) ");
//        } else {
//            param.put("attendance_type & in", " (3,4) ");
//        }
        Long countTime = 0L;
        countTime = DateUtil.getCurrentMonthLastDay();
        param.put("create_at & >= ", countTime);
        param.put("staff_id", adminId);
        param.put("@query", "id");
        param.put("@table", "attendance_log");
        param.put("@order", "create_at desc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }


    public static Map<String, Object> getScoreList(Long id, Integer scoreType) {
        Map<String, Object> param = new HashMap<>();
        param.put("special_id", id);
        param.put("score_type", scoreType);
        param.put("@query", "id");
        param.put("@table", "score_log");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getEnterpriseApproveList(Long staffId, Long logId, Integer type) {
        Map<String, Object> param = new HashMap<>();
        param.put("staff_id", staffId);
        param.put("log_id", logId);
        param.put("type", type);
        param.put("@query", "id");
        param.put("@table", "approve_log");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getAttendanceLog(Long staffId) {
        Map<String, Object> param = new HashMap<>();
        Long countTime = 0L;
        countTime = DateUtil.timeUtil(0);
        param.put("create_at & >= ", countTime);
        param.put("staff_id", staffId);
        param.put("@query", "id");
        param.put("@table", "attendance_log");
        param.put("@order", "create_at desc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getPraiseIdList(Long id, Long staffId) {
        Map<String, Object> param = new HashMap<>();
        param.put("staff_id", staffId);
        param.put("log_id", id);
        param.put("@query", "id");
        param.put("@table", "approve_log");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getenterpriaeApproval(String staffIdList, Long time, Long scoreId) {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("approval_id", approvalId);
        map.put("apply_id & in", "("+staffIdList+")");
        map.put("score_id", scoreId);
        map.put("create_at & >= ", time);
        map.put("@query", " id ");
        map.put("@table", " enterprise_approval ");
        map.put("@order", "create_at desc");
        log.info("==================================>>get enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }
}


