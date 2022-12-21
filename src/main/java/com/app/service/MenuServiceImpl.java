package com.app.service;

import com.app.entity.Menu;
import com.app.entity.User;
import com.app.dao.MenuDao;
import com.app.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuDao menuDao;
    private final UserDao userDao;

    @Override
    public void voted(int id, String userName) {
        User user = userDao.findByUsername(userName);
        if(!user.isVoted()){
            user.setVoted(true);
            goVote(id, user);
        } else if(user.isVoted() && !user.getDate().equals(LocalDate.now())){
            goVote(id, user);
        }
    }

    private void goVote(int id, User user) {
        Menu menu = menuDao.getById(id);
        user.setDate(LocalDate.now());
        int vote = menu.getVote();
        menu.setVote(vote + 1);
        menuDao.save(menu);
    }
}
