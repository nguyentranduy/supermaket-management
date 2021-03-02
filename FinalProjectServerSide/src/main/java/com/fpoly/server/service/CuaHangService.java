/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.server.service;

import java.util.List;

import com.fpoly.server.response.dto.CuaHangResponse;

public interface CuaHangService {

	CuaHangResponse findOne(String idCuaHang);
	CuaHangResponse findByIdNguoiDung(String idNguoiDung);
	List<CuaHangResponse> findListAll();
	List<CuaHangResponse> findByTenCuaHang(String tenCuaHang);
}
