package com.mortgage.customer.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.customer.service.entity.Address;
import com.mortgage.customer.service.entity.Customer;
import com.mortgage.customer.service.entity.IncomeAndProperty;
import com.mortgage.customer.service.entity.MortgageLoan;
import com.mortgage.customer.service.entity.PropertyDocument;
import com.mortgage.customer.service.entity.TypesOfMortgageLoans;
import com.mortgage.customer.service.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@ApiOperation(value = "Save Customer Details", response = Customer.class, tags = "Enter Customer Details")
	@PostMapping("/CustomerDetails")
	public ResponseEntity<Customer> customerDetails(@RequestBody Customer customer) {

		Customer newCustomer = customerService.saveCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}


	
	@ApiOperation(value = "Save Address Customer Details", response = Address.class, tags = "Enter AdressDetails")
	@PostMapping("/LocationDetails")
	public ResponseEntity<Address> addressDetails(@RequestBody Address address) {

		Address customerAddress = customerService.saveCustomerAdress(address);
		ResponseEntity<Address> responseEntity = new ResponseEntity<>(customerAddress, HttpStatus.CREATED);
		return responseEntity;
	}
	@ApiOperation(value = "Mortgage Loan Details", response = MortgageLoan.class, tags = "MortgageLoan")
	@PostMapping("/MortgageLoan")
	public ResponseEntity<MortgageLoan> mortgageLoan(@RequestBody MortgageLoan mortgageLoan) {

		MortgageLoan newMortgageLoan =customerService.saveMortgageLoan(mortgageLoan);
		ResponseEntity<MortgageLoan> responseEntity = new ResponseEntity<>(newMortgageLoan, HttpStatus.CREATED);
		return responseEntity;
	}
	

	 
	@ApiOperation(value = "See TypesOfMortgageLoans Details", response = TypesOfMortgageLoans.class, tags = "view TypesOfMortgageLoans")
	@GetMapping("/all")
	public List<TypesOfMortgageLoans> fetchAll(TypesOfMortgageLoans typesOfMortgageLoans) {
		List<TypesOfMortgageLoans> TypesOfMortgageLoans = customerService.getAllTypesOfLoans();
		return TypesOfMortgageLoans;
	}
	
	@ApiOperation(value = "Enter IncomeAndProperty Details", response = IncomeAndProperty.class, tags = "Enter IncomeAndProperty Details")
	@PostMapping("/Income")
	public ResponseEntity<IncomeAndProperty> income(@RequestBody IncomeAndProperty incomeAndProperty) {
		
		IncomeAndProperty newIncomeAndProperty= customerService.saveIncomeAndProperty(incomeAndProperty);
		ResponseEntity<IncomeAndProperty> responseEntity = new ResponseEntity<>(newIncomeAndProperty, HttpStatus.CREATED);
		
		return responseEntity;
		
	}
	@ApiOperation(value = "Enter PropertyDocument Details", response = PropertyDocument.class, tags = "Enter PropertyDocument Details")
	@PostMapping("/Property")
	public ResponseEntity<PropertyDocument> property(@RequestBody PropertyDocument propertyDocument) {
		PropertyDocument newPropertyDocument=customerService.savePropertyDocument(propertyDocument);
ResponseEntity<PropertyDocument> responseEntity = new ResponseEntity<>(newPropertyDocument, HttpStatus.CREATED);
		
		return responseEntity;
	}
}
