/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : itmd4515

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-18 14:51:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `concrete_internal_hdds`
-- ----------------------------
DROP TABLE IF EXISTS `concrete_internal_hdds`;
CREATE TABLE `concrete_internal_hdds` (
  `DEVICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MODEL_NO` varchar(255) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `CINTERFACE` int(11) DEFAULT NULL,
  `COLOR` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `FORM_FACTOR` float DEFAULT NULL,
  `RPMS` int(11) DEFAULT NULL,
  `WARRANTY` int(11) NOT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  UNIQUE KEY `SERIAL_NO` (`SERIAL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concrete_internal_hdds
-- ----------------------------
INSERT INTO `concrete_internal_hdds` VALUES ('1', 'WDPU201_0500', '53900a48-66d6-4a86-809a-629d84a0314f', '500', '6', '5', null, '2.5', '5400', '5');
INSERT INTO `concrete_internal_hdds` VALUES ('3', 'WDPS201_0300', 'f5bbb681-e7cc-4eb7-aa23-06c1dc4de48e', '500', '3', '0', '--This is an updated value--', '3.5', '7200', '5');

-- ----------------------------
-- Table structure for `concrete_sdcards`
-- ----------------------------
DROP TABLE IF EXISTS `concrete_sdcards`;
CREATE TABLE `concrete_sdcards` (
  `DEVICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MODEL_NO` varchar(255) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `CINTERFACE` int(11) DEFAULT NULL,
  `SPEED_CLASS` int(11) DEFAULT NULL,
  `WARRANTY` int(11) NOT NULL,
  `WEIGHT` float DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  UNIQUE KEY `SERIAL_NO` (`SERIAL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concrete_sdcards
-- ----------------------------
INSERT INTO `concrete_sdcards` VALUES ('1', '0SD010', 'a20eb031-b5bf-4e5c-ae9b-5786536043f1', '8', '9', '10', '3', '0.2');
INSERT INTO `concrete_sdcards` VALUES ('2', 'MSD006', '0afb67ea-1dfc-400c-975a-7b25483b341f', '32', '8', '6', '3', '0.4');

-- ----------------------------
-- Table structure for `concrete_storages`
-- ----------------------------
DROP TABLE IF EXISTS `concrete_storages`;
CREATE TABLE `concrete_storages` (
  `DEVICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MODEL_NO` varchar(255) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `WARRANTY` int(11) NOT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  UNIQUE KEY `SERIAL_NO` (`SERIAL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concrete_storages
-- ----------------------------
INSERT INTO `concrete_storages` VALUES ('1', 'MAGTAPE001', '92163012-65bd-42f9-8249-efb795a3186c', '2', '1');

-- ----------------------------
-- Table structure for `joined_internal_hdds`
-- ----------------------------
DROP TABLE IF EXISTS `joined_internal_hdds`;
CREATE TABLE `joined_internal_hdds` (
  `DEVICE_ID` int(11) NOT NULL,
  `CINTERFACE` int(11) DEFAULT NULL,
  `COLOR` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `FORM_FACTOR` float DEFAULT NULL,
  `RPMS` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  CONSTRAINT `FK_joined_internal_hdds_DEVICE_ID` FOREIGN KEY (`DEVICE_ID`) REFERENCES `joined_storages` (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joined_internal_hdds
-- ----------------------------
INSERT INTO `joined_internal_hdds` VALUES ('2', '3', '0', '--This is an updated value--', '3.5', '7200');
INSERT INTO `joined_internal_hdds` VALUES ('3', '6', '5', null, '2.5', '5400');

-- ----------------------------
-- Table structure for `joined_sdcards`
-- ----------------------------
DROP TABLE IF EXISTS `joined_sdcards`;
CREATE TABLE `joined_sdcards` (
  `DEVICE_ID` int(11) NOT NULL,
  `CINTERFACE` int(11) DEFAULT NULL,
  `SPEED_CLASS` int(11) DEFAULT NULL,
  `WEIGHT` float DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  CONSTRAINT `FK_joined_sdcards_DEVICE_ID` FOREIGN KEY (`DEVICE_ID`) REFERENCES `joined_storages` (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joined_sdcards
-- ----------------------------
INSERT INTO `joined_sdcards` VALUES ('4', '9', '10', '0.2');
INSERT INTO `joined_sdcards` VALUES ('5', '8', '6', '0.4');

-- ----------------------------
-- Table structure for `joined_storages`
-- ----------------------------
DROP TABLE IF EXISTS `joined_storages`;
CREATE TABLE `joined_storages` (
  `DEVICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DTYPE` varchar(31) DEFAULT NULL,
  `MODEL_NO` varchar(255) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `WARRANTY` int(11) NOT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  UNIQUE KEY `SERIAL_NO` (`SERIAL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joined_storages
-- ----------------------------
INSERT INTO `joined_storages` VALUES ('2', 'HardDrive2', 'WDPS201_0300', 'fd53899a-5ec6-4957-ac13-76db700ffd92', '500', '5');
INSERT INTO `joined_storages` VALUES ('3', 'HardDrive2', 'WDPU201_0500', 'cb8b8aa7-de63-4b92-afe5-8519ca13a07c', '500', '5');
INSERT INTO `joined_storages` VALUES ('4', 'MemoryStick2', '0SD010', '5c9f0185-d1c4-4fd7-86d0-c344fa7023c9', '8', '3');
INSERT INTO `joined_storages` VALUES ('5', 'MemoryStick2', 'MSD006', 'f06fbb57-dbcc-4041-9cc4-5bb1904d00a4', '32', '3');
INSERT INTO `joined_storages` VALUES ('6', 'StorageDevice2', 'MAGTAPE001', 'cfc6ad51-f011-4334-b135-9a736d672bc6', '2', '1');

-- ----------------------------
-- Table structure for `single_storages`
-- ----------------------------
DROP TABLE IF EXISTS `single_storages`;
CREATE TABLE `single_storages` (
  `DEVICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `storage_type` varchar(31) DEFAULT NULL,
  `MODEL_NO` varchar(255) NOT NULL,
  `SERIAL_NO` varchar(255) NOT NULL,
  `CAPACITY` int(11) NOT NULL,
  `WARRANTY` int(11) NOT NULL,
  `CINTERFACE` int(11) DEFAULT NULL,
  `SPEED_CLASS` int(11) DEFAULT NULL,
  `WEIGHT` float DEFAULT NULL,
  `COLOR` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `FORM_FACTOR` float DEFAULT NULL,
  `RPMS` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`),
  UNIQUE KEY `SERIAL_NO` (`SERIAL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of single_storages
-- ----------------------------
INSERT INTO `single_storages` VALUES ('1', 'Internal_HDD', 'WDPS201_0300', 'f5c3ec09-d700-4e7e-a363-a9e6efa3971f', '500', '5', '3', null, null, '0', '--This is an updated value--', '3.5', '7200');
INSERT INTO `single_storages` VALUES ('2', 'Internal_HDD', 'WDBS302_1000', '3ac5c9ab-fbce-44ce-bc5f-b439c0333d76', '1000', '5', '4', null, null, '3', null, '3.5', '10000');
INSERT INTO `single_storages` VALUES ('3', 'Internal_HDD', 'WDPU201_0500', '82b26afa-2b59-4098-904c-0efe499cc007', '500', '5', '6', null, null, '5', null, '2.5', '5400');
INSERT INTO `single_storages` VALUES ('4', 'SD_Card', '0SD010', 'c9e7e86b-4951-4a1c-ae41-e932fd588ea6', '8', '3', '9', '10', '0.2', null, null, null, null);
INSERT INTO `single_storages` VALUES ('5', 'SD_Card', 'MSD006', 'ba5281ac-f814-495c-a6f8-1f61bf837ec8', '32', '3', '8', '6', '0.4', null, null, null, null);
