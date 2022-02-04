package com.david.loan.controller;

import com.david.loan.dto.Customer;
import com.david.loan.model.Loan;
import com.david.loan.repository.LoanRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;


    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody Customer customer){
    	log.info("Rest Called");
        Optional<List<Loan>> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans.isPresent()){
        	try {
        		Thread.sleep(5000);
        	} catch (Exception e) {
        		//Nothing to do
        	}
            return loans.get();
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
