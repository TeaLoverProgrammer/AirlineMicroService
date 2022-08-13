package com.airline.payment.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @NotNull
    BigDecimal price;


    @NotNull
    String PassengerId;


    @NotNull
    String flightId;


}
