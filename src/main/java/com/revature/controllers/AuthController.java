package com.revature.controllers;

import com.revature.dtos.CredentialsDTO;
import com.revature.models.User;
import com.revature.security.JwtConfig;
import com.revature.security.TokenGenerator;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;
    private TokenGenerator tokenGenerator;
    private JwtConfig jwtConfig;

    @Autowired
    public AuthController(UserService userService, TokenGenerator tokenGenerator, JwtConfig jwtConfig) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.jwtConfig = jwtConfig;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public User authenticate(@RequestBody CredentialsDTO credentials, HttpServletResponse resp) {
        User user = userService.authenticate(credentials.getUsername(), credentials.getPassword());
        String jwt = tokenGenerator.createJwt(user);
        resp.setHeader(jwtConfig.getHeader(), jwt);
        return user;
    }
}
