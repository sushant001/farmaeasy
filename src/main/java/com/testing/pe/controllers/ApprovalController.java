/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.pe.dao.ApprovalDAO;
import com.testing.pe.model.AccessRequest;
import com.testing.pe.model.ApprovalStatus;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 *
 * @author SushantKumar
 */
@Controller
@Path(value = "approval")
public class ApprovalController {
    
    @Autowired
    private ApprovalDAO approvalDAO;
    
    @POST
    @Path(value = "getAllApproved")
    public String getAllApproved(String userId) throws Exception {
        System.out.println("User ID "+userId);
        String s = new ObjectMapper().writeValueAsString(approvalDAO.getAllApprovedRequest(Long.parseLong(userId)));
        return s;
    }
    
    
    @POST
    @Path(value = "getAllPending")
    public String getAll(String userId) throws Exception {
        System.out.println("User ID "+userId);
        String s = new ObjectMapper().writeValueAsString(approvalDAO.getAllPendingRequest(Long.parseLong(userId)));
        return s;
    }
    
    @POST
    @Path(value = "approve")
    public String approve(String s) throws Exception {
        AccessRequest r = new ObjectMapper().readValue(s, AccessRequest.class);
        r.setApprovalStatus(ApprovalStatus.APPROVED);
        return new ObjectMapper().writeValueAsString(approvalDAO.update(r));
    }
    
    
    @POST
    @Path(value = "request")
    public String save(String s) throws Exception {
        AccessRequest r = new ObjectMapper().readValue(s, AccessRequest.class);
        return new ObjectMapper().writeValueAsString(approvalDAO.save(r));
    }
}
