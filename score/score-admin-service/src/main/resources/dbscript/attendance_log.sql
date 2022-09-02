-- ----------------------------
-- Table structure for `attendance_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `attendance_log`;
CREATE TABLE `attendance_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `attendance_type` int(2)    COMMENT '考勤类型',  
    `attendance_address` varchar(255)    COMMENT '考勤地址',  
    `attendance_status` int(2)    COMMENT '考勤状态',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





