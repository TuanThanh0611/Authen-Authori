package com.Ivo.Auth.controller;


import com.Ivo.Auth.dto.reponse.ApiResponse;
import com.Ivo.Auth.dto.reponse.AuthenticationResponse;
import com.Ivo.Auth.dto.reponse.IntrospectResponse;
import com.Ivo.Auth.dto.request.AuthenticationRequest;
import com.Ivo.Auth.dto.request.IntrospectRequest;
import com.Ivo.Auth.service.impl.AuthenticationServiceImpl;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AuthencationController {
    @Autowired
    AuthenticationServiceImpl authenticationService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var result =authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().
                result(result)

                .build();
    }
    @PostMapping("/testToken")
    String testToken(@RequestBody AuthenticationRequest request){
        return authenticationService.testToken(request);
    }

    @PostMapping("/token")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result =authenticationService.intropect(request);
        return ApiResponse.<IntrospectResponse>builder().
                result(result)
                .build();
    }
}
