/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.pe.dao.ApprovalDAO;
import com.testing.pe.dao.ProfileDAO;
import com.testing.pe.model.ProfileMaster;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 *
 * @author SushantKumar
 */
@Controller
@Path(value = "profile")
public class ProfileController {
    
    @Autowired
    private ProfileDAO profileDAO;
    
    @POST
    @Path(value = "save")
    public String save(String profile) throws Exception {
        ProfileMaster pm = new ObjectMapper().readValue(profile, ProfileMaster.class);
        return new ObjectMapper().writeValueAsString(profileDAO.save(pm));
    }
    
    @GET
    @Path (value = "loadPatients")
    public String profileType() throws Exception {
        List<ProfileMaster> loadpatients = profileDAO.loadpatients();
        return new ObjectMapper().writeValueAsString(loadpatients);
    }
    
    
    @GET
    @Path (value = "loadAll")
    public String loadAll() throws Exception {
        List<ProfileMaster> loadpatients = profileDAO.loadAll();
        return new ObjectMapper().writeValueAsString(loadpatients);
    }
}
