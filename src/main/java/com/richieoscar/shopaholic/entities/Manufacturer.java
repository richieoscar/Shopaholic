package com.richieoscar.shopaholic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Manufacturer {

    @NotNull(message = "Please provide manufacturer name")
    private String manufacturerName;
    @NotNull(message = "Please provide address")
    private String manufacturerAddress;

}
