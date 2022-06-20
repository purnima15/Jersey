
package com.practice.JerseyTest.model;

public class ErrorMessage
{
    private String errorMessage;
    private int errorCode;
    
    public ErrorMessage(final String errorMessage, final int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
}