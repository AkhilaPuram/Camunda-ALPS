package com.aaseya.alps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaseya.alps.model.LicenseCaseDetails;



@Repository
public class LicenseCaseIdDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public LicenseCaseDetails getLicenseCaseById(String license_id) {
		LicenseCaseDetails licenseCaseDetails = new LicenseCaseDetails();
		Session session = sessionFactory.openSession();
		System.out.println(license_id);
		Query<LicenseCaseDetails> query = session.createQuery("FROM LicenseCaseDetails WHERE license_Id = :license_Id",
				LicenseCaseDetails.class);
		query.setParameter("license_Id", license_id);
		System.out.println(license_id);
		licenseCaseDetails = query.getSingleResult();
		session.close();
		return licenseCaseDetails;
		
	}
	public void updateLicenseCaseDetails(LicenseCaseDetails licenseCaseDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.merge(licenseCaseDetails);
		transaction.commit();
		System.out.println("inDAO   " + licenseCaseDetails);

		session.close();
		
	}
}
