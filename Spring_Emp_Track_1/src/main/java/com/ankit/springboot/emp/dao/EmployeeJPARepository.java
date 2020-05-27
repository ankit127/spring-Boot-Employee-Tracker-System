package com.ankit.springboot.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankit.springboot.emp.entity.Employee;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

	
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
