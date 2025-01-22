package com.project.projectOne.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandartError implements Serializable {

    private Instant timeStamp;
    private Integer Status;
    private String error;
    private String message;
    private String path;


    public StandartError(){

    }

    public StandartError(Instant timeStamp, Integer status, String error, String message, String path){

    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
