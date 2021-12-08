package com.linoz.petadoptioncatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by linoz on 12/3/21
 */

/**
 * Exception throw when a register is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundRequestException extends RuntimeException {

    public NotFoundRequestException(String message) {
        super(message);
    }
}
