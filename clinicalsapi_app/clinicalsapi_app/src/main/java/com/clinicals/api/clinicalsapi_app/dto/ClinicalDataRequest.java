package com.clinicals.api.clinicalsapi_app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ClinicalDataRequest {
  
	private Long id;
	@Column(name="component_name")
	private String componentname;
	@Column(name="component_value")
	private String componentvalue;
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
	@Override
	public String toString() {
		return "ClinicalDataRequest [id=" + id + ", componentname=" + componentname + ", componentvalue="
				+ componentvalue + "]";
	}
	
	
}
