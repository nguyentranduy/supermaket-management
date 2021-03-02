/*
 *	(C) Copyright 2020. All rights reserved.
 *	@author duyntps09687
 *	@date Nov 15, 2020 
 */

package com.fpoly.server.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "nguoi_dung")
public class NguoiDung implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="idNguoiDung", nullable = false, unique = true, updatable = false, length = 20)
	@NaturalId
	private String idNguoiDung;
	
	@Column(name = "idCuaHang", length = 20)
	private String idCuaHang;
	
	@Column(name = "userName", unique = true, nullable = false, length = 20)
	private String userName;
	
	@Column(name = "hoTen", nullable = false, length = 50)
	private String hoTen;
	
	@Column(name = "hashPassword", nullable = false, length = 120)
	private String hashPassword;
	
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email; 
	
	@Column(name = "dienThoai", unique = true, nullable = false, length = 11)
	private String dienThoai;
	
	@Column(name = "ngayDangKy", nullable = false)
	@CreationTimestamp
	private Date ngayDangKy;
	
	@Column(name = "lastLogin", nullable = false)
	@UpdateTimestamp
	private Date lastLogin;
	
	@Column(name = "idQuanLy", length = 20)
	private String idQuanLy;
	
	@Column(name = "vaiTro", nullable = false)
	private Integer vaiTro;
	
	@Column(name = "hinhAnh", length = 255)
	private String hinhAnh;
	
	@Column(name = "trangThaiKichHoat", nullable = false, columnDefinition = "boolean default false")
	private Boolean trangThaiKichHoat;
	
	@Column(name = "trangThaiHoatDong", nullable = false, columnDefinition = "boolean default false")
	private Boolean trangThaiHoatDong;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp	
	private Date updatedAt;
	
	@Column(name = "updatedBy", length = 20)
	private String updatedBy;

}
