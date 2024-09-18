package com.Ivo.Gym.service.service.impl;

import com.Ivo.Gym.service.dto.request.AuthenticationRequest;
import com.Ivo.Gym.service.exception.AppException;
import com.Ivo.Gym.service.exception.ErrorCode;
import com.Ivo.Gym.service.repository.UserRepository;
import com.Ivo.Gym.service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserRepository userRepository;
    public boolean authenticateByUserName(AuthenticationRequest request){
        var user = userRepository.findUsersByUserName(
                request.getUserName())
                        .orElseThrow(() ->new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(7);
        return passwordEncoder.matches(request.getPassword(),user.getPassword());
    }
}
