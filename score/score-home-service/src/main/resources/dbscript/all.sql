-- ----------------------------
-- Table structure for `article`
-- ----------------------------
-- DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `url` varchar(255)    COMMENT '跳转链接',  
    `img` varchar(255)    COMMENT '配图链接',  
    `type` int(2)    COMMENT '发布位置类型',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '修改时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `all_type_score`
-- ----------------------------
-- DROP TABLE IF EXISTS `all_type_score`;
CREATE TABLE `all_type_score` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(5)    COMMENT '类型(职位0/学历1/荣耀2/职称3/特长4)',  
    `name` varchar(30)    COMMENT '积分名称',  
    `score` int(5)    COMMENT '积分',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `department`
-- ----------------------------
-- DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(30) NOT NULL   COMMENT '部门名称',  
    `parent_id` int(5)    COMMENT '父id',  
    `is_parent` int(2)    COMMENT '是否为父级',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `score_type`
-- ----------------------------
-- DROP TABLE IF EXISTS `score_type`;
CREATE TABLE `score_type` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `moral` varchar(20) NOT NULL   COMMENT '品德准则',  
    `content` text    COMMENT '积分详细内容',  
    `project` int(2)    COMMENT '可申请方式',  
    `score_type` int(2)    COMMENT '积分类型',  
    `times` int(2)    COMMENT '已完成次数',  
    `status` int(2)    COMMENT '积分状态',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `philosophy`
-- ----------------------------
-- DROP TABLE IF EXISTS `philosophy`;
CREATE TABLE `philosophy` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `title` varchar(100) NOT NULL   COMMENT '标题',  
    `reward` int(2)    COMMENT '奖励积分',  
    `content` text    COMMENT '经营内容',  
    `project` int(2)    COMMENT '可申请方式',  
    `read_num` int(2)    COMMENT '已阅读次数',  
    `status` int(2)    COMMENT '积分状态',  
    `article_status` int(2)    COMMENT '状态（已阅读/未阅读）',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `staff_philosophy_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `staff_philosophy_relation`;
CREATE TABLE `staff_philosophy_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` int(2)    COMMENT '员工id',  
    `philosophy_id` int(2)    COMMENT '文章id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
-- DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `content` text    COMMENT '通告内容',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `star`
-- ----------------------------
-- DROP TABLE IF EXISTS `star`;
CREATE TABLE `star` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `grade_type` int(2)    COMMENT '等级类型',  
    `name` int(2)    COMMENT '等级名称',  
    `score` int(2)    COMMENT '等级积分',  
    `level` int(2)    COMMENT '等级',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `role`
-- ----------------------------
-- DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20)    COMMENT '角色名字',  
    `status` varchar(20)    COMMENT '状态',  
    `permissions` text    COMMENT '权限',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
-- DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `phone` varchar(20)    COMMENT '手机号码',  
    `role_id` bigint    COMMENT '角色id',  
    `nick` varchar(20)    COMMENT '',  
    `pwd` varchar(20)    COMMENT '密码',  
    `region` text    COMMENT '',  
    `company` varchar(200)    COMMENT '',  
    `type` varchar(20)    COMMENT '',  
    `name` varchar(20)    COMMENT '用户名',  
    `status` varchar(20)    COMMENT '状态',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `module`
-- ----------------------------
-- DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `name` varchar(20)    COMMENT '模块名称',  
    `parent_id` bigint    COMMENT '父模块id',  
    `type` varchar(20)    COMMENT '模块类型',  
    `menu_id` bigint    COMMENT '菜单id',  
    `icon` varchar(50)    COMMENT '图标',  
    `level` int(2)    COMMENT '等级',  
    `url` varchar(100)    COMMENT '模块url',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
-- DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `role_id` bigint    COMMENT '角色id',  
    `module_id` bigint    COMMENT '模块id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `daily_attendance`
-- ----------------------------
-- DROP TABLE IF EXISTS `daily_attendance`;
CREATE TABLE `daily_attendance` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `attendance_type` int(2)    COMMENT '考勤类型0内勤1外勤',  
    `normal_score` int(2)    COMMENT '正常奖励分数',  
    `morning_score` int(2)    COMMENT '早到奖励积分',  
    `late_score` int(2)    COMMENT '迟到减积分',  
    `overtime_score` int(2)    COMMENT '加班奖励积分',  
    `left_early_score` int(2)    COMMENT '早退减积分',  
    `absence_score` int(2)    COMMENT '缺勤扣积分',  
    `work_time` bigint    COMMENT '上班时间',  
    `closing_time` bigint    COMMENT '下班时间',  
    `company_coordinate` varchar(255)    COMMENT '公司地址(经纬度)',  
    `attendance_instance` bigint    COMMENT '考勤校验距离',  
    `outside_work_time_score` int(2)    COMMENT '外勤正常上班时间奖励',  
    `outside_closing_time_score` int(2)    COMMENT '外勤正常下班时间奖励',  
    `log_release_time` int(2)    COMMENT '每天发布日志次数',  
    `approve_score` int(2)    COMMENT '点赞他人日报获得积分',  
    `be_approve_score` int(2)    COMMENT '日报被赞获得积分',  
    `love_score` int(2)    COMMENT '爱心积分',  
    `sun_score` int(2)    COMMENT '太阳积分',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `enterprise_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `enterprise_log`;
