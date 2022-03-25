package com.richieoscar.shopaholic.dto.response;

import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.Item;
import com.richieoscar.shopaholic.entities.UserOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserOrderResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Item> items;
    private BigDecimal total;
    private LocalDateTime orderedAt;

    public UserOrderResponse(UserOrder userOrder){
        firstName = userOrder.getUser().getFirstName();
        lastName = userOrder.getUser().getLastName();
        email = userOrder.getUser().getEmail();
        items = userOrder.getItems();
        total = userOrder.getTotal();
        id = userOrder.getId();
        orderedAt = userOrder.getOrderedAt();
    }


}
