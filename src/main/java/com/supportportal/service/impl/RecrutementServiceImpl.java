package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Recrutement;
import com.supportportal.repository.RecrutementRepository;
import com.supportportal.service.RecrutementService;



@Service
public class RecrutementServiceImpl implements RecrutementService {

    @Autowired
    private RecrutementRepository recrutementRepository;

    @Override
    public Recrutement saveRecrutement(Recrutement recrutement) {
        return recrutementRepository.save(recrutement);
    }

    @Override
    public List<Recrutement> findAllRecruitments() {
        return recrutementRepository.findAll();
    }

    @Override
    public Recrutement findByIdRecrutement(Long idRecrutement) {
        return recrutementRepository.findById(idRecrutement).orElse(null);
    }

    @Override
    public void deleteRecrutement(Long idRecrutement) {
        recrutementRepository.deleteById(idRecrutement);
    }

	@Override
	public Recrutement updateRecrutement(Recrutement recrutement) {
		return null;
	}
    
}
