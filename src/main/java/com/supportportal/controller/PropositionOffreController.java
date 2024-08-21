package com.supportportal.controller;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.HttpResponse;
import com.supportportal.entity.PropositionFormation;
import com.supportportal.entity.PropositionOffre;
import com.supportportal.service.PropositionOffreService;


@RestController
@RequestMapping("/propositionOffres")
public class PropositionOffreController {

  @Autowired
  private PropositionOffreService propositionOffreService;


  @GetMapping("/getall")
  public List<PropositionOffre> getAllPropositionOffres() {
    return propositionOffreService.getAllPropositionOffres();
  }

  @GetMapping("/getone/{id}")
  public PropositionOffre getPropositionOffreById(@PathVariable Long id) {
    return propositionOffreService.getPropositionOffreById(id);
  }

  @PostMapping("/add")
  public ResponseEntity<PropositionOffre> addNewPropositionOffre(
          @RequestParam("departement") String departement,
          @RequestParam("jobTitle") String jobTitle,
          @RequestParam("coutEmbauche") Double coutEmbauche,
          @RequestParam("duree") String duree,
          @RequestParam("motifRecrutement") String motifRecrutement,
          @RequestParam("dateLancement") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateLancement,
          @RequestParam("dateEmbauche") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEmbauche,
          @RequestParam("recruteur") String recruteur,
          @RequestParam("modeRecrutement") String modeRecrutement) {

      PropositionOffre newPropositionOffre = propositionOffreService.ajouterPropositionOffre(
              departement, jobTitle, coutEmbauche, duree, motifRecrutement, dateLancement, 
              dateEmbauche, recruteur, modeRecrutement);

      return new ResponseEntity<>(newPropositionOffre, HttpStatus.CREATED);
  }

  
  @PostMapping("/update") 
  
  public ResponseEntity<PropositionOffre> updatePropositionoffre(
          @RequestParam("idOffreProp") Long idOffreProp,
          @RequestParam("departement") String departement,
          @RequestParam("jobTitre") String jobTitre,
          @RequestParam("coutEmbauche") Double coutEmbauche,
          @RequestParam("duree") String duree,
          @RequestParam("motifRecretement") String motifRecretement,
          @RequestParam("dateLancement")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateLancement,
          @RequestParam("dateEmbauche")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEmbauche,
          @RequestParam("recruteur") String recruteur,
          @RequestParam("modeRecrutement") String modeRecrutement,
          @RequestParam("statusPropo") String statusPropo
          
          ) {
      
      try {
    	  PropositionOffre updatedPropositionoffre = propositionOffreService.updateOffre(
    			  idOffreProp,  departement,  jobTitre, coutEmbauche, duree,
    				motifRecretement, dateLancement, dateEmbauche,   recruteur,
    				  modeRecrutement, statusPropo);
          return new ResponseEntity<>(updatedPropositionoffre, HttpStatus.OK);
      } catch (EntityNotFoundException e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
  
  
  
  
  
  
  
  
  
  
  @PostMapping("/accept")
  public ResponseEntity<PropositionOffre> acceptPropositionOffre(@RequestParam("idProposition") Long idProposition) {
      PropositionOffre acceptedProposition = propositionOffreService.accepterPropositionOffre(idProposition);
      if (acceptedProposition != null) {
          return new ResponseEntity<>(acceptedProposition, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  @PostMapping("/reject")
  public ResponseEntity<PropositionOffre> rejectPropositionOffre(@RequestParam("idProposition") Long idProposition) {
      PropositionOffre rejectedProposition = propositionOffreService.refuserPropositionOffre(idProposition);
      if (rejectedProposition != null) {
          return new ResponseEntity<>(rejectedProposition, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
  @DeleteMapping("/delete/{idProposition}")
  public ResponseEntity<HttpResponse> deletePropositionOffre(@PathVariable("idProposition") Long idProposition) {
      propositionOffreService.deletePropositionOffre(idProposition);
      return response(HttpStatus.OK, "Proposition d'offre a été supprimée avec succès");
  }

  private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
      HttpResponse body = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase());
      return new ResponseEntity<>(body, httpStatus);
  }



}