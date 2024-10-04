package org.accenture.ecommerce_demo.config.Jwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.accenture.ecommerce_demo.config.Jwt.service.JwtService;
import org.accenture.ecommerce_demo.config.Jwt.model.AuthRequest;
import org.accenture.ecommerce_demo.config.Jwt.model.AuthResponse;
import org.accenture.ecommerce_demo.exception.ApiError;
import org.accenture.ecommerce_demo.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    @Operation(summary = "Crea un nuevo token", description = "Permite la creación de un token para la autorizacion")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Token creado con exito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class))),
    })
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}
