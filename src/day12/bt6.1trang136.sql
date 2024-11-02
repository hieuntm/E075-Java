--- 1. TẠO DATABASE - >TẠO BẢNG
CREATE DATABASE bt61.trang136;

use bt61.trang136;

CREATE TABLE MON_HOC(
    MSMH varchar(10) PRIMARY KEY, -- Nếu mà key là varchar, thì không nên dùng auto_increment
    TENMH varchar(255),
    SO_TIN_CHI int DEFAULT 3, -- Nếu mà không insert vào cột này thì giá trị mặc định bằng 3
    TINH_CHAT bit, -- 0: học phần bắt buộc, 1: học phần tự chọn
)

CREATE TABLE LOP (
     MALOP varchar(10) PRIMARY KEY,
    TENLOP varchar(255),
    SI_SO int
)

CREATE TABLE SINH_VIEN (
    MSSV varchar(10) PRIMARY KEY,
    HO_TEN varchar(255),
    NGAYSINH date,
    MALOP varchar(10),
    FOREIGN KEY (MALOP) REFERENCES LOP(MALOP)
)

CREATE TABLE DIEM (
    MSSV varchar(10),
    MSMH varchar(10),
    DIEM float,
    FOREIGN KEY (MSSV) REFERENCES SINH_VIEN(MSSV),
    FOREIGN KEY (MSMH) REFERENCES MON_HOC(MSMH)
)

-- 2. Bắt đầu insert dữ liệu
-- MON_HOC -> LOP -> SINH_VIEN -> DIEM
INSERT INTO MON_HOC VALUES ('MH01', 'Toán', 4, 0)
INSERT INTO MON_HOC VALUES ('MH02', 'Lý', 4, 0)
INSERT INTO MON_HOC VALUES ('MH03', 'Hóa', 4, 0)
INSERT INTO MON_HOC VALUES ('MH04', 'Sinh', 4, 0)
INSERT INTO MON_HOC VALUES ('MH05', 'Văn', 3, 0)

INSERT INTO LOP(MALOP, TENLOP, SI_SO) VALUES ('L01', 'KTPM', 30)
INSERT INTO LOP VALUES ('L02', 'CNTT', 15)
INSERT INTO LOP VALUES ('L03', 'KTPM', 25)
INSERT INTO LOP VALUES ('L04', 'CNTT', 35)
INSERT INTO LOP VALUES ('L05', 'KIEMTHU', 30)

INSERT INTO SINH_VIEN VALUES ('SV01', 'Nguyễn Văn A', '1999-01-01', 'L01')
INSERT INTO SINH_VIEN VALUES ('SV02', 'Nguyễn Văn B', '1999-01-02', 'L02')
INSERT INTO SINH_VIEN VALUES ('SV03', 'Nguyễn Văn C', '1999-01-03', 'L03')
INSERT INTO SINH_VIEN VALUES ('SV04', 'Nguyễn Văn D', '1999-01-04', 'L04')
INSERT INTO SINH_VIEN VALUES ('SV05', 'Nguyễn Văn E', '1999-01-05', 'L05')

INSERT INTO DIEM VALUES ('SV01', 'MH01', 8.5)
INSERT INTO DIEM VALUES ('SV02', 'MH02', 9.5)
INSERT INTO DIEM VALUES ('SV03', 'MH03', 7.5)
INSERT INTO DIEM VALUES ('SV04', 'MH04', 8.5)
INSERT INTO DIEM VALUES ('SV05', 'MH05', 8.5)

-- Xong phần insert dữ liệu
-- 3. Thêm cột GIOI_TINH vào bảng SINH_VIEN, chỉ nhận giá trị F và M
ALTER TABLE SINH_VIEN -- Dùng câu lệnh alter để thay đổi, sửa bảng
ADD GIOI_TINH char(1)  -- add để thêm cột mới,
    -- ngoài ra thì có thể dùng modify để sửa cột có sẵn
    -- hoặc drop để xóa cột
    -- add để thêm foreign key
CHECK (GIOI_TINH IN ('F', 'M'))
-- Đảm bảo rằng, chỉ giá trị F, và M được chấp nhận
-- khi dùng câu lệnh insert, kể cả insert bằng UI


