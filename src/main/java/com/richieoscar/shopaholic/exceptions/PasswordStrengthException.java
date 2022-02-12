package com.richieoscar.shopaholic.exceptions;

import com.richieoscar.shopaholic.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = Constants.PASSWORD_STRENGTH_EXCEPTION_MESSAGE)
public class PasswordStrengthException  extends RuntimeException{
}
