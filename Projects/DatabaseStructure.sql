
CREATE DATABASE BankManager
GO
USE BankManager
GO

CREATE TABLE KHACHHANG
(
    MaKH VARCHAR(20), -- neu de cmmd làm ID thì có đảm bảo bảo mật ko ??
	TenKH NVARCHAR(30) NOT NULL,
	NgaySinh DATE NOT NULL,
	GioiTinh BIT NOT NULL, -- 0 = Nam, 1 = Nu
	DiaChi NVARCHAR(50),
	SoDienThoai VARCHAR(10), 
	PRIMARY KEY(MaKH)
)
GO


CREATE TABLE TAIKHOAN
(
    SoTK VARCHAR(20) PRIMARY KEY,
	MaKH VARCHAR(20) NOT NULL,
	NgayDangKy DATE NOT NULL DEFAULT GETDATE(), --mặc định ngày đăng kí là ngày thực hiện tạo TK
	SoDu MONEY DEFAULT 5000000 NOT NULL,

	FOREIGN KEY(MaKH) REFERENCES dbo.KHACHHANG(MaKH),
)
GO

CREATE TABLE loginAccount
(
	loginName VARCHAR(30) NOT NULL,
	loginPassword VARCHAR(30) NOT NULL,
	SoTK VARCHAR(20),
	
	PRIMARY KEY(loginName),
	FOREIGN KEY(SoTK) REFERENCES dbo.TAIKHOAN(SoTK)
)



CREATE TABLE CHITIETGD
(
    MaGD VARCHAR(20) NOT NULL,
	SoTien MONEY NOT NULL,
	NoiDung NVARCHAR(100),
	NgayGD DATE NOT NULL DEFAULT GETDATE(),
	PRIMARY KEY(MaGD),
)
GO 
CREATE TABLE GIAODICH
(
	SoTK VARCHAR(20) NOT NULL,
	LoaiGD NVARCHAR(20) NOT NULL,
	MaGD VARCHAR(20) NOT NULL,
	PRIMARY KEY(SoTK,MaGD),
	FOREIGN KEY(SoTK) REFERENCES dbo.TAIKHOAN(SoTK),
	FOREIGN KEY(MaGD) REFERENCES dbo.CHITIETGD(MaGD)

)
GO

--chen data khach hang
INSERT INTO dbo.KHACHHANG
(
    MaKH,
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
    MaKH,
    TenKH,
    NgaySinh,
    GioiTinh, -- false = Name, true = nữ
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
    MaKH,
    NgayDangKy,
    SoDu
)
VALUES
(   '9704363636',      -- SoTK - varchar(20)
    '1234567891',      -- MaKH - varchar(20)
    DEFAULT, -- NgayDangKy - datetime
    DEFAULT  -- SoDu - money
    )
INSERT INTO dbo.TAIKHOAN
(
    SoTK,
    MaKH,
    NgayDangKy,
    SoDu
)
VALUES
(   '9704686868',      -- SoTK - varchar(20)
    '9876543211',      -- MaKH - varchar(20)
    DEFAULT, -- NgayDangKy - datetime
    DEFAULT  -- SoDu - money
    )
INSERT INTO dbo.loginAccount
(
    loginName,
    loginPassword,
    SoTK
)
VALUES
(   'test1',  -- loginName - varchar(30)
    'admin',  -- loginPassword - varchar(30)
    '9704363636' -- SoTK - varchar(20)
)
INSERT INTO dbo.loginAccount
(
    loginName,
    loginPassword,
    SoTK
)
VALUES
(   'test2',  -- loginName - varchar(30)
    'admin',  -- loginPassword - varchar(30)
    '9704686868' -- SoTK - varchar(20)
)