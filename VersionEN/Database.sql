CREATE DATABASE QLNH
GO
USE QLNH
GO

CREATE TABLE KHACHHANG
(
    CMND VARCHAR(20), -- neu de cmmd làm ID thì có đảm bảo bảo mật ko ??
	TenKH NVARCHAR(30) NOT NULL,
	NgaySinh DATE NOT NULL,
	GioiTinh BIT NOT NULL, -- 0 = Nam, 1 = Nu
	DiaChi NVARCHAR(50),
	SoDienThoai VARCHAR(10), 
	PRIMARY KEY(CMND)
)
GO


CREATE TABLE TAIKHOAN
(
    SoTK VARCHAR(20) PRIMARY KEY,
	CMND VARCHAR(20) NOT NULL,
	TenTK VARCHAR(30)NOT NULL,
	Matkhau VARCHAR(20) NOT NULL,
	NgayDangKy DATE DEFAULT GETDATE(), --mặc định ngày đăng kí là ngày thực hiện tạo TK
	SoDu BIGINT DEFAULT 0,

	FOREIGN KEY(CMND) REFERENCES dbo.KHACHHANG(CMND),
)
GO



CREATE TABLE GIAODICH
(
	MaGD VARCHAR(20) PRIMARY KEY,
	NgayGD DATETIME NOT NULL DEFAULT GETDATE(),
	SoTien MONEY NOT NULL,
	GhiChu NVARCHAR(70),
)
GO

CREATE TABLE CHITIETGD
(

    MaGD VARCHAR(20) NOT NULL,
	LoaiGD NVARCHAR(20) NOT NULL,
	SoTK VARCHAR(20) NOT NULL, -- tài khoản nguồn
	SoTKNhan VARCHAR(20) NOT NULL, -- tai khoan thụ hưởng
	PRIMARY KEY(MaGD,SoTK,SoTKNhan),
	FOREIGN KEY (MaGD) REFERENCES dbo.GIAODICH(MaGD),
	FOREIGN KEY (SoTK) REFERENCES  dbo.TAIKHOAN(SoTK),
	FOREIGN KEY (SoTKNhan) REFERENCES dbo.TAIKHOAN(SoTK)
)
GO 


--chen data khach hang
INSERT INTO dbo.KHACHHANG
(
    CMND,
    TenKH,
    NgaySinh,
    GioiTinh,
    DiaChi,
    SoDienThoai
)
VALUES
(   '1234567891',        -- MaKH - varchar(20)
    N'Nguyễn Thanh Hòa',       -- TenKH - nvarchar(30)
    '01/01/2001', -- NgaySinh - date
    0,      -- GioiTinh - bit
    N'dia chi 1',      -- DiaChi - nvarchar(50)
    '0868104306'       -- SoDienThoai - varchar(10)
    )
INSERT INTO dbo.KHACHHANG
(
    CMND,
    TenKH,
    NgaySinh,
    GioiTinh,
    DiaChi,
    SoDienThoai
)
VALUES
(   '9876543211',        -- MaKH - varchar(20)
    N'Lê Ngọc Hà',       -- TenKH - nvarchar(30)
    '11/05/2001', -- NgaySinh - date
    1,      -- GioiTinh - bit
    'Dia Chi 2',      -- DiaChi - nvarchar(50)
    '0987667887'       -- SoDienThoai - varchar(10)
)
INSERT INTO dbo.TAIKHOAN
(
    SoTK,
    CMND,
    TenTK,
    Matkhau,
    NgayDangKy,
    SoDu
)
VALUES
(   '970468686868',      -- SoTK - varchar(20)
    '9876543211',      -- MaKH - varchar(20)
    'test1',      -- TenTK - varchar(30)
    'admin',      -- Matkhau - varchar(20)
    DEFAULT, -- NgayDangKy - datetime
    DEFAULT  -- SoDu - money
    )
INSERT INTO dbo.TAIKHOAN
(
    SoTK,
    CMND,
    TenTK,
    Matkhau,
    NgayDangKy,
    SoDu
)
VALUES
(   '970436363636',      -- SoTK - varchar(20)
    '1234567891',      -- MaKH - varchar(20)
    'test1',      -- TenTK - varchar(30)
    'admin',      -- Matkhau - varchar(20)
    DEFAULT, -- NgayDangKy - datetime
    DEFAULT  -- SoDu - money
)
 select * from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND WHERE TenTK = 'hoanglong'