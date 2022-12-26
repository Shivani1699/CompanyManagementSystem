package com.companymanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companymanagement.entity.Company;
import com.companymanagement.exception.ResourceNotFoundException;
import com.companymanagement.repository.CompanyRepository;
import com.companymanagement.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		return companyRepository.findAll();
	}

	@Override
	public Optional<Company> getCompanyDetail(Long id) {
		Company company = null;
		Optional<Company> optionalcompany = companyRepository.findById(id);
		if (optionalcompany.isPresent()) {
			company = optionalcompany.get();
		}
		return Optional.of(company);
	}

	@Override
	public void deleteCompanyDetails(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public Company UpdateCompanyDetails(Company company, Long id) {

		Company updateCompanyDetails = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company", "ID", id));
		updateCompanyDetails.setCompanyName(company.getCompanyName());
		updateCompanyDetails.setCompanyAddress(company.getCompanyAddress());
		updateCompanyDetails.setCompanyEmail(company.getCompanyEmail());
		updateCompanyDetails.setCompanyContact(company.getCompanyContact());
		return updateCompanyDetails;
	}
}
