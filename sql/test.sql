/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.37 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_name` varchar(128) DEFAULT NULL COMMENT '课程名',
  `credit` float DEFAULT NULL COMMENT '课程学分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_name` (`course_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

insert  into `t_course`(`id`,`course_name`,`credit`) values (1,'计算机1',6),(2,'计算机2',6),(3,'计算机3',6);

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stud_name` varchar(128) DEFAULT NULL COMMENT '学生姓名',
  `sex` tinyint(3) unsigned DEFAULT '1' COMMENT '学生性别 1-男 2-女',
  `grade` int(11) DEFAULT NULL COMMENT '学生年级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`stud_name`,`sex`,`grade`) values (1,'李四',2,1),(2,'王五',2,1),(3,'张三',1,1);

/*Table structure for table `t_student_course` */

DROP TABLE IF EXISTS `t_student_course`;

CREATE TABLE `t_student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stud_id` bigint(20) unsigned DEFAULT NULL COMMENT '学生id',
  `course_id` bigint(20) unsigned DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stud_id` (`stud_id`,`course_id`),
  KEY `fk_course` (`course_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stud` FOREIGN KEY (`stud_id`) REFERENCES `t_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_student_course` */

insert  into `t_student_course`(`id`,`stud_id`,`course_id`) values (3,1,1),(2,1,2),(5,1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
