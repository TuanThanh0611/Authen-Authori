package com.Ivo.Gym.service.mapper;


import com.Ivo.Gym.service.dto.reponse.UserResponse;
import com.Ivo.Gym.service.dto.request.UserCreationRequest;
import com.Ivo.Gym.service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
}
