package com.Ivo.Gym.service.service.impl;

import com.Ivo.Gym.service.dto.reponse.AuthenticationResponse;
import com.Ivo.Gym.service.dto.reponse.IntrospectResponse;
import com.Ivo.Gym.service.dto.request.AuthenticationRequest;
import com.Ivo.Gym.service.dto.request.IntrospectRequest;
import com.Ivo.Gym.service.exception.AppException;
import com.Ivo.Gym.service.exception.ErrorCode;
import com.Ivo.Gym.service.repository.UserRepository;
import com.Ivo.Gym.service.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserRepository userRepository;
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        var user = userRepository.findUsersByUserName(
                request.getUserName())
                        .orElseThrow(() ->new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(7);
        boolean authenticated= passwordEncoder.matches(request.getPassword(),user.getPassword());
        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        String token=generateToken(request.getUserName());
        if(token==null){
            throw new AppException(ErrorCode.CANNOT_CREATE_TOKEN);
        }


        return new AuthenticationResponse(token,authenticated);

    }

    public String testToken(AuthenticationRequest request){
        var user = userRepository.findUsersByUserName(
                        request.getUserName())
                .orElseThrow(() ->new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(7);
        boolean authenticated= passwordEncoder.matches(request.getPassword(),user.getPassword());
        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        String tokenn=generateToken(request.getUserName());
        if(tokenn==null){
            throw new AppException(ErrorCode.CANNOT_CREATE_TOKEN);
        }
        return tokenn;

    }
    private String generateToken(String userName)  {
        JWSHeader header=new JWSHeader(JWSAlgorithm.HS512);



        JWTClaimsSet jwtClaimsSet=new JWTClaimsSet.Builder()
                .subject(userName)
                .issuer("ivo.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(3, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim","Custom")
                .build();
        Payload payload=new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject=new JWSObject(header,payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
    public IntrospectResponse intropect(IntrospectRequest request) throws JOSEException, ParseException {
        var token =request.getToken();
        JWSVerifier verifier=new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT=SignedJWT.parse(token);
       Date expityTime=signedJWT.getJWTClaimsSet().getExpirationTime();
       var verified= signedJWT.verify(verifier);
//       if(!(verified&&expityTime.after(new Date())))
//           throw new AppException(ErrorCode.INVALID_TOKEN);
       return IntrospectResponse.builder()
               .valid(verified&&expityTime.after(new Date())).build();

    }
}
