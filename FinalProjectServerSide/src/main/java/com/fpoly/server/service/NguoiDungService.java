/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 15, 2020
 */
package com.fpoly.server.service;

import java.util.List;

import com.fpoly.server.response.dto.NguoiDungResponse;

public interface NguoiDungService {
	
	NguoiDungResponse findOne(String idNguoiDung);
	NguoiDungResponse findByUserName(String username);
	NguoiDungResponse findByEmail(String email);
	NguoiDungResponse findByDienThoai(String dienThoai);
	List<NguoiDungResponse> findByIdCuaHang(String idCuaHang);
	List<NguoiDungResponse> findByTrangThaiKichHoat(Boolean trangThaiKichHoat);
	List<NguoiDungResponse> findByTrangThaiHoatDong(Boolean trangThaiHoatDong);
	List<NguoiDungResponse> findListAll();
}
