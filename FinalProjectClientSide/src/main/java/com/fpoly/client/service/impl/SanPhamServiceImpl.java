/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.client.constant.path.sanpham.SanPham;
import com.fpoly.client.model.response.SanPhamResponse;
import com.fpoly.client.service.SanPhamService;
import com.fpoly.client.utils.RestTemplateUtils;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	
	@Autowired
	RestTemplateUtils restTemplate;

	@Override
	public SanPhamResponse findOne(String idSanPham, String idCuaHang) {
		return restTemplate.getForEntity(SanPhamResponse.class, SanPham.FIND_ONE, idSanPham, idCuaHang);
	}

	@Override
	public SanPhamResponse findByMaVach(String idCuaHang, String maVach) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPhamResponse> findByIdCuaHang(String idCuaHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPhamResponse> findByNhomHang(String idCuahang, String idNhomHang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPhamResponse> findByTenSanPham(String idCuaHang, String tenSanPhan) {
		// TODO Auto-generated method stub
		return null;
	}

}
