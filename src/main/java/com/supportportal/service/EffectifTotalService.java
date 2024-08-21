package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.EffectifTotal;

public interface EffectifTotalService {
    EffectifTotal saveEffectifTotal(EffectifTotal effectifTotal);
    List<EffectifTotal> getAllEffectifTotals();
    EffectifTotal getEffectifTotalById(Long id);
    EffectifTotal updateEffectifTotal(Long id, EffectifTotal effectifTotal);
    void deleteEffectifTotal(Long id);
}
