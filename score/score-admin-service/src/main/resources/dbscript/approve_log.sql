-- ----------------------------
-- Table structure for `approve_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `approve_log`;
CREATE TABLE `approve_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(2)    COMMENT '点赞类型（点赞日志、点赞人）',  
    `log_id` bigint    COMMENT '日志id/被点赞人id',  
    `attendance_type` int(2)    COMMENT '点赞人id',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





