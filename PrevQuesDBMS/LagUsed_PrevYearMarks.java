LAG(expression [, offset ] [, default ])
OVER (
	[ query_partition_clause ] 
	order_by_clause
)

expression
is a scalar expression evaluated against the value of the row at a given offset prior to the current row.

offset
is the number of rows that you want to backward from the current row. The default is 1.

default
If the offset goes beyond the scope of the partition, the function returns the default. If you omit default, then the function returns NULL.
//------------------------------



create table student(
student_name varchar2(30),
total_marks number(10),
cyear number(10)
);

INSERT INTO Student VALUES('Rahul',90,2010);
INSERT INTO Student VALUES('Sanjay',80,2010);
INSERT INTO Student VALUES('Mohan',70,2010);
INSERT INTO Student VALUES('Rahul',90,2011);
INSERT INTO Student VALUES('Sanjay',85,2011);
INSERT INTO Student VALUES('Mohan',65,2011);
INSERT INTO Student VALUES('Rahul',80,2012);
INSERT INTO Student VALUES('Sanjay',80,2012);
INSERT INTO Student VALUES('Mohan',90,2012);

select * from student;
//Inital Table
Rahul	90	2010
Sanjay	80	2010
Mohan	70	2010
Rahul	90	2011
Sanjay	85	2011
Mohan	65	2011
Rahul	80	2012
Sanjay	80	2012
Mohan	90	2012

//select student_name,cyear,total_marks,lag(total_marks,1,0) over (partition by student_name  order by cyear)  as prev_marks from student
STUDENT_NAME	CYEAR	TOTAL_MARKS	PREV_MARKS
Mohan	2010	70	0
Mohan	2011	65	70
Mohan	2012	90	65
Rahul	2010	90	0
Rahul	2011	90	90
Rahul	2012	80	90
Sanjay	2010	80	0
Sanjay	2011	85	80
Sanjay	2012	80	85

//Answer
with table1 as (select student_name,cyear,total_marks,lag(total_marks,1,0) over (partition by student_name  order by cyear)  as prev_marks from student)
select student_name,cyear,total_marks from table1 where (total_marks>=prev_marks and prev_marks>0) order by cyear;

STUDENT_NAME	CYEAR	TOTAL_MARKS
Rahul	2011	90
Sanjay	2011	85
Mohan	2012	90

