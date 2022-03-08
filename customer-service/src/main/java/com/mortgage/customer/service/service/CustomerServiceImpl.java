package com.mortgage.customer.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.mortgage.customer.service.repository.MortgageLoanRepository;
import com.mortgage.customer.service.repository.PropertyDocumentRepository;
import com.mortgage.customer.service.repository.TypesOfMortgageLoansRepository;

import org.springframework.stereotype.Service;

import com.mortgage.customer.service.entity.Address;
import com.mortgage.customer.service.entity.Customer;
import com.mortgage.customer.service.entity.IncomeAndProperty;
import com.mortgage.customer.service.entity.MortgageLoan;
import com.mortgage.customer.service.entity.PropertyDocument;
import com.mortgage.customer.service.entity.TypesOfMortgageLoans;
import com.mortgage.customer.service.exception.CustomerNotFoundException;
import com.mortgage.customer.service.repository.AddressRepository;
import com.mortgage.customer.service.repository.CustomerRepository;
import com.mortgage.customer.service.repository.IncomeAndPropertyRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private MortgageLoanRepository mortgageLoanRepository;
	
	@Autowired
	private IncomeAndPropertyRepository incomeAndPropertyRepository;
	
	@Autowired
	private PropertyDocumentRepository propertyDocumentRepository;
	
	@Autowired
	private TypesOfMortgageLoansRepository typesOfMortgageLoansRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}

	@Override
	public Address saveCustomerAdress(Address address) {
		Address savedCustomer = addressRepository.save(address);
		return savedCustomer;
	}

	@Override
	public MortgageLoan saveMortgageLoan(MortgageLoan mortgageLoan) {
		MortgageLoan saveMortgageLoan = mortgageLoanRepository.save(mortgageLoan);
		return saveMortgageLoan;
	}

	@Override
	public IncomeAndProperty saveIncomeAndProperty(IncomeAndProperty incomeAndProperty) {
		IncomeAndProperty saveIncomeAndProperty = incomeAndPropertyRepository.save(incomeAndProperty);
		return saveIncomeAndProperty;
	}

	@Override
	public PropertyDocument savePropertyDocument(PropertyDocument propertyDocument) {
		PropertyDocument savePropertyDocument = propertyDocumentRepository.save(propertyDocument);
		return savePropertyDocument;
	}

	@Override
	public List<TypesOfMortgageLoans> getAllTypesOfLoans() {
		List<TypesOfMortgageLoans> typesOfMortgageLoans=typesOfMortgageLoansRepository.findAll();
		return typesOfMortgageLoans;
	}

	@Override
	public MortgageLoan getMortgageLoanById(int customerId)  {
		Optional<MortgageLoan> loan =mortgageLoanRepository.findById(customerId);
		if(loan.isEmpty()) {
			throw new CustomerNotFoundException("Sorry! Customer not found with id" + customerId);
		}
		return loan.get();
	}
	
	

	

}
