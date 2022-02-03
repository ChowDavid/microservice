package com.david.account.controller;

import com.david.account.config.AccountServiceConfig;
import com.david.account.feign.CardsFeignClient;
import com.david.account.feign.LoansFeignClient;
import com.david.account.model.Account;
import com.david.account.model.Customer;
import com.david.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer){
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
    
    
}
