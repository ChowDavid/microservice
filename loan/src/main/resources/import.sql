DROP table if exists loan;

create table loan (loan_number int not null auto_increment primary key, customer_id int not null, start_dt date not null, loan_type varchar(100) not null, total_loan int not null, amount_paid int not null, outstanding_amount int not null, create_dt date default current_date );

insert into loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) values (1,'2020-10-13','Home',200000,5000,150000,'2020-10-13');
insert into loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) values (1,'2020-06-06','Vehicle',400000,10000,30000,'2020-06-06');
insert into loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt) values (1,'2020-2-14','Home',500000,10000,400000,'2020-2-14');
