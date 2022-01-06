create table emp(gname varchar2(10),seq number);

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

select * from emp;

ANSWER-

with makepropergrouptable as (select gname,seq,ROW_NUMBER() over(partition by gname order by seq) as par,seq-(ROW_NUMBER() over(partition by gname order by seq)) as diff from emp)
select gname,min(seq) as minseq,max(seq) as maxseq from(makepropergrouptable) group by gname,diff order by gname;
