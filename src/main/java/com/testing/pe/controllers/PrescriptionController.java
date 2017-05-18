/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.pe.dao.PrescriptionDAO;
import com.testing.pe.model.Prescription;
import java.util.Date;
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
@Path(value = "pres")
public class PrescriptionController {
    
    @Autowired
    private PrescriptionDAO prescriptionDAO;
    
    @GET
    @Path(value = "loadAllPrescriptions")
    public String loadAll() throws Exception {
        List<Prescription> list = prescriptionDAO.loadAll();
        return new ObjectMapper().writeValueAsString(list);
    }
    
    
    @POST
    @Path(value = "save")
    public String save(String profile) throws Exception {
        Prescription pm = new ObjectMapper().readValue(profile, Prescription.class);
        if(pm.getPrescriptionDate()==null) {
            pm.setPrescriptionDate(new Date());
        }
        return new ObjectMapper().writeValueAsString(prescriptionDAO.save(pm));
    }
    
    
}
