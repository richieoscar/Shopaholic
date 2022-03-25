package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.requests.RegistrationRequest;
import com.richieoscar.shopaholic.dto.response.RegistrationResponse;
import com.richieoscar.shopaholic.dto.response.UserResponse;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.Cart;
import com.richieoscar.shopaholic.exceptions.EmailNotValidException;
import com.richieoscar.shopaholic.exceptions.PasswordStrengthException;
import com.richieoscar.shopaholic.service.UserService;
import com.richieoscar.shopaholic.utils.EmailValidator;
import com.richieoscar.shopaholic.utils.PasswordValidator;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.richieoscar.shopaholic.utils.AppHelper.addHeader;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @Operation(description = "Register a User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registration Successful", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Invalid Email"),
            @ApiResponse(responseCode = "400", description = "Password (should contain: uppercase, special character, digit,min 8 characters, & passwords match)"),
            @ApiResponse(responseCode = "409", description = "Email already Exists"),
    })
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

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return ResponseEntity.ok(service.getUsers());
    }
}
