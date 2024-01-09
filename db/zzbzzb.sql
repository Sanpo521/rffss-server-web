/*
 Navicat Premium Data Transfer

 Source Server         : mysql.sqlpub.com
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : mysql.sqlpub.com:3306
 Source Schema         : zzbzzb

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 09/01/2024 09:56:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code_addiv
-- ----------------------------
DROP TABLE IF EXISTS `code_addiv`;
CREATE TABLE `code_addiv`  (
  `code` varchar(10) NOT NULL COMMENT '行政区划',
  `name` varchar(30) NOT NULL COMMENT '行政名称',
  `parent` varchar(10) NOT NULL COMMENT '父级行政区划',
  `level` varchar(1) NULL DEFAULT NULL COMMENT '行政级别：1为省，2为市，3为区县，4为乡镇、社区、街道',
  `enabled` tinyint(1) NULL DEFAULT NULL COMMENT '是否可用 1可用，0不可用',
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_addiv
-- ----------------------------
INSERT INTO `code_addiv` VALUES ('230000', '黑龙江省', '000000', '1', 1);
INSERT INTO `code_addiv` VALUES ('230100', '哈尔滨市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230102', '道里区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230103', '南岗区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230104', '道外区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230108', '平房区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230109', '松北区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230110', '香坊区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230111', '呼兰区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230112', '阿城区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230113', '双城区', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230123', '依兰县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230124', '方正县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230125', '宾县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230126', '巴彦县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230127', '木兰县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230128', '通河县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230129', '延寿县', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230183', '尚志市', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230184', '五常市', '230100', '3', 1);
INSERT INTO `code_addiv` VALUES ('230200', '齐齐哈尔市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230202', '龙沙区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230203', '建华区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230204', '铁锋区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230205', '昂昂溪区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230206', '富拉尔基区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230207', '碾子山区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230208', '梅里斯达斡尔族区', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230221', '龙江县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230223', '依安县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230224', '泰来县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230225', '甘南县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230227', '富裕县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230229', '克山县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230230', '克东县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230231', '拜泉县', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230281', '讷河市', '230200', '3', 1);
INSERT INTO `code_addiv` VALUES ('230300', '鸡西市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230302', '鸡冠区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230303', '恒山区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230304', '滴道区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230305', '梨树区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230306', '城子河区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230307', '麻山区', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230321', '鸡东县', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230381', '虎林市', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230382', '密山市', '230300', '3', 1);
INSERT INTO `code_addiv` VALUES ('230400', '鹤岗市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230402', '向阳区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230403', '工农区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230404', '南山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230405', '兴安区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230406', '东山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230407', '兴山区', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230421', '萝北县', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230422', '绥滨县', '230400', '3', 1);
INSERT INTO `code_addiv` VALUES ('230500', '双鸭山市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230502', '尖山区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230503', '岭东区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230505', '四方台区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230506', '宝山区', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230521', '集贤县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230522', '友谊县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230523', '宝清县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230524', '饶河县', '230500', '3', 1);
INSERT INTO `code_addiv` VALUES ('230600', '大庆市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230602', '萨尔图区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230603', '龙凤区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230604', '让胡路区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230605', '红岗区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230606', '大同区', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230621', '肇州县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230622', '肇源县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230623', '林甸县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230624', '杜尔伯特蒙古族自治县', '230600', '3', 1);
INSERT INTO `code_addiv` VALUES ('230700', '伊春市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230717', '伊美区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230718', '乌翠区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230719', '友好区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230722', '嘉荫县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230723', '汤旺县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230724', '丰林县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230725', '大箐山县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230726', '南岔县', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230751', '金林区', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230781', '铁力市', '230700', '3', 1);
INSERT INTO `code_addiv` VALUES ('230800', '佳木斯市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230803', '向阳区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230804', '前进区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230805', '东风区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230811', '郊区', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230822', '桦南县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230826', '桦川县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230828', '汤原县', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230881', '同江市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230882', '富锦市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230883', '抚远市', '230800', '3', 1);
INSERT INTO `code_addiv` VALUES ('230900', '七台河市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('230902', '新兴区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230903', '桃山区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230904', '茄子河区', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('230921', '勃利县', '230900', '3', 1);
INSERT INTO `code_addiv` VALUES ('231000', '牡丹江市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231002', '东安区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231003', '阳明区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231004', '爱民区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231005', '西安区', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231025', '林口县', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231081', '绥芬河市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231083', '海林市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231084', '宁安市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231085', '穆棱市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231086', '东宁市', '231000', '3', 1);
INSERT INTO `code_addiv` VALUES ('231100', '黑河市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231102', '爱辉区', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231123', '逊克县', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231124', '孙吴县', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231181', '北安市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231182', '五大连池市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231183', '嫩江市', '231100', '3', 1);
INSERT INTO `code_addiv` VALUES ('231200', '绥化市', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('231202', '北林区', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231221', '望奎县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231222', '兰西县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231223', '青冈县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231224', '庆安县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231225', '明水县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231226', '绥棱县', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231281', '安达市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231282', '肇东市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('231283', '海伦市', '231200', '3', 1);
INSERT INTO `code_addiv` VALUES ('232700', '大兴安岭地区', '230000', '2', 1);
INSERT INTO `code_addiv` VALUES ('232701', '漠河市', '232700', '3', 1);
INSERT INTO `code_addiv` VALUES ('232721', '呼玛县', '232700', '3', 1);
INSERT INTO `code_addiv` VALUES ('232722', '塔河县', '232700', '3', 1);

-- ----------------------------
-- Table structure for code_organ
-- ----------------------------
DROP TABLE IF EXISTS `code_organ`;
CREATE TABLE `code_organ`  (
  `code` varchar(10) NOT NULL COMMENT '代码',
  `name` varchar(300) NOT NULL COMMENT '机构名称',
  `areacode` varchar(6) NOT NULL COMMENT '行政区划',
  `sealid` varchar(100) NULL DEFAULT NULL COMMENT '电子印章编号',
  `uniscid` varchar(25) NOT NULL COMMENT '机构代码',
  `enabled` tinyint(1) NOT NULL COMMENT '是否可用 1可用，0不可用',
  `datasource` varchar(3) NULL DEFAULT NULL COMMENT '数据源',
  `parentcode` varchar(10) NULL DEFAULT NULL COMMENT '父级代码',
  PRIMARY KEY (`code`) USING BTREE,
  INDEX `idx_code_organ_areacode`(`areacode`) USING BTREE
) ENGINE = InnoDB COMMENT = '登记机关代码表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_organ
-- ----------------------------
INSERT INTO `code_organ` VALUES ('230000', '黑龙江省市场监督管理局', '230000', '23000000005997', '', 1, NULL, '000000');
INSERT INTO `code_organ` VALUES ('230100', '哈尔滨市市场监督管理局', '230100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230102', '哈尔滨市道里区市场监督管理局', '230102', '123', '123', 1, NULL, '230100');
INSERT INTO `code_organ` VALUES ('230103', '哈尔滨市南岗区市场监督管理局', '230103', '123', '123', 1, NULL, '230100');
INSERT INTO `code_organ` VALUES ('230200', '齐齐哈尔市市场监督管理局', '230200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230201', '齐齐哈尔市龙华区市场监督管理局', '230202', '123', '123', 1, NULL, '230200');
INSERT INTO `code_organ` VALUES ('230300', '鸡西市市场监督管理局', '230300', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230302', '鸡西市鸡东区市场监督管理局', '230302', '123', '123', 1, NULL, '230300');
INSERT INTO `code_organ` VALUES ('230400', '鹤岗市市场监督管理局', '230400', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230500', '双鸭山市市场监督管理局', '230500', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230600', '大庆市市场监督管理局', '230600', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230700', '伊春市市场监督管理局', '230700', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230800', '佳木斯市市场监督管理局', '230800', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('230900', '七台河市市场监督管理局', '230900', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231000', '牡丹江市市场监督管理局', '231000', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231100', '黑河市市场监督管理局', '231100', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('231200', '绥化市市场监督管理局', '231200', '23000000005997', '', 1, NULL, '230000');
INSERT INTO `code_organ` VALUES ('232700', '大兴安岭地区市场监督管理局', '232700', '23000000005997', '', 1, NULL, '230000');

-- ----------------------------
-- Table structure for gy_bioepqasm
-- ----------------------------
DROP TABLE IF EXISTS `gy_bioepqasm`;
CREATE TABLE `gy_bioepqasm`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `quality_and_safety_officer` varchar(20) NULL DEFAULT NULL COMMENT '质量安全员',
  `id_number` varchar(18) NULL DEFAULT NULL COMMENT '身份证号',
  `training_time` timestamp(0) NULL DEFAULT NULL COMMENT '参加培训时间',
  `duration_of_employment` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '任职时间',
  `phone` varchar(11) NULL DEFAULT NULL COMMENT '联系电话',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430713263730689 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_bioepqasm
-- ----------------------------
INSERT INTO `gy_bioepqasm` VALUES (1717081092783996930, '', '', '2023-10-24 11:06:18', '2023-10-24 11:06:18', '', '1717081090993029122', '2023-10-25 15:30:09', '2023-10-25 15:30:09');
INSERT INTO `gy_bioepqasm` VALUES (1717367365117652994, '111', '11111', '2023-10-18 00:00:00', '2023-10-17 00:00:00', '1111111', '1717367363809030145', '2023-10-26 10:27:42', '2023-10-26 10:27:42');
INSERT INTO `gy_bioepqasm` VALUES (1717429092358172674, '321', '321', '2023-10-19 00:00:00', '2023-10-17 00:00:00', '321', '1717429091871633410', '2023-10-26 14:32:59', '2023-10-26 14:32:59');
INSERT INTO `gy_bioepqasm` VALUES (1717430099259568130, '321', '321', '2023-10-19 00:00:00', '2023-10-17 00:00:00', '321', '1717430098814971906', '2023-10-26 14:36:59', '2023-10-26 14:36:59');
INSERT INTO `gy_bioepqasm` VALUES (1717430300493885442, '321', '321', '2023-10-19 00:00:00', '2023-10-17 00:00:00', '321', '1717430300040900609', '2023-10-26 14:37:47', '2023-10-26 14:37:47');
INSERT INTO `gy_bioepqasm` VALUES (1717430713263730689, '321', '321', '2023-10-19 00:00:00', '2023-10-17 00:00:00', '321', '1717430712835911682', '2023-10-26 14:39:25', '2023-10-26 14:39:25');

-- ----------------------------
-- Table structure for gy_bioer
-- ----------------------------
DROP TABLE IF EXISTS `gy_bioer`;
CREATE TABLE `gy_bioer`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL DEFAULT NULL COMMENT '企业名称',
  `production_unit` varchar(255) NULL DEFAULT NULL COMMENT '生产单位(0否 1是)',
  `sales_unit` varchar(255) NULL DEFAULT NULL COMMENT '销售单位(0否 1是)',
  `unified_social_credit_code` bigint(0) NULL DEFAULT NULL COMMENT '统一社会信用代码',
  `address` varchar(255) NULL DEFAULT NULL COMMENT '企业注册地址',
  `product_address` varchar(255) NULL DEFAULT NULL COMMENT '企业生产经营地址',
  `legal_representative` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人',
  `production_and_business_scope` varchar(255) NULL DEFAULT NULL COMMENT '生产经营范围',
  `province` varchar(255) NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) NULL DEFAULT NULL COMMENT '市',
  `distinguish` varchar(255) NULL DEFAULT NULL COMMENT '区',
  `cityregistration_authority` varchar(500) NULL DEFAULT NULL COMMENT '登记机关',
  `category_of_enterprise_quality_and_safety_management` varchar(255) NULL DEFAULT NULL COMMENT '企业质量安全管理类别',
  `id_number` varchar(255) NULL DEFAULT NULL COMMENT '身份证号',
  `duration_of_employment` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '任职时间',
  `phone` varchar(255) NULL DEFAULT NULL COMMENT '联系电话',
  `reason_for_storage` varchar(255) NULL DEFAULT NULL COMMENT '入库原因',
  `reason_for_storage_code` varchar(255) NULL DEFAULT NULL COMMENT '入库原因code',
  `implementation_of_two_regulations` varchar(255) NULL DEFAULT NULL COMMENT '两个规定落实情况',
  `implementation_of_two_regulations_code` varchar(255) NULL DEFAULT NULL COMMENT '两个规定落实情况code',
  `regulatory_level` varchar(255) NULL DEFAULT NULL COMMENT '监管级别',
  `regulatory_level_code` varchar(255) NULL DEFAULT NULL COMMENT '监管级别code',
  `risk_level` varchar(255) NULL DEFAULT NULL COMMENT '风险等级',
  `risk_level_code` varchar(255) NULL DEFAULT NULL COMMENT '风险等级code',
  `regulatory_measures` varchar(255) NULL DEFAULT NULL COMMENT '监管措施',
  `regulatory_measures_code` varchar(255) NULL DEFAULT NULL COMMENT '监管措施code',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `legal_representative_two` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人（与注册信息保持一样）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430712835911682 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_bioer
-- ----------------------------
INSERT INTO `gy_bioer` VALUES (1, '士大夫', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-10-24 11:32:04', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-10-24 11:32:04', '2023-10-24 11:32:04', NULL);
INSERT INTO `gy_bioer` VALUES (2, '地方撒', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-10-24 11:32:12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-10-24 11:32:12', '2023-10-24 11:32:12', NULL);
INSERT INTO `gy_bioer` VALUES (1717081090993029122, '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '2023-10-24 11:06:18', '', '', '', '', '', '', '', '', '', '', '', '2023-10-25 15:30:09', '2023-10-25 15:30:09', NULL);
INSERT INTO `gy_bioer` VALUES (1717367363809030145, '企业名称', '1', '1', 111111, '1111', '111', '111', '111', '230000', '230100', '230103', '伊春市市场监督管理局', 'A', '1111', '2023-10-26 00:00:00', '11111', '强制性标准', '3', '已落实', '2', '市级市场监管部门', 'B', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 10:27:41', '2023-10-26 10:27:41', '111');
INSERT INTO `gy_bioer` VALUES (1717370588788363266, '企业名称', '1', '1', 111111, '1111', '111', '111', '111', '230000', '230100', '230103', '伊春市市场监督管理局', '', '', '2023-10-26 10:40:30', '', '强制性标准', '3', '已落实', '2', '市级市场监管部门', 'B', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 10:40:30', '2023-10-26 10:40:30', '');
INSERT INTO `gy_bioer` VALUES (1717429091871633410, '321', '0', '0', 321, '321', '321', '3', '321', '230000', '230300', '230305', '牡丹江市市场监督管理局', 'A', '321', '2023-10-26 00:00:00', '321', '强制性标准', '3', '已落实', '2', '省级市场监管部门', 'A', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 14:32:58', '2023-10-26 14:32:58', '213');
INSERT INTO `gy_bioer` VALUES (1717430098814971906, '321', '0', '0', 321, '321', '321', '3', '321', '230000', '230300', '230305', '牡丹江市市场监督管理局', 'A', '321', '2023-10-26 00:00:00', '321', '强制性标准', '3', '已落实', '2', '省级市场监管部门', 'A', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 14:36:59', '2023-10-26 14:36:59', '213');
INSERT INTO `gy_bioer` VALUES (1717430300040900609, '321', '0', '0', 321, '321', '321', '3', '321', '230000', '230300', '230305', '牡丹江市市场监督管理局', 'A', '321', '2023-10-26 00:00:00', '321', '强制性标准', '3', '已落实', '2', '省级市场监管部门', 'A', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 14:37:46', '2023-10-26 14:37:46', '213');
INSERT INTO `gy_bioer` VALUES (1717430712835911682, '321', '0', '0', 321, '321', '321', '3', '321', '230000', '230300', '230305', '牡丹江市市场监督管理局', 'A', '321', '2023-10-26 00:00:00', '321', '强制性标准', '3', '已落实', '2', '省级市场监管部门', 'A', '质量安全风险较大或者信用风险较高', '2', '“双随机”日常监管或触发式监管', '1', '2023-10-26 14:39:25', '2023-10-26 14:39:25', '213');

-- ----------------------------
-- Table structure for gy_epi
-- ----------------------------
DROP TABLE IF EXISTS `gy_epi`;
CREATE TABLE `gy_epi`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NULL DEFAULT NULL COMMENT '产品名称',
  `product_specifications_and_models` varchar(255) NULL DEFAULT NULL COMMENT '产品规型号',
  `executive_standards` varchar(500) NULL DEFAULT NULL COMMENT '执行标准',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430713704132609 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_epi
-- ----------------------------
INSERT INTO `gy_epi` VALUES (1717081093564137473, '', '', '2023-10-24 11:06:18', '1717081090993029122', '2023-10-25 15:30:09', '2023-10-25 15:30:09');
INSERT INTO `gy_epi` VALUES (1717367366577270785, '卫星数字电视接收机', '1111', '11111', '1717367363809030145', '2023-10-26 10:27:42', '2023-10-26 10:27:42');
INSERT INTO `gy_epi` VALUES (1717430456161284097, '家用和类似用途固定式电气装置开关(0202)', '231', '321', '1717430300040900609', '2023-10-26 14:38:24', '2023-10-26 14:38:24');
INSERT INTO `gy_epi` VALUES (1717430713704132609, '家用和类似用途固定式电气装置开关(0202)', '231', '321', '1717430712835911682', '2023-10-26 14:39:25', '2023-10-26 14:39:25');

-- ----------------------------
-- Table structure for gy_eqasmpi
-- ----------------------------
DROP TABLE IF EXISTS `gy_eqasmpi`;
CREATE TABLE `gy_eqasmpi`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NULL DEFAULT NULL COMMENT '质量安全总监',
  `id_number` varchar(18) NULL DEFAULT NULL COMMENT '身份证号',
  `training_time` timestamp(0) NULL DEFAULT NULL COMMENT '参加培训时间',
  `duration_of_employment` varchar(255) NULL DEFAULT NULL COMMENT '任职时间',
  `phone` varchar(11) NULL DEFAULT NULL COMMENT '联系电话',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430714140340226 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_eqasmpi
-- ----------------------------
INSERT INTO `gy_eqasmpi` VALUES (1717081094277169154, '', '', '2023-10-24 11:06:18', '', '', '1717081090993029122', '2023-10-25 15:30:09', '2023-10-25 15:30:09');
INSERT INTO `gy_eqasmpi` VALUES (1717367367806201857, '111', '111', '2023-10-12 00:00:00', '2023-10-10 00:00:00', '11111111', '1717367363809030145', '2023-10-26 10:27:42', '2023-10-26 10:27:42');
INSERT INTO `gy_eqasmpi` VALUES (1717430631965536257, '321', '321', '2023-10-05 00:00:00', '2023-10-03 00:00:00', '321', '1717430300040900609', '2023-10-26 14:39:06', '2023-10-26 14:39:06');
INSERT INTO `gy_eqasmpi` VALUES (1717430714140340226, '321', '321', '2023-10-05 00:00:00', '2023-10-03 00:00:00', '321', '1717430712835911682', '2023-10-26 14:39:25', '2023-10-26 14:39:25');

-- ----------------------------
-- Table structure for gy_eqmsaii
-- ----------------------------
DROP TABLE IF EXISTS `gy_eqmsaii`;
CREATE TABLE `gy_eqmsaii`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `jroqasd` bigint(0) NULL DEFAULT NULL COMMENT '质量安全总监职位职责',
  `cocfaqso` bigint(0) NULL DEFAULT NULL COMMENT '质量安全员岗守则',
  `epqascl` bigint(0) NULL DEFAULT NULL COMMENT '企业产品质量安全管控清单',
  `daily_control_time` varchar(255) NULL DEFAULT NULL COMMENT '日管控时间',
  `is_daily_control` varchar(50) NULL DEFAULT NULL COMMENT '是否进行日管控(0否 1是)',
  `dcopqas` bigint(0) NULL DEFAULT NULL COMMENT '产品质量安全日管控情况',
  `rfnbc` varchar(50) NULL DEFAULT NULL COMMENT '未进行管控原因',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430716715642882 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_eqmsaii
-- ----------------------------
INSERT INTO `gy_eqmsaii` VALUES (1717081094793068546, 1, 1, 1, '', '2023-10-24 11:06:18', 1, '', '1717081090993029122', '2023-10-25 15:30:09', '2023-10-25 15:30:09');
INSERT INTO `gy_eqmsaii` VALUES (1717367368527622146, 1717361284039462913, 1717361307653394434, 1717361328763326465, '2023-10-03 00:00:00', '1', 1717361379904475137, '1111', '1717367363809030145', '2023-10-26 10:27:42', '2023-10-26 10:27:42');
INSERT INTO `gy_eqmsaii` VALUES (1717430633248993281, 1717426892558970881, 1717426881804775425, 1717426871037997058, '2023-10-11 00:00:00', '0', 1717426859965034498, '321', '1717430300040900609', '2023-10-26 14:39:06', '2023-10-26 14:39:06');
INSERT INTO `gy_eqmsaii` VALUES (1717430635451002881, 1717427047463006210, 1717427018174181377, 1717426995118092289, '2023-10-18 00:00:00', '1', 1717426940852187137, '321', '1717430300040900609', '2023-10-26 14:39:06', '2023-10-26 14:39:06');
INSERT INTO `gy_eqmsaii` VALUES (1717430714559770625, 1717426892558970881, 1717426881804775425, 1717426871037997058, '2023-10-11 00:00:00', '0', 1717426859965034498, '321', '1717430712835911682', '2023-10-26 14:39:25', '2023-10-26 14:39:25');
INSERT INTO `gy_eqmsaii` VALUES (1717430716715642882, 1717427047463006210, 1717427018174181377, 1717426995118092289, '2023-10-18 00:00:00', '1', 1717426940852187137, '321', '1717430712835911682', '2023-10-26 14:39:26', '2023-10-26 14:39:26');

-- ----------------------------
-- Table structure for gy_eqmsaii_month
-- ----------------------------
DROP TABLE IF EXISTS `gy_eqmsaii_month`;
CREATE TABLE `gy_eqmsaii_month`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `jroqasd` bigint(0) NULL DEFAULT NULL COMMENT '质量安全总监职位职责',
  `cocfaqso` bigint(0) NULL DEFAULT NULL COMMENT '质量安全员岗守则',
  `epqascl` bigint(0) NULL DEFAULT NULL COMMENT '企业产品质量安全管控清单',
  `monthly_scheduling_time` varchar(255) NULL DEFAULT NULL COMMENT '月调度时间',
  `is_monthly_scheduling` varchar(50) NULL DEFAULT NULL COMMENT '是否进行月调度(0否 1是)',
  `dcopqas` bigint(0) NULL DEFAULT NULL COMMENT '产品质量月调度情况',
  `rfns` varchar(50) NULL DEFAULT NULL COMMENT '未进调度原因',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430718842155009 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_eqmsaii_month
-- ----------------------------
INSERT INTO `gy_eqmsaii_month` VALUES (1717081098278535169, 1, 1, 1, '', '2023-10-24 11:06:18', 1, '', '1717081090993029122', '2023-10-25 15:30:10', '2023-10-25 15:30:10');
INSERT INTO `gy_eqmsaii_month` VALUES (1717367373195882497, 1717361571391229954, 1717361586713022466, 1717361600101240833, '2023-06-01 00:00:00', '0', 1717361632066031618, '111', '1717367363809030145', '2023-10-26 10:27:44', '2023-10-26 10:27:44');
INSERT INTO `gy_eqmsaii_month` VALUES (1717430637632040962, 1717427623349334017, 1717427609856258050, 1717427582203211777, '2023-10-01 00:00:00', '0', 1717427519947157506, '321', '1717430300040900609', '2023-10-26 14:39:07', '2023-10-26 14:39:07');
INSERT INTO `gy_eqmsaii_month` VALUES (1717430718842155009, 1717427623349334017, 1717427609856258050, 1717427582203211777, '2023-10-01 00:00:00', '0', 1717427519947157506, '321', '1717430712835911682', '2023-10-26 14:39:26', '2023-10-26 14:39:26');

-- ----------------------------
-- Table structure for gy_eqmsaii_week
-- ----------------------------
DROP TABLE IF EXISTS `gy_eqmsaii_week`;
CREATE TABLE `gy_eqmsaii_week`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `jroqasd` bigint(0) NULL DEFAULT NULL COMMENT '质量安全总监职位职责',
  `cocfaqso` bigint(0) NULL DEFAULT NULL COMMENT '质量安全员岗守则',
  `epqascl` bigint(0) NULL DEFAULT NULL COMMENT '企业产品质量安全管控清单',
  `weekly_inspection_time` varchar(255) NULL DEFAULT NULL COMMENT '周排查时间',
  `is_weekly_inspection` varchar(50) NULL DEFAULT NULL COMMENT '是否进行周排查(0否 1是)',
  `dcopqas` bigint(0) NULL DEFAULT NULL COMMENT '产品质量周排查情况',
  `rfnci` varchar(50) NULL DEFAULT NULL COMMENT '未进行排查原因',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430720985444353 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_eqmsaii_week
-- ----------------------------
INSERT INTO `gy_eqmsaii_week` VALUES (1717081100698648578, 1, 1, 1, '', '2023-10-24 11:06:18', 1, '', '1717081090993029122', '2023-10-25 15:30:11', '2023-10-25 15:30:11');
INSERT INTO `gy_eqmsaii_week` VALUES (1717367376664571905, 1717361413995778049, 1717361443628535810, 1717361475157118977, '2023-10-09 00:00:00', '1', 1717361535093723137, '111', '1717367363809030145', '2023-10-26 10:27:44', '2023-10-26 10:27:44');
INSERT INTO `gy_eqmsaii_week` VALUES (1717430641335611394, 1717427492340248578, 1717427478956224514, 1717427459964416002, '2023-10-23 00:00:00', '0', 1717427435293519873, '321', '1717430300040900609', '2023-10-26 14:39:08', '2023-10-26 14:39:08');
INSERT INTO `gy_eqmsaii_week` VALUES (1717430720985444353, 1717427492340248578, 1717427478956224514, 1717427459964416002, '2023-10-23 00:00:00', '0', 1717427435293519873, '321', '1717430712835911682', '2023-10-26 14:39:27', '2023-10-26 14:39:27');

-- ----------------------------
-- Table structure for gy_ipli
-- ----------------------------
DROP TABLE IF EXISTS `gy_ipli`;
CREATE TABLE `gy_ipli`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `iplmp` varchar(2) NULL DEFAULT NULL COMMENT '是否为工业产品许可证管理产品(0否 1是)',
  `ippln` varchar(50) NULL DEFAULT NULL COMMENT '工业产品生产许可证号',
  `cpsam_code` varchar(255) NULL DEFAULT NULL COMMENT '发证产品规格',
  `cpsam_name` varchar(255) NULL DEFAULT NULL COMMENT '发证产品型号',
  `issuing_authority` varchar(50) NULL DEFAULT NULL COMMENT '发证机关',
  `date_of_issuance` timestamp(0) NULL DEFAULT NULL COMMENT '发证时间',
  `validity_period` timestamp(0) NULL DEFAULT NULL COMMENT '有效期限',
  `license_scope` varchar(50) NULL DEFAULT NULL COMMENT '许可范围',
  `ccp` varchar(50) NULL DEFAULT NULL COMMENT '是否为强制性认证产品(0否 1是)',
  `ent_id` varchar(50) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430723111956482 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_ipli
-- ----------------------------
INSERT INTO `gy_ipli` VALUES (1717081103034875906, '', '', NULL, '', '', '2023-10-24 11:06:18', '2023-10-24 11:06:18', '', '', '1717081090993029122', '2023-10-25 15:30:11', '2023-10-25 15:30:11');
INSERT INTO `gy_ipli` VALUES (1717367381060202498, '0', '111', NULL, NULL, '230900', '2023-10-26 00:00:00', '2023-10-10 00:00:00', '111', '0', '1717367363809030145', '2023-10-26 10:27:45', '2023-10-26 10:27:45');
INSERT INTO `gy_ipli` VALUES (1717370589509783553, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, '1717370588788363266', '2023-10-26 10:40:30', '2023-10-26 10:40:30');
INSERT INTO `gy_ipli` VALUES (1717430643579564033, '0', '321', '321', '321', '230700', '2023-10-25 00:00:00', '2023-10-24 00:00:00', '321', '0', '1717430300040900609', '2023-10-26 14:39:08', '2023-10-26 14:39:08');
INSERT INTO `gy_ipli` VALUES (1717430723111956482, '0', '321', '321', '321', '230700', '2023-10-25 00:00:00', '2023-10-24 00:00:00', '321', '0', '1717430712835911682', '2023-10-26 14:39:27', '2023-10-26 14:39:27');

-- ----------------------------
-- Table structure for gy_market_regulated_information
-- ----------------------------
DROP TABLE IF EXISTS `gy_market_regulated_information`;
CREATE TABLE `gy_market_regulated_information`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `ent_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `inspection_time` datetime(0) NULL DEFAULT NULL COMMENT '检查时间',
  `did_you_issues` varchar(255) NULL DEFAULT NULL COMMENT '是否发现问题0否1是',
  `market_coverage_upid` bigint(0) NULL DEFAULT NULL COMMENT '市场所全覆盖监督检查情况文件id',
  `product_quality_market_upid` bigint(0) NULL DEFAULT NULL COMMENT '接受市场所产品质量行政处罚情况文件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430723531386881 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_market_regulated_information
-- ----------------------------
INSERT INTO `gy_market_regulated_information` VALUES (1, 1, NULL, NULL, NULL, '撒地方', NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (2, 1, NULL, NULL, NULL, '撒地方啊', NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (3, 4, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (1717081103542386689, 1717081090993029122, '2023-10-25 15:30:12', '2023-10-25 15:30:12', '2023-10-24 11:06:18', '', 1, 1);
INSERT INTO `gy_market_regulated_information` VALUES (1717367381680959490, 1717367363809030145, '2023-10-26 10:27:46', '2023-10-26 10:27:46', '2023-10-20 00:00:00', '0', NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (1717370590218620930, 1717370588788363266, '2023-10-26 10:40:31', '2023-10-26 10:40:31', '2023-10-20 00:00:00', '0', NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (1717430644007383042, 1717430300040900609, '2023-10-26 14:39:09', '2023-10-26 14:39:09', '2023-10-13 00:00:00', '0', NULL, NULL);
INSERT INTO `gy_market_regulated_information` VALUES (1717430723531386881, 1717430712835911682, '2023-10-26 14:39:27', '2023-10-26 14:39:27', '2023-10-13 00:00:00', '0', NULL, NULL);

-- ----------------------------
-- Table structure for gy_mrdipqassi_county_bureau_aoapfpqatcl
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_county_bureau_aoapfpqatcl`;
CREATE TABLE `gy_mrdipqassi_county_bureau_aoapfpqatcl`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `penalty_time` timestamp(0) NULL DEFAULT NULL COMMENT '处罚时间',
  `aoapfpqatcl` bigint(0) NULL DEFAULT NULL COMMENT '接受县（区）级产品质量行政处罚情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430723950817281 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_county_bureau_aoapfpqatcl
-- ----------------------------
INSERT INTO `gy_mrdipqassi_county_bureau_aoapfpqatcl` VALUES (1717081104947478530, '2023-10-24 11:06:18', 1, '1717081090993029122', '2023-10-25 15:30:12', '2023-10-25 15:30:12');
INSERT INTO `gy_mrdipqassi_county_bureau_aoapfpqatcl` VALUES (1717367382574346241, '2023-10-04 00:00:00', NULL, '1717367363809030145', '2023-10-26 10:27:46', '2023-10-26 10:27:46');
INSERT INTO `gy_mrdipqassi_county_bureau_aoapfpqatcl` VALUES (1717370590898098178, '2023-10-04 00:00:00', NULL, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31');
INSERT INTO `gy_mrdipqassi_county_bureau_aoapfpqatcl` VALUES (1717430644439396353, '2023-10-09 00:00:00', NULL, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_county_bureau_aoapfpqatcl` VALUES (1717430723950817281, '2023-10-09 00:00:00', NULL, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_county_bureau_clpqsasc
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_county_bureau_clpqsasc`;
CREATE TABLE `gy_mrdipqassi_county_bureau_clpqsasc`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `sampling_time` timestamp(0) NULL DEFAULT NULL COMMENT '抽检时间',
  `qualified` varchar(255) NULL DEFAULT NULL COMMENT '是否合格(0否 1是)',
  `clpqsasc` bigint(0) NULL DEFAULT NULL COMMENT '县（区）级产品质量监督抽查情',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430724378636289 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_county_bureau_clpqsasc
-- ----------------------------
INSERT INTO `gy_mrdipqassi_county_bureau_clpqsasc` VALUES (1717081105891196930, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:12', '2023-10-25 15:30:12');
INSERT INTO `gy_mrdipqassi_county_bureau_clpqsasc` VALUES (1717367383341903873, '2023-10-04 00:00:00', '0', NULL, '1717367363809030145', '2023-10-26 10:27:46', '2023-10-26 10:27:46');
INSERT INTO `gy_mrdipqassi_county_bureau_clpqsasc` VALUES (1717370591502077954, '2023-10-04 00:00:00', '0', NULL, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31');
INSERT INTO `gy_mrdipqassi_county_bureau_clpqsasc` VALUES (1717430644875603969, '2023-10-25 00:00:00', '0', NULL, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_county_bureau_clpqsasc` VALUES (1717430724378636289, '2023-10-25 00:00:00', '0', NULL, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_county_bureau_fcsaiocb
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_county_bureau_fcsaiocb`;
CREATE TABLE `gy_mrdipqassi_county_bureau_fcsaiocb`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `inspection_time` timestamp(0) NULL DEFAULT NULL COMMENT '检查时间',
  `discover_problems` varchar(255) NULL DEFAULT NULL COMMENT '是否发现问题(0否 1是)',
  `fcsaiocb` bigint(0) NULL DEFAULT NULL COMMENT '县（区）局全覆盖监督检查情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430724802260993 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_county_bureau_fcsaiocb
-- ----------------------------
INSERT INTO `gy_mrdipqassi_county_bureau_fcsaiocb` VALUES (1717081106839109633, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:12', '2023-10-25 15:30:12');
INSERT INTO `gy_mrdipqassi_county_bureau_fcsaiocb` VALUES (1717367384000409602, '2023-10-03 00:00:00', '0', NULL, '1717367363809030145', '2023-10-26 10:27:46', '2023-10-26 10:27:46');
INSERT INTO `gy_mrdipqassi_county_bureau_fcsaiocb` VALUES (1717370592030560258, '2023-10-03 00:00:00', '0', NULL, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31');
INSERT INTO `gy_mrdipqassi_county_bureau_fcsaiocb` VALUES (1717430645311811586, '2023-10-10 00:00:00', '0', NULL, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_county_bureau_fcsaiocb` VALUES (1717430724802260993, '2023-10-10 00:00:00', '0', NULL, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_municipal_bureau_double_randomness
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_municipal_bureau_double_randomness`;
CREATE TABLE `gy_mrdipqassi_municipal_bureau_double_randomness`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `inspection_time` timestamp(0) NULL DEFAULT NULL COMMENT '检查时间',
  `discover_problems` varchar(255) NULL DEFAULT NULL COMMENT '是否发现问题(0否 1是)',
  `drsaibtmb` bigint(0) NULL DEFAULT NULL COMMENT '市局双随机监督检查情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430730724618242 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_municipal_bureau_double_randomness
-- ----------------------------
INSERT INTO `gy_mrdipqassi_municipal_bureau_double_randomness` VALUES (1717081115089305602, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:14', '2023-10-25 15:30:14');
INSERT INTO `gy_mrdipqassi_municipal_bureau_double_randomness` VALUES (1717367393022357505, '2023-10-26 00:00:00', '0', NULL, '1717367363809030145', '2023-10-26 10:27:48', '2023-10-26 10:27:48');
INSERT INTO `gy_mrdipqassi_municipal_bureau_double_randomness` VALUES (1717370608203796481, '2023-10-26 00:00:00', '0', NULL, '1717370588788363266', '2023-10-26 10:40:35', '2023-10-26 10:40:35');
INSERT INTO `gy_mrdipqassi_municipal_bureau_double_randomness` VALUES (1717430651418718210, '2023-10-19 00:00:00', '0', NULL, '1717430300040900609', '2023-10-26 14:39:10', '2023-10-26 14:39:10');
INSERT INTO `gy_mrdipqassi_municipal_bureau_double_randomness` VALUES (1717430730724618242, '2023-10-19 00:00:00', '0', NULL, '1717430712835911682', '2023-10-26 14:39:29', '2023-10-26 14:39:29');

-- ----------------------------
-- Table structure for gy_mrdipqassi_municipal_bureau_product_quality
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_municipal_bureau_product_quality`;
CREATE TABLE `gy_mrdipqassi_municipal_bureau_product_quality`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `sampling_time` timestamp(0) NULL DEFAULT NULL COMMENT '抽检时间',
  `qualified` varchar(255) NULL DEFAULT NULL COMMENT '是否合格(0否 1是)',
  `mlpqsasc` bigint(0) NULL DEFAULT NULL COMMENT '市级产品质量监督抽查情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430725221691394 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_municipal_bureau_product_quality
-- ----------------------------
INSERT INTO `gy_mrdipqassi_municipal_bureau_product_quality` VALUES (1717081107795410945, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:13', '2023-10-25 15:30:13');
INSERT INTO `gy_mrdipqassi_municipal_bureau_product_quality` VALUES (1717367384700858369, '2023-10-04 00:00:00', '1', NULL, '1717367363809030145', '2023-10-26 10:27:46', '2023-10-26 10:27:46');
INSERT INTO `gy_mrdipqassi_municipal_bureau_product_quality` VALUES (1717370592634540034, '2023-10-04 00:00:00', '1', NULL, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31');
INSERT INTO `gy_mrdipqassi_municipal_bureau_product_quality` VALUES (1717430645735436289, '2023-10-04 00:00:00', '1', NULL, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_municipal_bureau_product_quality` VALUES (1717430725221691394, '2023-10-04 00:00:00', '1', NULL, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_municipal_bureau_punishment_situation
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_municipal_bureau_punishment_situation`;
CREATE TABLE `gy_mrdipqassi_municipal_bureau_punishment_situation`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `penalty_time` timestamp(0) NULL DEFAULT NULL COMMENT '处罚时间',
  `aoapfpqatml` bigint(0) NULL DEFAULT NULL COMMENT '接受市级产品质量行政处罚情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `discover_problems` varchar(255) NULL DEFAULT NULL COMMENT '是否发现问题(0否 1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430725645316098 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_municipal_bureau_punishment_situation
-- ----------------------------
INSERT INTO `gy_mrdipqassi_municipal_bureau_punishment_situation` VALUES (1717081108739129346, '2023-10-24 11:06:18', 1, '1717081090993029122', '2023-10-25 15:30:13', '2023-10-25 15:30:13', NULL);
INSERT INTO `gy_mrdipqassi_municipal_bureau_punishment_situation` VALUES (1717367385409695746, '2023-10-05 00:00:00', NULL, '1717367363809030145', '2023-10-26 10:27:46', '2023-10-26 10:27:46', '');
INSERT INTO `gy_mrdipqassi_municipal_bureau_punishment_situation` VALUES (1717370593225936897, '2023-10-05 00:00:00', NULL, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31', '');
INSERT INTO `gy_mrdipqassi_municipal_bureau_punishment_situation` VALUES (1717430646171643905, '2023-10-10 00:00:00', NULL, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09', '');
INSERT INTO `gy_mrdipqassi_municipal_bureau_punishment_situation` VALUES (1717430725645316098, '2023-10-10 00:00:00', NULL, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28', '');

-- ----------------------------
-- Table structure for gy_mrdipqassi_provincial_bureau_double_randomness
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_provincial_bureau_double_randomness`;
CREATE TABLE `gy_mrdipqassi_provincial_bureau_double_randomness`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `inspection_time` timestamp(0) NULL DEFAULT NULL COMMENT '检查时间',
  `discover_problems` varchar(255) NULL DEFAULT NULL COMMENT '是否发现问题(0否 1是)',
  `drsaibtpb` bigint(0) NULL DEFAULT NULL COMMENT '省局双随机监督检查情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430726073135105 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_provincial_bureau_double_randomness
-- ----------------------------
INSERT INTO `gy_mrdipqassi_provincial_bureau_double_randomness` VALUES (1717081109691236353, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:13', '2023-10-25 15:30:13');
INSERT INTO `gy_mrdipqassi_provincial_bureau_double_randomness` VALUES (1717367385929789441, '2023-10-18 00:00:00', '0', 1717361760579506177, '1717367363809030145', '2023-10-26 10:27:47', '2023-10-26 10:27:47');
INSERT INTO `gy_mrdipqassi_provincial_bureau_double_randomness` VALUES (1717370593884442625, '2023-10-18 00:00:00', '0', 1717361760579506177, '1717370588788363266', '2023-10-26 10:40:31', '2023-10-26 10:40:31');
INSERT INTO `gy_mrdipqassi_provincial_bureau_double_randomness` VALUES (1717430646612045826, '2023-09-26 00:00:00', '0', 1717427715334615041, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_provincial_bureau_double_randomness` VALUES (1717430726073135105, '2023-09-26 00:00:00', '0', 1717427715334615041, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_provincial_bureau_product_quality
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_provincial_bureau_product_quality`;
CREATE TABLE `gy_mrdipqassi_provincial_bureau_product_quality`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `sampling_time` timestamp(0) NULL DEFAULT NULL COMMENT '抽检时间',
  `qualified` varchar(255) NULL DEFAULT NULL COMMENT '是否合格(0否 1是)',
  `ppqsasc` bigint(0) NULL DEFAULT NULL COMMENT '省级产品质量监督抽查情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430726949744642 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_provincial_bureau_product_quality
-- ----------------------------
INSERT INTO `gy_mrdipqassi_provincial_bureau_product_quality` VALUES (1717081110651731970, '2023-10-24 11:06:18', '', 1, '1717081090993029122', '2023-10-25 15:30:13', '2023-10-25 15:30:13');
INSERT INTO `gy_mrdipqassi_provincial_bureau_product_quality` VALUES (1717367387787866114, '2023-10-18 00:00:00', '0', 1717361804149936129, '1717367363809030145', '2023-10-26 10:27:47', '2023-10-26 10:27:47');
INSERT INTO `gy_mrdipqassi_provincial_bureau_product_quality` VALUES (1717370595507638273, '2023-10-18 00:00:00', '0', 1717361804149936129, '1717370588788363266', '2023-10-26 10:40:32', '2023-10-26 10:40:32');
INSERT INTO `gy_mrdipqassi_provincial_bureau_product_quality` VALUES (1717430647492849666, '2023-10-20 00:00:00', '1', 1717427747622367234, '1717430300040900609', '2023-10-26 14:39:09', '2023-10-26 14:39:09');
INSERT INTO `gy_mrdipqassi_provincial_bureau_product_quality` VALUES (1717430726949744642, '2023-10-20 00:00:00', '1', 1717427747622367234, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_provincial_bureau_punishment_situation
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_provincial_bureau_punishment_situation`;
CREATE TABLE `gy_mrdipqassi_provincial_bureau_punishment_situation`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `penalty_time` timestamp(0) NULL DEFAULT NULL COMMENT '处罚时间',
  `aoplapfpq` bigint(0) NULL DEFAULT NULL COMMENT '接受省级产品质量行政处罚情况',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430727796994049 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_provincial_bureau_punishment_situation
-- ----------------------------
INSERT INTO `gy_mrdipqassi_provincial_bureau_punishment_situation` VALUES (1717081111612227585, '2023-10-24 11:06:18', 1, '1717081090993029122', '2023-10-25 15:30:13', '2023-10-25 15:30:13');
INSERT INTO `gy_mrdipqassi_provincial_bureau_punishment_situation` VALUES (1717367388916133890, '2023-10-03 00:00:00', 1717361830452416514, '1717367363809030145', '2023-10-26 10:27:47', '2023-10-26 10:27:47');
INSERT INTO `gy_mrdipqassi_provincial_bureau_punishment_situation` VALUES (1717370596640100353, '2023-10-03 00:00:00', 1717361830452416514, '1717370588788363266', '2023-10-26 10:40:32', '2023-10-26 10:40:32');
INSERT INTO `gy_mrdipqassi_provincial_bureau_punishment_situation` VALUES (1717430648386236417, '2023-10-04 00:00:00', 1717427764328280065, '1717430300040900609', '2023-10-26 14:39:10', '2023-10-26 14:39:10');
INSERT INTO `gy_mrdipqassi_provincial_bureau_punishment_situation` VALUES (1717430727796994049, '2023-10-04 00:00:00', 1717427764328280065, '1717430712835911682', '2023-10-26 14:39:28', '2023-10-26 14:39:28');

-- ----------------------------
-- Table structure for gy_mrdipqassi_stratification_county
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_stratification_county`;
CREATE TABLE `gy_mrdipqassi_stratification_county`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `performance_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '履职时间',
  `county_regulatory_responsible_person` varchar(255) NULL DEFAULT NULL COMMENT '县（区）级监管责任人',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430728640049154 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_stratification_county
-- ----------------------------
INSERT INTO `gy_mrdipqassi_stratification_county` VALUES (1717081112572723202, '2023-10-24 11:06:18', '', '1717081090993029122', '2023-10-25 15:30:14', '2023-10-25 15:30:14');
INSERT INTO `gy_mrdipqassi_stratification_county` VALUES (1717367389864046594, '2023-10-04 00:00:00', '11', '1717367363809030145', '2023-10-26 10:27:48', '2023-10-26 10:27:48');
INSERT INTO `gy_mrdipqassi_stratification_county` VALUES (1717370597764173825, '2023-10-04 00:00:00', '11', '1717370588788363266', '2023-10-26 10:40:32', '2023-10-26 10:40:32');
INSERT INTO `gy_mrdipqassi_stratification_county` VALUES (1717430649275428866, '2023-10-02 00:00:00', 'dwa', '1717430300040900609', '2023-10-26 14:39:10', '2023-10-26 14:39:10');
INSERT INTO `gy_mrdipqassi_stratification_county` VALUES (1717430728640049154, '2023-10-02 00:00:00', 'dwa', '1717430712835911682', '2023-10-26 14:39:29', '2023-10-26 14:39:29');

-- ----------------------------
-- Table structure for gy_mrdipqassi_stratification_market_institute
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_stratification_market_institute`;
CREATE TABLE `gy_mrdipqassi_stratification_market_institute`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `performance_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '履职时间',
  `market_institute_regulatory_responsible_person` varchar(255) NULL DEFAULT NULL COMMENT '市场所监管责任人',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430729063673857 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_stratification_market_institute
-- ----------------------------
INSERT INTO `gy_mrdipqassi_stratification_market_institute` VALUES (1717081113067651073, '2023-10-24 11:06:18', '', '1717081090993029122', '2023-10-25 15:30:14', '2023-10-25 15:30:14');
INSERT INTO `gy_mrdipqassi_stratification_market_institute` VALUES (1717367390342197249, '2023-10-27 00:00:00', '111', '1717367363809030145', '2023-10-26 10:27:48', '2023-10-26 10:27:48');
INSERT INTO `gy_mrdipqassi_stratification_market_institute` VALUES (1717370598322016258, '2023-10-27 00:00:00', '111', '1717370588788363266', '2023-10-26 10:40:33', '2023-10-26 10:40:33');
INSERT INTO `gy_mrdipqassi_stratification_market_institute` VALUES (1717430649707442178, '2023-10-11 00:00:00', 'dw', '1717430300040900609', '2023-10-26 14:39:10', '2023-10-26 14:39:10');
INSERT INTO `gy_mrdipqassi_stratification_market_institute` VALUES (1717430729063673857, '2023-10-11 00:00:00', 'dw', '1717430712835911682', '2023-10-26 14:39:29', '2023-10-26 14:39:29');

-- ----------------------------
-- Table structure for gy_mrdipqassi_stratification_province
-- ----------------------------
DROP TABLE IF EXISTS `gy_mrdipqassi_stratification_province`;
CREATE TABLE `gy_mrdipqassi_stratification_province`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `performance_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '履职时间',
  `provincial_regulatory_responsible_person` varchar(255) NULL DEFAULT NULL COMMENT '省级监管责任人',
  `ent_id` varchar(255) NULL DEFAULT NULL COMMENT '外键id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430729487298562 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_mrdipqassi_stratification_province
-- ----------------------------
INSERT INTO `gy_mrdipqassi_stratification_province` VALUES (1717081113566773249, '2023-10-24 11:06:18', '', '1717081090993029122', '2023-10-25 15:30:14', '2023-10-25 15:30:14');
INSERT INTO `gy_mrdipqassi_stratification_province` VALUES (1717367391088783362, '2023-09-27 00:00:00', '111', '1717367363809030145', '2023-10-26 10:27:48', '2023-10-26 10:27:48');
INSERT INTO `gy_mrdipqassi_stratification_province` VALUES (1717370598875664385, '2023-09-27 00:00:00', '111', '1717370588788363266', '2023-10-26 10:40:33', '2023-10-26 10:40:33');
INSERT INTO `gy_mrdipqassi_stratification_province` VALUES (1717430650131066882, '2023-10-25 00:00:00', 'dwa', '1717430300040900609', '2023-10-26 14:39:10', '2023-10-26 14:39:10');
INSERT INTO `gy_mrdipqassi_stratification_province` VALUES (1717430729487298562, '2023-10-25 00:00:00', 'dwa', '1717430712835911682', '2023-10-26 14:39:29', '2023-10-26 14:39:29');

-- ----------------------------
-- Table structure for gy_product_recall_information
-- ----------------------------
DROP TABLE IF EXISTS `gy_product_recall_information`;
CREATE TABLE `gy_product_recall_information`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `ent_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `recall_time` datetime(0) NULL DEFAULT NULL COMMENT '生产单位实施召回时间',
  `reason_for_recall` varchar(255) NULL DEFAULT NULL COMMENT '实施召回原因',
  `recalled_products` varchar(255) NULL DEFAULT NULL COMMENT '	\r\n对召回产品保证产品质量采取的措施',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430729919311873 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_product_recall_information
-- ----------------------------
INSERT INTO `gy_product_recall_information` VALUES (1717081114082672642, 1717081090993029122, '2023-10-25 15:30:14', '2023-10-25 15:30:14', '2023-10-24 11:06:18', '', '');
INSERT INTO `gy_product_recall_information` VALUES (1717367391843758082, 1717367363809030145, '2023-10-26 10:27:48', '2023-10-26 10:27:48', '2023-10-17 00:00:00', '11', '111');
INSERT INTO `gy_product_recall_information` VALUES (1717370602138832898, 1717370588788363266, '2023-10-26 10:40:33', '2023-10-26 10:40:33', '2023-10-17 00:00:00', '11', '111');
INSERT INTO `gy_product_recall_information` VALUES (1717430650567274498, 1717430300040900609, '2023-10-26 14:39:10', '2023-10-26 14:39:10', '2023-10-25 00:00:00', 'adw', 'dw');
INSERT INTO `gy_product_recall_information` VALUES (1717430729919311873, 1717430712835911682, '2023-10-26 14:39:29', '2023-10-26 14:39:29', '2023-10-25 00:00:00', 'adw', 'dw');

-- ----------------------------
-- Table structure for gy_reporting_information
-- ----------------------------
DROP TABLE IF EXISTS `gy_reporting_information`;
CREATE TABLE `gy_reporting_information`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `ent_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `reporting_time` datetime(0) NULL DEFAULT NULL COMMENT '被查实投诉举报时间',
  `reason_for_reporting` varchar(255) NULL DEFAULT NULL COMMENT '	\r\n投诉举报事由',
  `handling_situation` varchar(255) NULL DEFAULT NULL COMMENT '	\r\n	\r\n投诉举报处理情况',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717430730359713794 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gy_reporting_information
-- ----------------------------
INSERT INTO `gy_reporting_information` VALUES (1717081114606960642, 1717081090993029122, '2023-10-25 15:30:14', '2023-10-25 15:30:14', '2023-10-24 11:06:18', '', '');
INSERT INTO `gy_reporting_information` VALUES (1717367392464515074, 1717367363809030145, '2023-10-26 10:27:48', '2023-10-26 10:27:48', '2023-10-10 00:00:00', '111', '111');
INSERT INTO `gy_reporting_information` VALUES (1717370607654342658, 1717370588788363266, '2023-10-26 10:40:35', '2023-10-26 10:40:35', '2023-10-10 00:00:00', '111', '111');
INSERT INTO `gy_reporting_information` VALUES (1717430650995093506, 1717430300040900609, '2023-10-26 14:39:10', '2023-10-26 14:39:10', '2023-10-12 00:00:00', 'da', 'dwa');
INSERT INTO `gy_reporting_information` VALUES (1717430730359713794, 1717430712835911682, '2023-10-26 14:39:29', '2023-10-26 14:39:29', '2023-10-12 00:00:00', 'da', 'dwa');

-- ----------------------------
-- Table structure for gy_upload
-- ----------------------------
DROP TABLE IF EXISTS `gy_upload`;
CREATE TABLE `gy_upload`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `content` longblob NULL COMMENT '文件内容',
  `type` varchar(255) NULL DEFAULT '0' COMMENT '0未使用1已使用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `file_name` varchar(255) NULL DEFAULT NULL COMMENT '文件名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717428067513544705 ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for nf_agent
-- ----------------------------
DROP TABLE IF EXISTS `nf_agent`;
CREATE TABLE `nf_agent`  (
  `id` varchar(30) NOT NULL COMMENT '代理人ID',
  `name` varchar(30) NULL DEFAULT NULL COMMENT '代理人姓名',
  `mobile` varchar(20) NULL DEFAULT NULL COMMENT '代理人联系方式',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB COMMENT = '代理人' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_agent
-- ----------------------------
INSERT INTO `nf_agent` VALUES ('IN1648170705699631105', '1', '1', 'IN1648170704642666498', '2023-04-18 11:44:52', '2023-04-18 13:15:54');
INSERT INTO `nf_agent` VALUES ('IN1648596668375838721', '1', '1', 'IN1648596667465674754', '2023-04-19 15:57:30', '2023-04-19 15:57:55');
INSERT INTO `nf_agent` VALUES ('IN1699594865461841922', '1', '1', 'IN1699594864081915905', '2023-09-07 09:26:08', '2023-09-07 09:26:08');
INSERT INTO `nf_agent` VALUES ('IN1699595303938576385', '1', '1', 'IN1699595302873223169', '2023-09-07 09:27:52', '2023-09-07 09:27:52');
INSERT INTO `nf_agent` VALUES ('IN1699596667703939073', '321', '321', 'IN1699596666533728258', '2023-09-07 09:33:17', '2023-09-07 09:33:17');
INSERT INTO `nf_agent` VALUES ('IN1699597245871968257', '456', '456', 'IN1699597244785643522', '2023-09-07 09:35:35', '2023-09-07 09:35:35');
INSERT INTO `nf_agent` VALUES ('IN1699598189967855617', '890', '890', 'IN1699598188793450498', '2023-09-07 09:39:20', '2023-09-07 09:39:20');
INSERT INTO `nf_agent` VALUES ('IN1699600772686041090', 'qwe', 'qwe', 'IN1699600771624882178', '2023-09-07 09:49:36', '2023-09-07 09:49:36');
INSERT INTO `nf_agent` VALUES ('IN1699601419158310914', '34', '34', 'IN1699601418122317826', '2023-09-07 09:52:10', '2023-09-07 09:52:10');
INSERT INTO `nf_agent` VALUES ('IN1699602575733444610', '567', '657', 'IN1699602574588399618', '2023-09-07 09:56:46', '2023-09-07 09:56:46');
INSERT INTO `nf_agent` VALUES ('IN1699603691619635201', '3', '3', 'IN1699603690571059202', '2023-09-07 10:01:12', '2023-09-07 10:01:12');
INSERT INTO `nf_agent` VALUES ('IN1699605034837102593', '234', '432', 'IN1699605033889189889', '2023-09-07 10:06:32', '2023-09-07 10:06:32');
INSERT INTO `nf_agent` VALUES ('IN1699606575358824449', '123', '123', 'IN1699606574461243393', '2023-09-07 10:12:39', '2023-09-07 10:12:39');
INSERT INTO `nf_agent` VALUES ('IN1711200196138885122', '', '', 'IN1711200194960285698', '2023-10-09 10:01:34', '2023-10-09 10:01:34');
INSERT INTO `nf_agent` VALUES ('IN1711204214378586114', '321', '321', 'IN1711204213082546178', '2023-10-09 10:17:32', '2023-10-09 10:22:41');
INSERT INTO `nf_agent` VALUES ('IN1711552738844647426', '321', '321', 'IN1711552737691213826', '2023-10-10 09:22:27', '2023-10-10 09:22:27');
INSERT INTO `nf_agent` VALUES ('IN1711553305180545025', '3', '21', 'IN1711553304127774722', '2023-10-10 09:24:42', '2023-10-10 09:24:42');
INSERT INTO `nf_agent` VALUES ('IN1711553731456049153', '321', '321', 'IN1711553724241846274', '2023-10-10 09:26:23', '2023-10-10 09:45:12');
INSERT INTO `nf_agent` VALUES ('IN1719181223922704385', '1', '1', 'IN1719181222656024578', '2023-10-31 10:35:19', '2023-11-07 13:23:49');
INSERT INTO `nf_agent` VALUES ('IN1721766310136639489', '21', '21', 'IN1721766308836405250', '2023-11-07 13:47:32', '2023-11-07 14:11:45');
INSERT INTO `nf_agent` VALUES ('IN1721773958210867202', '321', '321', 'IN1721773956763832321', '2023-11-07 14:17:55', '2023-11-07 14:35:53');
INSERT INTO `nf_agent` VALUES ('IN1721774120513654786', '321', '312', 'IN1721774118886264833', '2023-11-07 14:18:34', '2023-11-09 10:07:12');
INSERT INTO `nf_agent` VALUES ('IN1721781168064245761', '321', '31', 'IN1721781166717874178', '2023-11-07 14:46:34', '2023-11-07 14:53:26');
INSERT INTO `nf_agent` VALUES ('IN1721789324827824129', '321', '31', 'IN1721789323603087361', '2023-11-07 15:18:59', '2023-11-07 15:19:34');
INSERT INTO `nf_agent` VALUES ('IN1722451443502358529', '111', '1111', 'IN1722467372630097922', '2023-11-09 11:10:00', '2023-11-09 12:13:29');
INSERT INTO `nf_agent` VALUES ('IN1722470233820708866', NULL, NULL, 'IN1722470232101044226', '2023-11-09 12:24:40', '2023-11-09 12:26:48');
INSERT INTO `nf_agent` VALUES ('IN1722472309413986306', '1', '1', 'IN1722472308122140674', '2023-11-09 12:32:55', '2023-11-09 12:32:55');
INSERT INTO `nf_agent` VALUES ('IN1722473720730173442', NULL, NULL, 'IN1722473719442522114', '2023-11-09 12:38:32', '2023-11-09 12:38:32');
INSERT INTO `nf_agent` VALUES ('IN1728994394676199425', '11', '11', 'OUT1711213251413393410', '2023-11-27 12:29:22', '2023-11-27 12:29:22');
INSERT INTO `nf_agent` VALUES ('IN1728994764240519169', '11', '11', 'IN1729430191879577601', '2023-11-27 12:30:50', '2023-11-28 17:21:18');
INSERT INTO `nf_agent` VALUES ('IN1729418144538267650', '', '', 'IN1729418143338696706', '2023-11-28 16:33:11', '2023-11-28 16:33:11');
INSERT INTO `nf_agent` VALUES ('IN1729418751508582401', '', '', 'IN1729418750321594369', '2023-11-28 16:35:36', '2023-11-28 16:35:36');
INSERT INTO `nf_agent` VALUES ('IN1730124718311288834', '', '', 'IN1730124716373520386', '2023-11-30 15:20:52', '2023-11-30 15:20:52');
INSERT INTO `nf_agent` VALUES ('IN1730126506271780866', '321', '312', 'IN1730126504241737729', '2023-11-30 15:27:58', '2023-11-30 15:27:58');
INSERT INTO `nf_agent` VALUES ('IN1730127190484398082', '321', '31', 'IN1730126504241737729', '2023-11-30 15:30:41', '2023-11-30 15:30:41');
INSERT INTO `nf_agent` VALUES ('IN1730129276144005121', '21', '21', 'IN1730129273900052481', '2023-11-30 15:38:58', '2023-11-30 15:38:58');
INSERT INTO `nf_agent` VALUES ('IN1730131101094100994', '32', '32', 'IN1730131099617705985', '2023-11-30 15:46:13', '2023-11-30 15:46:13');
INSERT INTO `nf_agent` VALUES ('OUT1648200233813700610', '暗室逢灯', '手动阀', 'OUT1648200232878370818', '2023-04-18 13:42:12', '2023-04-18 16:54:21');
INSERT INTO `nf_agent` VALUES ('OUT1648929889227599873', '1', '1', 'OUT1648929887864451074', '2023-04-20 14:01:36', '2023-10-08 14:38:57');
INSERT INTO `nf_agent` VALUES ('OUT1648932416237039617', '22', '222', 'OUT1648932415217823746', '2023-04-20 14:11:38', '2023-09-07 09:29:12');
INSERT INTO `nf_agent` VALUES ('OUT1648933205034627073', '3', '3', 'OUT1648933203923136514', '2023-04-20 14:14:46', '2023-10-08 14:37:35');
INSERT INTO `nf_agent` VALUES ('OUT1710901644971995137', '啊', '啊', 'OUT1710901643768229890', '2023-10-08 14:15:14', '2023-10-08 14:15:14');
INSERT INTO `nf_agent` VALUES ('OUT1710908353446608897', '啊', '啊', 'OUT1710908254922407938', '2023-10-08 14:41:53', '2023-10-08 14:41:53');
INSERT INTO `nf_agent` VALUES ('OUT1710909310536450050', '啊', '啊', 'OUT1710909292781961217', '2023-10-08 14:45:41', '2023-10-08 14:45:41');
INSERT INTO `nf_agent` VALUES ('OUT1710916697469124610', '啊', '啊', 'OUT1710916660819296258', '2023-10-08 15:15:03', '2023-10-08 15:15:03');
INSERT INTO `nf_agent` VALUES ('OUT1710937043471630337', '321', '321', 'OUT1710936640969441281', '2023-10-08 16:35:53', '2023-10-08 16:35:53');
INSERT INTO `nf_agent` VALUES ('OUT1710937160702427137', '321', '321', 'OUT1710937153307869186', '2023-10-08 16:36:21', '2023-10-08 16:36:21');
INSERT INTO `nf_agent` VALUES ('OUT1711188717671014401', '1', '1', 'OUT1711188711341809665', '2023-10-09 09:15:57', '2023-10-09 09:15:57');
INSERT INTO `nf_agent` VALUES ('OUT1711197345660526593', '321', '321', 'OUT1711197341457833985', '2023-10-09 09:50:14', '2023-10-09 09:50:14');
INSERT INTO `nf_agent` VALUES ('OUT1711213253367939073', '1', '1', 'IN1722467909526175746', '2023-10-09 10:53:27', '2023-11-09 12:16:06');
INSERT INTO `nf_agent` VALUES ('OUT1722437367401345026', '321', '231', 'OUT1722437365480353794', '2023-11-09 10:14:04', '2023-11-27 12:35:32');
INSERT INTO `nf_agent` VALUES ('OUT1722483221558542337', '333', '3333', 'OUT1722483219675299841', '2023-11-09 13:16:17', '2023-11-09 13:16:17');
INSERT INTO `nf_agent` VALUES ('OUT1722494555444584449', '6666', '66666', 'OUT1722494553720725506', '2023-11-09 14:01:19', '2023-11-30 14:56:07');
INSERT INTO `nf_agent` VALUES ('OUT1722497174288310274', '99', '99', 'OUT1722497173004853250', '2023-11-09 14:11:43', '2023-11-09 14:11:43');

-- ----------------------------
-- Table structure for nf_agent_history
-- ----------------------------
DROP TABLE IF EXISTS `nf_agent_history`;
CREATE TABLE `nf_agent_history`  (
  `id` varchar(30) NOT NULL COMMENT '代理人ID',
  `realid` varchar(30) NULL DEFAULT NULL,
  `name` varchar(30) NULL DEFAULT NULL COMMENT '代理人姓名',
  `mobile` varchar(20) NULL DEFAULT NULL COMMENT '代理人联系方式',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB COMMENT = '代理人' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_agent_history
-- ----------------------------
INSERT INTO `nf_agent_history` VALUES ('1722493476111753217', 'IN1722493152181460993', '44', '44', 'IN1722493150700871682', '2023-11-09 13:55:45', '2023-11-09 13:56:34');
INSERT INTO `nf_agent_history` VALUES ('1722496914321154050', 'OUT1722494555444584449', '6666', '66666', 'OUT1722494553720725506', '2023-11-09 14:01:19', '2023-11-09 14:02:38');
INSERT INTO `nf_agent_history` VALUES ('1729430187387478017', 'IN1728994764240519169', '11', '11', 'OUT1711213251413393410', '2023-11-27 12:30:50', '2023-11-28 16:11:41');

-- ----------------------------
-- Table structure for nf_busin
-- ----------------------------
DROP TABLE IF EXISTS `nf_busin`;
CREATE TABLE `nf_busin`  (
  `id` varchar(30) NOT NULL COMMENT '业务ID',
  `btype` varchar(3) NOT NULL COMMENT '业务类型： 10：内网备案申报 20：外网备案申报 11：内网备案变更申报 21：外网备案变更申报 12：内网备案注销申报 22：外网备案注销申报',
  `status` varchar(3) NOT NULL COMMENT '业务状态 21：未完成  11：受理不通过  21：审核不通过 22：待受理  12：受理通过  22：审核通过',
  `rffsspid` varchar(30) NOT NULL COMMENT '备案ID',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rffsspid`(`rffsspid`) USING BTREE
) ENGINE = InnoDB COMMENT = '业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_busin
-- ----------------------------
INSERT INTO `nf_busin` VALUES ('IN1711552737691213826', '10', '22', 'IN1711552736189652994', '2023-10-10 09:22:26', '2023-10-10 09:22:26');
INSERT INTO `nf_busin` VALUES ('IN1711553304127774722', '10', '22', 'IN1711553303045644289', '2023-10-10 09:24:41', '2023-10-10 09:24:41');
INSERT INTO `nf_busin` VALUES ('IN1711553724241846274', '10', '22', 'IN1711553721641377793', '2023-10-10 09:26:22', '2023-10-10 09:45:05');
INSERT INTO `nf_busin` VALUES ('IN1719181222656024578', '10', '22', 'IN1719181221389344769', '2023-10-31 10:35:19', '2023-11-07 13:23:49');
INSERT INTO `nf_busin` VALUES ('IN1721766308836405250', '10', '22', 'IN1721766307360010242', '2023-11-07 13:47:32', '2023-11-07 14:11:44');
INSERT INTO `nf_busin` VALUES ('IN1721773956763832321', '10', '22', 'IN1721773955274854402', '2023-11-07 14:17:55', '2023-11-07 14:35:53');
INSERT INTO `nf_busin` VALUES ('IN1721774118886264833', '10', '22', 'IN1721774117204348929', '2023-11-07 14:18:34', '2023-11-09 10:07:11');
INSERT INTO `nf_busin` VALUES ('IN1721781166717874178', '10', '22', 'IN1721781165312782338', '2023-11-07 14:46:34', '2023-11-07 14:53:26');
INSERT INTO `nf_busin` VALUES ('IN1721789323603087361', '10', '22', 'IN1721789322218967042', '2023-11-07 15:18:59', '2023-11-07 15:19:34');
INSERT INTO `nf_busin` VALUES ('IN1722467372630097922', '11', '32', 'IN1722451371440021506', '2023-11-09 12:13:20', '2023-11-09 12:13:21');
INSERT INTO `nf_busin` VALUES ('IN1722467909526175746', '11', '12', 'OUT1711213248884228098', '2023-11-09 12:15:26', '2023-11-09 12:16:04');
INSERT INTO `nf_busin` VALUES ('IN1722470232101044226', '12', '12', 'IN1722451371440021506', '2023-11-09 12:24:40', '2023-11-09 12:26:47');
INSERT INTO `nf_busin` VALUES ('IN1722472308122140674', '10', '32', 'IN1722472306851266561', '2023-11-09 12:32:55', '2023-11-09 12:32:55');
INSERT INTO `nf_busin` VALUES ('IN1722473719442522114', '12', '32', 'OUT1711213248884228098', '2023-11-09 12:38:31', '2023-11-09 12:38:31');
INSERT INTO `nf_busin` VALUES ('IN1722478325870444545', '10', '22', 'IN1722478324092059649', '2023-11-09 12:56:50', '2023-11-09 12:57:33');
INSERT INTO `nf_busin` VALUES ('IN1729418143338696706', '10', '32', 'IN1729418142122348546', '2023-11-28 16:33:11', '2023-11-28 16:33:11');
INSERT INTO `nf_busin` VALUES ('IN1729418750321594369', '10', '12', 'IN1729418749122023425', '2023-11-28 16:35:36', '2023-11-28 16:35:36');
INSERT INTO `nf_busin` VALUES ('IN1729430191879577601', '11', '12', 'OUT1711213248884228098', '2023-11-28 17:21:04', '2023-11-28 17:21:18');
INSERT INTO `nf_busin` VALUES ('IN1730124716373520386', '10', '32', 'IN1730124714431557633', '2023-11-30 15:20:51', '2023-11-30 15:20:51');
INSERT INTO `nf_busin` VALUES ('IN1730126504241737729', '10', '22', 'IN1730127187040874498', '2023-11-30 15:27:57', '2023-11-30 15:30:41');
INSERT INTO `nf_busin` VALUES ('IN1730129273900052481', '10', '22', 'IN1730129271211503618', '2023-11-30 15:38:58', '2023-11-30 15:38:58');
INSERT INTO `nf_busin` VALUES ('IN1730131099617705985', '10', '22', 'IN1730131097608634370', '2023-11-30 15:46:13', '2023-11-30 15:46:13');
INSERT INTO `nf_busin` VALUES ('OUT1722437365480353794', '21', '22', 'OUT1722437361831309313', '2023-11-09 10:14:04', '2023-11-27 12:35:32');
INSERT INTO `nf_busin` VALUES ('OUT1722483219675299841', '20', '32', 'OUT1722483214419836929', '2023-11-09 13:16:16', '2023-11-09 13:16:16');
INSERT INTO `nf_busin` VALUES ('OUT1722494553720725506', '21', '22', 'OUT1722494550411419650', '2023-11-09 14:01:19', '2023-11-30 14:56:06');
INSERT INTO `nf_busin` VALUES ('OUT1722497173004853250', '20', '32', 'OUT1722497169720713217', '2023-11-09 14:11:43', '2023-11-09 14:11:43');

-- ----------------------------
-- Table structure for nf_busin_history
-- ----------------------------
DROP TABLE IF EXISTS `nf_busin_history`;
CREATE TABLE `nf_busin_history`  (
  `id` varchar(30) NOT NULL COMMENT '业务ID',
  `realid` varchar(30) NULL DEFAULT NULL,
  `btype` varchar(3) NOT NULL COMMENT '业务类型： 10：内网备案申报 20：外网备案申报 11：内网备案变更申报 21：外网备案变更申报 12：内网备案注销申报 22：外网备案注销申报',
  `status` varchar(3) NOT NULL COMMENT '业务状态 21：未完成  11：受理不通过  21：审核不通过 22：待受理  12：受理通过  22：审核通过',
  `rffsspid` varchar(30) NOT NULL COMMENT '备案ID',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rffsspid`(`rffsspid`) USING BTREE
) ENGINE = InnoDB COMMENT = '业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_busin_history
-- ----------------------------
INSERT INTO `nf_busin_history` VALUES ('1722493478104047617', 'IN1722493150700871682', '10', '22', 'IN1722493148805046274', '2023-11-09 13:55:44', '2023-11-09 13:56:34');
INSERT INTO `nf_busin_history` VALUES ('1722496916271505410', 'OUT1722494553720725506', '20', '22', 'OUT1722494550411419650', '2023-11-09 14:01:19', '2023-11-09 14:02:37');
INSERT INTO `nf_busin_history` VALUES ('1729430189144891394', 'OUT1711213251413393410', '21', '22', 'OUT1711213248884228098', '2023-10-09 10:53:27', '2023-11-28 16:11:41');

-- ----------------------------
-- Table structure for nf_checked
-- ----------------------------
DROP TABLE IF EXISTS `nf_checked`;
CREATE TABLE `nf_checked`  (
  `id` varchar(30) NOT NULL COMMENT '受理审核ID',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `name` varchar(30) NOT NULL COMMENT '受理审核人员',
  `cresult` varchar(2) NULL DEFAULT NULL COMMENT '受理审核结果： 1 为不通过  2  为通过',
  `opinions` varchar(3000) NULL DEFAULT NULL COMMENT '受理审核意见',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '受理审核时间',
  `ctype` varchar(2) NULL DEFAULT NULL COMMENT '受理审核类型: 1 为受理    2  为审核',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '操作记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_checked
-- ----------------------------
INSERT INTO `nf_checked` VALUES ('0', 'IN1730129273900052481', '2', '2', '2', '2023-11-30 00:00:00', '2', '2023-11-30 15:40:29', '2023-11-30 15:40:29');
INSERT INTO `nf_checked` VALUES ('IN1648191796623077377', 'IN1648170704642666498', '1', '2', '1', '2023-04-17 00:00:00', '1', '2023-04-18 13:08:41', '2023-04-18 13:15:55');
INSERT INTO `nf_checked` VALUES ('IN1648193617223643137', 'IN1648170704642666498', '22', '2', '22', '2023-04-17 00:00:00', '2', '2023-04-18 13:15:55', '2023-04-18 13:15:55');
INSERT INTO `nf_checked` VALUES ('IN1648596773296353282', 'IN1648596667465674754', '1', '2', '1', '2023-04-18 00:00:00', '1', '2023-04-19 15:57:55', '2023-04-19 15:57:55');
INSERT INTO `nf_checked` VALUES ('IN1648930674116096002', 'OUT1648929887864451074', '1', '2', '1', '2023-04-20 00:00:00', '1', '2023-04-20 14:04:43', '2023-04-20 14:05:03');
INSERT INTO `nf_checked` VALUES ('IN1648930758287388673', 'OUT1648929887864451074', '1', '2', '1', '2023-04-20 00:00:00', '2', '2023-04-20 14:05:03', '2023-04-20 14:05:03');
INSERT INTO `nf_checked` VALUES ('IN1648932585221353473', 'OUT1648932415217823746', '11', '2', '11', '2023-04-20 00:00:00', '1', '2023-04-20 14:12:19', '2023-09-07 09:29:12');
INSERT INTO `nf_checked` VALUES ('IN1654369635978428417', 'OUT1648933203923136514', '213', '2', '321', '2023-05-04 00:00:00', '1', '2023-05-05 14:17:13', '2023-09-06 17:18:05');
INSERT INTO `nf_checked` VALUES ('IN1654369710410547202', 'OUT1648933203923136514', '321', '2', '312', '2023-05-04 00:00:00', '2', '2023-05-05 14:17:30', '2023-09-06 17:18:06');
INSERT INTO `nf_checked` VALUES ('IN1699595639570976769', 'OUT1648932415217823746', '1', '1', '1', '2023-09-07 00:00:00', '2', '2023-09-07 09:29:12', '2023-09-07 09:29:12');
INSERT INTO `nf_checked` VALUES ('IN1711204438719324162', 'IN1711204213082546178', '1231', '2', '321', '2023-10-04 00:00:00', '1', '2023-10-09 10:18:25', '2023-10-09 10:22:42');
INSERT INTO `nf_checked` VALUES ('IN1711205513958514690', 'IN1711204213082546178', '1231', '2', '321', '2023-10-05 00:00:00', '2', '2023-10-09 10:22:42', '2023-10-09 10:22:42');
INSERT INTO `nf_checked` VALUES ('IN1711216723563102209', 'OUT1711213251413393410', '112', '2', '112', '2023-10-09 00:00:00', '1', '2023-10-09 11:07:14', '2023-11-28 16:11:41');
INSERT INTO `nf_checked` VALUES ('IN1711216817268047874', 'OUT1711213251413393410', '122', '2', '122', '2023-10-09 00:00:00', '2', '2023-10-09 11:07:37', '2023-11-28 16:11:42');
INSERT INTO `nf_checked` VALUES ('IN1711558465751523329', 'IN1711553724241846274', '111', '2', '111', '2023-10-10 00:00:00', '1', '2023-10-10 09:45:12', '2023-10-10 09:45:12');
INSERT INTO `nf_checked` VALUES ('IN1721760121344593921', 'IN1719181222656024578', '1212', '2', '21', '2023-11-07 00:00:00', '1', '2023-11-07 13:22:56', '2023-11-07 13:23:49');
INSERT INTO `nf_checked` VALUES ('IN1721760344561258498', 'IN1719181222656024578', '123', '2', '321', '2023-11-07 00:00:00', '2', '2023-11-07 13:23:50', '2023-11-07 13:23:50');
INSERT INTO `nf_checked` VALUES ('IN1721766398154108930', 'IN1721766308836405250', '11', '2', '11', '2023-11-07 00:00:00', '1', '2023-11-07 13:47:53', '2023-11-07 14:11:45');
INSERT INTO `nf_checked` VALUES ('IN1721766496359542785', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:48:16', '2023-11-07 13:48:16');
INSERT INTO `nf_checked` VALUES ('IN1721766752195231745', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:49:17', '2023-11-07 13:49:17');
INSERT INTO `nf_checked` VALUES ('IN1721767458532876290', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:52:06', '2023-11-07 13:52:06');
INSERT INTO `nf_checked` VALUES ('IN1721768728899416066', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:57:09', '2023-11-07 13:57:09');
INSERT INTO `nf_checked` VALUES ('IN1721768979475521537', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:58:08', '2023-11-07 13:58:08');
INSERT INTO `nf_checked` VALUES ('IN1721769138649366529', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 13:58:46', '2023-11-07 13:58:46');
INSERT INTO `nf_checked` VALUES ('IN1721769453834498049', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 14:00:01', '2023-11-07 14:00:01');
INSERT INTO `nf_checked` VALUES ('IN1721770172935393281', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 14:02:53', '2023-11-07 14:02:53');
INSERT INTO `nf_checked` VALUES ('IN1721772406553268226', 'IN1721766308836405250', '11', '2', '111', '2023-11-07 00:00:00', '2', '2023-11-07 14:11:45', '2023-11-07 14:11:45');
INSERT INTO `nf_checked` VALUES ('IN1721774210833797122', 'IN1721774118886264833', '321', '2', '321', '2023-11-07 00:00:00', '1', '2023-11-07 14:18:56', '2023-11-09 10:07:12');
INSERT INTO `nf_checked` VALUES ('IN1721774275874869249', 'IN1721773956763832321', '321', '2', '321', '2023-11-07 00:00:00', '1', '2023-11-07 14:19:11', '2023-11-07 14:35:54');
INSERT INTO `nf_checked` VALUES ('IN1721777907127046145', 'IN1721773956763832321', '213', '2', '321', '2023-11-07 00:00:00', '2', '2023-11-07 14:33:37', '2023-11-07 14:33:37');
INSERT INTO `nf_checked` VALUES ('IN1721778482317176833', 'IN1721773956763832321', '213', '2', '321', '2023-11-07 00:00:00', '2', '2023-11-07 14:35:54', '2023-11-07 14:35:54');
INSERT INTO `nf_checked` VALUES ('IN1721781268727541761', 'IN1721781166717874178', '213', '2', '321', '2023-11-07 00:00:00', '1', '2023-11-07 14:46:58', '2023-11-07 14:53:27');
INSERT INTO `nf_checked` VALUES ('IN1721781353607671809', 'IN1721781166717874178', '13', '2', '21', '2023-11-07 00:00:00', '2', '2023-11-07 14:47:19', '2023-11-07 14:47:19');
INSERT INTO `nf_checked` VALUES ('IN1721782366230081537', 'IN1721781166717874178', '13', '2', '21', '2023-11-07 00:00:00', '2', '2023-11-07 14:51:20', '2023-11-07 14:51:20');
INSERT INTO `nf_checked` VALUES ('IN1721782899426820097', 'IN1721781166717874178', '13', '2', '21', '2023-11-07 00:00:00', '2', '2023-11-07 14:53:27', '2023-11-07 14:53:27');
INSERT INTO `nf_checked` VALUES ('IN1721789388220534785', 'IN1721789323603087361', '321', '2', '321', '2023-11-07 00:00:00', '1', '2023-11-07 15:19:14', '2023-11-07 15:19:34');
INSERT INTO `nf_checked` VALUES ('IN1721789473780142081', 'IN1721789323603087361', '321', '2', '321', '2023-11-07 00:00:00', '2', '2023-11-07 15:19:35', '2023-11-07 15:19:35');
INSERT INTO `nf_checked` VALUES ('IN1722435640828686338', 'IN1721774118886264833', '12', '2', '21', '2023-11-09 00:00:00', '2', '2023-11-09 10:07:13', '2023-11-09 10:07:13');
INSERT INTO `nf_checked` VALUES ('IN1722437931564593153', 'OUT1722437365480353794', '321ee', '2', '321ee', '2023-11-09 00:00:00', '1', '2023-11-09 10:16:19', '2023-11-27 12:35:33');
INSERT INTO `nf_checked` VALUES ('IN1722437997524217857', 'OUT1722437365480353794', '321e', '2', '321e', '2023-11-09 00:00:00', '2', '2023-11-09 10:16:35', '2023-11-27 12:35:33');
INSERT INTO `nf_checked` VALUES ('IN1722468077508050946', 'IN1722467909526175746', '11', '2', '111', '2023-11-09 00:00:00', '1', '2023-11-09 12:16:06', '2023-11-09 12:16:06');
INSERT INTO `nf_checked` VALUES ('IN1722470769408163841', 'IN1722470232101044226', '11', '2', '11', '2023-11-09 00:00:00', '1', '2023-11-09 12:26:48', '2023-11-09 12:26:48');
INSERT INTO `nf_checked` VALUES ('IN1722478433039106049', 'IN1722478325870444545', '发的是多少', '2', '大萨达', '2023-11-09 00:00:00', '1', '2023-11-09 12:57:15', '2023-11-09 12:57:34');
INSERT INTO `nf_checked` VALUES ('IN1722478513477468161', 'IN1722478325870444545', '萨达', '2', '大萨', '2023-11-09 00:00:00', '2', '2023-11-09 12:57:34', '2023-11-09 12:57:34');
INSERT INTO `nf_checked` VALUES ('IN1722493263250825218', 'IN1722493150700871682', '1144', '2', '444', '2023-11-09 00:00:00', '1', '2023-11-09 13:56:11', '2023-11-09 13:56:35');
INSERT INTO `nf_checked` VALUES ('IN1722493363494690818', 'IN1722493150700871682', '444', '2', '444', '2023-11-09 00:00:00', '2', '2023-11-09 13:56:35', '2023-11-09 13:56:35');
INSERT INTO `nf_checked` VALUES ('IN1722494818909790210', 'OUT1722494553720725506', '66667', '2', '66667', '2023-11-09 00:00:00', '1', '2023-11-09 14:02:22', '2023-11-30 14:56:07');
INSERT INTO `nf_checked` VALUES ('IN1722494889214713858', 'OUT1722494553720725506', '666', '2', '666', '2023-11-09 00:00:00', '2', '2023-11-09 14:02:39', '2023-11-30 14:56:08');
INSERT INTO `nf_checked` VALUES ('IN1729430254865440769', 'IN1729430191879577601', '1', '2', '1', '2023-11-28 00:00:00', '1', '2023-11-28 17:21:19', '2023-11-28 17:21:19');
INSERT INTO `nf_checked` VALUES ('IN1730131147722178562', 'IN1730131099617705985', '3', '2', '3', '2023-11-30 00:00:00', '1', '2023-11-30 15:46:31', '2023-11-30 15:46:31');
INSERT INTO `nf_checked` VALUES ('IN1730131206870253569', 'IN1730131099617705985', '4', '2', '4', '2023-11-30 00:00:00', '2', '2023-11-30 15:46:42', '2023-11-30 15:46:42');

-- ----------------------------
-- Table structure for nf_inbound_and_outbound
-- ----------------------------
DROP TABLE IF EXISTS `nf_inbound_and_outbound`;
CREATE TABLE `nf_inbound_and_outbound`  (
  `id` bigint(0) NOT NULL,
  `rffssp_id` varchar(30) NULL DEFAULT NULL COMMENT '冷藏备案id',
  `type` int(0) NULL DEFAULT NULL COMMENT '0入库1出库',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `types_of` int(0) NULL DEFAULT NULL COMMENT '1食品2食用农产品',
  `num` bigint(0) NULL DEFAULT NULL COMMENT '数量',
  `unit` varchar(255) NULL DEFAULT NULL COMMENT '单位',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_inbound_and_outbound
-- ----------------------------
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153108220424193, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 10:34:57', '2023-04-18 10:37:56');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153909571563522, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 10:38:08', '2023-04-18 10:38:08');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153913103167489, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 2, 5, '6', '2023-04-18 10:38:09', '2023-04-18 10:38:09');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153916500553729, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 2, 5, '6', '2023-04-18 10:38:10', '2023-04-18 10:38:10');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153919151353858, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 10:38:10', '2023-04-18 10:38:10');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153921047179265, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 1, 9, '6', '2023-04-18 10:38:11', '2023-04-18 10:38:11');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153922943004673, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 10:38:11', '2023-04-18 10:38:11');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153925388283905, 'IN1648170703413735425', 0, '2023-04-18 00:00:00', 2, 5, '6', '2023-04-18 10:38:12', '2023-04-18 10:38:12');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153926952759297, 'OUT1648200230403731457', 0, '2023-04-18 00:00:00', 2, 1, '6', '2023-04-18 10:38:12', '2023-04-18 10:38:12');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153928743727105, 'OUT1648200230403731457', 0, '2023-04-18 00:00:00', 2, 5, '6', '2023-04-18 10:38:12', '2023-04-18 10:38:12');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648153931197394946, 'OUT1648200230403731457', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 10:38:13', '2023-04-18 10:38:13');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648163272826761217, 'OUT1648200230403731457', 0, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 11:15:20', '2023-04-18 11:15:20');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648164264150482945, 'OUT1648200230403731457', 1, '2023-04-18 00:00:00', 1, 5, '6', NULL, NULL);
INSERT INTO `nf_inbound_and_outbound` VALUES (1648164607890452482, 'OUT1648200230403731457', 1, '2023-04-18 00:00:00', 1, 5, '6', '2023-04-18 11:20:39', '2023-04-18 11:20:39');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648523680376836098, 'IN1648170703413735425', 0, '2023-04-19 00:00:00', 2, 2, '3', '2023-04-19 11:07:28', '2023-04-19 11:07:28');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648931553615507457, 'OUT1648929887864451074', 0, '2023-04-20 00:00:00', 1, 1, '1', '2023-04-20 14:08:13', '2023-04-20 14:08:13');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648935524405047298, 'OUT1648929887864451074', 1, '2023-04-20 00:00:00', 2, 1, '1', '2023-04-20 14:23:59', '2023-04-20 14:23:59');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648943107035590658, 'OUT1648929887864451074', 0, NULL, NULL, 1, '1', '2023-04-20 14:54:07', '2023-04-20 14:54:07');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648960170798014465, 'OUT1648929887864451074', 0, NULL, NULL, 1, '1', '2023-04-20 16:01:56', '2023-04-20 16:01:56');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648961185475649538, 'OUT1648929887864451074', 1, '2023-04-13 00:00:00', 2, 1, '1', '2023-04-20 16:05:57', '2023-04-20 16:05:57');
INSERT INTO `nf_inbound_and_outbound` VALUES (1648963556528283649, 'OUT1648929887864451074', 0, '2023-04-05 00:00:00', 2, NULL, '1', '2023-04-20 16:15:23', '2023-04-20 16:15:23');
INSERT INTO `nf_inbound_and_outbound` VALUES (1699316446937366530, 'OUT1648933203923136514', 0, '2023-07-04 00:00:00', 1, 1, '1', '2023-09-06 14:59:47', '2023-09-06 14:59:47');
INSERT INTO `nf_inbound_and_outbound` VALUES (1699316499844317186, 'OUT1648933203923136514', 0, '2023-09-01 00:00:00', 1, 1, '1', '2023-09-06 15:00:00', '2023-09-06 15:00:00');
INSERT INTO `nf_inbound_and_outbound` VALUES (1699316536578031617, 'OUT1648933203923136514', 0, '2023-09-02 00:00:00', 2, 1, '1', '2023-09-06 15:00:09', '2023-09-06 15:00:09');
INSERT INTO `nf_inbound_and_outbound` VALUES (1699316572548382722, 'OUT1648933203923136514', 1, '2023-09-02 00:00:00', 1, 1, '1', '2023-09-06 15:00:17', '2023-09-06 15:00:17');
INSERT INTO `nf_inbound_and_outbound` VALUES (1699317648907452418, 'IN1648170704642666498', 1, '2023-09-02 00:00:00', 1, 1, '1', '2023-09-06 15:04:34', '2023-09-06 15:04:34');
INSERT INTO `nf_inbound_and_outbound` VALUES (1722499777579556865, 'OUT1711213251413393410', 0, '2023-11-09 00:00:00', 2, 1, '1', '2023-11-09 14:22:04', '2023-11-09 14:22:04');

-- ----------------------------
-- Table structure for nf_material
-- ----------------------------
DROP TABLE IF EXISTS `nf_material`;
CREATE TABLE `nf_material`  (
  `id` varchar(30) NOT NULL COMMENT '材料ID',
  `mtype` varchar(3) NOT NULL COMMENT '材料类型：10 冷藏冷冻贮存场所布局图 20 法定代表人或者负责人身份证明复印件人像面 21 法定代表人或者负责人身份证明复印件国徽面 30 所提交资料真实性承诺书',
  `morder` int(0) NULL DEFAULT NULL COMMENT '同材料类型的顺序号',
  `mpath` varchar(400) NOT NULL COMMENT '材料地址',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '材料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_material
-- ----------------------------

-- ----------------------------
-- Table structure for nf_material_history
-- ----------------------------
DROP TABLE IF EXISTS `nf_material_history`;
CREATE TABLE `nf_material_history`  (
  `id` varchar(30) NOT NULL COMMENT '材料ID',
  `realid` varchar(30) NULL DEFAULT NULL,
  `mtype` varchar(3) NOT NULL COMMENT '材料类型：10 冷藏冷冻贮存场所布局图 20 法定代表人或者负责人身份证明复印件人像面 21 法定代表人或者负责人身份证明复印件国徽面 30 所提交资料真实性承诺书',
  `morder` int(0) NULL DEFAULT NULL COMMENT '同材料类型的顺序号',
  `mpath` varchar(400) NOT NULL COMMENT '材料地址',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '材料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_material_history
-- ----------------------------

-- ----------------------------
-- Table structure for nf_opt
-- ----------------------------
DROP TABLE IF EXISTS `nf_opt`;
CREATE TABLE `nf_opt`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '操作记录ID',
  `businid` varchar(30) NOT NULL COMMENT '业务id: NfBusinEntity id',
  `module` varchar(30) NOT NULL COMMENT '操作模块名称',
  `ouser` bigint(0) NULL DEFAULT NULL COMMENT '操作人员',
  `ip` varchar(20) NULL DEFAULT NULL COMMENT 'IP地址',
  `duration` bigint(0) NULL DEFAULT NULL COMMENT '执行时长(毫秒)',
  `otime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `businid`(`businid`) USING BTREE
) ENGINE = InnoDB COMMENT = '操作记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_opt
-- ----------------------------

-- ----------------------------
-- Table structure for nf_rffssp
-- ----------------------------
DROP TABLE IF EXISTS `nf_rffssp`;
CREATE TABLE `nf_rffssp`  (
  `id` varchar(30) NOT NULL COMMENT '冷藏冷冻食品贮存服务提供者ID',
  `status` tinyint(0) NOT NULL COMMENT '状态 1 录入  2 提交  3 业务完成',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  `valid` int(0) NOT NULL COMMENT '是否有效：1有效 0无效',
  `issueorg` varchar(10) NULL DEFAULT NULL COMMENT '管理机构ID',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '办理备案日期',
  `apply_name` varchar(255) NULL DEFAULT NULL COMMENT '申请人姓名',
  `apply_contact_info` varchar(255) NULL DEFAULT NULL COMMENT '申请人联系方式',
  `unisc_id` varchar(255) NULL DEFAULT NULL COMMENT '统一社会信用代码',
  `storage_ent_name` varchar(255) NULL DEFAULT NULL COMMENT '从事冷藏冷冻食品贮存业务的非食品生产经营者名称',
  `le_rep` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人（负责人）',
  `le_rep_no` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人（负责人）身份证号码',
  `contract_name` varchar(255) NULL DEFAULT NULL COMMENT '联系人',
  `contract_tel` varchar(255) NULL DEFAULT NULL COMMENT '联系电话',
  `storage_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库名称',
  `storage_province` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）代码',
  `storage_prov_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）',
  `storage_city` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）代码',
  `storage_city_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）',
  `storage_county` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）代码',
  `storage_county_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）',
  `storage_address` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库详细地址',
  `storage_power_ton` varchar(255) NULL DEFAULT NULL COMMENT '贮存能力（单位：吨）',
  `storage_power_cubic_meter` varchar(255) NULL DEFAULT NULL COMMENT '贮存能力（单位：立方米）',
  `storage_amount` varchar(20) NULL DEFAULT NULL COMMENT '冷库数量',
  `rec_num` varchar(255) NULL DEFAULT NULL COMMENT '备案编号',
  `rec_time` datetime(0) NULL DEFAULT NULL COMMENT '备案日期',
  `entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  `safety_standards` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）是否符合食品安全标准',
  `storage_area` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存面积',
  `storage_capacity` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存容积',
  `equipment_name_specification` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）冷藏冷冻设施、设备名称规格及数量',
  `humidity_control_range` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）温度、湿度控制范围',
  `bumber_explicit_thermometers` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）可正确显示内部温度的温度计和外显式温度计数量',
  `keep_clean` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存设备、容器和工具是否无毒无害、保持清洁',
  `is_ground` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）是否分区分架分类存放食品，是否离地离墙10cm',
  `is_disinfect` varchar(255) NULL DEFAULT NULL COMMENT '是否有校验消毒清洁维护制度及记录',
  `other_categories` varchar(255) NULL DEFAULT NULL COMMENT '其他非食品类贮存品类别',
  `remarks` varchar(255) NULL DEFAULT NULL COMMENT '备注',
  `canclecause` text NULL COMMENT '注销原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '冷藏冷冻食品贮存服务提供者' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_rffssp
-- ----------------------------
INSERT INTO `nf_rffssp` VALUES ('IN1648170703413735425', 3, '2023-04-18 11:44:52', '2023-04-18 13:15:54', 1, '231000', '2023-03-29 00:00:00', '测试备案1', '1', '1', '1', '1', '1', '1', '1', '1', '230000', NULL, '230100', NULL, '230104', NULL, '1', '1', '1', NULL, '1', '2023-04-05 00:00:00', '2023-04-05 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', NULL, NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1648596666408710145', 2, '2023-04-19 15:57:29', '2023-04-19 15:57:54', 1, '230800', '2023-04-18 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '230000', NULL, '230300', NULL, '230303', NULL, '1', '1', '1', NULL, '1', '2023-04-19 00:00:00', '2023-04-19 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699594862622298114', 3, '2023-09-07 09:26:07', '2023-09-07 09:26:07', 1, '230400', '2023-09-06 00:00:00', '1', '1', '121!', '1', '1', '1', '1', '1', '1', '230000', NULL, '230200', NULL, '230204', NULL, '1', '1', '1', NULL, '1', '2023-09-13 00:00:00', '2023-09-13 00:00:00', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699595301799481345', 3, '2023-09-07 09:27:52', '2023-09-07 09:27:52', 1, '230500', '2023-09-20 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '230000', NULL, '230200', NULL, '230203', NULL, '1', '1', '1', NULL, '1', '2023-09-05 00:00:00', '2023-08-29 00:00:00', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699596665346740226', 3, '2023-09-07 09:33:17', '2023-09-07 09:33:17', 1, '230201', '2023-08-30 00:00:00', '321', '321', '1321', '321', '321', '3213', '321', '321', '321', '230000', NULL, '230200', NULL, '230204', NULL, '321', '321', '321', NULL, '321', '2023-09-05 00:00:00', '2023-08-30 00:00:00', '0', '321', '321', '321', '321', '321', '1', '0', '0', '32', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699597243682541569', 3, '2023-09-07 09:35:35', '2023-09-07 09:35:35', 1, '230500', '2023-09-13 00:00:00', '456', '456', '456', '4546', '456', '456', '456', '456', '456', '230000', NULL, '230100', NULL, '230104', NULL, '456', '456', '456', NULL, '456', '2023-09-12 00:00:00', '2023-09-06 00:00:00', '0', '456', '456', '456', '456', '456', '1', '1', '0', '456', '456', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699598187468050433', 3, '2023-09-07 09:39:20', '2023-09-07 09:39:20', 1, '', '2023-09-05 00:00:00', '890', '890', '890', '890', '890', '890', '890', '890', '890', '230000', NULL, '230200', NULL, '230203', NULL, '890', '890', '890', NULL, '890', '2023-09-07 00:00:00', '2023-08-29 00:00:00', '0', '890', '890', '890', '890', '890', '0', '0', '0', '890', '890', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699600770647609346', 3, '2023-09-07 09:49:35', '2023-09-07 09:49:35', 1, '230400', '2023-09-13 00:00:00', 'qwe', 'qwe', 'wqe', 'ewq', 'weq', 'eqw', 'qwe', 'qwe', 'weqw', '230000', NULL, '230100', NULL, '230103', NULL, 'qwe', 'qwe', 'qwe', NULL, 'weq', '2023-09-07 00:00:00', '2023-09-12 00:00:00', '0', 'qwe', 'qwe', 'qwe', 'qwe', 'qe', '0', '0', '0', 'wqeq', 'ewq', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699601416792723458', 3, '2023-09-07 09:52:09', '2023-09-07 09:52:09', 1, '232700', '2023-09-07 00:00:00', '34', '34', '43', '34', '34', '34', '34', '34', '34', '230000', NULL, '230100', NULL, '230108', NULL, '34', '34', '34', NULL, '43', '2023-09-07 00:00:00', '2023-09-07 00:00:00', '0', '43', '34', '34', '34', '34', '0', '0', '0', '34', '34', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699602573573378049', 3, '2023-09-07 09:56:45', '2023-09-07 09:56:45', 1, '230500', '2023-09-07 00:00:00', '567', '567', '7658', '567', '567', '567', '567', '567', '657', '230000', NULL, '230100', NULL, '230108', NULL, '567', '567', '567', NULL, '657', '2023-09-13 00:00:00', '2023-09-07 00:00:00', '0', '567', '567', '567', '567', '567', '0', '0', '0', '567', '567', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699603689463762945', 3, '2023-09-07 10:01:11', '2023-09-07 10:01:11', 1, '230700', '2023-09-06 00:00:00', '3', '3', '342', '3', '3', '3', '3', '3', '3', '230000', NULL, '230200', NULL, '230206', NULL, '3', '3', '3', NULL, '3', '2023-09-13 00:00:00', '2023-09-07 00:00:00', '0', '3', '3', '3', '3', '3', '0', '1', '0', '3', '3', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699605032941277186', 3, '2023-09-07 10:06:32', '2023-09-07 10:06:32', 1, '230600', '2023-09-06 00:00:00', '234', '32', '1234', '432', '432', '23', '324', '234', '432432', '230000', NULL, '230100', NULL, '230104', NULL, '324', '234', '234', NULL, '432', '2023-09-05 00:00:00', '2023-09-05 00:00:00', '0', '234', '234', '234', '432', '432', '0', '0', '0', '432', '432', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1699606573240700930', 3, '2023-09-07 10:12:39', '2023-09-07 10:12:39', 1, '230600', '2023-09-13 00:00:00', '123', '321', '231', '312', '321', '321', '132', '321', '213', '230000', NULL, '230200', NULL, '230205', NULL, '123', '12312', '123', NULL, '321', '2023-09-27 00:00:00', '2023-09-21 00:00:00', '0', '312', '3123', '321', '2131', '31', '0', '0', '0', '123', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1711200193827823618', 2, '2023-10-09 10:01:33', '2023-10-09 10:01:33', 1, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1711204211929112578', 3, '2023-10-09 10:17:31', '2023-10-09 10:22:41', 1, '230500', '2023-10-11 00:00:00', '321', '321', '123', '321', '321', '321', '321', '321', '321', '230000', NULL, '230300', NULL, '230305', NULL, '321', '321', '321', NULL, '321', '2023-10-11 00:00:00', '2023-10-05 00:00:00', '0', '321', '321', '321', '321', '321', '1', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1711552736189652994', 2, '2023-10-10 09:22:26', '2023-10-10 09:22:26', 1, '230500', '2023-10-12 00:00:00', '321', '321', '321', '321', '321', '3213', '321', '321', '321', '230000', NULL, '230100', NULL, '230104', NULL, '3213', '321', '321', NULL, '213213', '2023-10-10 00:00:00', '2023-10-10 00:00:00', '1', '312', '321', '321', '231', '123', '1', '1', '1', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1711553303045644289', 2, '2023-10-10 09:24:41', '2023-10-10 09:24:41', 1, '230600', '2023-10-10 00:00:00', '321', '321', '21321', '321', '321', '3213', '321', '321', '321', '230000', NULL, '230200', NULL, '230206', NULL, '321', '321', '321', NULL, '321', '2023-10-11 00:00:00', '2023-10-11 00:00:00', '1', '321', '321', '321', '321', '321', '1', '0', '0', '321', '213', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1711553721641377793', 2, '2023-10-10 09:26:21', '2023-10-10 09:45:04', 1, '230600', '2023-10-03 00:00:00', '312', '32', '24313', '321', '321', '3', '32', '321', '321', '230000', NULL, '230100', NULL, '230104', NULL, '321', '3221', '321', NULL, '321', '2023-10-11 00:00:00', '2023-10-11 00:00:00', '0', '321', '321', '321', '312321', '321', '1', '1', '0', '321', '21', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1719181221389344769', 3, '2023-10-31 10:35:19', '2023-11-07 13:23:48', 1, '230800', '2023-10-11 00:00:00', '111', '111', '11', '111', '11', '11', '111', '11', '111', '230000', NULL, '230600', NULL, '230604', NULL, '1', '1', '11', NULL, '11', '2023-10-11 00:00:00', '2023-10-19 00:00:00', '1', '1', '1', '1', '1', '1', '0', '1', '0', '11', '111', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1721766307360010242', 3, '2023-11-07 13:47:31', '2023-11-07 14:11:44', 1, '230600', '2023-10-30 00:00:00', '2', '21', '12', '21', '21', '21', '21', '21', '12', '230000', NULL, '230600', NULL, '230622', NULL, '21', '21', '21', NULL, '21', '2023-11-06 00:00:00', '2023-11-06 00:00:00', '0', '21', '21', '21', '21', '21', '0', '0', '0', '21', '21', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1721773955274854402', 3, '2023-11-07 14:17:55', '2023-11-07 14:35:52', 1, '230000', '2023-11-22 00:00:00', '321', '321', '21312', '321', '312', '321', '321', '321', '32', '230000', NULL, '230300', NULL, '230305', NULL, '321', '321', '321', NULL, '321', '2023-10-31 00:00:00', '2023-11-08 00:00:00', '0', '321', '321', '3213', '12', '321', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1721774117204348929', 3, '2023-11-07 14:18:33', '2023-11-09 10:07:11', 1, '230000', '2023-11-14 00:00:00', '321', '31', '321', '312', '2131', '321', '321', '3213', '3221', '230000', NULL, '230400', NULL, '230407', NULL, '321', '31', '321', NULL, '321', '2023-11-22 00:00:00', '2023-11-15 00:00:00', '0', '21', '312', '321', '213', '13', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1721781165312782338', 3, '2023-11-07 14:46:34', '2023-11-07 14:53:25', 1, '230000', '2023-11-14 00:00:00', '312', '321', '23132132131', '321', '321', '312', '321', '312', '321', '230000', '黑龙江省', '230300', '鸡西市', '230307', '麻山区', '321', '312', '321', NULL, '321', '2023-11-08 00:00:00', '2023-11-07 00:00:00', '0', '32', '31', '321', '321', '321', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1721789322218967042', 3, '2023-11-07 15:18:58', '2023-11-07 15:19:33', 1, '230000', '2023-11-08 00:00:00', '321', '321', '21312', '321', '321', '31', '321', '321', '321', '230000', '黑龙江省', '230300', '鸡西市', '230305', '梨树区', '321', '3213', '321', NULL, '321', '2023-11-16 00:00:00', '2023-11-08 00:00:00', '0', '1', '321', '213', '21', '321', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1722472306851266561', 2, '2023-11-09 12:32:55', '2023-11-09 12:32:55', 1, '230000', '2023-11-08 00:00:00', '1', '1', '11', '1', '1', '1', '1', '1', '1', '230000', '黑龙江省', '230400', '鹤岗市', '230407', '兴山区', '1', '1', '1', NULL, '1', '2023-11-14 00:00:00', '2023-11-09 00:00:00', '0', '1', '1', '1', '1', '1', '0', '0', '0', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1729418142122348546', 2, '2023-11-28 16:33:11', '2023-11-28 16:33:11', 1, '', NULL, NULL, NULL, '111111888111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1729418749122023425', 2, '2023-11-28 16:35:35', '2023-11-28 16:35:35', 1, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1730124714431557633', 2, '2023-11-30 15:20:51', '2023-11-30 15:20:51', 1, '230000', '2023-11-15 00:00:00', '1', '1', '111111111111111111', '1', '1', '1', '1', '1', '1', '230000', '黑龙江省', '230400', '鹤岗市', '230406', '东山区', '1', NULL, NULL, NULL, '11', '2023-11-22 00:00:00', '2023-11-14 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '1', NULL, NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1730126502262026241', 3, '2023-11-30 15:27:57', '2023-11-30 15:27:57', 1, '230000', '2023-11-07 00:00:00', '312', '312', '21', '321', '321', '321', '321', '312', '12', '230000', '黑龙江省', '230300', '鸡西市', '230307', '麻山区', '321', '321', '321', '2', '321', '2023-11-13 00:00:00', '2023-11-07 00:00:00', '0', NULL, NULL, '2', '22', '2', '0', '0', '0', '3213', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1730127187040874498', 3, '2023-11-30 15:30:40', '2023-11-30 15:30:40', 1, '230000', '2023-11-07 00:00:00', '321', '31', '321', '31', '321', '312', '32', '1312', '312', '230000', '黑龙江省', '230500', '双鸭山市', '230506', '宝山区', '321', '2', '32', '2', '321', '2023-11-13 00:00:00', '2023-11-15 00:00:00', '0', NULL, NULL, '2', '2', '2', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1730129271211503618', 3, '2023-11-30 15:38:57', '2023-11-30 15:38:57', 1, '230000', '2023-11-22 00:00:00', '21', '21', '12', '21', '21', '21', '21', '21', '21', '230000', '黑龙江省', '230500', '双鸭山市', '230521', '集贤县', '21', '2', '2', '2', '21', '2023-11-22 00:00:00', '2023-11-23 00:00:00', '0', NULL, NULL, '2', '2', '2', '0', '0', '0', '21', '21', NULL);
INSERT INTO `nf_rffssp` VALUES ('IN1730131097608634370', 3, '2023-11-30 15:46:13', '2023-11-30 15:46:13', 1, '230000', '2023-11-16 00:00:00', '32', '32', '123', '3', '32', '32', '32', '32', '32', '230000', '黑龙江省', '230300', '鸡西市', '230307', '麻山区', '32', '3', '3', '3', '321', '2023-11-15 00:00:00', '2023-11-08 00:00:00', '0', NULL, NULL, '3', '3', '3', '0', '0', '0', '321', '32', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1647866190601609218', 2, '2023-04-17 15:34:50', '2023-04-17 15:34:50', 1, '230800', '2023-04-11 00:00:00', '测试备案2', '1', '佛挡杀佛', '1', '1', '1', '1', '1', '1', '230000', NULL, '230400', NULL, '230404', NULL, '1', '1', '1', NULL, '1', '2023-04-18 00:00:00', '2023-04-12 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1648199914618777602', 2, '2023-04-18 13:40:56', '2023-04-18 13:40:56', 1, '231000', '2023-04-19 00:00:00', '测试备案3', '123121233123', '代码', '富士达啊', '手动阀', '手动阀', '123123', '123', '阿萨德', '230000', NULL, '230200', NULL, '230203', NULL, '奥德赛', '手动阀', '范德萨', NULL, '备案', '2023-04-04 00:00:00', '2023-04-20 00:00:00', '0', '撒的', '手动阀', '手动阀阿', '士大夫', '第三方啊', '0', '0', '0', '送达', '阿斯蒂芬', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1648199974735736833', 2, '2023-04-18 13:41:11', '2023-04-18 13:41:11', 1, '231000', '2023-04-19 00:00:00', '测试备案4', '123121233123', '代码', '富士达啊', '手动阀', '手动阀', '123123', '123', '阿萨德', '230000', NULL, '230200', NULL, '230203', NULL, '奥德赛', '手动阀', '范德萨', NULL, '备案', '2023-04-04 00:00:00', '2023-04-20 00:00:00', '0', '撒的', '手动阀', '手动阀阿', '士大夫', '第三方啊', '0', '0', '0', '送达', '阿斯蒂芬', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1648200230403731457', 2, '2023-04-18 13:42:12', '2023-04-18 16:54:19', 1, '231000', '2023-04-19 00:00:00', '测试备案5', '123121233123', '代码', '富士达啊', '手动阀', '手动阀', '123123', '123', '阿萨德222', '230000', NULL, '230200', NULL, '230203', NULL, '奥德赛', '手动阀', '范德萨', NULL, '备案', '2023-04-04 00:00:00', '2023-04-20 00:00:00', '0', '撒的', '手动阀', '手动阀阿', '士大夫', '第三方啊', '0', '0', '0', '送达', '阿斯蒂芬22', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1648929884068605954', 2, '2023-04-20 14:01:35', '2023-10-08 14:37:56', 1, '230800', '2023-04-26 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '1', '230000', NULL, '230100', NULL, '230103', NULL, '1', '1', '1', NULL, '1', '2023-04-18 00:00:00', '2023-04-04 00:00:00', '1', '1', '1', '11', '11', '11', '1', '1', '1', '1', '1', '213');
INSERT INTO `nf_rffssp` VALUES ('OUT1648932411493281793', 3, '2023-04-20 14:11:37', '2023-09-07 09:29:11', 1, '230700', '2023-04-12 00:00:00', '222', '222', '1212', '22', '22', '222', '22', '222', '222', '230000', NULL, '230500', NULL, '230506', NULL, '22', '22', '22', NULL, '222', '2023-04-25 00:00:00', '2023-04-19 00:00:00', '1', '22', '22', '22', '222', '222', '1', '1', '1', '222', '22', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1648933201129730050', 2, '2023-04-20 14:14:46', '2023-10-08 14:37:12', 1, '230800', '2023-04-27 00:00:00', '332', '332', '332', '332', '332', '32', '32', '332', '332', '230000', NULL, '230400', NULL, '230406', NULL, '332', '3', '3', NULL, '333', '2023-04-19 00:00:00', '2023-04-19 00:00:00', '0', '33', '3', '33', '3', '3', '0', '0', '1', '32', '333', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710901640601530370', 2, '2023-10-08 14:15:13', '2023-10-08 14:15:13', 1, '232700', '2023-10-18 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '230000', NULL, '230100', NULL, '230102', NULL, '啊', '啊', '啊', NULL, '啊', '2023-10-12 00:00:00', '2023-10-13 00:00:00', '0', '啊', '啊', '啊', '啊', '  啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710908252380659714', 2, '2023-10-08 14:41:29', '2023-10-08 14:41:29', 1, '231000', '2023-10-12 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '', NULL, '', NULL, '', NULL, '啊', '啊', '啊', NULL, '啊', '2023-09-27 00:00:00', '2023-10-16 00:00:00', '0', '啊', '啊', '啊', '啊', '啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710909290517037058', 2, '2023-10-08 14:45:37', '2023-10-08 14:45:37', 1, '231000', '2023-10-12 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '', NULL, '', NULL, '', NULL, '啊', '啊', '啊', NULL, '啊', '2023-09-27 00:00:00', '2023-10-16 00:00:00', '0', '啊', '啊', '啊', '啊', '啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710915256599871490', 2, '2023-10-08 15:09:19', '2023-10-08 15:09:19', 1, '231000', '2023-10-12 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '', NULL, '', NULL, '', NULL, '啊', '啊', '啊', NULL, '啊', '2023-09-27 00:00:00', '2023-10-16 00:00:00', '0', '啊', '啊', '啊', '啊', '啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710916009544548354', 2, '2023-10-08 15:12:19', '2023-10-08 15:12:19', 1, '231000', '2023-10-12 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '', NULL, '', NULL, '', NULL, '啊', '啊', '啊', NULL, '啊', '2023-09-27 00:00:00', '2023-10-16 00:00:00', '0', '啊', '啊', '啊', '啊', '啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710916658470486018', 2, '2023-10-08 15:14:53', '2023-10-08 15:14:53', 1, '231000', '2023-10-12 00:00:00', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '啊', '', NULL, '', NULL, '', NULL, '啊', '啊', '啊', NULL, '啊', '2023-09-27 00:00:00', '2023-10-16 00:00:00', '0', '啊', '啊', '啊', '啊', '啊', '0', '0', '0', '啊', '啊', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710936634220806145', 2, '2023-10-08 16:34:16', '2023-10-08 16:34:16', 1, '230500', '2023-10-05 00:00:00', '321', '321', '213312', '312', '321', '3213', '321', '321', '321', '230000', NULL, '230100', NULL, '230104', NULL, '321', '321', '321', NULL, '321', '2023-10-12 00:00:00', '2023-09-28 00:00:00', '1', '321', '321', '321', '3213', '321', '0', '0', '0', '321', '21', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1710937148438282242', 2, '2023-10-08 16:36:19', '2023-10-08 16:36:19', 1, '230500', '2023-10-05 00:00:00', '321', '321', '213312', '312', '321', '3213', '321', '321', '321', '230000', NULL, '230100', NULL, '230104', NULL, '321', '321', '321', NULL, '321', '2023-10-12 00:00:00', '2023-09-28 00:00:00', '1', '321', '321', '321', '3213', '321', '0', '0', '0', '321', '21', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1711188708720369666', 2, '2023-10-09 09:15:55', '2023-10-09 09:15:55', 1, '230500', '2023-10-11 00:00:00', '1', '1', '11', '1', '1', '1', '1', '1', '1', '230000', NULL, '230200', NULL, '230206', NULL, '11', '1', '1', NULL, '1', '2023-10-11 00:00:00', '2023-10-12 00:00:00', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1711197339088052225', 2, '2023-10-09 09:50:13', '2023-10-09 09:50:13', 1, '', '2023-10-05 00:00:00', '321', '321', '321', '321', '321', '321', '321', '321', '321', '230000', NULL, '230200', NULL, '230203', NULL, '321', '231', '321', NULL, '321', '2023-10-10 00:00:00', '2023-10-20 00:00:00', '0', '32132', '13', '21321', '321', '33', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1711213248884228098', 2, '2023-10-09 10:53:26', '2023-11-28 17:21:18', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp` VALUES ('OUT1722437361831309313', 3, '2023-11-09 10:14:03', '2023-11-27 12:35:32', 1, '230500', '2023-11-08 00:00:00', '321', '3123', '123', '21', '321', '312', '321', '31', '321', '230000', NULL, '230200', NULL, '230204', NULL, '321', '31', '321213', NULL, '321', '2023-11-09 00:00:00', '2023-11-09 00:00:00', '0', '321', '321', '321', '321', '321', '0', '0', '0', '321', '321', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1722483214419836929', 2, '2023-11-09 13:16:15', '2023-11-09 13:16:15', 1, '230600', '2023-11-09 00:00:00', '33', '333', '111', '3333', '3333', '333', '333', '33', '3333', '230000', NULL, '230300', NULL, '230304', NULL, '3333', '33', '333', NULL, '111', '2023-11-09 00:00:00', '2023-11-09 00:00:00', '0', '33', '3', '3', '3', '3', '0', '0', '0', '3333', '333', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1722494550411419650', 3, '2023-11-09 14:01:18', '2023-11-30 14:56:06', 1, '230500', '2023-11-09 00:00:00', '6666', '666', '1231', '6666', '6666', '66666', '6666', '66666', '6666666666', '230000', NULL, '230200', NULL, '230204', NULL, '2166666', '66', '6666', NULL, '321', '2023-11-09 00:00:00', '2023-11-09 00:00:00', '1', '666', '66', '6666', '666', '666', '1', '1', '1', '12', '66666', NULL);
INSERT INTO `nf_rffssp` VALUES ('OUT1722497169720713217', 2, '2023-11-09 14:11:42', '2023-11-09 14:11:42', 1, '230600', '2023-11-02 00:00:00', '99', '999', '9999', '99', '99', '99', '999', '99', '9999', '230000', NULL, '230200', NULL, '230205', NULL, '999', '999', '99', NULL, '9999', '2023-11-01 00:00:00', '2023-11-02 00:00:00', '0', '99', '99', '99', '99', '99', '1', '1', '1', '9999', '99', NULL);

-- ----------------------------
-- Table structure for nf_rffssp_history
-- ----------------------------
DROP TABLE IF EXISTS `nf_rffssp_history`;
CREATE TABLE `nf_rffssp_history`  (
  `id` varchar(30) NOT NULL COMMENT '冷藏冷冻食品贮存服务提供者ID',
  `realid` varchar(30) NULL DEFAULT NULL,
  `status` tinyint(0) NOT NULL COMMENT '状态 1 录入  2 提交  3 业务完成',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  `valid` int(0) NOT NULL COMMENT '是否有效：1有效 0无效',
  `issueorg` varchar(10) NULL DEFAULT NULL COMMENT '管理机构ID',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '办理备案日期',
  `apply_name` varchar(255) NULL DEFAULT NULL COMMENT '申请人姓名',
  `apply_contact_info` varchar(255) NULL DEFAULT NULL COMMENT '申请人联系方式',
  `unisc_id` varchar(255) NULL DEFAULT NULL COMMENT '统一社会信用代码',
  `storage_ent_name` varchar(255) NULL DEFAULT NULL COMMENT '从事冷藏冷冻食品贮存业务的非食品生产经营者名称',
  `le_rep` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人（负责人）',
  `le_rep_no` varchar(255) NULL DEFAULT NULL COMMENT '法定代表人（负责人）身份证号码',
  `contract_name` varchar(255) NULL DEFAULT NULL COMMENT '联系人',
  `contract_tel` varchar(255) NULL DEFAULT NULL COMMENT '联系电话',
  `storage_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库名称',
  `storage_province` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）代码',
  `storage_prov_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（省）',
  `storage_city` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）代码',
  `storage_city_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（市）',
  `storage_county` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）代码',
  `storage_county_name` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库地址（区/县）',
  `storage_address` varchar(255) NULL DEFAULT NULL COMMENT '冷藏冷冻库详细地址',
  `storage_power_ton` varchar(255) NULL DEFAULT NULL COMMENT '贮存能力（单位：吨）',
  `storage_power_cubic_meter` varchar(255) NULL DEFAULT NULL COMMENT '贮存能力（单位：立方米）',
  `storage_amount` varchar(20) NULL DEFAULT NULL COMMENT '冷库数量',
  `rec_num` varchar(255) NULL DEFAULT NULL COMMENT '备案编号',
  `rec_time` datetime(0) NULL DEFAULT NULL COMMENT '备案日期',
  `entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  `safety_standards` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）是否符合食品安全标准',
  `storage_area` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存面积',
  `storage_capacity` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存容积',
  `equipment_name_specification` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）冷藏冷冻设施、设备名称规格及数量',
  `humidity_control_range` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）温度、湿度控制范围',
  `bumber_explicit_thermometers` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）可正确显示内部温度的温度计和外显式温度计数量',
  `keep_clean` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）贮存设备、容器和工具是否无毒无害、保持清洁',
  `is_ground` varchar(255) NULL DEFAULT NULL COMMENT '（贮存能力）是否分区分架分类存放食品，是否离地离墙10cm',
  `is_disinfect` varchar(255) NULL DEFAULT NULL COMMENT '是否有校验消毒清洁维护制度及记录',
  `other_categories` varchar(255) NULL DEFAULT NULL COMMENT '其他非食品类贮存品类别',
  `remarks` varchar(255) NULL DEFAULT NULL COMMENT '备注',
  `canclecause` text NULL COMMENT '注销原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '冷藏冷冻食品贮存服务提供者' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_rffssp_history
-- ----------------------------
INSERT INTO `nf_rffssp_history` VALUES ('1722493474287230977', 'IN1722493148805046274', 3, '2023-11-09 13:55:44', '2023-11-09 13:56:33', 1, '230000', '2023-11-09 00:00:00', '444', '44', '1111', '44', '4444', '444', '444', '444', '4444', '230000', '黑龙江省', '230500', '双鸭山市', '230506', '宝山区', '444', '4', '4', NULL, '11', '2023-11-09 00:00:00', '2023-11-09 00:00:00', '0', '4', '4', '4', '4', '4', '1', '1', '0', '2333344', '444', NULL);
INSERT INTO `nf_rffssp_history` VALUES ('1722496912203030530', 'OUT1722494550411419650', 3, '2023-11-09 14:01:18', '2023-11-09 14:02:37', 1, '230500', '2023-11-09 00:00:00', '6666', '666', '1231', '6666', '6666', '66666', '6666', '66666', '6666666666', '230000', NULL, '230200', NULL, '230204', NULL, '2166666', '66', '6666', NULL, '321', '2023-11-09 00:00:00', '2023-11-09 00:00:00', '1', '666', '66', '6666', '666', '666', '1', '1', '1', '12', '66666', NULL);
INSERT INTO `nf_rffssp_history` VALUES ('1729426412077694978', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729426489080922113', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729426772552957954', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729427044796841985', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729427083485102081', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729427318257074178', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729427787981373442', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729428150243409922', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729428290844868610', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729428726515613698', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729429115289845761', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');
INSERT INTO `nf_rffssp_history` VALUES ('1729430164176199682', 'OUT1711213248884228098', 3, '2023-10-09 10:53:26', '2023-11-28 16:11:40', 1, '230600', '2023-09-27 00:00:00', '12大萨更大深V花洒好几十三打哈较大尴尬萨哈搭嘎傻噶', '12', '123456789012345678', '12', '12', '12', '12', '12', '12333', '230000', NULL, '230100', NULL, '230104', NULL, '12', '1233', '12333', '12231', '12', '2023-09-28 00:00:00', '2023-10-11 00:00:00', '1', '1', '1', '12', '123', '12223', '1', '1', '1', '12', '12', 'sda');

-- ----------------------------
-- Table structure for nf_rffssp_user
-- ----------------------------
DROP TABLE IF EXISTS `nf_rffssp_user`;
CREATE TABLE `nf_rffssp_user`  (
  `id` varchar(30) NOT NULL COMMENT 'ID',
  `rffsspid` varchar(30) NOT NULL COMMENT '备案ID',
  `userid` bigint(0) NOT NULL COMMENT '外网用户ID',
  `status` tinyint(0) NOT NULL COMMENT '状态  0：解绑   1：正常',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rffsspid`(`rffsspid`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE
) ENGINE = InnoDB COMMENT = '外网用户与主体关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_rffssp_user
-- ----------------------------
INSERT INTO `nf_rffssp_user` VALUES ('OUT1648200231691382785', 'OUT1648200230403731457', 1648197994609012738, 1, '2023-04-18 13:42:12', '2023-04-18 16:54:21');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1648929885935071233', 'OUT1648929884068605954', 1648198738586267650, 1, '2023-04-20 14:01:35', '2023-10-08 14:37:57');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1648932413678514178', 'OUT1648932411493281793', 1648198738586267650, 1, '2023-04-20 14:11:38', '2023-04-20 14:11:38');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1648933202954252289', 'OUT1648933201129730050', 1648198738586267650, 1, '2023-04-20 14:14:46', '2023-10-08 14:37:12');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710901642220531713', 'OUT1710901640601530370', 1648198738586267650, 1, '2023-10-08 14:15:13', '2023-10-08 14:15:13');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710908253643145217', 'OUT1710908252380659714', 1648198738586267650, 1, '2023-10-08 14:41:29', '2023-10-08 14:41:29');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710909291712413697', 'OUT1710909290517037058', 1648198738586267650, 1, '2023-10-08 14:45:37', '2023-10-08 14:45:37');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710915257979797506', 'OUT1710915256599871490', 1648198738586267650, 1, '2023-10-08 15:09:19', '2023-10-08 15:09:19');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710916010853171202', 'OUT1710916009544548354', 1648198738586267650, 1, '2023-10-08 15:12:19', '2023-10-08 15:12:19');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710916659712000002', 'OUT1710916658470486018', 1648198738586267650, 1, '2023-10-08 15:14:54', '2023-10-08 15:14:54');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710936637639163906', 'OUT1710936634220806145', 1648198738586267650, 1, '2023-10-08 16:34:17', '2023-10-08 16:34:17');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1710937151579815937', 'OUT1710937148438282242', 1648198738586267650, 1, '2023-10-08 16:36:19', '2023-10-08 16:36:19');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1711188710238707714', 'OUT1711188708720369666', 1648198738586267650, 1, '2023-10-09 09:15:56', '2023-10-09 09:15:56');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1711197340350537730', 'OUT1711197339088052225', 1648198738586267650, 1, '2023-10-09 09:50:13', '2023-10-09 09:50:13');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1711213250343845890', 'OUT1711213248884228098', 1648198738586267650, 1, '2023-10-09 10:53:26', '2023-11-09 10:04:36');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1722437363647442946', 'OUT1722437361831309313', 1648198738586267650, 1, '2023-11-09 10:14:04', '2023-11-09 10:41:53');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1722437611790856194', 'OUT1722437610079580161', 1648198738586267650, 1, '2023-11-09 10:15:03', '2023-11-09 10:17:58');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1722483217687199746', 'OUT1722483214419836929', 1648198738586267650, 1, '2023-11-09 13:16:16', '2023-11-09 13:16:16');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1722494552424685569', 'OUT1722494550411419650', 1648198738586267650, 1, '2023-11-09 14:01:18', '2023-11-09 14:10:43');
INSERT INTO `nf_rffssp_user` VALUES ('OUT1722497171713007618', 'OUT1722497169720713217', 1648198738586267650, 1, '2023-11-09 14:11:43', '2023-11-09 14:11:43');

-- ----------------------------
-- Table structure for nf_upload
-- ----------------------------
DROP TABLE IF EXISTS `nf_upload`;
CREATE TABLE `nf_upload`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `business_id` varchar(255) NULL DEFAULT NULL COMMENT '业务id',
  `content` longblob NULL COMMENT '文件内容',
  `business` varchar(255) NULL DEFAULT NULL COMMENT '业务类型',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1711553728637476866 ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for nf_upload_history
-- ----------------------------
DROP TABLE IF EXISTS `nf_upload_history`;
CREATE TABLE `nf_upload_history`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `business_id` varchar(255) NULL DEFAULT NULL COMMENT '业务id',
  `content` longblob NULL COMMENT '文件内容',
  `business` varchar(255) NULL DEFAULT NULL COMMENT '业务类型',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1711553728637476866 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_upload_history
-- ----------------------------

-- ----------------------------
-- Table structure for nf_wcaptcha
-- ----------------------------
DROP TABLE IF EXISTS `nf_wcaptcha`;
CREATE TABLE `nf_wcaptcha`  (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB COMMENT = '外网系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_wcaptcha
-- ----------------------------
INSERT INTO `nf_wcaptcha` VALUES ('0b91a1e8-33af-4c31-85d5-c4ec799efa5e', '3en5f', '2023-10-09 11:19:09');
INSERT INTO `nf_wcaptcha` VALUES ('1a58bf85-106d-4216-8cad-ee5b9227d4b0', 'wx626', '2023-10-17 15:05:18');
INSERT INTO `nf_wcaptcha` VALUES ('1ae72b26-18ed-4758-83d4-064f29eb68b1', '8b556', '2023-10-17 15:05:18');
INSERT INTO `nf_wcaptcha` VALUES ('1cf5ec25-8630-4f6c-889c-38c9d463a064', 'ecbwg', '2023-04-20 14:27:52');
INSERT INTO `nf_wcaptcha` VALUES ('1e8d8a1f-e1a6-4b37-8d10-2d3f69b11a40', 'x74pg', '2023-10-08 15:13:49');
INSERT INTO `nf_wcaptcha` VALUES ('217135db-1753-49fe-8738-7d48cbcb06cf', '3new7', '2023-10-08 15:25:29');
INSERT INTO `nf_wcaptcha` VALUES ('2212e0dc-8471-49df-8d94-aadf08825bbd', 'bb6n2', '2023-04-18 14:09:12');
INSERT INTO `nf_wcaptcha` VALUES ('22f24a5b-2473-48d5-8f13-e55ceae59be5', 'x74gg', '2023-04-19 17:12:06');
INSERT INTO `nf_wcaptcha` VALUES ('292fcc64-e957-4189-8ec6-f47ad72207fc', '6nfay', '2023-10-17 14:59:38');
INSERT INTO `nf_wcaptcha` VALUES ('2f6d2f11-fda8-45ea-8c74-0f5350487b33', '6gdc4', '2023-04-20 14:24:38');
INSERT INTO `nf_wcaptcha` VALUES ('3068a4b7-90a2-4817-8b50-9fe6e26da90a', 'gc8am', '2023-04-20 14:27:41');
INSERT INTO `nf_wcaptcha` VALUES ('33041437-47d4-43d5-8752-774fa757e149', '54yaa', '2023-04-18 13:41:42');
INSERT INTO `nf_wcaptcha` VALUES ('39f28ed9-d19f-4626-80ca-5bd4ca5393d4', 'd6dfc', '2023-10-08 14:11:43');
INSERT INTO `nf_wcaptcha` VALUES ('422eca93-8588-438a-8748-35d152b95db7', 'e2c5m', '2023-04-20 14:27:28');
INSERT INTO `nf_wcaptcha` VALUES ('441594b7-52a9-4dc3-8954-b1f098f39f29', 'mgn4n', '2023-10-08 14:11:28');
INSERT INTO `nf_wcaptcha` VALUES ('4ac96db8-4ba9-4fd5-8f6c-1674fd3c1ed0', 'nb5nf', '2023-04-20 14:27:48');
INSERT INTO `nf_wcaptcha` VALUES ('4baaa34d-a578-46b8-807f-741e7667d787', 'dxnp5', '2023-10-09 15:28:31');
INSERT INTO `nf_wcaptcha` VALUES ('50afac79-a181-4e94-8eeb-fd91b938a18f', '8ewyx', '2023-04-20 14:27:33');
INSERT INTO `nf_wcaptcha` VALUES ('5101059c-e462-4f94-898e-d0e9a9514b1b', 'wcana', '2023-10-17 14:43:50');
INSERT INTO `nf_wcaptcha` VALUES ('52cc9fb8-edb3-4f47-8f32-66e79e77c9a4', 'y3p5a', '2023-10-08 15:32:24');
INSERT INTO `nf_wcaptcha` VALUES ('53f7fe5e-afa6-4ee4-81b3-528a9a559d2b', 'nwbc2', '2023-04-20 14:27:43');
INSERT INTO `nf_wcaptcha` VALUES ('56dd933e-10c6-4172-8715-ee83389aeeaf', '2p2pm', '2023-04-18 13:36:04');
INSERT INTO `nf_wcaptcha` VALUES ('57210e07-eaee-4e38-8f89-31e20ebf13a6', '6ngp7', '2023-10-09 13:43:03');
INSERT INTO `nf_wcaptcha` VALUES ('602f4911-d958-4e91-8f90-fd2161159dc2', '86cpf', '2023-04-20 14:27:50');
INSERT INTO `nf_wcaptcha` VALUES ('6347da01-becf-49db-8953-bd3dbe1954dd', '38mcx', '2023-10-17 14:58:43');
INSERT INTO `nf_wcaptcha` VALUES ('644483b4-ad7a-4971-8c4b-254863bffd9c', 'y6xn4', '2023-04-18 13:37:41');
INSERT INTO `nf_wcaptcha` VALUES ('676f2589-e86c-4b35-89f9-435bc40e0820', '87ne3', '2023-04-20 14:27:37');
INSERT INTO `nf_wcaptcha` VALUES ('6d845955-6781-4fb0-8e8c-8f273536d0f3', 'a5yb7', '2023-10-17 14:59:33');
INSERT INTO `nf_wcaptcha` VALUES ('71f33e93-0d20-4638-8f4d-56869815b267', '3gp26', '2023-10-08 15:06:42');
INSERT INTO `nf_wcaptcha` VALUES ('7316c890-e90f-4ed8-8fd5-73f37f1f48ac', 'admbb', '2023-11-09 10:16:59');
INSERT INTO `nf_wcaptcha` VALUES ('78562e5b-059c-40f5-8653-33390c1e8516', 'fycfn', '2023-04-20 14:27:31');
INSERT INTO `nf_wcaptcha` VALUES ('816b6c8d-f58f-40c0-8c5f-9219f519017b', 'em2mc', '2023-10-17 15:09:27');
INSERT INTO `nf_wcaptcha` VALUES ('866035cb-cdec-49e7-89cf-625bf53a838a', 'n2xng', '2023-04-17 15:21:43');
INSERT INTO `nf_wcaptcha` VALUES ('886b01ee-099a-4d24-83fb-c78f19c76f96', '4g884', '2023-10-17 14:58:54');
INSERT INTO `nf_wcaptcha` VALUES ('8d91e6c3-e677-4efe-88e1-9942b1252bc7', 'a5p3p', '2023-04-18 13:35:53');
INSERT INTO `nf_wcaptcha` VALUES ('91b2dfc9-5a46-449c-8bc6-495a2c6f7b66', 'x43b6', '2023-04-20 14:25:51');
INSERT INTO `nf_wcaptcha` VALUES ('941d5d45-383d-482b-8ea6-c9aa94e80865', 'n42ww', '2023-04-18 16:59:50');
INSERT INTO `nf_wcaptcha` VALUES ('94415ae4-fc77-4623-8030-db85b7edb19f', 'np3f5', '2023-04-20 14:27:49');
INSERT INTO `nf_wcaptcha` VALUES ('99ba1b7f-e9c4-43b1-86ca-7cf519c45a54', 'nc785', '2023-11-09 14:16:57');
INSERT INTO `nf_wcaptcha` VALUES ('9fea1d17-fccf-4163-8f20-d6a0f82f813f', 'gx6f7', '2023-04-18 13:36:54');
INSERT INTO `nf_wcaptcha` VALUES ('a119c0ee-9461-423a-8302-d16a23422ae7', '2nfcp', '2023-10-17 14:43:44');
INSERT INTO `nf_wcaptcha` VALUES ('a2c54ff1-193d-4214-872f-ea314cce4049', 'd63xd', '2023-04-20 14:27:39');
INSERT INTO `nf_wcaptcha` VALUES ('aa7c5c00-4c9f-4398-8acb-68fb2fae91f3', 'g68ba', '2023-10-17 14:58:51');
INSERT INTO `nf_wcaptcha` VALUES ('adbca393-b5cd-4b0c-8799-832e42c7021e', '8p2y3', '2023-04-20 14:27:35');
INSERT INTO `nf_wcaptcha` VALUES ('b225c5b7-1141-4637-8808-26739cd6bf96', 'e5nec', '2023-04-20 14:25:46');
INSERT INTO `nf_wcaptcha` VALUES ('be0ce4a6-1f19-41b1-8d90-a6bd33460bae', '2a4f2', '2023-10-17 14:59:57');
INSERT INTO `nf_wcaptcha` VALUES ('c2e73ded-c2b6-4dc5-8fe4-e6c938d51b70', 'mwgda', '2023-10-17 14:43:56');
INSERT INTO `nf_wcaptcha` VALUES ('c31954a3-59c0-4ea8-852f-3152881e0df5', '2a4g4', '2023-04-20 14:27:54');
INSERT INTO `nf_wcaptcha` VALUES ('c42d0979-4c53-4a27-81bb-6701b55d1e29', '7338a', '2023-10-17 14:59:23');
INSERT INTO `nf_wcaptcha` VALUES ('c6a3f50d-93a5-4d47-8133-969ee88257ef', '2w6xp', '2023-10-17 15:05:25');
INSERT INTO `nf_wcaptcha` VALUES ('c9847e66-ee48-4218-8a9d-3325445be7b6', 'x6d4a', '2023-10-17 14:58:54');
INSERT INTO `nf_wcaptcha` VALUES ('cb188282-da24-471a-8963-47e512667cc3', 'dywnn', '2023-04-18 13:38:27');
INSERT INTO `nf_wcaptcha` VALUES ('cc06c092-3e50-49bf-8d8e-e822bd0a2ba9', 'n55nm', '2023-04-20 14:23:40');
INSERT INTO `nf_wcaptcha` VALUES ('cd2d249c-ec1a-4eb9-8b1b-6a4c2cfdb8c7', 'aewpf', '2023-04-20 14:27:10');
INSERT INTO `nf_wcaptcha` VALUES ('d89b8d04-d716-4a03-87c0-f270a763e310', 'abn2x', '2023-10-17 14:58:56');
INSERT INTO `nf_wcaptcha` VALUES ('d8ccc5e6-cc22-4339-8789-c6a5c6df57ec', 'nfapm', '2023-10-08 14:11:53');
INSERT INTO `nf_wcaptcha` VALUES ('ded31a00-6f5d-4e1f-8f0d-d9f55fcd4828', 'nwww3', '2023-04-20 14:27:57');
INSERT INTO `nf_wcaptcha` VALUES ('e3a79ba9-5443-42d6-81c4-e33d3ba84373', '8nn44', '2023-04-20 14:25:50');
INSERT INTO `nf_wcaptcha` VALUES ('ea3ae1ca-d04f-4368-89ba-8e8d4445281b', 'y3fm2', '2023-10-17 15:10:43');
INSERT INTO `nf_wcaptcha` VALUES ('ec0275dc-a775-4302-8538-40635a041b89', 'dxag4', '2023-04-18 14:09:13');
INSERT INTO `nf_wcaptcha` VALUES ('ec0c23a9-324b-460b-8990-608d06759aa3', 'm7pf6', '2023-10-17 14:59:27');
INSERT INTO `nf_wcaptcha` VALUES ('f8593539-1557-4fd8-8fc0-a653abec9e79', 'en68e', '2023-04-18 14:09:15');

-- ----------------------------
-- Table structure for nf_wuser
-- ----------------------------
DROP TABLE IF EXISTS `nf_wuser`;
CREATE TABLE `nf_wuser`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态  0：删除   1：正常   2：禁用',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1714175689104519169 COMMENT = '外网用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_wuser
-- ----------------------------
INSERT INTO `nf_wuser` VALUES (1648197994609012738, '123', '0b46eb74260c47c2b7a865294970d4d711b0730aacf2b54f5c553f60f784f3e0', 'feAngWI4v0izhCCMGN2C', '123@qq.com', '19151521521', 1, '2023-04-18 13:33:19', NULL);
INSERT INTO `nf_wuser` VALUES (1648198738586267650, '12345', 'eb3b20e4aa4d4332630f989a67a0aa7d662a23f98cad43f90263111856b9d332', 'PZkEjcLA18XRllrHqARe', '441146700@qq.com', '17859510298', 1, '2023-04-18 13:36:16', NULL);
INSERT INTO `nf_wuser` VALUES (1714175689104519169, '1234', 'a4ec8917fd893a60aca7662d4950eb2f6842a980ed667cd4d534e92be479688d', 'pbgV3CH2c0lk0GwIEL7Q', '441146700@qq.com', '18045643107', 1, '2023-10-17 15:05:07', NULL);

-- ----------------------------
-- Table structure for nf_wuser_token
-- ----------------------------
DROP TABLE IF EXISTS `nf_wuser_token`;
CREATE TABLE `nf_wuser_token`  (
  `id` bigint(0) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB COMMENT = '外网用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nf_wuser_token
-- ----------------------------
INSERT INTO `nf_wuser_token` VALUES (1648197994609012738, 'f08608efdc90c680b4de99b13f7f0cad', '2023-04-18 17:23:26', '2023-04-18 16:53:26');
INSERT INTO `nf_wuser_token` VALUES (1648198738586267650, '2446aad30b8b9ca6df4a775dd2ac1664', '2023-11-09 14:51:40', '2023-11-09 14:21:40');
INSERT INTO `nf_wuser_token` VALUES (1714175689104519169, 'e4acbf9f64f2fd903e1564422ba2b4f6', '2023-11-09 10:43:13', '2023-11-09 10:13:13');

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(0) NOT NULL,
  `job_id` bigint(0) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(0) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(0) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '定时任务日志' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`  (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB COMMENT = '系统验证码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha` VALUES ('04340145-86b6-4be0-86c3-8f9a6c48988d', '77mx3', '2023-11-28 11:49:51');
INSERT INTO `sys_captcha` VALUES ('06361ecb-93b0-4703-87df-a5cb4c88d595', '4wcd8', '2023-11-28 11:55:55');
INSERT INTO `sys_captcha` VALUES ('0961084f-eeac-4e03-81d4-75f8abc51c7b', 'x8cmy', '2023-05-05 15:07:14');
INSERT INTO `sys_captcha` VALUES ('0f0f55c3-9fce-4cce-8837-a1045437c71a', 'ndb52', '2023-09-06 17:43:36');
INSERT INTO `sys_captcha` VALUES ('11ebafad-b789-4992-8b71-52e21caa8a11', 'w8yp4', '2023-11-28 11:46:04');
INSERT INTO `sys_captcha` VALUES ('131aec7f-c882-412f-83ab-d025cda3e919', 'dm43g', '2023-04-18 16:10:21');
INSERT INTO `sys_captcha` VALUES ('187dd3f2-b3e4-4a7b-86a0-e0d3a62a3a9f', '6n5fa', '2023-10-26 13:47:51');
INSERT INTO `sys_captcha` VALUES ('20411e3d-fdc1-4dc0-8342-68503127a7b8', 'fnnwy', '2023-09-06 17:43:06');
INSERT INTO `sys_captcha` VALUES ('28947d96-b13d-46e7-8244-bc2f3d4add65', '85yfe', '2023-11-28 11:48:14');
INSERT INTO `sys_captcha` VALUES ('2c4edec3-4d5a-49cc-8a67-77208f4b2604', 'c4xfm', '2023-11-28 11:46:13');
INSERT INTO `sys_captcha` VALUES ('2d6c93c6-9bdb-4482-871b-45d3bf5d2b86', 'dem2p', '2023-09-06 17:21:00');
INSERT INTO `sys_captcha` VALUES ('3033fff1-bcf8-4a4c-8513-8b6d95b8ef4b', 'ncgmn', '2023-09-06 14:59:10');
INSERT INTO `sys_captcha` VALUES ('3591447e-b4b7-4bbb-86e0-520b36a46068', 'em37f', '2023-10-08 14:10:46');
INSERT INTO `sys_captcha` VALUES ('43ca4b54-fcef-47a3-8325-a1b7a148b4d4', 'eenmb', '2023-10-26 13:53:45');
INSERT INTO `sys_captcha` VALUES ('497c79ba-b67e-4d99-813e-b6762bca2dcb', 'efa7w', '2023-04-18 14:01:07');
INSERT INTO `sys_captcha` VALUES ('4b8e52b9-0cc6-4dd2-826b-676ab94506d2', '5f6n4', '2023-08-23 16:33:59');
INSERT INTO `sys_captcha` VALUES ('5ea70f32-42ee-4087-87d4-228d3b67c2f8', 'nmad4', '2023-04-19 09:11:31');
INSERT INTO `sys_captcha` VALUES ('5f272b6f-69da-4469-8ae8-83042223a856', 'wdwx2', '2023-09-06 17:55:06');
INSERT INTO `sys_captcha` VALUES ('627dc9b9-2656-4849-8085-a9a5ae686868', 'xwn5p', '2023-09-06 17:24:19');
INSERT INTO `sys_captcha` VALUES ('672a09c3-557b-43a5-85d3-519b288469de', '4xxca', '2023-04-19 09:41:24');
INSERT INTO `sys_captcha` VALUES ('69ce4f03-b888-455f-83da-ea20fc443c4f', 'ywbeb', '2023-11-28 11:49:03');
INSERT INTO `sys_captcha` VALUES ('6bcff0f5-1b19-4316-8af9-bb0e18f3ab1d', '8yyec', '2023-10-11 11:19:37');
INSERT INTO `sys_captcha` VALUES ('76f10cd9-661a-4fce-8092-c15f1a5a4d47', 'acydp', '2023-09-06 15:11:39');
INSERT INTO `sys_captcha` VALUES ('7abca518-48ff-499a-8268-f0e302f1a0ff', 'ngdda', '2023-10-23 17:27:28');
INSERT INTO `sys_captcha` VALUES ('7e1ad6e7-2d28-4785-8c8d-c12bf18b63c4', '5gebp', '2023-09-06 17:46:02');
INSERT INTO `sys_captcha` VALUES ('82276b72-8d14-4ddf-80ca-d0e8bd62ef8c', '6nanx', '2023-09-06 17:44:25');
INSERT INTO `sys_captcha` VALUES ('83db6831-8d1e-409e-8bef-71f59a25971d', '6ne74', '2023-10-31 09:50:26');
INSERT INTO `sys_captcha` VALUES ('99d25a38-dec9-447f-810d-7f9c86cc4fee', 'a6d5g', '2023-04-19 09:38:42');
INSERT INTO `sys_captcha` VALUES ('9b839d28-98f7-4cd8-8081-a951a1fe825c', 'xn7yb', '2023-10-23 17:27:28');
INSERT INTO `sys_captcha` VALUES ('9f17631a-6d0c-4aef-84f9-eb7dff859087', 'e4px7', '2023-11-28 11:45:22');
INSERT INTO `sys_captcha` VALUES ('abc33441-a8fa-4460-87e0-912066235442', 'f2ye8', '2023-04-17 15:24:40');
INSERT INTO `sys_captcha` VALUES ('ac395b62-037a-4eaa-8875-d994063fad87', '2an65', '2023-10-31 09:50:26');
INSERT INTO `sys_captcha` VALUES ('ae529c72-57d3-4b13-815f-a9f80afde07a', '5xp48', '2023-09-06 17:43:07');
INSERT INTO `sys_captcha` VALUES ('b3b12355-b3c4-4348-8a84-20fa9d3c185d', 'n8n45', '2023-11-28 11:45:20');
INSERT INTO `sys_captcha` VALUES ('c4e19e68-3e28-4906-8300-87cc9929cd91', '4egcy', '2023-10-08 10:19:05');
INSERT INTO `sys_captcha` VALUES ('c788753e-ab7b-484a-8b0e-263450f88acb', 'y7a35', '2023-04-19 09:11:15');
INSERT INTO `sys_captcha` VALUES ('c82d35ee-e012-4f43-843c-b35d25225360', '3b3db', '2023-09-06 17:35:45');
INSERT INTO `sys_captcha` VALUES ('c9edde57-3126-4e23-8f39-afa7c1bf2f38', 'g6cfp', '2023-10-10 17:15:30');
INSERT INTO `sys_captcha` VALUES ('d0e824db-8dd3-463c-8910-896cfa3669f3', 'me7x5', '2023-10-23 17:27:28');
INSERT INTO `sys_captcha` VALUES ('ef06e377-235a-49b5-848c-015cc170fbaf', '788bw', '2023-10-23 09:18:10');
INSERT INTO `sys_captcha` VALUES ('fa266e9f-fded-45fd-8807-045bb761776c', '3acan', '2023-09-06 17:25:49');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(0) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = '系统配置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(0) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1722531901300871170 COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1716272493220581377 COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'system', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', 'sys/user', NULL, 1, 'admin', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', NULL, 1, 'role', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'sys/menu', NULL, 1, 'menu', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'http://localhost:8080/renren-fast/druid/sql.html', NULL, 1, 'sql', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'job/schedule', NULL, 1, 'job', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:list', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'sys/config', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'config', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'sys/log', 'sys:log:list', 1, 'log', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'oss/oss', 'sys:oss:all', 1, 'oss', 6);
INSERT INTO `sys_menu` VALUES (100, 0, '备案申请', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu` VALUES (110, 100, '备案申请', 'nfrecord/apply', NULL, 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (111, 110, '查看', NULL, 'nfrecord:apply:list,nfrecord:apply:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (112, 110, '新增', NULL, 'nfrecord:apply:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (113, 110, '修改', NULL, 'nfrecord:apply:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (114, 110, '删除', NULL, 'nfrecord:apply:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (120, 100, '变更申请', 'nfrecord/change', '', 1, 'log', 2);
INSERT INTO `sys_menu` VALUES (121, 120, '查看', NULL, 'nfrecord:change:list,nfrecord:change:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (122, 120, '新增', NULL, 'nfrecord:change:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (123, 120, '修改', NULL, 'nfrecord:change:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (124, 120, '删除', NULL, 'nfrecord:change:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (130, 100, '注销申请', 'nfrecord/cancel', '', 1, 'log', 3);
INSERT INTO `sys_menu` VALUES (131, 130, '查看', NULL, 'nfrecord:cancel:list,nfrecord:cancel:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (132, 130, '新增', NULL, 'nfrecord:cancel:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (133, 130, '修改', NULL, 'nfrecord:cancel:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (134, 130, '删除', NULL, 'nfrecord:cancel:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (200, 0, '备案受理', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu` VALUES (210, 200, '备案受理', 'nfrecord/applya', NULL, 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (211, 210, '查看', NULL, 'nfrecord:applya:list,nfrecord:applya:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (212, 210, '受理', NULL, 'nfrecord:applya:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (213, 210, '修改', NULL, 'nfrecord:applya:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (220, 200, '变更受理', 'nfrecord/changea', '', 1, 'log', 2);
INSERT INTO `sys_menu` VALUES (221, 220, '查看', NULL, 'nfrecord:changea:list,nfrecord:changea:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (222, 220, '受理', NULL, 'nfrecord:changea:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (223, 220, '修改', NULL, 'nfrecord:changea:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (230, 200, '注销受理', 'nfrecord/cancela', '', 1, 'log', 3);
INSERT INTO `sys_menu` VALUES (231, 230, '查看', NULL, 'nfrecord:cancela:list,nfrecord:cancela:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (232, 230, '受理', NULL, 'nfrecord:cancela:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (233, 230, '修改', NULL, 'nfrecord:cancela:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (300, 0, '备案审核', NULL, NULL, 0, 'log', 1);
INSERT INTO `sys_menu` VALUES (310, 300, '备案审核', 'nfrecord/applyc', NULL, 1, 'log', 1);
INSERT INTO `sys_menu` VALUES (311, 310, '查看', NULL, 'nfrecord:applyc:list,nfrecord:applyc:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (312, 310, '审核', NULL, 'nfrecord:applyc:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (313, 310, '修改', NULL, 'nfrecord:applyc:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (320, 300, '变更审核', 'nfrecord/changec', '', 1, 'log', 2);
INSERT INTO `sys_menu` VALUES (321, 320, '查看', NULL, 'nfrecord:changec:list,nfrecord:changec:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (322, 320, '审核', NULL, 'nfrecord:changec:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (323, 320, '修改', NULL, 'nfrecord:changec:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (330, 300, '注销审核', 'nfrecord/cancelc', '', 1, 'log', 3);
INSERT INTO `sys_menu` VALUES (331, 330, '查看', NULL, 'nfrecord:cancelc:list,nfrecord:cancelc:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (332, 330, '审核', NULL, 'nfrecord:cancelc:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (333, 330, '修改', NULL, 'nfrecord:cancelc:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (400, 0, '审核完成', '', '', 0, 'log', 1);
INSERT INTO `sys_menu` VALUES (401, 400, '出库or入库', 'nfrecord/check', 'nfrecord:check:list', 1, NULL, 1);
INSERT INTO `sys_menu` VALUES (402, 400, '备案查询', 'nfrecord/statistics', 'nfrecord:statistics:list', 1, NULL, 2);
INSERT INTO `sys_menu` VALUES (403, 400, '入库统计', 'nfrecord/inbound', 'nfrecord:inbound:list', 1, NULL, 3);
INSERT INTO `sys_menu` VALUES (404, 400, '风险警告', 'nfrecord/warn', 'nfrecord:warn:list', 1, NULL, 4);
INSERT INTO `sys_menu` VALUES (405, 400, '补录', 'nfrecord/repair', 'repair', 1, 'bianji', 0);
INSERT INTO `sys_menu` VALUES (406, 400, '查询统计', 'nfrecord/statisticsex', 'nfrecord:statisticsex:list', 1, NULL, 5);
INSERT INTO `sys_menu` VALUES (1716264069531353089, 0, '工业安全落实', 'practicable/practicable', '', 1, 'jiesuo', 0);
INSERT INTO `sys_menu` VALUES (1716272493220581377, 1716264069531353089, '新增', '', 'practicable:practicable:save', 2, '', 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1699317886409916417 COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1699317886409916417, '测试角色', '', 1, '2023-09-06 15:05:31');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(0) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1716272549164208130 COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1716272544865046530, 1699317886409916417, 300);
INSERT INTO `sys_role_menu` VALUES (1716272545322225665, 1699317886409916417, 322);
INSERT INTO `sys_role_menu` VALUES (1716272545758433282, 1699317886409916417, 401);
INSERT INTO `sys_role_menu` VALUES (1716272546203029505, 1699317886409916417, 403);
INSERT INTO `sys_role_menu` VALUES (1716272546651820033, 1699317886409916417, 404);
INSERT INTO `sys_role_menu` VALUES (1716272547071250434, 1699317886409916417, 405);
INSERT INTO `sys_role_menu` VALUES (1716272547507458049, 1699317886409916417, 1716264069531353089);
INSERT INTO `sys_role_menu` VALUES (1716272547939471362, 1699317886409916417, 1716272493220581377);
INSERT INTO `sys_role_menu` VALUES (1716272548354707457, 1699317886409916417, -666666);
INSERT INTO `sys_role_menu` VALUES (1716272548769943553, 1699317886409916417, 320);
INSERT INTO `sys_role_menu` VALUES (1716272549164208130, 1699317886409916417, 400);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) NULL DEFAULT NULL COMMENT '手机号',
  `orgcode` varchar(10) NULL DEFAULT NULL COMMENT '用户隶属机构代码',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1722531899811893250 COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', NULL, 1, 1, '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES (1696351542135652354, '1234', '16b1609cbca45e63d01fcd72322db0f4d5172a950d9a26d7cea72f3d1bcec906', 'Q31ExGNRkHrGrpTJcI9o', '441146700@qq.com', '17859510298', '230400', 1, 1, '2023-08-29 10:38:19');
INSERT INTO `sys_user` VALUES (1721751250743857153, '111', '9718900adef415a2ea3e238e09b55a1891195552dd9ba214e97cce64c3ec6ee3', 'WujEH4ICDkeAhBHWG4oz', '441146700@qq.com', '17859510298', '230800', 1, 1, '2023-11-07 12:47:41');
INSERT INTO `sys_user` VALUES (1721783706243112961, '213', '0164976d063863ee6423b6caa23e48c3072f08ff11fecf0293c9313df62b7f49', 'MLIrsA5cWPWNp0xM85tX', '441146700@qq.com', '12321312312', '230400', 1, 1, '2023-11-07 14:56:39');
INSERT INTO `sys_user` VALUES (1721783908244987906, '21321', 'c7a556cf1af9956a4c2d07f37c35eb4f9009a48e5cc24c2e2e9070a229680961', 'w5dW6G1WgvGYtxRFIgei', '441146700@qq.com', '17859510299', '230600', 1, 1, '2023-11-07 14:57:28');
INSERT INTO `sys_user` VALUES (1722531309098700802, 'qqq', '76d874eba446eb39e27f15e742f24f8d5717a1eb32a7ba85655d8d36571842f6', 'Wn6QNMxZFzRsx09dWGKV', '441146700@qq.com', '17859510299', '230000', 1, 1, '2023-11-09 16:27:22');
INSERT INTO `sys_user` VALUES (1722531543065366529, 'asd', 'dfecbc35815e55edeec8eaedeb2a9885dfda09fff9f239461bb7561c95d6a702', '0aUvLgc3nL8YpHbIMXqi', '441146700@qq.com', '12345678910', '230000', 1, 1, '2023-11-09 16:28:18');
INSERT INTO `sys_user` VALUES (1722531649864929282, '11', 'd2865ca6222f5f61700c4f4e249df41a830070c081cf63188ff154edf1fba064', 'ZWyqpvq8m6RwslMOgDlB', '441146700@qq.com', '12345678999', '230000', 1, 1, '2023-11-09 16:28:43');
INSERT INTO `sys_user` VALUES (1722531719045779458, '12', '8e7e9c936cab4f23f2df422015906dc3edfef5193a418ded181cd5289e05d629', 'r79pKOmE3YHrsEKYO9sR', '441146700@qq.com', '12345678999', '230000', 1, 1, '2023-11-09 16:29:00');
INSERT INTO `sys_user` VALUES (1722531819948150786, '44', 'b7672ac3efdcb4791b7d01dc780b8bf26d812fb7f4fcf8ac208dc62f7bf75346', 'JaCrvUtYudiBRhxGahkJ', '441146700@qq.com', '11111111111', '230000', 1, 1, '2023-11-09 16:29:24');
INSERT INTO `sys_user` VALUES (1722531899811893250, '55', 'fb1a100c41a955a455a2d7f7fb1a3ee1b2453ee0dfd32541f41f90278f33db05', '4ktKL19rEU1TU6ZblZtn', '441146700@qq.com', '11111111111', '230000', 1, 1, '2023-11-09 16:29:43');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1699317972095352834 COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1699317972095352834, 1696351542135652354, 1699317886409916417);

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(0) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, 'b65098aedaea9dd84ac146eef4a627a4', '2023-12-01 02:49:54', '2023-11-30 14:49:54');
INSERT INTO `sys_user_token` VALUES (1696351542135652354, 'fbb1b1d1f2dac4968697b3c05aa5e79e', '2023-09-07 22:24:45', '2023-09-07 10:24:45');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

SET FOREIGN_KEY_CHECKS = 1;