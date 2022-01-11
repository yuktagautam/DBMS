Create Table Inventory(
ProdName Varchar(20),
ProductCode Varchar(15),
Quantity number,
InventoryDate Date);

//to_date--> to_date(takes a string , SpecifyTheFormatOfThatInputString)-->will convert the input string in date of format that software have
//to_char -->to_char(take date,formatInwhichThdateShouldBeConverted)-->convert the date into the string

Insert Into Inventory values('Keyboard','K1001',20,to_date('2020-03-01','yyyy-mm-dd'));  //-->converted to//1-MAR-20
Insert Into Inventory values('Keyboard','K1001',30,to_date('2020-03-02','yyyy-mm-dd'));
Insert Into Inventory values('Keyboard','K1001',10,to_date('2020-03-03','yyyy-mm-dd'));
Insert Into Inventory values('Keyboard','K1001',40,to_date('2020-03-04','yyyy-mm-dd'));
Insert Into Inventory values('Laptop','L1002',100,to_date('2020-03-01','yyyy-mm-dd'));
Insert Into Inventory values('Laptop','L1002',60,to_date('2020-03-02','yyyy-mm-dd'));
Insert Into Inventory values('Laptop','L1002',40,to_date('2020-03-03','yyyy-mm-dd'));
Insert Into Inventory values('Monitor','M5005',30,to_date('2020-03-01','yyyy-mm-dd'));
Insert Into Inventory values('Monitor','M5005',20,to_date('2020-03-02','yyyy-mm-dd'));

//A PARTITION BY clause is used to partition rows of table into groups. [IMP]It is useful when we have to perform a calculation on individual rows of a group using other rows of that group.

select ProductCode,sum(Quantity) over(partition by ProductCode) as SumQuant from Inventory; //whole group sum will be assigned
select ProductCode,sum(Quantity) over(partition by ProductCode order by InventoryDate) as CummSumQuant from Inventory;//as order by clause is present cummsum will be fiven
