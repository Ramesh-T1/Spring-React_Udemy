package com.clinicals.api.clinicalsapi_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicals.api.clinicalsapi_app.dto.ClinicalDataRequest;
import com.clinicals.api.clinicalsapi_app.models.ClinicalData;
import com.clinicals.api.clinicalsapi_app.models.Patient;
import com.clinicals.api.clinicalsapi_app.repos.ClinicalDataRepository;
import com.clinicals.api.clinicalsapi_app.repos.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClinicalDataController {
   @Autowired
   PatientRepository patientRepository;
   @Autowired
   ClinicalDataRepository clinicalDataRepository;
   
   //@CrossOrigin(origins = "http://localhost:3000")
   @PostMapping("/saveClinicalData")
   public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest cdr) {
	   Patient p=patientRepository.findById(cdr.getId()).get();
	   ClinicalData cd=new ClinicalData();
	   cd.setComponentname(cdr.getComponentname());
	   cd.setComponentvalue(cdr.getComponentvalue());
	   cd.setId(cdr.getId());
	   return clinicalDataRepository.save(cd);
   }
}
