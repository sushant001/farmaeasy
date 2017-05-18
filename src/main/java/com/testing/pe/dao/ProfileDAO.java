/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.dao;

import com.testing.pe.model.ProfileMaster;
import com.testing.pe.model.ProfileType;
import java.util.List;
import javax.persistence.Query;
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
public class ProfileDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public List<ProfileMaster> loadpatients() {
        Session session = this.sessionFactory.openSession();
        Query q = session.createQuery("from ProfileMaster p where p.profileType=:type");
        q.setParameter("type", ProfileType.PATIENT);
        List<ProfileMaster> results = q.getResultList();
        session.close();
        return results;
    }
    
    
    public List<ProfileMaster> loadAll() {
        Session session = this.sessionFactory.openSession();
        Query q = session.createQuery("from ProfileMaster p ");
        List<ProfileMaster> results = q.getResultList();
        session.close();
        return results;
    }
    
    public ProfileMaster save(ProfileMaster pm) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
	session.save(pm);
	tx.commit();
        ProfileMaster pm2 = session.get(ProfileMaster.class, pm.getId());
        session.close();
        return pm2;
    }
}
