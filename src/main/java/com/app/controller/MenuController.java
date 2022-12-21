package com.app.controller;


import com.app.exception_handling.IdMenuException;
import com.app.dao.MenuDao;
import com.app.service.MenuService;
import com.app.entity.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;
    private final MenuDao menuDao;

    @GetMapping("/menus")
    public List<Menu> showAllMenu() {
        log.info("Show all menu list");
        return menuDao.findAll();
    }

    @GetMapping("/menu/{id}")
    public Menu getMenu(@PathVariable int id) {
        try {
            log.info("Get menu id: " + id);
            return menuDao.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new IdMenuException("Меню с id: " + id + " нет");
        }
    }

    @PostMapping("/menus")
    public Menu saveMenu(@RequestBody Menu menu) {
        log.info("Save menu");
        menuDao.save(menu);
        return menu;
    }

    @PutMapping("/menus")
    public Menu updateMenu(@RequestBody Menu menu) {
        log.info("Update menu");
        menuDao.save(menu);
        return menu;
    }

    @PutMapping("/menu/{id}")
    public void voteMenu(@PathVariable int id) {
        try {
            if (menuDao.findById(id).get().getMenu() != null) {
                log.info("Vote for the menu with id" + id);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                menuService.voted(id, auth.getName());
            }
        } catch (NoSuchElementException e) {
            throw new IdMenuException("Меню с id: " + id + " нет");
        }
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable int id) {
        try {
            if (menuDao.findById(id).get().getMenu() != null) {
                log.info("Delete for the menu with id" + id);
                menuDao.delete(menuDao.getById(id));
            }
        } catch (NoSuchElementException e) {
            throw new IdMenuException("Меню с id: " + id + " нет");
        }
    }
}
