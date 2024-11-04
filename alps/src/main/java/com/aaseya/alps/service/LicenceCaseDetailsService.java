package com.aaseya.alps.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.aaseya.alps.dao.LicenceCaseDetailsDAO;
import com.aaseya.alps.dao.LicenseCaseDAO;
import com.aaseya.alps.dao.PersonBasicDetailsDAO;
import com.aaseya.alps.dao.ProgramDetailsDAO;
import com.aaseya.alps.dao.SubSubCategoryDAO;
import com.aaseya.alps.dto.CombinedResponse;
//import com.aaseya.alps.dto.CombinedResponse;
import com.aaseya.alps.model.LicenseCaseDetails;
import com.aaseya.alps.model.PersonBasicDetails;
import com.aaseya.alps.model.ProgramDetails;
import com.aaseya.alps.model.SubSubCategory;
 
@Service
public class LicenceCaseDetailsService {
 
	@Autowired
	private LicenceCaseDetailsDAO licenceCaseDetailsDAO;
	
	@Autowired
	private LicenseCaseDAO licenseCaseDAO;
	
	
 
    @Autowired
    private SubSubCategoryDAO subSubCategoryDAO;
 
    @Autowired
    private ProgramDetailsDAO programDetailsDAO;
 
    @Autowired
    private PersonBasicDetailsDAO personBasicDetailsDAO;
 
    @Transactional
    public List<LicenseCaseDetails> getPendingReviewCases() {
        return licenceCaseDetailsDAO.getPendingReviewCases();
    }
    
    public List<LicenseCaseDetails> getPendingApprovalCases() {
        return licenceCaseDetailsDAO.getPendingApprovalCases();
    }
//////////to get 4 tables data on licenceID/////////////
@Transactional
public CombinedResponse getCombinedResponse(String licenseId) {
  LicenseCaseDetails licenseCaseDetails = licenceCaseDetailsDAO.getLicenseCaseDetailsById(licenseId);
  if (licenseCaseDetails == null) {
      return null;
  }

  SubSubCategory subSubCategory = subSubCategoryDAO.getSubSubCategoryById(licenseCaseDetails.getSubsubcategory());
  ProgramDetails programDetails = programDetailsDAO.getProgramDetailsBySubSubCategoryId(licenseCaseDetails.getSubsubcategory());
  PersonBasicDetails personBasicDetails = personBasicDetailsDAO.getPersonBasicDetailsByLicenseId(licenseId);

  return new CombinedResponse(licenseCaseDetails, subSubCategory, programDetails, personBasicDetails);
}
//////////to get 4 tables data on licenceID/////////////
}