package com.avatar.bank.Avatar_Bank.exceptions;

import java.util.function.Supplier;

public class ResourceNotFoundException extends Exception{
    private final int errorCode;

    public ResourceNotFoundException(int code) {
        super();
        this.errorCode = code;
    }

    public ResourceNotFoundException(String s){
        super(s);
        this.errorCode = 300;
    }
    public int getErrorCode() {
        return this.errorCode;
    }

    public ResourceNotFoundException(String message, Throwable cause, int code) {
        super(message, cause);
        this.errorCode = code;
    }
    public ResourceNotFoundException(String message, int code) {
        super(message);
        this.errorCode = code;
    }

    public ResourceNotFoundException(Throwable cause, int code) {
        super(cause);
        this.errorCode = code;
    }

}
