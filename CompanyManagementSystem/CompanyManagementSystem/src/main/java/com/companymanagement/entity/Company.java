package com.companymanagement.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	private String companyName;

	private String companyAddress;
	
	private String companyEmail;
	
	private Long companyContact;
	
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
	@JoinColumn(name="ce_fk",referencedColumnName = "company_id")
	private Collection<Employee> employee = new ArrayList<Employee>();

	
}
