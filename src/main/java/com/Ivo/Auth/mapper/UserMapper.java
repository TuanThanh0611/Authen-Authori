package com.Ivo.Auth.mapper;


import com.Ivo.Auth.dto.reponse.UserResponse;
import com.Ivo.Auth.dto.request.UserCreationRequest;
import com.Ivo.Auth.dto.request.UserUpdateRequest;
import com.Ivo.Auth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public  interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    List<UserResponse> toListUsers(List<User> users);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
