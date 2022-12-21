package com.app.service;

import com.app.entity.Menu;
import com.app.entity.User;
import com.app.dao.MenuDao;
import com.app.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuServiceImplTest {

    @Mock
    MenuDao menuDao;
    @Mock
    UserDao userDao;
    @Mock
    User user;

    MenuServiceImpl menuService;
    Menu menu;

    @BeforeEach
    public void init(){
        menuService = new MenuServiceImpl(menuDao, userDao);
        menu = new Menu();
        menu.setMenu("1,2,3");
        menu.setRestaurantName("Name");
    }

    @Test
    public void checkVotedFunctionThenUserHasNotVote(){
        when(userDao.findByUsername(any())).thenReturn(user);
        when(menuDao.getById(any())).thenReturn(menu);
        when(user.isVoted()).thenReturn(false);

        menuService.voted(menu.getId(), "admin");
        verify(menuDao).save(menu);
    }

    @Test
    public void checkVotedFunctionThenUserHasVote(){
        when(userDao.findByUsername(any())).thenReturn(user);
        when(menuDao.getById(any())).thenReturn(menu);
        when(user.getDate()).thenReturn(LocalDate.now().plusDays(1));
        when(user.isVoted()).thenReturn(true);

        menuService.voted(menu.getId(), "admin");
        verify(menuDao).save(menu);
    }
}