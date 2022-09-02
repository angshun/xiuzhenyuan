-- ----------------------------
-- Table structure for `task`
-- ----------------------------
-- DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20) NOT NULL   COMMENT '任务名称',  
    `title` varchar(100)    COMMENT '任务标题',  
    `content` text    COMMENT '任务内容',  
    `points_type` int(2)    COMMENT '积分类型',  
    `task_type` int(2)    COMMENT '任务类型',  
    `project` int(2)    COMMENT '可申请方式',  
    `start_at` bigint    COMMENT '任务开始时间',  
    `end_at` bigint    COMMENT '任务结束时间',  
    `join_num` int(2)    COMMENT '已参加人数',  
    `number` int(2)    COMMENT '限制人数',  
    `times` int(2)    COMMENT '已完成次数',  
    `task_score` int(2)    COMMENT '任务积分',  
    `visual_department` varchar(50)    COMMENT '可见部门(数组)',  
    `task_status` int(2)    COMMENT '任务状态（始终为null，表示参与/未参与/完成）',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





