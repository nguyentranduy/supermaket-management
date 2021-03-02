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
@Table(name = "nha_cung_cap")
public class NhaCungCap implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuaHang", referencedColumnName = "idCuaHang", nullable = false)
	private CuaHang cuaHang;
	
	@Column(name = "tenNCC", nullable = false, length = 50)
	private String tenNCC;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
		
	@Column(name = "dienThoai", nullable = false, length = 11)
	private String dienThoai;
	
	@Column(name = "diaChi", nullable = false, length = 255)
	private String diaChi;
	
	@Column(name = "moTa", nullable = false, length = 255)
	private String moTa;
	
	@Column(name = "trangThai", nullable = false, columnDefinition = "boolean default true")
	private Boolean trangThai;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "createdBy", length = 20)
	private String createdBy;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private Date updatedAt;
	
	@Column(name = "updatedBy", length = 20)
	private String updatedBy;
	

}
