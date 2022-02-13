package com.richieoscar.shopaholic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.richieoscar.shopaholic.utils.EntityId;
import com.richieoscar.shopaholic.entities.enums.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @JsonProperty
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Field is required")
    private String name;

    @NotNull(message = "Field is required")
    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Manufacturer manufacturer;


}
