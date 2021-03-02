/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 23, 2020
 */
package com.fpoly.server.service;

import java.util.List;

import com.fpoly.server.request.dto.HoaDonRequest;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonChiTietOriginResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonFinalResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonOriginResponse;
import com.fpoly.server.response.dto.HoaDonResponse.SanPhamHoaDonResponse;

public interface HoaDonService {
	
	Boolean insert(HoaDonRequest hoaDonRequest);
	HoaDonFinalResponse findOne(String idHoaDon, String idCuaHang);
	List<HoaDonFinalResponse> findByIdNguoiDung(String idNguoiDung, String idCuaHang);
	List<HoaDonFinalResponse> findByIdCuaHang(String idCuaHang);
	
	HoaDonOriginResponse findOneOrigin(String idHoaDon, String idCuaHang);
	List<HoaDonChiTietOriginResponse> findListHDCTByIdHoaDon(String idHoaDon);
	List<SanPhamHoaDonResponse> findSanPhamInHDCT(String idHoaDon);

}