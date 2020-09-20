drop table product;

create table product(
  name         varchar(30) primary key,
  price        int not null,
  description  varchar(3000)
);