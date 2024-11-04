package com.aaseya.alps.dto;
 
import java.util.List;
 
public class SubSubCategoryDTO {
    private List<String> subsubcategory;
 
    public SubSubCategoryDTO(List<String> subsubcategory) {
        this.subsubcategory = subsubcategory;
    }
 
    public List<String> getSubsubcategory() {
        return subsubcategory;
    }
 
    public void setSubsubcategory(List<String> subsubcategory) {
        this.subsubcategory = subsubcategory;
    }
}
 