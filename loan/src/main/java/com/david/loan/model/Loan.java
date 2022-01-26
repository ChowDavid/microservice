package com.david.loan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Loan {
    @Id
    private int loanNumber;
    private int customerId;
    private LocalDate startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private LocalDate createDt;
}
