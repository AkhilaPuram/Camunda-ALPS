package com.aaseya.alps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaseya.alps.dto.ALPSResponseDTO;
import com.aaseya.alps.dto.CombinedResponse;
import com.aaseya.alps.dto.DocumentIntakeDTO;
import com.aaseya.alps.dto.PersonBasicDetailsDTO;
import com.aaseya.alps.dto.ResponseDTO;
import com.aaseya.alps.dto.StartALPSRequestDTO;
import com.aaseya.alps.dto.SubSubCategoryDTO;
import com.aaseya.alps.model.DocumentIntake;
import com.aaseya.alps.model.LicenseCaseDetails;
import com.aaseya.alps.model.ProgramDetails;
import com.aaseya.alps.model.SubSubCategory;
import com.aaseya.alps.service.ALPSService;
import com.aaseya.alps.service.DocumentIntakeService;
import com.aaseya.alps.service.LicenceCaseDetailsService;
import com.aaseya.alps.service.LicenseCaseService;
import com.aaseya.alps.service.PersonBasicDetailsService;
import com.aaseya.alps.service.ProgramDetailsService;
import com.aaseya.alps.service.SaveLicenseCaseService;
import com.aaseya.alps.service.SubSubCategoryService;
import com.aaseya.alps.service.SubmitApproveService;
import com.aaseya.alps.service.SubmitReviewService;

@CrossOrigin("*")
@RestController
public class ALPSController {

	@Autowired
	private ProgramDetailsService programDetailsService;

	@Autowired
	private PersonBasicDetailsService personBasicDetailsService;

	@Autowired
	private DocumentIntakeService documentIntakeService;

	@Autowired
	private SubSubCategoryService subSubCategoryService;

	@Autowired
	private LicenseCaseService licenseCaseService;
	
	    @Autowired
		private ALPSService alpsService;
		
		@Autowired
		private SaveLicenseCaseService saveLicenseCaseService;
		
		@Autowired
		private LicenceCaseDetailsService licenceCaseDetailsService;
		
		@Autowired
		private SubmitReviewService  submitReviewService;
		
		@Autowired
		private SubmitApproveService submitApproveService;
		  

	@GetMapping("/getProgramDetails")
	public List<ProgramDetails> getProgramDetails(@RequestParam String sub_sub_category) {
		// System.out.println(sub_sub_category);
		return programDetailsService.getProgramDetailsBySubSubCategory(sub_sub_category);
	}

	@GetMapping("/subsubcategoryname/{subCategoryId}")
	public ResponseEntity<SubSubCategoryDTO> getSubSubCategoriesBySubCategoryId(@PathVariable int subCategoryId) {
		List<SubSubCategory> subSubCategories = subSubCategoryService.getSubSubCategoriesBySubCategoryId(subCategoryId);
		List<String> subsubcategoryNames = subSubCategories.stream().map(SubSubCategory::getSubsubcategory_name)
				.collect(Collectors.toList());

		SubSubCategoryDTO response = new SubSubCategoryDTO(subsubcategoryNames);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/addPersonBasicDetails")
	public ResponseDTO addBasicDetails(@RequestBody PersonBasicDetailsDTO personBasicDetailsDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			personBasicDetailsService.addBasicDetails(personBasicDetailsDTO);
			responseDTO.setStatus("Success");
			responseDTO.setMessage("Address Added");
		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus("Failure");
			responseDTO.setErrorCode("500");
			responseDTO.setErrorMessage(e.getMessage());
		}
		return responseDTO;
	}

	@PostMapping("/addDocumentIntakeData")
	public ResponseEntity<List<DocumentIntake>> addData(@RequestBody List<DocumentIntakeDTO> documentIntakeDTOs) {
	    List<DocumentIntake> documentIntakes = new ArrayList<>();
	    for (DocumentIntakeDTO dto : documentIntakeDTOs) {
	        DocumentIntake documentIntake = documentIntakeService.addData(dto);
	        documentIntakes.add(documentIntake);
	    }
	    return ResponseEntity.ok(documentIntakes);
	}
	
	
	@GetMapping("/licensecases/open/{createdBy}")
	public List<LicenseCaseDetails> getOpenLicensesByCreatedBy(@PathVariable String createdBy) {
		return licenseCaseService.getOpenLicensesByCreatedBy(createdBy);
	}
	@PostMapping("/startALPSProcess")
	public ALPSResponseDTO startALPSProcess(@RequestBody StartALPSRequestDTO startALPSRequestDTO) {
		ALPSResponseDTO startALPSResponseDTO = new ALPSResponseDTO();
		try {
			String businessKey = alpsService.startALPSProcess(startALPSRequestDTO);
			System.out.println(businessKey);
			startALPSResponseDTO.setStatus("Success");
			startALPSResponseDTO.setMessage("ALPS process started successful.");
			startALPSResponseDTO.setBusinessKey(businessKey);
			System.out.println(startALPSResponseDTO);
			// store if new entity store in database
			   saveLicenseCaseService.saveLicenseCase(startALPSRequestDTO, businessKey);
 
		}
		 catch (Exception e) {
			startALPSResponseDTO.setStatus("Failure");
			startALPSResponseDTO.setMessage("Process is not started =" + e.getMessage());
		}
		return startALPSResponseDTO;
	}
	
	@GetMapping("/pending_review")
    public List<LicenseCaseDetails> getPendingReviewCases() {
        return licenceCaseDetailsService.getPendingReviewCases();
    }
	
	@GetMapping("/getpendingapproval")
    public List<LicenseCaseDetails> getPendingApprovalCases() {
        return licenceCaseDetailsService.getPendingApprovalCases();
    }
	
	@GetMapping("/license/{licenseId}")
	public ResponseEntity<CombinedResponse> getLicenseCaseDetails(@PathVariable String licenseId) {
		CombinedResponse response = licenceCaseDetailsService.getCombinedResponse(licenseId);
		return ResponseEntity.ok(response);
	}
	@PostMapping("/submitreview/{licenseId}")
	public ResponseDTO updateLicenseStatus(@PathVariable("licenseId") String licenseId ) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			submitReviewService.updateLicenseStatus(licenseId);
			responseDTO.setStatus("Success");
			responseDTO.setMessage("Review Completed");
		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus("Failure");
			responseDTO.setErrorCode("500");
			responseDTO.setErrorMessage(e.getMessage());
		}
		return responseDTO;
	}
	
	@PostMapping("/submitApprove/{licenseId}")
	public ResponseDTO updateApproveStatus(@PathVariable("licenseId") String licenseId ) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			submitApproveService.updateApproveStatus(licenseId);
			responseDTO.setStatus("Success");
			responseDTO.setMessage("Approval Completed");
		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setStatus("Failure");
			responseDTO.setErrorCode("500");
			responseDTO.setErrorMessage(e.getMessage());
		}
		return responseDTO;
	}
	
	 @GetMapping("/getdocumentintakedetails/{licenseId}")
	 
	    public List<DocumentIntakeDTO> getDocumentsByLicenseId(@PathVariable String licenseId) {
	        return documentIntakeService.getDocumentsByLicenseId(licenseId);
	    }
}


