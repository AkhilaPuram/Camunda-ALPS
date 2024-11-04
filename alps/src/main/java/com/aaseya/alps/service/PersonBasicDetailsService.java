package com.aaseya.alps.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaseya.alps.dao.LicenseCaseIdDAO;
import com.aaseya.alps.dao.PersonBasicDetailsDAO;
import com.aaseya.alps.dto.PersonBasicDetailsDTO;
import com.aaseya.alps.model.LicenseCaseDetails;
import com.aaseya.alps.model.PersonBasicDetails;

import jakarta.transaction.Transactional;

@Service
public class PersonBasicDetailsService {
	@Autowired
	private PersonBasicDetailsDAO personBasicDetailsDAO;

	@Autowired
	private LicenseCaseIdDAO licenseCaseIdDAO;

	@Autowired
	private TaskListService taskListService;

	@Transactional
	public void addBasicDetails(PersonBasicDetailsDTO personBasicDetailsDTO) {
		PersonBasicDetails personbasicdetails = new PersonBasicDetails();
		personbasicdetails.setFirst_name(personBasicDetailsDTO.getFirst_name());
		personbasicdetails.setLast_name(personBasicDetailsDTO.getLast_name());
		personbasicdetails.setMiddle_name(personBasicDetailsDTO.getMiddle_name());
		personbasicdetails.setEmail_id(personBasicDetailsDTO.getEmail_id());
		personbasicdetails.setPhone_number(personBasicDetailsDTO.getPhone_number());
		personbasicdetails.setDate_of_birth(personBasicDetailsDTO.getDate_of_birth());
		personbasicdetails.setCountry(personBasicDetailsDTO.getCountry());
		personbasicdetails.setAddress_line1(personBasicDetailsDTO.getAddress_line1());
		personbasicdetails.setAddress_line2(personBasicDetailsDTO.getAddress_line2());
		personbasicdetails.setCity(personBasicDetailsDTO.getCity());
		personbasicdetails.setState(personBasicDetailsDTO.getState());
		personbasicdetails.setPostal_code(personBasicDetailsDTO.getPostal_code());
		personbasicdetails.setApproved_hunting_organization(personBasicDetailsDTO.getApproved_hunting_organization());
		personbasicdetails.setRlicense_accreditation_number(personBasicDetailsDTO.getRlicense_accreditation_number());
		personbasicdetails.setTrainer_number(personBasicDetailsDTO.getTrainer_number());
		personbasicdetails.setWaterfowl_identification_test_number(
				personBasicDetailsDTO.getWaterfowl_identification_test_number());
		personbasicdetails.setLicense_id(personBasicDetailsDTO.getLicense_id());
		//personBasicDetailsDAO.saveAddressInfo(personbasicdetails);
		if (personBasicDetailsDTO.getAction().equalsIgnoreCase("save")) {
			LicenseCaseDetails licenseCaseDetails = licenseCaseIdDAO
					.getLicenseCaseById(personBasicDetailsDTO.getLicense_id());
			licenseCaseDetails.setStatus("open");
			System.out.println(licenseCaseDetails);
			personBasicDetailsDAO.saveAddressInfo(personbasicdetails);
			licenseCaseIdDAO.updateLicenseCaseDetails(licenseCaseDetails);

		} else {

			LicenseCaseDetails licenseCaseDetails = licenseCaseIdDAO
					.getLicenseCaseById(personBasicDetailsDTO.getLicense_id());
			licenseCaseDetails.setStatus("pending_review");
			licenseCaseIdDAO.updateLicenseCaseDetails(licenseCaseDetails);
			String taskId = taskListService.getActiveTaskID(personBasicDetailsDTO.getLicense_id().substring(4));
			taskListService.CompleteTaskByID(taskId, new HashMap<String, Object>() {
				{
					put("application submitted", "true");
				}
			});
		}
		System.out.println(personbasicdetails.toString());
		

	}
}
