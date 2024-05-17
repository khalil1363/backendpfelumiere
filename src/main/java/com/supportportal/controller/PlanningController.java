package com.supportportal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Planning;
import com.supportportal.service.PlanningService;


@RestController
@RequestMapping("/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @GetMapping("/getall")
    public List<Planning> getAllPlanning() {
        return planningService.getAllPlanning();
    }

    @GetMapping("getone/{idPlanning}")
    public Planning getPlanningById(@PathVariable Long idPlanning) {
        return planningService.getPlanningById(idPlanning);
    }

    @PostMapping("/add")
    public Planning savePlanning(@RequestBody Planning planning) {
        return planningService.savePlanning(planning);
    }

    @PutMapping("update/{idPlanning}")
    public Planning updatePlanning(@PathVariable Long idPlanning, @RequestBody Planning planning) {
        return planningService.savePlanning(planning);
    }

    @DeleteMapping("delete/{idPlanning}")
    public void deletePlanning(@PathVariable Long idPlanning) {
        planningService.deletePlanning(idPlanning);
    }
}