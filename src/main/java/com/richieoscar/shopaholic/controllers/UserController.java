package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.RegistrationRequest;
import com.richieoscar.shopaholic.entities.User;
import com.richieoscar.shopaholic.exceptions.PasswordStrengthException;
import com.richieoscar.shopaholic.service.UserService;
import com.richieoscar.shopaholic.utils.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        if (PasswordValidator.validatePassword(request.getPassword(), request.getConfirmPassword())) {
            throw new PasswordStrengthException();
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        service.registerUser(user);
        return "Registration Successful";
    }
}
