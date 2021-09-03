//Problem Statement : Write a SQL query to find the maximum and minimum values of continuous ‘Sequence’ in each ‘Group’

create table Emp(
groupcol varchar2(20),
seq number(10));
truncate table Emp;

INSERT INTO Emp VALUES('A',1);
INSERT INTO Emp VALUES('A',2);
INSERT INTO Emp VALUES('A',3);
INSERT INTO Emp VALUES('A',5);
INSERT INTO Emp VALUES('A',6);
INSERT INTO Emp VALUES('A',8);
INSERT INTO Emp VALUES('A',9);
INSERT INTO Emp VALUES('B',11);
INSERT INTO Emp VALUES('C',1);
INSERT INTO Emp VALUES('C',2);
INSERT INTO Emp VALUES('C',3);

//it's  ROW_NUMBER() 
//g s h diff
//A 2 1 1  
//A 3 2 1
//A 6 3 3
//A 7 4 3
//group made of upper two on basis of diff
//group made of below two on basis of diff

//ANSWER

with tt as(select groupcol, seq,seq-ROW_NUMBER() over(partition by groupcol order by seq) as diff from Emp)
select groupcol,min(seq),max(seq)  from tt group by diff,groupcol order by groupcol;
