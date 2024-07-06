package com.supportportal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.OffreStatus;
import com.supportportal.entity.PropositionOffre;
import com.supportportal.enumeration.StautsPropoOffre;
import com.supportportal.repository.OffreEmploiRepository;
import com.supportportal.repository.PropositionOffreRepository;
import com.supportportal.service.PropositionOffreService;
import java.util.Optional;


@Service
public class PropositionOffreServiceImpl implements PropositionOffreService {

	@Autowired
	  private PropositionOffreRepository propositionOffreRepository;
	
	@Autowired
	  private OffreEmploiRepository offreEmploiRepository;
  
	


  @Override
  public List<PropositionOffre> getAllPropositionOffres() {
    return propositionOffreRepository.findAll();
  }

  @Override
  public PropositionOffre getPropositionOffreById(Long id) {
    return propositionOffreRepository.findById(id).get();
  }

  @Override
  public void deletePropositionOffre(Long id) {
    propositionOffreRepository.deleteById(id);
  }
  
  
  @Override
  public PropositionOffre ajouterPropositionOffre(String departement, String jobTitle, Double coutEmbauche, String duree,
                                                  String motifRecrutement, Date dateLancement, Date dateEmbauche, 
                                                  String recruteur, String modeRecrutement) {
      PropositionOffre propositionOffre = new PropositionOffre();
      propositionOffre.setDepartement(departement);
      propositionOffre.setJobTitle(jobTitle);
      propositionOffre.setCoutEmbauche(coutEmbauche);
      propositionOffre.setDuree(duree);
      propositionOffre.setMotifRecretement(motifRecrutement);
      propositionOffre.setDateLancement(dateLancement);
      propositionOffre.setDateEmbauche(dateEmbauche);
      propositionOffre.setRecruteur(recruteur);
      propositionOffre.setModeRecretement(modeRecrutement);
      propositionOffre.setStatusPropo(StautsPropoOffre.EN_ATTENTE.name()); // Initial status
      propositionOffre.setAccepted(false);
      
      propositionOffreRepository.save(propositionOffre);
      
      return propositionOffre;
  }

  @Override
  public PropositionOffre accepterPropositionOffre(Long idOffreProp) {
      Optional<PropositionOffre> optionalOffre = propositionOffreRepository.findById(idOffreProp);
      if (optionalOffre.isPresent()) {
          PropositionOffre propositionOffre = optionalOffre.get();
          propositionOffre.setAccepted(true);
          propositionOffre.setStatusPropo(StautsPropoOffre.ACCEPTED.name());
          propositionOffreRepository.save(propositionOffre);

          // Copy to a new Offre entity (assuming an Offre entity exists)
          OffreEmploi offre = new OffreEmploi();
          offre.setStatusOffre(OffreStatus.VACANT.name());
          offre.setDepartement(propositionOffre.getDepartement());
          offre.setJobTitre(propositionOffre.getJobTitle());
          offre.setCoutEmbauche(propositionOffre.getCoutEmbauche());
          offre.setDuree(propositionOffre.getDuree());
          offre.setMotifRecretement(propositionOffre.getMotifRecretement());
          offre.setDateLancement(propositionOffre.getDateLancement());
          offre.setDateEmbauche(propositionOffre.getDateEmbauche());
          offre.setRecruteur(propositionOffre.getRecruteur());
          offre.setModeRecretement(propositionOffre.getModeRecretement());
          
          offreEmploiRepository.save(offre);

          return propositionOffre;
      } else {
          System.out.println("Aucune proposition d'offre avec l'ID " + idOffreProp + " trouvée.");
          return null;
      }
  }

  @Override
  public PropositionOffre refuserPropositionOffre(Long idOffreProp) {
      Optional<PropositionOffre> optionalOffre = propositionOffreRepository.findById(idOffreProp);
      if (optionalOffre.isPresent()) {
          PropositionOffre propositionOffre = optionalOffre.get();
          propositionOffre.setStatusPropo(StautsPropoOffre.REJECTED.name());
          
          propositionOffreRepository.save(propositionOffre);

          return propositionOffre;
      } else {
          System.out.println("Aucune proposition d'offre avec l'ID " + idOffreProp + " trouvée.");
          return null;
      }
  }


}