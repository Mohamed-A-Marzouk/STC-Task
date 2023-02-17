package com.clinic.appointment.util;



import java.util.Date;

import com.clinic.appointment.exception.ErrorCodes;
import com.clinic.appointment.exception.MissingOrBadParameterException;

public class ValidationUtil {
	
	public static void validatePatientName(String name) {
		if(name == null || name.equals("")) {
			throw new MissingOrBadParameterException(ErrorCodes.REQUIRED_PATIENT_NAME.getMessage(),
					ErrorCodes.REQUIRED_PATIENT_NAME.getCode());
		}
		
	}
	
	public static void validateAppointmentDate(Date date) {
		if(date == null ) {
			throw new MissingOrBadParameterException(ErrorCodes.REQUIRED_DATE.getMessage(),
					ErrorCodes.REQUIRED_DATE.getCode());
		}
		
	}

}
