-- 4 Chuẩn
-- NF1
-- NF2
-- NF3 -- Dùng chuẩn này, để đánh đổi performance, tài nguyên
-- NFBC - Boyce Code -> 4NF -> Chuẩn hay dùng

-- Chuẩn 1: Về cơ bản, không cột nào chứa dữ liệu kép
-- tất cả dữ liệu ở mỗi cột đều phải là giá trị

-- Địa chỉ (addressline1): 162-164 Grafton Road, London, NW5 4BA, United Kingdom
-- Người ta sẽ tách ra thành các cột như là số nhà, tên đường, thành phố, quốc gia
-- tên đường (Grafton Road)
-- số nhà (162-164)
-- thành phố (London)
-- quốc gia (UK)

-- Chuẩn 2: phải là chuẩn 1
--




--- MaNV(PK)    TenNV  DiaChi  MaPB(PK)    TenPB   DiaChiPB
---     1                   A           1                 B               C             D
---    1                  A           1                   C               CC           AD


-- Bảng NV
--  MaNV(PK)    TenNV  DiaChi
--  1                   A           1

-- Bảng PB
--  MaPB(PK)    TenPB   DiaChiPB
--         B               C             D
--         C               CC           AD

-- Bảng NV_PB
-- MaNV(PK)    MaPB(PK)  SoGio
--   1                   B                   8
--   1                   C                   8
