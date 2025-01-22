package com.project.projectOne.services.exceptions;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(Object id) {
        super("Record not found. Id " + id + " is unavailable!");
    }
}
