package com.aaseya.alps.dto;
 
import com.aaseya.alps.model.LicenseCaseDetails;
import com.aaseya.alps.model.SubSubCategory;
import com.aaseya.alps.model.ProgramDetails;
import com.aaseya.alps.model.PersonBasicDetails;
//////////to get 4 tables data on licenceID/////////////
public class CombinedResponse {
    private LicenseCaseDetails licenseCaseDetails;
    private SubSubCategory subSubCategory;
    private ProgramDetails programDetails;
    private PersonBasicDetails personBasicDetails;
    public CombinedResponse(LicenseCaseDetails licenseCaseDetails, SubSubCategory subSubCategory, ProgramDetails programDetails, PersonBasicDetails personBasicDetails) {
        this.licenseCaseDetails = licenseCaseDetails;
        this.subSubCategory = subSubCategory;
        this.programDetails = programDetails;
        this.personBasicDetails = personBasicDetails;
    }
 
	public LicenseCaseDetails getLicenseCaseDetails() {
		return licenseCaseDetails;
	}
 
	public void setLicenseCaseDetails(LicenseCaseDetails licenseCaseDetails) {
		this.licenseCaseDetails = licenseCaseDetails;
	}
 
	public SubSubCategory getSubSubCategory() {
		return subSubCategory;
	}
 
	public void setSubSubCategory(SubSubCategory subSubCategory) {
		this.subSubCategory = subSubCategory;
	}
 
	public ProgramDetails getProgramDetails() {
		return programDetails;
	}
}