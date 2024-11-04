package com.aaseya.alps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaseya.alps.dao.SaveLicenseCaseDAO;
import com.aaseya.alps.dto.StartALPSRequestDTO;
import com.aaseya.alps.model.LicenseCaseDetails;

@Service

public class SaveLicenseCaseService {

	@Autowired
	private SaveLicenseCaseDAO saveLicenseCaseDAO;

	public boolean saveLicenseCase(StartALPSRequestDTO startALPSRequestDTO, final String businessKey) {
		if (startALPSRequestDTO == null) {
			throw new IllegalArgumentException("startALPSRequestDTO cannot be null");
		}
		LicenseCaseDetails licenseCaseDetails = mapToLicenseCase(startALPSRequestDTO);
		licenseCaseDetails.setLicense_Id(businessKey);
		licenseCaseDetails.setStatus("new");
		try {
			// Ensure license_id is not overridden before saving
			System.out.println("Before saving: " + licenseCaseDetails);
			saveLicenseCaseDAO.saveLicenseCase(licenseCaseDetails);
			System.out.println("After saving: " + licenseCaseDetails.getLicense_Id());
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to save license case", e);
		}
	}

	private LicenseCaseDetails mapToLicenseCase(StartALPSRequestDTO startALPSRequestDTO) {
		LicenseCaseDetails licenseCaseDetails = new LicenseCaseDetails();
		licenseCaseDetails.setApplicantId(startALPSRequestDTO.getApplicantId());
		licenseCaseDetails.setCategory(startALPSRequestDTO.getCategory());
		licenseCaseDetails.setSubcategory(startALPSRequestDTO.getSubcategory());
		licenseCaseDetails.setSubsubcategory(startALPSRequestDTO.getSubsubcategory());
		licenseCaseDetails.setCreatedBy(startALPSRequestDTO.getCreatedBy());
		return licenseCaseDetails;
	}
}
