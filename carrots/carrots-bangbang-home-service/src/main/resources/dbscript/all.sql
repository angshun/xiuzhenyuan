-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(2)    COMMENT 'article类型',  
    `title` varchar(20) NOT NULL   COMMENT '标题',  
    `img` varchar(20)    COMMENT '图片',  
    `url` varchar(100)    COMMENT '链接',  
    `status` int(2)    COMMENT '上线状态',  
    `industry` int(2)    COMMENT '行业',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '修改时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    `rank` int(2)    COMMENT '排序',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `company_tag`
-- ----------------------------
-- DROP TABLE IF EXISTS `company_tag`;
CREATE TABLE `company_tag` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `cid` bigint    COMMENT '公司id',  
    `tag` varchar(20) NOT NULL   COMMENT '标签名称',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `profession_tag`
-- ----------------------------
-- DROP TABLE IF EXISTS `profession_tag`;
CREATE TABLE `profession_tag` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `cid` bigint    COMMENT '公司id',  
    `pid` bigint    COMMENT '职业id',  
    `tag` varchar(20)    COMMENT '职业标签',  
    `create_at` bigint NOT NULL   COMMENT '创建时间',  
    `update_at` bigint NOT NULL   COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





