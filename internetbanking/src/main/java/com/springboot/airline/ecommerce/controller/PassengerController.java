package com.springboot.airline.ecommerce.controller;



import com.springboot.airline.ecommerce.exception.PassengerDuplicationException;
import com.springboot.airline.ecommerce.model.*;
import com.springboot.airline.ecommerce.service.PassengerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@RestController
@RequestMapping("/airline/passenger")
@Validated
public class PassengerController {

    @Autowired
    PassengerServiceInterface passengerService;


   /**
     * Create a new passenger
     *
     * request:: passenger details
     * response:: returns passengerId provided passenger didnot exist in the repo before
     * exception:: if passenger already exists.
     */
    @PostMapping
    public PassengerCreationResponseDTO addPassenger (@Validated @RequestBody

                                                       final PassengerCreationRequestDTO passengerCreationRequest){
        PassengerCreationResponseDTO response = new PassengerCreationResponseDTO();
        try{
            response = passengerService.createNewPassenger(passengerCreationRequest);
        } catch (Exception e) {
            ErrorList errorList =  ErrorList.builder()
                                   .errorID("422-001")
                                   .errorMessage("Passenger with similar details already exists")
                                   .build();
            response.setErrorDetailsList(Arrays.asList(errorList));
        }

        return response;
    }

    /**
     * Edit existing passenger details
     *
     * request:: passenger details
     * response:: returns 200 if success
     * exception:: if passenger does not exist.
     */
    @PutMapping(value="/{passengerId}")
    public PassengerDetailResponseDTO editPassenger(@RequestBody @Validated
                                                      final PassengerDetailRequestDTO passengerDetailRequest,
                                                    @PathVariable("passengerId") String passengerId){

        return passengerService.changePassengerDetails(passengerDetailRequest, passengerId);
    }

    /**
     * Delete existing passenger details
     *
     * response:: returns 200 if success
     * exception:: if passenger does not exist.
     */
    @DeleteMapping(value="/{passengerId}")
    public void deletePassenger (@PathVariable("passengerId") String passengerId){
         passengerService.deletePassenger(passengerId);
    }



}
