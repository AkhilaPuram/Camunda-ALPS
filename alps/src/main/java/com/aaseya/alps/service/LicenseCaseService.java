package com.aaseya.alps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaseya.alps.dao.LicenseCaseDAO;
import com.aaseya.alps.model.LicenseCaseDetails;

@Service
public class LicenseCaseService {

	@Autowired
	private LicenseCaseDAO licenseCaseDAO;

	public List<LicenseCaseDetails> getOpenLicensesByCreatedBy(String createdBy) {
		// TODO Auto-generated method stub
		return licenseCaseDAO.findOpenLicensesByCreatedBy(createdBy);
	}

}
