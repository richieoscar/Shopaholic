package com.richieoscar.shopaholic.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponse {

    private String firstName;
    private String lastName;
    private String email;

}
