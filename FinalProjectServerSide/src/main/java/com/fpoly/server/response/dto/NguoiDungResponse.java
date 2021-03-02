/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 15, 2020
 */
package com.fpoly.server.response.dto;

import java.util.Date;

public interface NguoiDungResponse {

	String getIdNguoiDung();
	String getIdCuaHang();
	String getHoTen();
	String getUserName();
	String getHashPassword();
	String getEmail();
	String getDienThoai();
	Date getNgayDangKy();
	Date getLastLogin();
	String getIdQuanLy();
	String getVaiTro();
	String getHinhAnh();
	Boolean getTrangThaiKichHoat();
	Boolean getTrangThaiHoatDong();
	Date getUpdatedAt();
	String getUpdatedBy();
}
