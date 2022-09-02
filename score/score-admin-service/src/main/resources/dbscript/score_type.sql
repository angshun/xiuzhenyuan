-- ----------------------------
-- Table structure for `score_type`
-- ----------------------------
-- DROP TABLE IF EXISTS `score_type`;
CREATE TABLE `score_type` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `moral` varchar(20) NOT NULL   COMMENT '品德准则',  
    `content` text    COMMENT '积分详细内容',  
    `project` int(2)    COMMENT '可申请方式',  
    `score_type` int(2)    COMMENT '积分类型',  
    `times` int(2)    COMMENT '已完成次数',  
    `status` int(2)    COMMENT '积分状态',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





