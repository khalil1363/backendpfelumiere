package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.PropositionOffre;



public interface OffreEmploiService {

    List<OffreEmploi> getAllOffresEmploi();

    OffreEmploi getOffreEmploiById(Long idOffreEmploi);

    OffreEmploi saveOffreEmploi(OffreEmploi offreEmploi);

    void deleteOffreEmploi(Long idOffreEmploi);


    OffreEmploi updateOffre(   Long idOffreEmploi,
    
    String departement,
    String jobTitre,
     Double coutEmbauche,
     String duree,
    
     String motifRecretement,
    
     Date dateLancement,
     Date dateEmbauche,
    
     String recruteur,
     String modeRecrutement,
     String statusOffre);
	
	
}