-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
-- DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `content` text    COMMENT '通告内容',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





