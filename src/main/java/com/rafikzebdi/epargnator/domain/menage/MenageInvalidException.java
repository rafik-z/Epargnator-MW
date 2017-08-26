package com.rafikzebdi.epargnator.domain.menage;


public class MenageInvalidException extends Exception{

    public MenageInvalidException() {
        super();
    }

    public MenageInvalidException(String message) {
        super(message);
    }

    public MenageInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenageInvalidException(Throwable cause) {
        super(cause);
    }
}
