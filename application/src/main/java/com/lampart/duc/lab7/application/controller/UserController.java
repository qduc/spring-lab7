package com.lampart.duc.lab7.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.urlPrefix)
public class UserController {

    public static final String urlPrefix = "/user";
    public static final String viewRoot = "user/";

    @RequestMapping("")
    public String index() {
        return viewRoot + "index";
    }
}
