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

import org.hibernate.annotations.NaturalId;

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
@Table(name = "san_pham")
public class SanPham implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="idSanPham", nullable = false, unique = true, updatable = false, length = 50)
	@NaturalId
	private String idSanPham;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuaHang", referencedColumnName = "idCuaHang", nullable = false)
	private CuaHang cuaHang;
	
	@Column(name = "tenSanPham", nullable = false, length = 255)
	private String tenSanPham;
	
	@Column(name = "maVach", length = 50)
	private String maVach;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idNhomHang", referencedColumnName = "id", nullable = false)
	private NhomHang nhomHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idDVT", referencedColumnName = "id", nullable = false)
	private DonViTinh donViTinh;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idNguoiDung", referencedColumnName = "idNguoiDung", nullable = false)
	private NguoiDung nguoiDung;
	
	@Column(name = "idLoHang", length = 20)
	private String idLoHang;
	
	@Column(name = "soLuong", nullable = false, columnDefinition = "int default 0")
	private Integer soLuong;
	
	@Column(name = "giaVon", nullable = false)
	private Double giaVon;
	
	@Column(name = "giaBan", nullable = false)
	private Double giaBan;
	
	@Column(name = "dinhMucDuoi", nullable = false)
	private Integer dinhMucDuoi;
	
	@Column(name = "dinhMucTren", nullable = false)
	private Integer dinhMucTren;
	
	@Column(name = "hinhAnh", length = 255)
	private String hinhAnh;
	
	@Column(name = "trangThai", nullable = false, columnDefinition = "1")
	private Integer trangThai;
	
}
