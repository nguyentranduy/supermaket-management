use master
go

drop database if exists finalproject_sieuthimini
go

create database finalproject_sieuthimini
go

use finalproject_sieuthimini
go

create table [admin]
(
	id				int primary key identity(1,1),
	idAdmin			varchar(20) unique not null, 
	userName		varchar(20) unique not null,
	hashPassword	varchar(120) not null,
	email			varchar(50) unique not null 
)
go


create table nguoi_dung
(
	id					bigint primary key identity(1,1),
	idNguoiDung			varchar(20) unique not null, 
	idCuaHang			varchar(20) null,
	userName			varchar(20) unique not null, 
	hoTen				nvarchar(50) not null,
	hashPassword		varchar(120) not null,
	email				varchar(50) unique not null, 
	dienThoai			varchar(11) unique not null, 
	ngayDangKy			datetime not null default getdate(),
	lastLogin			datetime not null default getdate(),
	idQuanLy			varchar(20) null,
	vaiTro				varchar(20) not null,
	hinhAnh				varchar(255) null,
	trangThaiKichHoat	bit not null default 0,
	trangThaiHoatDong	bit not null default 0,
	updatedAt			datetime null,
	updatedBy			varchar(20) null,
)
go



create table cua_hang
(
	id				bigint primary key identity(1,1),
	idCuaHang		varchar(20) unique not null,
	idNguoiDung		varchar(20) not null foreign key references nguoi_dung(idNguoiDung) on update cascade on delete cascade,
	tenCuaHang		nvarchar(50) not null,
	diaChi			nvarchar(100) not null,
	ngayDangKy		datetime not null default getdate(),
	trangThai		bit not null default 1,
	updatedBy		varchar(20) null,
	updatedAt		datetime null
)	
go



create table nhom_hang
(
	id				int primary key identity(1,1),
	tenNhomHang		nvarchar(50) unique not null,
	trangThai		bit not null default 1
)
go



create table don_vi_tinh
(
	id			int primary key identity(1,1),
	tenDVT		nvarchar(20) unique not null,
	moTa		nvarchar(50) null,
	trangThai	bit not null default 1
)
go



create table san_pham
(
	id				bigint primary key identity(1,1),
	idSanPham		varchar(50) not null unique,
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	tenSanPham		nvarchar(255) not null,
	maVach			nvarchar(50) null,
	idNhomHang		int not null foreign key references nhom_hang(id) on update cascade on delete no action,
	idDVT			int not null foreign key references don_vi_tinh(id) on update cascade on delete no action,
	idNguoiDung		varchar(20) not null foreign key references nguoi_dung(idNguoiDung) on update no action on delete no action,
	idLoHang		varchar(20) null,
	soLuong			int default 0 not null,
	giaVon			decimal(12,3) not null,
	giaBan			decimal(12,3) not null,
	dinhMucDuoi		int not null,
	dinhMucTren		int not null,
	hinhAnh			varchar(255) null,
	trangThai		int not null default 1
)
go



create table nha_cung_cap
(
	id			bigint primary key identity(1,1),
	idCuaHang	varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	tenNCC		nvarchar(50) not null,
	email		varchar(50) not null,
	dienThoai	varchar(11) not null,
	diaChi		nvarchar(255) not null,
	moTa		nvarchar(255) not null,
	trangThai	bit not null default 1,
	createdAt	datetime default getdate(),
	createdBy	varchar(20) null,
	updatedAt	datetime null,
	updatedBy	varchar(20) null
)
go



create table phieu_nhap_hang
(
	id				bigint primary key identity(1,1),
	idPhieuNhap		varchar(50) not null unique,
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	idNguoiDung		varchar(20) not null foreign key references nguoi_dung(idNguoiDung) on update no action on delete no action,
	ngayNhap		datetime not null,
	tongGiaTri		decimal(12,3) not null,
	trangThai		int not null
)
go


