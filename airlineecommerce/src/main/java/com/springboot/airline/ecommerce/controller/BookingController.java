package com.springboot.airline.ecommerce.controller;

import com.springboot.airline.ecommerce.model.Flight;
import com.springboot.airline.ecommerce.service.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airline/booking")
@Validated
public class BookingController {

    @Autowired
    BookingServiceInterface bookingService;

    /**
     * Method to search flight
     */
    @GetMapping(value="/flight")
    List<Flight> searchFlights(){
        return bookingService.searchFlights();
    }
}
