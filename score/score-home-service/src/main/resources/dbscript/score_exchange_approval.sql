-- ----------------------------
-- Table structure for `score_exchange_approval`
-- ----------------------------
-- DROP TABLE IF EXISTS `score_exchange_approval`;
CREATE TABLE `score_exchange_approval` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_name` varchar(255)    COMMENT '用户姓名',  
    `goods_id` bigint    COMMENT '商品id',  
    `exchange_status` int(2)    COMMENT '兑换状态',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





