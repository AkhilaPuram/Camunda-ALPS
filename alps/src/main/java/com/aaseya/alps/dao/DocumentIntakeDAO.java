package com.aaseya.alps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.aaseya.alps.model.DocumentIntake;
@Repository
public class DocumentIntakeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveData(DocumentIntake documentIntake) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		session.persist(documentIntake);
		transaction.commit();
		session.close();
	}
	public void updateData(DocumentIntake documentIntake) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		session.persist(documentIntake);
		transaction.commit();
		session.close();
	}
	
	public List<DocumentIntake> findByLicenseId(String license_Id) {
		List<DocumentIntake> documentIntake = new ArrayList<DocumentIntake>();
        Session session = sessionFactory.openSession();
        documentIntake = session.createQuery("FROM DocumentIntake WHERE licenseCaseDetails.license_Id = :license_Id", DocumentIntake.class)
                      .setParameter("license_Id", license_Id)
                      .list();
        session.close();
        return documentIntake;
    }
}
