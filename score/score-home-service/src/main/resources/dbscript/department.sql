-- ----------------------------
-- Table structure for `department`
-- ----------------------------
-- DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(30) NOT NULL   COMMENT '部门名称',  
    `parent_id` int(5)    COMMENT '父id',  
    `is_parent` int(2)    COMMENT '是否为父级',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





