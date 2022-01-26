package com.david.account.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Customer {
    @Id
    private int customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDt;

}
