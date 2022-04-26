package com.spring.springboot.dao;

import com.spring.springboot.entity.Menu;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class MenuDaoImplTest {

    @Autowired
    MenuDao menuDao;

    @Test
    void getMenu() {
        Menu menu = menuDao.getMenu(2);
        assertEquals(2, menu.getId());
    }

    @Test
    @Transactional
    void save() {
        Menu menu = new Menu();
        menu.setRestaurantName("Рост");
        menu.setMenu("Завтрак");
        menuDao.save(menu);
        Menu menu1 =  menuDao.getMenu(menu.getId());
        assertEquals("Рост", menu1.getRestaurantName());
    }
}