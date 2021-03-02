/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 24, 2020
 */
package com.fpoly.server.response.dto.HoaDonResponse;

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
public class HoaDonChiTietFinalResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idHoaDon;
	private SanPhamHoaDonResponse sanPham; 
}