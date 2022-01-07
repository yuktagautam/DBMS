

create table Student (sname varchar2(20),tmarks number,tyear number);

INSERT INTO Student VALUES('Rahul',90,2010);
INSERT INTO Student VALUES('Sanjay',80,2010);
INSERT INTO Student VALUES('Mohan',70,2010);
INSERT INTO Student VALUES('Rahul',90,2011);
INSERT INTO Student VALUES('Sanjay',85,2011);
INSERT INTO Student VALUES('Mohan',65,2011);
INSERT INTO Student VALUES('Rahul',80,2012);
INSERT INTO Student VALUES('Sanjay',80,2012);
INSERT INTO Student VALUES('Mohan',90,2012);


Question -- Student Table has three columns Student_Name, Total_Marks and Year. User has to write a SQL query to display Student_Name, Total_Marks, Year,  Prev_Yr_Marks for those whose Total_Marks are greater than or equal to the previous year.


with ptable as (select sname,tmarks,tyear,lag(tmarks,1) over(partition by sname order by sname,tyear) as pmarks 
from Student),
htable as (select sname,tmarks,pmarks,tyear,case when pmarks<=tmarks then 1 else 0 end as flag from ptable)
select sname,tmarks,pmarks,tyear from htable where flag=1;
