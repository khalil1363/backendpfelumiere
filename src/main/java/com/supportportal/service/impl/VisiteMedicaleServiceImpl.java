package com.supportportal.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.VisiteMedicale;
import com.supportportal.repository.VisiteMedicaleRepository;
import com.supportportal.service.VisiteMedicaleService;

import java.util.List;

@Service
public class VisiteMedicaleServiceImpl implements VisiteMedicaleService {

    @Autowired
    private VisiteMedicaleRepository visiteMedicaleRepository;

    @Override
    public VisiteMedicale saveVisiteMedicale(VisiteMedicale visiteMedicale) {
        return visiteMedicaleRepository.save(visiteMedicale);
    }

    @Override
    public List<VisiteMedicale> getAllVisiteMedicales() {
        return visiteMedicaleRepository.findAll();
    }

    @Override
    public VisiteMedicale getVisiteMedicaleById(Long id) {
        return visiteMedicaleRepository.findById(id).orElse(null);
    }

    @Override
    public VisiteMedicale updateVisiteMedicale(VisiteMedicale visiteMedicale) {
        return visiteMedicaleRepository.save(visiteMedicale);
    }

    @Override
    public void deleteVisiteMedicale(Long id) {
        visiteMedicaleRepository.deleteById(id);
    }
}