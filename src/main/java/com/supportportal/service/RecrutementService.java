package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.Employee;
import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.Recrutement;



public interface RecrutementService {

    Recrutement saveRecrutement(Recrutement recrutement);
    List<Recrutement> findAllRecruitments();
    Recrutement findByIdRecrutement(Long idRecrutement);
    void deleteRecrutement(Long idRecrutement);
    Recrutement updateRecrutement(Recrutement recrutement); // Added update method
	Employee convertCandidatToEmployee(Long recrutementId);
	
	Recrutement updateOffre(   
			 Long idRecrutement,
		     String departement,
		    
		     String recruteur,
		    
		     String nomCondidat,
		    
		     String commentaire,
		    
		     Date  dateDemandeRec,
		    
		    // enum
		     String emploiDemandeType,
		    
		     String sourceType,
		    
		     String selectionPhase,
		    
		     String desisionType,
		    
		     String vueGestionaire,
		    
		     String vueDecideur,
		    
		     String vueRh
		    );
			
			
		
    	
}
