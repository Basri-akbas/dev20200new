package com.deneme.BosturDeneyebilirsin;


import com.deneme.BosturDeneyebilirsin.Entity.User;
import com.deneme.BosturDeneyebilirsin.Repository.UserRepository;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.apache.tomcat.jni.Mmap.delete;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

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
        User user=new User(3L,"Test-isim","Test-Soyisim","Testadres","testtel");
        userService.register(user);

        ArgumentCaptor<User> userCaptor= ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userCaptor.capture());
        User capturedUser =userCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);

    }

}
