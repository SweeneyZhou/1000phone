CREATE TABLE IF NOT EXISTS country
(
    country_id   char(2)     default null,
    country_name varchar(20) default null
);
CREATE TABLE IF NOT EXISTS department
(
    department_id   int,
    department_name varchar(25),
    manager_id      int,
    location_id     int
);
CREATE TABLE IF NOT EXISTS employee
(
    employee_id    int,
    first_name     varchar(20),
    last_name      varchar(20),
    email          varchar(20),
    phone_name     varchar(200),
    hire_date      date,
    job_id         varchar(20),
    salary         double,
    commission_pct double,
    manager_id     int,
    department_id  int
);
CREATE TABLE IF NOT EXISTS job
(
    job_id     varchar(20),
    job_title  varchar(20),
    min_salary double,
    max_salary double
);
CREATE TABLE IF NOT EXISTS location
(
    location_id    int,
    street_address varchar(20),
    postal_code    varchar(20),
    city           varchar(20),
    state_province varchar(20),
    country_id     char(2)
);
insert into country
values ('CN', 'China');
insert into country
values ('US', 'United States');
insert into country
values ('UK', 'United Kingdom');
insert into country
values ('RU', 'Russia');
insert into country
values ('JP', 'Japanese');
insert into job
values ('001', '经理', 50000, 56000);
insert into job
values ('002', '会计', 8000, 16000);
insert into job
values ('003', '程序员', 23000, 36000);
insert into job
values ('004', '程序测试', 21000, 34000);
insert into job
values ('005', '运维管理', 20000, 33000);
insert into location
values ('001', '水产路', '231323', '上海', '上海', 'CN');
insert into location
values ('002', '同济路', '425436', '上海', '上海', 'CN');
insert into location
values ('003', '浙江路', '234242', '桂林', '广西', 'CN');
insert into location
values ('004', '五马街', '342524', '温州', '浙江', 'CN');
insert into location
values ('005', '北京路', '234242', '成都', '广西', 'CN');
insert into location
values ('006', '四川路', '423424', '广州', '广东', 'CN');
insert into department
values (1, '上铺公寓', 1, 1);
insert into department
values (1, '梦想之家', 1, 1);
insert into department
values (1, '友间公寓', 1, 1);
insert into employee
values (1, '周', '小迪', '670998330@qq.com', '18858818389', '2021-03-15 08:00:00', '003', 15000, 16, 1, 1);
select *
from location;
select *
from job;
select *
from country;
select *
from department;
select *
from employee;

CREATE TABLE UNI_test
(
    id   int primary key auto_increment,
    name varchar(20) unique
);
alter table uni_test
    modify name varchar(768) unique;
desc uni_test;