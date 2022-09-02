-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
-- DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `phone` varchar(20)    COMMENT '手机号码',  
    `role_id` bigint    COMMENT '角色id',  
    `nick` varchar(20)    COMMENT '',  
    `pwd` varchar(20)    COMMENT '密码',  
    `region` text    COMMENT '',  
    `company` varchar(200)    COMMENT '',  
    `type` varchar(20)    COMMENT '',  
    `name` varchar(20)    COMMENT '用户名',  
    `status` varchar(20)    COMMENT '状态',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





