use mydb;
select salesman.Name, salesman.idSales_Executive, salesman.Mobile_number, salesman.DOB, count(*) 
as No_of_products_sold from `sales executive` salesman
	inner join sell s on s.idSales_Executive = salesman.idSales_Executive 
	inner join buy b on b.ProductCode = s.ProductCode 
	group by idSales_Executive ;
    
    describe `sales executive`;
    
show tables;