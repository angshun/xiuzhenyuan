-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `url` varchar(255)    COMMENT '跳转链接',  
    `img` varchar(255)    COMMENT '配图链接',  
    `type` int(2)    COMMENT '发布位置类型',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '修改时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





