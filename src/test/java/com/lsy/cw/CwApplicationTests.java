package com.lsy.cw;

import com.lsy.cw.dao.UserDao;
import com.lsy.cw.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CwApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        List<User> users = userDao.queryAllUser();
        users.forEach(System.out::println);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setUemail("1111@qq.com");
        user.setUsex(1);
        user.setUname("lsy3");
        user.setUpwd("111");
        user.setUstatus(1);
        user.setUillegalTime(1);
        user.setUface("google2");
        int i = userDao.addUser(user);
        System.out.println(i);
        System.out.println(user);
    }

}
