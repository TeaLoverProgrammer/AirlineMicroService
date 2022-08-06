package com.springboot.airline.ecommerce.repo;

import com.springboot.airline.ecommerce.model.Account;
import org.springframework.stereotype.Repository;

//to be removed with xml files with iBatis.

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{


    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }
}
