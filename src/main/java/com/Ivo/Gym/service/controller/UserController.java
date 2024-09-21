package com.Ivo.Gym.service.controller;

import com.Ivo.Gym.service.dto.reponse.ApiResponse;
import com.Ivo.Gym.service.dto.reponse.UserResponse;
import com.Ivo.Gym.service.dto.request.UserCreationRequest;
import com.Ivo.Gym.service.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse =new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
//    @GetMapping
//    ApiResponse<List<UserResponse>> getAllUsers(){
//        return ApiResponse.<List<UserResponse>>builder()
//        .result(userService.getAllUsers())
//                .build();
//    }

}
