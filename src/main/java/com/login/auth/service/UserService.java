package com.login.auth.service;

import java.util.List;
import java.util.ArrayList;

import com.login.auth.models.User;
import com.login.auth.models.Role;

import com.login.auth.models.Data.UserDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Id;


@Service //used to hold business logic, or the code to create the business rules around how data is created and changed
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void createUser(User user)
    {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(); // used to encrypt passwords
        user.setPassword(encoder.encode(user.getPassword())); // gets password, encodes password then sets it to the encrpytion
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>(); // uses arraylist to add roles
        roles.add(userRole); //adds role to list
        user.setRoles(roles); //sets "USER" role
        userDAO.save(user); //saves user to repo
    }

    public boolean findUser(Id username) {
        return userDAO.existsByIdIgnoreCase(username);
    }


}
