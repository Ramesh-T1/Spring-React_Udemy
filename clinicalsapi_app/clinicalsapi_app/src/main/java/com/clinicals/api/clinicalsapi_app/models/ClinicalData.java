package com.clinicals.api.clinicalsapi_app.models;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clinicaldata")
@JsonIgnoreProperties({"patient"})
public class ClinicalData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="component_name")
	private String componentname;
	@Column(name="component_value")
	private String componentvalue;
	@Column(name="measured_date_time")
	private Timestamp manufacturedDateTime;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComponentname() {
		return componentname;
	}
	public void setComponentname(String componentname) {
		this.componentname = componentname;
	}
	public String getComponentvalue() {
		return componentvalue;
	}
	public void setComponentvalue(String componentvalue) {
		this.componentvalue = componentvalue;
	}
	public Timestamp getManufacturedDateTime() {
		return manufacturedDateTime;
	}
	public void setManufacturedDateTime(Timestamp manufacturedDateTime) {
		this.manufacturedDateTime = manufacturedDateTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "ClinicalData [id=" + id + ", componentname=" + componentname + ", componentvalue=" + componentvalue
				+ ", manufacturedDateTime=" + manufacturedDateTime + ", patient=" + patient + "]";
	}
	
}
