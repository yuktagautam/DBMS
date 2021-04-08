//Question1-Display the employee names along with their department names. Display department name even if no employee is working in that department. 
select ename,dname from emp,dept where emp.deptno(+)=dept.deptno;


//Query 2. Display the employee names along with their manager names
select e.ename,m.ename from emp e,emp m where e.mrg=m.empno;

//Question3-Query 8. Display the employee names starting with vowel and ending with vowel. 
select ename from emp where substr(ename,1,1) in ('A','E','I','O','U','a','e','i','o','u') and substr(ename,-1,1) in ('A','E','I','O','U',,'a','e','i','o','u');


//-**********************************************Concept OF ROWNUM*********************************************************************************************
//ROWNUM jo hota hai numbering karne mai use hota hai
//ye increasing order mai assign karta hai 
//SIRF USI KO JO FROM KAI JUST BADH LIKHA HOTA HAI
//-----------------------------------
exp->select ename,ROWNUM from emp;
//-------------------OUTPUT----------------------------
// abh is case mai from kai just badh emp hai toh jaise table mila hai usko usi mai increasing order mai numbering kar dega vo or table mai ROWNUM ka column add ho jayega
ENAME	ROWNUM
Allen	1
Ward	2
Jones	3
Martin	4
Blake	5
Clark	6
Scott	7
King	8
Turner	9
Adams	10
James	11
Ford	12
Miller	13
//-----------------------------------------------------------------------
exp->select ename,ROWNUM from emp order by sal;
//--------------------OUTPUT--------------------------
//IS CASE MAI --->from kai just badh emp hai toh ,sabse phele vo ROWNUM column ko add karega increasing mai 
//,the moment vo table ban gya abh usko sort karega according to operation performed(order by sal)
James	11
Adams	10
Ward	2
Martin	4
Miller	13
Turner	9
Allen	1
Clark	6
Blake	5
Jones	3
Scott	7
Ford	12
King	8
  //----------------------------------------------------
//exp-->3 ,agr mujhe order by sal karke fir usko numbering karni thi toh kaise
select ename,sal,ROWNUM from (select * from emp order by sal desc);
//------OUTPUT------------------------
ENAME	SAL	ROWNUM
King	5000	1
Scott	3000	2
Ford	3000	3
Jones	2975	4
Blake	2850	5
Clark	2450	6
Allen	1600	7
Turner	1500	8
Miller	1300	9
Ward	1250	10
Martin	1250	11
Adams	1100	12
James	950	13
// CAUTION *********   If we have only single '=' like-> ROWNUM=5 ,this will not work 
//ROWNUM can work with combined '='with other operatand like '<=' ,'>='
//CONCLUSION,ROWNUM work with [>=,<=,>,<]
 //ROWNUM work on an individual record not on group.
  //**************************************************************************************************************************************************8
  
//Question 4 Fetch top 5 records from employee according to the salary
  //this  will give the top 5 records
 select ename,sal,ROWNUM from (select * from emp order by sal desc) where ROWNUM<=5;
 

//Question 5  Display third highest paid employee
select ename,sal,ROWNUM from (select * from emp order by sal desc) 
where ROWNUM<=3  MINUS select ename,sal,ROWNUM from (select * from emp order by sal desc) where ROWNUM<=2;
//---------------------------------

// Q6--list the employee details whose salary is greater than average salary of all the employees joined after 1st April’1981. 
select * from emp where sal>(select avg(sal) from emp) and hiredate> '01-apr-1981';
//Q7--list the employee details whose salary is greater than average salary of all the employees who have joined after 1st April’1981. 
select * from emp where sal>(select avg(sal) from emp where hiredate> '01-apr-1981');

//-----------------------------------------
//Q8- list the job with highest average salary
select max(avg(sal)) from emp group by deptno;   //output ->2916.666666666666666666666666666666666667 
//but here we can't display job 
*******WRONG************
select job,max(avg(sal)) from emp group by deptno; // <----WRONG ,IMP--->Because we can not write a single value thing with a aggrigate function
              
