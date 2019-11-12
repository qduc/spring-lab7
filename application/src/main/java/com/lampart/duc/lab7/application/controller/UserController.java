package com.lampart.duc.lab7.application.controller;

import com.lampart.duc.lab7.api.data.DataService;
import com.lampart.duc.lab7.service.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        model.addAttribute("title", "User List");
        model.addAttribute("users", userDataService.findAll());
        return viewRoot + "index";
    }

    @GetMapping("add")
    public String addGet(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new UserDto());
        return viewRoot + "add_edit";
    }

    @PostMapping("add")
    public String addPost(@ModelAttribute UserDto userDto) {
        userDataService.save(userDto);
        return "redirect:" + urlPrefix;
    }

    @GetMapping("edit/{id}")
    public String editGet(
            @PathVariable(value="id") Long id,
            Model model
    ) {
        model.addAttribute("title", "Edit User");
        Optional<UserDto> user = userDataService.findById(id);
        if (!user.isPresent()) {
            return "error/404";
        }

        model.addAttribute("user", user.get());
        return viewRoot + "add_edit";
    }

    @PostMapping("edit/{id}")
    public String editPost(
            @PathVariable(value="id") Long id,
            @ModelAttribute UserDto userDto
    ) {
        userDto.setId(id);
        userDataService.save(userDto);
        return "redirect:" + urlPrefix;
    }

    @GetMapping("delete/{id}")
    public String deletePost(
            @PathVariable(value="id") Long id
    ) {
        userDataService.deleteById(id);
        return "redirect:" + urlPrefix;
    }
}
