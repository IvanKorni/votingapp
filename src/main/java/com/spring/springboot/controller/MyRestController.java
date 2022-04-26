package com.spring.springboot.controller;


import com.spring.springboot.entity.Menu;
import com.spring.springboot.exception_handling.NoSuchMenuException;
import com.spring.springboot.service.MenuService;
import com.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping("/menus")
    public List<Menu> showAllMenu() {
        return menuService.getAllMenu();
    }

    @GetMapping("/menu/{id}")
    public Menu getMenu(@PathVariable int id) {
        Menu menu = menuService.getMenu(id);
        if (menu == null) {
            throw new NoSuchMenuException("Меню с таким id:" + id + " нет");
        }
        return menu;
    }

    @PostMapping("/menus")
    public Menu saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return menu;
    }

    @PutMapping("/menus")
    public Menu updateMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return menu;
    }

    @PutMapping("/menu/vote/{id}")
    public void voteMenu(@PathVariable int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        menuService.voted(id, auth.getName());
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable int id) {
        Menu menu = menuService.getMenu(id);
        if (menu == null) {
            throw new NoSuchMenuException("Меню с таким id:" + id + " нет");
        }
        menuService.delete(id);

    }
}
