package com.richieoscar.shopaholic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.richieoscar.shopaholic.utils.EntityId;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends EntityId {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    @JsonProperty
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private List<Item> items;

    @Column
    @JsonProperty
    private BigDecimal total;

    @OneToOne(mappedBy = "cart")
    private AppUser user;

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        if(total ==null){
            total = new BigDecimal(0);
        }
        total = total.add(item.getPrice());
    }
    public void removeItem(Item item){
        if(items != null){
         items.remove(item);
        }
        if(total != null){
           total = total.subtract(item.getPrice());
        }

    }
}
