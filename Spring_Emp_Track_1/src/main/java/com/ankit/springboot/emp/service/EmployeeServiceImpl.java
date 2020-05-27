package com.ankit.springboot.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.springboot.emp.dao.EmployeeJPARepository;
import com.ankit.springboot.emp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeJPARepository employeeJPARepository;

	public EmployeeServiceImpl(EmployeeJPARepository theEmployeeJPARepository) {
		this.employeeJPARepository = theEmployeeJPARepository;
	}

	public List<Employee> findAll() {

		return  employeeJPARepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeJPARepository.findById(theId);

		Employee theEmployee = null;

		
		if (result.isPresent()) {
			
			 theEmployee = result.get();

		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;

	}

	@Override
	public void save(Employee theEmployee) {

          employeeJPARepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {

		employeeJPARepository.deleteById(theId);

	}

	@Override
	public List<Employee> searchBy(String theName) {
     List<Employee> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = employeeJPARepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
		
			results = findAll();
			System.out.println("In Search Method : " +results.size());
		}
		
		return results;	}

}
