package com.login.auth.service;

import java.util.List;
import java.util.ArrayList;

import com.login.auth.models.User;
import com.login.auth.models.Role;

import com.login.auth.models.Data.UserDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void createUser (User user)
    {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole =new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userDAO.save(user);
    }

}
