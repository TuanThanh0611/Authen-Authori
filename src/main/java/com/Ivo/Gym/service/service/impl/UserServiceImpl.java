package com.Ivo.Gym.service.service.impl;

import com.Ivo.Gym.service.dto.reponse.UserResponse;
import com.Ivo.Gym.service.dto.request.UserCreationRequest;
import com.Ivo.Gym.service.entity.User;
import com.Ivo.Gym.service.exception.AppException;
import com.Ivo.Gym.service.exception.ErrorCode;
import com.Ivo.Gym.service.mapper.UserMapper;
import com.Ivo.Gym.service.repository.UserRepository;
import com.Ivo.Gym.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;


    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.existsByUserName(request.getUserName())){
            throw new AppException(ErrorCode.User_EXISTED);
        }
        User user=mapper.toUser(request);
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(7);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return mapper.toUserResponse(userRepository.save(user));
    }
}
