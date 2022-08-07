package com.springboot.airline.ecommerce.service;


import com.springboot.airline.ecommerce.exception.PassengerDuplicationException;
import com.springboot.airline.ecommerce.exception.ResourceNotFoundException;
import com.springboot.airline.ecommerce.model.*;
import com.springboot.airline.ecommerce.repo.PassengerRepositoryInterface;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PassengerService implements PassengerServiceInterface {

    @Autowired
    protected Passenger passenger;

    @Autowired
    protected Mapper mapper;

    @Autowired
    protected PassengerRepositoryInterface passengerRepository;


    /**
     * Method to add a new passenger
     *
     * @param passengerCreationRequest
     * @return
     */
    @Override
    public PassengerCreationResponseDTO createNewPassenger(PassengerCreationRequestDTO passengerCreationRequest)  {

        final Passenger newPassenger = mapper.map(passengerCreationRequest, Passenger.class);

        if(fetchPassenger(newPassenger).size() > 0){
            throw new PassengerDuplicationException("Passenger already exists!");
        }

        String passengerId = UUID.randomUUID().toString();
        newPassenger.setPassengerId(passengerId);

        passengerRepository.save(newPassenger);

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
    private List<Passenger> fetchPassenger(Passenger newPassenger) {
        return  passengerRepository.findByFirstnameAndLastname(newPassenger.getFirstName(), newPassenger.getLastName());
    }

    /**
     * Method to edit existing passenger details
     *
     * @param passengerDetailRequest
     * @param passengerId
     * @return
     */
    @Override
    public PassengerDetailResponseDTO changePassengerDetails(PassengerDetailRequestDTO passengerDetailRequest, String passengerId) {

       Passenger existingPassenger = passengerRepository.findById(passengerId).get();

       if(Objects.isNull(existingPassenger)){
           throw new ResourceNotFoundException("Passenger details could not be changed as passenger does not exists.");
       }

       validateAndUpdatePassengerDetails(passengerDetailRequest, existingPassenger);

      Passenger updatedPassenger = passengerRepository.save(existingPassenger) ;
      ErrorList errorList = null;
      if(Objects.isNull(updatedPassenger)){
           errorList = ErrorList.builder()
                  .errorMessage("422_102")
                  .errorMessage("There was some internal issue during passenger details update")
                  .build();
      }
        PassengerDetailResponseDTO response =  mapper.map(updatedPassenger, PassengerDetailResponseDTO.class);
        if(Objects.nonNull(errorList)){
            response.setErrorDetailsList(Arrays.asList(errorList));
        }

        return response;

    }

    /**
     * Method for updating existing passenger details
     *
     * @param passengerDetailRequest
     * @param existingPassenger
     */
    private void validateAndUpdatePassengerDetails(PassengerDetailRequestDTO passengerDetailRequest,
                                                   Passenger existingPassenger) {

        if(Objects.nonNull(passengerDetailRequest.getFirstName())){
            existingPassenger.setFirstName(passengerDetailRequest.getFirstName());
        }else if(Objects.nonNull(passengerDetailRequest.getLastName())){
            existingPassenger.setLastName(passengerDetailRequest.getLastName());
        }else if(Objects.nonNull(passengerDetailRequest.getPassportNumber())){
            existingPassenger.setPassportNumber(passengerDetailRequest.getPassportNumber());
        }else if(Objects.nonNull(passengerDetailRequest.getDateOfBirth())){
            existingPassenger.setDateOfBirth(passengerDetailRequest.getDateOfBirth());
        }
    }

    @Override
    public void deletePassenger(String passengerId) {
        Passenger existingPassenger = passengerRepository.findById(passengerId).get();

        if(Objects.isNull(existingPassenger)){
            throw new ResourceNotFoundException("Passenger details could not be changed as passenger does not exists.");
        }

        passengerRepository.deleteById(passengerId);
    }
}
