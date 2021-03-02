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
@Table(name = "phieu_nhap_hang")
public class PhieuNhapHang implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "idPhieuNhap", unique = true, nullable = false, length = 50)
	private String idPhieuNhap;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuaHang", referencedColumnName = "idCuaHang", nullable = false)
	private CuaHang cuaHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idNguoiDung", referencedColumnName = "idNguoiDung", nullable = false)
	private NguoiDung nguoiDung;
	
	@Column(name = "ngayNhap", nullable = false)
	private Date ngayNhap;
	
	@Column(name = "tongGiaTri", nullable = false)
	private Double tongGiaTri;
	
	@Column(name = "trangThai", nullable = false, columnDefinition = "boolean default true")
	private Boolean trangThai;
}
