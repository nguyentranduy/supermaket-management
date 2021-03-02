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

import com.fpoly.server.entity.HoaDonChiTiet;
import com.fpoly.server.request.dto.HoaDonChiTietRequest;
import com.fpoly.server.response.dto.HoaDonResponse.HoaDonChiTietOriginResponse;
import com.fpoly.server.response.dto.HoaDonResponse.SanPhamHoaDonResponse;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "INSERT INTO hoa_don_chi_tiet(idHoaDon, idLoHang, idSanPham,"
			+ " soLuong, giaBan)"
			+ " VALUES(:#{#hdct.idHoaDon}, :#{#hdct.sanPham.idLoHang},"
			+ " :#{#hdct.sanPham.idSanPham}, :#{#hdct.sanPham.soLuong},"
			+ " :#{#hdct.sanPham.giaBan})", nativeQuery = true)
	void insert(@Param("hdct") HoaDonChiTietRequest hdct);
	
	@Query(value = "SELECT idHoaDon, idLoHang, idSanPham, soLuong, giaBan"
			+ " FROM hoa_don_chi_tiet WHERE idHoaDon = ?1", nativeQuery = true)
	List<HoaDonChiTietOriginResponse> findByIdHoaDon(String idHoaDon);
	
	@Query(value = "SELECT hdct.idSanPham, sp.idCuaHang, sp.tenSanPham, sp.maVach,"
			+ " sp.idNhomHang, sp.idDVT, hdct.idLoHang, hdct.soLuong, hdct.giaBan"
			+ " FROM san_pham sp INNER JOIN hoa_don_chi_tiet hdct"
			+ " ON sp.idSanPham = hdct.idSanPham"
			+ " WHERE hdct.idHoaDon = ?1", nativeQuery = true)
	List<SanPhamHoaDonResponse> findSanPhamInHDCT(String idHoaDon);

}