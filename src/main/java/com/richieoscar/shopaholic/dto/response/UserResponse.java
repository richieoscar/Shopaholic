package com.richieoscar.shopaholic.dto.response;

import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private CartItems cartItems;

    public UserResponse(AppUser appUser) {
        firstName = appUser.getFirstName();
        lastName = appUser.getLastName();
        email = appUser.getEmail();
        cartItems = new CartItems(appUser.getCart() == null ? new Cart() : appUser.getCart());
    }


}
