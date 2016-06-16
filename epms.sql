/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : epms

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2016-06-16 10:19:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approle
-- ----------------------------
DROP TABLE IF EXISTS `approle`;
CREATE TABLE `approle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `permissionLevel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of approle
-- ----------------------------
INSERT INTO `approle` VALUES ('1', 'ROLE_USER', '1');
INSERT INTO `approle` VALUES ('2', 'ROLE_VIEWER', '2');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `Devicetype_Id` int(11) DEFAULT NULL,
  `TestingPoint` varchar(255) DEFAULT NULL,
  `LastMaintenanceDate` datetime DEFAULT NULL,
  `SeculededPreventiveMaintenaceDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '001', '1', 'Lab', null, null);
INSERT INTO `device` VALUES ('2', '003', '1', 'Lab', '2016-01-06 00:00:00', '2018-06-06 00:00:00');

-- ----------------------------
-- Table structure for devicetype
-- ----------------------------
DROP TABLE IF EXISTS `devicetype`;
CREATE TABLE `devicetype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of devicetype
-- ----------------------------
INSERT INTO `devicetype` VALUES ('1', 'CD4');
INSERT INTO `devicetype` VALUES ('2', 'Facs Prestos');

-- ----------------------------
-- Table structure for nodeconfiguration
-- ----------------------------
DROP TABLE IF EXISTS `nodeconfiguration`;
CREATE TABLE `nodeconfiguration` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Country` varchar(255) DEFAULT NULL,
  `Province` varchar(255) DEFAULT NULL,
  `District` varchar(255) DEFAULT NULL,
  `Facility` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nodeconfiguration
-- ----------------------------
INSERT INTO `nodeconfiguration` VALUES ('1', 'Ethiopia', 'Oromia', 'Arsi', 'Arsi HC');

-- ----------------------------
-- Table structure for nodehealthstatistics
-- ----------------------------
DROP TABLE IF EXISTS `nodehealthstatistics`;
CREATE TABLE `nodehealthstatistics` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LogDate` datetime DEFAULT NULL,
  `Lat` varchar(255) DEFAULT NULL,
  `Long` varchar(255) DEFAULT NULL,
  `BatteryStatus` varchar(255) DEFAULT NULL,
  `NetworkSignalStrength` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nodehealthstatistics
-- ----------------------------
INSERT INTO `nodehealthstatistics` VALUES ('1', '2016-06-10 08:32:35', '2', '2', 'Good', 'Good');

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `PROPERTY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCOPE` enum('GLOBAL','SYSTEM','USER') DEFAULT NULL,
  `ENTITY_TYPE` varchar(45) DEFAULT NULL,
  `ENTITY_VALUE` varchar(45) DEFAULT NULL,
  `KEY` text,
  `VALUE` text,
  `CREATED_TIMESTAMP` varchar(45) DEFAULT NULL,
  `UPDATED_TIMESTAMP` varchar(45) DEFAULT NULL,
  `CREATED_BY` varchar(45) DEFAULT NULL,
  `UPDATED_BY` varchar(45) DEFAULT NULL,
  `ARCHIVING_STATUS_ID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PROPERTY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES ('71', 'SYSTEM', null, null, 'bd.presto.source.folder', '/home/ubuntu/usbfiles', null, null, null, null, null);
INSERT INTO `property` VALUES ('72', 'SYSTEM', null, null, 'bd.presto.destination.folder', '/home/ubuntu/tempbdfiles', null, null, null, null, null);
INSERT INTO `property` VALUES ('73', 'SYSTEM', null, null, 'other.file.ftp.destination.folder', '/home/ubuntu/otherfiles', null, null, null, null, null);
INSERT INTO `property` VALUES ('74', 'USER', null, null, 'bd.presto.export.record.limit', '5', null, null, null, null, null);
INSERT INTO `property` VALUES ('75', 'SYSTEM', null, null, 'bd.presto.file.ftp.destination.folder', '/home/ubuntu/bdfinalbdfiles', null, null, null, null, null);
INSERT INTO `property` VALUES ('76', 'USER', null, null, 'bd.presto.ftp.server', 'mhealth.nmrl.org.zw', null, null, null, null, null);
INSERT INTO `property` VALUES ('77', 'USER', null, null, 'bd.presto.ftp.username', 'testuser', null, null, null, null, null);
INSERT INTO `property` VALUES ('78', 'USER', null, null, 'bd.presto.ftp.password', 'password', null, null, null, null, null);
INSERT INTO `property` VALUES ('79', 'USER', null, null, 'bd.presto.ftp.ispassivemode', '1', null, null, null, null, null);
INSERT INTO `property` VALUES ('80', 'USER', null, null, 'bd.presto.ftp.usefor.other.files', '1', null, null, null, null, null);
INSERT INTO `property` VALUES ('81', 'USER', null, null, 'bd.presto.ftp.port', '21', null, null, null, null, null);
INSERT INTO `property` VALUES ('82', 'USER', null, null, 'bd.other.ftp.server', 'mhealth.nmrl.org.zw', null, null, null, null, null);
INSERT INTO `property` VALUES ('83', 'USER', null, null, 'bd.other.ftp.username', 'testuser', null, null, null, null, null);
INSERT INTO `property` VALUES ('84', 'USER', null, null, 'bd.other.ftp.password', 'password', null, null, null, null, null);
INSERT INTO `property` VALUES ('85', 'USER', null, null, 'bd.other.ftp.ispassivemode', '1', null, null, null, null, null);
INSERT INTO `property` VALUES ('86', 'USER', null, null, 'bd.other.ftp.port', '21', null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `phoneno` varchar(255) DEFAULT NULL,
  `IsActive` bit(1) DEFAULT NULL,
  `LastLogIn` date DEFAULT NULL,
  `DateCreated` date DEFAULT NULL,
  `DateModified` date DEFAULT NULL,
  `GetSMSNotification` bit(1) DEFAULT NULL,
  `GetEMailNotification` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Yonatan', 'Gossaye', 'Dessalegn', 'yonatan', '5f4dcc3b5aa765d61d8327deb882cf99', 'yoni@gmail.com', 'Programmer', '', '2015-07-21', '2015-07-22', '2015-07-22', null, null);
INSERT INTO `user` VALUES ('2', 'Geleta', 'Abate', 'Fulas', 'geleta', '5f4dcc3b5aa765d61d8327deb882cf99', 'ageleta@clintonhealthaccess.org', '0913168564', '', null, '2016-06-14', null, '\0', null);

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `UserID` int(11) NOT NULL,
  `AppRoleID` int(11) NOT NULL,
  PRIMARY KEY (`UserID`,`AppRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '1');
INSERT INTO `userrole` VALUES ('2', '2');
