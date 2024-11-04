package com.aaseya.alps.dao;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.aaseya.alps.model.SubSubCategory;
 
@Repository
public class SubSubCategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
 
	public List<SubSubCategory> findBySubCategoryId(int subCategoryId) {
        Session session = sessionFactory.openSession();
        List<SubSubCategory> subSubCategories = session.createQuery("FROM SubSubCategory WHERE subCategory.id = :subCategoryId", SubSubCategory.class)
            .setParameter("subCategoryId", subCategoryId)
            .list();
        session.close();
        return subSubCategories;
    }
//////////to get 4 tables data on licenceID/////////////
public SubSubCategory getSubSubCategoryById(int subsubcategoryId) {
	SubSubCategory subSubCategory = new SubSubCategory();
  Session session = sessionFactory.openSession();
  subSubCategory = session.get(SubSubCategory.class, subsubcategoryId);
  session.close();
  return subSubCategory;
}
//////////to get 4 tables data on licenceID/////////////
}