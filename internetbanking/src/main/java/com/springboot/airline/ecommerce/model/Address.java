package com.springboot.airline.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private static final long serialVersionUID = -7055989014704818579L;

    @NotBlank
    private String houseNumber;

    private String street1;

    private String street2;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String state;

    @NotBlank
    private String country;
}
