-- ----------------------------
-- Table structure for `reward_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `reward_log`;
CREATE TABLE `reward_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `admin_Name` varchar(255)    COMMENT '管理员姓名',  
    `admin_photo` varchar(255)    COMMENT '管理员头像',  
    `reward_content` varchar(255)    COMMENT '表扬内容',  
    `reward_score` varchar(255)    COMMENT '表扬积分',  
    `reward_remark` varchar(255)    COMMENT '审批备注',  
    `reward_title` varchar(255)    COMMENT '表扬标题',  
    `score_type` int(2)    COMMENT '积分类型',  
    `create_at` bigint    COMMENT '创建时间（获得积分时间）',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





