package com.david.account.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter @Setter @ToString
public class Loan {

    private int loanNumber;
    private int customerId;
    private LocalDate startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private LocalDate createDt;
}
