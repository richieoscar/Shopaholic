package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.dto.RegistrationRequest;
import com.richieoscar.shopaholic.entities.User;
import com.richieoscar.shopaholic.exceptions.EmailAlreadyExistException;
import com.richieoscar.shopaholic.repositories.UserRepository;
import com.richieoscar.shopaholic.utils.PasswordValidator;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User user) {
        try {
            repository.save(user);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (DuplicateKeyException e) {
            throw new EmailAlreadyExistException();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return user;
    }

}
