package com.springboot.airline.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Passenger {

    @Id
    private String passengerId;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String passportNumber;
}
