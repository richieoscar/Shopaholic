package com.richieoscar.shopaholic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Category Already Exist")
public class CategoryAlreadyExistException extends RuntimeException {
}
