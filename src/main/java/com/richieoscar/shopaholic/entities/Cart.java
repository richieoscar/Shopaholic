package com.richieoscar.shopaholic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.richieoscar.shopaholic.utils.EntityId;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart  extends EntityId {

    @Column(name = "item")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @Column
    @JsonProperty
    private BigDecimal total;

    @OneToOne(mappedBy = "cart")
    private User user;
}
