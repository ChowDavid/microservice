package com.david.account.repository;

import com.david.account.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface AccountRepository extends CrudRepository<Account,Long> {
    Optional<Account> findByCustomerId(int customerId);
}
