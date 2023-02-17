package com.clinic.appointment.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "patient_name", nullable = false)
	@NotBlank(message = "The patient name can not be empty or null.")
	private String patientName;
	
	@Column(name = "appointment_date", nullable = false)
	@NotBlank(message = "The patient name can not be empty or null.")
	private Date appointmentDate;
	
	@Column(name = "cancellation_reason")
	private String cancellationReason;
	
}
