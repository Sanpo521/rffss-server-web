-- 菜单
CREATE TABLE sys_menu (
  menu_id NUMBER(20, 0) NOT NULL,
  parent_id NUMBER(20, 0) NOT NULL,
  name varchar2(50),
  url varchar2(200),
  perms varchar2(500),
  type NUMBER(2, 0),
  icon varchar2(50),
  order_num NUMBER(8, 0),
  PRIMARY KEY (menu_id)
);

-- 系统用户
CREATE TABLE sys_user (
  user_id NUMBER(20, 0) NOT NULL,
  username varchar2(50) NOT NULL,
  password varchar2(100),
  salt varchar2(20),
  email varchar2(100),
  mobile varchar2(100),
  orgcode varchar2(10),
  status NUMBER(2, 0) NOT NULL,
  create_user_id NUMBER(20, 0) NOT NULL,
  create_time timestamp,
  PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX idx_sys_user_username on sys_user(username);

-- 系统用户Token
CREATE TABLE sys_user_token (
  user_id NUMBER(20, 0) NOT NULL,
  token varchar2(100) NOT NULL,
  expire_time timestamp,
  update_time timestamp,
  PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX idx_token on sys_user_token(token);

-- 系统验证码
CREATE TABLE sys_captcha (
  uuid varchar2(36) NOT NULL,
  code varchar2(6) NOT NULL,
  expire_time timestamp,
  PRIMARY KEY (uuid)
);

-- 角色
CREATE TABLE sys_role (
  role_id NUMBER(20, 0) NOT NULL,
  role_name varchar2(100),
  remark varchar2(100),
  create_user_id NUMBER(20, 0) NOT NULL,
  create_time timestamp,
  PRIMARY KEY (role_id)
);

-- 用户与角色对应关系
CREATE TABLE sys_user_role (
  id NUMBER(20, 0) NOT NULL,
  user_id NUMBER(20, 0) NOT NULL,
  role_id NUMBER(20, 0) NOT NULL,
  PRIMARY KEY (id)
);

-- 角色与菜单对应关系
CREATE TABLE sys_role_menu (
  id NUMBER(20, 0) NOT NULL,
  role_id NUMBER(20, 0) NOT NULL,
  menu_id NUMBER(20, 0) NOT NULL,
  PRIMARY KEY (id)
);

-- 系统配置信息
CREATE TABLE sys_config (
  id NUMBER(20, 0) NOT NULL,
  param_key varchar2(50),
  param_value varchar2(4000),
  status NUMBER(2, 0) DEFAULT 1 NOT NULL,
  remark varchar2(500),
  PRIMARY KEY (id)
);
CREATE UNIQUE INDEX idx_param_key on sys_config(param_key);


-- 系统日志
CREATE TABLE sys_log (
  id NUMBER(20, 0) NOT NULL,
  username varchar2(50),
  operation varchar2(50),
  method varchar2(200),
  params clob,
  time NUMBER(20, 0) NOT NULL,
  ip varchar2(64),
  create_date timestamp,
  PRIMARY KEY (id)
);

-- 文件上传
CREATE TABLE sys_oss (
  id NUMBER(20, 0) NOT NULL,
  url varchar2(200),
  create_date timestamp,
  PRIMARY KEY (id)
);

-- 定时任务
CREATE TABLE schedule_job (
  job_id NUMBER(20, 0) NOT NULL,
  bean_name varchar2(200),
  params varchar2(2000),
  cron_expression varchar2(100),
  status NUMBER(2, 0) NOT NULL,
  remark varchar2(255),
  create_time timestamp,
  PRIMARY KEY (job_id)
);

-- 定时任务日志
CREATE TABLE schedule_job_log (
  log_id NUMBER(20, 0) NOT NULL,
  job_id NUMBER(20, 0) NOT NULL,
  bean_name varchar2(200),
  params varchar2(2000),
  status NUMBER(2, 0) NOT NULL,
  error varchar2(2000),
  times NUMBER(10, 0) NOT NULL,
  create_time timestamp,
  PRIMARY KEY (log_id)
);
CREATE INDEX idx_job_id on schedule_job_log(job_id);

-- 用户表
CREATE TABLE tb_user (
  user_id NUMBER(20, 0) NOT NULL,
  username varchar2(50) NOT NULL,
  mobile varchar2(20) NOT NULL,
  password varchar2(64),
  create_time timestamp,
  PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX idx_tb_user_username on tb_user(username);

INSERT INTO sys_user (user_id, username, password, salt, email, mobile, status, create_user_id, create_time) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', CURRENT_DATE);

INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (5, 1, 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);



INSERT INTO sys_config (id, param_key, param_value, status, remark) VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY',  '{"aliyunAccessKeyId":"","aliyunAccessKeySecret":"","aliyunBucketName":"","aliyunDomain":"","aliyunEndPoint":"","aliyunPrefix":"","qcloudBucketName":"","qcloudDomain":"","qcloudPrefix":"","qcloudSecretId":"","qcloudSecretKey":"","qiniuAccessKey":"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ","qiniuBucketName":"ios-app","qiniuDomain":"http://7xlij2.com1.z0.glb.clouddn.com","qiniuPrefix":"upload","qiniuSecretKey":"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV","type":1}', '0', '云存储配置信息');

INSERT INTO schedule_job (job_id, bean_name, params, cron_expression, status, remark, create_time) VALUES (1, 'testTask', 'renren', '0 0/30 * * * ?', '0', '参数测试', CURRENT_DATE);


-- 账号：13612345678  密码：admin
INSERT INTO tb_user (user_id, username, mobile, password, create_time) VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', CURRENT_DATE);




--  quartz自带表结构
CREATE TABLE qrtz_job_details
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  JOB_NAME  VARCHAR2(200) NOT NULL,
  JOB_GROUP VARCHAR2(200) NOT NULL,
  DESCRIPTION VARCHAR2(250) NULL,
  JOB_CLASS_NAME   VARCHAR2(250) NOT NULL,
  IS_DURABLE VARCHAR2(1) NOT NULL,
  IS_NONCONCURRENT VARCHAR2(1) NOT NULL,
  IS_UPDATE_DATA VARCHAR2(1) NOT NULL,
  REQUESTS_RECOVERY VARCHAR2(1) NOT NULL,
  JOB_DATA BLOB NULL,
  CONSTRAINT QRTZ_JOB_DETAILS_PK PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);
CREATE TABLE qrtz_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  JOB_NAME  VARCHAR2(200) NOT NULL,
  JOB_GROUP VARCHAR2(200) NOT NULL,
  DESCRIPTION VARCHAR2(250) NULL,
  NEXT_FIRE_TIME NUMBER(13) NULL,
  PREV_FIRE_TIME NUMBER(13) NULL,
  PRIORITY NUMBER(13) NULL,
  TRIGGER_STATE VARCHAR2(16) NOT NULL,
  TRIGGER_TYPE VARCHAR2(8) NOT NULL,
  START_TIME NUMBER(13) NOT NULL,
  END_TIME NUMBER(13) NULL,
  CALENDAR_NAME VARCHAR2(200) NULL,
  MISFIRE_INSTR NUMBER(2) NULL,
  JOB_DATA BLOB NULL,
  CONSTRAINT QRTZ_TRIGGERS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT QRTZ_TRIGGER_TO_JOBS_FK FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
  REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP)
);
CREATE TABLE qrtz_simple_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  REPEAT_COUNT NUMBER(7) NOT NULL,
  REPEAT_INTERVAL NUMBER(12) NOT NULL,
  TIMES_TRIGGERED NUMBER(10) NOT NULL,
  CONSTRAINT QRTZ_SIMPLE_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT QRTZ_SIMPLE_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_cron_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  CRON_EXPRESSION VARCHAR2(120) NOT NULL,
  TIME_ZONE_ID VARCHAR2(80),
  CONSTRAINT QRTZ_CRON_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT QRTZ_CRON_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_simprop_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  STR_PROP_1 VARCHAR2(512) NULL,
  STR_PROP_2 VARCHAR2(512) NULL,
  STR_PROP_3 VARCHAR2(512) NULL,
  INT_PROP_1 NUMBER(10) NULL,
  INT_PROP_2 NUMBER(10) NULL,
  LONG_PROP_1 NUMBER(13) NULL,
  LONG_PROP_2 NUMBER(13) NULL,
  DEC_PROP_1 NUMERIC(13,4) NULL,
  DEC_PROP_2 NUMERIC(13,4) NULL,
  BOOL_PROP_1 VARCHAR2(1) NULL,
  BOOL_PROP_2 VARCHAR2(1) NULL,
  CONSTRAINT QRTZ_SIMPROP_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT QRTZ_SIMPROP_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_blob_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  BLOB_DATA BLOB NULL,
  CONSTRAINT QRTZ_BLOB_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT QRTZ_BLOB_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_calendars
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  CALENDAR_NAME  VARCHAR2(200) NOT NULL,
  CALENDAR BLOB NOT NULL,
  CONSTRAINT QRTZ_CALENDARS_PK PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);
