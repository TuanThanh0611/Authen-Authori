package com.Ivo.Gym.service.controller;


import com.Ivo.Gym.service.dto.reponse.ApiResponse;
import com.Ivo.Gym.service.dto.reponse.AuthenticationResponse;
import com.Ivo.Gym.service.dto.request.AuthenticationRequest;
import com.Ivo.Gym.service.service.impl.AuthenticationServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AuthencationController {
    @Autowired
    AuthenticationServiceImpl authenticationService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        boolean result =authenticationService.authenticateByUserName(request);
        return ApiResponse.<AuthenticationResponse>builder().
                result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
