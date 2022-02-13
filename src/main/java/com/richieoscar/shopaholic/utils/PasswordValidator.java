package com.richieoscar.shopaholic.utils;

import com.richieoscar.shopaholic.exceptions.PasswordDoNotMatchException;

public class PasswordValidator {

    public static boolean validatePassword(String password, String confirmPassword) {
        if (passwordMatch(password, confirmPassword) && doValidate(password)) {
            return true;
        }
        return false;
    }

    protected static boolean doValidate(String password) {
        if (password.length() > 8
                && containsSpecialCharacter(password)
                && containsDigit(password)
                && containsDigit(password)
                && containsUpperCase(password)) {
            return true;
        }
        return false;
    }

    protected static boolean containsSpecialCharacter(String password) {
        if (password.contains("@") || password.contains("#") || password.contains("$")
                || password.contains("&") || password.contains("%") ||
                password.contains("!") || password.contains("^") || password.contains("*")) {
            return true;
        }
        return false;
    }

    protected static boolean containsUpperCase(String password) {

        char[] chars = password.toCharArray();
        for (Character ch : chars) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean containsDigit(String password) {
        char[] chars = password.toCharArray();
        for (Character ch : chars) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean passwordMatch(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) return true;
        throw new PasswordDoNotMatchException();
    }
}


