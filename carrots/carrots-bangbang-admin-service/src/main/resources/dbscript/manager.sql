-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
-- DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `mobile` varchar(20)    COMMENT '手机号码',  
    `r_id` bigint    COMMENT '角色id',  
    `pwd` varchar(100)    COMMENT '密码',  
    `name` varchar(50)    COMMENT '用户名',  
    `status` varchar(20)    COMMENT '',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





