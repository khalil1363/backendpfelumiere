package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.PropositionFormation;
import com.supportportal.repository.PropositionFormationRepository;
import com.supportportal.service.PropositionFormationService;


@Service
public class PropositionFormationServiceImpl implements PropositionFormationService {

    @Autowired
    private PropositionFormationRepository propositionFormationRepository;

    @Override
    public List<PropositionFormation> getAllPropositionFormations() {
        return propositionFormationRepository.findAll();
    }

    
	@Override
    public PropositionFormation getPropositionFormationById(Long idProposition) {
        return propositionFormationRepository.findById(idProposition).orElse(null);
    }

	@Override
    public PropositionFormation ajouterPropositionFormation(String module, String type, String categorie, Integer duree, String description, String proposePar) {
        PropositionFormation propositionFormation = new PropositionFormation();
        propositionFormation.setModule(module);
        propositionFormation.setType(type);
        propositionFormation.setCategorie(categorie);
        propositionFormation.setDuree(duree);
        propositionFormation.setDescription(description);
        propositionFormation.setProposePar(proposePar);
        propositionFormation.setAccepted(false); // Par défaut, la proposition n'est pas acceptée
        return propositionFormationRepository.save(propositionFormation);
    }

    @Override
    public PropositionFormation updatePropositionFormation(Long idProposition, String module, String type, String categorie, Integer duree, String description, String proposePar, boolean isAccepted) {
        PropositionFormation propositionFormation = propositionFormationRepository.findById(idProposition).orElse(null);
        if (propositionFormation != null) {
            propositionFormation.setModule(module);
            propositionFormation.setType(type);
            propositionFormation.setCategorie(categorie);
            propositionFormation.setDuree(duree);
            propositionFormation.setDescription(description);
            propositionFormation.setProposePar(proposePar);
            propositionFormation.setAccepted(isAccepted);
            return propositionFormationRepository.save(propositionFormation);
        } else {
            System.out.println("Aucune proposition de formation avec l'ID " + idProposition + " trouvé.");
            return null;
        }
    }

    @Override
    public void deletePropositionFormation(Long idProposition) {
        propositionFormationRepository.deleteById(idProposition);
    }
}
