package com.clinic.appointment.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.appointment.dto.CommonResponseDto;
import com.clinic.appointment.entity.Appointment;
import com.clinic.appointment.exception.ErrorCodes;
import com.clinic.appointment.exception.MissingOrBadParameterException;
import com.clinic.appointment.repository.AppointmentRepository;
import com.clinic.appointment.util.DateUtil;
import com.clinic.appointment.util.ResponseUtil;
import com.clinic.appointment.util.ValidationUtil;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;



@Service
@Slf4j
public class AppointmentService {

	private static final Logger log = LoggerFactory.getLogger(AppointmentService.class);
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public CommonResponseDto saveAppointment(Appointment appointment) {
		ValidationUtil.validateAppointmentDate(appointment.getAppointmentDate());
		ValidationUtil.validatePatientName(appointment.getPatientName());
		try {
			appointment = appointmentRepository.save(appointment);
		} catch (Exception e) {
			return ResponseUtil.buildResponse(null, ErrorCodes.FAILD_TO_ADD_APPOINTMENT.message, e,ErrorCodes.FAILD_TO_ADD_APPOINTMENT.code);
		}
		
		return ResponseUtil.buildResponse(appointment, "success", null);
	}
	
	public CommonResponseDto getAllTodayAppointments() {
        Date sqlDateStart = DateUtil.getTodayStart();
        Date sqlDateEnd = DateUtil.getTodayEnd();
		List <Appointment> appointments = appointmentRepository.getAllTodayAppointments(sqlDateStart,sqlDateEnd);
		return ResponseUtil.buildResponse(appointments, "success", null);
		
	}
	public CommonResponseDto getDayAppointments(Date date) {
        Date sqlDateStart = DateUtil.getDayStart(date);
        Date sqlDateEnd = DateUtil.getDayEnd(date);
		List <Appointment> appointments = appointmentRepository.getDayAppointments(sqlDateStart,sqlDateEnd);
		return ResponseUtil.buildResponse(appointments, "success", null);
	}
	public CommonResponseDto getPatientAppointment(String patientName) {
		if(patientName == null || patientName.equals("")) {
			throw new MissingOrBadParameterException(ErrorCodes.REQUIRED_PATIENT_NAME.getMessage(),
					ErrorCodes.REQUIRED_PATIENT_NAME.getCode());
		}
		Date sqlDateStart = DateUtil.getTodayStart();
        Date sqlDateEnd = DateUtil.getTodayEnd();
		List <Appointment> appointments = appointmentRepository.getPatientTodayAppointments(patientName,sqlDateStart,sqlDateEnd);
		return ResponseUtil.buildResponse(appointments, "success", null);
	}
	
	public CommonResponseDto getPatientHistory(String patientName) {
		if(patientName == null || patientName.equals("")) {
			throw new MissingOrBadParameterException(ErrorCodes.REQUIRED_PATIENT_NAME.getMessage(),
					ErrorCodes.REQUIRED_PATIENT_NAME.getCode());
		}
		List <Appointment> appointments = appointmentRepository.findByPatientName(patientName);
		return ResponseUtil.buildResponse(appointments, "success", null);
		
	}
	
	public CommonResponseDto updateAppointment(Appointment appointment) {
		Appointment existingAppointment = appointmentRepository.findById(appointment.getId()).orElse(null);
		if(existingAppointment == null) {
			log.info("Appointment not found in database");
			throw new MissingOrBadParameterException(ErrorCodes.NOT_FOUNDED_APPOINTMENT.getMessage(),
					ErrorCodes.NOT_FOUNDED_APPOINTMENT.getCode());
		}
		existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
		existingAppointment.setCancellationReason(appointment.getCancellationReason());
		existingAppointment.setPatientName(appointment.getPatientName());
		return ResponseUtil.buildResponse(appointmentRepository.save(existingAppointment), "success", null);
		
	}	

}
