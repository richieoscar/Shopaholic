package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.requests.RegistrationRequest;
import com.richieoscar.shopaholic.dto.response.RegistrationResponse;
import com.richieoscar.shopaholic.dto.response.UserResponse;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.exceptions.EmailNotValidException;
import com.richieoscar.shopaholic.exceptions.PasswordStrengthException;
import com.richieoscar.shopaholic.service.UserService;
import com.richieoscar.shopaholic.utils.EmailValidator;
import com.richieoscar.shopaholic.utils.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.richieoscar.shopaholic.utils.AppHelper.addHeader;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {

        if (!PasswordValidator.validatePassword(request.getPassword(), request.getConfirmPassword())) {
            throw new PasswordStrengthException();
        }
        if (!EmailValidator.validate(request.getEmail())) {
            throw new EmailNotValidException();
        }
        AppUser user = new AppUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return new ResponseEntity<RegistrationResponse>(service.registerUser(user), addHeader(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{email}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("email") String email) {

        if (EmailValidator.validate(email)) {
            return new ResponseEntity<UserResponse>(service.getUser(email), addHeader(), HttpStatus.OK);
        } else throw new EmailNotValidException();
    }
}
