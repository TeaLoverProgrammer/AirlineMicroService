package com.springboot.airline.ecommerce.exception;

public class PassengerDuplicationException extends RuntimeException{

    private static final long serialVersionUID = 4036311125913595579L;

    private String message;

    public PassengerDuplicationException (String message){
        this.message = message;
    }

}
