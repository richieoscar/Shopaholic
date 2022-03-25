package com.richieoscar.shopaholic.dto.requests;

import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyCartRequest {

    private String userEmail;
    private Long itemId;
}
