-- ----------------------------
-- Table structure for `apply_manage`
-- ----------------------------
-- DROP TABLE IF EXISTS `apply_manage`;
CREATE TABLE `apply_manage` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `module_id` bigint    COMMENT '模块编号',  
    `status` int(2)    COMMENT '状态0下线/1上线',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





