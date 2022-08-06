package com.springboot.airline.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 3718298119975694185L;

    private String message;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

}
