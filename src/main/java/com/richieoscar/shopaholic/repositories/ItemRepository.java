package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
}
