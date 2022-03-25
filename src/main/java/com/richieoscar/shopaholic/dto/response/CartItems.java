package com.richieoscar.shopaholic.dto.response;

import com.richieoscar.shopaholic.entities.Cart;
import com.richieoscar.shopaholic.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItems {
    private List<Item> items;
    private BigDecimal total;
    private UserResponse user;

    public CartItems(Cart cart){
        items = cart.getItems();
        total = cart.getTotal();
    }
}
