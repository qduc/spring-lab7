package com.lampart.duc.lab7.application.controller;

import com.lampart.duc.lab7.api.data.DataService;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.urlPrefix)
public class UserController {

    public static final String urlPrefix = "/user";
    public static final String viewRoot = "user/";

    private final DataService<UserDto> userDataService;

    public UserController(DataService<UserDto> userDataService) {
        this.userDataService = userDataService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("users", userDataService.findAll());
        return viewRoot + "index";
    }

    @GetMapping("add")
    public String addGet(Model model) {
        model.addAttribute("user", new UserDto());
        return viewRoot + "add_edit";
    }

    @PostMapping("add")
    public String addPost(@ModelAttribute UserDto userDto) {
        userDataService.save(userDto);
        return "redirect:" + urlPrefix;
    }
}
