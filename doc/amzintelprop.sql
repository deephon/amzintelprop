/*
Navicat MySQL Data Transfer

Source Server         : Learning
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : amzintelprop

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-12-20 19:29:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for amz_account
-- ----------------------------
DROP TABLE IF EXISTS `amz_account`;
CREATE TABLE `amz_account` (
  `account_id` varchar(100) NOT NULL COMMENT '账号ID',
  `account` varchar(255) NOT NULL COMMENT '账号',
  `principal` varchar(255) DEFAULT NULL COMMENT '负责人',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of amz_account
-- ----------------------------
INSERT INTO `amz_account` VALUES ('585f483285974b57921a9d6ebf83ee6a', 'test', 'test', 'test', 'test');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `data_id` varchar(32) NOT NULL COMMENT '字典标识',
  `data_value` varchar(255) NOT NULL COMMENT '字典名称',
  `data_key` int(6) NOT NULL COMMENT '字典编码',
  `type_id` varchar(32) NOT NULL COMMENT '字典类型标识',
  `type_code` int(6) NOT NULL COMMENT '字典类型编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`data_id`),
  KEY `type_id` (`type_id`),
  KEY `type_code` (`type_code`),
  CONSTRAINT `sys_dict_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `sys_dict_type` (`type_id`),
  CONSTRAINT `sys_dict_ibfk_2` FOREIGN KEY (`type_code`) REFERENCES `sys_dict_type` (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('354995888dfe4e8ea967875e251698bd', '侵权', '0', 'd245576bc63b4f15beeeb74dc2e52568', '110', '侵权SKU');
INSERT INTO `sys_dict` VALUES ('be9ebc3096714020b49b8bbc8c8d965b', '已审核', '0', '9b376361a2a9480992dbb0efb981e03f', '120', '已审核SKU');
INSERT INTO `sys_dict` VALUES ('e2b42d833f7d45ce85eded7672050ebd', '未侵权', '1', 'd245576bc63b4f15beeeb74dc2e52568', '110', '未侵权');
INSERT INTO `sys_dict` VALUES ('efc0cfc80544454a85dbbead087560eb', '未审核', '1', '9b376361a2a9480992dbb0efb981e03f', '120', '尚未审核SKU');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `type_id` varchar(32) NOT NULL COMMENT '字典类型标识',
  `type_name` varchar(255) NOT NULL COMMENT '字典类型名称',
  `type_code` int(6) NOT NULL COMMENT '字典类型编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`type_id`),
  KEY `type_code` (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('9b376361a2a9480992dbb0efb981e03f', '是否审核', '120', '判断是否已经审核');
INSERT INTO `sys_dict_type` VALUES ('d245576bc63b4f15beeeb74dc2e52568', '是否侵权', '110', '判断是否侵权');
