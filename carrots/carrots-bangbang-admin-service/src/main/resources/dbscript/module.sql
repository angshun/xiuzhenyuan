-- ----------------------------
-- Table structure for `module`
-- ----------------------------
-- DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20)    COMMENT '模块名称',  
    `p_id` bigint    COMMENT '父模块id',  
    `type` varchar(20)    COMMENT '模块类型',  
    `menu_id` bigint    COMMENT '',  
    `icon` varchar(50)    COMMENT '',  
    `level` int    COMMENT '',  
    `url` varchar(100)    COMMENT '模块相对于的url',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





