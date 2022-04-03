package com.richieoscar.shopaholic.controllers;

import com.richieoscar.shopaholic.dto.requests.RegistrationRequest;
import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.richieoscar.shopaholic.utils.AppHelper.covertToJson;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;


    @Test
    void register() throws Exception {
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("oscaranyiam100@gmail.com");
        request.setFirstName("Oscar");
        request.setLastName("Anyiam");
        request.setPassword("Passwordone@3");
        request.setConfirmPassword("Passwordone@3");

        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        covertToJson(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/register")
                        .content(covertToJson(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(service, times(1)).registerUser(user);
    }

    @Test
    void getUser() throws Exception {
        String email = "oscaranyiam@gmail.com";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getUser/" + email))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(service, times(1)).getUser(email);
    }
}