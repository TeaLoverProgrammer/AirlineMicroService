package com.springboot.airline.ecommerce.model;

import java.math.BigDecimal;
import java.util.List;

public class Account {

    private String accountNo;

    private BigDecimal balance;

    private List<Transaction> transactionList;
}
