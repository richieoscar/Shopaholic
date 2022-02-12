package com.richieoscar.shopaholic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richieoscar.shopaholic.utils.EntityId;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends EntityId {

    @JsonProperty
    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "email is required")
    private String email;

    @JsonProperty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @JsonProperty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonProperty
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;
}
