-- ----------------------------
-- Table structure for `operation_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `admin` varchar(255)    COMMENT '操作人（管理员）',  
    `operation` varchar(255)    COMMENT '操作类型',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





