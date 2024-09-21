package com.Ivo.Gym.service.service.impl.UserServiceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.Ivo.Gym.service.dto.reponse.UserResponse;
import com.Ivo.Gym.service.dto.request.UserCreationRequest;
import com.Ivo.Gym.service.entity.User;
import com.Ivo.Gym.service.mapper.UserMapper;
import com.Ivo.Gym.service.repository.UserRepository;
import com.Ivo.Gym.service.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private UserMapper mapper;
//
//    private UserCreationRequest request;
//    private User user;
//    private UserResponse userResponse;
//
//    @BeforeEach
//    public void setUp() {
//        request = new UserCreationRequest();
//        request.setUserName("testuser");
//        request.setPassword("password");
//        // Set other fields as needed
//
//        user = new User();
//        user.setUserName("testuser");
//        user.setPassword("hashedPassword"); // This will be hashed in the service
//        // Set other fields as needed
//
//        userResponse = new UserResponse();
//        userResponse.setUserName("testuser");
//        // Set other fields as needed
//    }
//
//    @Test
//    public void testCreateUser() {
//        when(userRepository.existsByUserName(request.getUserName())).thenReturn(false);
//        when(mapper.toUser(request)).thenReturn(user);
//        when(userRepository.save(user)).thenReturn(user);
//        when(mapper.toUserResponse(user)).thenReturn(userResponse);
//
//        UserResponse response = userService.createUser(request);
//
//        assertNotNull(response);
//        assertEquals("testuser", response.getUserName());
//        verify(userRepository).save(user);
//    }
//
//    @Test
//    public void testGetAllUsers() {
//        List<User> users = Arrays.asList(user);
//        when(userRepository.findAll()).thenReturn(users);
//        when(mapper.toListUserResponse(users)).thenReturn(Arrays.asList(userResponse));
//
//        List<UserResponse> responses = userService.getAllUsers();
//
//        assertNotNull(responses);
//        assertEquals(1, responses.size());
//        assertEquals("testuser", responses.get(0).getUserName());
//        verify(userRepository).findAll();
//    }
//}