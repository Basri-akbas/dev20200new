package com.deneme.BosturDeneyebilirsin.service;


import com.deneme.BosturDeneyebilirsin.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceTest.class})
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

   /* @Test
    void test_register() {
        User user = new User(10L,"Furkan","Nakruf","Esslingen",73730);
        when(userRepository.save(user)).thenReturn(user);
        userRepository.save(user);
        assertEquals(user,userRepository.save(user));
    }

    @Test
    void test_findByIdTrue() {


        User user1 = new User(11L,"Faruk","Nakıp","Öttlingen",73731);


        Long userId = 11L;



        when(userRepository.findById(userId)).thenReturn(Optional.of(user1));

        assertEquals(11L, userRepository.findById(userId).orElseThrow().getId());


    }

    @Test
    void test_updateUser() {
    }

    @Test
    void test_removeById() {
    }*/
}