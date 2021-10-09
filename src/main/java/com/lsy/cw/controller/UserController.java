package com.lsy.cw.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.cw.dao.UserDao;
import com.lsy.cw.pojo.User;

import com.lsy.cw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/u")
    public String queryAllUser() throws Exception {
        List<User> users = userService.queryAllUser();
        
        return new ObjectMapper().writeValueAsString(users);
    }

//    @GetMapping ("/u")
//    public String queryUserById(int id) {
//        User user = userService.queryUserById(id);
//        return user.toString();
//    }
}
