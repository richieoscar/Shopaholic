package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.dto.response.RegistrationResponse;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.exceptions.EmailAlreadyExistException;
import com.richieoscar.shopaholic.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new UserService(userRepository);
    }

    @Test
    void registerUser() {
        //given
        AppUser user = new AppUser();
        user.setEmail("richieanyiam@gmail.com");
        user.setFirstName("richie");
        user.setLastName("Anyiam");
        user.setPassword("Payday2018$");
        user.setId(1L);
        user.setCart(null);

        RegistrationResponse response = new RegistrationResponse();
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());

        // given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.of(user));

        //when
        underTest.registerUser(user);

        //then
        ArgumentCaptor<AppUser> captor = ArgumentCaptor.forClass(AppUser.class);
        verify(userRepository).save(captor.capture());
        AppUser capturedUser = captor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    public void willThrowExceptionForRegisterUser() {
        //given
        AppUser user = new AppUser();
        String email = "richieanyiam@gmail.com";
        user.setEmail(email);
        user.setFirstName("richie");
        user.setLastName("Anyiam");
        user.setPassword("Payday2018$");
        user.setId(1L);
        user.setCart(null);

        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));

        //then
        assertThatThrownBy(() -> underTest.registerUser(user))
                .isInstanceOf(EmailAlreadyExistException.class)
                .hasMessageContaining(String.format("Email: %s already exist", user.getEmail()));

    }

    @Test
    public void getAllUsers() {
        //when
        underTest.getUsers();
        //then
        verify(userRepository).findAll();
    }
}