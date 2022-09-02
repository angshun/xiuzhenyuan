-- ----------------------------
-- Table structure for `enterprise_approval`
-- ----------------------------
-- DROP TABLE IF EXISTS `enterprise_approval`;
CREATE TABLE `enterprise_approval` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `title` varchar(30)    COMMENT '审批标题',  
    `apply_id` bigint    COMMENT '申请人id',  
    `score_type` int(2)    COMMENT '积分类型',  
    `score` int(2)    COMMENT '申请积分',  
    `status` int(2)    COMMENT '审批状态0审批中/1审批通过/2审批未通过',  
    `content` varchar(255)    COMMENT '审批内容',  
    `picture` varchar(255)    COMMENT '审批图片',  
    `approval_id` bigint    COMMENT '审批人id',  
    `create_at` bigint    COMMENT '创建时间（申请时间）',  
    `update_at` bigint    COMMENT '更新时间（审批时间）',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





