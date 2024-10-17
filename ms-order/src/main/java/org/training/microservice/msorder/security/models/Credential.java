package org.training.microservice.msorder.security.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credential {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
