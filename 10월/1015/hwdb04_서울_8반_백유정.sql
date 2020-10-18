create table product(
	pcode int,
    pname varchar(20),
    pprice int,
    pletfover int
);

create table customer(
	cid int,
    cname varchar(20),
    clocation varchar(20),
    cphone1 varchar(20),
    cphone2 varchar(20)
);

create table `order`(
	oid int,
    oprice int,
    obpay boolean,
    obship boolean,
    pcode int,
    cid int
);