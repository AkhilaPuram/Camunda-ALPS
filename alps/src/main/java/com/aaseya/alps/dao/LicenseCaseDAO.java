package com.aaseya.alps.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaseya.alps.model.LicenseCaseDetails;

@Repository
public class LicenseCaseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<LicenseCaseDetails> findOpenLicensesByCreatedBy(String createdBy) {
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM LicenseCaseDetails WHERE createdBy = :createdBy AND status = 'open'";
			Query<LicenseCaseDetails> query = session.createQuery(hql, LicenseCaseDetails.class);
			query.setParameter("createdBy", createdBy);
			return query.list();
		}
	}

}
