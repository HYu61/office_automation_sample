drop database if exists oa;
create database oa;
use oa;

drop table if exists reimbursement_form_records;
drop table if exists reimbursement_form_detail;
drop table if exists reimbursement_forms;
drop table if exists employees;
drop table if exists departments;


create table employees(
  sn char(6) not null,
  password varchar(500) not null,
  name varchar(50) not null,
  ca_sin varchar(9) not null,
  dept_id int not null,
  position varchar(20) not null,
  primary key (sn),
  UNIQUE KEY (ca_sin)
)engine=innodb charset=utf8;

create table departments(
  id int not null auto_increment,
  name varchar(20) not null ,
  address varchar(100),
  primary key (id),
  UNIQUE KEY (name)
)engine=innodb charset=utf8;

create table reimbursement_forms(
  id int not null auto_increment,
  business_purpose varchar(100) not null,
  applicant_sn char(6) not null,
  create_time dateTime not null,
  approver_sn char(6),
  total_amount double,
  status varchar(20),
  primary key (id)
)engine=innodb charset=utf8;

create table reimbursement_form_detail(
  id int not null auto_increment,
  reimbursement_form_id int not null,
  cate_of_expense varchar(20) not null,
  amount double not null,
  description varchar(100),
  primary key(id)
)engine=innodb charset=utf8;

create table reimbursement_form_records(
  id int not null auto_increment,
  reimbursement_form_id int not null,
  approver_sn char(6) not null,
  handle_date dateTime not null,
  process_type varchar(20) not null,
  result varchar(20) not null,
  remark varchar(100),
  primary key(id)
)engine=innodb charset=utf8;


alter table employees add constraint dept_FK foreign key (dept_id) references departments(id) on delete restrict on update restrict;
alter table reimbursement_forms add constraint rf_applicant_FK foreign key (applicant_sn) references employees(sn) on delete restrict on update restrict;
alter table reimbursement_forms add constraint rf_approver_FK foreign key (approver_sn) references employees(sn) on delete restrict on update restrict;
alter table reimbursement_form_detail add constraint rfd_rf_FK foreign key (reimbursement_form_id) references reimbursement_forms(id) on delete restrict on update restrict;
alter table reimbursement_form_records add constraint records_rf_FK foreign key (reimbursement_form_id) references reimbursement_forms(id) on delete restrict on update restrict;
alter table reimbursement_form_records add constraint records_approver_FK foreign key (approver_sn) references employees(sn) on delete restrict on update restrict;


insert into departments values(1001,'GM Office','70 Main street 1201');
insert into departments values(1002,'Finace','70 Main street 1202');
insert into departments values(1003,'Marketing','70 Main street 1101');
insert into departments values(1004,'HR','70 Main street 1110');

insert into employees values('0001',hex(aes_encrypt('000000','oa')),'Harry',910000001,1001,'General Manager');
insert into employees values('0002',hex(aes_encrypt('000000','oa')),'Jack',910000002,1002,'Department Manager');
insert into employees values('0003',hex(aes_encrypt('000000','oa')),'Tom',910000003,1003,'Department Manager');
insert into employees values('0004',hex(aes_encrypt('000000','oa')),'Cal',910000004,1004,'Department Manager');
insert into employees values('0005',hex(aes_encrypt('000000','oa')),'Lucy',910000005,1001,'Staff');
insert into employees values('0006',hex(aes_encrypt('000000','oa')),'Peter',910000006,1002,'Staff');
insert into employees values('0007',hex(aes_encrypt('000000','oa')),'Lily',910000007,1003,'Staff');
insert into employees values('0008',hex(aes_encrypt('000000','oa')),'Sara',910000008,1004,'Staff');







