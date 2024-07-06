package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.PropositionOffre;



public interface PropositionOffreService {

	  public List<PropositionOffre> getAllPropositionOffres();
	  public PropositionOffre getPropositionOffreById(Long id);
	  public void deletePropositionOffre(Long id);
	 
	  
	  PropositionOffre ajouterPropositionOffre(String departement, String jobTitle, Double coutEmbauche, String duree,
				String motifRecrutement, Date dateLancement, Date dateEmbauche, String recruteur, String modeRecrutement);
		
	  
	  PropositionOffre accepterPropositionOffre(Long idOffreProp);
	
	
	PropositionOffre refuserPropositionOffre(Long idOffreProp);
	}