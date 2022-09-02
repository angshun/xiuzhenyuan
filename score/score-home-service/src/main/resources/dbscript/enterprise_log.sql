-- ----------------------------
-- Table structure for `enterprise_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `enterprise_log`;
CREATE TABLE `enterprise_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id（日志id）',  
    `staff_id` bigint    COMMENT '员工id',  
    `log_content` varchar(255)    COMMENT '日志内容',  
    `approve_num` int(2)    COMMENT '点赞数',  
    `comment_num` int(2)    COMMENT '评论数',  
    `picture` varchar(255)    COMMENT '日志图片',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





