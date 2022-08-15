package com.alkemy.disneylandia.disneylandia.exception;

public class ParamNotFound extends RuntimeException {
    public ParamNotFound(String error) {
        super(error);
    }
}