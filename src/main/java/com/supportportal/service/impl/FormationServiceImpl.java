package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Formation;
import com.supportportal.repository.FormationRepository;
import com.supportportal.service.FormationService;



@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> findAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation findByIdFormation(Long idFormation) {
        return formationRepository.findById(idFormation).orElse(null);
    }

    @Override
    public void deleteFormation(Long idFormation) {
        formationRepository.deleteById(idFormation);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        Formation existingFormation = formationRepository.findById(formation.getIdFormation()).orElse(null);
        if (existingFormation != null) {
            existingFormation.setModule(formation.getModule());
            existingFormation.setCategorie(formation.getCategorie());
            existingFormation.setType(formation.getType());
            existingFormation.setDuree(formation.getDuree());
            return formationRepository.save(existingFormation);
        } else {
            throw new RuntimeException("Formation with ID " + formation.getIdFormation() + " not found for update.");
        }
    }
}