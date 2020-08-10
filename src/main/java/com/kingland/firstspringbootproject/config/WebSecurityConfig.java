/**

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.firstspringbootproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    final UserMapper userMapper;
    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    PasswordEncoder passwordEncoder;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserDetailsServiceImpl(userMapper));
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //Authorization for request
            .authorizeRequests()
            //These pages do not require authentication, other requests require authentication
            .antMatchers("/user/register").permitAll()
            .antMatchers("/user/login").permitAll()
            //Any request
            .anyRequest()
            //Both need identity authentication
            .authenticated()
        .and()
            //Form login authentication
            .formLogin()
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailureHandler)
        .and()
            .formLogin()
        .and()
            //Disable cross site attacks
            .csrf().disable();

    }

    // Pass "/static/**" all request
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/static/**");
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}