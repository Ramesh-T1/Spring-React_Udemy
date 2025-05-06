package com.clinicals.api.clinicalsapi_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicals.api.clinicalsapi_app.models.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {

}
