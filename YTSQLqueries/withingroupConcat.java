Question- Emp_Details  Table has four columns EmpID, Gender, EmailID and DeptID. 
User has to write a SQL query to derive another column called Email_List to display all Emailid concatenated with semicolon associated with a each DEPT_ID 
as shown below in output Table.

CREATE TABLE Emp_Details (
EMPID int,
Gender varchar,
EmailID varchar(30),
DeptID int)

create table Emp_Details(
empid number,
gender varchar2(20),
emailid varchar2(20),
deptid number)

INSERT INTO Emp_Details VALUES (1001,'M','YYYYY@gmaix.com',104);
INSERT INTO Emp_Details VALUES (1002,'M','ZZZ@gmaix.com',103);
INSERT INTO Emp_Details VALUES (1003,'F','AAAAA@gmaix.com',102);
INSERT INTO Emp_Details VALUES (1004,'F','PP@gmaix.com',104);
INSERT INTO Emp_Details VALUES (1005,'M','CCCC@yahu.com',101);
INSERT INTO Emp_Details VALUES (1006,'M','DDDDD@yahu.com',100);
INSERT INTO Emp_Details VALUES (1007,'F','E@yahu.com',102);
INSERT INTO Emp_Details VALUES (1008,'M','M@yahu.com',102);
INSERT INTO Emp_Details VALUES (1009,'F','SS@yahu.com',100);

select  listagg(emailid,',') within group(order by deptid) as con from Emp_Details;

select listagg(emailid,',') over(partition by deptid order by empid) as con from Emp_Details;//wrong, in listagg does not orderby in partition, instead use within group

select deptid,listagg(emailid,',') within group(order by emailid) over(partition by deptid) as con from Emp_Details;
