package com.aaseya.alps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaseya.alps.dao.SubSubCategoryDAO;
import com.aaseya.alps.model.SubSubCategory;

@Service
public class SubSubCategoryService {

	@Autowired
	private SubSubCategoryDAO subSubCategoryDAO;

//    public List<SubSubCategory> getSubSubCategoryById(String subcategory_id) {
//    	System.out.println("Hello");
//        return subSubCategoryDAO.getSubSubCategoryById(subcategory_id);
//    }
	public List<SubSubCategory> getSubSubCategoriesBySubCategoryId(int subCategoryId) {
		return subSubCategoryDAO.findBySubCategoryId(subCategoryId);
	}

}