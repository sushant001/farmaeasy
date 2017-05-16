# farmaeasy

Profile is of 3 type 
Patient
Doctor 
Pharmacy 

A prescription is specific to a Profile. Any number of prescription can be associated with a Profile.
An Access Request is composed of a Requester (Profile) and a prescription.  Any number of Access Request can be generated for a unique combination of Requester and prescription.


/request
When a doctor or a pharmacy request access for a patient’s prescription, a new AccessRequest is created and is 
/getAllPending
visible to the linked patient as Pending Approval. 

/approve
When patient approves the request, its status is updated to APPROVED from PENDING and is 

/getAllApproved

accessible to the corresponding requester as ApprovedRequest. 

