package com.richieoscar.shopaholic.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.richieoscar.shopaholic.utils.EntityId;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @SequenceGenerator(
            name = "manu_sequence",
            sequenceName = "manu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manu_sequence")
    @JsonProperty
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Please provide manufacturer name")
    private String name;
    @Column(name = "address", nullable = false)
    @NotNull(message = "Please provide address")
    private String address;


}
