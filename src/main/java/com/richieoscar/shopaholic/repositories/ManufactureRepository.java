package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacturer, Long> {
}
