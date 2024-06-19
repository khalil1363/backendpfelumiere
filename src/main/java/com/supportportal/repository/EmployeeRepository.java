package com.supportportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.entity.Employee;
import com.supportportal.entity.Formation;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findEmployeeByMat (String mat);
	
	List<Employee> findByNomPrenomContaining(String name);
	
	Optional<Employee> findByNomPrenom(String employeeName);
}

