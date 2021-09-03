Question //https://platform.stratascratch.com/coding/10319-monthly-percentage-difference?python=

create table trans(
id number(10) primary key,
created_at varchar2(20),
value number(10),
purchase_id number(10)
);

insert into trans values (1,'2019-01-01',172692,43);
insert into trans values (2,'2019-01-05',177194,36);
insert into trans values  (3,'2019-01-09',109519,30);
insert into trans values  (4,'2019-02-09',109519,30);
insert into trans values  (5,'2019-02-09',10000,60);
insert into trans values  (6,'2019-03-09',10000,30);
insert into trans values  (7,'2019-04-09',109519,30);

//Step 1 converting to date ->date to YYYY-MM 
//to_date used to convert format into date ->'YYYY-MM-DD'  is mandatory
//to_char used to convert date into any type of date format 'MM-YYYY' 'YYYY-MM'
select to_date(created_at,'YYYY-MM-DD') as datec from trans;


//group by month
select id,to_char(to_date(created_at,'YYYY-MM-DD'),'YYYY-MM') as monthc, value from trans;

//lag is a window function it means it have to come  with over(...)  , inside order there must be some group by  or order by or both

select monthc,((sum(value) - lag(sum(value),1) over (order by monthc))/lag(sum(value),1) over (order by monthc))*100
as prev from 
(select id,to_char(to_date(created_at,'YYYY-MM-DD'),'YYYY-MM') as monthc, value from trans)
group by monthc;

//Making readable with help of groupedTableOnMOnth
with groupedTableOnMonth as (select id,to_char(to_date(created_at,'YYYY-MM-DD'),'YYYY-MM') as monthc, value from trans)
select monthc,((sum(value) - lag(sum(value),1) over (order by monthc))/lag(sum(value),1) over (order by monthc))*100
as prev from 
groupedTableOnMonth
group by monthc;
