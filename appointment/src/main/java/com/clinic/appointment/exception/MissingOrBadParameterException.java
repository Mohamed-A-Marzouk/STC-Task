package com.clinic.appointment.exception;

import lombok.Getter;

public class MissingOrBadParameterException extends RuntimeException {
	@Getter
	private final String code;

	public MissingOrBadParameterException(String message, String code) {
		super(message);
		this.code = code;
	}

}
