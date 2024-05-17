package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.supportportal.entity.Formation;
import com.supportportal.service.FormationService;



@RestController
@RequestMapping("/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @PostMapping
    public ResponseEntity<Formation> createFormation(@Validated @RequestBody Formation formation) {
        Formation savedFormation = formationService.saveFormation(formation);
        return new ResponseEntity<>(savedFormation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.findAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
        Formation formation = formationService.findByIdFormation(id);
        if (formation != null) {
            return new ResponseEntity<>(formation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @Validated @RequestBody Formation formation) {
        if (!id.equals(formation.getIdFormation())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // IDs don't match
        }

        Formation updatedFormation = formationService.updateFormation(formation);
        if (updatedFormation != null) {
            return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}