-- ----------------------------
-- Table structure for `staff_task_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `staff_task_relation`;
CREATE TABLE `staff_task_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `task_id` bigint    COMMENT '任务id',  
    `attendance_type` int(2)    COMMENT '任务状态（0已参与/1已完成）',  
    `task_type` int(2)    COMMENT '任务类型',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





