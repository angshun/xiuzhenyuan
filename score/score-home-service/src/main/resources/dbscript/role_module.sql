-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
-- DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `role_id` bigint    COMMENT '角色id',  
    `module_id` bigint    COMMENT '模块id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





