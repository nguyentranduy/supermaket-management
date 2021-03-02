/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 26, 2020
 */
package com.fpoly.server.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.server.exception.notfoundexception.CuaHangNotFoundException;
import com.fpoly.server.response.dto.CuaHangResponse;
import com.fpoly.server.service.CuaHangService;

@RestController
@RequestMapping("/api/cuahang")
public class CuaHangAPI {
	
	@Autowired
	private CuaHangService service;

	@GetMapping(value = "/{idCuaHang}")
	public ResponseEntity<?> findOne(@PathVariable("idCuaHang") String idCuaHang) {
		try {
			CuaHangResponse response = service.findOne(idCuaHang);
			return ResponseEntity.ok(response);
		} catch (CuaHangNotFoundException ex) {
			throw new CuaHangNotFoundException("Cua hang not found exception");
		}
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<?> findListAll() {
		try {
			List<CuaHangResponse> response = service.findListAll();
			return ResponseEntity.ok(response);
		} catch (CuaHangNotFoundException ex) {
			throw new CuaHangNotFoundException("Cua hang not found exception");
		}
	}
	
	@GetMapping(value = "/find", params = {"nguoidung"})
	public ResponseEntity<?> findByIdNguoiDung(@RequestParam("nguoidung") String idNguoiDung) {
		try {
			CuaHangResponse response = service.findByIdNguoiDung(idNguoiDung);
			return ResponseEntity.ok(response);
		} catch (CuaHangNotFoundException ex) {
			throw new CuaHangNotFoundException("Cua hang not found exception");
		}
	}
	
	@GetMapping(value = "/find", params = {"tencuahang"})
	public ResponseEntity<?> findByTenCuaHang(@RequestParam("tencuahang") String tenCuaHang) {
		try {
			List<CuaHangResponse> response = service.findByTenCuaHang(tenCuaHang);
			return ResponseEntity.ok(response);
		} catch (CuaHangNotFoundException ex) {
			throw new CuaHangNotFoundException("Cua hang not found exception");
		}
	}
}
