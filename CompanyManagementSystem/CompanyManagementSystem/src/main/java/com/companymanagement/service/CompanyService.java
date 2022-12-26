package com.companymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.companymanagement.entity.Company;

@Service
public interface CompanyService {
	
	    public Company addCompany(Company company);
	    
	    public List<Company> getAllCompanyDetails();
	    
	    public Optional<Company> getCompanyDetail(Long id);
	    
	    public void deleteCompanyDetails(Long id); 
	   
	    public Company UpdateCompanyDetails(Company company,Long id);
		   
}
