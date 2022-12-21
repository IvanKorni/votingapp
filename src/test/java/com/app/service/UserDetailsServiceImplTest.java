package com.app.service;

import com.app.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    void checkLoadUserByUsername() {
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userDao);
        assertEquals("Admin", userDetailsService.loadUserByUsername("admin").getUsername());
    }
}