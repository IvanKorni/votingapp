package com.spring.springboot.dao;

import com.spring.springboot.entity.Menu;

import java.util.List;

public interface MenuDao {
    public List<Menu> getAllMenu();

    public void save(Menu menu);

    public Menu getMenu(int id);

    public void delete(int id);

    public void voted(int id);
}
