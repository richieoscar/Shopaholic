package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
