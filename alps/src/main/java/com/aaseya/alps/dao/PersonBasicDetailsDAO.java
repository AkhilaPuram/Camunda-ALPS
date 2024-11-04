package com.aaseya.alps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaseya.alps.model.PersonBasicDetails;

@Repository
public class PersonBasicDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveAddressInfo(PersonBasicDetails personBasicDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.persist(personBasicDetails);
		transaction.commit();
		session.close();
	}

	public void updateAddressInfo(PersonBasicDetails personBasicDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.persist(personBasicDetails);
		transaction.commit();
		session.close();
	}
//////////to get 4 tables data on licenceID/////////////
public PersonBasicDetails getPersonBasicDetailsByLicenseId(String licenseId) {
	PersonBasicDetails personBasicDetails = new PersonBasicDetails();
  Session session = sessionFactory.openSession();
  Query<PersonBasicDetails> query = session.createQuery("FROM PersonBasicDetails WHERE license_id = :licenseId", PersonBasicDetails.class);
  query.setParameter("licenseId", licenseId);
  personBasicDetails = query.uniqueResult();
  session.close();
  return personBasicDetails;
  
}
//////////to get 4 tables data on licenceID/////////////
}
