package com.example.PP_3_1_2_CRUD_SpringBoot.controller;

import com.example.PP_3_1_2_CRUD_SpringBoot.model.User;
import com.example.PP_3_1_2_CRUD_SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userTable(Model model) {
        List<User> users = userService.index();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.show(id));
        return "/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/";
    }
    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.delete(id);
        List<User> users = userService.index();
        model.addAttribute("users", users);
        return "users";
    }

}