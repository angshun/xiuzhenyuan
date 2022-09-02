-- ----------------------------
-- Table structure for `score_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `score_log`;
CREATE TABLE `score_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `score_reason` int(2)    COMMENT '积分项目',  
    `score_change` varchar(30)    COMMENT '积分变动',  
    `score_type` int(2)    COMMENT '积分类型',  
    `create_at` bigint    COMMENT '创建时间（获得积分时间）',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





