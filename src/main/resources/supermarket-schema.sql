drop table if exists supermarket CASCADE;
create table supermarket (
id bigint AUTO_INCREMENT,
category varchar(255), 
item varchar(255), 
weight integer not null, 
primary key (id)
);