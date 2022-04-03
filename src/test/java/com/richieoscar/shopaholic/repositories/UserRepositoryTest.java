package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    public void canFindUserByEmail() {
        //given
        AppUser user = new AppUser();
        user.setFirstName("Oscar");
        user.setLastName("Anyiam");
        user.setPassword("Payday2016$");
        user.setCart(null);
        String email = "oscaranyiam@gmail.com";
        user.setEmail(email);
        underTest.save(user);

        //when
        Optional<AppUser> expected = underTest.findByEmail(email);

        //then
        assertThat(expected).isPresent();
    }

    @Test
    public void cannotFindUserByEmail() {
        //given
        AppUser user = new AppUser();
        user.setFirstName("Oscar");
        user.setLastName("Anyiam");
        user.setPassword("Payday2016$");
        user.setCart(null);
        String email = "oscaranyiam@gmail.com";
        user.setEmail(email);

        //when
        Optional<AppUser> expected = underTest.findByEmail(email);

        //then
        assertThat(expected).isEmpty();
    }
}