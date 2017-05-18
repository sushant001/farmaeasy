/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.pe.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.stereotype.Controller;


/**
 *
 * @author SushantKumar
 */
@Controller
@Path(value = "test")
public class TestController {
    
    @GET
    @Path(value = "test")
    public String testctrl() {
        return "Testing";
    }
}
