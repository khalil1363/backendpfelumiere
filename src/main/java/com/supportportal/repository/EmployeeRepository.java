package com.supportportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportportal.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findEmployeeByMat (String mat);
	List<Employee> findByNomPrenomContaining(String name);
}

