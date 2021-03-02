/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 24, 2020
 */
package com.fpoly.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.server.exception.BadRequestException;
import com.fpoly.server.exception.notfoundexception.HoaDonNotFoundException;
import com.fpoly.server.repository.HoaDonChiTietRepository;
import com.fpoly.server.repository.HoaDonRepository;
import com.fpoly.server.request.dto.HoaDonChiTietRequest;
import com.fpoly.server.request.dto.HoaDonRequest;
import com.fpoly.server.response.dto.CuaHangResponse;
import com.fpoly.server.response.dto.NguoiDungResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonChiTietFinalResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonChiTietOriginResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonFinalResponse;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonOriginResponse;
import com.fpoly.server.response.dto.HoaDonResponse.SanPhamHoaDonResponse;
import com.fpoly.server.service.CuaHangService;
import com.fpoly.server.service.HoaDonService;
import com.fpoly.server.service.NguoiDungService;
import com.fpoly.server.utils.GenerateUniqueIdUtils;

@Service
public class HoaDonServiceImpl implements HoaDonService {
	
	@Autowired
	private HoaDonRepository hoaDonRepo;
	
	@Autowired
	private HoaDonChiTietRepository hdctRepo;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private CuaHangService cuaHangService;
	
	@Autowired
	private GenerateUniqueIdUtils generateUniqueId;

	@Override
	@Transactional
	public Boolean insert(HoaDonRequest hoaDonRequest) {
		try {
			hoaDonRequest.setIdHoaDon(generateUniqueId.generateRandomString(20));
			hoaDonRepo.insert(hoaDonRequest);
			for (HoaDonChiTietRequest hdctRequest : hoaDonRequest.getListHDCT()) {
				hdctRequest.setIdHoaDon(hoaDonRequest.getIdHoaDon());
				hdctRepo.insert(hdctRequest);
			}
			return true;
		} catch (Exception ex) {
			throw new BadRequestException("Bad request exception");
		}
	}
	
	@Override
	@Transactional
	public HoaDonFinalResponse findOne(String idHoaDon, String idCuaHang) {
		try {
			HoaDonOriginResponse hdOrigin = findOneOrigin(idHoaDon, idCuaHang);
			NguoiDungResponse nguoiDung = nguoiDungService.findOne(hdOrigin.getIdNguoiDung());
			CuaHangResponse cuaHang = cuaHangService.findOne(hdOrigin.getIdCuaHang());
			List<SanPhamHoaDonResponse> listSanPhamHDCT = findSanPhamInHDCT(hdOrigin.getIdHoaDon());
			List<HoaDonChiTietFinalResponse> listHDCTFinal = createListHoaDonChiTietFinal(listSanPhamHDCT, hdOrigin.getIdHoaDon());
			HoaDonFinalResponse hoaDonFinalResponse = HoaDonFinalResponse.builder()
													.setIdHoaDon(hdOrigin.getIdHoaDon())
													.setTenKhachHang(hdOrigin.getTenKhachHang())
													.setTongTien(hdOrigin.getTongTien())
													.setNguoiDung(nguoiDung)
													.setCuaHang(cuaHang)
													.setListHDCT(listHDCTFinal)
													.setCreatedAt(hdOrigin.getCreatedAt())
													.build();
			return hoaDonFinalResponse;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}
	
	@Override
	@Transactional
	public List<HoaDonFinalResponse> findByIdNguoiDung(String idNguoiDung, String idCuaHang) {
		try {
			List<HoaDonOriginResponse> listHdOrigin = hoaDonRepo.findByIdNguoiDung(idNguoiDung);
			List<HoaDonFinalResponse> listResult = new ArrayList<>();
			for (HoaDonOriginResponse hdOrigin : listHdOrigin) {
				HoaDonFinalResponse hdFinal = findOne(hdOrigin.getIdHoaDon(), idCuaHang);
				listResult.add(hdFinal);
			}
			return listResult;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}
	
	@Override
	@Transactional
	public List<HoaDonFinalResponse> findByIdCuaHang(String idCuaHang) {
		try {
			List<HoaDonOriginResponse> listHdOrigin = hoaDonRepo.findByIdCuaHang(idCuaHang);
			List<HoaDonFinalResponse> listResult = new ArrayList<>();
			for (HoaDonOriginResponse hdOrigin : listHdOrigin) {
				HoaDonFinalResponse hdFinal = findOne(hdOrigin.getIdHoaDon(), idCuaHang);
				listResult.add(hdFinal);
			}
			return listResult;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}

	@Override
	public HoaDonOriginResponse findOneOrigin(String idHoaDon, String idCuaHang) {
		try {
			return hoaDonRepo.findOne(idHoaDon, idCuaHang);
		} catch (Exception ex) {
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}

	@Override
	public List<HoaDonChiTietOriginResponse> findListHDCTByIdHoaDon(String idHoaDon) {
		try {
			return hdctRepo.findByIdHoaDon(idHoaDon);
		} catch (Exception ex) {
			throw new HoaDonNotFoundException("Hoa don not found exception");
		}
	}

	@Override
	public List<SanPhamHoaDonResponse> findSanPhamInHDCT(String idHoaDon) {
		return hdctRepo.findSanPhamInHDCT(idHoaDon);
	}
	
	private List<HoaDonChiTietFinalResponse> createListHoaDonChiTietFinal(List<SanPhamHoaDonResponse> listSanPham, String idHoaDon) {
		List<HoaDonChiTietFinalResponse> listResult = new ArrayList<>();
		for (SanPhamHoaDonResponse sp : listSanPham) {
			HoaDonChiTietFinalResponse hdctFinalResponse = HoaDonChiTietFinalResponse.builder()
															.setIdHoaDon(idHoaDon)
															.setSanPham(sp)
															.build();
			listResult.add(hdctFinalResponse);
		}
		return listResult;
	}

}