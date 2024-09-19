package com.Ivo.Gym.service.service;

import com.Ivo.Gym.service.dto.reponse.AuthenticationResponse;
import com.Ivo.Gym.service.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
