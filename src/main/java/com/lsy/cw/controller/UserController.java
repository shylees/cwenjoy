package com.lsy.cw.controller;


import com.lsy.cw.dao.UserDao;
import com.lsy.cw.pojo.User;

import com.lsy.cw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/u")
    public String queryAllUser() {
        List<User> users = userService.queryAllUser();
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.toString()+"\n");
        }
        return sb.toString();
    }

    @GetMapping ("/u")
    public String queryUserById(int id) {
        User user = userService.queryUserById(id);
        return user.toString();
    }
}
