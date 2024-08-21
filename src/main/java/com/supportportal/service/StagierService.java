package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Stagier;



public interface StagierService {

    List<Stagier> getAllStagiers();

    Stagier getStagierById(Long idStagier);

  

    void deleteStagier(Long idStagier);

	Stagier ajouterStagier(String nomPrenom, String institut, String diplome, String specialite, String cin, String societe, String tel,
			String superviseurMatricule, String stageRef);

	Stagier updateStagier(String cin, String nomPrenom,  String societe, String institut, String diplome, String specialite, String tel,
			String superviseurMatricule, String stageRef);
}