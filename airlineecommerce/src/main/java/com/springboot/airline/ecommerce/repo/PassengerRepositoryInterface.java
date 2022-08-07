package com.springboot.airline.ecommerce.repo;

import com.springboot.airline.ecommerce.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepositoryInterface extends JpaRepository<Passenger, String> {

    List<Passenger> findByFirstnameAndLastname(String firstName, String lastName);
}
