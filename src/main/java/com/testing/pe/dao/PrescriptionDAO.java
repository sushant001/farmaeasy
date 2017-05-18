/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.dao;

import com.testing.pe.model.Prescription;
import com.testing.pe.model.ProfileMaster;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SushantKumar
 */

@Component
public class PrescriptionDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Prescription> loadAll() {
        Session session = this.sessionFactory.openSession();
        List<Prescription> list = session.createQuery(" from Prescription p ").list();
        session.close();
        return list;
    }
    
    public Prescription save(Prescription pm) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
	session.save(pm);
	tx.commit();
        Prescription pm2 = session.get(Prescription.class, pm.getId());
        session.close();
        return pm2;
    }
}
