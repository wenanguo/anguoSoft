/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : bae

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2013-07-14 18:42:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'wenanguo');
INSERT INTO user VALUES ('2', '文安国');
