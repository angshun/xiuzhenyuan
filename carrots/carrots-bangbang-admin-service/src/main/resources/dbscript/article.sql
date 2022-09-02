-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(2)    COMMENT 'article类型',  
    `title` varchar(20) NOT NULL   COMMENT '标题',  
    `img` varchar(20)    COMMENT '图片',  
    `url` varchar(100)    COMMENT '链接',  
    `status` int(2)    COMMENT '上线状态',  
    `industry` int(2)    COMMENT '行业',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '修改时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    `rank` int(2)    COMMENT '排序',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





