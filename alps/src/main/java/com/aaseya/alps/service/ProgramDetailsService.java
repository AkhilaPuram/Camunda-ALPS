package com.aaseya.alps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aaseya.alps.dao.ProgramDetailsDAO;

import com.aaseya.alps.model.ProgramDetails;
@Service
public class ProgramDetailsService {

    @Autowired
    private ProgramDetailsDAO programDetailsDAO;

    public List<ProgramDetails> getProgramDetailsBySubSubCategory(String sub_sub_category) {
    	//System.out.println("Hello");
        return programDetailsDAO.getProgramDetailsBySubSubCategory(sub_sub_category);
    }

}
