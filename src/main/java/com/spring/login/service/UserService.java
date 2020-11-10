package com.spring.login.service;

import com.spring.login.models.UserModel;
import com.spring.login.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserModel createNewUser(String name, String role, String password) {
        String encryptedPwd = bCryptPasswordEncoder.encode(password);
        UserModel register = new UserModel();
        register.setName(name);
        register.setRole(role);
        register.setPassword(encryptedPwd);
        userRepository.save(register);
        return register;
    }

}
