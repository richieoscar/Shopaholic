package com.richieoscar.shopaholic.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@MappedSuperclass
public class EntityId {
    @Id
    @SequenceGenerator(
            name = "entity_sequence",
            sequenceName = "entity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    @JsonProperty
    private Long id;

}
