/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 15, 2020
 */
package com.fpoly.server.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "phieu_xuat_chi_tiet")
public class PhieuXuatChiTiet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPhieuXuat", referencedColumnName = "idPhieuXuat", nullable = false)
	private PhieuXuatHang phieuXuatHang;
	
	@Column(name = "idLoHang", nullable = false, length = 20)
	private String idLoHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idSanPham", referencedColumnName = "idSanPham", nullable = false)
	private SanPham sanPham;
	
	@Column(name = "dvt", nullable = false, length = 20)
	private String dvt;
	
	@Column(name = "soLuongXuat", nullable = false)
	private Integer soLuongXuat;
	
	@Column(name = "donGia", nullable = false)
	private Double donGia;
	
}
