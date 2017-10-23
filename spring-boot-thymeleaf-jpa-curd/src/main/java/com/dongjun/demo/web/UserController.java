package com.dongjun.demo.web;


import com.dongjun.demo.entity.User;
import com.dongjun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users",users);
        return "index";
    }

    @GetMapping(value = "/toEdit")
    public String toEdit(Model model,Integer id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "/save")
    public String save(User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteById(Integer id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/toAdd")
    public String add() {
        return "add";
    }

}
