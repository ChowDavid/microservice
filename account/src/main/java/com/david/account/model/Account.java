package com.david.account.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Account {
    private int customerId;
    @Id
    private long accountNumber;
    private String accountType;
    private String branchAddress;
    private LocalDate createDt;

}
