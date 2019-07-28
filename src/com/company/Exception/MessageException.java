package com.company.Exception;

public class MessageException extends RuntimeException {

    private String message;

    public MessageException(String message){
        super(message);
        this.message = message;

    }

}
