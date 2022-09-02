-- ----------------------------
-- Table structure for `role`
-- ----------------------------
-- DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20)    COMMENT '角色名字',  
    `status` varchar(20)    COMMENT '',  
    `permissions` text    COMMENT '权限',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





