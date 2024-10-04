package org.accenture.ecommerce_demo.config.Jwt.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

}