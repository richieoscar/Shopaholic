package com.richieoscar.shopaholic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Manufacturer not found")
public class ManufacturerNotFoundException extends RuntimeException {
}