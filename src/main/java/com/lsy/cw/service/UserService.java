package com.lsy.cw.service;


import com.lsy.cw.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {
    List<User> queryAllUser();

    User queryUserById(int uid);

    int addUser(User user);

    int updateUser(User user);

    int updataUserFace(int uid, String uface);

    int updateUserUillegalTime(int uid, int uilleglTime);

    int updateUserUstatus(int uid, int ustatus);

    int deleteUserByUid(int uid);
}
