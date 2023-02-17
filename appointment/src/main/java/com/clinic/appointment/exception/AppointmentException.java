package com.clinic.appointment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clinic.appointment.dto.CommonErrorResponseDto;
import com.clinic.appointment.dto.CommonResponseDto;

@ControllerAdvice
public class AppointmentException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(MissingOrBadParameterException.class)
	public ResponseEntity<CommonResponseDto> handMissingOrBadParameterException(MissingOrBadParameterException ex) {
		CommonResponseDto commonResponseDto = new CommonResponseDto();
		commonResponseDto.setCode(ex.getCode());
		commonResponseDto.setSuccess(false);
		CommonErrorResponseDto commonErrorResponseDto = new CommonErrorResponseDto();
		commonErrorResponseDto.setErrorMessage(ex.getMessage());
		commonResponseDto.setError(commonErrorResponseDto);
		commonResponseDto.setMessage("Fail");
		commonResponseDto.setData(null);
		return ResponseEntity.ok(commonResponseDto);
	}
	
}
