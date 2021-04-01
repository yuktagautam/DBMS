------------------creating dept table----------------
create table dept

(deptno number(4) primary key,

dname varchar2(15) not null,

loc varchar2(10) not null);
-------------------Emp table------------------------------
    
create table emp

(empno number(5) primary key,

ename varchar2(10) not null,

job varchar2(20) not null,

mrg number(5),

hiredate date,

sal number(5,1) not null,

comm number(5,1),

deptno number(4) references dept);
-------------------------------Inserting into dept table --------------------------
insert into dept values (10,'Accounting','New York');
insert into dept values (20, 'Research','Dallas');

insert into dept values (30, 'Sales','Chicago');

insert into dept values (40, 'Operations','Boston');
 
select * from dept;
----------------------------Inserting into emp table------------------
insert into emp values (7499, 'Allen', 'Salesman', 7698, '20-feb-81',1600,300,30);

insert into emp values (7521, 'Ward', 'Salesman', 7698, '22-feb-81',1250,500,30);

insert into emp values (7566, 'Jones','Manager', 7839, '02-apr-81',2975,'',20);

insert into emp values (7654, 'Martin', 'Salesman', 7698, '28-sep-81',1250,1400,30);

insert into emp values (7698, 'Blake', 'Manager', 7839, '01-May-81',2850,'',30);

insert into emp values (7782, 'Clark', 'Manager', 7839, '09-jun-81',2450,'',10);

insert into emp values (7788, 'Scott', 'Analyst', 7566, '09-dec-82',3000,'',20);

insert into emp values (7839, 'King', 'President', '', '17-nov-81',5000,'',10);

insert into emp values (7844, 'Turner', 'Salesman', 7698, '08-sep-81',1500,0,30);

insert into emp values (7876, 'Adams', 'Clerk', 7788, '12-jan-83',1100,'',20);

insert into emp values (7900, 'James', 'Clerk', 7698, '03-dec-81',950,'',30);

insert into emp values (7902, 'Ford', 'Analyst', 7566, '04-dec-81',3000,'',20);

insert into emp values (7934, 'Miller','Clerk', 7782, '23-Jan-82',1300,'',10);

select * from emp;
//---------------------------------------------------------------

