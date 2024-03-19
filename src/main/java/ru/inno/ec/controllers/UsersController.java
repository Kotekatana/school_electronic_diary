package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.inno.ec.dto.UserForm;
import ru.inno.ec.services.LearningGroupsService;
import ru.inno.ec.services.UsersService;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;
    private final LearningGroupsService learningGroupsService;
    @GetMapping("/users")
    public String getUsersPage(@RequestParam(value = "orderBy", required = false) String orderBy,
                               @RequestParam(value = "dir", required = false) String direction, Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        model.addAttribute("groups",learningGroupsService.getAllLearningGroups());
        return "users_page";
    }

    @PostMapping("/users")
    public String addUser(UserForm user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{user-id}")
    public String getUserPage(@PathVariable("user-id") Long id, Model model) {
        model.addAttribute("user", usersService.getUser(id));
        return "user_page";
    }

    @PostMapping("/users/{user-id}/update")
    public String updateUser(@PathVariable("user-id") Long userId, UserForm user) {
        usersService.updateUser(userId, user);
        return "redirect:/users/" + userId;
    }

    @GetMapping("/users/{user-id}/delete")
    public String updateUser(@PathVariable("user-id") Long userId) {
        usersService.deleteUser(userId);
        return "redirect:/users/";
    }
}
