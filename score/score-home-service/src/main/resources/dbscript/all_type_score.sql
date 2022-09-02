-- ----------------------------
-- Table structure for `all_type_score`
-- ----------------------------
-- DROP TABLE IF EXISTS `all_type_score`;
CREATE TABLE `all_type_score` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(5)    COMMENT '类型(职位0/学历1/荣耀2/职称3/特长4)',  
    `name` varchar(30)    COMMENT '积分名称',  
    `score` int(5)    COMMENT '积分',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





