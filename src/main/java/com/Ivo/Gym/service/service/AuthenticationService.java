package com.Ivo.Gym.service.service;

import com.Ivo.Gym.service.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    public boolean authenticateByUserName(AuthenticationRequest request);
}
