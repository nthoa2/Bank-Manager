CREATE DATABASE QLNH
GO

USE  QLNH
GO

CREATE TABLE CHINHANH
(
	MaCN VARCHAR(20),
	TenCN NVARCHAR(50),
	DiaChi NVARCHAR(50),
	CONSTRAINT PK_CHINHANH PRIMARY KEY (MaCN)
)
GO

CREATE TABLE NHANVIEN
(
    MaNV VARCHAR(10),
	TenNV NVARCHAR(30),
	NgayVL DATE,
	MaCN VARCHAR(20) NOT NULL,
	CONSTRAINT PK_NHANVIEN PRIMARY KEY(MaNV),
	CONSTRAINT FK_NHANVIEN FOREIGN KEY (MaCN) REFERENCES CHINHANH(MaCN),
)
GO

CREATE TABLE KHACHHANG
(
    CMND VARCHAR(20),
	TenKH NVARCHAR(30),
	NgaySinh DATE,
	GioiTinh BIT, 
	DiaChi NVARCHAR(50),
	SoDienThoai VARCHAR(10), 
	CONSTRAINT PK_KHACHHANG PRIMARY KEY(CMND)
)
GO

CREATE TABLE XULYNHUCAU
(
	CMND VARCHAR(20),
	MaNV VARCHAR(10),
	NgayLamViec DATE,
	NhuCau NVARCHAR(50),

	CONSTRAINT PK_XULYNHUCAU PRIMARY KEY(CMND, MaNV)
)
GO

CREATE TABLE TAIKHOAN
(
    SoTK VARCHAR(20),
	TenDangNhap NVARCHAR(30) UNIQUE NOT NULL,
	MatKhau VARCHAR(20),
	NgayDangKy DATE,
	SoThe VARCHAR(20),
	SoDu FLOAT DEFAULT 50000000.0, -- số dư ban đầu của mỗi tài khoản là 50 trệu đồng
	CMND VARCHAR(20) NOT NULL,
	
	CONSTRAINT PK_TAIKHOAN PRIMARY KEY(SoTK),
	CONSTRAINT FK_TAIKHOAN FOREIGN KEY (CMND) REFERENCES dbo.KHACHHANG(CMND)
)
GO

CREATE TABLE QUANLY
(
	MaNV VARCHAR(10),
	SoTK VARCHAR(20),
	NgayKT DATE ,
	GhiChu NVARCHAR(50),

	CONSTRAINT PK_QUANLY PRIMARY KEY(MaNV, SoTK)
)
GO

CREATE TABLE GIAODICH
(
	MaGD VARCHAR(20) PRIMARY KEY,
	LoaiGD NVARCHAR(30),
	
)
GO

CREATE TABLE CHITIETGD
(
    MaGD VARCHAR(20) NOT NULL,
	SoTK VARCHAR(20) NOT NULL,
	SoTKNhan VARCHAR(20),
	NgayGD DATE,
	SoTien FLOAT,
	GhiChu NVARCHAR(70),
    PRIMARY KEY(MaGD, SoTK),
	FOREIGN KEY (MaGD) REFERENCES GIAODICH(MaGD),
	FOREIGN KEY (SoTK) REFERENCES TAIKHOAN(SoTK),
	FOREIGN KEY (SoTKNhan) REFERENCES TAIKHOAN(SoTK)
)
GO 
-- Tạo khóa ngoại cho bảng XULYNHUCAU
ALTER TABLE XULYNHUCAU ADD FOREIGN KEY(CMND) REFERENCES KHACHHANG(CMND)
ALTER TABLE XULYNHUCAU ADD FOREIGN KEY(MaNV) REFERENCES NHANVIEN(MaNV)

-- Tạo khóa ngoại cho bảng  QUANLY
ALTER TABLE QUANLY ADD FOREIGN KEY(MaNV) REFERENCES NHANVIEN(MaNV)
ALTER TABLE QUANLY ADD FOREIGN KEY(SoTK) REFERENCES TAIKHOAN(SoTK)

-- Tạo khóa ngoại cho bảng CHITIETHD
ALTER TABLE CHITIETGD ADD FOREIGN KEY(MaGD) REFERENCES GIAODICH(MaGD)
ALTER TABLE CHITIETGD ADD FOREIGN KEY(SoTK) REFERENCES TAIKHOAN(SoTK)


-- Thêm dữ liệu cho bảng  CHI NHANH
INSERT INTO dbo.CHINHANH(MaCN,TenCN,DiaChi)
VALUES( 'CN01',N'VietinBank', N'Hà nội'  )
INSERT INTO dbo.CHINHANH(MaCN,TenCN,DiaChi)
VALUES( 'CN02',N'VietinBank', N'Đà nẵng'  )
INSERT INTO dbo.CHINHANH(MaCN,TenCN,DiaChi)
VALUES( 'CN03',N'VietinBank', N'Hồ chí minh' )