create table phieu_nhap_chi_tiet
(
	id				bigint primary key identity(1,1),
	idPhieuNhap		varchar(50) not null foreign key references phieu_nhap_hang(idPhieuNhap) on update cascade on delete cascade,
	idLoHang		varchar(20) unique not null,
	idSanPham		varchar(50) not null foreign key references san_pham(idSanPham) on update no action on delete no action,
	idNhaCungCap	bigint not null foreign key references nha_cung_cap(id)  on update no action on delete no action,
	giaNhap			decimal(12,3) not null,
	dvt				nvarchar(20) not null,
	soLuongNhap		int not null,
	hsd				datetime not null
)
go



create table kho_hang
(
	id				bigint primary key identity(1,1),
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	idLoHang		varchar(20) unique not null,
	idSanPham		varchar(50) not null foreign key references san_pham(idSanPham)  on update no action on delete no action,
	idNhaCungCap	bigint not null foreign key references nha_cung_cap(id)  on update no action on delete no action,
	hsd				datetime not null,
	tonKho			int not null,
	trangThai		tinyint not null,
	updatedAt		datetime null,
	updatedBy		varchar(20) null
)
go



create table phieu_xuat_hang
(
	id				bigint primary key identity(1,1),
	idPhieuXuat		varchar(50) not null unique,
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	idNguoiDung		varchar(20) not null foreign key references nguoi_dung(idNguoiDung) on update no action on delete no action,
	tongGiaTri		decimal(12,3) not null,
	ngayXuat		datetime default getdate(),
	trangThai		bit not null
)
go



create table phieu_xuat_chi_tiet
(
	id				bigint primary key identity(1,1),
	idPhieuXuat		varchar(50) not null foreign key references phieu_xuat_hang(idPhieuXuat) on update cascade on delete cascade,
	idLoHang		varchar(20) not null,
	idSanPham		varchar(50) not null foreign key references san_pham(idSanPham)  on update no action on delete no action,
	dvt				nvarchar(20) not null,
	soLuongXuat		int not null,
	donGia			decimal(12,3) not null
)
go



create table phieu_kiem_ke
(
	id				bigint primary key identity(1,1),
	idPhieuKiem		varchar(50) not null unique,
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	loaiPhieuKiem	bit not null,
	createdAt		datetime default getdate(),
	createdBy		varchar(20) not null,
	giaTriLech		decimal(12,3) not null,
	ghiChu			nvarchar(50) not null,
	ngayCanBang		datetime null,
	updatedAt		datetime null,
	updatedBy		varchar(20) null,
	trangThai		bit not null
)
go

create table phieu_kiem_chi_tiet
(
	id				bigint primary key identity(1,1),
	idPhieuKiem		varchar(50) not null foreign key references phieu_kiem_ke(idPhieuKiem) on update cascade on delete cascade,
	idSanPham		varchar(50) not null foreign key references san_pham(idSanPham)  on update no action on delete no action,
	idLoHang		varchar(20) not null,
	dvt				nvarchar(20) not null,
	giaVon			decimal(12,3) not null,
	tonKhoSoSach	int not null,
	tonKhoThucTe	int not null,
	soLuongLech		int not null,
	giaTriLech		decimal(12,3) not null
)
go

create table hoa_don
(
	id				bigint primary key identity(1,1),
	idHoaDon		varchar(50) not null unique,
	idCuaHang		varchar(20) not null foreign key references cua_hang(idCuaHang) on update cascade on delete cascade,
	idNguoiDung		varchar(20) not null foreign key references nguoi_dung(idNguoiDung)  on update no action on delete no action,
	tenKhachHang	nvarchar(100) not null,
	tongTien		decimal(12,3) not null,
	createdAt		datetime default getdate()
)	
go

create table hoa_don_chi_tiet
(
	id			bigint primary key identity(1,1),
	idHoaDon	varchar(50) not null foreign key references hoa_don(idHoaDon) on update cascade on delete cascade,
	idLoHang	varchar(20) not null,
	idSanPham	varchar(50) not null foreign key references san_pham(idSanPham) on update no action on delete no action,
	soLuong		int not null,
	giaBan		decimal(12,3) not null,
	thanhTien	decimal(12,3) not null
)
go


insert into [admin](idAdmin, username, hashPassword, email) values
('Q9Y0oXl9RL5NFkeJPjk3',	'duynt',	'$2y$12$92RHn9T2rxjlafHA8a9k3.UcjFvGLatFvLkSNd6WjeuUhROyNCibu',	'nguyentranduy94@gmail.com'),
('GTk8XJmo5c9nasybSdm7',	'phupv',	'$2y$12$cxXjjRHcOelxbzalkvBQl.PDmxGOCfMKINsTFtoJfwxFHhd8GsEvG',	'phanvanphu@gmail.com')
go


