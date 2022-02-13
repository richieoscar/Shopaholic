package com.richieoscar.shopaholic.exceptions;

import com.richieoscar.shopaholic.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.richieoscar.shopaholic.utils.Constants.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = PASSWORD_DO_NOT_MATCH_EXCEPTION_MESSAGE)
public class PasswordDoNotMatchException extends RuntimeException {
}
