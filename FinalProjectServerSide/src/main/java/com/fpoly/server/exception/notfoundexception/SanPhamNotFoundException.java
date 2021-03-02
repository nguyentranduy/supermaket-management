/*
 * (C) Copyright 2020 Fresher Academy. All Rights Reserved.
 * 
 * @author HoangMH1
 * @date Oct 8, 2020
 * @version 1.0
 */
package com.fpoly.server.exception.notfoundexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SanPhamNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SanPhamNotFoundException(String message) {
		super(message);
	}
}
