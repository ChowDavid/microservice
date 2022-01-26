drop table if exists card;

create table card (card_id int not null auto_increment primary key, card_number varchar(100) not null, customer_id int not null,card_type varchar(100) not null,total_limit int not null, amount_used int not null, available_amount int not null, create_dt date default current_date );

insert into card (card_number, customer_id, card_type,total_limit,amount_used,available_amount) values ('4565XXX4656',1,'Credit',10000,500,9500);
insert into card (card_number, customer_id, card_type,total_limit,amount_used,available_amount) values ('3455XXX8673',1,'Credit',7500,600,6900);
insert into card (card_number, customer_id, card_type,total_limit,amount_used,available_amount) values ('2359XXX9346',1,'Credit',20000,4000,16000);