package com.companymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companymanagement.constant.EmployeeUrlConstants;
import com.companymanagement.entity.Employee;
import com.companymanagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(EmployeeUrlConstants.ADDEMPLOYEE)
	public Employee addCompany(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping(EmployeeUrlConstants.LISTEMPLOYEE)
	public List<Employee> getAllCompanyDetails() {
		return employeeService.getAllEmployeeDetails();
	}

	@GetMapping(EmployeeUrlConstants.EMPLOYEE_ID)
	public Optional<Employee> getCompanyDetail(@PathVariable Long id) {
		return employeeService.getEmployeeDetails(id);
	}

	@DeleteMapping(EmployeeUrlConstants.EMPLOYEE_ID)
	public void deleteCompanyDetails(@PathVariable Long id) {
		employeeService.deleteEmployeeDetails(id);
	}

	@PutMapping(EmployeeUrlConstants.EMPLOYEE_ID)
	public Employee UpdateCompanyDetails(@RequestBody Employee employee, @PathVariable Long id) {

		return employeeService.updateEmployeeDetails(employee, id);
	}
}
