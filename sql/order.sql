/*
 Navicat Premium Data Transfer

 Source Server         : dwah
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/08/2024 05:48:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '工单id',
  `order_no` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工单编号（必填）',
  `order_type` tinyint(0) NOT NULL COMMENT '工单状态 0 交办 1 直接答复 3无效工单（必填）',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题（必填）',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容（必填）',
  `handle_dept_id` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理部门',
  `create_time` date NOT NULL COMMENT '创建时间（必填）',
  `fenpai_time` date NULL DEFAULT NULL COMMENT '分派时间',
  `is_overdue` tinyint(1) NULL DEFAULT NULL COMMENT '是否超期 0否 1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '20241H1221023', 0, '这是个测试工单', '测试工单内容', '1', '2024-08-08', '2024-08-08', 0);
INSERT INTO `order` VALUES (2, '20241H1221023', 1, '这是个测试工单', '测试工单内容', '1', '2024-08-08', '2024-08-08', 1);
INSERT INTO `order` VALUES (8, '20241H122102311', 0, '这是个测试工单', '测试工单内容', '2', '2024-08-09', NULL, 1);
INSERT INTO `order` VALUES (9, '20241H122102312', 0, '这是个测试工单', '测试工单内容', '2', '2024-08-09', NULL, 1);
INSERT INTO `order` VALUES (10, '20241H1221023122', 0, '这是个测试工单', '测试工单内容', '3', '2024-08-09', NULL, 1);
INSERT INTO `order` VALUES (11, '20241H12210231212', 0, '这是个测试工单', '测试工单内容', '3', '2024-08-09', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
