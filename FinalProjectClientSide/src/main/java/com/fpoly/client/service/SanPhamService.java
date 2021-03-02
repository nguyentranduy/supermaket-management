/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.client.service;

import java.util.List;

import com.fpoly.client.model.response.SanPhamResponse;

public interface SanPhamService {
	
	SanPhamResponse findOne(String idSanPham, String idCuaHang);
	SanPhamResponse findByMaVach(String idCuaHang, String maVach);
	List<SanPhamResponse> findByIdCuaHang(String idCuaHang);
	List<SanPhamResponse> findByNhomHang(String idCuahang, String idNhomHang);
	List<SanPhamResponse> findByTenSanPham(String idCuaHang, String tenSanPhan);

}
