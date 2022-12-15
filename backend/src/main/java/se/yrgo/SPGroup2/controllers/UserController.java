package se.yrgo.SPGroup2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.SPGroup2.domain.User;
import se.yrgo.SPGroup2.repositories.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
