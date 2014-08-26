/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50171
Source Host           : 115.29.151.55:3306
Source Database       : wenanguo

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2014-04-15 23:31:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `ACT_GE_BYTEARRAY`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_GE_BYTEARRAY`;
CREATE TABLE `ACT_GE_BYTEARRAY` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_RE_DEPLOYMENT` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_GE_BYTEARRAY
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_GE_PROPERTY`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_GE_PROPERTY`;
CREATE TABLE `ACT_GE_PROPERTY` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_GE_PROPERTY
-- ----------------------------
INSERT INTO ACT_GE_PROPERTY VALUES ('next.dbid', '1', '1');
INSERT INTO ACT_GE_PROPERTY VALUES ('schema.history', 'create(5.13)', '1');
INSERT INTO ACT_GE_PROPERTY VALUES ('schema.version', '5.13', '1');

-- ----------------------------
-- Table structure for `ACT_HI_ACTINST`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_ACTINST`;
CREATE TABLE `ACT_HI_ACTINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_ACTINST
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_ATTACHMENT`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_ATTACHMENT`;
CREATE TABLE `ACT_HI_ATTACHMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_ATTACHMENT
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_COMMENT`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_COMMENT`;
CREATE TABLE `ACT_HI_COMMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_COMMENT
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_DETAIL`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_DETAIL`;
CREATE TABLE `ACT_HI_DETAIL` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_DETAIL
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_IDENTITYLINK`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_IDENTITYLINK`;
CREATE TABLE `ACT_HI_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_IDENTITYLINK
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_PROCINST`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_PROCINST`;
CREATE TABLE `ACT_HI_PROCINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  UNIQUE KEY `ACT_UNIQ_HI_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_PROCINST
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_TASKINST`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_TASKINST`;
CREATE TABLE `ACT_HI_TASKINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_TASKINST
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_HI_VARINST`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_HI_VARINST`;
CREATE TABLE `ACT_HI_VARINST` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_HI_VARINST
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_ID_GROUP`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_ID_GROUP`;
CREATE TABLE `ACT_ID_GROUP` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_ID_GROUP
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_ID_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_ID_INFO`;
CREATE TABLE `ACT_ID_INFO` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_ID_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_ID_MEMBERSHIP`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_ID_MEMBERSHIP`;
CREATE TABLE `ACT_ID_MEMBERSHIP` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `ACT_ID_GROUP` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `ACT_ID_USER` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_ID_MEMBERSHIP
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_ID_USER`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_ID_USER`;
CREATE TABLE `ACT_ID_USER` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_ID_USER
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RE_DEPLOYMENT`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RE_DEPLOYMENT`;
CREATE TABLE `ACT_RE_DEPLOYMENT` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOY_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RE_DEPLOYMENT
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RE_MODEL`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RE_MODEL`;
CREATE TABLE `ACT_RE_MODEL` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `ACT_RE_DEPLOYMENT` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RE_MODEL
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RE_PROCDEF`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RE_PROCDEF`;
CREATE TABLE `ACT_RE_PROCDEF` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RE_PROCDEF
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_EVENT_SUBSCR`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_EVENT_SUBSCR`;
CREATE TABLE `ACT_RU_EVENT_SUBSCR` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_EVENT_SUBSCR
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_EXECUTION`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_EXECUTION`;
CREATE TABLE `ACT_RU_EXECUTION` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_RU_BUS_KEY` (`PROC_DEF_ID_`,`BUSINESS_KEY_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_EXECUTION
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_IDENTITYLINK`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_IDENTITYLINK`;
CREATE TABLE `ACT_RU_IDENTITYLINK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `ACT_RU_TASK` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_IDENTITYLINK
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_JOB`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_JOB`;
CREATE TABLE `ACT_RU_JOB` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_JOB
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_TASK`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_TASK`;
CREATE TABLE `ACT_RU_TASK` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DUE_DATE_` datetime DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `ACT_RE_PROCDEF` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_TASK
-- ----------------------------

-- ----------------------------
-- Table structure for `ACT_RU_VARIABLE`
-- ----------------------------
DROP TABLE IF EXISTS `ACT_RU_VARIABLE`;
CREATE TABLE `ACT_RU_VARIABLE` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `ACT_GE_BYTEARRAY` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `ACT_RU_EXECUTION` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ACT_RU_VARIABLE
-- ----------------------------

-- ----------------------------
-- Table structure for `common_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `common_role_authority`;
CREATE TABLE `common_role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `common_sys_role_id` int(11) DEFAULT NULL,
  `common_sys_authority_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_common_sys_authority_ref_common_role_authority_mapping` (`common_sys_authority_id`),
  KEY `FK_common_sys_role_ref_common_role_authority_mapping` (`common_sys_role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of common_role_authority
-- ----------------------------
INSERT INTO common_role_authority VALUES ('1', '2', '2');
INSERT INTO common_role_authority VALUES ('7', '2', '3');
INSERT INTO common_role_authority VALUES ('8', '2', '4');
INSERT INTO common_role_authority VALUES ('9', '2', '5');
INSERT INTO common_role_authority VALUES ('10', '2', '6');
INSERT INTO common_role_authority VALUES ('11', '2', '113');
INSERT INTO common_role_authority VALUES ('12', '2', '114');
INSERT INTO common_role_authority VALUES ('13', '2', '115');

-- ----------------------------
-- Table structure for `common_sys_authority`
-- ----------------------------
DROP TABLE IF EXISTS `common_sys_authority`;
CREATE TABLE `common_sys_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of common_sys_authority
-- ----------------------------
INSERT INTO common_sys_authority VALUES ('3', '10001', '网站数据管理', '', null, '2', '1', '0', '100');
INSERT INTO common_sys_authority VALUES ('4', '10002', '内容管理', 'jsp/news/newsManager.jsp', 'computer_add', '2', '2', '3', null);
INSERT INTO common_sys_authority VALUES ('5', '10000', '配置管理', 'jsp/news/newsConfigManager.jsp', null, '2', '3', '3', null);
INSERT INTO common_sys_authority VALUES ('6', '10003', '消息管理', 'jsp/news/newsManager.jsp', null, '2', '1', '3', null);
INSERT INTO common_sys_authority VALUES ('1', null, '所有用户权限', '/**', null, '1', '1', '0', null);
INSERT INTO common_sys_authority VALUES ('2', null, '登录首页', '/index.jsp', null, '1', '2', '0', null);
INSERT INTO common_sys_authority VALUES ('113', null, '系统管理', '1111', null, '2', '1', '0', null);
INSERT INTO common_sys_authority VALUES ('114', null, '用户管理', 'jsp/system/userManager.jsp', null, '2', '1', '113', null);
INSERT INTO common_sys_authority VALUES ('115', null, '角色管理', 'jsp/system/roleManager.jsp', null, '2', '1', '113', null);

-- ----------------------------
-- Table structure for `common_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `common_sys_dict`;
CREATE TABLE `common_sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号.',
  `type_name` varchar(100) DEFAULT NULL COMMENT '类别名称.',
  `field_name` varchar(100) DEFAULT NULL COMMENT '字段名称.',
  `field_value` varchar(100) DEFAULT NULL COMMENT '字段值.',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点.',
  `status` int(11) DEFAULT NULL COMMENT '状态.',
  `operate_user_id` int(11) DEFAULT NULL COMMENT '操作人.',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of common_sys_dict
-- ----------------------------
INSERT INTO common_sys_dict VALUES ('1', 'authority.type', '菜单', '1', '0', '100', '1', '2013-10-12 20:04:55');

-- ----------------------------
-- Table structure for `common_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `common_sys_role`;
CREATE TABLE `common_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `e_name` varchar(100) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色表.';

-- ----------------------------
-- Records of common_sys_role
-- ----------------------------
INSERT INTO common_sys_role VALUES ('2', '超级管理员角色', 'ROLE_ADMIN', null, '100');
INSERT INTO common_sys_role VALUES ('3', '配置管理角色', 'ROLE_USER', null, '100');
INSERT INTO common_sys_role VALUES ('4', '报表编辑角色', 'ROLE_EDIT', null, '100');

-- ----------------------------
-- Table structure for `common_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `common_sys_user`;
CREATE TABLE `common_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `operate_user_id` int(11) DEFAULT NULL,
  `operate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表.';

-- ----------------------------
-- Records of common_sys_user
-- ----------------------------
INSERT INTO common_sys_user VALUES ('1', 'wenanguo', 'wenanguo', '文安国', '2014-04-30 20:14:57', 'wenanguo110@163.com', '15285027249', '备注', '100', '1', '2013-10-11 16:18:41');
INSERT INTO common_sys_user VALUES ('2', 'user', 'user', '测试用户', '2013-10-11 16:18:55', 'user@163.com', '15285027249', '备注', '100', '1', '2013-10-11 16:19:15');

-- ----------------------------
-- Table structure for `common_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `common_user_role`;
CREATE TABLE `common_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `common_sys_user_id` int(11) DEFAULT NULL,
  `common_sys_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_common_sys_role_ref_common_user_role` (`common_sys_role_id`),
  KEY `FK_common_sys_user_ref_common_user_role_mapping` (`common_sys_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of common_user_role
-- ----------------------------
INSERT INTO common_user_role VALUES ('1', '1', '2');
INSERT INTO common_user_role VALUES ('11', '2', '3');
INSERT INTO common_user_role VALUES ('12', '2', '2');
INSERT INTO common_user_role VALUES ('10', '5', '2');
INSERT INTO common_user_role VALUES ('9', '5', '4');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', '文安国adfasdaf');

-- ----------------------------
-- Table structure for `web_config`
-- ----------------------------
DROP TABLE IF EXISTS `web_config`;
CREATE TABLE `web_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content_type` int(11) DEFAULT NULL,
  `content_class` int(11) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态.',
  `operate_user_id` int(11) DEFAULT NULL COMMENT '操作人.',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间.',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_config
-- ----------------------------
INSERT INTO web_config VALUES ('7', 'config.contactUs', '联系我们', '1', null, '<table width=\"240\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tbody><tr class=\"firstRow\"><td height=\"120\" colspan=\"2\">&nbsp;</td></tr><tr><td width=\"10\" height=\"25\"><br/></td><td width=\"230\">地址:贵阳市南明区宝山南路5210、5122号</td></tr><tr><td width=\"10\" height=\"25\"><br/></td><td width=\"230\">电话:0851-xxxxxxx,0851-xxxxxxx</td></tr><tr><td width=\"10\" height=\"25\"><br/></td><td width=\"230\">E-mail:xxxxxxx@163.com</td></tr></tbody></table>', null, null, null);
INSERT INTO web_config VALUES ('8', 'config.linkBottom', '友情连接', '1', null, '<p><span style=\"color:#575352\"><strong>友情链接： | 百度 | 腾讯 | 网易 | 新浪 | 搜狐</strong></span></p>', null, null, null);
INSERT INTO web_config VALUES ('9', 'config.copyright', '版权说明', '1', null, '&nbsp; &nbsp;<span style=\"color:#575352\"><strong>贵州锦越和能公司有限公司 版权所有 COPYRIGHT 2013 GUIYANG JINGYUEHENENG ELECTRIC CO.,LTD.</strong></span>', null, null, null);
INSERT INTO web_config VALUES ('10', 'config.weibo', '微博', '1', null, '<a href=\"http://weibo.com/wenanguo\" target=\"_blank\"><img src=\"web/images/sina.png\"/></a> &nbsp;<a href=\"http://t.qq.com/Win79912844\" target=\"_blank\"><img src=\"web/images/qq-weib.png\"/></a>', null, null, null);
INSERT INTO web_config VALUES ('12', 'config.title', '网站名称', '1', null, '贵州锦越和能源', null, null, null);
INSERT INTO web_config VALUES ('13', 'config.shortcutIcon', '小图标', '1', null, '<link rel=\"shortcut icon\" href=\"${pageContext.request.contextPath}/web/images/2.ico\"/>', null, null, null);
INSERT INTO web_config VALUES ('14', 'config.logoImage', 'logo图片', '1', null, '<a href=\"web/index.htm\"><img src=\"web/images/logo3.png\" alt=\"贵州锦越和能公司\"/></a>', null, null, null);
INSERT INTO web_config VALUES ('15', 'config.footLogoImage', '底部logo', '1', null, '&nbsp; &nbsp;&nbsp;', null, null, null);

-- ----------------------------
-- Table structure for `web_news`
-- ----------------------------
DROP TABLE IF EXISTS `web_news`;
CREATE TABLE `web_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_title` varchar(100) DEFAULT NULL,
  `sub_title` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  `content` text,
  `is_display_preview_img` int(11) DEFAULT '1',
  `preview_img` varchar(500) DEFAULT NULL,
  `web_news_type_id` int(11) DEFAULT NULL,
  `is_red` int(11) DEFAULT '1',
  `hits` int(11) DEFAULT '0',
  `content_type` int(11) DEFAULT '1',
  `status` int(11) DEFAULT NULL COMMENT '状态.',
  `operate_user_id` int(11) DEFAULT NULL COMMENT '操作人.',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间.',
  PRIMARY KEY (`id`),
  KEY `FK_web_news_type_ref_news` (`web_news_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_news
-- ----------------------------
INSERT INTO web_news VALUES ('1', '新闻1', '新闻副标题1', '0', '<p><span style=\"color:#141414\">&nbsp;&nbsp;&nbsp; 5月5日欧特斯参加了湖北浠水钻石联盟家居展！当天展会聚集了许多市民,，偌大的会场人山人海，座无虚席。欧特斯空气能携全新产品欧特卡丽—亮相，便吸引了众多市民的目光。航天品质加上五一特惠活动，将欧特斯品牌在市场上得到很好的宣传，让更多人从了解、认知、认可欧特斯空气能热水器。 <br/><br/>\r\n			</span></p><p style=\"text-align:center;\">\r\n			<img border=\"0\" src=\"/admin/html/UploadFile/2013510223939692.jpg\"/>\r\n			</p><p>\r\n		</p><p><br/></p>', '1', '20140319223305451.jpg', '1', '1', '1', '1', '1', '1', '2014-02-18 16:11:14');
INSERT INTO web_news VALUES ('2', '新闻2', '新闻副标题2', '0', '<p>新闻内容2</p>', '1', '20140319222643103.jpg', '1', '1', '2', '1', '1', '1', '2014-02-18 16:11:17');
INSERT INTO web_news VALUES ('3', '新闻3', '新闻副标题3', '0', '新闻内容3', '1', '', '1', '1', '3', '1', '1', '1', '2014-02-18 16:46:18');
INSERT INTO web_news VALUES ('4', '新闻4', '新闻副标题4', '0', '新闻内容4', '1', '', '1', '1', '4', '1', '1', '1', '2014-02-18 16:46:20');
INSERT INTO web_news VALUES ('5', '新闻52', '新闻副标题52', '0', '新闻内容5', '1', '', '1', '1', '5', '1', '1', '1', '2014-02-18 16:46:22');
INSERT INTO web_news VALUES ('8', 'SE 汽油机油', ' ', '0', '<p>普遍适用于要求使用SE及以下级别机油的汽油发动机</p><p><img alt=\"SE 汽油机油\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/gasoline_eng_o/pic3fkp5x3e.gif\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\">&nbsp;</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\">&nbsp;<br/><br/>API级别：SE&nbsp;<br/><br/>SAE黏度：30、40、10W-30、15W-40&nbsp;<br/><br/>包装规格：3.5kg/塑桶，3.5kg/铁桶，16kg/塑桶，170kg/钢桶&nbsp;<br/><br/><a href=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/gasoline_eng_o/download/%E8%BD%A6%E7%94%A8%E6%B2%B9%2016.pdf\" style=\"color: rgb(102, 102, 102); text-decoration: none;\">详细资料下载</a>&nbsp;</p><p><br/></p>', '2', '20140325222759626.gif', '4', '1', '11', '1', '1', '1', '2014-03-25 22:28:01');
INSERT INTO web_news VALUES ('9', 'CD柴油机油', ' ', '0', '<p>被东风汽车集团公司认可为装车及服务站用油，是中国重型汽车集团公司装车用油，为斯太尔发动机指定用油，适用于推荐使用CD、CC级别机油的柴油发动机。</p><p><img alt=\"CD柴油机油\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/picy3hg811e.gif\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/></p><p><img border=\"0\" hspace=\"2\" alt=\"\" align=\"right\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/images/picwgeo3j57.gif\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/>API级别：CD&nbsp;<br/><br/>SAE黏度：30、40、50、5W-40、10W-30、15W-40、20W-50&nbsp;<br/><br/>包装规格：3.5kg/塑桶，3.5kg/铁桶，13kg/塑桶，14kg/塑桶，16kg/塑桶，170kg/钢桶&nbsp;<br/><br/><a href=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/download/%E8%BD%A6%E7%94%A8%E6%B2%B9%2025.pdf\" style=\"color: rgb(102, 102, 102); text-decoration: none;\">详细资料下载</a></p><p><br/></p>', '2', '20140325222747178.gif', '4', '1', '13', '1', '1', '1', '2014-03-25 22:27:48');
INSERT INTO web_news VALUES ('10', '尊龙TULUX T600', ' ', '0', '<p>尊龙TULUX T600柴油机油采用抗氧化性能优异的精制高黏度指数基础油复配顶级复合型多功能添加剂调制而成，是当前美国石油学会(API)最高性能的柴油发动机润滑油，可为所有柴油发动机〔包括满足欧IV/欧V排放要求、带有废气再循环（EGR）系统或带有颗粒捕集器（DPF）的柴油发动机〕提供全方位润滑保护。百万公里行车试验证明，该产品具有高水平的抗磨损保护功能，从而有效延长发动机功效和寿命。</p><p><img alt=\"尊龙TULUX T600\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/picr78llh43.png\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\"><strong>性能特点：</strong><br/>1.采用优化配比的顶级清净分散剂，有效分散烟炱及沉积物，控制发动机油泥和活塞环沉积物生成，保持发动机清洁。<br/>2. 热稳定性和氧化安定性能优异，抑制低温油泥和高温沉积物的生成。<br/>3.卓越的抗磨损性能和减摩效果，有效延长发动机寿命。<br/>4.先进的低硫、低磷及低灰分配方，延长各种尾气后处理装置寿命，并提高其功效。<img border=\"0\" alt=\"\" align=\"right\" width=\"116\" height=\"171\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/images/pic58a5agbb.png\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/><br/>5.杰出的酸中和及TBN保持性能，油品抗氧化增稠能力强，换油期超长。<br/>6.超低的蒸发损失，有效降低机油耗。<br/>7. 良好的橡胶相容性，有效保护密封材料，防止泄漏。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\"><strong>技术规格：</strong><br/>■ API CJ-4/CI-4+/CI-4/CH-4/CG-4/CF-4/CF<br/>■ API SM/SL/SJ<br/>■ ACEA E7<br/>■ MB 228.3<br/>■ CAT ECF-3/ECF-2<br/>■ VOLVO VDS-4<br/>■ Cummins 20081<br/>■ MACK EO-O PREMIUM PLUS<br/>■ Detroit Diesel PGOS 93K218<br/>■ MTU Category 2</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\"><br/><strong>执行标准：<br/></strong>■ Q/SH303 554-2010</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\"><strong>应用范围：</strong><br/>■ 适用于所有高级柴油发动机，包括配备废气再循环（EGR）系统或带有颗粒捕集器(DPF)及选择催化转化器（SCR）的新型环保柴油发动机。<br/>■ 适用于满足欧IV/欧V或US2007最新排放标准的现代低排放要求的各种进口或国产高档高速柴油发动机及商用车。<br/>■ 被众多主流OEM厂商认可，特别适用于有多种高端发动机的综合车队。<br/>■ 适用于矿山、建筑、工程机械等低速柴油发动机等，可适应采用高硫燃料的润滑需要。</p><p><br/></p>', '1', '20140325215930072.png', '4', '1', '6', '1', '1', '1', '2014-03-25 22:27:26');
INSERT INTO web_news VALUES ('11', '首页切换大图1', ' ', '0', '<p>1</p>', '2', '1.jpg', '101', '1', '6', '1', '1', '1', '2014-03-25 22:41:24');
INSERT INTO web_news VALUES ('12', '首页切换大图2', null, '0', '<p>1</p>', '2', '2.jpg', '101', '1', '6', '1', '1', null, '2014-03-25 19:31:28');
INSERT INTO web_news VALUES ('13', '首页切换大图3', null, '0', '<p>1</p>', '2', '3.jpg', '101', '1', '6', '1', '1', null, '2014-03-25 19:31:23');
INSERT INTO web_news VALUES ('14', '相伴航天，我们的伙伴', null, '0', '<p>1</p>', '2', '20140325223451117.jpg', '101', '1', '11', '1', '1', null, '2014-03-25 22:35:09');
INSERT INTO web_news VALUES ('39', '“马上升级 如虎添翼”尊龙推广活动全面启动', '', '0', '<p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 2em;\">从3月开始，以“马上升级 如虎添翼”为主题的长城尊龙系列产品推介活动全面推开，该活动覆盖全国，于3-5月期间以推介会为契机，以技术为主导，以服务为推手，向客户广为宣传“科学选油、专业用油”，为车辆设备得到良好润滑提供技术支持。推介活动得到了相关行业客户和终端用户的积极响应。<br/>&nbsp;&nbsp;&nbsp; 3月11日，首场“马上升级 如虎添翼”2014年长城尊龙系列产品推介会在黑龙江省佳木斯市召开，吸引了100余家尊龙终端客户到场参会，仅1个小时尊龙T500以上级别产品的订货量就达数百桶。而在山东曲阜市举办的产品终端推介会则有来自公交、旅游、物流等行业的众多终端客户参加，现场订单量近千件。此后河北的廊坊等地也先后举行了这一推介活动，现场订货同样踊跃。<br/>&nbsp;&nbsp;&nbsp; 自长城尊龙TULUX系列产品推出以来，其产品“油压稳 更强劲”的优异性能已广为人知，推介会通过技术人员现场的深层分析和专业推介，进一步挖掘市场潜力，触发市场经营、应用长城尊龙产品的积极性，将进一步加速长城尊龙TULUX系列产品的市场开拓步伐。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>&nbsp; &nbsp; &nbsp;</p><p><br/></p>', '1', '', '3', '2', '3', '1', null, null, '2014-03-25 22:03:42');
INSERT INTO web_news VALUES ('33', '金吉星JUSTAR J700U', '', '0', '<p><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">为追求完美驾乘体验和引擎极</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">致保护的人群提供绝佳的选择</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">满足保时捷、宝马、奔驰、大众、通用、雷诺等技术要求，可为所有汽油发动机提供全方位润滑保护；适用于采用多气阀、可变气门正时(VVT）、缸内直喷(GDI及FSI及SIDI)、涡轮增压(TSI及TFSI)等新技术发动机及长换油周期的各种豪华轿车。超强品质和性能让您自由应对极端天气和恶劣工况对发动机的考验，让车辆发挥持久澎湃动力。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">SN/CF OW-40 OW-50 5W-30 5W-40</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●采用高品质全合成基础油，自由应对极端天气和恶劣工况对发动机的考验，更长的使用寿命，尤其为带有涡轮增压器的电控直喷发动机提供更持久的安全保护，让车辆发挥持久动力；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●出色的低温启动性能和高温润滑性能，适合各地区全天候使用；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●采用独特的抗磨减摩添加剂，有效减少发动机部件磨损，延长发动机寿命；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●超凡的高温抗氧化性能和清净分散性能，全面抑制积炭和油泥的生成，具有超长的换油周期。</span></p>', '1', '20140324170806967.jpg', '4', '1', '15', '1', null, null, '2014-03-24 17:08:08');
INSERT INTO web_news VALUES ('32', '22222', '', '0', '1', '1', null, null, '1', '0', '1', null, null, null);
INSERT INTO web_news VALUES ('22', '22', '', '0', '1', '1', null, null, '1', '0', '1', null, null, null);
INSERT INTO web_news VALUES ('30', '222', '', '0', '1', '1', null, null, '1', '0', '1', null, null, null);
INSERT INTO web_news VALUES ('31', '2', '', '0', '1', '1', null, null, '1', '0', '1', null, null, null);
INSERT INTO web_news VALUES ('34', '金吉星JUSTAR J700F', '', '0', '<p><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">SN/GF-5 5W-30</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●采用高品质合成基础油，特有环保配方，有效提高燃油经济性，延长三元催化转化装置使用寿命，为带有涡轮增压器的电喷发动机提供更持久的安全保护，让车辆发挥持久动力；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●优异的低温启动性能和高温润滑性能，适合全天候使用；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●卓越的抗磨损性能，有效减少磨损，延长发动机使用寿命；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●出色的高温抗氧化性能和清净分散性能，全面抑制积炭和油泥的生成，有效地延长换油周期。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">SN/CF 5W-40</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●采用高品质合成基础油，为带有涡轮增压器的电喷发动机提供更持久的安全保护，让车辆发挥持久动力；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●优异的低温启动性能和高温润滑性能，适合全天候使用；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●卓越的抗磨损性能，有效减少磨损，延长发动机寿命；</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">●出色的高温抗氧化性能和清净分散性能，全面抑制积炭和油泥的生成，有效地延长换油周期。</span></p>', '1', '20140324171149708.jpg', '4', '2', '5', '1', null, null, '2014-03-24 17:11:50');
INSERT INTO web_news VALUES ('35', '尊龙TULUX T600', '', '0', '<p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>性能特点：</strong><br/>1.采用优化配比的顶级清净分散剂，有效分散烟炱及沉积物，控制发动机油泥和活塞环沉积物生成，保持发动机清洁。<br/>2. 热稳定性和氧化安定性能优异，抑制低温油泥和高温沉积物的生成。<br/>3.卓越的抗磨损性能和减摩效果，有效延长发动机寿命。<br/>4.先进的低硫、低磷及低灰分配方，延长各种尾气后处理装置寿命，并提高其功效。<img border=\"0\" alt=\"\" align=\"right\" width=\"116\" height=\"171\" src=\"http://sinolube.sinopec.com/sinolube/Resource/ImportImage/product/for_business/auto_o/diesel_eng_o/images/pic58a5agbb.png\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/><br/>5.杰出的酸中和及TBN保持性能，油品抗氧化增稠能力强，换油期超长。<br/>6.超低的蒸发损失，有效降低机油耗。<br/>7. 良好的橡胶相容性，有效保护密封材料，防止泄漏。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>技术规格：</strong><br/>■ API CJ-4/CI-4+/CI-4/CH-4/CG-4/CF-4/CF<br/>■ API SM/SL/SJ<br/>■ ACEA E7<br/>■ MB 228.3<br/>■ CAT ECF-3/ECF-2<br/>■ VOLVO VDS-4<br/>■ Cummins 20081<br/>■ MACK EO-O PREMIUM PLUS<br/>■ Detroit Diesel PGOS 93K218<br/>■ MTU Category 2</p><p><br/></p>', '2', '20140324171409737.png', '1012', '1', '5', '1', null, null, '2014-03-24 17:14:11');
INSERT INTO web_news VALUES ('36', '网站上线公告', ' ', '0', '<p><span style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; background-color: rgb(255, 255, 255);\">创一流企业，塑百年品牌！贵阳锦越和能公司将秉承“创造价值”的企业宗旨，坚持在全球范围内推广可再生能源，为全球的消费者提供绿色低碳新体验。</span></p><p><span style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; background-color: rgb(255, 255, 255);\">网站最新上线，敬请关注！</span></p>', '4', '', '8', '2', '11', '1', null, null, '2014-03-25 22:13:51');
INSERT INTO web_news VALUES ('38', '公司简介', '', '0', '<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\"></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\">中国石化润滑油公司是中国石化为适应润滑油市场国际化竞争，按照“统一计划安排、统一资源配置、统一市场开拓、统一品牌形象、统一产品开发”的“五统一”原则于2002年5月29日正式组建的润滑油专业公司，总部位于北京市海淀区安宁庄西路6号。<br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\">公司前身为原石油工业部所属企业，曾为“两弹一星”发射做出积极贡献。上世纪80年代初期，率先推出中国润滑油行业的第一个品牌—“长城”，以航天润滑科技为独特个性，支持中国制造业发展，服务社会大众。公司成立后，传承和发扬自主创新精神，研发航天润滑核心科技，为“神舟”系列载人飞船和“嫦娥”系列探月卫星的成功发射提供润滑保障，是目前唯一的“中国航天事业战略合作伙伴”。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;<span style=\"font-size:12px\">公司下设12个生产基地、5个区域销售中心、5个区域技术支持中心和5个省级销售分公司、3个合资公司、1个海外子公司和9个海外办事处。拥有4个产品研发机构，12个国家认可实验室，具备领先的创新研发能力和世界一流的生产设备和工艺技术，产品涵盖内燃机润滑油、工业齿轮油、液压油、润滑脂、防冻液、刹车液、金属加工液、船用油及润滑油添加剂等21大类2000多个品种，广泛应用于航空航天、汽车、机械、冶金、矿采、石油化工、电子等领域，质量达到国际标准组织（ISO）、美国石油学会（API）、欧洲汽车制造商协会（ACEA）等标准的要求。<br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\">公司以“高科技、高品质、国际化”为品牌发展目标，境内推广“长城”品牌，境外推广“SINOPEC”品牌。长城润滑油多年保持国内润滑油行</span><span style=\"font-size:12px\">业第一品牌位置，品牌价值在行业内居领先地位。公司以“SINOPEC”品牌推进国际市场开发，已在东南亚、澳洲、欧洲、南美洲、非洲等50多个国家和地区设有经销网络；在新加坡、阿联酋、美国和南非等国家的主要港口设有船用油供应网点。2013年7月，位于新加坡裕廊工业区的润滑油脂生产基地正式投产，实现了产品和技术的同步输出。<br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\">公司建立了以满足顾客需要为核心的企业经营理念，通过ISO/TS16949及HSE管理体系认证；致力于发展润滑油事业，积极参与国际化竞争，以建设世界一流润滑油公司为目标，努力寻求与相关行业建立长期合作伙伴关系，共同发展和进步。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:12px\"><br/></span><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><p><br/></p>', '4', '', '2', '1', '43', '1', null, null, '2014-03-26 10:37:58');
INSERT INTO web_news VALUES ('40', '“长城”攻关项目获石化科技进步一等奖', '', '0', '<p>\r\n    <span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">长城润滑油组织研发的“自主技术高档内燃机油开发和在汽车行业应用推广及配套基础油研究”项目，为中国石化“十条龙”攻关项目。3月20日，该项目获得了2013年度中国石化科技进步一等奖。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 自2008年项目启动以来，长城润滑油科技团队群策群力，使项目于2012年顺利“出龙”。该项目完成了4个质量级别、7个黏度牌号内燃机油自主开发及工业应用的攻关目标。还超额完成了自主技术添加剂在7个黏度牌号的推广应用。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 该项目自主技术实现了全面工业化。目前，自主技术生产的高档内燃机油质量稳定，性能优良。开发的产品在众多汽车、工程机械企业得到推广应用。</span>\r\n</p>', '1', '', '3', '2', '2', '1', null, null, '2014-03-25 22:04:43');
INSERT INTO web_news VALUES ('41', '亚非地区引领世界润滑油需求持续增长', '', '0', '<p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">据德国福斯润滑油公司(Fuchs Petrolub)最新公布数据称，2013年全球润滑油需求量为3530万吨，表明全球润滑油需求基本持平，但各地区表现差异较大。中国2013年润滑油需求量超过600万吨已成为世界上最大消费国，但中国润滑油人均消费量还不足4千克表明中国市场需求增长仍存在巨大潜力。福斯润滑油的全球竞争情报负责人和首席环保长Apu Gosalia先生在出席伦敦《ICIS世界基础油和润滑油会议》作主题演讲时，报告了2013全球润滑油需求以及各国家和公司的排名情况。自2000年以来，全球各地区润滑油需求情况发生了很大变化，2000年全球润滑油需求量(不包括海洋用油)达到3640万吨，13年来，亚太地区占总需求的份额由29%猛增至42%，而北美所占份额则从26%降至19%，欧洲的份额也从27%下滑到20%。13年来，壳牌公司已成为世界上最大的润滑油制造商，排在第二位的是埃克森美孚。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; “全球润滑油需求与GDP增长趋势相同，但增速偏低” Gosalia先生表示。2012至2013年全球GDP增长了3%，而全球润滑油需求仅小幅上升0.9%。按地区来看，2012年至2013年润滑剂需求增长情况：北美为0%、拉丁美洲1.7%，西欧-0.6%、东欧0.9%、中东1.5%、非洲0.9、亚太地区1.4%。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; “从年人均消费量来看，亚洲和非洲润滑油增长潜力较大，” Gosalia指出。世界年人均润滑油消耗约5千克，但地区差异非常显著。北美2013年消费量超过18千克。而亚太地区人均消费不足4千克，非洲仅仅2千克。西欧人均消耗约9千克，东欧和中东人均消耗接近8千克，拉丁美洲人均消费量也刚刚超过5千克。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 据统计，世界上最大20个润滑油消费国消费量之和已占到全球润滑油需求的75%，” Gosalia称。中国2013年润滑油需求突破600万吨已成为世界第一大市场，美国位居第二，其消费量略低于600万吨。印度已成为第三大消费国，2013年总计消耗量约150万吨，接下来是俄罗斯、日本、巴西、德国、韩国、墨西哥和伊朗。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 按润滑油产品应用行业来分，全球润滑油需求的56%是汽车，而工业润滑油 占到总量的44%。同样，不同地区不同行业润滑油消费情况差异也非常明显，如在北美汽车需求约占需求的58%，在拉丁美洲汽车需求占到71%，西欧则为44%，东欧为57%，中东占76%，非洲51%，而亚太地区则为64%。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 近几十年世界润滑油行业的竞争格局也在显著改变，Gosalia指出。20世纪90年代中期，年产量在1000吨的独立润滑油制造商大约有1,500家，大约有200家大公司。到2005年，独立润滑油制造商的数量缩减至590家，专业润滑油大公司也只有130家。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; Gosalia预测说，预计2014年全球GDP将增长3.7%，但润滑油需求增速约为1%至1.5%。</p><p><br/></p>', '4', '', '7', '2', '5', '1', null, null, '2014-03-25 22:10:55');
INSERT INTO web_news VALUES ('42', '中国工程机械未来发展趋势分析', '', '0', '<p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">据德国福斯润滑油公司(Fuchs Petrolub)最新公布数据称，2013年全球润滑油需求量为3530万吨，表明全球润滑油需求基本持平，但各地区表现差异较大。中国2013年润滑油需求量超过600万吨已成为世界上最大消费国，但中国润滑油人均消费量还不足4千克表明中国市场需求增长仍存在巨大潜力。福斯润滑油的全球竞争情报负责人和首席环保长Apu Gosalia先生在出席伦敦《ICIS世界基础油和润滑油会议》作主题演讲时，报告了2013全球润滑油需求以及各国家和公司的排名情况。自2000年以来，全球各地区润滑油需求情况发生了很大变化，2000年全球润滑油需求量(不包括海洋用油)达到3640万吨，13年来，亚太地区占总需求的份额由29%猛增至42%，而北美所占份额则从26%降至19%，欧洲的份额也从27%下滑到20%。13年来，壳牌公司已成为世界上最大的润滑油制造商，排在第二位的是埃克森美孚。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; “全球润滑油需求与GDP增长趋势相同，但增速偏低” Gosalia先生表示。2012至2013年全球GDP增长了3%，而全球润滑油需求仅小幅上升0.9%。按地区来看，2012年至2013年润滑剂需求增长情况：北美为0%、拉丁美洲1.7%，西欧-0.6%、东欧0.9%、中东1.5%、非洲0.9、亚太地区1.4%。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; “从年人均消费量来看，亚洲和非洲润滑油增长潜力较大，” Gosalia指出。世界年人均润滑油消耗约5千克，但地区差异非常显著。北美2013年消费量超过18千克。而亚太地区人均消费不足4千克，非洲仅仅2千克。西欧人均消耗约9千克，东欧和中东人均消耗接近8千克，拉丁美洲人均消费量也刚刚超过5千克。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 据统计，世界上最大20个润滑油消费国消费量之和已占到全球润滑油需求的75%，” Gosalia称。中国2013年润滑油需求突破600万吨已成为世界第一大市场，美国位居第二，其消费量略低于600万吨。印度已成为第三大消费国，2013年总计消耗量约150万吨，接下来是俄罗斯、日本、巴西、德国、韩国、墨西哥和伊朗。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 按润滑油产品应用行业来分，全球润滑油需求的56%是汽车，而工业润滑油 占到总量的44%。同样，不同地区不同行业润滑油消费情况差异也非常明显，如在北美汽车需求约占需求的58%，在拉丁美洲汽车需求占到71%，西欧则为44%，东欧为57%，中东占76%，非洲51%，而亚太地区则为64%。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; 近几十年世界润滑油行业的竞争格局也在显著改变，Gosalia指出。20世纪90年代中期，年产量在1000吨的独立润滑油制造商大约有1,500家，大约有200家大公司。到2005年，独立润滑油制造商的数量缩减至590家，专业润滑油大公司也只有130家。</p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp; Gosalia预测说，预计2014年全球GDP将增长3.7%，但润滑油需求增速约为1%至1.5%。</p><p><br/></p>', '4', '', '7', '1', '2', '1', null, null, '2014-03-25 22:11:58');
INSERT INTO web_news VALUES ('43', '服务与支持', '', '0', '<h1 style=\"margin: 0px 0px 20px; padding: 0px; font-size: 18px; line-height: 36px; color: rgb(94, 157, 172); width: 670px; border-bottom-width: 1px; border-bottom-style: dashed; border-bottom-color: rgb(238, 238, 238); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>客服中心</strong></h1><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"><tbody><tr class=\"firstRow\"><td align=\"left\"><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;&nbsp;&nbsp;<img src=\"http://sinolube.sinopec.com/sinolube/Resource/Image/pic_c_service_center_display01.jpg\" border=\"0\" alt=\"\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/>　</p><p style=\"line-height: 24px; text-indent: 2em;\"><span style=\"color:#ff0000;font-size:16px\"><span style=\"color:#373737\">　　</span><strong>您好！这里是长城润滑油客户服务中心！很高兴为您服务！</strong></span></p><p style=\"text-align:left;line-height: 24px; text-indent: 2em;\">&nbsp;　　<strong><span style=\"color:#000000;font-size:16px\">我们的职责：</span></strong></p><p style=\"text-align:left;line-height: 24px; text-indent: 2em;\">&nbsp;</p>● 真诚对待您的建议和投诉● 为您提供更多的油品选择及使用的专业建议● 为您推荐值得信赖的长城润滑油专售点● 为您提供售后问题的解决途径和办法<p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p><p style=\"line-height: 24px; text-indent: 2em;\"><span style=\"color:#0000ff;font-size:16px\"><strong>　　<span style=\"color:#000000\">联系我们:</span></strong></span></p><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p>&nbsp;全国服务热线：400-810-9886，800-810-9886&nbsp;<span style=\"font-size:16px\">　　咨询电话，全国统一，免除了在不同地区记忆不同电话号码的烦恼。无论您身在何处，长城春风服务伴您左右。</span><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p>&nbsp;长城润滑油网站：http://www.sinolube.com<span style=\"font-size:16px\">　　长城润滑油网站借助网络优势，及时发布最丰富信息，并充分考虑到客户的服务需求，整合相关信息资料，按照客户习惯进行设计，产品展示、常见问答、车辆养护、选油DIY、工业润滑以及应用案例等栏目，鼠标一点，润滑无忧。</span><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p>&nbsp;短信平台：1065-7500-9886<span style=\"font-size:16px\">　　温馨提示、促销通知、新产品信息、节日问候，随时随地及时轻松到达您的身边。&nbsp;<br/><br/></span><span style=\"font-size:16px\"><strong><span style=\"color:#0000ff\">　　</span><span style=\"color:#000000\">在线沟通：</span></strong></span><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p><p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p>&nbsp;MSN：csc@sinolube.com&nbsp;QQ：100-70-9886 / 100-42-9886/200-77-9886&nbsp;微博：长城润滑油旗舰店&nbsp;t.sina.com.cn/sinolube<p style=\"line-height: 24px; text-indent: 2em;\">&nbsp;</p><p style=\"line-height: 24px; text-indent: 2em;\"><span style=\"font-size:16px\">　　覆盖面广、快捷的网络沟通方式，方便不同使用习惯的客户。&nbsp;<br/><br/><strong><span style=\"color:#0000ff\">　　</span><span style=\"color:#000000\">服务支撑</span></strong><br/>覆盖全国网络的长城润滑油服务体系，四个研发中心、五大销售中心、五大技服中心的人员作为强有力的技术服务支持后盾，当客户在销售、使用油品过程中出现问题时，五大销售中心人员均将在第一时间现场服务。&nbsp;<br/><br/></span><span style=\"font-size:16px\"><strong><span style=\"color:#0000ff\">　　</span><span style=\"color:#000000\">长城润滑油淘宝旗舰店&nbsp;<br/></span></strong>　　基于互联网的网络润滑油营销业务是独立于传统渠道的全新销售渠道，搭建了公司直接面对客户的销售平台，经济、便捷、迅速的购物方式符合人们低碳高效的生活节奏，弥补了现有渠道无法覆盖的范围。让您尽享轻松、低碳的网购生活。网址：</span><a href=\"http://sinolube.taobao.com/\" style=\"color: rgb(102, 102, 102); text-decoration: none;\"><span style=\"font-size:16px\">http://sinolube.taobao.com/</span></a><span style=\"font-size:16px\"></span></p><p style=\"line-height: 24px; text-indent: 2em;\"><span style=\"font-size:16px\"><strong><span style=\"color:#0000ff\">　　</span><span style=\"color:#000000\">服务时间:<br/></span></strong>网站：24小时自助服务<br/>热线：13小时人工服务&nbsp; 8:00—21:00<br/>在线：MSN、QQ: 8:00—21:00<br/>淘宝旺旺：8:00—21:00（周一至周五） 9:00—18:00（周六日及节假日）</span></p><br/><p style=\"text-align:center;line-height: 24px; text-indent: 2em;\"><img src=\"http://sinolube.sinopec.com/sinolube/Resource/Image/pic_c_service_center_display08.jpg\" border=\"0\" alt=\"\" style=\"border: none; -webkit-tap-highlight-color: transparent;\"/>&nbsp;</p></td></tr></tbody></table><p><br/></p>', '4', '', '6', '2', '23', '1', null, null, '2014-03-26 09:34:32');
INSERT INTO web_news VALUES ('44', '润滑油清净分散性的作用', '', '0', '<p><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">在润滑油的使用过程中，会有一些因燃料燃烧而生成的炭粒、烟尘进入其中，还有一些空气中的灰尘也会进入油中，再加上润滑油自身的高温氧化产生的一些酸性物质，长期下去，这些物质就会生成积炭、油泥堵塞润滑油路，造成机械润滑失败。而抑制积炭、油泥的能力取决于润滑油中清净分散剂的质量和配比量。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">　　润滑油的清净分散性是润滑油重要指标之一，它能把发动机内部的积炭等污物清洗下来，并均匀地分布在油中，抑制减少沉积物的生成，使发动机内部清洁。另外，清净分散剂还能中和油中的酸性物质。清净分散剂的作用概括起来就是洗涤、分散、增溶、中和四点。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">　　长城尊龙TULUX柴油机油，所特有的聚能强护因子这一核心技术，赋予了产品“超强耐磨、清净防腐和高低温保护”三大核心功能，能有效保持发动机内部清洁，让大马力柴油发动机油压更稳，动力更强劲，排放更环保。</span></p>', '4', '', '5', '2', '4', '1', null, null, '2014-03-25 22:20:42');
INSERT INTO web_news VALUES ('45', '润滑脂的组成和作用', '', '0', '<p><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">在润滑油的使用过程中，会有一些因燃料燃烧而生成的炭粒、烟尘进入其中，还有一些空气中的灰尘也会进入油中，再加上润滑油自身的高温氧化产生的一些酸性物质，长期下去，这些物质就会生成积炭、油泥堵塞润滑油路，造成机械润滑失败。而抑制积炭、油泥的能力取决于润滑油中清净分散剂的质量和配比量。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">　　润滑油的清净分散性是润滑油重要指标之一，它能把发动机内部的积炭等污物清洗下来，并均匀地分布在油中，抑制减少沉积物的生成，使发动机内部清洁。另外，清净分散剂还能中和油中的酸性物质。清净分散剂的作用概括起来就是洗涤、分散、增溶、中和四点。</span><br style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; white-space: normal; background-color: rgb(255, 255, 255);\"/><span style=\"color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; line-height: 24px; background-color: rgb(255, 255, 255);\">　　长城尊龙TULUX柴油机油，所特有的聚能强护因子这一核心技术，赋予了产品“超强耐磨、清净防腐和高低温保护”三大核心功能，能有效保持发动机内部清洁，让大马力柴油发动机油压更稳，动力更强劲，排放更环保。</span></p>', '4', '', '5', '2', '3', '1', null, null, '2014-03-25 22:20:57');
INSERT INTO web_news VALUES ('46', '如何自换防冻液', '', '0', '<p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">选对了合适的防冻液，如果车友打算自己更换，需要注意一些问题。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 1.车友首先要注意选在车辆发动机完全冷却的环境下进行更换防冻液。切勿在发动机处于高温的状态下更换</span><span style=\"font-size:18px\">防冻液。一来会有烫伤的风险；二来在“热车”时放掉防冻液也会影响到车辆的降温效果。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 2.防冻液产品因为不同品牌的性能指数有所差异，所以不能混加。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 3.更换不同品牌的防冻液，需要将原车的防冻液完全放完之后，对冷却系统进行冲洗。其常用方法是用一根</span><span style=\"font-size:18px\">橡胶软管插入储液罐并源源不断地注入清水，同时放水口保持开启，让清水从底部顺畅地流出，在冲洗的过程中</span><span style=\"font-size:18px\">还需短暂发动车辆大3~5分钟，并打开暖风，必须让清水循环起来。这样做的目的是使得车内的旧防冻液能全部流</span><span style=\"font-size:18px\">出。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 4.通过出水口处水的颜色来判断冷却系统是否清洗干净了。混杂了旧防冻液的水颜色应该为淡粉色或者淡蓝</span><span style=\"font-size:18px\">色，如果流出的水变成了无色清水，这就说明你的冲洗工作完成了。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 5.加注新防冻液时，可以直接向储液罐中倒入大约3.5L（视车型而定）的防冻液，副水壶液面高度到达上限</span><span style=\"font-size:18px\">MAX位置后停止加注。此时拧下“上水管”旁的放水螺丝，并继续开始加注防冻液，看到防冻液从该放水螺丝中源</span><span style=\"font-size:18px\">源不断地涌出且不夹杂气泡后，再将放水螺丝拧紧。这样才能既加满防冻液又排净冷却系统中的空气。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 6.加完防冻液后，车友还需启动车辆在怠速的状态下让车辆进入正常工作温度，并且使新换上的防冻液能在</span><span style=\"font-size:18px\">车内水道中充分循环。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 7.3-5分钟以后关闭发动机，打开储液罐会发现液面高度有所降低，这时只需要再添加适量的防冻液使其液面</span><span style=\"font-size:18px\">保持在MAX和MIN之间即可。</span></p><p style=\"margin-top: 19px; margin-bottom: 19px; padding: 0px; line-height: 24px; color: rgb(139, 139, 139); font-family: 宋体, &#39;Microsoft Yahei UI&#39;, &#39;Microsoft Yahei&#39;, 微软雅黑, SimSun, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:18px\">&nbsp;&nbsp;&nbsp; 长城润滑油技术专家温馨提示：不管采取直接更换还是冲洗后更换防冻液，都不能保证车辆冷却系统100%冲</span><span style=\"font-size:18px\">洗干净。不过，车友也不用为此担心会削弱新防冻液的“防冻”能力。因为可以通过选择更低冰点的防冻液产品</span><span style=\"font-size:18px\">来预防这一风险。</span></p><p><br/></p>', '4', '', '5', '2', '2', '1', null, null, '2014-03-25 22:21:28');
INSERT INTO web_news VALUES ('47', '联系我们', '', '0', '<p style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"font-size:24px;font-family:隶书\"><strong>贵州锦越和能源有限公司</strong></span></p><p style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">联系电话：0851-xxxxxxx<br/>维修电话：0851<span style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; background-color: rgb(255, 255, 255);\">-xxxxxxx</span></p><p style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">email：xxxxxxxxxx@163.com</p><p style=\"color: rgb(98, 94, 93); font-family: Arial, ����, Helvetica, sans-serif; font-size: 12px; line-height: 22px; white-space: normal; background-color: rgb(255, 255, 255);\">专卖店地址：贵阳市xxxxxxxxxxxxxxxxxxxxxxxx<br/>办公室地址：贵阳市云岩区xxxxxxxxxxxxxxxx05号</p><p><br/></p>', '4', '', '9', '2', '17', '1', null, null, '2014-03-26 09:37:45');

-- ----------------------------
-- Table structure for `web_news_type`
-- ----------------------------
DROP TABLE IF EXISTS `web_news_type`;
CREATE TABLE `web_news_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `is_preview_img` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  `type_order` int(11) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态.',
  `operate_user_id` int(11) DEFAULT NULL COMMENT '操作人.',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间.',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_news_type
-- ----------------------------
INSERT INTO web_news_type VALUES ('1', '内容类', '1', '0', null, '', null, '100', '1', '2014-02-18 14:40:09');
INSERT INTO web_news_type VALUES ('3', '新闻动态', '1', '1', '3', 'web/newslist.htm?webNewsTypeId=3', null, '100', '1', '2014-02-18 14:40:28');
INSERT INTO web_news_type VALUES ('4', '产品与应用', '2', '1', '4', 'web/newslist.htm?webNewsTypeId=4', null, '100', '1', '2014-02-18 16:47:46');
INSERT INTO web_news_type VALUES ('5', '常见问题', '1', '1', '5', 'web/newslist.htm?webNewsTypeId=5', null, null, null, null);
INSERT INTO web_news_type VALUES ('6', '服务与支持', '1', '1', '6', 'web/newsdetail.htm?id=43', null, null, null, null);
INSERT INTO web_news_type VALUES ('7', '资讯中心', '1', '1', '7', 'web/newslist.htm?webNewsTypeId=7', null, null, null, null);
INSERT INTO web_news_type VALUES ('8', '在线公告', '1', '1', '8', 'web/newslist.htm?webNewsTypeId=8', null, null, null, null);
INSERT INTO web_news_type VALUES ('9', '联系我们', '1', '6', '9', 'web/newsdetail.htm?id=47', null, null, null, null);
INSERT INTO web_news_type VALUES ('100', '广告类', '2', '0', null, null, null, null, null, null);
INSERT INTO web_news_type VALUES ('101', '焦点广告', '1', '100', null, null, null, null, null, null);
INSERT INTO web_news_type VALUES ('2', '企业介绍', '1', '1', '2', 'web/newsdetail.htm?id=38', null, '100', null, null);
INSERT INTO web_news_type VALUES ('1012', '汽车润滑油', '2', '4', null, null, null, '100', null, null);
INSERT INTO web_news_type VALUES ('1013', '工业润滑油', '2', '4', null, null, null, '100', null, null);
INSERT INTO web_news_type VALUES ('10', '首页', '1', '1', '1', 'web/index.htm', null, null, null, null);
