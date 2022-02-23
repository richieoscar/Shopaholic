package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
    List<Item> findAllByName(String name);
    List<Item> findAllByManufacturer_Name(String manufacturerName);
}