CREATE TABLE `enterprise_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id（日志id）',  
    `staff_id` bigint    COMMENT '员工id',  
    `log_content` varchar(255)    COMMENT '日志内容',  
    `approve_num` int(2)    COMMENT '点赞数',  
    `comment_num` int(2)    COMMENT '评论数',  
    `picture` varchar(255)    COMMENT '日志图片',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `score_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `score_log`;
CREATE TABLE `score_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `score_reason` int(2)    COMMENT '积分项目',  
    `score_change` varchar(30)    COMMENT '积分变动',  
    `score_type` int(2)    COMMENT '积分类型',  
    `create_at` bigint    COMMENT '创建时间（获得积分时间）',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




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




-- ----------------------------
-- Table structure for `operation_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `admin` varchar(255)    COMMENT '操作人（管理员）',  
    `operation` varchar(255)    COMMENT '操作类型',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `attendance_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `attendance_log`;
CREATE TABLE `attendance_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `attendance_type` int(2)    COMMENT '考勤类型',  
    `attendance_address` varchar(255)    COMMENT '考勤地址',  
    `attendance_status` int(2)    COMMENT '考勤状态',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `approve_log`
-- ----------------------------
-- DROP TABLE IF EXISTS `approve_log`;
CREATE TABLE `approve_log` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `type` int(2)    COMMENT '点赞类型（点赞日志、点赞人）',  
    `log_id` bigint    COMMENT '日志id/被点赞人id',  
    `attendance_type` int(2)    COMMENT '点赞人id',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `staff_task_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `staff_task_relation`;
CREATE TABLE `staff_task_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `staff_id` bigint    COMMENT '员工id',  
    `task_id` bigint    COMMENT '任务id',  
    `attendance_type` int(2)    COMMENT '任务状态（0已参与/1已完成）',  
    `task_type` int(2)    COMMENT '任务类型',  
    `create_at` bigint    COMMENT '创建时间(考勤时间)',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `copy_relation`
-- ----------------------------
-- DROP TABLE IF EXISTS `copy_relation`;
CREATE TABLE `copy_relation` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `record_id` bigint    COMMENT '申请记录id',  
    `copy_id` bigint    COMMENT '抄送人id',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for `apply_manage`
-- ----------------------------
-- DROP TABLE IF EXISTS `apply_manage`;
CREATE TABLE `apply_manage` (
    `id` bigint NOT NULL   AUTO_INCREMENT  COMMENT '自增id',  
    `module_id` bigint    COMMENT '模块编号',  
    `status` int(2)    COMMENT '状态0下线/1上线',  
    `create_at` bigint    COMMENT '创建时间',  
    `update_at` bigint    COMMENT '更新时间',  
    `create_by` bigint    COMMENT '创建人',  
    `update_by` bigint    COMMENT '更新人',  
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;





