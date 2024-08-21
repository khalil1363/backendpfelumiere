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

import com.supportportal.entity.OffreEmploi;
import com.supportportal.entity.PropositionOffre;
import com.supportportal.service.OffreEmploiService;



@RestController
@RequestMapping("/offresEmploi")
public class OffreEmploiController {

    @Autowired
    private OffreEmploiService offreEmploiService;

    @GetMapping("/getall")
    public List<OffreEmploi> getAllOffresEmploi() {
        return offreEmploiService.getAllOffresEmploi();
    }

    @GetMapping("/{idOffreEmploi}")
    public OffreEmploi getOffreEmploiById(@PathVariable Long idOffreEmploi) {
        return offreEmploiService.getOffreEmploiById(idOffreEmploi);
    }

    @PostMapping("/add")
    public OffreEmploi saveOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        return offreEmploiService.saveOffreEmploi(offreEmploi);
    }

    
    
    

    @PostMapping("/update") 
    
    public ResponseEntity<OffreEmploi> updatePropositionoffre(
            @RequestParam("idOffreEmploi") Long idOffreEmploi,
            @RequestParam("departement") String departement,
            @RequestParam("jobTitre") String jobTitre,
            @RequestParam("coutEmbauche") Double coutEmbauche,
            @RequestParam("duree") String duree,
            @RequestParam("motifRecretement") String motifRecretement,
            @RequestParam("dateLancement")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateLancement,
            @RequestParam("dateEmbauche")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEmbauche,
            @RequestParam("recruteur") String recruteur,
            @RequestParam("modeRecrutement") String modeRecrutement,
            @RequestParam("statusOffre") String statusOffre
            
            ) {
        
        try {
        	OffreEmploi updatedPropositionoffre = offreEmploiService.updateOffre(
        			idOffreEmploi,  departement,  jobTitre, coutEmbauche, duree,
      				motifRecretement, dateLancement, dateEmbauche,   recruteur,
      				  modeRecrutement, statusOffre);
            return new ResponseEntity<>(updatedPropositionoffre, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    
    
    
    
   
    @DeleteMapping("/{idOffreEmploi}")
    public void deleteOffreEmploi(@PathVariable Long idOffreEmploi) {
        offreEmploiService.deleteOffreEmploi(idOffreEmploi);
    }
    
    
  
    
    
    
    
    
    
}