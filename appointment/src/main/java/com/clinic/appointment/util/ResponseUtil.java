package com.clinic.appointment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clinic.appointment.dto.CommonErrorResponseDto;
import com.clinic.appointment.dto.CommonResponseDto;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ResponseUtil {
	private static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);
	public static CommonResponseDto buildResponse(Object... params) {
		log.info("entering buildResponse");
		CommonResponseDto commonResponseRepresentation = new CommonResponseDto();
		commonResponseRepresentation.setData(params[0]);
		commonResponseRepresentation.setMessage(params[1].toString());
		if (params[2] != null && !params[2].toString().isEmpty()) {
			String errorMessage = params[2].toString();
			CommonErrorResponseDto commonErrorResponseDto = new CommonErrorResponseDto();
			commonErrorResponseDto.setErrorMessage(errorMessage);
			commonResponseRepresentation.setError(commonErrorResponseDto);
			commonResponseRepresentation.setCode(params[3].toString());
			commonResponseRepresentation.setSuccess(false);
		} else {
			commonResponseRepresentation.setCode("200");
			commonResponseRepresentation.setSuccess(true);
			commonResponseRepresentation.setError(null);
		}

		log.info("exiting buildResponse");
		return commonResponseRepresentation;
	}

}
