package com.rafikzebdi.epargnator.domain.projet;

public class ProjetInvalidException extends Exception {
    public ProjetInvalidException() {
        super ();
    }

    public ProjetInvalidException(String message) {
        super ( message );
    }

    public ProjetInvalidException(String message, Throwable cause) {
        super ( message, cause );
    }

    public ProjetInvalidException(Throwable cause) {
        super ( cause );
    }

    protected ProjetInvalidException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super ( message, cause, enableSuppression, writableStackTrace );
    }
}
