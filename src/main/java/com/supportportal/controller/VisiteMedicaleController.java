package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.VisiteMedicale;
import com.supportportal.service.VisiteMedicaleService;

@RestController
@RequestMapping("/visitemedicale")
public class VisiteMedicaleController {

    @Autowired
    private VisiteMedicaleService visiteMedicaleService;

    @PostMapping("/add")
    public VisiteMedicale createVisiteMedicale(@RequestBody VisiteMedicale visiteMedicale) {
        return visiteMedicaleService.saveVisiteMedicale(visiteMedicale);
    }

    @GetMapping("/list")
    public List<VisiteMedicale> getAllVisiteMedicales() {
        return visiteMedicaleService.getAllVisiteMedicales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisiteMedicale> getVisiteMedicaleById(@PathVariable Long id) {
        VisiteMedicale visiteMedicale = visiteMedicaleService.getVisiteMedicaleById(id);
        if (visiteMedicale == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(visiteMedicale);
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisiteMedicale(@PathVariable Long id) {
        VisiteMedicale visiteMedicale = visiteMedicaleService.getVisiteMedicaleById(id);
        if (visiteMedicale == null) {
            return ResponseEntity.notFound().build();
        }

        visiteMedicaleService.deleteVisiteMedicale(id);
        return ResponseEntity.noContent().build();
    }
}