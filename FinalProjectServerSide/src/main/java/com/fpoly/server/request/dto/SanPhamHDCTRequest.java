/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 23, 2020
 */
package com.fpoly.server.request.dto;

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
public class SanPhamHDCTRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idSanPham;
	private String idLoHang;
	private Integer soLuong;
	private Double giaBan;

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + idSanPham.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SanPhamHDCTRequest))
			return false;
		SanPhamHDCTRequest sanPhamHDCTResponse = (SanPhamHDCTRequest) obj;
		return sanPhamHDCTResponse.idSanPham.equals(idSanPham);
	}

}
