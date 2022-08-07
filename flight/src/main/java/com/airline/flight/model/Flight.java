package com.airline.flight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Flight {

    @Id
    private String flightId;

    private String flightName;

    private String departureLocation;

    private String destinationLocation;

    private BigDecimal price;

    private Date flyDate;

    private boolean seatAvailableFlag;
}
