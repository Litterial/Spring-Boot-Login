package com.login.auth.controller;

import com.login.auth.models.Data.UserDAO;
import com.login.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.auth.models.User;

import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping(value = "")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="")
    public String index(Model model)
    {
        model.addAttribute("title","Hello World");
        return "index";
    }
    @RequestMapping(value="register",method = RequestMethod.GET)
    public String RegisterForm(Model model)
    {
        System.out.println("registerGet");
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value="register", method=RequestMethod.POST)
    public String verifyRegister(@Valid @ModelAttribute("user") User createUser, Errors err, Model model  )
    {
        System.out.println("registerPost");
        if (err.hasErrors())
        {
            System.out.println("errors");
            return "register";
        }
        if (!userService.findUser(createUser.getUsername()))
        {
            model.addAttribute("message","This username already exist");
            model.addAttribute("user",new User());
            return "register";
        }
        System.out.println("Passed all test");
        userService.createUser(createUser);

        return "redirect:";
    }
}


