/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 23, 2020
 */
package com.fpoly.server.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.server.exception.BadRequestException;
import com.fpoly.server.exception.notfoundexception.HoaDonNotFoundException;
import com.fpoly.server.request.dto.HoaDonRequest;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonFinalResponse;
import com.fpoly.server.service.HoaDonService;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonAPI {
	
	@Autowired
	private HoaDonService service;
	
	@GetMapping(value = "/{idHoaDon}", params = {"cuahang"})
	public ResponseEntity<?> findOne(@PathVariable("idHoaDon") String idHoaDon,
			@RequestParam("cuahang") String idCuaHang) {
		try {
			HoaDonFinalResponse response = service.findOne(idHoaDon, idCuaHang);
			return ResponseEntity.ok(response);
		} catch (HoaDonNotFoundException ex) {
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}
	
	@GetMapping(value = "/find", params = {"nguoidung", "cuahang"})
	public ResponseEntity<?> findByIdNguoiDung(@RequestParam("nguoidung") String idNguoiDung, 
			@RequestParam("cuahang") String idCuaHang) {
		try {
			List<HoaDonFinalResponse> response = service.findByIdNguoiDung(idNguoiDung, idCuaHang);
			return ResponseEntity.ok(response);
		} catch (HoaDonNotFoundException ex) {
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}
	
	@GetMapping(value = "/find", params = {"cuahang"})
	public ResponseEntity<?> findByIdCuaHang(@RequestParam("cuahang") String idCuaHang) {
		try {
			List<HoaDonFinalResponse> response = service.findByIdCuaHang(idCuaHang);
			return ResponseEntity.ok(response);
		} catch (HoaDonNotFoundException ex) {
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> insertHoaDon(@RequestBody HoaDonRequest hoaDonRequest) {
		try {
			Boolean response = service.insert(hoaDonRequest);
			return ResponseEntity.ok(response);
		} catch (BadRequestException ex) {
			throw new BadRequestException("Bad request exception");
		}
	}
}
