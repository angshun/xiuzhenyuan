-- ----------------------------
-- Table structure for `staff_philosophy_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `staff_philosophy_relation`;
CREATE TABLE `staff_philosophy_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` int(2)    COMMENT '员工id',  
    `philosophy_id` int(2)    COMMENT '文章id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





