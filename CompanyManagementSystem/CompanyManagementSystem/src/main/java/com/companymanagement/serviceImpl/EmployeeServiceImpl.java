package com.companymanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companymanagement.entity.Employee;
import com.companymanagement.exception.ResourceNotFoundException;
import com.companymanagement.repository.EmployeeRepository;
import com.companymanagement.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		 return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeDetails(Long id) {
		Employee employee = null;
		Optional<Employee> optionalemployee = employeeRepository.findById(id);
		if (optionalemployee.isPresent()) {
			employee = optionalemployee.get();
		}
		return Optional.of(employee);

	}

	@Override
	public void deleteEmployeeDetails(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee,Long employeeId) {
		Employee updateEmployeeDetails = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",employeeId));
		updateEmployeeDetails.setName(employee.getName());
		updateEmployeeDetails.setAddress(employee.getAddress());
		updateEmployeeDetails.setGender(employee.getGender());
		updateEmployeeDetails.setContact(employee.getContact());
		updateEmployeeDetails.setDesignation(employee.getDesignation());
        updateEmployeeDetails.setEmail(employee.getEmail());
       	employeeRepository.save(updateEmployeeDetails);

		return updateEmployeeDetails;
	}

}
