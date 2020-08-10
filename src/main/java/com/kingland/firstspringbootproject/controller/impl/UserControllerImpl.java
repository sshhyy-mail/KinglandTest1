package com.kingland.firstspringbootproject.controller.impl;

import com.kingland.firstspringbootproject.controller.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    @Override
    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }

    @Override
    @RequestMapping("/register")
    public String userRegister() {
        return "register";
    }
}
