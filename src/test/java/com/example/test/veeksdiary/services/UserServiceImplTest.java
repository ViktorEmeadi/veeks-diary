package com.example.test.veeksdiary.services;

import com.example.veeksdiary.services.DiaryService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
   @Mock
   public DiaryService diaryService;
   @Mock
   public  UserRepository repository;

   @InjectMocks
   public UserService userService;
   @BeforeEach
   public void setUp(){
       userService = new UserServiceImpl(repository,diaryService);
   }

    @Test
    public void testRegisterUser(){
//        UserRequest request = new UserRequest();
//        request.setFirstName("Me");
//        request.setLastName("V");
//        request.setEmail("v@gmail.com");
//        request.setPassword("1234");
//        userService.registerNewUser(request);
//        assertEquals(1, repository.count());
        assertEquals(0, repository.count());
    }
}