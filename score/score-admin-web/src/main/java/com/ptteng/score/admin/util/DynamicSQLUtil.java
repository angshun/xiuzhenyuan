package com.ptteng.score.admin.util;

import com.gemantic.common.util.StringUtil;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.score.admin.model.Star;
import com.qding.common.util.DataUtils;
import org.apache.log4j.Logger;
import org.python.util.InterpreterTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    private static Map<String, Object> applyManageList;

    public static Map<String, Object> searchTask(Long taskType, Long scoreType, Long project, Long startAt, Long endAt, Integer orderBy) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != taskType) {
            map.put("task_type & =", "'" + taskType + "'");
        }
        if (null != scoreType) {
            map.put("score_type & =", "'" + scoreType + "'");
        }
        if (null != project) {
            map.put("project & =", "'" + project + "'");
        }
        if (null != startAt) {
            map.put("create_at & >", "'" + startAt + "'");
        }
        if (null != endAt) {
            map.put("create_at & <", "'" + endAt + "'");
        }
        switch (orderBy) {
            case 0:
                map.put("@order", " create_at desc ");
                break;
            case 1:
                map.put("@order", " create_at asc ");
                break;
            case 2:
                map.put("@order", " times desc ");
                break;
            case 3:
                map.put("@order", " times asc ");
                break;
        }
        map.put("@query", " id ");
        map.put("@table", " task ");
        log.info("==================================>>get task sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchStaffByCondition(String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != name) {
            map.put("name & like", "'%" + name + "%'");
        }
        if (null != departmentId) {
            map.put("department_id & =", "'" + departmentId + "'");
        }
        if (null != positionId) {
            map.put("position_id & =", "'" + positionId + "'");
        }
        if (null != startAt) {
            map.put("create_at & >", "'" + startAt + "'");
        }
        if (null != endAt) {
            map.put("create_at & <", "'" + endAt + "'");
        }
        map.put("join_rank & =", "'1'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff ");
        log.info("==================================>>get staff sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }


    public static Map<String, Object> searchScoreType(Integer scoreType, Integer project, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != scoreType) {
            map.put("score_type & =", "'" + scoreType + "'");
        }
        if (null != project) {
            map.put("project & =", "'" + project + "'");
        }
        if (null != startAt) {
            map.put("create_at & >", "'" + startAt + "'");
        }
        if (null != endAt) {
            map.put("create_at & <", "'" + endAt + "'");
        }
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " score_type ");
        log.info("==================================>>get score_type sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchPhilosophy(Integer project, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != project) {
            map.put("project & =", "'" + project + "'");
        }
        if (null != startAt) {
            map.put("create_at & >", "'" + startAt + "'");
        }
        if (null != endAt) {
            map.put("create_at & <", "'" + endAt + "'");
        }
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " philosophy ");
        log.info("==================================>>get score_type sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchEnterpriseApproval(String name, Long account, Long departmentId, Long positionId,
                                                               Long status, Long startAt, Long endAt, Integer scoreType) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("enterprise_approval enterprise_approval");
        map.put("staff.id", "enterprise_approval.apply_id");
        if (DataUtils.isNotNullOrEmpty(name)) {
            map.put("staff.name & like", "'%" + name + "%'");
        }

        if (DataUtils.isNotNullOrEmpty(account)) {
            map.put("staff.phone & like", "'%" + account + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(scoreType)) {
            map.put("enterprise_approval.score_type & =", "'" + scoreType + "'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            map.put("staff.department_id & =", "'" + departmentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionId)) {
            map.put("staff.position_id & =", "'" + positionId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            map.put("enterprise_approval.status & =", "'" + status + "'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            map.put("enterprise_approval.create_at & >", "'" + startAt + "'");
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            map.put("enterprise_approval.create_at & <", "'" + endAt + "'");
        }
        String table = SQLUtil.convertTable(tables);
        map.put("@order", " enterprise_approval.update_at desc ");
        map.put("@query", " enterprise_approval.id ");
        map.put("@table", table);
        log.info("==================================>>get  enterprise_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchScoreExchagngeList() {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("score_exchange_approval score_exchange_approval");
        map.put("staff.id", "score_exchange_approval.staff_id");

        String table = SQLUtil.convertTable(tables);
        map.put("@order", " score_exchange_approval.update_at desc ");
        map.put("@query", " score_exchange_approval.id ");
        map.put("@table", table);
        log.info("==================================>>get  score_exchange_approval sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchEnterpriseLog(String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("enterprise_log enterprise_log");
        map.put("staff.id", "enterprise_log.staff_id");
        if (DataUtils.isNotNullOrEmpty(name)) {
            map.put("staff.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            map.put("staff.department_id & =", "'" + departmentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionId)) {
            map.put("staff.position_id & =", "'" + positionId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            map.put("enterprise_log.create_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            map.put("enterprise_log.create_at & <=", endAt);
        }
//        if (DataUtils.isNotNullOrEmpty(startAt)) {
//            map.put("enterprise_log.create_at & <", "'" + startAt + "'");
//        }
//        if (DataUtils.isNotNullOrEmpty(endAt)) {
//            map.put("enterprise_log.create_at & >", "'" + endAt + "'");
//        }
        String table = SQLUtil.convertTable(tables);
        map.put("@order", " enterprise_log.update_at desc ");
        map.put("@query", " enterprise_log.id ");
        map.put("@table", table);
        log.info("==================================>>get  enterprise_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchNotice(Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != startAt) {
            map.put("create_at & >", "'" + startAt + "'");
        }
        if (null != endAt) {
            map.put("create_at & <", "'" + endAt + "'");
        }
        map.put("@order", " update_at desc ");
        map.put("@query", " id ");
        map.put("@table", " notice ");
        log.info("==================================>>get notice sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchScoreLog(String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("score_log score_log");
        map.put("staff.id", "score_log.staff_id");
        if (DataUtils.isNotNullOrEmpty(name)) {
            map.put("staff.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            map.put("staff.department_id & =", "'" + departmentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionId)) {
            map.put("staff.position_id & =", "'" + positionId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            map.put("score_log.create_at & >", "'" + startAt + "'");
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            map.put("score_log.create_at & <", "'" + endAt + "'");
        }
        String table = SQLUtil.convertTable(tables);
        map.put("@order", " score_log.update_at desc ");
        map.put("@query", " score_log.id ");
        map.put("@table", table);
        log.info("==================================>>get  score_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchAttendanceLog(String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("attendance_log attendance_log");
        map.put("staff.id", "attendance_log.staff_id");
        if (DataUtils.isNotNullOrEmpty(name)) {
            map.put("staff.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            map.put("staff.department_id & =", "'" + departmentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionId)) {
            map.put("staff.position_id & =", "'" + positionId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            map.put("attendance_log.create_at & >", "'" + startAt + "'");
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            map.put("attendance_log.create_at & <", "'" + endAt + "'");
        }
        String table = SQLUtil.convertTable(tables);
        map.put("@order", " attendance_log.update_at desc ");
        map.put("@query", " attendance_log.id ");
        map.put("@table", table);
        log.info("==================================>>get  attendance_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> searchRewardLog(String name, Integer departmentId, Integer positionId, Long startAt, Long endAt) {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> tables = new HashSet<>();
        tables.add("staff staff");
        tables.add("reward_log reward_log");
        map.put("staff.id", "reward_log.staff_id");
        if (DataUtils.isNotNullOrEmpty(name)) {
            map.put("staff.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            map.put("staff.department_id & =", "'" + departmentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionId)) {
            map.put("staff.position_id & =", "'" + positionId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            map.put("reward_log.create_at & >", "'" + startAt + "'");
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            map.put("reward_log.create_at & <", "'" + endAt + "'");
        }
        String table = SQLUtil.convertTable(tables);
        map.put("@order", " reward_log.update_at desc ");
        map.put("@query", " reward_log.id ");
        map.put("@table", table);
        log.info("==================================>>get  reward_log sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }


    /**
     * manager列表搜索
     *
     * @param roleId
     * @param name
     * @return
     */
    public static Map<String, Object> getManagerList(Integer roleId, String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", "m.id");
//        params.put("@query", " distinct m.id");
        params.put("@table", "manager m,role r");
        params.put("m.role_id", "r.id");
        params.put("@order", "m.create_at desc");
        if (DataUtils.isNotNullOrEmpty(name)) {

            params.put("m.name & like", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(roleId)) {
            params.put("m.role_id", roleId);

        }

        log.info(SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
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

    /**
     * 登录
     *
     * @param name
     * @return
     */
    public static Map<String, Object> getLogin(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@query", "id");
        params.put("@table", "manager");
        params.put("name", "'" + name + "'");

        log.info(SQLUtil.convert2Sql(params, 0, Integer.MAX_VALUE));
        return params;
    }


    public static Map<String, Object> getStaffList(String name, String phone, String departmentName, String positionName) {
        Map<String, Object> param = new HashMap<>();
        if (DataUtils.isNotNullOrEmpty(name)) {
            param.put("name & like ", "'%" + name + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(phone)) {
            param.put("phone & like", "'%" + phone + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(departmentName)) {
            param.put("department_name", "'" + departmentName + "'");
        }
        if (DataUtils.isNotNullOrEmpty(positionName)) {
            param.put("position_name", "'" + positionName + "'");
        }
        param.put("@query", "id");
        param.put("@table", "staff");
        param.put("@order", "create_at desc");
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
        param.put("@order", "create_at desc");
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
        param.put("@order", "id asc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getStarScoreList(Integer level, Integer gradeType) {

        Map<String, Object> param = new HashMap<>();
        param.put("level", level);
        param.put("@query", "id");
        param.put("grade_type", gradeType);
        param.put("@table", "star");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getAllTypeScore(Integer type) {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "all_type_score");
        if (DataUtils.isNotNullOrEmpty(type)) {
            param.put("type", type);
        }
        param.put("@order", "create_at desc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }


    public static Map<String, Object> getPhoneList(String phone) {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "staff");
        param.put("phone & like", "'%" + phone + "%'");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }


    public static Map<String, Object> getDepartmentStaffList(String departmentName) {
        Map<String, Object> param = new HashMap<>();
        param.put("department_name", "'" + departmentName + "'");
        param.put("@query", "id");
        param.put("@table", "staff");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getPositionNameList(String positionName) {
        Map<String, Object> param = new HashMap<>();
        param.put("position_name", "'" + positionName + "'");
        param.put("@query", "id");
        param.put("@table", "staff");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }

    public static Map<String, Object> getApplyManageList() {
        Map<String, Object> param = new HashMap<>();
        param.put("@query", "id");
        param.put("@table", "apply_manage");
        param.put("@order", "id asc");
        log.info(SQLUtil.convert2Sql(param, 0, Integer.MAX_VALUE));
        return param;
    }


    public static Map<String, Object> searchTaskInTime(Long id, Long taskId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id & =", "'" + id + "'");
        map.put("task_id & =", "'" + taskId + "'");
        map.put("@order", " create_at desc ");
        map.put("@query", " id ");
        map.put("@table", " staff_task_relation ");
        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(map, 0, 0));
        return map;
    }

    public static Map<String, Object> getScoreLogByStaffId(Long staff_id) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("staff_id & =", "'" + staff_id + "'");
        param.put("@query", " id ");
        param.put("@table", "score_log");

        log.info("==================================>>get staff_task_relation sql is " + SQLUtil.convert2Sql(param, 0, 0));
        return param;

    }



}
