
package com.practice.JerseyTest.exception;

public class DataNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = -9008046648689074760L;
    
    public DataNotFoundException(final String message) {
        super(message);
    }
}