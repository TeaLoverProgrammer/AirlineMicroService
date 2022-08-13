package com.springboot.airline.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private String flightId;

    private String flightName;

    private String departureLocation;

    private String destinationLocation;

    private BigDecimal price;

    private Date flyDate;

    private boolean seatAvailableFlag;
}
