package com.spring.springboot.service;

import com.spring.springboot.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> getAllMenu();

    public void saveMenu(Menu menu);

    public Menu getMenu(int id);

    public void delete(int id);

    public void voted(int id, String userName);

}
