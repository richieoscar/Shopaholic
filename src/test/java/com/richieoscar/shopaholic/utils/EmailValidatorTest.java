package com.richieoscar.shopaholic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void validate() {
        String email = "oscar@gmail.com";
        assertTrue(EmailValidator.validate(email));
    }
}