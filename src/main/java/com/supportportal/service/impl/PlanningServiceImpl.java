package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Planning;
import com.supportportal.repository.PlanningRepository;
import com.supportportal.service.PlanningService;


@Service
public class PlanningServiceImpl implements PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    @Override
    public List<Planning> getAllPlanning() {
        return planningRepository.findAll();
    }

    @Override
    public Planning getPlanningById(Long idPlanning) {
        return planningRepository.findById(idPlanning).orElse(null);
    }

    @Override
    public Planning savePlanning(Planning planning) {
        return planningRepository.save(planning);
    }

    @Override
    public void deletePlanning(Long idPlanning) {
        planningRepository.deleteById(idPlanning);
    }
}