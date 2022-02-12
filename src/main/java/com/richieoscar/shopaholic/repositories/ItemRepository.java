package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Long> {
}
