package com.spring.login.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.login.models.UserModel;
import com.spring.login.request.AddUser;
import com.spring.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public UserModel adduser(AddUser addUser)
    {
        UserModel map = new UserModel();
        map = userService.createNewUser(addUser.getName(), addUser.getRole(), addUser.getPassword());
        return map;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView obj = new ModelAndView();
        obj.setViewName("signup");
        return obj;
    }
}
