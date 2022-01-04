//on->for join with keyword full join,left join, inner join, right join
jabh join se cartisian product hota hai ye tabh saath sath lta hai,like during doing cartisian product this condition is noticed

//where->for filtering the data after "on" keywoard
jabki ye cartisian product hone kai badh lgta hai


create table tname( 
roll_no number(2) primary key,
pname varchar2(10) );

drop table tname;

create table tmarks(
roll_no number(2) primary key,
marks number(2) not null
);

drop table tmarks;

insert into tname values (1,'A');
insert into  tname values(2,'B');
insert into  tname values(3,'C');

insert into  tmarks values(2,40);
insert into  tmarks values(3,30);
insert into  tmarks values(4,50);

select * from tname;
select * from tmarks;
//on-->works when there 

select * from tname left join tmarks on tname.roll_no=tmarks.roll_no and tmarks.marks=30; #filteration will not occur ,whole query will be treated as let join condition

// -- ROLL_NO	PNAME	ROLL_NO	MARKS
// -- 2	B	 - 	 - 
// -- 1	A	 - 	 - 
// -- 3	C	3	30

select * from tname left join tmarks on tname.roll_no=tmarks.roll_no where tmarks.marks=30;

// -- ROLL_NO	PNAME	ROLL_NO	MARKS
// -- 3   	C	         3	  30

//it only apply = condition for the attribute which is common in both table
select * from tname natural join tmarks;

// -- ROLL_NO	PNAME	MARKS
// -- 2	B	40
// -- 3	C	30

//where as in this condition we can apply equal to condition in different attribute of two tables.

select * from tname inner join tmarks on tname.roll_no=tmarks.roll_no;

// -- ROLL_NO	PNAME	ROLL_NO	MARKS
// -- 2	B	2	40
// -- 3	C	3	30

select * from tname full join tmarks on tname.roll_no=tmarks.roll_no;


-- ROLL_NO	PNAME	ROLL_NO	MARKS
// -- 2	B	2	40
// -- 3	C	3	30
// --  - 	 - 	4	50
// -- 1	A	 - 	 - 




//there is no such keyword like "self join" , so we need to apply "," and need to give alias name to each table and then apply "where"

select t1.roll_no from tname t1,tname t2 where t1.roll_no=t2.roll_no;


select * from tname;
select * from tmarks;
select * from tname cross join tmarks;
select * from tname left join tmarks on tname.roll_no<tmarks.roll_no and tmarks.marks=40;

select * from tname,tmarks; //this will to cartisian product , and display all attributes name


EQUI JOIN
when we use = sign

NonEqui JOIN
when use >=,<,>,<= signs



