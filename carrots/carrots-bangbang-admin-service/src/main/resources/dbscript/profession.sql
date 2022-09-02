-- ----------------------------
-- Table structure for `profession`
-- ----------------------------
-- DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20) NOT NULL   COMMENT '职业名称',  
    `c_id` bigint    COMMENT '公司id',  
    `release_at` bigint    COMMENT '发布时间',  
    `salary` int(2)    COMMENT '薪资',  
    `education` int(2)    COMMENT '学历',  
    `work_experience` int(2)    COMMENT '工作经验',  
    `status` int(2)    COMMENT '上架状态',  
    `responsibility` varchar(1000)    COMMENT '岗位职责',  
    `requirement` varchar(1000)    COMMENT '必备条件',  
    `welfare` varchar(1000)    COMMENT '公司福利',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '修改时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





