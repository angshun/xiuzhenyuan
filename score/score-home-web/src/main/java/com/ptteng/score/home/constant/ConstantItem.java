package com.ptteng.score.home.constant;

/**
 * Title:    score
 * Description:
 * Company:  www.jnshu.com
 *
 * @author hfismyangel@163.com
 * @version 1.0
 * @Ddate 2017/9/28
 */
public class ConstantItem {
    /**
     * 四种类型Excel导出字段常量表
     */
    public static final String[] REWARD_FIELD = {"id工号", "员工姓名", "管理员姓名", "部门", "职位", "表扬标题", "表扬内容", "表扬积分", "积分类型", "积分时间"};
    public static final String REWARD_TABLE_NAME = "领导表彰记录表";
    //员工积分记录表
    public static final String[] SCORE_FIELD = {"id工号", "员工姓名", "部门", "职位", "积分项目", "积分变更", "积分类型", "创建时间"};
    public static final String SCORE_TABLE_NAME = "员工积分记录表";
    //员工积分榜单
    public static final String[] SCORE_RANK_FIELD = {"排行", "员工id", "员工姓名", "职位", "部门", "学位积分", "荣耀积分", "职称积分", "特殊积分", "可用表彰积分", "基础积分", "累加积分", "累减积分", "积分情况", "总积分", "工龄", "等级", "离职状态", "太阳积分", "爱心积分"};
    public static final String SCORE_RANK_TABLE_NAME = "员工积分榜单";
    //员工信息管理表
    public static final String[] NEW_STAFF = {"id", "员工姓名", "员工头像", "员工手机号"};
    public static final String STAFF_TABLE_NAME = "员工信息管理表";

    public static final String OFFICE_WORK_ATTENDANCE = "内勤上班打卡";
    public static final String OFFICE_EARLY_TO_SIGN = "内勤早到打卡";
    public static final String OFFICE_WORK_LATE = "内勤上班迟到";
    public static final String OFFICE_WORK_ABSENTEEISM = "内勤上班缺勤";
    public static final String CLOCK_OUT = "内勤下班打卡";
    public static final String EARLY = "内勤下班早退";
    public static final String OVERTIME = "内勤加班打卡";
    public static final String OUTSIDE_OFFICE_WORK_ABSENTEEISM = "外勤上班缺勤";
    public static final String OUTSIDE_OFFICE_WORK_ATTENDANCE = "外勤上班打卡";
    public static final String OUTSIDE_CLOCK_OUT = "外勤下班打卡";
    public static final String CLOCKK = "签到";


    public static final String LOG_PRAISE = "日志被赞";
    public static final String PRAISE_SUN = "点赞";
    public static final String PRAISE_LOVE = "点赞";
    public static final String ADD = "+";
    public static final String SUB = "_";


    /**
     * 几种考勤状态约定
     */
    public static final int STATUS_RIGHT = 1;
    public static final int STATUS_ARRIVE_EARLY = 2;
    public static final int STATUS_LATE = 3;
    public static final int STATUS_LEAVE_EARLY = 4;
    public static final int STATUS_ABSENCE = 5;
    public static final int STATUS_OVERTIME = 6;


    /**
     * 考勤、爱心点赞、工作日志设置约定
     * 三种类型按顺序对应数据库三条数据
     * 按id查询
     */
    public static final Long CLOCK = 1L;
    public static final Long LOVE_PRAISE = 2L;
    public static final Long WORL_LOG = 3L;


    /**
     * 点赞类型约定
     * type
     */
    public static final int PRAISE_LOG = 0;
    public static final int PRAISE_PEOPLE = 1;

    /**
     * gradeType工龄、等级约定
     */
    public static final int SENIORITY = 0;
    public static final int STAR = 1;

    /**
     * incumbency 0离职1在职
     * joinRank  0不参与排行1参与排行
     */

    public static final int INCUMBERCY = 1;
    public static final int DIMISSION = 0;
    public static final int PARTICIPATE = 1;
    public static final int NO_participate = 0;

    /**
     * 默认id
     */
    public static final Long ZERO_ID = 0L;
    public static final Long MINUS_ID = -1L;
    /**
     * incumbency 0离职1在职
     * joinRank  0不参与排行1参与排行
     * <p>
     * public static final int STATUS_NO_PASS = 0;
     * public static final int STATUS_PASS = 1;
     * <p>
     * <p>
     * / * 积分兑换
     */
    public static final int STATUS_NO_PASS = 0;
    public static final int STATUS_PASS = 1;
    public static final int STATUS_EXAMINE = 2;
    /**
     * 积分类型管理状态
     */
    public static final int STATUS_CEASE = 0;
    public static final int STATUS_USE = 1;

    /**
     * 积分类型约定
     * 0品德/1业绩/2行为/3点赞/4日志/5企业哲学/6领导表扬/7任务积分/8考勤
     */
    public static final int MORAL = 0;
    public static final int ACHIEVEMENT = 1;
    public static final int BEHAVIOUR = 2;
    public static final int PRAISE = 3;
    public static final int LOG = 4;
    public static final int PHILOSOPHY = 5;
    public static final int LEADER_PRAISE = 6;
    public static final int TASK_SCORE = 7;
    public static final int ATTENDANCE = 8;
    public static final int GOODS_EXCHANGE = 9;

    /**
     * 任务管理状态
     * 0未通过
     * 1通过状态
     */
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SERVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final Long ZEROL = 0L;
    public static final Long ONEL = 1L;
    public static final int MINUS_ONE = -1;
    public static final int TWENTY = 20;
    public static final int TWENTY_FOUR = 24;
    public static final String NOTE = "发表日志";
    public static final int FIFTY = 50;


    public static final Long TIME = 60 * 60 * 8 * 1000L;
    public static final Long HOUR = 60 * 60 * 1000L;
    public static final Long MINUTES = 60 * 40 * 1000L;
    public static final Long ONE_MINUTES = 60 * 1000L;


    /*
    返回状态码常量表
     */
    //服务器异常
    public static final int ONE_HUNDRED_THOUSAND = -100000;
    //参数不能为空
    public static final int ONE_THOUSAND = -1000;
    //该任务已提交过审批
    public static final int HAS_BEEN_APPROVED = -111;
    //没有抄送人
    public static final int NO_COPY = -112;
    //人数已满或未管理员设置该任务限制人数
    public static final int MAX_PEOPLE = -103;
    //该用户非管理员
    public static final int NOT_MANAGER = -105;
}