CREATE TABLE qrtz_paused_trigger_grps
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_GROUP  VARCHAR2(200) NOT NULL,
  CONSTRAINT QRTZ_PAUSED_TRIG_GRPS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_fired_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  ENTRY_ID VARCHAR2(95) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  INSTANCE_NAME VARCHAR2(200) NOT NULL,
  FIRED_TIME NUMBER(13) NOT NULL,
  SCHED_TIME NUMBER(13) NOT NULL,
  PRIORITY NUMBER(13) NOT NULL,
  STATE VARCHAR2(16) NOT NULL,
  JOB_NAME VARCHAR2(200) NULL,
  JOB_GROUP VARCHAR2(200) NULL,
  IS_NONCONCURRENT VARCHAR2(1) NULL,
  REQUESTS_RECOVERY VARCHAR2(1) NULL,
  CONSTRAINT QRTZ_FIRED_TRIGGER_PK PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);
CREATE TABLE qrtz_scheduler_state
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  INSTANCE_NAME VARCHAR2(200) NOT NULL,
  LAST_CHECKIN_TIME NUMBER(13) NOT NULL,
  CHECKIN_INTERVAL NUMBER(13) NOT NULL,
  CONSTRAINT QRTZ_SCHEDULER_STATE_PK PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);
CREATE TABLE qrtz_locks
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  LOCK_NAME  VARCHAR2(40) NOT NULL,
  CONSTRAINT QRTZ_LOCKS_PK PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

