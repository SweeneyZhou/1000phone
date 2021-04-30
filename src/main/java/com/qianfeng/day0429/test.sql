use java2101;
DROP TABLE if exists users;
CREATE TABLE if not exists USERS(
    id int primary key auto_increment,
    username varchar(20) not null unique ,
    password varchar(20) not null ,
    last_login_time datetime default now()
);
insert into USERS(username,password) values ('张三','123123');
insert into USERS(username,password) values ('李四','123412');
insert into USERS(username,password) values ('王五','123451');
insert into USERS(username,password) values ('赵六','123456');
select * from USERS;