-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
-- DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(30) NOT NULL   COMMENT '员工名字',  
    `img` varchar(200)    COMMENT '员工头像',  
    `phone` varchar(30) NOT NULL   COMMENT '员工手机号',  
    `pwd` varchar(50) NOT NULL   COMMENT '登录密码',  
    `department_id` int(2)    COMMENT '部门id',  
    `department_name` varchar(50)    COMMENT '部门名称',  
    `position` int(2)    COMMENT '职位id',  
    `ini_score` int(10)    COMMENT '可用点赞分数',  
    `degree_score` int(2)    COMMENT '学位积分',  
    `honor_score` int(2)    COMMENT '荣誉积分',  
    `jop_score` int(2)    COMMENT '职称积分',  
    `speciality_score` int(2)    COMMENT '特长积分',  
    `commend_score` int(10)    COMMENT '可用表彰积分',  
    `base_score` int(2)    COMMENT '基础积分',  
    `add_score` int(2)    COMMENT '加分总分',  
    `sub_score` int(2)    COMMENT '减分总分',  
    `score_situation` int(2)    COMMENT '积分情况（按年/月/日）',  
    `total_score` int(2)    COMMENT '总积分',  
    `seniority` int(2)    COMMENT '工龄',  
    `star` int(2)    COMMENT '星级',  
    `incumbency` int(10)    COMMENT '离职状态',  
    `sun_score` int(2)    COMMENT '太阳积分(每月初始化为0)',  
    `love_score` int(2)    COMMENT '爱心积分(每月初始化为0)',  
    `approval_log_num` int(2)    COMMENT '审批日志',  
    `wait_approval_num` int(2)    COMMENT '待我审批',  
    `my_approval_num` int(2)    COMMENT '我发起的',  
    `my_copy_num` int(2)    COMMENT '我的抄送',  
    `ranking` int(2)    COMMENT '积分排行',  
    `join_rank` int(2)    COMMENT '是否参与积分排行',  
    `entry_at` bigint    COMMENT '入职时间',  
    `role` int(2)    COMMENT '员工角色',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