-- Thêm dữ liệu cho bảng NHAN VIEN
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV001', N'Hà huy hoàng','2016-2-28','CN01' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV002', N'Võ đoàn hoàng long','2017-1-21','CN02' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV003', N'Lê âu hải','2017-8-20','CN02' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV004', N'Nguyễn thanh hoa','2017-6-20','CN02' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV005', N'Đặng văn phước','2018-9-23','CN02' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV006', N'Phan tấn hoàng','2017-12-2','CN01' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV007', N'Đào duy tân','2018-11-25','CN02' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV008', N'Bùi văn tân','2019-1-8','CN03' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV009', N'Vũ quang huy','2018-1-20','CN03' )
INSERT INTO dbo.NHANVIEN(MaNV,TenNV,NgayVL, MaCN)
VALUES( 'NV010', N'Huỳnh tiến thịnh','2017-1-20','CN03' )



-- Thêm dữ liệu cho bảng  KHACH HANG
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558671', N'Đặng đình duy', '1980-1-20',1, N'Hà nội', '0982753684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558672', N'Đoàn phước nhật', '1980-12-2',1, N'Hồ chí minh', '0382753684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558673', N'Đặng quang trường nguyên', '2019-2-20',1, N'Hà nội', '0382853684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558674', N'Lê anh quốc', '1990-3-20',1, N'Hồ chí minh', '0982750684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558675', N'Trần thị thanh thư', '2019-11-20',0, N'Hà nội', '0982703684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558676', N'Hồ ngọc thống', '1990-11-20',1, N'Đà nẵng', '0082753684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558677', N'Phan quang đông', '1980-7-20',1, N'Hồ chí minh', '0380753684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558678', N'Nguyễn văn quyền', '1990-5-20',1, N'Hà nội', '0382053084' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558679', N'Phan mạnh quỳnh', '1990-6-20',0, N'Đà nẵng', '0982003684' )
INSERT INTO dbo.KHACHHANG(CMND,TenKH,NgaySinh,GioiTinh,DiaChi,SoDienThoai)
VALUES(   '215558680', N'Huỳnh thị thanh', '1990-4-20',0, N'Hà nội', '0982780684' )



-- Thêm dữ liệu cho bảng  XU LY NHU CAU
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558671', 'NV001',  '2019-2-20',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558671', 'NV002',  '2020-1-1',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558671', 'NV008',  '2019-2-18',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558672', 'NV001',  '2020-3-18',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558672', 'NV002',  '2020-1-1',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558672', 'NV006',  '2019-5-20',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558672', 'NV007',  '2019-6-20',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558673', 'NV009',  '2020-7-20',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558673', 'NV010',  '2020-1-1',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558673', 'NV005',  '2019-9-20',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558673', 'NV007',  '2019-12-20',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558673', 'NV002',  '2020-1-2',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558675', 'NV006',  '2020-12-2',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558675', 'NV010',  '2020-8-25',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558675', 'NV003',  '2020-1-20',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV001',  '2020-8-20',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV002',  '2020-1-1',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV006',  '2020-1-1',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV007',  '2020-1-1',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV008',  '2020-3-2',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558678', 'NV005',  '2020-1-1',N'Cập nhập thông tin khách hàng' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558680', 'NV002',  '2020-12-25',N'Liệt kê lịch sử giao dịch' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558680', 'NV009',  '2020-1-1',N'Đổi mật khẩu' )
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)
VALUES(   '215558680', 'NV010',  '2020-12-7',N'Cập nhập thông tin khách hàng')
INSERT INTO dbo.XULYNHUCAU(CMND,MaNV,NgayLamViec,NhuCau)	
VALUES(   '215558680', 'NV008',  '2020-1-1',N'Liệt kê lịch sử giao dịch')



