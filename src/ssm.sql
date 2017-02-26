/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : ssmm

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-02-26 21:49:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL default '0',
  `user_id` int(11) default NULL,
  `room_id` int(11) default NULL,
  `content` varchar(255) default NULL,
  `createtime` date default NULL,
  PRIMARY KEY  (`record_id`),
  KEY `rrid` (`user_id`),
  CONSTRAINT `rrid` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('17021501', '2', '1001', 'WTO', '2017-02-15');
INSERT INTO `record` VALUES ('17021502', '3', '1002', 'POG', '2017-02-15');
INSERT INTO `record` VALUES ('17021503', '2', '1002', 'JSR 303', '2017-02-16');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `size` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1001', '天罡地煞', '6');
INSERT INTO `room` VALUES ('1002', '北斗七星', '8');
INSERT INTO `room` VALUES ('1003', '华夏大厦', '6');
INSERT INTO `room` VALUES ('1004', '幽暗阁', '8');
INSERT INTO `room` VALUES ('1005', 'maven Meeting', '6');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `imgUrl` varchar(255) default NULL,
  `IsAdmin` char(1) default 'N',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '1195805998@qq.com', '123', '13819194541', null, 'Y');
INSERT INTO `userinfo` VALUES ('2', 'chuang', '123', '17682440726', '/upload/1487851434911.jpg', 'Y');
INSERT INTO `userinfo` VALUES ('3', 'zhwj', '123', '17877837844', null, 'N');
INSERT INTO `userinfo` VALUES ('4', 'echo', '123', '15671448765', null, 'N');
INSERT INTO `userinfo` VALUES ('5', 'huwenhua', '123', '15671448765', null, 'N');
INSERT INTO `userinfo` VALUES ('6', 'zhanghua', '123', '13819195024', null, 'Y');
INSERT INTO `userinfo` VALUES ('7', 'wenhua', '123', '13819195024', null, 'N');
INSERT INTO `userinfo` VALUES ('8', 'mengfan', '3333', '17682440726', null, 'N');
INSERT INTO `userinfo` VALUES ('9', 'ssss', '123', '15687664244', null, 'N');
INSERT INTO `userinfo` VALUES ('10', '11111', '1111', '15687664244', null, 'N');
INSERT INTO `userinfo` VALUES ('11', '张少', '123', '15687664244', null, 'N');
INSERT INTO `userinfo` VALUES ('12', 'aaaa', 'aaaaa', '13610987643', null, 'N');
INSERT INTO `userinfo` VALUES ('13', 'uuuuu', 'kkkkk', '15687664244', '/upload/1487851766316.jpg', 'N');
