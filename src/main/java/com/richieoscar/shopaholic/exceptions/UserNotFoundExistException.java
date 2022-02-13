package com.richieoscar.shopaholic.exceptions;

import com.richieoscar.shopaholic.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Constants.USER_NOT_FOUND_EXCEPTION_MESSAGE)
public class UserNotFoundExistException extends RuntimeException {
}
