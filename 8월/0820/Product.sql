USE ssafy_db;

CREATE TABLE Product(
	num int PRIMARY KEY,
    name VARCHAR(20) not null,
    price int not null,
    stock int not null
);