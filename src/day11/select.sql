-- Mỗi query nó ảnh hưởng tới dữ liệu
-- Nó sẽ trả về số lượng records bị ảnh hưởng/ affected

-- Sau khi insert sau, ngta thường sử dụng câu lệnh
-- SELECT để kiểm tra lại dữ liệu

SELECT id as laptop_id, name as laptop_name FROM LAPTOP;

-- Tạo database -> Use Database/Schema -> Tạo Table
-- Insert vào table -> Kiểm tra lại bằng select

-- Khi mà select nó sẽ trả tất cả bản ghi, dựa vào Database
-- Server của mình, có thể là 4000, có thể 4000000
-- Việc mà sử dụng select để lấy dữ liệu, truy vấn
-- Dựa vào số bản ghi trả về, mà nó lấy tài nguyên
-- Tức là càng nhiều dữ liệu trả về, nó sẽ mất thời gian
-- Mất bộ nhớ
-- Server Database, ngta ít khi để nó quá mạnh
-- Tuỳ thuộc vào yêu cầu
-- Sinh ra các điều kiện, sắp xếp, và thậm chí giới hạn
-- Các bản ghi được trả ra thông qua câu lệnh select

-- Câu lệnh điều kiện trong select = WHERE
SELECT * FROM LAPTOP
WHERE id = 10
-- WHERE THƯỜNG VIẾT SAU FROM và là điều kiện cho các cột

SELECT * FROM LAPTOP
WHERE id > 3; -- <, >=, <=, <>

SELECT * FROM LAPTOP
WHERE id <> 3;

SELECT * FROM LAPTOP
WHERE id <> 3 AND NAME = 'DELL I17';

SELECT * FROM LAPTOP
WHERE id <> 3 OR id <> 4;

SELECT * FROM LAPTOP
WHERE id between 1 and 3;
-- Between, ứng dụng tìm khoảng giá tiền
-- Khoảng thời gian, khoảng date

SELECT * FROM LAPTOP
WHERE NAME = 'DELL I17';
-- varchar/string = là tìm chính xác
-- tìm tương đối
SELECT * from LAPTOP
WHERE NAME LIKE 'DELL';
-- Câu lệnh đặc biệt, các bạn phải thêm
-- % vào trước hoặc sau, hoặc cả trước cả sau
SELECT * from LAPTOP
WHERE NAME LIKE '%DELL'; -- Đuôi phải giống DELL

SELECT * from LAPTOP
WHERE NAME LIKE 'DELL%'; -- Đầu phải giống DELL

SELECT * from LAPTOP
WHERE NAME LIKE '%DELL%'; -- Trong bản ghi có chứa

-- Các câu trên là điều kiện đơn, ngoài câu
-- and or between
SELECT * from LAPTOP
WHERE id in (2, 3, 4) -- Tìm trong list điều kiện

SELECT * from LAPTOP
WHERE id not in (2, 3, 4) -- Không tìm trong list điều kiện

SELECT * from LAPTOP
WHERE id is null -- Tìm id null

SELECT * from LAPTOP
WHERE id is not null -- Tìm id không null

    insert into LAPTOP(name) values ('Acer');

SELECT * from LAPTOP;

-- SELECT sắp xếp
-- SELECT * from LAPTOP;
-- ORDER BY <Tên column>
-- ORDER BY nằm sau WHERE
SELECT * FROM LAPTOP
ORDER BY id;
-- Để select tăng dần, thì mình dùng từ asc ở đằng sau
-- và giảm dần thì dừng desc
SELECT * FROM LAPTOP
ORDER BY id asc; -- Bản chất nó đã sắp xếp rồi, nên
-- thường lược bỏ

SELECT * FROM LAPTOP
ORDER BY id desc;

SELECT * FROM LAPTOP
ORDER BY name desc;

-- Giới hạn bản ghi trả ra
-- Thêm LIMIT 0, thay 0 bằng số cần limit
-- LIMIT dùng đằng sau ORDER BY
SELECT * FROM LAPTOP
ORDER BY name desc
    LIMIT 2;

-- SELECT TOP tương đương select LIMIT
SELECT TOP [Số record tối đa trả về]
FROM [Tên bảng]

-- Update dữ liệu kiểu gì?
SELECT * FROM LAPTOP;

-- UPDATE
UPDATE LAPTOP set id = 100
WHERE id = 6;
-- Câu này về bản chất là điều kiện
-- Cứ id là null thì set id = 6
-- Nó không chỉ ảnh hưởng 1 bản ghi, có thể ảnh hưởng
-- Rât nhiều bản ghi
-- Khi chạy câu lệnh UPDATE/ DELETE
-- Nó sẽ báo lỗi safe update
-- Để tránh chuyện xoá nhầm dữ liệu hoặc là sửa nhầm
-- Để xử lý chạy câu lệnh SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 0;
UPDATE LAPTOP set name = 'Acer Ins', price = 2999.9
WHERE id = 6;

SELECT * FROM LAPTOP WHERE id = 100;
-- Từ đây nó 1 cái dở, là id cũng thay đổi được
-- Vậy nên từ đây người ta sinh ra 1 cái
-- Gọi là khoá chính, PRIMARY KEY
-- PRIMARY KEY là chìa khoá, quyết định bản ghi trong bảng
-- theo cột, thường thì nó sẽ là id
-- Có nghĩa là từ id chúng ta sẽ lấy được dữ liệu/ bản ghi
-- duy nhất

CREATE TABLE STUDENT(
                        id int PRIMARY KEY auto_increment,
                        first_name varchar(255),
                        last_name varchar(255),
                        dob datetime,
                        gender tinyint,
                        address varchar(255)
)
    -- khi sử dụng khoá chính PRIMARY KEY, ngta thường sử dụng
-- 1 cụm từ để xử lý việc khoá chính tự tăng
-- Không cần hoặc hạn chế việc insert từ bên ngoài vào
-- auto_increment về logic, Core SQL tự tăng bởi 1

-- Khi insert dữ liệu vào 1 bảng có khoá chính và auto_incre
-- Thì không cần phải liệt kê trường id vào
    INSERT INTO STUDENT (id, first_name, last_name, dob, gender, address)
values (1, 'Green', 'Academy', '20241031', 1, '148 Nguyen Trai');

INSERT INTO STUDENT (first_name, last_name, dob, gender, address)
values ('Hello', 'Academy A', '20221031', 1, '148 Nguyen Trai');

SELECT * FROM STUDENT;

SELECT * FROM STUDENT
                  LIMIT 2;

-- SELECT TOP 3 FROM STUDENT;


-- SELECT * FROM ORDER
-- ORDER BY total_amount desc
-- LIMIT 3


-- Để xoá database
-- Để xoá table
-- Dùng câu lệnh drop
DROP DATABASE ABC;
DROP TABLE LAPTOP;

-- Thao tác với dữ liệu trong bảng