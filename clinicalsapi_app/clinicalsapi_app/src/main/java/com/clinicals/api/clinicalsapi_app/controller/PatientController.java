package com.clinicals.api.clinicalsapi_app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinicals.api.clinicalsapi_app.models.ClinicalData;
import com.clinicals.api.clinicalsapi_app.models.Patient;
import com.clinicals.api.clinicalsapi_app.repos.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	Map<String,String> filters=new HashMap();
	
	//http://localhost:8080/clinicalservices/api/allpatients
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/allpatients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	//http://localhost:8080/clinicalservices/api/patients/3
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable ("id") Long id){
		return patientRepository.findById(id).get();
	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/savepatients")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable("id") Long id) {
		Patient patient=patientRepository.findById(id).get();
		List<ClinicalData> clinicalData=patient.getCd();
		List<ClinicalData> duplicateClinicalData=new ArrayList<>(clinicalData);
		for(ClinicalData eachEntry:duplicateClinicalData) {
			if(filters.containsKey(eachEntry.getComponentname())) {
				clinicalData.remove(eachEntry);
			}else {
				filters.put(eachEntry.getComponentname(), null);
			}
			if(eachEntry.getComponentname().equals("hw")) {
				String[] heightAndWeight=eachEntry.getComponentvalue().split("/");
				if(heightAndWeight != null && heightAndWeight.length>1) {
					float heightInMeters=Float.parseFloat(heightAndWeight[0])*0.4536F;
					float bmi=Float.parseFloat(heightAndWeight[1])/(heightInMeters*heightInMeters);
					ClinicalData bmiData=new ClinicalData();
					bmiData.setComponentname("bmi");
					bmiData.setComponentvalue(Float.toString(bmi));
					clinicalData.add(bmiData);
				}
			}
		}	
		filters.clear();//If we do not include this for second time we will get error
		return patient;
	}
}
