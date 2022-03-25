package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.dto.TestResponse;
import com.richieoscar.shopaholic.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
    List<Item> findAllByName(String name);
   // List<Item> findAllByManufacturerName(String name);
    List<Item> findAllByManufacturerManufacturerName(String name);

    @Query("SELECT new com.richieoscar.shopaholic.dto.TestResponse( t.name, m.manufacturerName) FROM Item t JOIN t.manufacturer m")
    List<TestResponse> getJoinInfo();

}
