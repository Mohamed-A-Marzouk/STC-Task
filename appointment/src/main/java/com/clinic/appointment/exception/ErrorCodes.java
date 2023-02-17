package com.clinic.appointment.exception;

import lombok.Getter;

public enum ErrorCodes {
	NOT_FOUNDED_APPOINTMENT("1", "Not Founded Appointment"),
	REQUIRED_DATE("2", "Required patient name"),
	REQUIRED_PATIENT_NAME("3", "Required appointment date"),
	FAILD_TO_ADD_APPOINTMENT("4", "Failed To Add Appointment");
	@Getter
	public final String message;
	@Getter
	public final String code;
	private ErrorCodes(String code, String message) {
		this.message = message;
		this.code = code;
	}
	public static String getErrorMessage(String id) {
	for (ErrorCodes e : values()) {
		if (e.code .equals(id))
			return e.getMessage();
	}
	return null;
}
	
	
}
