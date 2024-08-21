package com.supportportal.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Candidat;
import com.supportportal.service.CandidatService;



@RestController
@RequestMapping("/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @GetMapping("/getall")
    public List<Candidat> getAllCandidats() {
        return candidatService.getAllCandidats();
    }

    @GetMapping("/{idCandidats}")
    public Candidat getCandidatById(@PathVariable Long idCandidats) {
        return candidatService.getCandidatById(idCandidats);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidat> addNewCandidat(
            @RequestParam("nomPrenom") String nomPrenom,
            @RequestParam("cin") String cin,
            @RequestParam("tel") String tel,
            @RequestParam("adresse") String adresse,
            @RequestParam("niveau") String niveau,
            @RequestParam("diplome") String diplome,
            @RequestParam("famille") String famille,
            @RequestParam("postPropose") String postPropose,
            @RequestParam("contact") String contact,
            @RequestParam("observation") String observation,
            @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date,
            @RequestParam(value = "offresEmploiIds", required = false) List<Long> offresEmploiIds) {

        Candidat newCandidat = candidatService.addCandidat(nomPrenom, cin, tel, adresse, niveau, diplome, famille, 
                                                            postPropose, contact, observation, date, offresEmploiIds);

        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }
    

    @PostMapping("/update")
    public ResponseEntity<Candidat> updateCandidat(
    		@RequestParam(value = "idCandidat") Long id,
            @RequestParam(value = "nomPrenom", required = false) String nomPrenom,
            @RequestParam(value = "cin", required = false) String cin,
            @RequestParam(value = "tel", required = false) String tel,
            @RequestParam(value = "adresse", required = false) String adresse,
            @RequestParam(value = "niveau", required = false) String niveau,
            @RequestParam(value = "diplome", required = false) String diplome,
            @RequestParam(value = "famille", required = false) String famille,
            @RequestParam(value = "postPropose", required = false) String postPropose,
            @RequestParam(value = "contact", required = false) String contact,
            @RequestParam(value = "observation", required = false) String observation,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date date
           ) {

        Candidat updatedCandidat = candidatService.updateCandidat(id, nomPrenom, cin, tel, adresse, niveau, diplome, famille, postPropose, contact, observation, date);
        return new ResponseEntity<>(updatedCandidat, HttpStatus.OK);
    }

   
    @DeleteMapping("/{idCandidats}")
    public void deleteCandidat(@PathVariable Long idCandidats) {
        candidatService.deleteCandidat(idCandidats);
    }
}