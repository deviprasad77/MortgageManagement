package com.mortgage.customer.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="incomeAndProperty")
public class IncomeAndProperty {
	
	@Id
	@Column(name="customer_id")
	private int customerId;
	private String typeOfEmployment;
	private String organizationType;
	private long income;
	private int retirementAge;


	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customerId = customer_Id;
	}
	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}
	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public int getRetirementAge() {
		return retirementAge;
	}
	public void setRetirementAge(int retirementAge) {
		this.retirementAge = retirementAge;
	}
	
	

}
