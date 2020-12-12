CREATE DATABASE IF NOT EXISTS `chiron`;
USE `chiron`;

-- 用户
CREATE TABLE IF NOT EXISTS `T_user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) UNIQUE COMMENT '管理员以a开头，教师用户名以t开头，学生用户名以s开头',
    `password` VARCHAR(50) COMMENT '密码',
    `name` VARCHAR(50) COMMENT '姓名',
    `sex` VARCHAR(50) COMMENT '性别',
    `age` INT COMMENT '年龄',
    `class_id` INT COMMENT '所在班级',
    `type` INT COMMENT '0为管理员，1为教师，2为学生',
    PRIMARY KEY (`id`)
);

-- 班级
CREATE TABLE IF NOT EXISTS `T_class` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `classNo` VARCHAR(50) UNIQUE COMMENT '班级编号以c开头',
    `className` VARCHAR(50) COMMENT '班级名称',
    PRIMARY KEY (`id`)
);

-- 教师布置作业
CREATE TABLE IF NOT EXISTS `T_homework` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `teacher_id` INT COMMENT '布置作业教师ID',
    `title` VARCHAR(50) COMMENT '作业名称',
    `describe` VARCHAR(50) COMMENT '作业内容',
    `class_id` INT COMMENT '班级ID',
    `end_time` VARCHAR(50) COMMENT '结束时间',
    `attachment_title` VARCHAR(255) COMMENT '作业附件标题',
    `attachment_url` VARCHAR(255) COMMENT '作业附件路径',
    PRIMARY KEY (`id`)
);

-- 学生提交作业
CREATE TABLE IF NOT EXISTS `T_student_homework` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `hw_id` INT COMMENT '作业id',
    `s_id` INT COMMENT '学生id（学生信息）',
    `title` VARCHAR(50) COMMENT '学生作业名称',
    `describe` VARCHAR(255) COMMENT '描述',
    `status` BOOL COMMENT '审阅状态',
    `review_content` VARCHAR(255) COMMENT '评阅意见（内容）',
    `review_time` VARCHAR(50) COMMENT '评阅时间',
    `attachment_title` VARCHAR(50) COMMENT '作业附件标题',
    `attachment_url` VARCHAR(255) COMMENT '文件保存路径',
    PRIMARY KEY (`id`)
);

-- 留言板留言
CREATE TABLE IF NOT EXISTS `T_message` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(50) COMMENT '标题',
    `content` VARCHAR(255) COMMENT '内容',
    `create_time` VARCHAR(50) COMMENT '发布时间',
    PRIMARY KEY (`id`)
);

-- 公告栏公告
CREATE TABLE IF NOT EXISTS `T_notice` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) COMMENT '标题',
    `content` VARCHAR(255) COMMENT '公告内容',
    `create_time` VARCHAR(255) COMMENT '创建时间',
    PRIMARY KEY (`id`)
);
