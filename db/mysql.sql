-- 菜单
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) COMMENT '菜单名称',
  `url` varchar(200) COMMENT '菜单URL',
  `perms` varchar(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) COMMENT '菜单图标',
  `order_num` int COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='菜单管理';

-- 系统用户
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) COMMENT '密码',
  `salt` varchar(20) COMMENT '盐',
  `email` varchar(100) COMMENT '邮箱',
  `mobile` varchar(100) COMMENT '手机号',
  `orgcode` varchar(10) COMMENT '用户隶属机构代码',
  `status` tinyint COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) COMMENT '创建者ID',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统用户';

-- 系统用户Token
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统用户Token';

-- 系统验证码
CREATE TABLE `sys_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统验证码';

-- 角色
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) COMMENT '角色名称',
  `remark` varchar(100) COMMENT '备注',
  `create_user_id` bigint(20) COMMENT '创建者ID',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='角色';

-- 用户与角色对应关系
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint COMMENT '用户ID',
  `role_id` bigint COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='用户与角色对应关系';

-- 角色与菜单对应关系
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint COMMENT '角色ID',
  `menu_id` bigint COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='角色与菜单对应关系';

-- 系统配置信息
CREATE TABLE `sys_config` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`param_key` varchar(50) COMMENT 'key',
	`param_value` varchar(2000) COMMENT 'value',
	`status` tinyint DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
	`remark` varchar(500) COMMENT '备注',
	PRIMARY KEY (`id`),
	UNIQUE INDEX (`param_key`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统配置信息表';


-- 系统日志
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COMMENT '用户名',
  `operation` varchar(50) COMMENT '用户操作',
  `method` varchar(200) COMMENT '请求方法',
  `params` varchar(5000) COMMENT '请求参数',
  `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) COMMENT 'IP地址',
  `create_date` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='系统日志';


-- 文件上传
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) COMMENT 'URL地址',
  `create_date` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='文件上传';


-- 定时任务
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='定时任务';

-- 定时任务日志
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='定时任务日志';



