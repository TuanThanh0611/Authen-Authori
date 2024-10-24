package com.Ivo.Auth.service;

import com.Ivo.Auth.dto.reponse.AuthenticationResponse;
import com.Ivo.Auth.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
