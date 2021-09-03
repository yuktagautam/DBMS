create table customers
(id number(4) primary key,
first_name varchar2(20) ,
last_name varchar2(20),
city varchar2(10),
address varchar2(20),
phone_number number(11));

insert into customers values(3,'Yukta','Gautam','Kkr','Address',9599279043);
insert into customers values(7,'Sidhu','Gautam','Australia','Addres',349439435);
insert into customers values(1,'abc','last','delhi','Addres',898989989);
insert into customers values(2,'def','last2','Inndia','Address23',3);

create table orders
(id number(4) primary key,
cust_id number(4) references customers,
order_date date,
order_details varchar2(15) not null,
total_order number(10));


insert into orders values (1,3,to_date('2019-03-04','yyyy/mm/dd'),'Coat',100);
insert into orders values (2,3,to_date('2019-03-04','yyyy/mm/dd'),'Shoes',80);
insert into orders values (3,3,to_date('2019-03-07','yyyy/mm/dd'),'Skirt',30);
insert into orders values (4,1,to_date('2019-02-01','yyyy/mm/dd'),'Coat',300);
select * from customers;
select * from orders;

//ANSWER
select customers.first_name from (select o.cust_id,o.order_date,sum(o.total_order) as sumcol from orders o,customers c  where o.cust_id=c.id(+) and o.order_date between to_date('2019-03-01','yyyy/mm/dd') and to_date('2019-09-05','yyyy/mm/dd') group by o.cust_id,o.order_date
having sum(o.total_order) = (select max(sum(o.total_order)) from orders o,customers c where o.cust_id=c.id(+) and o.order_date between to_date('2019-03-01','yyyy/mm/dd') and to_date('2019-09-05','yyyy/mm/dd') group by o.cust_id,o.order_date)) t1,customers where t1.cust_id=customers.id;
 //Ek table banaynege ((which contain cust_id,sumcol ) join with table having a maxmimum total_order_cost)join customer 
//last join to find out the name attached to cust_id