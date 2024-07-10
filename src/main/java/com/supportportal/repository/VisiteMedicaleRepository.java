package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.entity.VisiteMedicale;

@Repository
public interface VisiteMedicaleRepository extends JpaRepository<VisiteMedicale, Long> {
}
