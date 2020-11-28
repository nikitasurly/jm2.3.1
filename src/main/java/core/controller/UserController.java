package core.controller;

import core.model.User;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String listUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.find(id));
        return "find";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "find";
    }

    @GetMapping("/{id}/edit")
    public String setUser(@PathVariable("id") Long id,
                          ModelMap model) {
        model.addAttribute("user", userService.find(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String set(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "find";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
