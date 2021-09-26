package com.lsy.cw.service.impl;

import com.lsy.cw.dao.UserDao;
import com.lsy.cw.pojo.User;
import com.lsy.cw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public User queryUserById(int uid) {
        return userDao.queryUserById(uid);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updataUserFace(int uid, String uface) {
        return userDao.updataUserFace(uid,uface);
    }

    @Override
    public int updateUserUillegalTime(int uid, int uilleglTime) {
        return userDao.updateUserUillegalTime(uid, uilleglTime);
    }

    @Override
    public int updateUserUstatus(int uid, int ustatus) {
        return userDao.updateUserUstatus(uid, ustatus);
    }

    @Override
    public int deleteUserByUid(int uid) {
        return userDao.deleteUserByUid(uid);
    }
}
