package com.springboot.airline.ecommerce.service;


import com.springboot.airline.ecommerce.exception.PassengerDuplicationException;
import com.springboot.airline.ecommerce.model.*;
import com.springboot.airline.ecommerce.repo.PassengerRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PassengerService implements PassengerServiceInterface {

    @Autowired
    protected Passenger passenger;

    @Autowired
    protected Mapper mapper;

    @Autowired
    protected PassengerRepository passengerRepository;


    /**
     * Method to add a new passenger
     *
     * @param passengerCreationRequest
     * @return
     */
    @Override
    public PassengerCreationResponseDTO createNewPassenger(PassengerCreationRequestDTO passengerCreationRequest)  {

        final Passenger newPassenger = mapper.map(passengerCreationRequest, Passenger.class);

        if(checkexistsPassenger(newPassenger)){
            throw new PassengerDuplicationException("Passenger already exists!");
        }

        String passengerId = UUID.randomUUID().toString();
        newPassenger.setPassengerId(passengerId);

        passengerRepository.insertPassenger(newPassenger);

        final PassengerCreationResponseDTO passengerCreationResponse = mapper.map(newPassenger,
                PassengerCreationResponseDTO.class);

        return passengerCreationResponse;
    }

    /**
     * Method to check whether the customer details already exists
     *
     * @param newPassenger
     * @return true: customer exists;
     *         false: customer doesnot exists;
     */
    private boolean checkexistsPassenger(Passenger newPassenger) {
        return passengerRepository.getCustomer(newPassenger);
    }

    @Override
    public PassengerDetailResponseDTO changePassengerDetails(PassengerDetailRequestDTO passengerDetailRequest, String passengerId) {
        return null;
    }

    @Override
    public void deletePassenger(String passengerId) {

    }
}
