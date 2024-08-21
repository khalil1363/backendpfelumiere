package com.supportportal.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.PropositionOffre;
import com.supportportal.repository.OffreEmploiRepository;
import com.supportportal.service.OffreEmploiService;


@Service
public class OffreEmploiServiceImpl implements OffreEmploiService {

    @Autowired
    private OffreEmploiRepository offreEmploiRepository;

    @Override
    public List<OffreEmploi> getAllOffresEmploi() {
        return offreEmploiRepository.findAll();
    }

    @Override
    public OffreEmploi getOffreEmploiById(Long idOffreEmploi) {
        return offreEmploiRepository.findById(idOffreEmploi).orElse(null);
    }

    @Override
    public OffreEmploi saveOffreEmploi(OffreEmploi offreEmploi) {
        return offreEmploiRepository.save(offreEmploi);
    }

    @Override
    public void deleteOffreEmploi(Long idOffreEmploi) {
        offreEmploiRepository.deleteById(idOffreEmploi);
    }
    
    
    
    @Override
	public OffreEmploi updateOffre( Long idOffreEmploi,
		    
		    String departement,
		    String jobTitre,
		     Double coutEmbauche,
		     String duree,
		    
		     String motifRecretement,
		    
		     Date dateLancement,
		     Date dateEmbauche,
		    
		     String recruteur,
		     String modeRecrutement,
		     String statusOffre) {
		
	// Vérifier si l'ID existe, sinon lever une exception (ken les 2 lignes hedhom zeydin par rapport l methode 'ajout 
    	OffreEmploi propositionFormation = offreEmploiRepository.findById(idOffreEmploi)
	.orElseThrow(() -> new EntityNotFoundException("PropositionFormation not found with id: " + idOffreEmploi));
	
	// MAJ les champs (elli t7eb taamel aalehom modification)
	propositionFormation.setDepartement(departement);
	propositionFormation.setJobTitre(jobTitre);
	propositionFormation.setCoutEmbauche(coutEmbauche);
	propositionFormation.setDuree(duree);
	propositionFormation.setMotifRecretement(motifRecretement);
	propositionFormation.setDateLancement(dateLancement);
	propositionFormation.setDateEmbauche(dateEmbauche);
	propositionFormation.setRecruteur(recruteur);
	propositionFormation.setModeRecretement(motifRecretement);
	propositionFormation.setStatusOffre(statusOffre);
	
	
	
	return offreEmploiRepository.save(propositionFormation);
	}
    
    
    
}