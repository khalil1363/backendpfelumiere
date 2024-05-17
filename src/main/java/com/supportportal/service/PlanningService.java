package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Planning;



public interface PlanningService {

    List<Planning> getAllPlanning();

    Planning getPlanningById(Long idPlanning);

    Planning savePlanning(Planning planning);

    void deletePlanning(Long idPlanning);
}