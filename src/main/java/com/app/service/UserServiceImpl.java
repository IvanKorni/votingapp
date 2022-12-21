package com.app.service;

import com.app.entity.User;
import com.app.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUsername(username);
    }

}
