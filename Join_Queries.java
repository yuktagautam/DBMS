
select * from emp;
select * from dept;
//-----------------------------------------
//gives cartisian product  ,means one row (emp) join with all rows of another (dept),than other row of (emp) with all rows of another (dept),and so on
select ename,dname from emp,dept; 

//------------------------------------------
//--if in this cartisian product we add one more condition -->  emp.deptno=dept.deptno ,than according to database values one row may or may not link with other row of dept table by matching deptno
//---here deptno is acting as a foregin key in emp 
select ename,dname from emp,dept where emp.deptno=dept.deptno;
//--------------------------------------------
//Q if  along with ename,dname you want to sepecify deptno too
//WRONG--->deptno have to select form emp or dept table is not sepecifed
select ename,deptno,dname from emp,dept where emp.deptno=dept.deptno;
//RIGHT
select ename,emp.deptno,dept.deptno,dname from emp,dept where emp.deptno=dept.deptno;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------INNER JOIN-------------------------------------------------------------------------------------------------------
//isme do table kai beech mai sare  valid non null(matlb jsike corresponding koi non null value exist karti ho,vo sare print honge)
  empno ename  deptno             deptno dname Loction
  124  Ram   20                   30      Neha  delhi
  //in this case no data will be obtained ,because inner 20 kai link pai koi value avilable nhi hai
