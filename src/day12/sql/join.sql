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