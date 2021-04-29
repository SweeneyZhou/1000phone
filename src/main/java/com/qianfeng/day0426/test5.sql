# 创建用户表
create table user(
                     userId int primary key auto_increment,
                     username varchar(20) not null,
                     password varchar(18) not null,
                     address varchar(100),
                     phone varchar(11)
);

#创建分类表
create table category(
                         cid varchar(32) PRIMARY KEY ,
                         cname varchar(100) not null		#分类名称
);

# 商品表
CREATE TABLE `products` (
                            `pid` varchar(32) PRIMARY KEY,
                            `name` VARCHAR(40) ,
                            `price` DOUBLE(7,2),
                            category_id varchar(32),
                            constraint fk_products_category_id foreign key(category_id) references category(cid)
);

#订单表
create table `orders`(
                         `oid` varchar(32) PRIMARY KEY ,
                         `totalprice` double(12,2), #总计
                         `userId` int,
                         constraint fk_orders_userId foreign key(userId) references user(userId) #外键
);

# 订单项表
create table orderitem(
                          oid varchar(32),	#订单id
                          pid varchar(32),	#商品id
                          num int ,         #购买商品数量
                          primary key(oid,pid), #主键
                          constraint fk_orderitem_oid foreign key(oid) references orders(oid),
                          constraint fk_orderitem_pid foreign key(pid) references products(pid)
);

#-----------------------------------------------
#初始化数据

#用户表添加数据
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('张三','123','北京昌平沙河','13812345678');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('王五','5678','北京海淀','13812345141');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('赵六','123','北京朝阳','13812340987');
INSERT INTO USER(username,PASSWORD,address,phone) VALUES('田七','123','北京大兴','13812345687');

#给分类表初始化数据
insert into category values('c001','电器');
insert into category values('c002','服饰');
insert into category values('c003','化妆品');
insert into category values('c004','书籍');

#添加订单
insert into orders values('o6100',18000.50,1);
insert into orders values('o6101',7200.35,1);
insert into orders values('o6102',600.00,2);
insert into orders values('o6103',1300.26,4);

#给商品表初始化数据
insert into products(pid,name,price,category_id) values('p001','联想',5000,'c001');
insert into products(pid,name,price,category_id) values('p002','海尔',3000,'c001');
insert into products(pid,name,price,category_id) values('p003','雷神',5000,'c001');
insert into products(pid,name,price,category_id) values('p004','JACK JONES',800,'c002');
insert into products(pid,name,price,category_id) values('p005','真维斯',200,'c002');
insert into products(pid,name,price,category_id) values('p006','花花公子',440,'c002');
insert into products(pid,name,price,category_id) values('p007','劲霸',2000,'c002');
insert into products(pid,name,price,category_id) values('p008','香奈儿',800,'c003');
insert into products(pid,name,price,category_id) values('p009','相宜本草',200,'c003');
insert into products(pid,name,price,category_id) values('p010','梅明子',200,null);

#订单详情表
insert into orderitem values('o6100','p001',1),('o6100','p002',1),('o6101','p003',1);