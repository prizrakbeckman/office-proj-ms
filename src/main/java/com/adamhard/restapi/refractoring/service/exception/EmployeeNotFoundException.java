package com.adamhard.restapi.refractoring.service.exception;

public class EmployeeNotFoundException extends Exception {

    EmployeeNotFoundException(String message){
        super(message);
    }

}
