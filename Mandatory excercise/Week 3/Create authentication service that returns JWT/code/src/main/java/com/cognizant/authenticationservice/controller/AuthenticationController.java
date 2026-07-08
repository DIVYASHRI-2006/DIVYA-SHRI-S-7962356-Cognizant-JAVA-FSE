package com.cognizant.authenticationservice.controller;

import com.cognizant.authenticationservice.model.AuthenticationResponse;
import com.cognizant.authenticationservice.util.JwtUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(

            @RequestHeader("Authorization") String authorizationHeader) {

        String base64Credentials = authorizationHeader.substring("Basic".length()).trim();

        byte[] decoded = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decoded, StandardCharsets.UTF_8);

        String username = credentials.split(":")[0];

        String token = JwtUtil.generateToken(username);

        return new AuthenticationResponse(token);

    }

}