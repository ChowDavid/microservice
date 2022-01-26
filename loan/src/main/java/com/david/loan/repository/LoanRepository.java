package com.david.loan.repository;

import com.david.loan.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Long> {
    Optional<List<Loan>> findByCustomerIdOrderByStartDtDesc(int customerId);
}
