/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 15, 2020
 */
package com.fpoly.server.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "phieu_nhap_chi_tiet")
public class PhieuNhapChiTiet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idPhieuNhap", referencedColumnName = "idPhieuNhap", nullable = false)
	private PhieuNhapHang phieuNhapHang;
	
	@Column(name = "idLoHang", unique = true, nullable = false, length = 20)
	private String idLoHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idSanPham", referencedColumnName = "idSanPham", nullable = false)
	private SanPham sanPham;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idNhaCungCap", referencedColumnName = "id", nullable = false)
	private NhaCungCap nhaCungCap;
	
	@Column(name = "giaNhap", nullable = false)
	private Double giaNhap;
	
	@Column(name = "dvt", nullable = false, length = 20)
	private String dvt;
	
	@Column(name = "soLuongNhap", nullable = false)
	private Integer soLuongNhap;
	
	@Column(name = "hsd", nullable = false)
	private Date hsd;

}
