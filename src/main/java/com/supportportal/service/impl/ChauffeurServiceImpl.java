package com.supportportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Chauffeur;
import com.supportportal.repository.ChauffeurRepository;
import com.supportportal.service.ChauffeurService;

@Service
public class ChauffeurServiceImpl implements ChauffeurService {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    @Override
    public Chauffeur getChauffeurById(Long id) {
        Optional<Chauffeur> optionalChauffeur = chauffeurRepository.findById(id);
        return optionalChauffeur.orElse(null);
    }

    @Override
    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        return chauffeurRepository.save(chauffeur);
    }

    @Override
    public Chauffeur updateChauffeur(Long id, Chauffeur chauffeur) {
        if (chauffeurRepository.existsById(id)) {
            chauffeur.setId(id);
            return chauffeurRepository.save(chauffeur);
        } else {
            return null;
        }
    }

    @Override
    public void deleteChauffeur(Long id) {
        chauffeurRepository.deleteById(id);
    }
}
