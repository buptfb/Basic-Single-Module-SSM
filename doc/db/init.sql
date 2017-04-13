# 创建数据库并创建权限用户
# CREATE DATABASE 'ssm' CHARACTER SET utf8;
CREATE DATABASE ssm CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'ssm'@'%' IDENTIFIED BY 'Moranhuishou2016:)';
GRANT ALL PRIVILEGES ON ssm.* TO 'ssm'@'%';
FLUSH PRIVILEGES;


/*# 创建表
USE ssm;
CREATE TABLE `sys_user` (
  `sys_user_id` bigint(20) NOT NULL,
  `sys_user_login_name` varchar(50) NOT NULL,
  `sys_user_login_password` varchar(50) NOT NULL,
  `sys_user_status` varchar(1) NOT NULL,
  `sys_user_is_delete` varchar(1) NOT NULL,
  `sys_user_register_datetime` datetime NOT NULL,
  `sys_user_register_source` varchar(1) NOT NULL,
  `sys_user_type` varchar(1) NOT NULL,
  `sys_user_sex` varchar(1) NOT NULL,
  `sys_user_is_email_active` varchar(1) NOT NULL,
  `sys_user_is_mobile_active` varchar(1) NOT NULL,
  `sys_user_register_type` varchar(1) NOT NULL,
  `sys_user_pay_passwrod` varchar(50) DEFAULT NULL,
  `sys_user_icon` varchar(100) DEFAULT NULL,
  `sys_user_real_name` varchar(20) DEFAULT NULL,
  `sys_user_email` varchar(50) DEFAULT NULL,
  `sys_user_mobile` varchar(20) DEFAULT NULL,
  `sys_user_weibo_id` varchar(36) DEFAULT NULL,
  `sys_user_qq_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

USE ssm;
CREATE TABLE `user_type`(
  `user_type_id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户类型id',
  `user_type_name` varchar(32)  NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_type_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台用户类型表';


CREATE TABLE `user_info` (
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `user_pwd` varchar (32) NOT NULL COMMENT '用户密码',
  `user_email` varchar (32) NOT NULL COMMENT '用户邮箱地址',
  `user_type_id` tinyint(1)  NOT NULL COMMENT '用户类型id',
  `create_time` datetime default CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`user_name`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台用户表';


CREATE TABLE `job_info`(
  `job_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `user_name` varchar(32) NOT NULL COMMENT '创建该任务的用户名',
  `job_type` varchar (32) NOT NULL COMMENT '任务类型',
  `job_params` text  NOT NULL COMMENT 'job请求参数',
  `job_status` varchar(32)  NOT NULL COMMENT 'Job执行状态',
  `job_create_time` datetime default CURRENT_TIMESTAMP COMMENT 'job创建时间',
  `job_modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'job状态更新时间',
  PRIMARY KEY(`job_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台任务表';

CREATE TABLE `document_info`(
  `doc_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'doc id值',
  `job_id` int(11) unsigned NOT NULL  COMMENT 'doc所属job id',
  `op_type` varchar (32) NOT NULL COMMENT 'doc的待操作类型',
  `doc_content` text  NOT NULL COMMENT 'doc内容',
  `doc_status` varchar(32)  NOT NULL COMMENT 'doc审核状态',
  `doc_create_time` datetime default CURRENT_TIMESTAMP COMMENT 'doc创建时间',
  `doc_modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'doc最后更新时间',
  PRIMARY KEY(`doc_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台document信息表';



DROP TABLE IF EXISTS `es_index`;
CREATE TABLE `es_index`(
  `index_id` int(11) unsigned NOT NULL auto_increment COMMENT '索引id',
  `index_name` varchar(64) NOT NULL COMMENT '索引名称',
  `type_name` varchar(64) NOT NULL COMMENT 'type名称',
  `index_mapping_field`  text   NOT NULL COMMENT 'mapping字段',
  `index_create_time` datetime default CURRENT_TIMESTAMP COMMENT 'index创建时间',
  `index_modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'index状态更新时间',
  PRIMARY KEY(`index_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台索引表';


CREATE TABLE `index_field_query_type`
( `field_query_type_id` tinyint(1) unsigned  NOT NULL auto_increment COMMENT '查询类型id',
  `field_query_type_name` varchar(32)  NOT NULL COMMENT '查询类型名称',
  `field_query_type_sub1` varchar(32)  NULL COMMENT '查询类型对应的子字段1',
  `field_query_type_sub2` varchar(32)  NULL COMMENT '查询类型对应的子字段2',
  PRIMARY KEY (`field_query_type_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识库干预平台查询类型表';


# 创建表数据
/*
USE ssm;
insert  into `sys_user`(`sys_user_id`,`sys_user_login_name`,`sys_user_login_password`,`sys_user_status`,`sys_user_is_delete`,`sys_user_register_datetime`,`sys_user_register_source`,`sys_user_type`,`sys_user_sex`,`sys_user_is_email_active`,`sys_user_is_mobile_active`,`sys_user_register_type`,`sys_user_pay_passwrod`,`sys_user_icon`,`sys_user_real_name`,`sys_user_email`,`sys_user_mobile`,`sys_user_weibo_id`,`sys_user_qq_id`) values (1,'YouMeek1','e10adc3949ba59abbe56e057f20f883e','0','N','2016-02-24 00:12:23','0','0','0','Y','Y','0','e10adc3949ba59abbe56e057f20f883e','','张觉恩1','363379441@qq.com','13800000001','','');
insert  into `sys_user`(`sys_user_id`,`sys_user_login_name`,`sys_user_login_password`,`sys_user_status`,`sys_user_is_delete`,`sys_user_register_datetime`,`sys_user_register_source`,`sys_user_type`,`sys_user_sex`,`sys_user_is_email_active`,`sys_user_is_mobile_active`,`sys_user_register_type`,`sys_user_pay_passwrod`,`sys_user_icon`,`sys_user_real_name`,`sys_user_email`,`sys_user_mobile`,`sys_user_weibo_id`,`sys_user_qq_id`) values (2,'YouMeek2','e10adc3949ba59abbe56e057f20f883e','0','N','2016-02-24 00:12:23','0','0','0','Y','Y','0','e10adc3949ba59abbe56e057f20f883e','','张觉恩2','363379442@qq.com','13800000002','','');
insert  into `sys_user`(`sys_user_id`,`sys_user_login_name`,`sys_user_login_password`,`sys_user_status`,`sys_user_is_delete`,`sys_user_register_datetime`,`sys_user_register_source`,`sys_user_type`,`sys_user_sex`,`sys_user_is_email_active`,`sys_user_is_mobile_active`,`sys_user_register_type`,`sys_user_pay_passwrod`,`sys_user_icon`,`sys_user_real_name`,`sys_user_email`,`sys_user_mobile`,`sys_user_weibo_id`,`sys_user_qq_id`) values (3,'YouMeek3','e10adc3949ba59abbe56e057f20f883e','0','N','2016-02-24 00:12:23','0','0','0','Y','Y','0','e10adc3949ba59abbe56e057f20f883e','','张觉恩3','363379443@qq.com','13800000003','','');
insert  into `sys_user`(`sys_user_id`,`sys_user_login_name`,`sys_user_login_password`,`sys_user_status`,`sys_user_is_delete`,`sys_user_register_datetime`,`sys_user_register_source`,`sys_user_type`,`sys_user_sex`,`sys_user_is_email_active`,`sys_user_is_mobile_active`,`sys_user_register_type`,`sys_user_pay_passwrod`,`sys_user_icon`,`sys_user_real_name`,`sys_user_email`,`sys_user_mobile`,`sys_user_weibo_id`,`sys_user_qq_id`) values (4,'YouMeek4','e10adc3949ba59abbe56e057f20f883e','0','N','2016-02-24 00:12:23','0','0','0','Y','Y','0','e10adc3949ba59abbe56e057f20f883e','','张觉恩4','363379444@qq.com','13800000004','','');
insert  into `sys_user`(`sys_user_id`,`sys_user_login_name`,`sys_user_login_password`,`sys_user_status`,`sys_user_is_delete`,`sys_user_register_datetime`,`sys_user_register_source`,`sys_user_type`,`sys_user_sex`,`sys_user_is_email_active`,`sys_user_is_mobile_active`,`sys_user_register_type`,`sys_user_pay_passwrod`,`sys_user_icon`,`sys_user_real_name`,`sys_user_email`,`sys_user_mobile`,`sys_user_weibo_id`,`sys_user_qq_id`) values (5,'YouMeek5','e10adc3949ba59abbe56e057f20f883e','0','N','2016-02-24 00:12:23','0','0','0','Y','Y','0','e10adc3949ba59abbe56e057f20f883e','','张觉恩5','363379445@qq.com','13800000005','','');


*/
USE ssm;
insert into `user_info` (user_name, user_pwd, user_email, user_type_id) values('fanbo', 'imoran@0505', 'fanbo@imoran.net', 2);
insert into `user_info` (user_name, user_pwd, user_email, user_type_id) values('caoxiaoshuai', 'imoran@0505', 'caoxiaoshuai@imoran.net', 0);
insert INTO `user_type` (user_type_name) VALUES ('common');
insert INTO `user_type` (user_type_name) VALUES ('reviewer');
insert INTO `user_type` (user_type_name) VALUES ('admin');

alter table user_info modify column user_type_id SMALLINT (1);

insert into `job_info` (user_name, job_type, job_params, job_status) values('fanbo', 'add', '', 'unaudited');
insert INTO `job_info` (user_name, job_type, job_params, job_status) values('fanbo', 'modify', '', 'in_audit');
insert INTO `job_info` (user_name, job_type, job_params, job_status) values('fanbo', 'modify', '', 'audited');
insert INTO `job_info` (user_name, job_type, job_params, job_status) values('fanbo', 'modify', '', 'online');

USE ssm;
desc user_info;

insert INTO `document_info` (job_id, op_type, doc_content, doc_status) values(1, 'add', '', 'unaudited');

