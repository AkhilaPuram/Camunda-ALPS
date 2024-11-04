package com.aaseya.alps.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaseya.alps.dao.DocumentIntakeDAO;
import com.aaseya.alps.dao.LicenseCaseIdDAO;
import com.aaseya.alps.dto.DocumentIntakeDTO;
import com.aaseya.alps.model.DocumentIntake;
import com.aaseya.alps.model.LicenseCaseDetails;

import jakarta.transaction.Transactional;

@Service
public class DocumentIntakeService {

	@Autowired
	private DocumentIntakeDAO documentIntakeDAO;
	@Autowired
	private LicenseCaseIdDAO licenseCaseIdDAO;

	@Transactional
	public DocumentIntake addData(DocumentIntakeDTO documentIntakeDTO) {
		DocumentIntake documentinfo = new DocumentIntake();
		documentinfo.setDocument_id(documentIntakeDTO.getDocument_id());
		documentinfo.setDocument_type(documentIntakeDTO.getDocument_type());
		documentinfo.setName(documentIntakeDTO.getName());
		documentinfo.setContent(documentIntakeDTO.getContent());
		System.out.println(documentIntakeDTO);
		LicenseCaseDetails licenseCaseDetails = licenseCaseIdDAO.getLicenseCaseById(documentIntakeDTO.getLicense_id());
		documentinfo.setLicenseCaseDetails(licenseCaseDetails);

		System.out.println(documentinfo.toString());
		documentIntakeDAO.saveData(documentinfo);
		return documentinfo;

	}
	 public List<DocumentIntakeDTO> getDocumentsByLicenseId(String license_Id) {
	        List<DocumentIntake> documents = documentIntakeDAO.findByLicenseId(license_Id);

	        // Convert to DTO
	        return documents.stream().map(document -> {
	            DocumentIntakeDTO dto = new DocumentIntakeDTO();
	            dto.setDocument_id(document.getDocument_id());
	            dto.setDocument_type(document.getDocument_type());
	            dto.setName(document.getName());
	            dto.setContent(document.getContent());
	            return dto;
	        }).collect(Collectors.toList());
	    }
}
