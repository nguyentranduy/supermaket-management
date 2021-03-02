/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 24, 2020
 */
package com.fpoly.server.response.dto;

import java.util.Date;

public interface CuaHangResponse {
	
	String getIdCuaHang();
	String getTenCuaHang();
	String getIdNguoiDung();
	String getUserName();
	String getHoTen();
	String getDienThoai();
	String getDiaChi();
	Date getNgayDangKy();
	String getUpdatedBy();
	Date getUpdatedAt();
	Boolean getTrangThai();

}
