package com.supportportal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Candidat;
import com.supportportal.entity.Employee;
import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.Recrutement;
import com.supportportal.repository.EmployeeRepository;
import com.supportportal.repository.RecrutementRepository;
import com.supportportal.service.RecrutementService;



@Service
public class RecrutementServiceImpl implements RecrutementService {

	 @Autowired
	    private RecrutementRepository recrutementRepository;
	 
	 @Autowired
	 private EmployeeRepository employeeRepository;

    @Override
    public Recrutement saveRecrutement(Recrutement recrutement) {
        return recrutementRepository.save(recrutement);
    }

    @Override
    public List<Recrutement> findAllRecruitments() {
        return recrutementRepository.findAll();
    }

    @Override
    public Recrutement findByIdRecrutement(Long idRecrutement) {
        return recrutementRepository.findById(idRecrutement).orElse(null);
    }

    @Override
    public void deleteRecrutement(Long idRecrutement) {
        recrutementRepository.deleteById(idRecrutement);
    }

    @Override
    public Recrutement updateRecrutement(Recrutement recrutement) {
        return recrutementRepository.save(recrutement);
    }


    @Override
    public Employee convertCandidatToEmployee(Long recrutementId) {
        Optional<Recrutement> recrutementOptional = recrutementRepository.findById(recrutementId);
        if (!recrutementOptional.isPresent()) {
            throw new RuntimeException("Recrutement not found");
        }

        Recrutement recrutement = recrutementOptional.get();
        Candidat candidat = recrutement.getCandidat();

        Employee employee = new Employee();
        employee.setNomPrenom(candidat.getNomPrenom());
        employee.setDepartement(recrutement.getOffreEmploi().getDepartement());
        employee.setFonction(candidat.getPostPropose());
        employee.setSite(null); // Initially null, can be updated later
        employee.setTel(candidat.getTel());
        employee.setMat(null); // Initially null, can be updated later

        return employeeRepository.save(employee);
    }
    
    @Override
   	public Recrutement updateOffre(   
			 Long idRecrutement,
		     String departement,
		    
		     String recruteur,
		    
		     String nomCondidat,
		    
		     String commentaire,
		    
		     Date  dateDemandeRec,
		    
		     String emploiDemandeType,
		    
		     String sourceType,
		    
		     String selectionPhase,
		    
		     String desisionType,
		    
		     String vueGestionaire,
		    
		     String vueDecideur,
		    
		     String vueRh
		    ) {
   		
   	// Vérifier si l'ID existe, sinon lever une exception (ken les 2 lignes hedhom zeydin par rapport l methode 'ajout 
    	Recrutement propositionFormation = recrutementRepository.findById(idRecrutement)
   	.orElseThrow(() -> new EntityNotFoundException("PropositionFormation not found with id: " + idRecrutement));
   	
   	// MAJ les champs (elli t7eb taamel aalehom modification)
   	propositionFormation.setDepartement(departement);
   	propositionFormation.setRecruteur(recruteur);
   	propositionFormation.setNomCondidat(nomCondidat);
   	propositionFormation.setCommentaire(commentaire);
   	propositionFormation.setDateDemandeRec(dateDemandeRec);
   	propositionFormation.setEmploiDemandeType(emploiDemandeType);
   	propositionFormation.setSourceType(sourceType);
   	propositionFormation.setSelectionPhase(selectionPhase); 
   	propositionFormation.setDesisionType(desisionType);
   	propositionFormation.setVueGestionaire(vueGestionaire);
	
   	
   	propositionFormation.setVueDecideur(vueDecideur);
	propositionFormation.setVueRh(vueRh);

   	return recrutementRepository.save(propositionFormation);
   	}
	
}
