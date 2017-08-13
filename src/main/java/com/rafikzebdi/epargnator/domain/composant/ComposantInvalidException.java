package com.rafikzebdi.epargnator.domain.composant;

public class ComposantInvalidException extends Exception {
    public ComposantInvalidException() {
        super ();
    }

    public ComposantInvalidException(String message) {
        super ( message );
    }

    public ComposantInvalidException(String message, Throwable cause) {
        super ( message, cause );
    }

    public ComposantInvalidException(Throwable cause) {
        super ( cause );
    }

    protected ComposantInvalidException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super ( message, cause, enableSuppression, writableStackTrace );
    }
}
