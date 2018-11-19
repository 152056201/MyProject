--删除表
drop datebase if exists mshop ;
--创建数据库
CREATE DATABASE mshop character set utf8;
--使用表
use mshop;
--创建数据表
--1.创建商品类型表
CREATE  TABLE  item(
  iid int AUTO_INCREMENT,
  title varchar(50) not null,
  constraint pk_iid primary  key(iid)
)engine=InnoDB ;

--2.创建管理员信息表
create table users (
   uid                 varchar(50),
   password            varchar(32) not null,
   lastdate            datetime,
   constraint  pk_aid primary  key(uid)
)engine=InnoDB ;

--3.创建用户表

CREATE  table  member(
   mid                  varchar(50),
   password             varchar(32) not null,
   name                 varchar(50),
   phone                varchar(50),
   address              varchar(100),
   status               int,
   code                 varchar(100),
   regdate              datetime not null,
   photo                varchar(50) default 'nophoto.jpg',
   constraint pk_mid primary key(mid)
)engine=InnoDB ;

--4.商品信息表
create table goods(
   gid                  int AUTO_INCREMENT,
   iid                  int,
   uid                  varchar(50),
   title                varchar(50),
   price                float,
   pubdate              datetime,
   amount               int,
   bow                  int,
   note                 text,
   photo                varchar(100),
   status               int,
   constraint  pk_gid primary key(gid),
   constraint  fk_iid foreign key(iid) references item(iid)  on delete set null,
   constraint  fk_uid foreign key(uid) references  users(uid)  on delete set null
)engine=InnoDB ;

--5.订单信息
create table orders(
   oid                  int AUTO_INCREMENT,
   mid                  varchar(50),
   name                 varchar(50),
   phone                varchar(50),
   address              varchar(100),
   credate              datetime,
   price                float,
   constraint  pk_oid primary key(oid),
   constraint  fk_mid foreign key(mid) references member(mid) on delete  cascade
)engine=InnoDB ;
--6.创建订单详情表
create table details(
   odid                 int AUTO_INCREMENT,
   oid                  int not null,
   gid                  int,
   tilte                varchar(50) not null,
   price                float not null,
   amount               int not null,
   constraint  pk_odid  primary key(odid),
   constraint  fk_oid foreign key(oid) references orders(oid) on delete cascade,
   constraint fk_gid foreign key(gid) references goods(gid) on delete set null
)engine=InnoDB ;

--测试数据
insert into item(title) values ('生活用品');
insert into item(title) values ('体育健身');
insert into item(title) values ('医疗器械');
insert into item(title) values ('厨房用具');
insert into item(title) values ('卫生保洁');
insert into item(title) values ('办公用品');

insert into users(uid,password) values ('yuanhao','2c875b6c2a9cae9d989cc4d3fa85f21b');
insert into users(uid,password) values ('admin','5d41402abc4b2a76b9719d911017c592');
--user123
insert into member(mid,password,regdate) values ('myuser','6ad14ba9986e3615423dfca256d04e3f','2018-11-19');