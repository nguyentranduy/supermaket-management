/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.client.model.response;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(setterPrefix = "set")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class SanPhamResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idSanPham;
	private String idCuaHang;
	private String tenSanPham;
	private String maVach;
	private String idNhomHang;
	private String idDVT;
	private String idNguoiDung;
	private String idLoHang;
	private Integer soLuong;
	private Double giaVon;
	private Double giaBan;
	private Integer dinhMucDuoi;
	private Integer dinhMucTren;
	private String hinhAnh;
	private Integer trangThai;

}