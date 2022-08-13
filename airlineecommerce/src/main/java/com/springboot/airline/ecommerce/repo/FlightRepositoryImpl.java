package com.springboot.airline.ecommerce.repo;

import com.springboot.airline.ecommerce.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class FlightRepositoryImpl  implements  FlightRepositoryInterface {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Flight> searchFlights() {

        final HttpHeaders headers = new HttpHeaders();
       //set header variables

        final HttpEntity requestEntity = new HttpEntity(null, headers);
        final String requestUri = "{region}/airline/flight";
        final Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("region","UAE");

        final ResponseEntity<Flight>   response = restTemplate.exchange(requestUri, HttpMethod.GET, requestEntity, Flight.class,
                 pathVariables);

        return Arrays.asList(response.getBody());

    }


}
