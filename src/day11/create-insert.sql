-- Tạo database/schemas
CREATE DATABASE `JAVA-BASIC`;


-- Khi mà login vào MySQL Workbench
-- Chúng ta đứng ở vị trí ngoài các schemas

-- Để mà có thể sử dụng các schemas, thì chúng ta
-- sử dụng cái câu lệnh
use `JAVA-BASIC`;

-- Câu tạo tạo table/ tạo bảng
-- CREATE TABLE <name>

CREATE TABLE LAPTOP(
           id int,
           name varchar(255), -- Số đằng sau là độ dài của chuỗi
           price double
);

-- Khi mà có nhiều câu lệnh trong 1 file sql, thì nên
-- bôi đen câu lệnh đấy và


-- Sử dụng select để lấy dữ liệu từ bảng
SELECT * FROM LAPTOP;
-- * là kí tự dùng để select toàn bộ các cột thông tin
-- trong bảng
-- Có thể thay thế bằng tên của các cột
SELECT id, price FROM LAPTOP;
-- Nếu muốn đổi tên cột từ kết quả của câu select
-- Dùng từ as
SELECT id as laptop_id, price as price_laptop FROM LAPTOP;

-- SQL nó là Structured Query Language
-- Ngôn ngữ truy vấn thôi, việc thay đổi tin ở cột
-- Không làm thay đổi đến tính đúng sai của dữ liệu

-- Để thêm dữ liệu vào bảng
-- dùng câu lệnh insert
-- INSERT INTO LAPTOP(id, price)
INSERT INTO LAPTOP(id, name, price)
VALUES (1, 'Dell I17', 80.3);
-- INSERT 1 value/ 1 record/ 1 bản ghi/ 1 row

INSERT INTO LAPTOP(id, name, price)
VALUES (1, 'Dell I17', 80.3),
       (1, 'Dell I17', 80.3),
       (1, 'Dell I17', 80.3),
       (1, 'Dell I17', 80.3) ;