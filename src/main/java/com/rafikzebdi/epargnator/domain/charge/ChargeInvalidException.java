package com.rafikzebdi.epargnator.domain.charge;


public class ChargeInvalidException extends Exception{

    public ChargeInvalidException() {
        super();
    }

    public ChargeInvalidException(String message) {
        super(message);
    }

    public ChargeInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChargeInvalidException(Throwable cause) {
        super(cause);
    }
}
