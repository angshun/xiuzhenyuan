-- ----------------------------
-- Table structure for `product`
-- ----------------------------
-- DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20) NOT NULL   COMMENT '产品名称',  
    `logo` varchar(20)    COMMENT '产品logo',  
    `summary` varchar(1000)    COMMENT '产品简介',  
    `slogan` varchar(50)    COMMENT '产品标语',  
    `cid` bigint    COMMENT '公司id',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





