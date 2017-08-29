-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.24a-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Definition of table `test`.`emp_detail`
--

DROP TABLE IF EXISTS `test`.`emp_detail`;
CREATE TABLE  `test`.`emp_detail` (
  `emp_id` int(10) unsigned NOT NULL auto_increment,
  `emp_name` varchar(45) NOT NULL,
  `emp_address` varchar(45) NOT NULL,
  `emp_mobile` double NOT NULL,
  PRIMARY KEY  (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`emp_detail`
--

/*!40000 ALTER TABLE `emp_detail` DISABLE KEYS */;
INSERT INTO `test`.`emp_detail` (`emp_id`,`emp_name`,`emp_address`,`emp_mobile`) VALUES 
 (1,'Piyush','surat',9898141452);
/*!40000 ALTER TABLE `emp_detail` ENABLE KEYS */;


--
-- Definition of table `test`.`emplogin`
--

DROP TABLE IF EXISTS `test`.`emplogin`;
CREATE TABLE  `test`.`emplogin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`emplogin`
--

/*!40000 ALTER TABLE `emplogin` DISABLE KEYS */;
INSERT INTO `test`.`emplogin` (`username`,`password`) VALUES 
 ('admin','cct');
/*!40000 ALTER TABLE `emplogin` ENABLE KEYS */;


--
-- Definition of table `test`.`higest_qulification`
--

DROP TABLE IF EXISTS `test`.`higest_qulification`;
CREATE TABLE  `test`.`higest_qulification` (
  `qid` int(10) unsigned NOT NULL auto_increment,
  `qname` varchar(20) NOT NULL,
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`higest_qulification`
--

/*!40000 ALTER TABLE `higest_qulification` DISABLE KEYS */;
INSERT INTO `test`.`higest_qulification` (`qid`,`qname`) VALUES 
 (1,'M.TECH'),
 (2,'B.TECH'),
 (3,'M.C.A'),
 (4,'B.C.A'),
 (5,'M.SC(CS)');
/*!40000 ALTER TABLE `higest_qulification` ENABLE KEYS */;


--
-- Definition of table `test`.`person_register`
--

DROP TABLE IF EXISTS `test`.`person_register`;
CREATE TABLE  `test`.`person_register` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dateofbirth` date default NULL,
  `address` varchar(45) default NULL,
  `mobileno` bigint(20) unsigned default NULL,
  `hid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`pid`,`hid`),
  KEY `FK_person_register_hq` (`hid`),
  CONSTRAINT `FK_person_register_hq` FOREIGN KEY (`hid`) REFERENCES `higest_qulification` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`person_register`
--

/*!40000 ALTER TABLE `person_register` DISABLE KEYS */;
INSERT INTO `test`.`person_register` (`pid`,`firstname`,`lastname`,`gender`,`dateofbirth`,`address`,`mobileno`,`hid`) VALUES 
 (1,'Piyush','chaudhari','MALE','2012-01-04','Ahmedabad',9898974010,3),
 (2,'Romit','Mewada','MALE','2012-01-27','Gandinager',7878456545,2),
 (3,'Hardik','Shah','FEMALE','2012-01-07','Kalol',8585898978,3),
 (4,'Keyur','belani','FEMALE','2012-01-13','Bapunager',7878454512,1),
 (7,'Raju','Shah','MALE','2008-05-29','Bapunager',989845000,1);
/*!40000 ALTER TABLE `person_register` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
