/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.pe.model.AccessRequest;
import com.testing.pe.model.ApprovalStatus;
import com.testing.pe.model.Prescription;
import com.testing.pe.model.ProfileMaster;
import com.testing.pe.model.ProfileType;
import java.util.Date;

/**
 *
 * @author SushantKumar
 */
public class Profile {
    public static void main2(String[] args) throws Exception {
        ProfileMaster pm = new ProfileMaster();
        pm.setName("xxyyzz");
        pm.setProfileType(ProfileType.PATIENT);
        pm.setPwd("abc123");
        String s = new ObjectMapper().writeValueAsString(pm);
        System.out.println(s);
                
    }
    
    public static void mainss(String[] args) throws Exception {
        Prescription p = new Prescription();
        p.setDescriptionText("P1");
        ProfileMaster parient = new ProfileMaster();
        parient.setId(1L);
        p.setPatient(parient);
        p.setPrescriptionDate(new Date());
        String s = new ObjectMapper().writeValueAsString(p);
        System.out.println(s);
                
    }
    
    public static void main(String[] args) throws Exception {
        AccessRequest ac = new AccessRequest();
        Prescription px = new Prescription();
        px.setId(1L);
        ac.setPrescription(px);
        ac.setApprovalStatus(ApprovalStatus.PENDING);
        ProfileMaster parient = new ProfileMaster();
        parient.setId(1L);
        ProfileMaster doctor = new ProfileMaster();
        doctor.setId(3L);
        ac.setRequester(doctor);
        ac.setRequestDate(new Date());
//s        ac.setPatient(parient);
        String s = new ObjectMapper().writeValueAsString(ac);
        System.out.println(s);
                
    }
}
