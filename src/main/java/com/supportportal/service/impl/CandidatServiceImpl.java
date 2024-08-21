package com.supportportal.service.impl;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Candidat;
import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.Recrutement;
import com.supportportal.repository.CandidatRepository;
import com.supportportal.repository.OffreEmploiRepository;
import com.supportportal.repository.RecrutementRepository;
import com.supportportal.service.CandidatService;



@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository ;
    
    @Autowired
    private OffreEmploiRepository offreEmploiRepository ;
    
    
    @Autowired
    private RecrutementRepository recrutementRepository;

    @Override
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat getCandidatById(Long idCandidats) {
        return candidatRepository.findById(idCandidats).orElse(null);
    }

    @Override
    public void deleteCandidat(Long idCandidats) {
        candidatRepository.deleteById(idCandidats);
    }

    @Override
    public Candidat addCandidat(String nomPrenom, String cin, String tel, String adresse, 
                                String niveau, String diplome, String famille, String postPropose,
                                String contact, String observation, Date date, 
                                List<Long> offresEmploiIds) {
        
    	  Candidat candidat = new Candidat();
        candidat.setNomPrenom(nomPrenom);
        candidat.setCin(cin);
        candidat.setTel(tel);
        candidat.setAdresse(adresse);
        candidat.setNiveau(niveau);
        candidat.setDiplome(diplome);
        candidat.setFamille(famille);
        candidat.setPostPropose(postPropose);
        candidat.setContact(contact);
        candidat.setObservation(observation);
        candidat.setDate(date);

        if (offresEmploiIds != null && !offresEmploiIds.isEmpty()) {
            Set<OffreEmploi> offresEmploi = new HashSet<>();
            for (Long id : offresEmploiIds) {
                Optional<OffreEmploi> offreEmploiOptional = offreEmploiRepository.findById(id);
                if (offreEmploiOptional.isPresent()) {
                    OffreEmploi offreEmploi = offreEmploiOptional.get();
                    offresEmploi.add(offreEmploi);
                    candidat.setOffresEmploi(offresEmploi);
                    candidatRepository.save(candidat);
                    
                    // Création et enregistrement du Recrutement
                    Recrutement recrutement = new Recrutement();
                    recrutement.setCandidat(candidat);
                    recrutement.setOffreEmploi(offreEmploi);
                    recrutement.setNomCondidat(nomPrenom);
                    recrutement.setDepartement(offreEmploi.getDepartement());
                    recrutement.setRecruteur(offreEmploi.getRecruteur());
                    recrutement.setDateDemandeRec(new Date()); 
                    recrutement.setCommentaire("Nouveau recrutement créé pour le candidat " + nomPrenom);
                    
                    recrutementRepository.save(recrutement);
                }
            }
        }

        return candidatRepository.save(candidat);
    }

    
    

    @Override
    public Candidat updateCandidat(Long idCandidat,
                                   String nomPrenom, String cin, String tel, String adresse, 
                                   String niveau, String diplome, String famille, String postPropose,
                                   String contact, String observation, Date date) {

        // Step 1: Retrieve the existing candidate by ID
        Optional<Candidat> optionalCandidat = candidatRepository.findById(idCandidat);
        if (!optionalCandidat.isPresent()) {
            throw new RuntimeException("Candidat not found with ID " + idCandidat);
        }
        
        Candidat existingCandidat = optionalCandidat.get();

        // Step 2: Update the candidate's details if provided
        if (nomPrenom != null) existingCandidat.setNomPrenom(nomPrenom);
        if (cin != null) existingCandidat.setCin(cin);
        if (tel != null) existingCandidat.setTel(tel);
        if (adresse != null) existingCandidat.setAdresse(adresse);
        if (niveau != null) existingCandidat.setNiveau(niveau);
        if (diplome != null) existingCandidat.setDiplome(diplome);
        if (famille != null) existingCandidat.setFamille(famille);
        if (postPropose != null) existingCandidat.setPostPropose(postPropose);
        if (contact != null) existingCandidat.setContact(contact);
        if (observation != null) existingCandidat.setObservation(observation);
        if (date != null) existingCandidat.setDate(date);

       

        // Step 4: Save the updated candidate
        return candidatRepository.save(existingCandidat);
    }
}