package com.Ivo.Auth.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String email;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<String> roles;
}
