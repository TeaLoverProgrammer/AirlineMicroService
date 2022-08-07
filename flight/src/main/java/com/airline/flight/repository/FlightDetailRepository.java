package com.airline.flight.repository;

import com.airline.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDetailRepository extends JpaRepository<Flight,String> {


}
