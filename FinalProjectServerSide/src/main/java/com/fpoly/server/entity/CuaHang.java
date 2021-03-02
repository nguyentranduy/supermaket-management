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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
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
@Table(name = "cua_hang")
public class CuaHang implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="idCuaHang", nullable = false, unique = true, updatable = false, length = 20)
	@NaturalId
	private String idCuaHang;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idNguoiDung", referencedColumnName = "idNguoiDung", nullable = false)
	private NguoiDung nguoiDung;
	
	@Column(name = "tenCuaHang", nullable = false, length = 50)
	private String tenCuaHang;
	
	@Column(name = "diaChi", nullable = false, length = 100)
	private String diaChi;
	
	@Column(name = "ngayDangKy", nullable = false)
	@CreationTimestamp
	private Date ngayDangKy;
	
	@Column(name = "trangThai", nullable = false, columnDefinition = "boolean default true")
	private Boolean trangThai;
	
	@Column(name = "updatedBy", length = 20)
	private String updatedBy;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private Date updatedAt;

}
