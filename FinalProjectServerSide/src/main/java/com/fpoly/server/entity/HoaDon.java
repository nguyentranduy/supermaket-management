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

import org.hibernate.annotations.CreationTimestamp;
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
@Table(name = "hoa_don")
public class HoaDon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="idHoaDon", nullable = false, unique = true, updatable = false, length = 50)
	@NaturalId
	private String idHoaDon;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuaHang", referencedColumnName = "idCuaHang", nullable = false)
	private CuaHang cuaHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idNguoiDung", referencedColumnName = "idNguoiDung", nullable = false)
	private NguoiDung nguoiDung;
	
	@Column(name = "tenKhachHang", nullable = false, length = 100)
	private String tenKhachHang;
	
	@Column(name = "tongTien", nullable = false)
	private Double tongTien;
	
	@Column(name = "createdAt")
	@CreationTimestamp	
	private Date createdAt;
	
}
