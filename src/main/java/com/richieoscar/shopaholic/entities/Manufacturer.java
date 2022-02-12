package com.richieoscar.shopaholic.entities;

import com.richieoscar.shopaholic.utils.EntityId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "manufacturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manufacturer extends EntityId {

    @Column(name = "name", nullable = false)
    @NotNull(message = "Please provide manufacturer name")
    private String name;
    @Column(name = "address", nullable = false)
    @NotNull(message = "Please provide address")
    private String address;


}
