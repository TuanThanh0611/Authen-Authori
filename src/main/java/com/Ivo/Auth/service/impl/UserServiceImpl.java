package com.Ivo.Auth.service.impl;

import com.Ivo.Auth.enums.Role;
import com.Ivo.Auth.dto.reponse.UserResponse;
import com.Ivo.Auth.dto.request.UserCreationRequest;
import com.Ivo.Auth.dto.request.UserUpdateRequest;
import com.Ivo.Auth.entity.User;
import com.Ivo.Auth.exception.AppException;
import com.Ivo.Auth.exception.ErrorCode;
import com.Ivo.Auth.mapper.UserMapper;
import com.Ivo.Auth.repository.UserRepository;
import com.Ivo.Auth.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE,makeFinal = true)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper mapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.User_EXISTED);
        }
        User user=mapper.toUser(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(roles);

        return mapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers(){
        return mapper.toListUsers(userRepository.findAll());
    }

    @Override
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        mapper.updateUser(user, request);

        return mapper.toUserResponse(userRepository.save(user));
    }


    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
//        log.info("Tên người dùng từ JWT: {}", name);

        User user = userRepository.findUsersByUsername(name).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));
   //     log.info("Người dùng tìm thấy: {}", user.getUsername());

        return mapper.toUserResponse(user);
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(String id){
        log.info("In method get user by Id");
        return mapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }


    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }



}
