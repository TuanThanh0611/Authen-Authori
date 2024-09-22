package com.Ivo.Gym.service.service;

import com.Ivo.Gym.service.dto.reponse.UserResponse;
import com.Ivo.Gym.service.dto.request.UserCreationRequest;
import com.Ivo.Gym.service.mapper.UserMapper;
import com.Ivo.Gym.service.repository.UserRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
     public UserResponse createUser(UserCreationRequest request);
     public List<UserResponse> getAllUsers();
}