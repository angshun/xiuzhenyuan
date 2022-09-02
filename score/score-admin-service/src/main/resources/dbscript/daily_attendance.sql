-- ----------------------------
-- Table structure for `daily_attendance`
-- ----------------------------
-- DROP TABLE IF EXISTS `daily_attendance`;
CREATE TABLE `daily_attendance` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `attendance_type` int(2)    COMMENT '考勤类型0内勤1外勤',  
    `normal_score` int(2)    COMMENT '正常奖励分数',  
    `morning_score` int(2)    COMMENT '早到奖励积分',  
    `late_score` int(2)    COMMENT '迟到减积分',  
    `overtime_score` int(2)    COMMENT '加班奖励积分',  
    `left_early_score` int(2)    COMMENT '早退减积分',  
    `absence_score` int(2)    COMMENT '缺勤扣积分',  
    `work_time` bigint    COMMENT '上班时间',  
    `closing_time` bigint    COMMENT '下班时间',  
    `company_coordinate` varchar(255)    COMMENT '公司地址(经纬度)',  
    `attendance_instance` bigint    COMMENT '考勤校验距离',  
    `outside_work_time_score` int(2)    COMMENT '外勤正常上班时间奖励',  
    `outside_closing_time_score` int(2)    COMMENT '外勤正常下班时间奖励',  
    `log_release_time` int(2)    COMMENT '每天发布日志次数',  
    `approve_score` int(2)    COMMENT '点赞他人日报获得积分',  
    `be_approve_score` int(2)    COMMENT '日报被赞获得积分',  
    `love_score` int(2)    COMMENT '爱心积分',  
    `sun_score` int(2)    COMMENT '太阳积分',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





