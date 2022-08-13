package com.airline.flight.controller;

import com.airline.flight.model.Flight;
import com.airline.flight.service.FlightDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline/flight")
@Validated
public class FlightDetailController {

    @Autowired
    FlightDetailService flightDetailService;

    /**
     * Get all flight details
     *
     * response:: List of available flights
     */
    @GetMapping
    List<Flight> fetchAllFlights(){
        return flightDetailService.getAllFlights();
    }

    /**
     * Get flight details for the given id
     *
     */
    @GetMapping(value="/{flightId}")
    Flight fetchFlightDetail(@PathVariable("flightId") final String flightId){
        return flightDetailService.getFlightDetail(flightId);
    }

    /**
     * Insert flight details. Only for admin users
     *
     */
    @PostMapping
    void addFlight(@RequestBody final Flight flightDetail){
        flightDetailService.insertFlightDetail(flightDetail);
    }

}
