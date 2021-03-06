package com.richieoscar.shopaholic.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class RegistrationRequest {
    @JsonProperty
    @NotNull(message = "email is required")
    @Email(message = "Provide valid email")
    private String email;

    @JsonProperty
    @NotNull(message = "Field is required")
    private String firstName;

    @JsonProperty
    @NotNull(message = "Field is required")
    private String lastName;

    @JsonProperty
    @NotNull(message = "Field is required")
    private String password;

    @JsonProperty
    @NotNull(message = "Field is required")
    private String confirmPassword;

}
