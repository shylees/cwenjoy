package com.lsy.cw.dao;

import com.lsy.cw.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> queryAllUser();

    @Select("select * from user where uid = #{uid}")
    User queryUserById(int uid);

    @Insert("insert into user (uemail, upwd, usex, uface, uillegalTime, ustatus, uname) values (#{uemail}, #{upwd}, #{usex}, #{uface},#{uillegalTime}, #{ustatus}, #{uname})")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    int addUser(User user);

    @Update("update user set uemail = #{uemail}, upwd = #{upwd}, usex = #{usex} where uid = #{uid}")
    int updateUser(User user);

    @Update("update user set uface = #{uface} where uid = #{uid}")
    int updataUserFace(int uid, String uface);

    @Update("update user set uilleglTime = #{uilleglTime} where uid = #{uid}")
    int updateUserUillegalTime(int uid, int uilleglTime);

    @Update("update user set ustatus = #{ustatus} where uid = #{uid}")
    int updateUserUstatus(int uid, int ustatus);

    @Delete("delete from user where uid = #{uid}")
    int deleteUserByUid(int uid);

}
