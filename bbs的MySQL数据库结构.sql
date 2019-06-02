/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-06-02 10:31:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏编号',
  `content_id` int(11) NOT NULL COMMENT '帖子编号',
  `collection_date` datetime NOT NULL COMMENT '收藏时间',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`collection_id`),
  KEY `content_id` (`content_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`content_id`) REFERENCES `thematic_content` (`content_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子收藏表';

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目（吧）管理员编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `column_id` int(11) NOT NULL COMMENT '所管理的栏目（吧）编号',
  PRIMARY KEY (`manager_id`),
  KEY `user_id` (`user_id`),
  KEY `column_id` (`column_id`),
  CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `manager_ibfk_2` FOREIGN KEY (`column_id`) REFERENCES `thematic_column` (`column_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主题栏目（吧）管理员表';

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for replies
-- ----------------------------
DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies` (
  `replies_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
  `content_id` int(11) NOT NULL COMMENT '回复主题内容编号（回复的帖子编号）',
  `replies_date` datetime NOT NULL COMMENT '回复时间',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `replies_content` text NOT NULL COMMENT '回复内容',
  PRIMARY KEY (`replies_id`),
  KEY `content_id` (`content_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `replies_ibfk_1` FOREIGN KEY (`content_id`) REFERENCES `thematic_content` (`content_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `replies_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='主题内容（帖子）回复表';

-- ----------------------------
-- Records of replies
-- ----------------------------
INSERT INTO `replies` VALUES ('1', '21', '2018-11-29 16:16:18', '2', '测试回复');
INSERT INTO `replies` VALUES ('2', '21', '2018-11-15 16:22:10', '3', '我也来个灌水');
INSERT INTO `replies` VALUES ('3', '21', '2018-11-29 16:29:05', '11', '再来灌水');
INSERT INTO `replies` VALUES ('4', '24', '2018-11-30 11:03:28', '2', '我先来测试回复');
INSERT INTO `replies` VALUES ('5', '24', '2018-11-30 11:03:47', '2', '好像可以回复了对吧');
INSERT INTO `replies` VALUES ('6', '24', '2018-11-30 11:03:54', '2', '465');
INSERT INTO `replies` VALUES ('7', '24', '2018-11-30 11:04:10', '2', '在试试回复');
INSERT INTO `replies` VALUES ('8', '24', '2018-11-30 11:04:17', '2', '世界观和深刻的金凤凰科技大会上');
INSERT INTO `replies` VALUES ('14', '23', '2018-11-30 11:08:01', '2', '13132132115');
INSERT INTO `replies` VALUES ('15', '23', '2018-11-30 11:09:16', '2', '测试');
INSERT INTO `replies` VALUES ('16', '25', '2018-11-30 11:13:12', '2', '哈哈哈哈，真好玩');
INSERT INTO `replies` VALUES ('17', '24', '2018-11-30 11:14:14', '14', '可以很是优秀突出并且独秀');
INSERT INTO `replies` VALUES ('18', '10', '2018-11-30 11:16:13', '3', '这么喜欢测试啊，数量管控上回复噶活佛济公很快就复合函数');
INSERT INTO `replies` VALUES ('21', '22', '2018-11-30 11:19:51', '2', '给你回了');
INSERT INTO `replies` VALUES ('22', '22', '2018-11-30 11:21:36', '2', '再给你回一条吧');
INSERT INTO `replies` VALUES ('23', '4', '2018-11-30 11:21:55', '2', '1');
INSERT INTO `replies` VALUES ('24', '6', '2018-11-30 11:58:12', '1', '56');
INSERT INTO `replies` VALUES ('25', '6', '2018-11-30 11:58:21', '1', '那就回复一个吧');
INSERT INTO `replies` VALUES ('26', '6', '2018-11-30 11:58:35', '1', '就是这样的大');
INSERT INTO `replies` VALUES ('27', '6', '2018-11-30 11:58:42', '1', '啥好看见的发挥科技');
INSERT INTO `replies` VALUES ('28', '6', '2019-05-30 20:02:17', '15', 'aksdlfajlk拉科技的数量看见');
INSERT INTO `replies` VALUES ('29', '23', '2019-05-30 20:02:34', '15', '深V在v');
INSERT INTO `replies` VALUES ('30', '26', '2019-05-30 20:10:32', '1', '你这个也太水帖了吧');

-- ----------------------------
-- Table structure for thematic_column
-- ----------------------------
DROP TABLE IF EXISTS `thematic_column`;
CREATE TABLE `thematic_column` (
  `column_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目（吧）编号',
  `column_name` varchar(50) NOT NULL COMMENT '栏目（吧）名称',
  `description` varchar(50) NOT NULL COMMENT '栏目（吧）描述',
  `column_createdate` datetime NOT NULL COMMENT '栏目（吧）创建时间',
  `user_id` int(11) NOT NULL COMMENT '栏目（吧）创建人',
  PRIMARY KEY (`column_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `thematic_column_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='主题栏目（吧）表';

-- ----------------------------
-- Records of thematic_column
-- ----------------------------
INSERT INTO `thematic_column` VALUES ('1', '好玩吧', '这是一个很好玩的吧', '2018-11-26 10:14:30', '1');
INSERT INTO `thematic_column` VALUES ('2', '百度贴吧', '全球最大的中文社区', '2018-11-20 07:22:19', '1');
INSERT INTO `thematic_column` VALUES ('3', 'Java 吧', '有问题为什么不先问问隔壁C++吧呢？', '2018-11-01 10:24:15', '2');
INSERT INTO `thematic_column` VALUES ('4', 'c++ 吧', '有问题为什么不先问问隔壁C语言吧呢？', '2018-11-26 10:25:03', '2');
INSERT INTO `thematic_column` VALUES ('5', 'c 语言吧', '有问题为什么不先问问神奇海螺呢？', '2018-11-26 10:26:07', '2');
INSERT INTO `thematic_column` VALUES ('6', 'Python 吧', 'python学习交流基地。', '2018-11-26 10:26:58', '1');
INSERT INTO `thematic_column` VALUES ('7', 'JavaScript吧', '这就是javascript吧', '2018-11-25 10:28:24', '1');
INSERT INTO `thematic_column` VALUES ('8', 'CSS 吧', 'WEB前端布局者', '2018-11-26 10:29:16', '2');

-- ----------------------------
-- Table structure for thematic_content
-- ----------------------------
DROP TABLE IF EXISTS `thematic_content`;
CREATE TABLE `thematic_content` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '内容（帖子）编号',
  `column_id` int(11) NOT NULL COMMENT '所在的栏目（吧）的编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号（创建人的编号）',
  `thematic_content` text NOT NULL COMMENT '栏目内容（帖子内容）',
  `content_createdate` datetime NOT NULL COMMENT '栏目内容（帖子）创建时间',
  `content_title` varchar(50) NOT NULL COMMENT '栏目内容标题（帖子标题）',
  PRIMARY KEY (`content_id`),
  KEY `column_id` (`column_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `thematic_content_ibfk_1` FOREIGN KEY (`column_id`) REFERENCES `thematic_column` (`column_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `thematic_content_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='主题内容（帖子）表';

-- ----------------------------
-- Records of thematic_content
-- ----------------------------
INSERT INTO `thematic_content` VALUES ('1', '1', '2', '我是第一发帖的人，真好玩', '2018-11-26 11:17:16', '我是第一个发帖的');
INSERT INTO `thematic_content` VALUES ('2', '3', '1', '我是管理员，我就想发帖', '2018-11-26 15:53:17', '管理员');
INSERT INTO `thematic_content` VALUES ('3', '3', '2', '我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖我要发帖', '2018-11-27 10:12:22', '就是要发帖');
INSERT INTO `thematic_content` VALUES ('4', '2', '1', '抢了个沙发', '2018-11-27 10:39:43', '沙发帖');
INSERT INTO `thematic_content` VALUES ('5', '1', '1', '456', '2018-11-28 15:57:45', '123');
INSERT INTO `thematic_content` VALUES ('6', '2', '2', 'z真好玩', '2018-11-28 16:05:42', '测试帖子');
INSERT INTO `thematic_content` VALUES ('10', '4', '2', '测试帖子内容', '2018-11-28 16:13:40', '测试帖子');
INSERT INTO `thematic_content` VALUES ('11', '3', '12', 'agdhgjdgkfh,jvk,gjk.k.k.klfj', '2018-11-28 16:16:41', 'asdfagfdhg');
INSERT INTO `thematic_content` VALUES ('12', '5', '1', '新人请仔细阅读本贴，问本贴中叙述过的内容可能会遭到吧务和众吧友的反感和鄙视，请自重！\n', '2018-11-28 16:18:54', 'c语言吧新人引导，入门必看！');
INSERT INTO `thematic_content` VALUES ('13', '3', '1', '再次测试内容', '2018-11-28 16:24:34', '再次测试');
INSERT INTO `thematic_content` VALUES ('14', '4', '2', '456', '2018-11-29 09:09:15', '123');
INSERT INTO `thematic_content` VALUES ('16', '3', '2', '123', '2018-11-29 09:30:15', '最新');
INSERT INTO `thematic_content` VALUES ('17', '1', '2', '后发帖的在最前面', '2018-11-29 09:30:51', '按照时间排序');
INSERT INTO `thematic_content` VALUES ('18', '3', '2', '56', '2018-11-29 09:39:25', '13');
INSERT INTO `thematic_content` VALUES ('19', '1', '1', '123', '2018-11-29 09:46:39', '我还要发');
INSERT INTO `thematic_content` VALUES ('21', '6', '1', '都是水帖，使劲灌水', '2018-11-29 10:19:35', '我来Python发一帖子');
INSERT INTO `thematic_content` VALUES ('22', '1', '12', '1', '2018-11-29 15:18:11', '踩踩，记得回踩');
INSERT INTO `thematic_content` VALUES ('23', '8', '13', '23131', '2018-11-29 15:19:49', '阿彬到此一游');
INSERT INTO `thematic_content` VALUES ('24', '1', '13', '1321313', '2018-11-29 15:26:49', '54645');
INSERT INTO `thematic_content` VALUES ('25', '1', '14', '我老板luchangqiang未来中国第四大互联网企业创始人', '2018-11-30 11:12:45', '老板你好');
INSERT INTO `thematic_content` VALUES ('26', '2', '15', 'alkjdskfaj', '2019-05-30 19:58:33', 'adsfaf a');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(50) NOT NULL COMMENT '账户名',
  `user_pwd` varchar(50) NOT NULL COMMENT '用户密码',
  `email` varchar(50) NOT NULL COMMENT '验证邮箱',
  `user_alias` varchar(50) NOT NULL COMMENT '昵称',
  `user_type` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型（1普通用户 2管理员）',
  `createdate` datetime NOT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'root', '', '高冷的管理员', '2', '2018-11-22 15:30:33');
INSERT INTO `user` VALUES ('2', 'lcq', '123', '1780082826@qq.com', '傻强', '1', '2018-11-25 21:24:27');
INSERT INTO `user` VALUES ('3', 'nf', '123', '13481476390@163.com', '农夫山泉', '1', '2018-11-28 08:43:06');
INSERT INTO `user` VALUES ('4', 'bbs', '123', '1780082826@qq.com', '132', '1', '2018-11-28 08:48:14');
INSERT INTO `user` VALUES ('11', '农夫山泉', '123', '13481476390@163.com', 'n', '1', '2018-11-28 09:20:38');
INSERT INTO `user` VALUES ('12', 'onlin', '123456', '874394578@qq.com', 'inille', '1', '2018-11-28 11:53:30');
INSERT INTO `user` VALUES ('13', 'admin21', '123', '123@gmail.com', '阿彬', '1', '2018-11-29 15:18:44');
INSERT INTO `user` VALUES ('14', 'HHKHKH', 'LLM123', '949746546@163.COM', 'LLM', '1', '2018-11-30 11:11:15');
INSERT INTO `user` VALUES ('15', 'abc', '123', '13481476390@163.com', '465456', '1', '2019-05-30 19:57:46');
