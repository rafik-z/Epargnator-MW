package com.rafikzebdi.epargnator.domain.personne;


public class PersonneInvalidException extends Exception{

    public PersonneInvalidException() {
        super();
    }

    public PersonneInvalidException(String message) {
        super(message);
    }

    public PersonneInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonneInvalidException(Throwable cause) {
        super(cause);
    }
}
