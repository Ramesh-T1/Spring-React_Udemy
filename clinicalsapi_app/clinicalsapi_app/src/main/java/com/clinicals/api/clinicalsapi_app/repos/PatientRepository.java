package com.clinicals.api.clinicalsapi_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicals.api.clinicalsapi_app.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
