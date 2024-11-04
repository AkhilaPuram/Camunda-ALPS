package com.aaseya.alps.dao;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.aaseya.alps.model.LicenseCaseDetails;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
 
@Repository
public class LicenceCaseDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
 
	public List<LicenseCaseDetails> getPendingReviewCases() {
	    Session session = sessionFactory.openSession();
	    try {
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<LicenseCaseDetails> criteriaQuery = criteriaBuilder.createQuery(LicenseCaseDetails.class);
	        Root<LicenseCaseDetails> root = criteriaQuery.from(LicenseCaseDetails.class);

	        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("status"), "pending_review"));

	        Query<LicenseCaseDetails> query = session.createQuery(criteriaQuery);
	        return query.getResultList();
	    } finally {
	        session.close();
	    }
	}
	 

	public List<LicenseCaseDetails> getPendingApprovalCases() {
	    Session session = sessionFactory.openSession();
	    try {
	        // Create CriteriaBuilder
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        
	        // Create CriteriaQuery
	        CriteriaQuery<LicenseCaseDetails> criteriaQuery = criteriaBuilder.createQuery(LicenseCaseDetails.class);
	        
	        // Define the root for the query (i.e., the table/entity)
	        Root<LicenseCaseDetails> root = criteriaQuery.from(LicenseCaseDetails.class);
	        
	        // Add a WHERE clause to filter by status
	        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("status"), "pending_approval"));
	        
	        // Create a query object from the session and execute the query
	        Query<LicenseCaseDetails> query = session.createQuery(criteriaQuery);
	        return query.getResultList();
	    } finally {
	        session.close();
	    }
	}
	
	  public LicenseCaseDetails getLicenseCaseDetailsById(String licenseId) {
	        try(Session session = sessionFactory.openSession()){
	        return session.get(LicenseCaseDetails.class, licenseId);
	        
	   }
	       
	  } 
	  
	  
}
 