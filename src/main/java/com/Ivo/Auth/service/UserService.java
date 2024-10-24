package com.Ivo.Auth.service;

import com.Ivo.Auth.dto.reponse.UserResponse;
import com.Ivo.Auth.dto.request.UserCreationRequest;
import com.Ivo.Auth.dto.request.UserUpdateRequest;

import java.util.List;

public interface UserService {
     public UserResponse createUser(UserCreationRequest request);
     public List<UserResponse> getAllUsers();
     public UserResponse updateUser(String userId, UserUpdateRequest request);
     public void deleteUser(String userId);
     public UserResponse getUser(String id);
}