create index idx_qrtz_j_req_recovery on qrtz_job_details(SCHED_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_j_grp on qrtz_job_details(SCHED_NAME,JOB_GROUP);

create index idx_qrtz_t_j on qrtz_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_t_jg on qrtz_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_t_c on qrtz_triggers(SCHED_NAME,CALENDAR_NAME);
create index idx_qrtz_t_g on qrtz_triggers(SCHED_NAME,TRIGGER_GROUP);
create index idx_qrtz_t_state on qrtz_triggers(SCHED_NAME,TRIGGER_STATE);
create index idx_qrtz_t_n_state on qrtz_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_n_g_state on qrtz_triggers(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_next_fire_time on qrtz_triggers(SCHED_NAME,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st on qrtz_triggers(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_misfire on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st_misfire on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
create index idx_qrtz_t_nft_st_misfire_grp on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

create index idx_qrtz_ft_trig_inst_name on qrtz_fired_triggers(SCHED_NAME,INSTANCE_NAME);
create index idx_qrtz_ft_inst_job_req_rcvry on qrtz_fired_triggers(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_ft_j_g on qrtz_fired_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_ft_jg on qrtz_fired_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_ft_t_g on qrtz_fired_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
create index idx_qrtz_ft_tg on qrtz_fired_triggers(SCHED_NAME,TRIGGER_GROUP);

CREATE TABLE code_organ  (
                             code VARCHAR2(10) NOT NULL,
                             name VARCHAR2(300) NOT NULL,
                             areacode VARCHAR2(6) NOT NULL,
                             sealid VARCHAR2(100) NULL,
                             enabled NUMBER(1) NOT NULL,
                             UNISCID VARCHAR2(25) NULL,
                             DATASOURCE VARCHAR2(3) NULL,
                             PARENTCODE VARCHAR2(10) NULL,
                             PRIMARY KEY(code)
                                 NOT DEFERRABLE VALIDATE
);
COMMENT ON TABLE code_organ IS '登记机关代码表';
COMMENT ON COLUMN code_organ.code IS '代码';
COMMENT ON COLUMN code_organ.name IS '机构名称';
COMMENT ON COLUMN code_organ.areacode IS '行政区划';
COMMENT ON COLUMN code_organ.sealid IS '电子印章编号';
COMMENT ON COLUMN code_organ.enabled IS '是否可用 1可用，0不可用';
COMMENT ON COLUMN CODE_ORGAN.UNISCID IS '机构代码';
COMMENT ON COLUMN CODE_ORGAN.DATASOURCE IS '数据来源代码';
COMMENT ON COLUMN CODE_ORGAN.PARENTCODE IS '父级代码';
CREATE INDEX idx_code_organ_areacode ON code_organ(areacode);
commit;

INSERT INTO code_organ VALUES ('230000', '黑龙江省市场监督管理局', '230000', '23000000005997', '', 1, NULL, '000000');
INSERT INTO code_organ VALUES ('230100', '哈尔滨市市场监督管理局', '230100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230200', '齐齐哈尔市市场监督管理局', '230200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230300', '鸡西市市场监督管理局', '230300', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230400', '鹤岗市市场监督管理局', '230400', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230500', '双鸭山市市场监督管理局', '230500', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230600', '大庆市市场监督管理局', '230600', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230700', '伊春市市场监督管理局', '230700', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230800', '佳木斯市市场监督管理局', '230800', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('230900', '七台河市市场监督管理局', '230900', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('231000', '牡丹江市市场监督管理局', '231000', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('231100', '黑河市市场监督管理局', '231100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('231200', '绥化市市场监督管理局', '231200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO code_organ VALUES ('232700', '大兴安岭地区市场监督管理局', '232700', '23000000005997', '', 1, NULL, '230000');

COMMIT;

-- 系统用户Token
CREATE TABLE nf_wuser_token (
                                id NUMBER(20, 0) NOT NULL,
                                token varchar2(100) NOT NULL,
                                expire_time timestamp,
                                update_time timestamp,
                                PRIMARY KEY (id)
);
COMMENT ON TABLE nf_wuser_token IS '外网用户Token';
COMMENT ON COLUMN nf_wuser_token.id IS '外网用户Id';
COMMENT ON COLUMN nf_wuser_token.token IS 'token';
COMMENT ON COLUMN nf_wuser_token.expire_time IS '过期时间';
COMMENT ON COLUMN nf_wuser_token.update_time IS '更新时间';
CREATE UNIQUE INDEX idx_wtoken on nf_wuser_token(token);

-- 系统验证码
CREATE TABLE nf_wcaptcha (
                             uuid varchar2(36) NOT NULL,
                             code varchar2(6) NOT NULL,
                             expire_time timestamp,
                             PRIMARY KEY (uuid)
);
COMMENT ON TABLE nf_wcaptcha IS '外网系统验证码表';
COMMENT ON COLUMN nf_wcaptcha.code IS 'uuid';
COMMENT ON COLUMN nf_wcaptcha.name IS '验证码';
COMMENT ON COLUMN nf_wcaptcha.areacode IS '过期时间';

-- 外网用户
CREATE TABLE nf_wuser (
                          id NUMBER(20, 0) NOT NULL,
                          username varchar2(50) NOT NULL,
                          password varchar2(100),
                          salt varchar2(20),
                          email varchar2(100),
                          mobile varchar2(100),
                          status NUMBER(2, 0) NOT NULL,
                          createtime timestamp,
                          lasttime timestamp,
                          PRIMARY KEY (id)
);
COMMENT ON TABLE nf_wuser IS '外网用户';
COMMENT ON COLUMN nf_wuser.id IS '用户Id';
COMMENT ON COLUMN nf_wuser.username IS '用户名';
COMMENT ON COLUMN nf_wuser.password IS '密码';
COMMENT ON COLUMN nf_wuser.salt IS '盐';
COMMENT ON COLUMN nf_wuser.email IS '邮箱';
COMMENT ON COLUMN nf_wuser.mobile IS '手机号';
COMMENT ON COLUMN nf_wuser.status IS '状态  0：删除   1：正常   2：禁用';
COMMENT ON COLUMN nf_wuser.createtime IS '创建时间';
COMMENT ON COLUMN nf_wuser.lasttime IS '最后操作时间';
CREATE UNIQUE INDEX idx_nf_wuser_username on nf_wuser(username);

-- 冷藏冷冻食品贮存服务提供者
CREATE TABLE nf_rffssp (
                          id varchar2(30) NOT NULL,
                          uniscid varchar2(50) NOT NULL,
                          entname varchar2(200) NOT NULL,
                          address varchar2(300) NOT NULL,
                          storcapa varchar2(400) NOT NULL,
                          legalrep varchar2(100) NOT NULL,
                          callinfo varchar2(20) NOT NULL,
                          status NUMBER(2, 0) NOT NULL,
                          createtime timestamp NOT NULL,
                          lasttime timestamp NOT NULL,
                          valid NUMBER(1, 0) NOT NULL,
                          issueorg varchar2(10) NOT NULL,
                          PRIMARY KEY (id)
);
COMMENT ON TABLE nf_rffssp IS '冷藏冷冻食品贮存服务提供者';
COMMENT ON COLUMN nf_rffssp.id IS '冷藏冷冻食品贮存服务提供者ID';
COMMENT ON COLUMN nf_rffssp.uniscid IS '统一社会信用代码';
COMMENT ON COLUMN nf_rffssp.entname IS '冷藏冷冻库名称';
COMMENT ON COLUMN nf_rffssp.address IS '冷藏冷冻库地址';
COMMENT ON COLUMN nf_rffssp.storcapa IS '贮存能力';
COMMENT ON COLUMN nf_rffssp.legalrep IS '法定代表人或者负责人姓名';
COMMENT ON COLUMN nf_rffssp.callinfo IS '联系方式';
COMMENT ON COLUMN nf_rffssp.status IS '状态 1 录入  2 提交  3 业务完成';
COMMENT ON COLUMN nf_rffssp.createtime IS '创建时间';
COMMENT ON COLUMN nf_rffssp.lasttime IS '最后操作时间';
COMMENT ON COLUMN nf_rffssp.valid IS '是否有效：1有效 0无效';
COMMENT ON COLUMN nf_rffssp.issueorg IS '管理机构ID';
CREATE INDEX idx_rffssp_uniscid on nf_rffssp(uniscid);
CREATE INDEX idx_rffssp_legalrep on nf_rffssp(legalrep);
CREATE INDEX idx_rffssp_callinfo on nf_rffssp(callinfo);

-- 业务表
CREATE TABLE nf_busin (
                           id varchar2(30) NOT NULL,
                           btype varchar2(3) NOT NULL,
                           status varchar2(200) NOT NULL,
                           rffsspid varchar2(30) NOT NULL,
                           createtime timestamp NOT NULL,
                           lasttime timestamp NOT NULL,
                           PRIMARY KEY (id)
);
COMMENT ON TABLE nf_busin IS '业务表';
COMMENT ON COLUMN nf_busin.id IS '业务ID';
COMMENT ON COLUMN nf_busin.btype IS '业务类型： 10：内网备案申报 20：外网备案申报 11：内网备案变更申报 21：外网备案变更申报 12：内网备案注销申报 22：外网备案注销申报';
COMMENT ON COLUMN nf_busin.status IS '业务状态 21：未完成  11：受理不通过  21：审核不通过 22：待受理  12：受理通过  22：审核通过';
COMMENT ON COLUMN nf_busin.rffsspid IS '备案ID';
COMMENT ON COLUMN nf_busin.createtime IS '创建时间';
COMMENT ON COLUMN nf_busin.lasttime IS '最后操作时间';
CREATE INDEX idx_busin_rffsspid on nf_busin(rffsspid);

-- 代理人
CREATE TABLE nf_agent (
                          id varchar2(30) NOT NULL,
                          name varchar2(30) NOT NULL,
                          status varchar2(200) NOT NULL,
                          businid varchar2(30) NOT NULL,
                          createtime timestamp NOT NULL,
                          lasttime timestamp NOT NULL,
                          PRIMARY KEY (id)
);
COMMENT ON TABLE nf_agent IS '代理人';
COMMENT ON COLUMN nf_agent.id IS '代理人ID';
COMMENT ON COLUMN nf_agent.name IS '代理人姓名';
COMMENT ON COLUMN nf_agent.mobile IS '代理人联系方式';
COMMENT ON COLUMN nf_agent.businid IS '业务id: NfBusinEntity id';
COMMENT ON COLUMN nf_agent.createtime IS '创建时间';
COMMENT ON COLUMN nf_agent.lasttime IS '最后操作时间';
CREATE INDEX idx_agent_businid on nf_agent(businid);
CREATE INDEX idx_agent_name on nf_agent(name);

-- 材料表
CREATE TABLE nf_material (
                          id varchar2(30) NOT NULL,
                          mtype varchar2(3) NOT NULL,
                          morder NUMBER(2, 0) NOT NULL,
                          mpath varchar2(400) NOT NULL,
                          businid varchar2(30) NOT NULL,
                          createtime timestamp NOT NULL,
                          lasttime timestamp NOT NULL,
                          PRIMARY KEY (id)
);
COMMENT ON TABLE nf_material IS '材料表';
COMMENT ON COLUMN nf_material.id IS '材料ID';
COMMENT ON COLUMN nf_material.mtype IS '材料类型：10 冷藏冷冻贮存场所布局图 20 法定代表人或者负责人身份证明复印件人像面 21 法定代表人或者负责人身份证明复印件国徽面 30 所提交资料真实性承诺书';
COMMENT ON COLUMN nf_material.morder IS '同材料类型的顺序号';
COMMENT ON COLUMN nf_material.mpath IS '材料地址';
COMMENT ON COLUMN nf_material.businid IS '业务id: NfBusinEntity id';
COMMENT ON COLUMN nf_material.createtime IS '创建时间';
COMMENT ON COLUMN nf_material.lasttime IS '最后操作时间';
CREATE INDEX idx_material_businid on nf_material(businid);

-- 操作记录
CREATE TABLE nf_opt (
                             id NUMBER(20, 0) NOT NULL,
                             businid varchar2(30) NOT NULL,
                             module varchar2(30) NOT NULL,
                             ouser NUMBER(20, 0) NOT NULL,
                             ip varchar2(64) NULL,
                             duration NUMBER(20, 0) NOT NULL,
                             otime timestamp NOT NULL,
                             PRIMARY KEY (id)
);
COMMENT ON TABLE nf_opt IS '操作记录';
COMMENT ON COLUMN nf_opt.id IS '操作记录ID';
COMMENT ON COLUMN nf_opt.businid IS '业务id: NfBusinEntity id';
COMMENT ON COLUMN nf_opt.module IS '操作模块名称';
COMMENT ON COLUMN nf_opt.ouser IS '操作人员';
COMMENT ON COLUMN nf_opt.ip IS 'IP地址';
COMMENT ON COLUMN nf_opt.duration IS '执行时长(毫秒)';
COMMENT ON COLUMN nf_opt.otime IS '操作时间';
CREATE INDEX idx_opt_businid on nf_opt(businid);

-- 受理审核
CREATE TABLE nf_checked (
                        id NUMBER(20, 0) NOT NULL,
                        businid varchar2(30) NOT NULL,
                        name varchar2(30) NOT NULL,
                        cresult varchar2(2) NOT NULL,
                        opinions varchar2(3000) NULL,
                        ctime timestamp NOT NULL,
                        ctype varchar2(2) NOT NULL,
                        createtime timestamp NOT NULL,
                        lasttime timestamp NOT NULL,
                        PRIMARY KEY (id)
);
COMMENT ON TABLE nf_checked IS '受理审核';
COMMENT ON COLUMN nf_checked.id IS '受理审核ID';
COMMENT ON COLUMN nf_checked.businid IS '业务id: NfBusinEntity id';
COMMENT ON COLUMN nf_checked.name IS '受理审核人员';
COMMENT ON COLUMN nf_checked.cresult IS '受理审核结果： 1 为不通过  2  为通过';
COMMENT ON COLUMN nf_checked.opinions IS '受理审核意见';
COMMENT ON COLUMN nf_checked.ctime IS '受理审核时间';
COMMENT ON COLUMN nf_checked.ctype IS '受理审核类型: 1 为受理    2  为审核';
COMMENT ON COLUMN nf_checked.createtime IS '创建时间';
COMMENT ON COLUMN nf_checked.lasttime IS '最后操作时间';
CREATE INDEX idx_checked_businid on nf_checked(businid);

-- 外网用户与主体关联表
CREATE TABLE nf_rffssp_user (
                          id NUMBER(20, 0) NOT NULL,
                          rffsspid varchar2(30) NOT NULL,
                          userid NUMBER(20, 0) NOT NULL,
                          status NUMBER(2, 0) NOT NULL,
                          createtime timestamp NOT NULL,
                          lasttime timestamp NOT NULL,
                          PRIMARY KEY (id)
);
COMMENT ON TABLE nf_rffssp_user IS '外网用户与主体关联表';
COMMENT ON COLUMN nf_rffssp_user.id IS 'ID';
COMMENT ON COLUMN nf_rffssp_user.rffsspid IS '备案ID';
COMMENT ON COLUMN nf_rffssp_user.btype IS '外网用户ID';
COMMENT ON COLUMN nf_rffssp_user.status IS '状态  0：解绑   1：正常';
COMMENT ON COLUMN nf_rffssp_user.createtime IS '创建时间';
COMMENT ON COLUMN nf_rffssp_user.lasttime IS '最后操作时间';
CREATE INDEX idx_rffsspuser_rffsspid on nf_rffssp_user(rffsspid);
CREATE INDEX idx_rffsspuser_userid on nf_rffssp_user(userid);

INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (100, 0, '备案申请', NULL, NULL, 0, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (110, 100, '备案申请', 'nfrecord/apply', NULL, 1, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (111, 110, '查看', NULL, 'nfrecord:apply:list,nfrecord:apply:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (112, 110, '新增', NULL, 'nfrecord:apply:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (113, 110, '修改', NULL, 'nfrecord:apply:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (114, 110, '删除', NULL, 'nfrecord:apply:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (120, 100, '变更申请', 'nfrecord/change', '', 1, 'log', 2);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (121, 120, '查看', NULL, 'nfrecord:change:list,nfrecord:change:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (122, 120, '新增', NULL, 'nfrecord:change:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (123, 120, '修改', NULL, 'nfrecord:change:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (124, 120, '删除', NULL, 'nfrecord:change:delete', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (130, 100, '注销申请', 'nfrecord/cancel', '', 1, 'log', 3);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (131, 130, '查看', NULL, 'nfrecord:cancel:list,nfrecord:cancel:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (132, 130, '新增', NULL, 'nfrecord:cancel:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (133, 130, '修改', NULL, 'nfrecord:cancel:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (134, 130, '删除', NULL, 'nfrecord:cancel:delete', 2, NULL, 0);

INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (200, 0, '备案受理', NULL, NULL, 0, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (210, 200, '备案受理', 'nfrecord/applya', NULL, 1, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (211, 210, '查看', NULL, 'nfrecord:applya:list,nfrecord:applya:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (212, 210, '受理', NULL, 'nfrecord:applya:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (213, 210, '修改', NULL, 'nfrecord:applya:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (220, 200, '变更受理', 'nfrecord/changea', '', 1, 'log', 2);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (221, 220, '查看', NULL, 'nfrecord:changea:list,nfrecord:changea:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (222, 220, '受理', NULL, 'nfrecord:changea:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (223, 220, '修改', NULL, 'nfrecord:changea:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (230, 200, '注销受理', 'nfrecord/cancela', '', 1, 'log', 3);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (231, 230, '查看', NULL, 'nfrecord:cancela:list,nfrecord:cancela:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (232, 230, '受理', NULL, 'nfrecord:cancela:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (233, 230, '修改', NULL, 'nfrecord:cancela:update', 2, NULL, 0);

INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (300, 0, '备案审核', NULL, NULL, 0, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (310, 300, '备案审核', 'nfrecord/applyc', NULL, 1, 'log', 1);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (311, 310, '查看', NULL, 'nfrecord:applyc:list,nfrecord:applyc:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (312, 310, '审核', NULL, 'nfrecord:applyc:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (313, 310, '修改', NULL, 'nfrecord:applyc:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (320, 300, '变更审核', 'nfrecord/changec', '', 1, 'log', 2);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (321, 320, '查看', NULL, 'nfrecord:changec:list,nfrecord:changec:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (322, 320, '审核', NULL, 'nfrecord:changec:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (323, 320, '修改', NULL, 'nfrecord:changec:update', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (330, 300, '注销审核', 'nfrecord/cancelc', '', 1, 'log', 3);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (331, 330, '查看', NULL, 'nfrecord:cancelc:list,nfrecord:cancelc:info', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (332, 330, '审核', NULL, 'nfrecord:cancelc:save', 2, NULL, 0);
INSERT INTO sys_menu(menu_id, parent_id, name, url, perms, type, icon, order_num) VALUES (333, 330, '修改', NULL, 'nfrecord:cancelc:update', 2, NULL, 0);

commit;
