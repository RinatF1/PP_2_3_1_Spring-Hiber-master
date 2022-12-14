package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String showAllUsers(ModelMap model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

    return "all_users";
    }


    @RequestMapping("/addNewUser")
    public String addNewUser(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);

        return "add_user";
    }

    @RequestMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect: /";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, ModelMap model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "add_user";
    }

    @GetMapping(value="/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
