package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
