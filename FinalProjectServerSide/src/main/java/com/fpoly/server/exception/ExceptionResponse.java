/*
 * (C) Copyright 2020 Fresher Academy. All Rights Reserved.
 * 
 * @author HoangMH1
 * @date Oct 8, 2020
 * @version 1.0
 */
package com.fpoly.server.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse  {
	private Date timestamp;
	private String message;
	private String details;
}
