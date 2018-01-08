/*
MySQL Backup
Source Server Version: 5.5.27
Source Database: dml_v1.0
Date: 2017/12/15/周五 13:41:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `cms_banner_img`
-- ----------------------------
DROP TABLE IF EXISTS `cms_banner_img`;
CREATE TABLE `cms_banner_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `loadpath` varchar(255) DEFAULT NULL COMMENT 'loadpath',
  `name` varchar(255) DEFAULT NULL COMMENT 'name',
  `create_time` datetime DEFAULT NULL COMMENT 'createTime',
  `xuhao` int(11) DEFAULT NULL COMMENT 'xuhao',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='cms_banner_img';

-- ----------------------------
--  Table structure for `cms_news`
-- ----------------------------
DROP TABLE IF EXISTS `cms_news`;
CREATE TABLE `cms_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `files` text,
  `office_id` int(11) DEFAULT NULL,
  `title` text,
  `content` longtext,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `cms_office`
-- ----------------------------
DROP TABLE IF EXISTS `cms_office`;
CREATE TABLE `cms_office` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_id` int(11) DEFAULT NULL COMMENT 'deptId',
  `name` varchar(50) DEFAULT NULL COMMENT 'name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='cms_office';

-- ----------------------------
--  Table structure for `cms_user_office`
-- ----------------------------
DROP TABLE IF EXISTS `cms_user_office`;
CREATE TABLE `cms_user_office` (
  `user_id` int(11) NOT NULL,
  `office_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `code` varchar(20) DEFAULT NULL COMMENT '部门name',
  `name` varchar(20) DEFAULT NULL COMMENT '部门code',
  `parantid` int(11) DEFAULT NULL COMMENT '父级部门id',
  PRIMARY KEY (`id`),
  KEY `code` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL COMMENT '资源 ID',
  `name` varchar(20) NOT NULL COMMENT '资源名称',
  `menuname` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `permission` varchar(40) NOT NULL COMMENT '资源权限字符串',
  `url` varchar(255) NOT NULL COMMENT '资源 url',
  `flag` int(11) DEFAULT NULL COMMENT '是否生成菜单,0:默认不生成菜单,1:生成菜单',
  `zindex` int(11) DEFAULT NULL COMMENT '菜单排序',
  `parantid` int(11) DEFAULT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_resource';

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表 ID',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `sn` varchar(20) NOT NULL COMMENT '角色字符串',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='t_role';

-- ----------------------------
--  Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色 id',
  `permission_id` int(11) NOT NULL COMMENT '资源 id',
  KEY `FK_Reference_3` (`role_id`) USING BTREE,
  KEY `FK_Reference_4` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_role_resource';

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 ID',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `staffname` varchar(30) NOT NULL COMMENT '员工姓名',
  `username` varchar(30) NOT NULL COMMENT '员工工号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `status` int(11) NOT NULL COMMENT '状态:0 禁用,1 启用',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户&推送人员表';

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户 id',
  `role_id` int(11) NOT NULL COMMENT '角色 id',
  KEY `FK_Reference_5` (`role_id`) USING BTREE,
  KEY `FK_Reference_6` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_user_role';

-- ----------------------------
--  View definition for `view_news_1`
-- ----------------------------
DROP VIEW IF EXISTS `view_news_1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_news_1` AS select `t_user`.`id` AS `id`,`t_user`.`dept_id` AS `dept_id`,`t_user`.`staffname` AS `staffname`,`t_user`.`username` AS `username`,`t_user`.`password` AS `password`,`t_user`.`status` AS `status`,`t_dept`.`name` AS `deptname`,`t_role`.`name` AS `rolename`,`t_role`.`id` AS `roleId`,`t_dept`.`id` AS `deptId` from (((`t_user` left join `t_dept` on((`t_user`.`dept_id` = `t_dept`.`id`))) left join `t_user_role` on((`t_user`.`id` = `t_user_role`.`user_id`))) left join `t_role` on((`t_user_role`.`role_id` = `t_role`.`id`)));

-- ----------------------------
--  View definition for `view_news_office_dept`
-- ----------------------------
DROP VIEW IF EXISTS `view_news_office_dept`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_news_office_dept` AS select `a`.`id` AS `id`,`a`.`create_id` AS `create_id`,`d`.`staffname` AS `create_name`,`d`.`deptId` AS `create_dept_id`,`d`.`deptname` AS `create_dept_name`,`a`.`create_time` AS `create_time`,`a`.`files` AS `files`,`a`.`title` AS `title`,`a`.`content` AS `content`,`a`.`count` AS `count`,`a`.`office_id` AS `office_id`,`b`.`dept_id` AS `dept_id`,`b`.`name` AS `office_name`,`c`.`code` AS `dept_code`,`c`.`name` AS `dept_name`,`c`.`parantid` AS `dept_parant_id` from (((`cms_news` `a` left join `cms_office` `b` on((`a`.`office_id` = `b`.`id`))) left join `t_dept` `c` on((`c`.`id` = `b`.`dept_id`))) left join `view_news_1` `d` on((`a`.`create_id` = `d`.`id`))) order by 5 desc;

-- ----------------------------
--  View definition for `view_permission_user`
-- ----------------------------
DROP VIEW IF EXISTS `view_permission_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_permission_user` AS select `t_permission`.`id` AS `id`,`t_permission`.`name` AS `name`,`t_permission`.`menuname` AS `menuname`,`t_permission`.`permission` AS `permission`,`t_permission`.`url` AS `url`,`t_permission`.`flag` AS `flag`,`t_permission`.`zindex` AS `zindex`,`t_permission`.`parantid` AS `parantid`,`t_user_role`.`user_id` AS `userid` from ((`t_user_role` left join `t_role_permission` on((`t_user_role`.`role_id` = `t_role_permission`.`role_id`))) left join `t_permission` on((`t_role_permission`.`permission_id` = `t_permission`.`id`)));

-- ----------------------------
--  View definition for `view_role_permission`
-- ----------------------------
DROP VIEW IF EXISTS `view_role_permission`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_role_permission` AS select `t_role`.`id` AS `id`,`t_role`.`name` AS `name`,`t_role`.`sn` AS `sn`,`t_permission`.`id` AS `permissionId`,`t_permission`.`name` AS `permissionname`,`t_permission`.`menuname` AS `menuname`,`t_permission`.`permission` AS `permission`,`t_permission`.`url` AS `url`,`t_permission`.`flag` AS `flag`,`t_permission`.`zindex` AS `zindex`,`t_permission`.`parantid` AS `parantid` from ((`t_role` left join `t_role_permission` on((`t_role`.`id` = `t_role_permission`.`role_id`))) left join `t_permission` on((`t_role_permission`.`permission_id` = `t_permission`.`id`)));

-- ----------------------------
--  View definition for `view_role_user`
-- ----------------------------
DROP VIEW IF EXISTS `view_role_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_role_user` AS select distinct `t_role`.`id` AS `id`,`t_role`.`name` AS `name`,`t_role`.`sn` AS `sn`,`t_user_role`.`user_id` AS `user_id` from (`t_user_role` left join `t_role` on((`t_role`.`id` = `t_user_role`.`role_id`)));

-- ----------------------------
--  View definition for `view_user_dept_role`
-- ----------------------------
DROP VIEW IF EXISTS `view_user_dept_role`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`` SQL SECURITY DEFINER VIEW `view_user_dept_role` AS select `t_user`.`id` AS `id`,`t_user`.`dept_id` AS `dept_id`,`t_user`.`staffname` AS `staffname`,`t_user`.`username` AS `username`,`t_user`.`password` AS `password`,`t_user`.`status` AS `status`,`t_dept`.`name` AS `deptname`,`t_role`.`name` AS `rolename`,`t_role`.`id` AS `roleId`,`t_dept`.`id` AS `deptId` from (((`t_user` left join `t_dept` on((`t_user`.`dept_id` = `t_dept`.`id`))) left join `t_user_role` on((`t_user`.`id` = `t_user_role`.`user_id`))) left join `t_role` on((`t_user_role`.`role_id` = `t_role`.`id`)));

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `cms_banner_img` VALUES ('1','/upload/image/20171130/20171130163217056_IMG_大磨岭全景.jpg','大磨岭全景.jpg','2017-11-30 16:32:19','1'), ('2','/upload/image/20171130/20171130163217084_IMG_副井井口房.jpg','副井井口房.jpg','2017-11-30 16:32:19','1'), ('3','/upload/image/20171130/20171130163217004_IMG_4377.jpg','4377.jpg','2017-11-30 16:32:19','1'), ('4','/upload/image/20171130/20171130163217079_IMG_职工宿舍楼.jpg','职工宿舍楼.jpg','2017-11-30 16:32:19','1'), ('5','/upload/image/20171130/20171130163217074_IMG_4372.jpg','4372.jpg','2017-11-30 16:32:19','1');
INSERT INTO `cms_news` VALUES ('1','1','2017-09-28 14:32:45',NULL,'16','test','test',NULL), ('2','1','2017-09-30 10:59:51',NULL,'31','test','test',NULL), ('3','1','2017-09-30 11:00:37',NULL,'31','test','test',NULL), ('4','1','2017-09-30 11:02:19',NULL,'31','test','test',NULL), ('5','1','2017-09-30 11:03:22',NULL,'31','test','test',NULL), ('6','1','2017-09-30 11:04:01',NULL,'31','test','test',NULL), ('7','1','2017-09-30 11:06:04',NULL,'16','test','test',NULL), ('8','1','2017-09-30 11:09:13',NULL,'1','test','test',NULL), ('9','1','2017-09-30 11:17:20',NULL,'16','test','test',NULL), ('10','1','2017-09-30 17:33:56',NULL,'36','test','test',NULL), ('11','1','2017-09-30 17:33:30',NULL,'36','test','test',NULL), ('12','1','2017-09-30 17:36:37',NULL,'1','test','test',NULL), ('13','1','2017-10-10 18:58:18',NULL,'1','test','test',NULL), ('14','1','2017-10-10 18:59:31',NULL,'31','test','test',NULL), ('15','1','2017-10-10 19:00:35',NULL,'1','test','test',NULL), ('16','1','2017-10-11 09:46:49',NULL,'1','test','test',NULL), ('17','1','2017-10-11 09:47:57',NULL,'51','test','test',NULL), ('18','1','2017-10-11 15:01:24',NULL,'41','test','test',NULL), ('19','1','2017-10-11 15:02:18',NULL,'41','test','test',NULL), ('20','1','2017-10-11 15:02:49',NULL,'41','test','test',NULL), ('21','1','2017-10-11 15:03:28',NULL,'41','test','test',NULL), ('22','1','2017-10-11 15:04:28',NULL,'16','test','test',NULL), ('23','1','2017-10-11 15:06:21',NULL,'16','test','test',NULL), ('24','1','2017-10-13 18:53:33',NULL,'21','test','test',NULL), ('25','1','2017-10-13 18:54:20',NULL,'21','test','test',NULL), ('26','1','2017-10-13 18:55:04',NULL,'21','test','test',NULL), ('27','1','2017-10-13 18:55:43',NULL,'21','test','test',NULL), ('28','1','2017-10-13 19:16:12',NULL,'11','test','test',NULL), ('29','1','2017-10-13 19:17:52',NULL,'11','test','test',NULL), ('30','1','2017-10-13 19:18:50',NULL,'26','test','test',NULL), ('31','1','2017-10-13 19:20:26',NULL,'26','test','test',NULL), ('32','1','2017-10-13 19:21:02',NULL,'26','test','test','1'), ('33','1','2017-10-13 19:24:41',NULL,'26','test','test',NULL), ('34','1','2017-10-14 08:45:40',NULL,'1','test','test',NULL), ('35','1','2017-10-15 14:29:55',NULL,'1','test','test',NULL), ('36','1','2017-10-15 14:28:52',NULL,'41','test','test',NULL), ('37','1','2017-10-15 14:30:41',NULL,'11','test','test',NULL), ('38','1','2017-10-17 20:29:06',NULL,'41','test','test',NULL), ('39','1','2017-10-19 09:03:39',NULL,'11','test','test',NULL), ('40','1','2017-10-19 09:02:25',NULL,'11','test','test',NULL), ('41','1','2017-10-19 09:02:56',NULL,'11','test','test',NULL), ('42','1','2017-10-19 09:06:15',NULL,'1','test','test',NULL), ('43','1','2017-10-19 10:58:40',NULL,'1','test','test',NULL), ('44','1','2017-10-19 10:59:50',NULL,'36','test','test',NULL), ('45','1','2017-10-19 11:00:20',NULL,'36','test','test',NULL), ('46','1','2017-10-19 11:00:56',NULL,'36','test','test',NULL), ('47','1','2017-10-19 11:02:16',NULL,'36','test','test',NULL), ('48','1','2017-10-19 11:02:44',NULL,'36','test','test',NULL), ('49','1','2017-10-19 11:03:13',NULL,'36','test','test',NULL), ('50','1','2017-10-19 11:04:02',NULL,'36','test','test',NULL), ('51','1','2017-10-21 09:12:54',NULL,'51','test','test',NULL), ('52','1','2017-10-21 09:12:38',NULL,'51','test','test',NULL), ('53','1','2017-10-23 16:24:22',NULL,'11','test','test',NULL), ('54','1','2017-10-23 16:25:02',NULL,'36','test','test',NULL), ('55','1','2017-10-23 16:26:23',NULL,'36','test','test',NULL), ('56','1','2017-10-23 16:27:01',NULL,'36','test','test',NULL), ('57','1','2017-10-23 16:27:36',NULL,'36','test','test',NULL), ('58','1','2017-10-25 11:34:22',NULL,'1','test','test',NULL), ('59','1','2017-10-26 13:34:15',NULL,'36','test','test','1'), ('60','1','2017-10-31 09:11:14',NULL,'26','test','test',NULL), ('61','1','2017-10-31 09:21:07',NULL,'11','test','test',NULL), ('62','1','2017-10-31 09:22:21',NULL,'31','test','test',NULL), ('63','1','2017-10-31 09:23:33',NULL,'11','test','test',NULL), ('64','1','2017-10-31 15:32:06',NULL,'1','test','test','1'), ('65','1','2017-10-31 15:33:57',NULL,'1','test','test',NULL), ('66','1','2017-11-01 15:14:37',NULL,'51','test','test',NULL), ('67','1','2017-11-01 15:16:07',NULL,'51','test','test',NULL), ('68','1','2017-11-01 15:25:27',NULL,'51','test','test',NULL), ('69','1','2017-11-03 13:16:37',NULL,'1','test','test',NULL), ('70','1','2017-11-08 20:44:48',NULL,'31','test','test',NULL), ('71','1','2017-11-09 11:18:52',NULL,'16','test','test',NULL), ('72','1','2017-11-09 11:21:23',NULL,'16','test','test',NULL), ('73','1','2017-11-10 14:12:05',NULL,'51','test','test',NULL), ('74','1','2017-11-12 10:59:43',NULL,'51','test','test',NULL), ('75','1','2017-11-14 14:23:31',NULL,'31','test','test',NULL), ('76','1','2017-11-14 14:25:06',NULL,'11','test','test',NULL), ('77','1','2017-11-15 09:34:31',NULL,'51','test','test',NULL), ('78','1','2017-11-20 15:19:50',NULL,'36','test','test',NULL), ('79','1','2017-11-20 15:20:58',NULL,'11','test','test',NULL), ('80','1','2017-11-22 09:25:33',NULL,'51','test','test','1'), ('81','1','2017-11-22 09:27:11',NULL,'26','test','test',NULL), ('82','1','2017-11-22 15:57:27',NULL,'1','test','test',NULL), ('83','1','2017-11-23 15:52:07',NULL,'2','test','test',NULL), ('84','1','2017-11-25 09:10:21',NULL,'51','test','test',NULL), ('85','1','2017-11-26 15:01:41',NULL,'51','test','test','1'), ('86','1','2017-11-26 16:35:37',NULL,'2','test','test','1'), ('87','1','2017-11-26 17:50:35',NULL,'2','test','test',NULL), ('88','1','2017-12-01 11:52:48',NULL,'51','test','test',NULL), ('89','1','2017-12-04 09:08:59',NULL,'2','test','test',NULL), ('90','1','2017-12-04 09:12:30',NULL,'2','test','test',NULL), ('91','1','2017-12-04 16:06:52',NULL,'2','test','test','3'), ('92','1','2017-12-05 15:43:12',NULL,'51','test','test',NULL);
INSERT INTO `cms_office` VALUES ('1',NULL,'新闻动态'), ('2',NULL,'通知通报'), ('11','11','上情下达'), ('12','11','行政文件'), ('16','12','调度管理'), ('17','12','调度信息'), ('21','13','标准规范'), ('22','13','质量达标'), ('26','14','规章制度'), ('31','15','机电信息'), ('32','15','机电考核'), ('36','16','技术管理'), ('41','18','规章制度'), ('46','19','法律法规'), ('51','30','工会信息'), ('52','30','检查通报');
INSERT INTO `cms_user_office` VALUES ('6','1'), ('6','2'), ('6','16'), ('6','17');
INSERT INTO `t_dept` VALUES ('1','快捷导航','机关科室',NULL), ('2','区队信息','区队信息',NULL), ('11','上情下达','综合办','1'), ('12','调度信息','调度室','1'), ('13','生产技术','工程科','1'), ('14','安全文化','安检科','1'), ('15','机电管理','机电科','1'), ('16','一通三防','通防科','1'), ('18','企业管理','企管科','1'), ('19','人力资源','企管科(人力资源)','1'), ('30','政工信息','工会',NULL);
INSERT INTO `t_permission` VALUES ('1','系统管理',NULL,'admin:*','/admin/**','0',NULL,NULL), ('2','系统资源',NULL,'pagejump:*','/admin/index/**',NULL,NULL,NULL), ('1000','内容管理','内容管理','cms','cms','1','0','0'), ('1100','文章管理','文章管理','news:*','/admin/news/**','1','0','1000'), ('1110','发布文章','发布文章','news:*','/admin/news/add','1','0','1100'), ('1120','文章列表','文章列表','news:index','/admin/news/index','1','1','1100'), ('1200','图片管理','图片管理','bannerimg:*','/admin/bannerimg/**','1','0','1000'), ('1220','图片列表','图片列表','bannerimg:index','/admin/bannerimg/index','1','1','1200'), ('5000','系统设置','系统设置','permission','permission','1','1','0'), ('5100','个人中心','个人中心','member:*','/admin/member/**','1','0','5000'), ('5110','个人资料','个人资料','member:index','/admin/member/index','1','0','5100'), ('5120','密码修改','密码修改','member:updatepwd','/admin/member/updatepwd/','1','2','5100'), ('5200','用户中心','用户中心','usercenter','/admin/user/**','1','1','5000'), ('5210','用户列表','用户管理','user:index','/admin/user/index','1','0','5200'), ('5220','部门列表','部门管理','dept:index','/admin/dept/index','1','1','5200'), ('5221','部门权限','部门权限','dept:*','/admin/dept/**','1','1','5220'), ('5230','栏目管理','栏目管理','office:index','/admin/office/index','1','3','5200'), ('5231','栏目权限','栏目权限','office:*','/admin/office/**','1','1','5230'), ('5300','系统权限','系统权限','permissioncenter','permissioncenter','1','2','5000'), ('5310','角色列表','角色管理','role:index','/admin/role/index','1','0','5300'), ('5320','权限列表','权限管理','permission:index','/admin/permission/index','1','1','5300'), ('5330','菜单列表','菜单管理','menu:index','/admin/menu/index','1','2','5300');
INSERT INTO `t_role` VALUES ('1','超级管理员','administrator','超级管理员拥有至高无上的权限'), ('2','管理员','admin','管理员'), ('3','文章发布员','user','用户');
INSERT INTO `t_role_permission` VALUES ('1','1'), ('2','2'), ('2','1000'), ('2','1100'), ('2','1110'), ('2','1120'), ('2','1200'), ('2','1220'), ('2','5000'), ('2','5100'), ('2','5110'), ('2','5120'), ('2','5200'), ('2','5210'), ('2','5220'), ('2','5221'), ('2','5230'), ('2','5231'), ('3','2'), ('3','1000'), ('3','1100'), ('3','1110'), ('3','1120'), ('3','5000'), ('3','5100'), ('3','5110'), ('3','5120');
INSERT INTO `t_user` VALUES ('1','1','admin','admin','d3b6d9791d7392d0c28745c84ce0a9fe','1');
INSERT INTO `t_user_role` VALUES ('1','1'), ('2','2');
