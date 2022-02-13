package com.richieoscar.shopaholic.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void validatePassword() {
        String password = "Passwordone1#";
        String password2 = "Passwordone1#";
        assertTrue(PasswordValidator.validatePassword(password, password2));
    }

    @Test
    void containsSpecialCharacter() {
        String password = "passwordone3@";
        assertTrue(PasswordValidator.containsSpecialCharacter(password));
    }

    @Test
    void containsUpperCase() {
        String pass = "assP";
        assertTrue(PasswordValidator.containsUpperCase(pass));
    }

    @Test
    void containsDigit() {
        String pass = "password4788";
        assertTrue(PasswordValidator.containsDigit(pass));
    }

    @Test
    void passwordMatch(){
        String password = "abc";
        String confirmPassword = "abc";
        assertEquals(password, confirmPassword);
    }

    @Test
    void doValidate(){
        String password = "password4@P";
        assertTrue(PasswordValidator.doValidate(password));
    }
}