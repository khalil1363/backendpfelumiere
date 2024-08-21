package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Chauffeur;
import com.supportportal.service.ChauffeurService;

@RestController
@RequestMapping("/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @GetMapping("/list")
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chauffeur> getChauffeurById(@PathVariable Long id) {
        Chauffeur chauffeur = chauffeurService.getChauffeurById(id);
        if (chauffeur != null) {
            return ResponseEntity.ok(chauffeur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Chauffeur createChauffeur(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.createChauffeur(chauffeur);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Chauffeur> updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur chauffeur) {
        Chauffeur updatedChauffeur = chauffeurService.updateChauffeur(id, chauffeur);
        if (updatedChauffeur != null) {
            return ResponseEntity.ok(updatedChauffeur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChauffeur(@PathVariable Long id) {
        chauffeurService.deleteChauffeur(id);
        return ResponseEntity.noContent().build();
    }
}