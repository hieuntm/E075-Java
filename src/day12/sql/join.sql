-- Join bản chất là kết hợp 2 hoặc nhiều bảng
-- 4 kiểu join
-- inner join
-- left join (left outer join)
-- right join (right outer join)
-- full join


-- Giả sử có bảng A(id, bId) và B (id)
-- Join nó sẽ liên quan đến quan hệ 1-1 or 1-n or n-n
select * from A, B -- Select từ A và B
where A.bId = B.id; -- Điều kiện để join là A.bId = B.id
-- Cú pháp cũ

select * from A
inner join B on A.bId = B.id; -- Cú pháp mới

SELECT * from offices, employees
where offices.officeCode = employees.officeCode;

select * from offices
                  inner join employees on offices.officeCode = employees.officeCode
where offices.officeCode = 1;

select * from offices
                  right join employees on offices.officeCode = employees.officeCode
where offices.officeCode = 1;

select employees.*,offices.city as office_location from offices
                                                            right join employees on offices.officeCode = employees.officeCode
where offices.officeCode = 1;

-- Tất cả nhân viên làm việc tại Paris (offices tables cột city)
select employees.*,offices.city as office_location from offices
                                                            right join employees on offices.officeCode = employees.officeCode
where offices.city = 'Paris';

-- Lấy cả order của 1 customer có tên là Labrune
select orders.* from orders
                         inner join customers on orders.customerNumber = customers.customerNumber
where  customers.contactLastName = 'Labrune'


-- Lấy cả sản phẩm trong order của
-- customer có tên là Labrune
select orders.* from orders
                         inner join customers on orders.customerNumber = customers.customerNumber
                         inner join orderdetails on orderdetails.orderNumber = orders.orderNumber
                         inner join products on products.productCode = orderdetails.productCode
where  customers.contactLastName = 'Labrune'

-- Lấy cả sản phẩm trong order có orderNumber = 10275 của
-- customer có tên là Labrune
select products.*, orderdetails.orderNumber from orders
                                                     inner join customers on orders.customerNumber = customers.customerNumber
                                                     inner join orderdetails on orderdetails.orderNumber = orders.orderNumber
                                                     inner join products on products.productCode = orderdetails.productCode
where  customers.contactLastName = 'Labrune' and orders.orderNumber = 10275


SELECT * FROM products
where productCode = 'S10_1678';