-- Thêm dữ liệu cho bảng TAI KHOAN
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205267891', N'DANG DINH DUY', 'A0123456', '2018-1-26','970405026961', 5000000, '215558671' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205207092', N'BACH VONG VU', 'B0123456', '2016-2-7','970405082962', 15000000, '215558671' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303208207098', N'NGUYEN MINH TRI', 'C0123458', '2017-3-11','970505036963', 25000000, '215558671' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303202206494', N'DOAN PHUOC NHAT', 'D0123454', '2017-4-23','970505284964', 35000000, '215558672' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205807095', N'DANG QUAN TRUONG NGUYEN', 'E0123456', '2017-5-2','970405286965', 95000000, '215558673' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205207496', N'LE THANH DUAN', 'G0123456', '2016-7-5','970405486966', 9000000, '215558673' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4363206807097', N'PHAN KHANH DUY', 'I0123456', '2018-6-6','974455586967', 9500000, '215558673' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303204207048', N'LE ANH QUOC', 'H0123455', '2019-8-20','972475086968', 10000000, '215558674' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4383202207499', N'DANG BINH PHUOC', 'O0123453', '2017-11-28','970455086969', 55000000, '215558674' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303202207002', N'DOAN MINH THONG', 'N0123452', '2018-10-20','970465286970', 800000, '215558674' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4333805207043', N'DANG NGOC CHUNG', 'M0163450', '2018-12-14','970405486981', 17000000, '215558675' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205207844', N'TRAN THI THANH THU', 'L0623456', '2017-9-23','970464086982', 23000000, '215558675' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205277843', N'KIM TAN', 'L0123956', '2018-2-18','970864085981', 23000000, '215558675' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303207507844', N'HO NGOC THONG', 'J0123406', '2016-3-20','970464058982', 23000000, '215558676' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303205607848', N'NGUYEN LE VINH', 'L0125456', '2017-4-12','970484786983', 23000000, '215558676' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303275207649', N'PHAN QUANG DONG', 'U0103455', '2016-5-11','970464056984', 23000000, '215558677' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303206277840', N'NGUYEN LAM TRUC', 'K0123452', '2019-6-3','970484056985', 33000000, '215558677' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303675207845', N'NGUYEN VAN QUYEN', 'Q0173456', '2017-7-9','970484085986', 5000000, '215558678' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303675267845', N'PHAN MANH QUYNH', 'W0163740', '2017-8-6','970464053989', 3000000, '215558679' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4306275207646', N'HUYNH Y DUYEN', 'R0123456', '2016-9-2','970764756980', 23000000, '215558679' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303207207862', N'VU HOANG PHI', 'V0126456', '2016-10-20','970465686977', 6000000, '215558680' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4603275206847', N'BUI NGOC THUY QUYEN', 'P0128456', '2019-11-8','970764586782', 6500000, '215558680' )
INSERT INTO dbo.TAIKHOAN(SoTK,TenDangNhap,MatKhau,NgayDangKy,SoThe,SoDu,CMND)
VALUES(  '4303765257866', N'HUYNH THI THANH', 'Y0123956', '2016-2-6','970467586982', 8000000, '215558680' )

-- Thêm dữ liệu cho bảng GIAO DICH
INSERT INTO dbo.GIAODICH(MaGD,LoaiGD)
VALUES( 'GD001', N'Chuyển tiền')
INSERT INTO dbo.GIAODICH(MaGD,LoaiGD)
VALUES( 'GD002', N'Nạp tiền')
INSERT INTO dbo.GIAODICH(MaGD,LoaiGD)
VALUES( 'GD003', N'Rút tiền')

