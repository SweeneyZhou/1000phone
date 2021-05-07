/*
Navicat MySQL Data Transfer

Source Server         : java2101
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : companydb

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2021-04-30 15:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '张三', '1000');
INSERT INTO `account` VALUES ('2', '李四', '1000');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '开发组');
INSERT INTO `groups` VALUES ('2', '调研组');
INSERT INTO `groups` VALUES ('3', '测试组');
INSERT INTO `groups` VALUES ('4', '前端组');
INSERT INTO `groups` VALUES ('5', '公关组');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '100');
INSERT INTO `test` VALUES ('2', '200');
INSERT INTO `test` VALUES ('3', null);
INSERT INTO `test` VALUES ('4', '300');

-- ----------------------------
-- Table structure for t_countries
-- ----------------------------
DROP TABLE IF EXISTS `t_countries`;
CREATE TABLE `t_countries` (
  `COUNTRY_ID` varchar(255) NOT NULL,
  `COUNTRY_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_countries
-- ----------------------------
INSERT INTO `t_countries` VALUES ('AR', 'Argentina');
INSERT INTO `t_countries` VALUES ('AU', 'Australia');
INSERT INTO `t_countries` VALUES ('BE', 'Belgium');
INSERT INTO `t_countries` VALUES ('BR', 'Brazil');
INSERT INTO `t_countries` VALUES ('CA', 'Canada');
INSERT INTO `t_countries` VALUES ('CH', 'Switzerland');
INSERT INTO `t_countries` VALUES ('CN', 'China');
INSERT INTO `t_countries` VALUES ('DE', 'Germany');
INSERT INTO `t_countries` VALUES ('DK', 'Denmark');
INSERT INTO `t_countries` VALUES ('EG', 'Egypt');
INSERT INTO `t_countries` VALUES ('FR', 'France');
INSERT INTO `t_countries` VALUES ('HK', 'HongKong');
INSERT INTO `t_countries` VALUES ('IL', '');
INSERT INTO `t_countries` VALUES ('IN', 'India');
INSERT INTO `t_countries` VALUES ('IT', 'Italy');
INSERT INTO `t_countries` VALUES ('JP', 'Japan');
INSERT INTO `t_countries` VALUES ('KW', 'Kuwait');
INSERT INTO `t_countries` VALUES ('MX', 'Mexico');
INSERT INTO `t_countries` VALUES ('NG', 'Nigeria');
INSERT INTO `t_countries` VALUES ('NL', 'Netherlands');
INSERT INTO `t_countries` VALUES ('SG', 'Singapore');
INSERT INTO `t_countries` VALUES ('UK', 'United Kingdom');
INSERT INTO `t_countries` VALUES ('US', 'United States of America');
INSERT INTO `t_countries` VALUES ('ZM', 'Zambia');
INSERT INTO `t_countries` VALUES ('ZW', 'Zimbabwe');

-- ----------------------------
-- Table structure for t_departments
-- ----------------------------
DROP TABLE IF EXISTS `t_departments`;
CREATE TABLE `t_departments` (
  `DEPARTMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` varchar(255) DEFAULT NULL,
  `MANAGER_ID` varchar(255) DEFAULT NULL,
  `LOCATION_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_departments
-- ----------------------------
INSERT INTO `t_departments` VALUES ('10', 'Administration', '200', '1700');
INSERT INTO `t_departments` VALUES ('20', 'Marketing', '201', '1800');
INSERT INTO `t_departments` VALUES ('30', 'Purchasing', '114', '1700');
INSERT INTO `t_departments` VALUES ('40', 'Human Resources', '203', '2400');
INSERT INTO `t_departments` VALUES ('50', 'Shipping', '121', '1500');
INSERT INTO `t_departments` VALUES ('60', 'IT', '103', '1400');
INSERT INTO `t_departments` VALUES ('70', 'Public Relations', '204', '2700');
INSERT INTO `t_departments` VALUES ('80', 'Sales', '145', '2500');
INSERT INTO `t_departments` VALUES ('90', 'Executive', '100', '2000');
INSERT INTO `t_departments` VALUES ('100', 'Finance', '108', '1700');
INSERT INTO `t_departments` VALUES ('110', 'Accounting', '205', '1700');
INSERT INTO `t_departments` VALUES ('120', 'Treasury', null, '1700');
INSERT INTO `t_departments` VALUES ('130', 'Corporate Tax', null, '1700');
INSERT INTO `t_departments` VALUES ('140', 'Control And Credit', null, '1700');
INSERT INTO `t_departments` VALUES ('150', 'Shareholder Services', null, '1700');
INSERT INTO `t_departments` VALUES ('160', 'Benefits', null, '1700');
INSERT INTO `t_departments` VALUES ('170', 'Manufacturing', null, '1700');
INSERT INTO `t_departments` VALUES ('180', 'Construction', null, '1700');
INSERT INTO `t_departments` VALUES ('190', 'Contracting', null, '1700');
INSERT INTO `t_departments` VALUES ('200', 'Operations', null, '1700');
INSERT INTO `t_departments` VALUES ('210', 'IT Support', null, '1700');
INSERT INTO `t_departments` VALUES ('220', 'NOC', null, '1700');
INSERT INTO `t_departments` VALUES ('230', 'IT Helpdesk', null, '1700');
INSERT INTO `t_departments` VALUES ('240', 'Government Sales', null, '1700');
INSERT INTO `t_departments` VALUES ('250', 'Retail Sales', null, '1700');
INSERT INTO `t_departments` VALUES ('260', 'Recruiting', null, '1700');
INSERT INTO `t_departments` VALUES ('270', 'Payroll', null, '1700');
INSERT INTO `t_departments` VALUES ('280', '外交部', null, null);

-- ----------------------------
-- Table structure for t_employees
-- ----------------------------
DROP TABLE IF EXISTS `t_employees`;
CREATE TABLE `t_employees` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `HIRE_DATE` date DEFAULT NULL,
  `JOB_ID` varchar(255) DEFAULT NULL,
  `SALARY` int(11) DEFAULT NULL,
  `COMM` decimal(3,2) DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL,
  `PIC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_employees
-- ----------------------------
INSERT INTO `t_employees` VALUES ('100', '杨景言', 'james', 'yyyyy@qq.com', '123123123123', '2020-03-08', 'SH_CLERK', '25000', null, null, '90', 'upload/1.jpg');
INSERT INTO `t_employees` VALUES ('101', 'Neena', 'james', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', '17000', null, '100', '100', null);
INSERT INTO `t_employees` VALUES ('102', 'Lex', 'james', 'LDEHAAN', '515.123.4569', '1993-01-13', 'AD_VP', '17000', null, '100', '40', null);
INSERT INTO `t_employees` VALUES ('103', 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1990-01-03', 'IT_PROG', '9000', null, '102', '60', null);
INSERT INTO `t_employees` VALUES ('104', 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1991-05-21', 'IT_PROG', '6000', null, '103', '60', null);
INSERT INTO `t_employees` VALUES ('105', 'David', 'Austin', 'DAUSTIN', '590.423.4569', '1997-06-25', 'IT_PROG', '4800', null, '103', '60', null);
INSERT INTO `t_employees` VALUES ('106', 'Valli', 'Pataballa', 'VPATABAL', '590.423.4560', '1998-02-05', 'IT_PROG', '4800', null, '103', '60', null);
INSERT INTO `t_employees` VALUES ('108', 'Nancy', 'Greenberg', 'NGREENBE', '515.124.4569', '1994-08-17', 'FI_MGR', '12000', null, '101', '100', null);
INSERT INTO `t_employees` VALUES ('110', 'John', 'Chen', 'JCHEN', '515.124.4269', '1997-09-28', 'FI_ACCOUNT', '8200', null, '108', '100', null);
INSERT INTO `t_employees` VALUES ('112', 'Jose Manuel', 'Urman', 'JMURMAN', '515.124.4469', '1998-03-07', 'FI_ACCOUNT', '7800', null, '108', '100', null);
INSERT INTO `t_employees` VALUES ('113', 'Luis', 'Popp', 'LPOPP', '515.124.4567', '1999-12-07', 'FI_ACCOUNT', '6900', null, '108', '100', null);
INSERT INTO `t_employees` VALUES ('114', 'Den', 'Raphaely', 'DRAPHEAL', '515.127.4561', '1994-12-07', 'PU_MAN', '11000', null, '100', '30', null);
INSERT INTO `t_employees` VALUES ('115', 'Alexander', 'Khoo', 'AKHOO', '515.127.4562', '1995-05-18', 'PU_CLERK', '3100', null, '114', '30', null);
INSERT INTO `t_employees` VALUES ('116', 'Shelli', 'Baida', 'SBAIDA', '515.127.4563', '1997-12-24', 'PU_CLERK', '2900', null, '114', '30', null);
INSERT INTO `t_employees` VALUES ('117', 'Sigal', 'Tobias', 'STOBIAS', '515.127.4564', '1997-07-24', 'PU_CLERK', '2800', null, '114', '30', null);
INSERT INTO `t_employees` VALUES ('118', 'Guy', 'Himuro', 'GHIMURO', '515.127.4565', '1998-11-15', 'PU_CLERK', '2600', null, '114', '30', null);
INSERT INTO `t_employees` VALUES ('119', 'Karen', 'Colmenares', 'KCOLMENA', '515.127.4566', '1999-08-10', 'PU_CLERK', '2500', null, '114', '30', null);
INSERT INTO `t_employees` VALUES ('120', 'Matthew', 'Weiss', 'MWEISS', '650.123.1234', '1996-07-18', 'ST_MAN', '8000', null, '100', '50', null);
INSERT INTO `t_employees` VALUES ('121', 'Adam', 'Fripp', 'AFRIPP', '650.123.2234', '1997-04-10', 'ST_MAN', '8200', null, '100', '50', null);
INSERT INTO `t_employees` VALUES ('122', 'Payam', 'Kaufling', 'PKAUFLIN', '650.123.3234', '1995-05-01', 'ST_MAN', '7900', null, '100', '50', null);
INSERT INTO `t_employees` VALUES ('123', 'Shanta', 'Vollman', 'SVOLLMAN', '650.123.4234', '1997-10-10', 'ST_MAN', '6500', null, '100', '50', null);
INSERT INTO `t_employees` VALUES ('124', 'Kevin', 'Mourgos', 'KMOURGOS', '650.123.5234', '1999-11-16', 'ST_MAN', '5800', null, '100', '50', null);
INSERT INTO `t_employees` VALUES ('125', 'Julia', 'Nayer', 'JNAYER', '650.124.1214', '1997-07-16', 'ST_CLERK', '3200', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('126', 'Irene', 'Mikkilineni', 'IMIKKILI', '650.124.1224', '1998-09-28', 'ST_CLERK', '2700', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('127', 'James', 'Landry', 'JLANDRY', '650.124.1334', '1999-01-14', 'ST_CLERK', '2400', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('128', 'Steven', 'Markle', 'SMARKLE', '650.124.1434', '2000-03-08', 'ST_CLERK', '2200', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('129', 'Laura', 'Bissot', 'LBISSOT', '650.124.5234', '1997-08-20', 'ST_CLERK', '3300', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('130', 'Mozhe', 'Atkinson', 'MATKINSO', '650.124.6234', '1997-10-30', 'ST_CLERK', '2800', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('131', 'James', 'Marlow', 'JAMRLOW', '650.124.7234', '1997-02-16', 'ST_CLERK', '2500', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('132', 'TJ', 'Olson', 'TJOLSON', '650.124.8234', '1999-04-10', 'ST_CLERK', '2100', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('133', 'Jason', 'Mallin', 'JMALLIN', '650.127.1934', '1996-06-14', 'ST_CLERK', '3300', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('134', 'Michael', 'Rogers', 'MROGERS', '650.127.1834', '1998-08-26', 'ST_CLERK', '2900', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('135', 'Ki', 'Gee', 'KGEE', '650.127.1734', '1999-12-12', 'ST_CLERK', '2400', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('136', 'Hazel', 'Philtanker', 'HPHILTAN', '650.127.1634', '2000-02-06', 'ST_CLERK', '2200', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('137', 'Renske', 'Ladwig', 'RLADWIG', '650.121.1234', '1995-07-14', 'ST_CLERK', '3600', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('138', 'Stephen', 'Stiles', 'SSTILES', '650.121.2034', '1997-10-26', 'ST_CLERK', '3200', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('139', 'John', 'Seo', 'JSEO', '650.121.2019', '1998-02-12', 'ST_CLERK', '2700', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('140', 'Joshua', 'Patel', 'JPATEL', '650.121.1834', '1998-04-06', 'ST_CLERK', '2500', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('141', 'Trenna', 'Rajs', 'TRAJS', '650.121.8009', '1995-10-17', 'ST_CLERK', '3500', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('142', 'Curtis', 'Davies', 'CDAVIES', '650.121.2994', '1997-01-29', 'ST_CLERK', '3100', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('143', 'Randall', 'Matos', 'RMATOS', '650.121.2874', '1998-03-15', 'ST_CLERK', '2600', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('144', 'Peter', 'Vargas', 'PVARGAS', '650.121.2004', '1998-07-09', 'ST_CLERK', '2500', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('145', 'John', 'Russell', 'JRUSSEL', '011.44.1344.429268', '1996-10-01', 'SA_MAN', '14000', '0.40', '100', '80', null);
INSERT INTO `t_employees` VALUES ('146', 'Karen', 'Partners', 'KPARTNER', '011.44.1344.467268', '1997-01-05', 'SA_MAN', '13500', '0.30', '100', '80', null);
INSERT INTO `t_employees` VALUES ('147', 'Alberto', 'Errazuriz', 'AERRAZUR', '011.44.1344.429278', '1997-03-10', 'SA_MAN', '12000', '0.30', '100', '80', null);
INSERT INTO `t_employees` VALUES ('148', 'Gerald', 'Cambrault', 'GCAMBRAU', '011.44.1344.619268', '1999-10-15', 'SA_MAN', '11000', '0.30', '100', '80', null);
INSERT INTO `t_employees` VALUES ('149', 'Eleni', 'Zlotkey', 'EZLOTKEY', '011.44.1344.429018', '2000-01-29', 'SA_MAN', '10500', '0.20', '100', '80', null);
INSERT INTO `t_employees` VALUES ('150', 'Peter', 'Tucker', 'PTUCKER', '011.44.1344.129268', '1997-01-30', 'SA_REP', '10000', '0.30', '145', '80', null);
INSERT INTO `t_employees` VALUES ('151', 'David', 'Bernstein', 'DBERNSTE', '011.44.1344.345268', '1997-03-24', 'SA_REP', '9500', '0.25', '145', '80', null);
INSERT INTO `t_employees` VALUES ('152', 'Peter', 'Hall', 'PHALL', '011.44.1344.478968', '1997-08-20', 'SA_REP', '9000', '0.25', '145', '80', null);
INSERT INTO `t_employees` VALUES ('153', 'Christopher', 'Olsen', 'COLSEN', '011.44.1344.498718', '1998-03-30', 'SA_REP', '8000', '0.20', '145', '80', null);
INSERT INTO `t_employees` VALUES ('154', 'Nanette', 'Cambrault', 'NCAMBRAU', '011.44.1344.987668', '1998-12-09', 'SA_REP', '7500', '0.20', '145', '80', null);
INSERT INTO `t_employees` VALUES ('155', 'Oliver', 'Tuvault', 'OTUVAULT', '011.44.1344.486508', '1999-11-23', 'SA_REP', '7000', '0.15', '145', '80', null);
INSERT INTO `t_employees` VALUES ('156', 'Janette', 'King', 'JKING', '011.44.1345.429268', '1996-01-30', 'SA_REP', '10000', '0.35', '146', '80', null);
INSERT INTO `t_employees` VALUES ('157', 'Patrick', 'Sully', 'PSULLY', '011.44.1345.929268', '1996-03-04', 'SA_REP', '9500', '0.35', '146', '80', null);
INSERT INTO `t_employees` VALUES ('158', 'Allan', 'McEwen', 'AMCEWEN', '011.44.1345.829268', '1996-08-01', 'SA_REP', '9000', '0.35', '146', '80', null);
INSERT INTO `t_employees` VALUES ('159', 'Lindsey', 'Smith', 'LSMITH', '011.44.1345.729268', '1997-03-10', 'SA_REP', '8000', '0.30', '146', '80', null);
INSERT INTO `t_employees` VALUES ('160', 'Louise', 'Doran', 'LDORAN', '011.44.1345.629268', '1997-12-15', 'SA_REP', '7500', '0.30', '146', '80', null);
INSERT INTO `t_employees` VALUES ('161', 'Sarath', 'Sewall', 'SSEWALL', '011.44.1345.529268', '1998-11-03', 'SA_REP', '7000', '0.25', '146', '80', null);
INSERT INTO `t_employees` VALUES ('162', 'Clara', 'Vishney', 'CVISHNEY', '011.44.1346.129268', '1997-11-11', 'SA_REP', '10500', '0.25', '147', '80', null);
INSERT INTO `t_employees` VALUES ('163', 'Danielle', 'Greene', 'DGREENE', '011.44.1346.229268', '1999-03-19', 'SA_REP', '9500', '0.15', '147', '80', null);
INSERT INTO `t_employees` VALUES ('164', 'Mattea', 'Marvins', 'MMARVINS', '011.44.1346.329268', '2000-01-24', 'SA_REP', '7200', '0.10', '147', '80', null);
INSERT INTO `t_employees` VALUES ('165', 'David', 'Lee', 'DLEE', '011.44.1346.529268', '2000-02-23', 'SA_REP', '6800', '0.10', '147', '80', null);
INSERT INTO `t_employees` VALUES ('166', 'Sundar', 'Ande', 'SANDE', '011.44.1346.629268', '2000-03-24', 'SA_REP', '6400', '0.10', '147', '80', null);
INSERT INTO `t_employees` VALUES ('167', 'Amit', 'Banda', 'ABANDA', '011.44.1346.729268', '2000-04-21', 'SA_REP', '6200', '0.10', '147', '80', null);
INSERT INTO `t_employees` VALUES ('168', 'Lisa', 'Ozer', 'LOZER', '011.44.1343.929268', '1997-03-11', 'SA_REP', '11500', '0.25', '148', '80', null);
INSERT INTO `t_employees` VALUES ('169', 'Harrison', 'Bloom', 'HBLOOM', '011.44.1343.829268', '1998-03-23', 'SA_REP', '10000', '0.20', '148', '80', null);
INSERT INTO `t_employees` VALUES ('170', 'Tayler', 'Fox', 'TFOX', '011.44.1343.729268', '1998-01-24', 'SA_REP', '9600', '0.20', '148', '80', null);
INSERT INTO `t_employees` VALUES ('171', 'William', 'Smith', 'WSMITH', '011.44.1343.629268', '1999-02-23', 'SA_REP', '7400', '0.15', '148', '80', null);
INSERT INTO `t_employees` VALUES ('172', 'Elizabeth', 'Bates', 'EBATES', '011.44.1343.529268', '1999-03-24', 'SA_REP', '7300', '0.15', '148', '80', null);
INSERT INTO `t_employees` VALUES ('173', 'Sundita', 'Kumar', 'SKUMAR', '011.44.1343.329268', '2000-04-21', 'SA_REP', '6100', '0.10', '148', '80', null);
INSERT INTO `t_employees` VALUES ('174', 'Ellen', 'Abel', 'EABEL', '011.44.1644.429267', '1996-05-11', 'SA_REP', '11000', '0.30', '149', '80', null);
INSERT INTO `t_employees` VALUES ('175', 'Alyssa', 'Hutton', 'AHUTTON', '011.44.1644.429266', '1997-03-19', 'SA_REP', '8800', '0.25', '149', '80', null);
INSERT INTO `t_employees` VALUES ('176', 'Jonathon', 'Taylor', 'JTAYLOR', '011.44.1644.429265', '1998-03-24', 'SA_REP', '8600', '0.20', '149', '80', null);
INSERT INTO `t_employees` VALUES ('177', 'Jack', 'Livingston', 'JLIVINGS', '011.44.1644.429264', '1998-04-23', 'SA_REP', '8400', '0.20', '149', '80', null);
INSERT INTO `t_employees` VALUES ('178', 'Kimberely', 'Grant', 'KGRANT', '011.44.1644.429263', '1999-05-24', 'SA_REP', '7000', '0.15', '149', '90', null);
INSERT INTO `t_employees` VALUES ('179', 'Charles', 'Johnson', 'CJOHNSON', '011.44.1644.429262', '2000-01-04', 'SA_REP', '6200', '0.10', '149', '80', null);
INSERT INTO `t_employees` VALUES ('180', 'Winston', 'Taylor', 'WTAYLOR', '650.507.9876', '1998-01-24', 'SH_CLERK', '3200', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('181', 'Jean', 'Fleaur', 'JFLEAUR', '650.507.9877', '1998-02-23', 'SH_CLERK', '3100', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('182', 'Martha', 'Sullivan', 'MSULLIVA', '650.507.9878', '1999-06-21', 'SH_CLERK', '2500', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('183', 'Girard', 'Geoni', 'GGEONI', '650.507.9879', '2000-02-03', 'SH_CLERK', '2800', null, '120', '50', null);
INSERT INTO `t_employees` VALUES ('184', 'Nandita', 'Sarchand', 'NSARCHAN', '650.509.1876', '1996-01-27', 'SH_CLERK', '4200', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('185', 'Alexis', 'Bull', 'ABULL', '650.509.2876', '1997-02-20', 'SH_CLERK', '4100', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('186', 'Julia', 'Dellinger', 'JDELLING', '650.509.3876', '1998-06-24', 'SH_CLERK', '3400', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('187', 'Anthony', 'Cabrio', 'ACABRIO', '650.509.4876', '1999-02-07', 'SH_CLERK', '3000', null, '121', '50', null);
INSERT INTO `t_employees` VALUES ('188', 'Kelly', 'Chung', 'KCHUNG', '650.505.1876', '1997-06-14', 'SH_CLERK', '3800', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('189', 'Jennifer', 'Dilly', 'JDILLY', '650.505.2876', '1997-08-13', 'SH_CLERK', '3600', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('190', 'Timothy', 'Gates', 'TGATES', '650.505.3876', '1998-07-11', 'SH_CLERK', '2900', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('191', 'Randall', 'Perkins', 'RPERKINS', '650.505.4876', '1999-12-19', 'SH_CLERK', '2500', null, '122', '50', null);
INSERT INTO `t_employees` VALUES ('192', 'Sarah', 'Bell', 'SBELL', '650.501.1876', '1996-02-04', 'SH_CLERK', '4000', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('193', 'Britney', 'Everett', 'BEVERETT', '650.501.2876', '1997-03-03', 'SH_CLERK', '3900', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('194', 'Samuel', 'McCain', 'SMCCAIN', '650.501.3876', '1998-07-01', 'SH_CLERK', '3200', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('195', 'Vance', 'Jones', 'VJONES', '650.501.4876', '1999-03-17', 'SH_CLERK', '2800', null, '123', '50', null);
INSERT INTO `t_employees` VALUES ('196', 'Alana', 'Walsh', 'AWALSH', '650.507.9811', '1998-04-24', 'SH_CLERK', '3100', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('197', 'Kevin', 'Feeney', 'KFEENEY', '650.507.9822', '1998-05-23', 'SH_CLERK', '3000', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('198', 'Donald', 'OConnell', 'DOCONNEL', '650.507.9833', '1999-06-21', 'SH_CLERK', '2600', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('199', 'Douglas', 'Grant', 'DGRANT', '650.507.9844', '2000-01-13', 'SH_CLERK', '2600', null, '124', '50', null);
INSERT INTO `t_employees` VALUES ('200', 'Jennifer', 'Whalen', 'JWHALEN', '515.123.4444', '1987-09-17', 'AD_ASST', '4400', null, '101', '10', null);
INSERT INTO `t_employees` VALUES ('201', 'Michael', 'Hartstein', 'MHARTSTE', '515.123.5555', '1996-02-17', 'MK_MAN', '13000', null, '100', '20', null);
INSERT INTO `t_employees` VALUES ('202', 'Pat', 'Fay', 'PFAY', '603.123.6666', '1997-08-17', 'MK_REP', '6000', null, '201', '20', null);
INSERT INTO `t_employees` VALUES ('203', 'Susan', 'Mavris', 'SMAVRIS', '515.123.7777', '1994-06-07', 'HR_REP', '6500', null, '101', '40', null);
INSERT INTO `t_employees` VALUES ('204', 'Hermann', 'Baer', 'HBAER', '515.123.8888', '1994-06-07', 'PR_REP', '10000', null, '101', '70', null);
INSERT INTO `t_employees` VALUES ('206', '毛毛', '斌斌', 'maobinbin@qq.com', '111111', '2021-03-04', 'SH_CLERK', '40000', null, '1001', '1001', null);

-- ----------------------------
-- Table structure for t_jobs
-- ----------------------------
DROP TABLE IF EXISTS `t_jobs`;
CREATE TABLE `t_jobs` (
  `JOB_ID` varchar(255) NOT NULL,
  `JOB_TITLE` varchar(255) DEFAULT NULL,
  `MIN_SALARY` int(11) DEFAULT NULL,
  `MAX_SALARY` int(11) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_jobs
-- ----------------------------
INSERT INTO `t_jobs` VALUES ('AC_ACCOUNT', 'Public Accountant', '4200', '9000');
INSERT INTO `t_jobs` VALUES ('AC_MGR', 'Accounting Manager', '8200', '16000');
INSERT INTO `t_jobs` VALUES ('AD_ASST', 'Administration Assistant', '3000', '6000');
INSERT INTO `t_jobs` VALUES ('AD_PRES', 'President', '20000', '40000');
INSERT INTO `t_jobs` VALUES ('AD_VP', 'Administration Vice President', '15000', '30000');
INSERT INTO `t_jobs` VALUES ('FI_ACCOUNT', 'Accountant', '4200', '9000');
INSERT INTO `t_jobs` VALUES ('FI_MGR', 'Finance Manager', '8200', '16000');
INSERT INTO `t_jobs` VALUES ('HR_REP', 'Human Resources Representative', '4000', '9000');
INSERT INTO `t_jobs` VALUES ('IT_PROG', 'Programmer', '4000', '10000');
INSERT INTO `t_jobs` VALUES ('MK_MAN', 'Marketing Manager', '9000', '15000');
INSERT INTO `t_jobs` VALUES ('MK_REP', 'Marketing Representative', '4000', '9000');
INSERT INTO `t_jobs` VALUES ('PR_REP', 'Public Relations Representative', '4500', '10500');
INSERT INTO `t_jobs` VALUES ('PU_CLERK', 'Purchasing Clerk', '2500', '5500');
INSERT INTO `t_jobs` VALUES ('PU_MAN', 'Purchasing Manager', '8000', '15000');
INSERT INTO `t_jobs` VALUES ('SA_MAN', 'Sales Manager', '10000', '20000');
INSERT INTO `t_jobs` VALUES ('SA_REP', 'Sales Representative', '6000', '12000');
INSERT INTO `t_jobs` VALUES ('SH_CLERK', 'Shipping Clerk', '2500', '5500');
INSERT INTO `t_jobs` VALUES ('ST_CLERK', 'Stock Clerk', '2000', '5000');
INSERT INTO `t_jobs` VALUES ('ST_MAN', 'Stock Manager', '5500', '8500');

-- ----------------------------
-- Table structure for t_locations
-- ----------------------------
DROP TABLE IF EXISTS `t_locations`;
CREATE TABLE `t_locations` (
  `LOCATION_ID` varchar(255) NOT NULL,
  `STREET_ADDRESS` varchar(255) DEFAULT NULL,
  `POSTAL_CODE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STATE_PROVINCE` varchar(255) DEFAULT NULL,
  `COUNTRY_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LOCATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_locations
-- ----------------------------
INSERT INTO `t_locations` VALUES ('1100', '我也测试一', '1313521', '哈哈', '上海老朱', 'CN');
INSERT INTO `t_locations` VALUES ('1200', '拼搏到无能为力,努力到感动自己', '20201019', '上海千锋欢迎你', '上海老zhu再等你', 'CN');
INSERT INTO `t_locations` VALUES ('1300', '9450 Kamiya-cho', '6823', 'Hiroshima', null, 'JP');
INSERT INTO `t_locations` VALUES ('1400', '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US');
INSERT INTO `t_locations` VALUES ('1500', '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');
INSERT INTO `t_locations` VALUES ('1600', '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US');
INSERT INTO `t_locations` VALUES ('1700', '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
INSERT INTO `t_locations` VALUES ('1800', '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');
INSERT INTO `t_locations` VALUES ('1900', '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA');
INSERT INTO `t_locations` VALUES ('2000', '40-5-12 Laogianggen', '1313521', 'Beijing', '上海老朱', 'CN');
INSERT INTO `t_locations` VALUES ('2100', '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN');
INSERT INTO `t_locations` VALUES ('2200', '12-98 Victoria Street', '2901', 'Sydney', 'New South Wales', 'AU');
INSERT INTO `t_locations` VALUES ('2300', '198 Clementi North', '540198', 'Singapore', null, 'SG');
INSERT INTO `t_locations` VALUES ('2400', '8204 Arthur St', null, 'London', null, 'UK');
INSERT INTO `t_locations` VALUES ('2500', 'Magdalen Centre, The Oxford Science Park', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK');
INSERT INTO `t_locations` VALUES ('2600', '9702 Chester Road', '09629850293', 'Stretford', 'Manchester', 'UK');
INSERT INTO `t_locations` VALUES ('2700', 'Schwanthalerstr. 7031', '80925', 'Munich', 'Bavaria', 'DE');
INSERT INTO `t_locations` VALUES ('2800', 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR');
INSERT INTO `t_locations` VALUES ('2900', '20 Rue des Corps-Saints', '1730', 'Geneva', 'Geneve', 'CH');
INSERT INTO `t_locations` VALUES ('3000', 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH');
INSERT INTO `t_locations` VALUES ('3100', 'Pieter Breughelstraat 837', '3029SK', 'Utrecht', 'Utrecht', 'NL');
INSERT INTO `t_locations` VALUES ('3200', 'Mariano Escobedo 9991', '11932', 'Mexico City', 'Distrito Federal,', 'MX');

-- ----------------------------
-- Table structure for t_passagers
-- ----------------------------
DROP TABLE IF EXISTS `t_passagers`;
CREATE TABLE `t_passagers` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_passagers
-- ----------------------------
INSERT INTO `t_passagers` VALUES ('1001', '张三', '男', '2020-09-30');
INSERT INTO `t_passagers` VALUES ('1002', '李四', '女', '2020-01-20');

-- ----------------------------
-- Table structure for t_passports
-- ----------------------------
DROP TABLE IF EXISTS `t_passports`;
CREATE TABLE `t_passports` (
  `id` int(11) NOT NULL,
  `nationality` varchar(200) DEFAULT NULL,
  `expire` date DEFAULT NULL,
  `passagers_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `passagers_id` (`passagers_id`),
  CONSTRAINT `FK_passagers_id` FOREIGN KEY (`passagers_id`) REFERENCES `t_passagers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_passports
-- ----------------------------
INSERT INTO `t_passports` VALUES ('1', '中国', '2020-10-29', '1001');
INSERT INTO `t_passports` VALUES ('2', '美国', '2020-10-30', '1002');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `tel` varchar(200) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '沈豪杰', '123456', '110', '2021-04-12 16:27:31');
INSERT INTO `users` VALUES ('2', '催杰康', '123456', '112', '2021-03-02 16:27:35');
INSERT INTO `users` VALUES ('3', '刘道庆', '654321', '114', '2021-04-29 16:44:38');

-- ----------------------------
-- View structure for v1
-- ----------------------------
DROP VIEW IF EXISTS `v1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v1` AS select * from t_employees ;

-- ----------------------------
-- Procedure structure for proc
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc`(in a1 int, in a2 int, out num int  )
BEGIN
	select count(*)  from t_employees 
	where SALARY BETWEEN a1 and a2 into num;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc2
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc2`(in a1 int, in a2 int)
BEGIN
	DECLARE num int;
	select count(*)  from t_employees where SALARY BETWEEN a1 and a2 into num;

    if num > 0 THEN
        select '存在该范围的用户' as '结果';
    end if;

END
;;
DELIMITER ;

SELECT *
FROM t_jobs;
desc t_jobs;
Select *
from t_employees;

select *
from t_employees
order by SALARY DESC;

Select *
from t_departments
         join t_locations l on t_departments.LOCATION_ID = l.location_id;
show tables;
desc t_employees;
desc t_departments;
desc t_locations;

desc account;
select *
from account;
delete
from t_departments
where DEPARTMENT_ID = 283;
select *
from t_employees t1
         left join t_departments td on t1.DEPARTMENT_ID = td.DEPARTMENT_ID
         left join t_jobs tj on t1.JOB_ID = tj.JOB_ID;
