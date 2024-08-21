package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.EffectifTotal;
import com.supportportal.repository.EffectifTotalRepository;
import com.supportportal.service.EffectifTotalService;

@Service
public class EffectifTotalServiceImpl implements EffectifTotalService {

    @Autowired
    private EffectifTotalRepository effectifTotalRepository;

    @Override
    public EffectifTotal saveEffectifTotal(EffectifTotal effectifTotal) {
        return effectifTotalRepository.save(effectifTotal);
    }

    @Override
    public List<EffectifTotal> getAllEffectifTotals() {
        return effectifTotalRepository.findAll();
    }

    @Override
    public EffectifTotal getEffectifTotalById(Long id) {
        return effectifTotalRepository.findById(id).orElseThrow(() -> new RuntimeException("EffectifTotal not found"));
    }

    @Override
    public EffectifTotal updateEffectifTotal(Long id, EffectifTotal effectifTotal) {
        EffectifTotal existingEffectifTotal = getEffectifTotalById(id);
        existingEffectifTotal.setEffectiveTotal(effectifTotal.getEffectiveTotal());
        return effectifTotalRepository.save(existingEffectifTotal);
    }

    @Override
    public void deleteEffectifTotal(Long id) {
        effectifTotalRepository.deleteById(id);
    }
}