-- Thêm dữ liệu cho bảng CHITIETHD
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303205267891', '4303205207092', '2020-3-20', 2500000, N'Đặng đình duy chuyển tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303208207098', '4303202206494', '2020-1-20', 15000000, N'Đặng đình duy nạp tiền cho đoàn phước nhật' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4363206807097', '4303205207092', '2020-2-20', 3000000, N'phan khánh duy nạp tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303202206494', NULL, '2020-1-20', 7000000, N'rút tiền từ tài khoản của đoàn phước nhật' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303202206494', '4303205207092', '2020-5-20', 6000000, N'đoàn phước nhật chuyển tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303205807095', '4363206807097', '2020-3-20',3500000, N'đặng quan trường nguyên chuyển tiền cho phan khánh duy' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303205207092', '4303205277843', '2020-3-30', 300000, N'bạch long vũ nạp tiền cho kim tân' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303202206494', '4363206807097', '2020-3-25', 300000, N'đoàn phước nhật nạp tiền cho phan khánh duy' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303675207845', '4303208207098', '2020-3-2', 300000, N'nguyễn văn quyền nạp tiền cho đặng đình duy' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303205207496', '4303675207845', '2020-3-20', 300000, N'lê thanh duẩn nạp tiền cho nguyễn văn quyền' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303205277843 ', '4303205207496', '2020-5-20', 300000, N'kim tân nạp tiền cho lê thanh duẩn' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303765257866', NULL, '2020-1-20', 7500000, N'rút tiền từ tài khoản của huỳnh thị thanh' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4363206807097', '4303205207092', '2020-3-20', 850000, N'phan khánh duy chuyển tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303675207845', NULL, '2020-5-20', 500000, N'rút tiền từ tài khoản của nguyễn văn quyền' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4383202207499', '4303207207862', '2020-2-20', 9000000, N'đặng bình phước nạp tiền cho vũ hoàng phi' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4363206807097', NULL, '2020-2-20', 1000000, N'rút tiền từ tài khoản của phan khánh duy' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303205807095', NULL, '2020-11-20', 2500000, N'rút tiền từ tài khoản của đặng quan trường nguyên' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303208207098', NULL, '2020-12-20', 3300000, N'rút tiền từ tài khoản của Đặng đình duy' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)	
VALUES(  'GD001', '4303205277843', '4303205207092', '2020-1-20', 2800000, N'kim tân chuyển tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303205277843', NULL, '2020-12-20', 800000, N'rút tiền từ tài khoản của kim tân' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303207507844', '4303675267845', '2020-1-12', 600000, N'hồ ngọc thống nạp tiền cho phan mạnh quỳnh' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303207207862', '4303205207092', '2020-3-20', 380000, N'vũ hoàng phi chuyển tiền cho bạch long vũ' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303765257866', '4303207507844', '2020-5-20', 4530000, N'huỳnh thị thanh chuyển tiền cho hồ ngọc thống' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD002', '4303206277840', '4303205807095', '2020-3-20', 2000000, N'nguyễn lâm trúc nạp tiền cho đặng quan trường nguyên' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303206277840', NULL, '2020-7-18', 300000, N'rút tiền từ tài khoản của nguyễn lâm trúc' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD001', '4303207507844', '4303205277843', '2020-5-20', 9830000, N'hồ ngọc thống chuyển tiền cho kim tân' )
INSERT INTO dbo.CHITIETGD(MaGD,SoTK,SoTKNhan,NgayGD,SoTien,GhiChu)
VALUES(  'GD003', '4303207507844', NULL, '2020-12-20', 36300000, N'rút tiền từ tài khoản của hồ ngọc thống' )




-- Thêm dữ liệu cho bảng QUANLY
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV001', '4303205267891', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV001', '4303205807095', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV002', '4303207207862', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV002', '4303765257866', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV003', '4303208207098', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV003', '4303205807095', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV003', '4303205267891', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV005', '4303765257866', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV005', '4303675207845', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV004', '4303205807095', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV006', '4303207507844', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV006', '4363206807097', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV007', '4383202207499', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV007', '4303205807095', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV010', '4303205807095', '2020-1-20',N'Trừ phí dịch vụ' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV010', '4303207507844', '2020-1-20',N'Kiểm tra số dư định kì' )
INSERT INTO dbo.QUANLY(MaNV,SoTK,NgayKT,GhiChu)
VALUES(   'NV010', '4383202207499', '2020-1-20',N'Trừ phí dịch vụ' )



--                                              TRUY VẤN DỮ LIỆU 

-- 1. Liệt kê danh sách nhân viên của từng chi nhánh. yêu cầu thông tin gồm: MaCN, MaNV, TenNV
-- (2). Tìm những nhân viên làm việc tại chi nhánh "CN02" có thời gian làm việc lâu nhất. yêu cầu thông tin gồm:MaCN, MaNV, TenNV
-- 3. Tìm những khách hàng đã chuyển tiền vào ngày 20/03/2020. yêu cầu thông tin gồm:CMND, TenKH
-- 4. Liệt kê số lượng nhân viên làm việc của từng chi nhánh. yêu cầu thông tin gồm:MaCN, TenCN , SOLUONG là thuộc tính tự đặt
-- 5. Tìm thông tin những khách hàng chưa chuyển tiền lần nào 
-- 6. Đưa ra tất cả giao dịch của số tài khoản "4303207507844" từ ngày "1/1/2020". yêu cầu thông tin gồm:
-- 7. In ra thông tin khách hàng có số dư cao nhất . yêu cầu thông tin gồm:CMND, TenKH, SoDu
-- 8. Liệt kê danh sách những nhân viên thực hiện giao dịch nạp tiền có số tiền nạp giảm dần. 
-- 9. Tìm tài khoản có tổng số tiền nạp lớn nhất trong tháng 3/2020. yêu cầu thông tin gồm:SoTK ,TONGTIEN là thuộc tính tự đặt
-- 10.Liệt kê danh sách khách hàng mà nhân viên 'NV002' đã làm việc từ ngày "1/1/2020" . yêu cầu thông tin gồm:CMND, TenKH

-- TÂN ĐÃ GIẢI RA 10 CÂU NÊN CHỈ GỬI AE ĐỀ R AE TỰ GIẢI 
