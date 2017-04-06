create database examReservation;
use examReservation;

--建表
--管理员表
create table exam_admin(
	aname char(20) primary key,
	apwd char(32) not null
)engine=MyISAM;

--学生表
create table exam_stu(
	sno char(10) primary key,
	spwd char(32) not null default '88888888',
	sname char(10) not null,
	sbirth date,
	sidentity char(18) not null unique,
	ssex char(2),
	stel char(11) unique,
	semail varchar(30) unique,
	sunivsersity varchar(50),
	savator varchar(50) not null default '../ERimage/zanwu.jpg'
)engine=InnoDB;

--考试科目表
create table examination(
	eid int primary key auto_increment,
	ename varchar(50) not null,
	estart datetime not null,
	eend datetime not null,
	emaxnum int,
	ecurrnum int not null default 0,
	outofdate tinyint(1) not null,
	epic varchar(50) not null default '../ERimage/zanwu.jpg'
)engine=InnoDB;

--预约清单表
create table reserve_list(
	oid int primary key auto_increment,
	eid int,
	sno char(11),
	reservetime datetime not null,
	outofdate tinyint(1) not null
)engine=InnoDB;

--消息表
create table message(
	mid int primary key auto_increment,
	sno char(11),
	content text not null,
	sendtime datetime not null,
	mtype tinyint(1) not null,
	isnew tinyint(1) not null
)engine=InnoDB;

alter table reserve_list 
add constraint fk_examination_eid 
foreign key(eid) references examination(eid);

alter table reserve_list
add constraint fk_reserve_exam_stu_sno
foreign key(sno) references exam_stu(sno);

alter table message
add constraint fk_message_exam_stu_sno
foreign key(sno) references exam_stu(sno);

insert into exam_admin values('admin','admin');


--带游标的存储过程
delimiter //
create procedure notifyAll(in tcontent text)
begin
	declare tsno char(10);
	declare done int default 0;
	declare cur cursor for select sno from exam_stu;
	declare continue handler for sqlstate '02000' set done = 1;
	open cur;
	fetch next from cur into tsno;
	repeat
	insert into message(sno,content,sendtime,mtype) values(tsno,tcontent,now(),1);
	fetch next from cur into tsno;
	until done end repeat;
	close cur;
end// 
delimiter ;


commit;