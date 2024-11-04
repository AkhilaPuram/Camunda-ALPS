package com.aaseya.alps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaseya.alps.model.ProgramDetails;
import com.aaseya.alps.model.SubSubCategory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

@Repository
public class ProgramDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<ProgramDetails> getProgramDetailsBySubSubCategory(String sub_sub_category) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<SubSubCategory> cr = cb.createQuery(SubSubCategory.class);
		Root<SubSubCategory> root = cr.from(SubSubCategory.class);
		cr.select(root).where(cb.equal(root.get("subsubcategory_name"), sub_sub_category));
		SubSubCategory subSubCategory = session.createQuery(cr).getSingleResultOrNull();
 
		if (subSubCategory == null) {
			System.out.println("No SubSubCategory found with subsubcategory_name: " + sub_sub_category);
			return new ArrayList<>();
		}
 
		long subsubcategoryid = subSubCategory.getSubsubcategory_id();
		System.out.println("Result: " + subsubcategoryid);
 
		CriteriaBuilder cb2 = session.getCriteriaBuilder();
		CriteriaQuery<ProgramDetails> cr2 = cb2.createQuery(ProgramDetails.class);
		Root<ProgramDetails> root2 = cr2.from(ProgramDetails.class);
		cr2.where(cb2.equal(root2.join("subsubCategory").get("subsubcategory_id"), subsubcategoryid));
		List<ProgramDetails> programDetails = session.createQuery(cr2).getResultList();
		System.out.println("ProgramDetails: " + programDetails);
 
		session.close();
		return programDetails;
	}
//////////to get 4 tables data on licenceID/////////////
public ProgramDetails getProgramDetailsBySubSubCategoryId(int subsubcategoryId) {
	ProgramDetails programDetails = new ProgramDetails();
  Session session = sessionFactory.openSession();
  Query<ProgramDetails> query = session.createQuery("FROM ProgramDetails WHERE subsubCategory.subsubcategory_id = :subsubcategoryId", ProgramDetails.class);
  query.setParameter("subsubcategoryId", subsubcategoryId);
  programDetails = query.uniqueResult();
  session.close();
  return programDetails;
}
}