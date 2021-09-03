Order_Tbl has four columns namely ORDER_DAY, ORDER_ID, PRODUCT_ID, QUANTITY and PRICE
(a) Write a SQL to get all the products that got sold on both the days and the number of times the product is sold.
(b) (b) Write a SQL to get products that was ordered on 02-May-2015 but not on 01-May-2015


create table orderTable(
order_day varchar2(10),
order_id varchar2(10),
product_id varchar2(10),
quantity number(10),
price number(10));


INSERT INTO orderTable  VALUES ('2015-05-01','ODR1', 'PROD1', 5, 5);
INSERT INTO orderTable  VALUES ('2015-05-01','ODR2', 'PROD2', 2, 10);
INSERT INTO orderTable  VALUES ('2015-05-01','ODR3', 'PROD3', 10, 25);
INSERT INTO orderTable  VALUES ('2015-05-01','ODR4', 'PROD1', 20, 5);
INSERT INTO orderTable VALUES ('2015-05-02','ODR5', 'PROD3', 5, 25);
INSERT INTO orderTable  VALUES ('2015-05-02','ODR6', 'PROD4', 6, 20);
INSERT INTO orderTable  VALUES ('2015-05-02','ODR7', 'PROD1', 2, 5);
INSERT INTO orderTable  VALUES ('2015-05-02','ODR8', 'PROD5', 1, 50);
INSERT INTO orderTable  VALUES ('2015-05-02','ODR9', 'PROD6', 2, 50);
INSERT INTO orderTable  VALUES ('2015-05-02','ODR10','PROD2', 4, 10);


select * from orderTable;
//(a) Write a SQL to get all the products that got sold on both the days and the number of times the product is sold.

select product_id,count(distinct order_day) as dcount from orderTable group by product_id having count(distinct order_day)>1 order by product_id;

//(b) Write a SQL to get products that was ordered on 02-May-2015 but not on 01-May-2015

select product_id from((select distinct(product_id) from orderTable where order_day='2015-05-02') MINUS (select distinct(product_id) from orderTable where order_day='2015-05-01'));

with left as (select distinct(product_id) from orderTable where order_day='2015-05-02'),right as (select distinct(product_id) from orderTable where order_day='2015-05-01'),
ans as (select left.product_id as a1,right.product_id as a2 from orderTable left,right where left.product_id=right.product_id(+))
select ans.a1 from ans where ans.a2 is null;
