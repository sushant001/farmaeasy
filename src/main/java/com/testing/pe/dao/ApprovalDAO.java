/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.dao;

import com.testing.pe.model.AccessRequest;
import com.testing.pe.model.ApprovalStatus;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SushantKumar
 */

@Component
public class ApprovalDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public AccessRequest update(AccessRequest request) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
	session.merge(request);
	tx.commit();
        AccessRequest pm2 = session.get(AccessRequest.class, request.getId());
        session.close();
        return pm2;
    }
    
    
    public AccessRequest save(AccessRequest pm) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
	session.save(pm);
	tx.commit();
        AccessRequest pm2 = session.get(AccessRequest.class, pm.getId());
        session.close();
        return pm2;
    }
    
    
    public List<AccessRequest> getAllApprovedRequest(Long profileId) {
        Session session = this.sessionFactory.openSession();
        Query createQuery = session.createQuery("from AccessRequest a where a.requester.id=:userId and a.approvalStatus=:status");
        createQuery.setLong("userId", profileId);
        createQuery.setInteger("status", ApprovalStatus.APPROVED.ordinal());
        List list = createQuery.list();
        session.close();
        return list;
    }
    
    public List<AccessRequest> getAllPendingRequest(Long patientId) {
        Session session = this.sessionFactory.openSession();
        Query createQuery = session.createQuery("from AccessRequest a where a.prescription.patient.id=:userId and a.approvalStatus=:status");
        createQuery.setLong("userId", patientId);
        createQuery.setInteger("status", ApprovalStatus.PENDING.ordinal());
        List list = createQuery.list();
        session.close();
        return list;
    }
}
