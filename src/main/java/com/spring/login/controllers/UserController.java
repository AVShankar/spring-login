package com.spring.login.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.login.request.AddUser;
import com.spring.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    @PostMapping(value = "/home")
    public ObjectNode adduser(AddUser addUser)
    {
        userService.createNewUser(addUser.getName(), addUser.getRole(), addUser.getPassword());
        return 
    }
}
