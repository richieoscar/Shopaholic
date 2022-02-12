package com.richieoscar.shopaholic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Email already exist")
public class EmailAlreadyExistException extends RuntimeException {
}
