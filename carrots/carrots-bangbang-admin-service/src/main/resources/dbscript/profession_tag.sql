-- ----------------------------
-- Table structure for `profession_tag`
-- ----------------------------
-- DROP TABLE IF EXISTS `profession_tag`;
CREATE TABLE `profession_tag` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `cid` bigint    COMMENT '公司id',  
    `pid` bigint    COMMENT '职业id',  
    `tag` varchar(20)    COMMENT '职业标签',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





