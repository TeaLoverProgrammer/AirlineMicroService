package com.springboot.airline.ecommerce.repo;

import com.springboot.airline.ecommerce.model.Account;

//in project only interface files are there and their corresponding xml repository.
public interface CustomerRepository {

    Account getAccount(String accountNumber);

}