insert into nguoi_dung(idNguoiDung, userName, hoTen, hashPassword, email, dienThoai, idQuanLy, vaiTro) values
('zAwdt0OQzub0Soab15wV',	'thongnn',	N'Nguyễn Nhật Thông', '$2y$12$eW6szigitXEPi4fwlxWGjOMEMxsYrRI0.vMtuw76btDwD71SHUDAm', 'thongnn@gmail.com', '0901123456', null, 1),
('8KI4FbapsQEoBQ7dgyt2',	'khanhnq',	N'Nguyễn Quốc Khánh', '$2y$12$6tXKmNMHyM/nPDuQPwtwLO0iiSgBhi6Vm2LfMRPkhcskDhtI3DTBC', 'khanhnq@gmail.com', '0902123456', 'zAwdt0OQzub0Soab15wV', 0)
go

insert into cua_hang(idCuaHang, idNguoiDung, tenCuaHang, diaChi) values
('KhIpzi4jWFoTMxDj46TW',	'zAwdt0OQzub0Soab15wV',		N'Cửa hàng demo',		N'TP HCM')
go

update nguoi_dung set idCuaHang = 'KhIpzi4jWFoTMxDj46TW' where idNguoiDung = 'zAwdt0OQzub0Soab15wV'
update nguoi_dung set trangThaiKichHoat = 1 where idNguoiDung = 'zAwdt0OQzub0Soab15wV'
update nguoi_dung set trangThaiHoatDong = 1 where idNguoiDung = 'zAwdt0OQzub0Soab15wV'
update nguoi_dung set idCuaHang = 'KhIpzi4jWFoTMxDj46TW' where idNguoiDung = '8KI4FbapsQEoBQ7dgyt2'
update nguoi_dung set trangThaiKichHoat = 1 where idNguoiDung = '8KI4FbapsQEoBQ7dgyt2'
update nguoi_dung set trangThaiHoatDong = 1 where idNguoiDung = '8KI4FbapsQEoBQ7dgyt2'
go

insert into nhom_hang(tenNhomHang) values
(N'Tổng hợp'),
(N'Văn phòng phẩm'),
(N'Bánh kẹo'),
(N'Sản phẩm sữa'),
(N'Đồ uống'),
(N'Thực phẩm'),
(N'Mỹ phẩm'),
(N'Hoá phẩm'),
(N'Nhà bếp')
go

insert into don_vi_tinh(tenDVT) values
(N'Cái'),
(N'Chai'),
(N'Gói'),
(N'Chiếc'),
(N'Hộp'),
(N'Lon'),
(N'Lốc'),
(N'Thùng'),
(N'Cây'),
(N'Tuýp'),
(N'Lọ'),
(N'Quyển'),
(N'Cuộn')
go

insert into san_pham(idSanPham, idCuaHang, tenSanPham, idNhomHang, idDVT, idNguoiDung, soLuong, giaVon, giaBan, dinhMucDuoi, dinhMucTren) values
('k8laMeMGHZfLdv5tieEv', 'KhIpzi4jWFoTMxDj46TW', N'Sản phẩm demo', 1, 1, 'zAwdt0OQzub0Soab15wV', 10, 10000, 12000, 5, 20)
go

insert into nha_cung_cap(idCuaHang, tenNCC, email, dienthoai, diaChi, moTa) values
('KhIpzi4jWFoTMxDj46TW', N'NCC demo', 'ncc@gmail.com', '0912345678', 'TP HCM', 'nhà cung cấp demo')
go


insert into phieu_nhap_hang(idPhieuNhap, idCuaHang, idNguoiDung, ngayNhap, tongGiaTri, trangThai) values
('lejUYqc2v9JxJhFNtaBF', 'KhIpzi4jWFoTMxDj46TW', 'zAwdt0OQzub0Soab15wV', '2020-11-15', 2000000, 1) -- 1: da nhap, 0: da xoa 
go

