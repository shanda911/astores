package com.cloudone.astores.controller;

import com.cloudone.astores.entitiy.Role;
import com.cloudone.astores.entitiy.User;
import com.cloudone.astores.jwt.JwtTokenUtil;
import com.cloudone.astores.model.AuthRequest;
import com.cloudone.astores.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AuthController {
    @Autowired AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            List<String> roleNames = user.getRoles().stream()
                    .map(this::transform)
                    .collect(Collectors.toList());
            AuthResponse response = new AuthResponse(user.getEmail(), roleNames, accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private String transform(Role role){
        return role.getName();
    }

}

