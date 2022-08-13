package com.airline.flight.service;

import com.airline.flight.exception.ResourceNotFoundException;
import com.airline.flight.model.Flight;
import com.airline.flight.repository.FlightDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightDetailService implements  FlightDetailServiceInterface{

    @Autowired
    FlightDetailRepository flightRepository;

    /**
     * Fetch all available flights
     * @return
     */
    @Override
    public List<Flight> getAllFlights() {

        return flightRepository.findAll().stream()
                .filter(flight -> flight.isSeatAvailableFlag())
                .collect(Collectors.toList());
    }

    /**
     * Fetch detail for the given flight id
     *
     * @return Flight
     */
    @Override
    public Flight getFlightDetail(String flightId) {
        Flight flightDetail =  Optional.ofNullable(flightRepository.findById(flightId).get())
                .orElseThrow(() -> new ResourceNotFoundException("Flight details not found"));
        return flightDetail;
    }

    /**
     * Insert flight details
     *
     */
    @Override
    public void insertFlightDetail(Flight flightDetail) {
        flightRepository.save(flightDetail);
    }




}
