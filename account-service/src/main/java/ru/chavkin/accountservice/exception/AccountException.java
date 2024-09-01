package ru.chavkin.accountservice.exception;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class AccountException extends RuntimeException{
    public AccountException(String message) {
        super(message);
    }
}
