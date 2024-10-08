package com.supportportal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Employee;
import com.supportportal.entity.Formation;
import com.supportportal.entity.PropositionFormation;
import com.supportportal.enumeration.StautsPropoForma;
import com.supportportal.repository.EmployeeRepository;
import com.supportportal.repository.FormationRepository;
import com.supportportal.repository.PropositionFormationRepository;
import com.supportportal.service.PropositionFormationService;


@Service
public class PropositionFormationServiceImpl implements PropositionFormationService {

	@Autowired
    private PropositionFormationRepository propositionFormationRepository;
    
	@Autowired
    private  FormationRepository formationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 public PropositionFormationServiceImpl(PropositionFormationRepository propositionFormationRepository,  FormationRepository formationRepository) {
		this.propositionFormationRepository = propositionFormationRepository;
		this.formationRepository = formationRepository; 
}
	
	 
	 @Override
		public PropositionFormation updateProposition(long idPropo, String module, String type, String categorie, String description,
		                 String proposePar, String posteProposerPar, String cabinetpropo, String departement,
		                 String objectif, String activite, String observation, String formateurPropose,
		                 Date prdSouhaite) {
			
		// Vérifier si l'ID existe, sinon lever une exception (ken les 2 lignes hedhom zeydin par rapport l methode 'ajout 
		PropositionFormation propositionFormation = propositionFormationRepository.findById(idPropo)
		.orElseThrow(() -> new EntityNotFoundException("PropositionFormation not found with id: " + idPropo));
		
		// MAJ les champs (elli t7eb taamel aalehom modification)
		propositionFormation.setModule(module);
		propositionFormation.setTypePropo(type);
		propositionFormation.setCategorie(categorie);
		propositionFormation.setDescription(description);
		propositionFormation.setProposePar(proposePar);
		propositionFormation.setPosteProposerPar(posteProposerPar);
		propositionFormation.setCabinetproposer(cabinetpropo);
		propositionFormation.setDepartement(departement);
		propositionFormation.setObjectif(objectif);
		propositionFormation.setActivite(activite);
		propositionFormation.setObservation(observation);
		propositionFormation.setFormateurPropose(formateurPropose);
		propositionFormation.setPeriodeSouhaite(prdSouhaite);
		propositionFormation.setStatus(StautsPropoForma.EN_ATTENTE.name());
		
		// Save Entity
		return propositionFormationRepository.save(propositionFormation);
		}
	 

    @Override
    public List<PropositionFormation> getAllPropositionFormations() {
        return propositionFormationRepository.findAll();
    }

    
	@Override
    public PropositionFormation getPropositionFormationById(Long idProposition) {
        return propositionFormationRepository.findById(idProposition).orElse(null);
    }

	@Override
    public PropositionFormation ajouterPropositionFormation(String module, String type, String categorie, String  description, 
    														String proposePar, String posteProposerPar , String cabinetpropo,String departemenet,
    														String objectif , String activite , String observation , String formateurPropose ,
    														Date prdSouhaite , List<String> employeeNames) {
        PropositionFormation propositionFormation = new PropositionFormation();
        propositionFormation.setModule(module);
        propositionFormation.setDateCreation(new Date());
        propositionFormation.setTypePropo(type);
        propositionFormation.setCategorie(categorie);
        propositionFormation.setDescription(description);
        propositionFormation.setProposePar(proposePar);
        propositionFormation.setPosteProposerPar(posteProposerPar);
        propositionFormation.setCabinetproposer(cabinetpropo);
        propositionFormation.setDepartement(departemenet);
        propositionFormation.setObjectif(objectif);
        propositionFormation.setActivite(activite);
        propositionFormation.setObservation(observation);
        propositionFormation.setFormateurPropose(formateurPropose);
        propositionFormation.setPeriodeSouhaite(prdSouhaite);
        propositionFormation.setAccepted(false);
        propositionFormation.setStatus(StautsPropoForma.EN_ATTENTE.name());
        
        // Ajouter les participants
        for (String employeeName : employeeNames) {
            Employee employee = employeeRepository.findByNomPrenom(employeeName).orElseThrow(() -> 
                new EntityNotFoundException("Employee " + employeeName + " not found"));
            propositionFormation.getParticipants().add(employee);
        }
       
        propositionFormationRepository.save(propositionFormation);
       
        return  propositionFormation ;
    }
	
	  
	@Override 
	  public PropositionFormation AccepterPropositionFormation(Long idProposition) {
	        PropositionFormation propositionFormation = propositionFormationRepository.findById(idProposition).orElse(null);
	        if (propositionFormation != null) {
	            propositionFormation.setAccepted(true);
	            propositionFormation.setStatus(StautsPropoForma.ACCEPTED.name());
	            propositionFormationRepository.save(propositionFormation);

	            Formation formation = new Formation();
		         // Copier les attributs obligatoires
		         formation.setModule(propositionFormation.getModule());
		         formation.setType(propositionFormation.getTypePropo());
		         formation.setCategorie(propositionFormation.getCategorie());
		         formation.setDescription(propositionFormation.getDescription());
		         formation.setProposePar(propositionFormation.getProposePar());
		         formation.setPosteProposerPar(propositionFormation.getPosteProposerPar());
		         formation.setDepartement(propositionFormation.getDepartement());
		         formation.setObjectif(propositionFormation.getObjectif());
		         formation.setActivite(propositionFormation.getActivite());
		         formation.setBudgetPrevisionnel("00.00");
		 
		        
		         // Copier les attributs non obligatoires si présents
		         if (propositionFormation.getCabinetproposer() != null) {
		             formation.setCabinetproposer(propositionFormation.getCabinetproposer());
		         }
	
		         if (propositionFormation.getFormateurPropose() != null) {
		             formation.setFormateurPropose(propositionFormation.getFormateurPropose());
		         }
	
		         if (propositionFormation.getObservation() != null) {
		             formation.setObservation(propositionFormation.getObservation());
		         }
		         List<Employee> participants = new ArrayList<>();
		         for (Employee participant : propositionFormation.getParticipants()) {
		             // Save the new Employee instance
		             Employee newParticipant = employeeRepository.save(participant);
		             // Add the new participant to the list
		             participants.add(newParticipant);
		         }
		         // Set the participants for the new Formation
		         formation.setParticipants(participants);

		         // Save the new Formation
		         formationRepository.save(formation);


	            return propositionFormation;
	        } else {
	            System.out.println("Aucune proposition de formation avec l'ID " + idProposition + " trouvée.");
	            return null;
	        }
	    }
	  
	  
	  @Override 
	  public PropositionFormation RefuserPropositionFormation(Long idProposition) {
	        PropositionFormation propositionFormation = propositionFormationRepository.findById(idProposition).orElse(null);
	        if (propositionFormation != null) {
	            propositionFormation.setAccepted(false);
	            propositionFormation.setStatus(StautsPropoForma.REJECTED.name());
	            propositionFormationRepository.save(propositionFormation);

	            return propositionFormation;
	        } else {
	            System.out.println("Aucune proposition de formation avec l'ID " + idProposition + " trouvée.");
	            return null;
	        }
	    }
	  
	  

    @Override
    public void deletePropositionFormation(Long idProposition) {
        propositionFormationRepository.deleteById(idProposition);
    }

	
}