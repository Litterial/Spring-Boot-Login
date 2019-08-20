package com.login.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping(value="")
    public String index(Model model)
    {
        model.addAttribute("title","Hello World");
        return "index";
    }
}


