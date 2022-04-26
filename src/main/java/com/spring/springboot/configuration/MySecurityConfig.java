package com.spring.springboot.configuration;


import com.spring.springboot.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import javax.sql.DataSource;
import java.util.Optional;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/menus").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/menu/vote/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/api/menus").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/menus").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/menu/**").hasRole("ADMIN")
                .and().httpBasic()
                .and().formLogin()
                .and().logout()
                .permitAll();

    }
}
