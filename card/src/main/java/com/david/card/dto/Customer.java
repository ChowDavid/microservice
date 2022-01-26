package com.david.card.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter @Setter @ToString
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDt;

}
