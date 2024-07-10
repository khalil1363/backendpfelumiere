package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.VisiteMedicale;

public interface VisiteMedicaleService {
	 VisiteMedicale saveVisiteMedicale(VisiteMedicale visiteMedicale);
	    List<VisiteMedicale> getAllVisiteMedicales();
	    VisiteMedicale getVisiteMedicaleById(Long id);
	    VisiteMedicale updateVisiteMedicale(VisiteMedicale visiteMedicale);
	    void deleteVisiteMedicale(Long id);
}
