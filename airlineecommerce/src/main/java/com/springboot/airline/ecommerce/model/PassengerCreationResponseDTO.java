package com.springboot.airline.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerCreationResponseDTO {
    private static final long serialVersionUID = -2301690319972067653L;

    private String passengerUniqueId;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private List<ErrorList> errorDetailsList;


}
