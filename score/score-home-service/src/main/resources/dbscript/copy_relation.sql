-- ----------------------------
-- Table structure for `copy_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `copy_relation`;
CREATE TABLE `copy_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `record_id` bigint    COMMENT '申请记录id',  
    `copy_id` bigint    COMMENT '抄送人id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





