package com.avatar.bank.Avatar_Bank.exceptions;

public class AccountTransactionException extends Exception{
    private static final long serialVersionUID = 7718828512143293558L;

    private final int errorCode;

    public AccountTransactionException(int code) {
        super();
        this.errorCode = code;
    }

    public AccountTransactionException(String s){
        super(s);
        this.errorCode = 300;
    }
    public int getErrorCode() {
        return this.errorCode;
    }

    public AccountTransactionException(String message, Throwable cause, int code) {
        super(message, cause);
        this.errorCode = code;
    }
    public AccountTransactionException(String message, int code) {
        super(message);
        this.errorCode = code;
    }

    public AccountTransactionException(Throwable cause, int code) {
        super(cause);
        this.errorCode = code;
    }
}
