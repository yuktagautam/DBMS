
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
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------INNER JOIN------------------------------------------------------------------------------------------------
//isme do table kai beech mai sare  valid non null(matlb jsike corresponding koi non null value exist karti ho,vo sare print honge)
  empno ename  deptno             deptno dname Loction
  124  Ram   20                   30      Neha  delhi
  //in this case no data will be obtained ,because inner 20 kai link pai koi value avilable nhi hai
  //query--->
select ename,dname from emp,dept where emp.deptno=dept.deptno;  //actually a inner join
select ename,dname from emp inner join dept on emp.deptno=dept.deptno;   //other method to write " , kai place pai join Type and where kai place pai on"
-------------------------------------------------LEFT OUTER JOIN-----------------------------------------------------------------
  //emp left outer dept
  //left mai emp likha hai 
  //right mai dept
 //Join TYPE->left outer  -->matlb left mai jo hoga uske sare records whether their corresponding value present in other table or not 
  empno ename  deptno             deptno dname Loction
  124  Ram   20                   30      Neha  delhi
  //is dept  table mai 20 deptno exist nhi karta but fir bhi ye Ram ka name print karega or dname kai place pai "-" sign a jayega
  //query----->
  select ename,dname from emp left outer join dept on emp.deptno=dept.deptno;
select ename,dname from emp,dept where emp.deptno=dept.deptno(+)  -->agr sign right vale kai sath presnt ho toh matlb left ki sari records (left outer join)
---------------------------------------------RIGHT OUTER JOIN--------------------------------------------------
   //emp left outer dept
  //left mai emp likha hai 
  //right mai dept
 //Join TYPE->right outer  -->matlb right mai jo hoga uske sare records prit honge whether their corresponding value present in other table or not 
  empno ename  deptno             deptno dname Loction
  124  Ram   20                   30      Neha  delhi
  //is ename mai deptno 30 exist  nhi karta but fir bhi ye Neha ka name print karega or ename kai place pai "-" sign a jayega
 //query----->
select ename,dname from emp rightouter join dept on emp.deptno=dept.deptno;
select ename,dname from emp,dept where emp.deptno(+)=dept.deptno -->agr sign left vale kai sath  sign present ho toh matlb right ki sari records (right outer join)
 
