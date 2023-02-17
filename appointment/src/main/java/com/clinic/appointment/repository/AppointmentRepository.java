package com.clinic.appointment.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinic.appointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByPatientName(String patientName);
	
	@Query(value = "SELECT app FROM Appointment app WHERE app.appointmentDate >=:startDate AND app.appointmentDate <=:endDate ")
	List<Appointment> getAllTodayAppointments(Date startDate, Date endDate);
	
	@Query(value = "SELECT app FROM Appointment app WHERE app.patientName like %:patientName% AND app.appointmentDate >=:startDate AND app.appointmentDate <=:endDate ")
	List<Appointment> getPatientTodayAppointments(String patientName, Date startDate, Date endDate);
	
	@Query(value = "SELECT app FROM Appointment app WHERE app.appointmentDate >=:startDate AND app.appointmentDate <=:endDate ")
	List<Appointment> getDayAppointments(Date startDate, Date endDate);

	

}
