package com.springboot.airline.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerCreationRequestDTO {

    private static final long serialVersionUID = 7184025304885269631L;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date dateOfBirth;

    private Address address;

    @NotNull
    @Size(max = 9)
    private String passportNumber;
}
