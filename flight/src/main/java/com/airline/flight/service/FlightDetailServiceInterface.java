package com.airline.flight.service;

import com.airline.flight.model.Flight;

import java.util.List;

public interface FlightDetailServiceInterface {
    /**
     * Method to fetch all flight details
     * @return
     */
     List<Flight> getAllFlights();

    /**
     * Method to fetch a particular flight detail
     * @param flightId
     * @return
     */
    Flight getFlightDetail(String flightId);

    /**
     * Method to insert flight detail
     *
     * @return
     */
    void insertFlightDetail(Flight flightDetail);

}