insert into phieu_nhap_chi_tiet(idPhieuNhap, idLoHang, idSanPham, idNhaCungCap, giaNhap, dvt, soLuongNhap, hsd) values
('lejUYqc2v9JxJhFNtaBF', '3EEI08NkXQdHvAH38Y7W', 'k8laMeMGHZfLdv5tieEv', 1, 10000, N'Cái', 20, '2021-12-12')
go

insert into kho_hang(idCuaHang, idLoHang, idSanPham, idNhaCungCap, hsd, tonKho, trangThai) values
('KhIpzi4jWFoTMxDj46TW', '3EEI08NkXQdHvAH38Y7W', 'k8laMeMGHZfLdv5tieEv', 1, '2021-12-12', 10, 1) -- 1: dang ban, 0: chua ban, -1: da het hang 
go

insert into phieu_xuat_hang(idPhieuXuat, idCuaHang, idNguoiDung, tongGiaTri, trangThai) values
('DzPUuDqGtUCvToN8QkeS', 'KhIpzi4jWFoTMxDj46TW', 'zAwdt0OQzub0Soab15wV', 1000000, 1)
go

insert into phieu_xuat_chi_tiet(idPhieuXuat, idLoHang, idSanPham, dvt, soLuongXuat, donGia) values
('DzPUuDqGtUCvToN8QkeS', '3EEI08NkXQdHvAH38Y7W', 'k8laMeMGHZfLdv5tieEv', N'Cái', 10, 10000)
go

create procedure sp_nhanvien_thongkebanhang 
(
	@idNhanVien varchar(20) 
)
as
begin
	select 
		count(idHoaDon) as tongsohoadon,
		sum(tongtien) as tongtien,
		hoten,
		convert(varchar,createdAt,103) as [ngaythongke]
	from
		hoa_don left join nguoi_dung on hoa_don.idNguoiDung = nguoi_dung.idNguoiDung
	where 
		hoa_don.idNguoiDung = @idNhanVien
		and convert(varchar,createdAt,103) = convert(varchar,getdate(),103) 
	group by hoa_don.idNguoiDung, convert(varchar,createdAt,103), hoten
end

go

/*
  A. QUAN LY SAN PHAM TREN KE BAN:
      1. ds hang da het han su dung ma van con tren ke ban
	  */
if OBJECT_ID('sp_quanly_thongkeso1') is not null
drop proc sp_quanly_thongkeso1
go

/* tk so 1: danh sach sp da het han ma van con nam tren ke*/
create procedure sp_quanly_thongkeso1 
(
	@idCuaHang varchar(20) 
)
as
begin
	select
		sp.idsanpham,
		sp.tensanpham,
		sp.idlohang,
		sp.soLuong as soluongtrenke,
		kh.hsd,
		nh.tennhomhang,
		pn.ngaynhap,
		kh.tonkho as tonkho
	from
		san_pham sp 
			left join nhom_hang nh
				on sp.idnhomhang = nh.id
			left join kho_hang kh
				on (sp.idlohang = kh.idLoHang and sp.idSanPham = kh.idSanPham)
			left join phieu_nhap_chi_tiet pnct
				on (sp.idLoHang = pnct.idLoHang and sp.idSanPham = pnct.idSanPham)
			left join phieu_nhap_hang pn
				on pnct.idPhieuNhap = pn.idPhieuNhap
	where 
 		sp.idCuaHang = @idCuaHang
		and sp.trangThai = 1
		and kh.hsd < getdate()
end
go

if OBJECT_ID('sp_quanly_thongkeso2') is not null
drop proc sp_quanly_thongkeso2
go

/* thong ke so 2: dem so sp sap het han trong 7 ngay toi*/
create procedure sp_quanly_thongkeso2 
(
	@idCuaHang varchar(20) 
)
as
begin
	select
		count(sp.idsanpham) as result
	from
		san_pham sp 
			left join nhom_hang nh
				on sp.idnhomhang = nh.id
			left join kho_hang kh
				on (sp.idlohang = kh.idLoHang and sp.idSanPham = kh.idSanPham)
	where 
 		sp.idCuaHang = @idCuaHang
		and sp.trangThai = 1
		and kh.hsd between getdate() and (getdate()+7)
end
go
