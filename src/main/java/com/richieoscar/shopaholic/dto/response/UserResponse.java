package com.richieoscar.shopaholic.dto.response;

import com.richieoscar.shopaholic.entities.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String firsName;
    private String lastName;
    private String email;
    private Cart cart;

}
