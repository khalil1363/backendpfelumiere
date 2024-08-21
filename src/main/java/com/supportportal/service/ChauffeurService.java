package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Chauffeur;

public interface ChauffeurService {
    List<Chauffeur> getAllChauffeurs();
    Chauffeur getChauffeurById(Long id);
    Chauffeur createChauffeur(Chauffeur chauffeur);
    Chauffeur updateChauffeur(Long id, Chauffeur chauffeur);
    void deleteChauffeur(Long id);
}