package com.springboot.airline.ecommerce.repo;

import com.springboot.airline.ecommerce.model.Flight;

import java.util.List;

public interface FlightRepositoryInterface {

    List<Flight> searchFlights();
}
