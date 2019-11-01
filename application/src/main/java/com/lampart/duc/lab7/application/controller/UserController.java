package com.lampart.duc.lab7.application.controller;

import com.lampart.duc.lab7.api.data.UserDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.urlPrefix)
public class UserController {

    public static final String urlPrefix = "/user";
    public static final String viewRoot = "user/";

    private UserDataService userDataService;

    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("users", userDataService.findAll());
        return viewRoot + "index";
    }
}
