package com.aaseya.alps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.aaseya.alps.model.LicenseCaseDetails;
@Repository
public class SaveLicenseCaseDAO {
    private SessionFactory sessionFactory;
    public SaveLicenseCaseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveLicenseCase(LicenseCaseDetails licenseCase) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            if (session.contains(licenseCase)) {
                session.persist(licenseCase);
            } else {
                licenseCase = (LicenseCaseDetails) session.merge(licenseCase);
                session.persist(licenseCase);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
