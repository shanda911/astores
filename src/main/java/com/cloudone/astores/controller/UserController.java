package com.cloudone.astores.controller;

import java.net.URI;

import javax.validation.Valid;

import com.cloudone.astores.entitiy.Role;
import com.cloudone.astores.entitiy.User;
import com.cloudone.astores.model.dto.UserDTO;
import com.cloudone.astores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired private UserService service;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        user.addRole(new Role(2));//FIXME: UserRole : Customer
        User createdUser = service.save(user);
        URI uri = URI.create("/users/" + createdUser.getId());

        UserDTO userDto = new UserDTO(createdUser.getId(), createdUser.getEmail());

        return ResponseEntity.created(uri).body(userDto);
    }
}
