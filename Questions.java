Percentage Of Total Spend
Calculate the percentage of the total spend a customer spent on each order. Output the customer’s first name, order details, and percentage of the order cost to their total spend across all orders. 

Assume each customer has a unique first name (i.e., there is only 1 customer named Karen in the dataset) and that customers place at most only 1 order a day.

Percentages should be represented as fractions
Tables: orders, customers


//Hints
// - First join the `customer` table with the `orders` table using an inner join. Any customers that did not place an order will be removed in the resulting dataset.
// - You’ll want to find the customer’s total amount of purchases and then divide the cost of each individual order with the total amount across all orders.
// - To calculate the total amount across all orders for each customer, use a window function and partition the window by the first name of the customer.
// - For each transaction, take the cost of the order and divide it by the total amount for each customer. 
// - Round the percentage to the nearest whole number using the round() function


//orders
idint
cust_idint
order_datedatetime
order_detailsvarchar
total_order_costint

//customers
idint
first_namevarchar
last_namevarchar
cityvarchar
addressvarchar
phone_numbervarchar


//order values
id	cust_id	order_date	order_details	total_order_cost
1	3	2019-03-04	Coat	100
2	3	2019-03-01	Shoes	80
3	3	2019-03-07	Skirt	30
4	7	2019-02-01	Coat	25
5	7	2019-03-10	Shoes	80
6	15	2019-02-01	Boats	100
7	15	2019-01-11	Shirts	60
  
//customer values
  8	John	Joseph	San Francisco		928-386-8164
7	Jill	Michael	Austin		813-297-0692
4	William	Daniel	Denver		813-368-1200
5	Henry	Jackson	Miami		808-601-7513
13	Emma	Isaac	Miami		808-690-5201
14	Liam	Samuel	Miami		808-555-5201
  
  //some what query like
  
  
 create table orders
(id number(4) primary key,
cust_id number(4) not null,
order_date date,
order_details varchar2(15) not null,
total_order number(10));

insert into orders values (1,3,2019-03-04,'Coat',100);
insert into orders values (2,3,2019-03-01,'Shoes',80);
insert into orders values (3,3,2019-03-07,'Skirt',30);
insert into orders values (7,1,2019-02-01,'Coat',25);


create table customers
(id number(4) references orders,
first_name varchar2(20) ,
last_name varchar2(20),
city varchar2(10),
address varchar2(20),
phone_number number(11));

insert into customers values(3,'Yukta','Gautam','Kkr','Address',9599279043);
insert into customers values(7,'Sidhu','Gautam','Australia','Addres',349439435);
insert into customers values(1,'abc','last','delhi','Addres',898989989);
insert into customers values(2,'def','last2','Inndia','Address23',3);
truncate table customers;

select o1.cust_id,c1.first_name,(o1.total_order/sum(o1.total_order) over (partition by c1.first_name)) percentage from orders o1,customers c1 where o1.cust_id=c1.id;
