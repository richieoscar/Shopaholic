package com.richieoscar.shopaholic.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private AppUser user;

    private BigDecimal total;

    private LocalDateTime orderedAt;

    public static UserOrder createFromCart(Cart cart) {
        UserOrder order = new UserOrder();
        order.setItems(cart.getItems().stream().collect(Collectors.toList()));
        order.setTotal(cart.getTotal());
        order.setUser(cart.getUser());
        order.setOrderedAt(LocalDateTime.now());
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserOrder userOrder = (UserOrder) o;
        return id != null && Objects.equals(id, userOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
