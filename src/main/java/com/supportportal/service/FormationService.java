package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Formation;



public interface FormationService {

	 Formation saveFormation(Formation formation);
	    List<Formation> findAllFormations();
	    Formation findByIdFormation(Long idFormation);
	    void deleteFormation(Long idFormation);
	    Formation updateFormation(Formation formation);
	
	}