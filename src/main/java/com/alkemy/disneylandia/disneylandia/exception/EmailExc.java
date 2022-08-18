package com.alkemy.disneylandia.disneylandia.exception;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

public class EmailExc extends RuntimeException {

    public EmailExc(String error) {
        super(error);
    }
}