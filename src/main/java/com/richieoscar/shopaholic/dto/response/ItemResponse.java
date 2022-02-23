package com.richieoscar.shopaholic.dto.response;

import com.richieoscar.shopaholic.entities.Category;
import com.richieoscar.shopaholic.entities.Manufacturer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ItemResponse {

    private Long id;

    private String name;


    private String description;


    private BigDecimal price;


    private List<String> categories;


    private Manufacturer manufacturer;
}
