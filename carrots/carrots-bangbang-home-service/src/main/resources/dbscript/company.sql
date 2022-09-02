-- ----------------------------
-- Table structure for `company`
-- ----------------------------
-- DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20) NOT NULL   COMMENT '公司名称',  
    `total_num` bigint    COMMENT '公司人数',  
    `industry` int(2)    COMMENT '公司行业',  
    `province` varchar(20)    COMMENT '省邮编',  
    `city` varchar(20)    COMMENT '市邮编',  
    `county` varchar(20)    COMMENT '县邮编',  
    `financing` int(2)    COMMENT '公司规模',  
    `approved` int(2)    COMMENT '认证状态',  
    `approved_at` bigint    COMMENT '认证时间',  
    `freezed` int(2)    COMMENT '冻结状态',  
    `slogan` varchar(100)    COMMENT '公司标语',  
    `introduction` varchar(1000)    COMMENT '公司介绍',  
    `product` varchar(20)    COMMENT '公司产品',  
    `moblile` varchar(20)    COMMENT '公司电话',  
    `address` varchar(100)    COMMENT '公司地址',  
    `logo` varchar(20)    COMMENT '公司logo',  
    `mail` varchar(50)    COMMENT '公司邮箱',  
    `map` varchar(50)    COMMENT '公司地图',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `release_at` bigint    COMMENT '发布时间',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





