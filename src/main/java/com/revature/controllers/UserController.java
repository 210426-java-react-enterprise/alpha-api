package com.revature.controllers;

import com.revature.models.User;
import com.revature.repos.LocationRepository;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.revature.dtos.UserDTO;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("users")
public class UserController
{

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public UserController(UserRepository userRepository, LocationRepository locationRepository)
    {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @RequestMapping("/getUserByEmail")
    public User getUserById(@RequestParam String uem)


    @RequestMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String un)
    {
        return userRepository.findUserByUsername(un);
    }

    @PostMapping(value = "/validate",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validateUser(@RequestBody User newUser)
    {
        if (userRepository.existsByUsername(newUser.getUsername()))
        {
            return new ResponseEntity<>("username", HttpStatus.CONFLICT);
        } else if (userRepository.existsByEmail(newUser.getEmail()))
        {
            return new ResponseEntity<>("email",HttpStatus.CONFLICT);
        } else if (!locationRepository.existsByCountryAndState("usa", newUser.getState()))
        {
            return new ResponseEntity<>("state", HttpStatus.NOT_ACCEPTABLE);
        } else if (!locationRepository.existsByCountryAndStateAndCity("usa", newUser.getState(), newUser.getCity()))
        {
            return new ResponseEntity<>("city", HttpStatus.NOT_ACCEPTABLE);
        } else
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @Autowired
    public UserController(UserService userService)

    {
        this.userService = userService;
    }

//    @RequestMapping("/getUserByEmail")
//    public User getUserById(@RequestParam String uem)
//    {
//        return userRepository.findUserByEmail(uem);
//    }
//
//    @RequestMapping("/getUserByUsername")
//    public User getUserByUsername(@RequestParam String un)
//    {
//        return userRepository.findUserByUsername(un);
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> getAllUsers()
//    {
//        return userRepository.findAll();
//    }
//
//    @PostMapping(value="/users",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public User register(@RequestBody @Valid User newUser)
//    {
//
//        return userRepository.registerUser(newUser);
//    }



}
