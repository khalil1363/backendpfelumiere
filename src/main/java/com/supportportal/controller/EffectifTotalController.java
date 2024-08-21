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

import com.supportportal.entity.EffectifTotal;
import com.supportportal.service.EffectifTotalService;

@RestController
@RequestMapping("/effectifTotal")
public class EffectifTotalController {

    @Autowired
    private EffectifTotalService effectifTotalService;

    @PostMapping
    public EffectifTotal createEffectifTotal(@RequestBody EffectifTotal effectifTotal) {
        return effectifTotalService.saveEffectifTotal(effectifTotal);
    }

    @GetMapping
    public List<EffectifTotal> getAllEffectifTotals() {
        return effectifTotalService.getAllEffectifTotals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EffectifTotal> getEffectifTotalById(@PathVariable Long id) {
        EffectifTotal effectifTotal = effectifTotalService.getEffectifTotalById(id);
        return ResponseEntity.ok(effectifTotal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EffectifTotal> updateEffectifTotal(@PathVariable Long id, @RequestBody EffectifTotal effectifTotal) {
        EffectifTotal updatedEffectifTotal = effectifTotalService.updateEffectifTotal(id, effectifTotal);
        return ResponseEntity.ok(updatedEffectifTotal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEffectifTotal(@PathVariable Long id) {
        effectifTotalService.deleteEffectifTotal(id);
        return ResponseEntity.noContent().build();
    }
}