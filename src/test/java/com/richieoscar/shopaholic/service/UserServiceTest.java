package com.richieoscar.shopaholic.service;

import com.richieoscar.shopaholic.dto.response.RegistrationResponse;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    @Mock private UserRepository userRepository;

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
        user.setId(1L);
        user.setCart(null);

        RegistrationResponse response = new RegistrationResponse();
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());

        given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.of(user));

        //when

        RegistrationResponse actual = underTest.registerUser(user);

        //then

        RegistrationResponse expected = response;
        assertThat(actual).isEqualTo(expected);
    }
}