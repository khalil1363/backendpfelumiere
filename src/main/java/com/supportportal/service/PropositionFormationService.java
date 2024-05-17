package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.PropositionFormation;



public interface PropositionFormationService {
	    List<PropositionFormation> getAllPropositionFormations();
	    PropositionFormation getPropositionFormationById(Long idProposition);
	    
		PropositionFormation updatePropositionFormation(Long idProposition, String module, String type,
				String categorie, Integer duree, String description, String proposePar, boolean isAccepted); 
		void deletePropositionFormation(Long idProposition);
		PropositionFormation ajouterPropositionFormation(String module, String type, String categorie, Integer duree,
				String description, String proposePar);
}