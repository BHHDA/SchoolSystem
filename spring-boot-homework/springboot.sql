/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2021-11-28 17:18:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `no` int(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', '张三', '20');

-- ----------------------------
-- Table structure for doorer
-- ----------------------------
DROP TABLE IF EXISTS `doorer`;
CREATE TABLE `doorer` (
  `jobno` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(200) NOT NULL,
  `jname` varchar(200) NOT NULL,
  PRIMARY KEY (`jobno`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doorer
-- ----------------------------
INSERT INTO `doorer` VALUES ('1000', '123', '达布拉');
INSERT INTO `doorer` VALUES ('1001', '123', '张天');
INSERT INTO `doorer` VALUES ('1002', '123', '刘东');
INSERT INTO `doorer` VALUES ('1003', '123', '张大天');
INSERT INTO `doorer` VALUES ('1004', '123', '陈铎皮');
INSERT INTO `doorer` VALUES ('1006', '123', '毛冲天');
INSERT INTO `doorer` VALUES ('1007', '123', '林天多');
INSERT INTO `doorer` VALUES ('1008', '123', '迪卢克');

-- ----------------------------
-- Table structure for nacheck
-- ----------------------------
DROP TABLE IF EXISTS `nacheck`;
CREATE TABLE `nacheck` (
  `jobno` int(11) DEFAULT NULL,
  `jname` varchar(200) NOT NULL,
  `sno` int(20) NOT NULL,
  `sname` varchar(200) DEFAULT NULL,
  `checktime` datetime DEFAULT NULL,
  `changetime` datetime DEFAULT NULL,
  `healthcode` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nacheck
-- ----------------------------
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-23 15:49:00', '2021-11-23 15:49:24', 'Y');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-23 15:51:00', '2021-11-23 15:51:23', 'N');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-23 16:35:00', '2021-11-23 16:35:52', 'Y');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-23 16:40:00', '2021-11-23 16:40:39', 'Y');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-23 16:41:00', '2021-11-23 16:41:54', 'Y');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-25 10:03:00', '2021-11-25 10:03:58', 'Y');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-25 19:01:00', '2021-11-25 19:01:57', 'Y');
INSERT INTO `nacheck` VALUES ('5002', '刘大', '1940129000', '黄韵', '2021-11-27 02:22:00', '2021-11-27 02:22:40', 'Y');
INSERT INTO `nacheck` VALUES ('5003', '陈晨', '1940129000', '黄韵', '2021-11-28 15:19:00', '2021-11-28 15:19:54', 'Y');
INSERT INTO `nacheck` VALUES ('5003', '陈晨', '1940129000', '黄韵', '2021-11-28 15:21:00', '2021-11-28 15:21:45', 'N');
INSERT INTO `nacheck` VALUES ('5000', '张朵朵', '1940129000', '黄韵', '2021-11-28 16:22:00', '2021-11-28 16:22:50', 'Y');

-- ----------------------------
-- Table structure for nucleictester
-- ----------------------------
DROP TABLE IF EXISTS `nucleictester`;
CREATE TABLE `nucleictester` (
  `jobno` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(200) NOT NULL,
  `jname` varchar(200) NOT NULL,
  PRIMARY KEY (`jobno`)
) ENGINE=InnoDB AUTO_INCREMENT=5011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nucleictester
-- ----------------------------
INSERT INTO `nucleictester` VALUES ('5000', '123', '张朵朵');
INSERT INTO `nucleictester` VALUES ('5001', '123', '刘大');
INSERT INTO `nucleictester` VALUES ('5002', '123', '刘大');
INSERT INTO `nucleictester` VALUES ('5003', '123', '陈晨');
INSERT INTO `nucleictester` VALUES ('5004', '123', '陈东');
INSERT INTO `nucleictester` VALUES ('5005', '123', '陈楠');
INSERT INTO `nucleictester` VALUES ('5006', '123', '张天佑');
INSERT INTO `nucleictester` VALUES ('5007', '123', '林只比');
INSERT INTO `nucleictester` VALUES ('5008', '123', '毛多多');
INSERT INTO `nucleictester` VALUES ('5009', '123', '秦七七');
INSERT INTO `nucleictester` VALUES ('5010', '123', '胡桃');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `jobno` int(20) NOT NULL,
  `jname` varchar(200) NOT NULL,
  `area` varchar(150) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('2', '1000', '达布拉', '北门', '2021-11-18 03:46:00', '2021-11-18 14:46:00');
INSERT INTO `plan` VALUES ('8', '1000', '达布拉', '北门', '2021-11-21 11:03:00', '2021-11-21 15:03:00');
INSERT INTO `plan` VALUES ('9', '1000', '达布拉', '南门', '2021-11-22 11:03:00', '2021-11-22 13:03:00');
INSERT INTO `plan` VALUES ('10', '1001', '张天', '北门', '2021-11-22 00:13:00', '2021-11-22 23:13:00');
INSERT INTO `plan` VALUES ('13', '5000', '张朵朵', '校外监测点', '2021-11-23 14:33:00', '2021-11-23 23:33:00');
INSERT INTO `plan` VALUES ('15', '1003', '张大天', '南门', '2021-11-23 19:07:00', '2021-11-23 20:07:00');
INSERT INTO `plan` VALUES ('16', '5001', '刘大', '校外监测点', '2021-11-22 10:07:00', '2021-11-22 20:07:00');
INSERT INTO `plan` VALUES ('17', '1000', '达布拉', '北门', '2021-11-23 17:32:00', '2021-11-23 23:32:00');
INSERT INTO `plan` VALUES ('18', '1004', '陈铎皮', '南门', '2021-11-25 08:01:00', '2021-11-25 14:01:00');
INSERT INTO `plan` VALUES ('19', '5000', '张朵朵', '校外监测点', '2021-11-25 08:03:00', '2021-11-25 11:03:00');
INSERT INTO `plan` VALUES ('20', '5000', '张朵朵', '校外监测点', '2021-11-25 19:00:00', '2021-11-25 23:01:00');
INSERT INTO `plan` VALUES ('21', '1000', '达布拉', '北门', '2021-11-26 00:12:00', '2021-11-26 23:59:00');
INSERT INTO `plan` VALUES ('22', '5001', '刘大', '校外监测点', '2021-11-26 00:13:00', '2021-11-26 23:59:00');
INSERT INTO `plan` VALUES ('23', '1006', '毛冲天', '南门', '2021-11-27 00:15:00', '2021-11-27 23:15:00');
INSERT INTO `plan` VALUES ('24', '5002', '刘大', '校外监测点', '2021-11-27 01:15:00', '2021-11-27 23:16:00');
INSERT INTO `plan` VALUES ('25', '1003', '张大天', '北门', '2021-11-28 15:18:00', '2021-11-28 20:18:00');
INSERT INTO `plan` VALUES ('26', '5003', '陈晨', '校外监测点', '2021-11-28 15:19:00', '2021-11-28 20:19:00');
INSERT INTO `plan` VALUES ('27', '1008', '迪卢克', '北门', '2021-11-28 02:41:00', '2021-11-28 22:41:00');
INSERT INTO `plan` VALUES ('28', '5010', '胡桃', '校外监测点', '2021-11-28 07:41:00', '2021-11-28 23:41:00');

-- ----------------------------
-- Table structure for signin
-- ----------------------------
DROP TABLE IF EXISTS `signin`;
CREATE TABLE `signin` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `sno` int(11) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL,
  `body` int(11) DEFAULT NULL,
  `t1` int(11) DEFAULT NULL,
  `t2` int(11) DEFAULT NULL,
  `t3` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signin
-- ----------------------------
INSERT INTO `signin` VALUES ('5', '1940129000', '黄韵', '1', '1', '1', '1', '1', '2021-11-25 19:00:04');
INSERT INTO `signin` VALUES ('6', '1940129006', '刘城东', '1', '0', '0', '0', '1', '2021-11-27 16:12:53');
INSERT INTO `signin` VALUES ('7', '1940129000', '黄韵', '3', '1', '0', '0', '1', '2021-11-28 15:21:20');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `major` varchar(200) DEFAULT NULL,
  `local` varchar(10) DEFAULT NULL,
  `healthcode` varchar(10) DEFAULT NULL,
  `clockin` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=1940129013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1940129000', '123', '黄韵', '女', '18', '软件工程', '在校', 'N', '已提交');
INSERT INTO `student` VALUES ('1940129001', '123', '张晨', '男', '21', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129002', '123', '黄柳柳', '女', '20', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129003', '123', '黄渤', '男', '22', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129004', '123', '林多', '男', '19', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129005', '123', '陈天', '男', '20', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129006', '123', '刘城东', '男', '21', '软件工程', '在校', 'N', '已提交');
INSERT INTO `student` VALUES ('1940129007', '123', '李成', '男', '21', '软件工程', '在校', 'N', '未提交');
INSERT INTO `student` VALUES ('1940129008', '123', '陈千', '女', '19', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129009', '123', '张体', '男', '20', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129010', '123', '林德', '男', '21', '软件工程', '在校', 'Y', '未提交');
INSERT INTO `student` VALUES ('1940129012', '123', '芭芭拉', '女', '18', '软件工程', null, null, null);

-- ----------------------------
-- Table structure for timeer
-- ----------------------------
DROP TABLE IF EXISTS `timeer`;
CREATE TABLE `timeer` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `jobno` int(255) NOT NULL,
  `jname` varchar(200) NOT NULL,
  `sno` int(20) NOT NULL,
  `sname` varchar(200) NOT NULL,
  `outtime` datetime DEFAULT NULL,
  `cometime` datetime DEFAULT NULL,
  `outarea` varchar(255) DEFAULT NULL,
  `comearea` varchar(255) DEFAULT NULL,
  `heathcode` varchar(10) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timeer
-- ----------------------------
INSERT INTO `timeer` VALUES ('1', '1000', '达布拉', '1940129000', '黄韵', '2021-11-22 01:46:17', '2021-11-23 16:34:20', '南门', '南门', 'N');
INSERT INTO `timeer` VALUES ('2', '1004', '陈铎皮', '1940129000', '黄韵', '2021-11-24 01:46:22', '2021-11-25 10:01:58', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('5', '1006', '毛冲天', '1940129000', '黄韵', '2021-11-27 02:22:52', '2021-11-27 02:23:10', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('6', '1006', '毛冲天', '1940129000', '黄韵', '2021-11-27 02:23:32', '2021-11-27 02:23:51', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('9', '1006', '毛冲天', '1940129003', '黄渤', '2021-11-27 02:29:03', '2021-11-27 02:31:21', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('10', '1006', '毛冲天', '1940129004', '林多', '2021-11-27 02:31:49', '2021-11-27 02:32:03', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('11', '1006', '毛冲天', '1940129011', '曹大发', '2021-11-27 15:29:54', '2021-11-27 15:30:38', '南门', '南门', 'Y');
INSERT INTO `timeer` VALUES ('12', '1003', '张大天', '1940129000', '黄韵', '2021-11-28 15:19:26', '2021-11-28 15:22:29', '北门', '北门', 'N');
INSERT INTO `timeer` VALUES ('13', '1003', '张大天', '1940129000', '黄韵', '2021-11-28 16:05:50', '2021-11-28 16:43:22', '北门', '北门', 'N');
INSERT INTO `timeer` VALUES ('14', '1008', '迪卢克', '1940129000', '黄韵', '2021-11-28 16:59:01', '2021-11-28 16:59:23', '北门', '北门', 'Y');

-- ----------------------------
-- Table structure for waiting
-- ----------------------------
DROP TABLE IF EXISTS `waiting`;
CREATE TABLE `waiting` (
  `sno` int(11) NOT NULL,
  `sname` varchar(255) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waiting
-- ----------------------------
INSERT INTO `waiting` VALUES ('1940129000', '黄韵');
