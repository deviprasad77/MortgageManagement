package com.mortgage.customer.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mortgage.customer.service.entity.MortgageLoan;
import com.mortgage.customer.service.repository.MortgageLoanRepository;
import com.mortgage.customer.service.service.CustomerService;
import com.mortgage.customer.service.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerservice =new CustomerServiceImpl();
	
	@Mock
	private MortgageLoanRepository mortgageRepository;
	
	@Test
	public void testGetByCustomerId() {
		
		MortgageLoan mortgageLoan =new MortgageLoan();
		mortgageLoan.setCustomerId(1);
		mortgageLoan.setLoanAmount(1000000);
		mortgageLoan.setTenure(12);
		mortgageLoan.setTypeofMortgage("PropertyLoan");
		mortgageLoan.setApprovalStatus("Approved");
		
		Optional<MortgageLoan> optionalMortgageLoan = Optional.of(mortgageLoan);
		int customerId = 2;
		
		when(mortgageRepository.findById(2)).thenReturn(optionalMortgageLoan);
		
		MortgageLoan existingMortgageLoan = customerservice.getMortgageLoanById(customerId);
		
		assertEquals(mortgageLoan.getCustomerId(),existingMortgageLoan.getCustomerId());
		assertEquals(mortgageLoan.getLoanAmount(),existingMortgageLoan.getLoanAmount());
		assertEquals(mortgageLoan.getTenure(),existingMortgageLoan.getTenure());
		assertEquals(mortgageLoan.getTypeofMortgage(),existingMortgageLoan.getTypeofMortgage());
		assertEquals(mortgageLoan.getApprovalStatus(),existingMortgageLoan.getApprovalStatus());
	}

		
	}

