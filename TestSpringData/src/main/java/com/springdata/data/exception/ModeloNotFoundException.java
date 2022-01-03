package com.springdata.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) ya no es necesario si estamos editando en ResponseExceptionHandler
public class ModeloNotFoundException extends RuntimeException{

    public ModeloNotFoundException(String mensaje){
        super(mensaje);
    }
}
