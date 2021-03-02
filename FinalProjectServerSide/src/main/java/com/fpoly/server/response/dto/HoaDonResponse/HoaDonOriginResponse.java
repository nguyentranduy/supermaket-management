/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 23, 2020
 */
package com.fpoly.server.response.dto.HoaDonResponse;

import java.util.Date;

public interface HoaDonOriginResponse {

	String getIdHoaDon();
	String getIdCuaHang();
	String getIdNguoiDung();
	String getTenKhachHang();
	Double getTongTien();
	Date getCreatedAt();
}
