package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacturer, Long> {
}
