package com.springboot.airline.ecommerce.service;


import com.springboot.airline.ecommerce.model.PassengerCreationRequestDTO;
import com.springboot.airline.ecommerce.model.PassengerCreationResponseDTO;
import com.springboot.airline.ecommerce.model.PassengerDetailRequestDTO;
import com.springboot.airline.ecommerce.model.PassengerDetailResponseDTO;

public interface PassengerServiceInterface {

    /**
     * Method to create new passenger details
     *
     * @param passengerCreationRequest
     * @return PassengerCreationResponse
     */
    PassengerCreationResponseDTO createNewPassenger(PassengerCreationRequestDTO passengerCreationRequest) throws Exception;


    /**
     * Method to edit an existing passenger details
     *
     * @param passengerDetailRequest
     * @param passengerId
     * @return
     */
    PassengerDetailResponseDTO changePassengerDetails(PassengerDetailRequestDTO passengerDetailRequest, String passengerId);


    /**
     * Method to delete a passenger details
     *
     * @param passengerId
     */
    void deletePassenger(String passengerId);
}
