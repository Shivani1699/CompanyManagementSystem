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

import com.companymanagement.constant.CompanyUrlConstants;
import com.companymanagement.entity.Company;
import com.companymanagement.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(CompanyUrlConstants.ADDCOMPANY)
	public Company addCompany(@RequestBody Company company) {
		return companyService.addCompany(company);
	}

	@GetMapping(CompanyUrlConstants.LISTCOMPANY)
	public List<Company> getAllCompanyDetails() {
		return companyService.getAllCompanyDetails();
	}

	@GetMapping(CompanyUrlConstants.COMPANY_ID)
	public Optional<Company> getCompanyDetail(@PathVariable Long id) {
		return companyService.getCompanyDetail(id);
	}

	@DeleteMapping(CompanyUrlConstants.COMPANY_ID)
	public void deleteCompanyDetails(@PathVariable Long id) {
		companyService.deleteCompanyDetails(id);
	}

	@PutMapping(CompanyUrlConstants.COMPANY_ID)
	public Company UpdateCompanyDetails(@RequestBody Company Company ,@PathVariable Long id) {

		return companyService.UpdateCompanyDetails(Company,id);
	}
}
