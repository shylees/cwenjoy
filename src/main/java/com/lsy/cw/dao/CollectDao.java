package com.lsy.cw.dao;

import com.lsy.cw.pojo.Collect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectDao {
    @Select("select * from collect")
    List<Collect> queryAllCollect();

    @Select("select * from collect where uid = #{uid}")
    List<Collect> queryCollectByUid(int uid);

    @Insert("insert into collect (uid, cwid, ctime, cwtext) values (#{uid}, #{cwid}, #{ctime}, #{cwtext})")
    int addCollect(Collect collect);

    @Delete("delete from collect where uid = #{uid} and cwid = #{cwid}")
    int deleteCollect(int uid, int cwid);

    @Update("update collect set ctime = #{ctime} where uid = #{uid} and cwid = #{cwid}")
    int updataCollect(Collect collect);
}
