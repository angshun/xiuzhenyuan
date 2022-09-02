-- ----------------------------
-- Table structure for `philosophy`
-- ----------------------------
-- DROP TABLE IF EXISTS `philosophy`;
CREATE TABLE `philosophy` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `title` varchar(100) NOT NULL   COMMENT '标题',  
    `reward` int(2)    COMMENT '奖励积分',  
    `content` text    COMMENT '经营内容',  
    `project` int(2)    COMMENT '可申请方式',  
    `read_num` int(2)    COMMENT '已阅读次数',  
    `status` int(2)    COMMENT '积分状态',  
    `article_status` int(2)    COMMENT '状态（已阅读/未阅读）',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





