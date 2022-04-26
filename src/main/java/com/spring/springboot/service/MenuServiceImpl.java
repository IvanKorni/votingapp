package com.spring.springboot.service;

import com.spring.springboot.dao.MenuDao;
import com.spring.springboot.dao.UserDao;
import com.spring.springboot.entity.Menu;
import com.spring.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Override
    @Transactional
    public void saveMenu(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional
    public Menu getMenu(int id) {
        return menuDao.getMenu(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        menuDao.delete(id);
    }

    @Override
    @Transactional
    public void voted(int id, String userName) {
        User user = userDao.findByUsername(userName);
        if(!user.isVoted()){
            user.setVoted(true);
            user.setDate(LocalDate.now());
            menuDao.voted(id);
        } else if(user.getDate()!= null && !user.getDate().equals(LocalDate.now())){
            user.setDate(LocalDate.now());
            menuDao.voted(id);
        }
    }

}
