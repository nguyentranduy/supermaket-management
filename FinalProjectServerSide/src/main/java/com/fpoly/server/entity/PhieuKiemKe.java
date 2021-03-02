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
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "phieu_kiem_ke")
public class PhieuKiemKe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "idPhieuKiem", unique = true, nullable = false, length = 50)
	private String idPhieuKiem;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuaHang", referencedColumnName = "idCuaHang", nullable = false)
	private CuaHang cuaHang;

	@Column(name = "loaiPhieuKiem", nullable = false)
	private Boolean loaiPhieuKiem;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@Column(name = "giaTriLech", nullable = false)
	private Double giaTriLech;
	
	@Column(name = "ghiChu", nullable = false, length = 50)
	private String ghiChu;
	
	@Column(name = "ngayCanBang")
	private Date ngayCanBang;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp	
	private Date updatedAt;
	
	@Column(name = "updatedBy", length = 20)
	private String updatedBy;
	
	@Column(name = "trangThai", nullable = false)
	private Boolean trangThai;
		
}
