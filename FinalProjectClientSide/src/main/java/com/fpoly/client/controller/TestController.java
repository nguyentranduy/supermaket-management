/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.client.exception.NotFoundException;
import com.fpoly.client.model.response.SanPhamResponse;
import com.fpoly.client.service.SanPhamService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("/{idsanpham}")
	public ResponseEntity<?> findOne(@PathVariable("idsanpham") String idSanPham,
			@RequestParam("cuahang") String idCuaHang) {
		try {
			SanPhamResponse response = sanPhamService.findOne(idSanPham, idCuaHang);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			throw new NotFoundException("San pham not found");
		}
	}

}
