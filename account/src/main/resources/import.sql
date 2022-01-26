DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE customer ( customer_id int AUTO_INCREMENT PRIMARY KEY, name varchar(100) not null, email varchar(100) not null, mobile_number varchar(20) not null, create_it date default current_date );

CREATE TABLE account ( customer_id int not null, account_number int AUTO_INCREMENT PRIMARY KEY, account_type varchar(100) not null, branch_address varchar(200) not null, create_dt date default current_date );

Alter table account add foreign key (customer_id) references customer (customer_id);

insert into customer (customer_id,name,email,mobile_number) values (1,'david','yip@igreendata.com',0447019154);
insert into account (customer_id,account_number,account_type,branch_address) values(1,123456789,'Savings','Mel');