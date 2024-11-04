package com.aaseya.alps.service;
 
import java.util.HashMap;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.aaseya.alps.dao.LicenseCaseIdDAO;
import com.aaseya.alps.dao.PersonBasicDetailsDAO;
import com.aaseya.alps.dto.PersonBasicDetailsDTO;
import com.aaseya.alps.dto.LicenseCaseDTO;
import com.aaseya.alps.model.LicenseCaseDetails;
import com.aaseya.alps.model.PersonBasicDetails;
 
import jakarta.transaction.Transactional;
 
@Service
public class SubmitReviewService {
	@Autowired
	private PersonBasicDetailsDAO personBasicDetailsDAO;
	
	
 
	@Autowired
	private LicenseCaseIdDAO licenseCaseIdDAO;
 
	@Autowired
	private TaskListService taskListService;
 
	@Transactional
	public void updateLicenseStatus(String licenseId) {
		PersonBasicDetails personbasicdetails =new PersonBasicDetails();
		LicenseCaseDetails licenseCaseDetails = licenseCaseIdDAO
				.getLicenseCaseById(licenseId);
		licenseCaseDetails.setStatus("pending_approval");
		licenseCaseIdDAO.updateLicenseCaseDetails(licenseCaseDetails);
		String taskId = taskListService.getActiveTaskID(licenseId.substring(4));
		taskListService.CompleteTaskByID(taskId, new HashMap<String, Object>() {
			{
				put("reviewStatus", true);
			}
		});
 
	}
}
