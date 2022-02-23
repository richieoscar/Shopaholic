package com.richieoscar.shopaholic.dto;

import com.richieoscar.shopaholic.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemRequest {

   private Item item;

}
