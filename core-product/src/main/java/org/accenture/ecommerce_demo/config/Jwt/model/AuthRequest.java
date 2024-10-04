package org.accenture.ecommerce_demo.config.Jwt.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
