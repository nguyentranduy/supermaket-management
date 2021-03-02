/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 18, 2020
 */
package com.fpoly.server.response.dto;

public interface SanPhamResponse {
	
	String getIdSanPham();	
	String getIdCuaHang();
	String getTenSanPham();
	String getMaVach();	
	String getIdNhomHang();	
	String getIdDVT();	
	String getIdNguoiDung();	
	String getIdLoHang();	
	Integer getSoLuong();	
	Double getGiaVon();	
	Double getGiaBan();	
	Integer getDinhMucDuoi();	
	Integer getDinhMucTren();	
	String getHinhAnh();	
	Integer getTrangThai();

}