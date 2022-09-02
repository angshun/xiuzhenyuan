-- ----------------------------
-- Table structure for `star`
-- ----------------------------
-- DROP TABLE IF EXISTS `star`;
CREATE TABLE `star` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `grade_type` int(2)    COMMENT '等级类型',  
    `name` int(2)    COMMENT '等级名称',  
    `score` int(2)    COMMENT '等级积分',  
    `level` int(2)    COMMENT '等级',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





