package com.companymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.companymanagement.entity.Employee;


@Service
public interface EmployeeService {

   	    public Employee addEmployee(Employee employee);
	    
	    public List<Employee> getAllEmployeeDetails();
	    
	    public Optional<Employee> getEmployeeDetails(Long id);
	    
	    public void deleteEmployeeDetails(Long id); 
	    
        public Employee updateEmployeeDetails(Employee employee, Long id);
	   
	    
}
