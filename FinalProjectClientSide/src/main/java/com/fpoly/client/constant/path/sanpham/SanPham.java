/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.client.constant.path.sanpham;

public final class SanPham {
	
	public static final String FIND_ONE = "http://localhost:8080/api/sanpham/{idSanPham}?cuahang={idCuaHang}";
	public static final String FIND_BY_CUA_HANG = "http://localhost:8080/api/sanpham/find?cuahang={idCuaHang}";
	public static final String FIND_BY_MA_VACH = "http://localhost:8080/api/sanpham/find?cuahang={idCuaHang}&mavach={mavach}";
	public static final String FIND_BY_NHOM_HANG = "http://localhost:8080/api/sanpham/find?cuahang={idCuaHang}&nhomhang={idNhomHang}";
	public static final String FIND_BY_TEN_SAN_PHAM = "http://localhost:8080/api/sanpham/find?cuahang={idCuaHang}&tensanpham={tenSanPham}";

}
