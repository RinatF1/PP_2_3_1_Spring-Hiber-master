package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String showAllUsers(ModelMap model){
        List<User> allUsers = userDao.getAllUsers();
        model.addAttribute("allUsers", allUsers);

    return "all_users";
    }

}
