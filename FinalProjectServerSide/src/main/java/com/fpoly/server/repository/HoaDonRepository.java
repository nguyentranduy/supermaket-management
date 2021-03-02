/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 23, 2020
 */
package com.fpoly.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fpoly.server.entity.HoaDon;
import com.fpoly.server.request.dto.HoaDonRequest;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonOriginResponse;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "INSERT INTO hoa_don(idHoaDon, idCuaHang, idNguoiDung,"
			+ " tenKhachHang, tongTien)"
			+ " VALUES(:#{#hd.idHoaDon}, :#{#hd.idCuaHang}, :#{#hd.idNguoiDung},"
			+ " :#{#hd.tenKhachHang}, :#{#hd.tongTien})", nativeQuery = true)
	void insert(@Param("hd") HoaDonRequest hd);
	
	@Query(value = "SELECT hd.idHoaDon, hd.idCuaHang, hd.idNguoiDung, hd.tenKhachHang,"
			+ " hd.tongTien, hd.createdAt"
			+ " FROM hoa_don hd WHERE hd.idHoaDon = ?1 AND hd.idCuaHang = ?2", nativeQuery = true)
	HoaDonOriginResponse findOne(String idHoaDon, String idCuaHang);
	
	@Query(value = "SELECT hd.idHoaDon, hd.idCuaHang, hd.idNguoiDung, hd.tenKhachHang,"
			+ " hd.tongTien, hd.createdAt"
			+ " FROM hoa_don hd WHERE hd.idNguoiDung = ?1", nativeQuery = true)
	List<HoaDonOriginResponse> findByIdNguoiDung(String idNguoiDung);
	
	@Query(value = "SELECT hd.idHoaDon, hd.idCuaHang, hd.idNguoiDung, hd.tenKhachHang,"
			+ " hd.tongTien, hd.createdAt"
			+ " FROM hoa_don hd WHERE hd.idCuaHang = ?1", nativeQuery = true)
	List<HoaDonOriginResponse> findByIdCuaHang(String idCuaHang);
}