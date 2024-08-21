package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.entity.Chauffeur;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}