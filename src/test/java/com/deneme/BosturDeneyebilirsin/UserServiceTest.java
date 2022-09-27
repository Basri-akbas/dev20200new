package com.deneme.BosturDeneyebilirsin;


import com.deneme.BosturDeneyebilirsin.repository.UserRepository;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        userService=new UserService(userRepository);
    }

    @Test
    public void registerTest(){


    }

}
