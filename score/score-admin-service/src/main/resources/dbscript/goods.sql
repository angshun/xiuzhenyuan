-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
-- DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(30)    COMMENT '商品名称',  
    `img` varchar(100)    COMMENT '商品图片',  
    `content` text    COMMENT '商品详情',  
    `score` int(2)    COMMENT '兑换积分',  
    `number` int(2)    COMMENT '商品数量',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





