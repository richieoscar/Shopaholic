package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.dto.response.RegistrationResponse;
import com.richieoscar.shopaholic.dto.response.UserResponse;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.exceptions.EmailAlreadyExistException;
import com.richieoscar.shopaholic.exceptions.UserNotFoundExistException;
import com.richieoscar.shopaholic.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public RegistrationResponse registerUser(AppUser user) {
        Optional<AppUser> userExists = repository.findByEmail(user.getEmail());
        if (userExists.isPresent()) {
            throw new EmailAlreadyExistException();
        }
        try {
            repository.save(user);

        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new EmailAlreadyExistException();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        RegistrationResponse response = new RegistrationResponse();
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }

    public UserResponse getUser(String email) {
        UserResponse userResponse = new UserResponse();
        Optional<AppUser> userOptional = repository.findByEmail(email);
        if (userOptional.isPresent()) {
            AppUser appUser = userOptional.get();
            userResponse.setFirsName(appUser.getFirstName());
            userResponse.setLastName(appUser.getLastName());
            userResponse.setEmail(appUser.getEmail());
            userResponse.setCart(appUser.getCart());
            return userResponse;
        } else throw new UserNotFoundExistException();
    }

}