-- 用户表
CREATE TABLE `tb_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) COMMENT '密码',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='用户';






-- 初始数据
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `salt`, `email`, `mobile`, `status`, `create_user_id`, `create_time`) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');

INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (5, 1, 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);

INSERT INTO `sys_config` (`param_key`, `param_value`, `status`, `remark`) VALUES ('CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');
INSERT INTO `schedule_job` (`bean_name`, `params`, `cron_expression`, `status`, `remark`, `create_time`) VALUES ('testTask', 'renren', '0 0/30 * * * ?', '0', '参数测试', now());


-- 账号：13612345678  密码：admin
INSERT INTO `tb_user` (`username`, `mobile`, `password`, `create_time`) VALUES ('mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');








--  quartz自带表结构
CREATE TABLE QRTZ_JOB_DETAILS(
SCHED_NAME VARCHAR(120) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
JOB_CLASS_NAME VARCHAR(250) NOT NULL,
IS_DURABLE VARCHAR(1) NOT NULL,
IS_NONCONCURRENT VARCHAR(1) NOT NULL,
IS_UPDATE_DATA VARCHAR(1) NOT NULL,
REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
NEXT_FIRE_TIME BIGINT(13) NULL,
PREV_FIRE_TIME BIGINT(13) NULL,
PRIORITY INTEGER NULL,
TRIGGER_STATE VARCHAR(16) NOT NULL,
TRIGGER_TYPE VARCHAR(8) NOT NULL,
START_TIME BIGINT(13) NOT NULL,
END_TIME BIGINT(13) NULL,
CALENDAR_NAME VARCHAR(200) NULL,
MISFIRE_INSTR SMALLINT(2) NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
REPEAT_COUNT BIGINT(7) NOT NULL,
REPEAT_INTERVAL BIGINT(12) NOT NULL,
TIMES_TRIGGERED BIGINT(10) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CRON_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
CRON_EXPRESSION VARCHAR(120) NOT NULL,
TIME_ZONE_ID VARCHAR(80),
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
BLOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CALENDARS (
SCHED_NAME VARCHAR(120) NOT NULL,
CALENDAR_NAME VARCHAR(200) NOT NULL,
CALENDAR BLOB NOT NULL,
PRIMARY KEY (SCHED_NAME,CALENDAR_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
ENTRY_ID VARCHAR(95) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
FIRED_TIME BIGINT(13) NOT NULL,
SCHED_TIME BIGINT(13) NOT NULL,
PRIORITY INTEGER NOT NULL,
STATE VARCHAR(16) NOT NULL,
JOB_NAME VARCHAR(200) NULL,
JOB_GROUP VARCHAR(200) NULL,
IS_NONCONCURRENT VARCHAR(1) NULL,
REQUESTS_RECOVERY VARCHAR(1) NULL,
PRIMARY KEY (SCHED_NAME,ENTRY_ID))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SCHEDULER_STATE (
SCHED_NAME VARCHAR(120) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
CHECKIN_INTERVAL BIGINT(13) NOT NULL,
PRIMARY KEY (SCHED_NAME,INSTANCE_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_LOCKS (
SCHED_NAME VARCHAR(120) NOT NULL,
LOCK_NAME VARCHAR(40) NOT NULL,
PRIMARY KEY (SCHED_NAME,LOCK_NAME))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);


CREATE TABLE `code_organ`  (
                               `code` varchar(10) NOT NULL COMMENT '代码',
                               `name` varchar(300) NOT NULL COMMENT '机构名称',
                               `areacode` varchar(6) NOT NULL COMMENT '行政区划',
                               `sealid` varchar(100) NULL DEFAULT NULL COMMENT '电子印章编号',
                               `uniscid` varchar(25) NOT NULL COMMENT '机构代码',
                               `enabled` tinyint(1) NOT NULL COMMENT '是否可用 1可用，0不可用',
                               `datasource` varchar(3) NULL DEFAULT NULL COMMENT '数据源',
                               `parentcode` varchar(10) NULL DEFAULT NULL COMMENT '父级代码',
                               PRIMARY KEY (`code`) USING BTREE,
                               INDEX `idx_code_organ_areacode`(`areacode`) USING BTREE
) COMMENT = '登记机关代码表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_organ
-- ----------------------------
INSERT INTO `code_organ` VALUES ('230000', '黑龙江省市场监督管理局mysql', '230000', '23000000005997', '', 1, NULL, '000000');
INSERT INTO `code_organ` VALUES ('230100', '哈尔滨市市场监督管理局', '230100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230102', '哈尔滨市道里区市场监督管理局', '230102', '123', '123', 1, NULL, '230100');
INSERT INTO `code_organ` VALUES ('230103', '哈尔滨市南岗区市场监督管理局', '230103', '123', '123', 1, NULL, '230100');
INSERT INTO `code_organ` VALUES ('230200', '齐齐哈尔市市场监督管理局', '230200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230201', '齐齐哈尔市龙华区市场监督管理局', '230202', '123', '123', 1, NULL, '230200');
INSERT INTO `code_organ` VALUES ('230300', '鸡西市市场监督管理局', '230300', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230302', '鸡西市鸡东区市场监督管理局', '230302', '123', '123', 1, NULL, '230300');
INSERT INTO `code_organ` VALUES ('230400', '鹤岗市市场监督管理局', '230400', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230500', '双鸭山市市场监督管理局', '230500', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230600', '大庆市市场监督管理局', '230600', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230700', '伊春市市场监督管理局', '230700', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230800', '佳木斯市市场监督管理局', '230800', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230900', '七台河市市场监督管理局', '230900', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231000', '牡丹江市市场监督管理局', '231000', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231100', '黑河市市场监督管理局', '231100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231200', '绥化市市场监督管理局', '231200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('232700', '大兴安岭地区市场监督管理局', '232700', '23000000005997', '', 1, NULL, '230000');

COMMIT;

-- 外网用户Token
CREATE TABLE `nf_wuser_token` (
                                  `id` bigint(20) NOT NULL,
                                  `token` varchar(100) NOT NULL COMMENT 'token',
                                  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `token` (`token`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='外网用户Token';

-- 外网系统验证码
CREATE TABLE `nf_wcaptcha` (
                               `uuid` char(36) NOT NULL COMMENT 'uuid',
                               `code` varchar(6) NOT NULL COMMENT '验证码',
                               `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
                               PRIMARY KEY (`uuid`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COMMENT='外网系统验证码';

-- 外网用户
CREATE TABLE `nf_wuser`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `username` varchar(50) NOT NULL COMMENT '用户名',
                             `password` varchar(100) NULL DEFAULT NULL COMMENT '密码',
                             `salt` varchar(20) NULL DEFAULT NULL COMMENT '盐',
                             `email` varchar(100) NULL DEFAULT NULL COMMENT '邮箱',
                             `mobile` varchar(100) NULL DEFAULT NULL COMMENT '手机号',
                             `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：删除   1：正常   2：禁用',
                             `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                             `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB COMMENT = '外网用户' ROW_FORMAT = Dynamic;

-- 冷藏冷冻食品贮存服务提供者
CREATE TABLE `nf_rffssp`  (
                              `id` varchar(30)  NOT NULL COMMENT '冷藏冷冻食品贮存服务提供者ID',
                              `status` tinyint(0) NOT NULL COMMENT '状态 1 录入  2 提交  3 业务完成',
                              `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                              `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                              `valid` int(0) NOT NULL COMMENT '是否有效：1有效 0无效',
                              `issueorg` varchar(10)  NULL DEFAULT NULL COMMENT '管理机构ID',
                              `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '办理备案日期',
                              `apply_name` varchar(255)  NULL DEFAULT NULL COMMENT '申请人姓名',
                              `apply_contact_info` varchar(255)  NULL DEFAULT NULL COMMENT '申请人联系方式',
                              `unisc_id` varchar(255)  NULL DEFAULT NULL COMMENT '统一社会信用代码',
                              `storage_ent_name` varchar(255)  NULL DEFAULT NULL COMMENT '从事冷藏冷冻食品贮存业务的非食品生产经营者名称',
                              `le_rep` varchar(255)  NULL DEFAULT NULL COMMENT '法定代表人（负责人）',
                              `le_rep_no` varchar(255)  NULL DEFAULT NULL COMMENT '法定代表人（负责人）身份证号码',
                              `contract_name` varchar(255)  NULL DEFAULT NULL COMMENT '联系人',
                              `contract_tel` varchar(255)  NULL DEFAULT NULL COMMENT '联系电话',
                              `storage_name` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库名称',
                              `storage_province` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）代码',
                              `storage_prov_name` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）',
                              `storage_city` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）代码',
                              `storage_city_name` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）',
                              `storage_county` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）代码',
                              `storage_county_name` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）',
                              `storage_address` varchar(255)  NULL DEFAULT NULL COMMENT '冷藏冷冻库详细地址',
                              `storage_power_ton` varchar(255)  NULL DEFAULT NULL COMMENT '贮存能力（单位：吨）',
                              `storage_power_cubic_meter` varchar(255)  NULL DEFAULT NULL COMMENT '贮存能力（单位：立方米）',
                              `rec_num` varchar(255)  NULL DEFAULT NULL COMMENT '备案编号',
                              `rec_time` datetime(0) NULL DEFAULT NULL COMMENT '备案日期',
                              `entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
                              `safety_standards` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）是否符合食品安全标准',
                              `storage_area` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）贮存面积',
                              `storage_capacity` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）贮存容积',
                              `equipment_name_specification` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）冷藏冷冻设施、设备名称规格及数量',
                              `humidity_control_range` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）温度、湿度控制范围',
                              `bumber_explicit_thermometers` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）可正确显示内部温度的温度计和外显式温度计数量',
                              `keep_clean` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）贮存设备、容器和工具是否无毒无害、保持清洁',
                              `is_ground` varchar(255)  NULL DEFAULT NULL COMMENT '（贮存能力）是否分区分架分类存放食品，是否离地离墙10cm',
                              `is_disinfect` varchar(255)  NULL DEFAULT NULL COMMENT '是否有校验消毒清洁维护制度及记录',
                              `other_categories` varchar(255)  NULL DEFAULT NULL COMMENT '其他非食品类贮存品类别',
                              `remarks` varchar(255)  NULL DEFAULT NULL COMMENT '备注',
                              `canclecause` text  NULL DEFAULT NULL COMMENT '注销原因',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '冷藏冷冻食品贮存服务提供者' ROW_FORMAT = Dynamic;

-- 业务表
CREATE TABLE `nf_busin`  (
                              `id` varchar(30) NOT NULL COMMENT '业务ID',
                              `btype` varchar(3) NOT NULL COMMENT '业务类型： 10：内网备案申报 20：外网备案申报 11：内网备案变更申报 21：外网备案变更申报 12：内网备案注销申报 22：外网备案注销申报',
                              `status` varchar(3) NOT NULL COMMENT '业务状态 21：未完成  11：受理不通过  21：审核不通过 22：待受理  12：受理通过  22：审核通过',
                              `rffsspid` varchar(30) NOT NULL COMMENT '备案ID',
                              `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                              `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                              PRIMARY KEY (`id`) USING BTREE,
                             INDEX `rffsspid`(`rffsspid`) USING BTREE
) ENGINE = InnoDB COMMENT = '业务表' ROW_FORMAT = Dynamic;

-- 代理人
CREATE TABLE `nf_agent`  (
                             `id` varchar(30) NOT NULL COMMENT '代理人ID',
                             `name` varchar(30)  NULL COMMENT '代理人姓名',
                             `mobile` varchar(20)  NULL COMMENT '代理人联系方式',
                             `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
                             `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                             `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `businid`(`businid`) USING BTREE,
                             INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB COMMENT = '代理人' ROW_FORMAT = Dynamic;

-- 材料表
CREATE TABLE `nf_material`  (
                                `id` varchar(30) NOT NULL COMMENT '材料ID',
                                `mtype` varchar(3) NOT NULL COMMENT '材料类型：10 冷藏冷冻贮存场所布局图 20 法定代表人或者负责人身份证明复印件人像面 21 法定代表人或者负责人身份证明复印件国徽面 30 所提交资料真实性承诺书',
                                `morder` int(2)  NULL COMMENT '同材料类型的顺序号',
                                `mpath` varchar(400) NOT NULL COMMENT '材料地址',
                                `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
                                `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                                PRIMARY KEY (`id`) USING BTREE,
                             INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '材料表' ROW_FORMAT = Dynamic;

-- 操作记录
CREATE TABLE `nf_opt`  (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '操作记录ID',
                                `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
                                `module` varchar(30) NOT NULL COMMENT '操作模块名称',
                                `ouser` bigint(20)  NULL COMMENT '操作人员',
                                `ip` varchar(20) NULL COMMENT 'IP地址',
                                `duration` bigint(20) NULL DEFAULT NULL COMMENT '执行时长(毫秒)',
                                `otime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
                                PRIMARY KEY (`id`) USING BTREE,
                             INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '操作记录' ROW_FORMAT = Dynamic;

-- 受理审核
CREATE TABLE `nf_checked`  (
                           `id` bigint(20) NOT NULL COMMENT '受理审核ID',
                           `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
                           `name` varchar(30) NOT NULL COMMENT '受理审核人员',
                           `cresult` varchar(2)  NULL COMMENT '受理审核结果： 1 为不通过  2  为通过',
                           `opinions` varchar(3000) NULL COMMENT '受理审核意见',
                           `ctime` datetime(0) NULL DEFAULT NULL COMMENT '受理审核时间',
                           `ctype` varchar(2) NULL DEFAULT NULL COMMENT '受理审核类型: 1 为受理    2  为审核',
                           `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                           `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                           PRIMARY KEY (`id`) USING BTREE,
                            INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '操作记录' ROW_FORMAT = Dynamic;

-- 外网用户与主体关联表
CREATE TABLE `nf_rffssp_user`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `rffsspid` varchar(30) NOT NULL COMMENT '备案ID',
                             `userid` bigint(20) NOT NULL COMMENT '外网用户ID',
                             `status` tinyint NOT NULL COMMENT '状态  0：解绑   1：正常',
                             `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                             `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `rffsspid`(`rffsspid`) USING BTREE,
                             INDEX `userid`(`userid`) USING BTREE
) ENGINE = InnoDB COMMENT = '外网用户与主体关联表' ROW_FORMAT = Dynamic;
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (100, 0, '备案申请', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (110, 100, '备案申请', 'nfrecord/apply', NULL, 1, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (111, 110, '查看', NULL, 'nfrecord:apply:list,nfrecord:apply:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (112, 110, '新增', NULL, 'nfrecord:apply:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (113, 110, '修改', NULL, 'nfrecord:apply:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (114, 110, '删除', NULL, 'nfrecord:apply:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (120, 100, '变更申请', 'nfrecord/change', '', 1, 'log', 2);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (121, 120, '查看', NULL, 'nfrecord:change:list,nfrecord:change:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (122, 120, '新增', NULL, 'nfrecord:change:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (123, 120, '修改', NULL, 'nfrecord:change:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (124, 120, '删除', NULL, 'nfrecord:change:delete', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (130, 100, '注销申请', 'nfrecord/cancel', '', 1, 'log', 3);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (131, 130, '查看', NULL, 'nfrecord:cancel:list,nfrecord:cancel:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (132, 130, '新增', NULL, 'nfrecord:cancel:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (133, 130, '修改', NULL, 'nfrecord:cancel:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (134, 130, '删除', NULL, 'nfrecord:cancel:delete', 2, NULL, 0);

INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (200, 0, '备案受理', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (210, 200, '备案受理', 'nfrecord/applya', NULL, 1, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (211, 210, '查看', NULL, 'nfrecord:applya:list,nfrecord:applya:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (212, 210, '受理', NULL, 'nfrecord:applya:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (213, 210, '修改', NULL, 'nfrecord:applya:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (220, 200, '变更受理', 'nfrecord/changea', '', 1, 'log', 2);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (221, 220, '查看', NULL, 'nfrecord:changea:list,nfrecord:changea:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (222, 220, '受理', NULL, 'nfrecord:changea:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (223, 220, '修改', NULL, 'nfrecord:changea:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (230, 200, '注销受理', 'nfrecord/cancela', '', 1, 'log', 3);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (231, 230, '查看', NULL, 'nfrecord:cancela:list,nfrecord:cancela:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (232, 230, '受理', NULL, 'nfrecord:cancela:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (233, 230, '修改', NULL, 'nfrecord:cancela:update', 2, NULL, 0);

INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (300, 0, '备案审核', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (310, 300, '备案审核', 'nfrecord/applyc', NULL, 1, 'log', 1);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (311, 310, '查看', NULL, 'nfrecord:applyc:list,nfrecord:applyc:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (312, 310, '审核', NULL, 'nfrecord:applyc:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (313, 310, '修改', NULL, 'nfrecord:applyc:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (320, 300, '变更审核', 'nfrecord/changec', '', 1, 'log', 2);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (321, 320, '查看', NULL, 'nfrecord:changec:list,nfrecord:changec:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (322, 320, '审核', NULL, 'nfrecord:changec:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (323, 320, '修改', NULL, 'nfrecord:changec:update', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (330, 300, '注销审核', 'nfrecord/cancelc', '', 1, 'log', 3);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (331, 330, '查看', NULL, 'nfrecord:cancelc:list,nfrecord:cancelc:info', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (332, 330, '审核', NULL, 'nfrecord:cancelc:save', 2, NULL, 0);
INSERT INTO `sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (333, 330, '修改', NULL, 'nfrecord:cancelc:update', 2, NULL, 0);

COMMIT;



DROP TABLE IF EXISTS `code_addiv`;
CREATE TABLE `code_addiv`  (
                               `code` varchar(10)  NOT NULL COMMENT '行政区划',
                               `name` varchar(30)  NOT NULL COMMENT '行政名称',
                               `parent` varchar(10)  NOT NULL COMMENT '父级行政区划',
                               `level` varchar(1)  NULL DEFAULT NULL COMMENT '行政级别：1为省，2为市，3为区县，4为乡镇、社区、街道',
                               `enabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否可用 1可用，0不可用',
                               PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_addiv
-- ----------------------------
INSERT INTO `code_addiv` VALUES ('230000', '黑龙江省', '000000', '1', 1);
INSERT INTO `code_addiv` VALUES ('230100', '哈尔滨市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230102', '道里区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230103', '南岗区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230104', '道外区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230108', '平房区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230109', '松北区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230110', '香坊区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230111', '呼兰区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230112', '阿城区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230113', '双城区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230123', '依兰县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230124', '方正县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230125', '宾县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230126', '巴彦县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230127', '木兰县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230128', '通河县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230129', '延寿县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230183', '尚志市', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230184', '五常市', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230200', '齐齐哈尔市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230202', '龙沙区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230203', '建华区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230204', '铁锋区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230205', '昂昂溪区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230206', '富拉尔基区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230207', '碾子山区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230208', '梅里斯达斡尔族区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230221', '龙江县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230223', '依安县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230224', '泰来县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230225', '甘南县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230227', '富裕县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230229', '克山县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230230', '克东县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230231', '拜泉县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230281', '讷河市', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230300', '鸡西市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230302', '鸡冠区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230303', '恒山区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230304', '滴道区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230305', '梨树区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230306', '城子河区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230307', '麻山区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230321', '鸡东县', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230381', '虎林市', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230382', '密山市', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230400', '鹤岗市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230402', '向阳区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230403', '工农区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230404', '南山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230405', '兴安区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230406', '东山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230407', '兴山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230421', '萝北县', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230422', '绥滨县', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230500', '双鸭山市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230502', '尖山区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230503', '岭东区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230505', '四方台区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230506', '宝山区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230521', '集贤县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230522', '友谊县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230523', '宝清县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230524', '饶河县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230600', '大庆市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230602', '萨尔图区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230603', '龙凤区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230604', '让胡路区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230605', '红岗区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230606', '大同区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230621', '肇州县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230622', '肇源县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230623', '林甸县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230624', '杜尔伯特蒙古族自治县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230700', '伊春市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230717', '伊美区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230718', '乌翠区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230719', '友好区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230722', '嘉荫县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230723', '汤旺县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230724', '丰林县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230725', '大箐山县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230726', '南岔县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230751', '金林区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230781', '铁力市', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230800', '佳木斯市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230803', '向阳区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230804', '前进区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230805', '东风区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230811', '郊区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230822', '桦南县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230826', '桦川县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230828', '汤原县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230881', '同江市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230882', '富锦市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230883', '抚远市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230900', '七台河市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230902', '新兴区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230903', '桃山区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230904', '茄子河区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230921', '勃利县', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('231000', '牡丹江市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231002', '东安区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231003', '阳明区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231004', '爱民区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231005', '西安区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231025', '林口县', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231081', '绥芬河市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231083', '海林市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231084', '宁安市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231085', '穆棱市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231086', '东宁市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231100', '黑河市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231102', '爱辉区', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231123', '逊克县', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231124', '孙吴县', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231181', '北安市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231182', '五大连池市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231183', '嫩江市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231200', '绥化市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231202', '北林区', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231221', '望奎县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231222', '兰西县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231223', '青冈县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231224', '庆安县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231225', '明水县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231226', '绥棱县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231281', '安达市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231282', '肇东市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231283', '海伦市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('232700', '大兴安岭地区', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('232701', '漠河市', '232700', '3', 1);
INSERT INTO `code_addiv` VALUES ('232721', '呼玛县', '232700', '3', 1);
INSERT INTO `code_addiv` VALUES ('232722', '塔河县', '232700', '3', 1);

-- 出库入库

CREATE TABLE `nf_inbound_and_outbound`  (
                                            `id` bigint(0) NOT NULL,
                                            `rffssp_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '冷藏备案id',
                                            `type` int(0) NULL DEFAULT NULL COMMENT '0入库1出库',
                                            `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
                                            `types_of` int(0) NULL DEFAULT NULL COMMENT '1食品2食用农产品',
                                            `num` bigint(0) NULL DEFAULT NULL COMMENT '数量',
                                            `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
                                            `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                            `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
                                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `nf_samr_rffss`.`sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (400, 0, '审核完成', '', '', 0, 'log', 1);
INSERT INTO `nf_samr_rffss`.`sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (401, 400, '出库or入库', 'nfrecord/check', 'nfrecord:check:list', 1, NULL, 1);
INSERT INTO `nf_samr_rffss`.`sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (402, 400, '备案查询', 'nfrecord/statistics', 'nfrecord:statistics:list', 1, NULL, 2);
INSERT INTO `nf_samr_rffss`.`sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (403, 400, '入库统计', 'nfrecord/inbound', 'nfrecord:inbound:list', 1, NULL, 3);
INSERT INTO `nf_samr_rffss`.`sys_menu`(`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (404, 400, '风险警告', 'nfrecord/warn', 'nfrecord:warn:list', 1, NULL, 4);
