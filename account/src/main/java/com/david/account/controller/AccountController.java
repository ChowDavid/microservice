package com.david.account.controller;

import com.david.account.config.AccountServiceConfig;
import com.david.account.feign.CardsFeignClient;
import com.david.account.feign.LoansFeignClient;
import com.david.account.model.Account;
import com.david.account.model.Customer;
import com.david.account.repository.AccountRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountServiceConfig config;
    @Autowired
    private CardsFeignClient cardsFeignClient;
    @Autowired
    private LoansFeignClient loansFeignClient;

    @CircuitBreaker(name="detailsApiCall", fallbackMethod = "fallbackMethod")
    //@Retry(name="myRtry", fallbackMethod = "fallbackMethod")
    @Timed(value="getAccountDetails.time", description="Custom metric forAccount Details")
    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestHeader("correlation-id") String header, @RequestBody Customer customer){
        log.info("correlationId {}", header);
    	log.info(customer.toString());
        log.info("config {}",config);
        Optional<Account> account=accountRepository.findByCustomerId(customer.getCustomerId());
        
        if(account.isPresent()){
        	log.info(cardsFeignClient.getCardDetails(customer).get(0).toString());
            log.info(loansFeignClient.getLoanDetails(customer).get(0).toString());
            return account.get();
        } else {
            return null;
        }
    }
    
    private Account fallbackMethod(String header, Customer customer, Throwable t) {
    	log.info("fall back method was called");
    	log.info(customer.toString());
        log.info("config {}",config);
        Optional<Account> account=accountRepository.findByCustomerId(customer.getCustomerId());
        
        if(account.isPresent()){
            return account.get();
        } else {
            return null;
        }
    }
    
    @RateLimiter(name = "myRate", fallbackMethod = "fallbackRate")
    @GetMapping("/getHello")
    public String getHello() {
    	return "Hello";
    	
    }
    
    private String fallbackRate(Throwable t) {
    	return "FallBackRate";
    }
    
    
}
