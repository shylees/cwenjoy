package com.lsy.cw.dao;

import com.lsy.cw.pojo.Warn;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WarnDao {
    @Select("select * from warn")
    List<Warn> queryAllWarn();

    @Select("select * from warn where wid = #{wid}")
    Warn queryWarnByWid(int wid);

    @Select("select * from warn where uid = #{uid}")
    List<Warn> queryWarnByUid(int uid);

    @Select("select * from warn where wstatus = #{wstatus}")
    List<Warn> queryWarnByStatus(int wstatus);

    @Select("select * from warn where uid = #{uid} and wstatus = #{wstatus}")
    List<Warn> queryWarnByUidStatus(int uid, int wstatus);

    @Insert("insert into warn (uid, wcontext, wtime, wstatus) values (#{uid}, #{wcontext}, #{wtime}, #{wstatus})")
    @Options(useGeneratedKeys = true, keyProperty = "wid", keyColumn = "wid")
    int addWarn(Warn warn);

    @Delete("delete from warn where wid = #{wid}")
    int deleteWarn(int wid);

    @Update("update warn set uid = #{uid} where wid = #{wid}")
    int updateWarnUid(int wid, int uid);

    @Update("update warn set wcontext = #{wcontext} where wid = #{wid}")
    int updateWarnContent(int wid, String wcontent);

    @Update("update watn set wstatus = #{wstatus} where wid = #{wid}")
    int updateWarnStatus(int wid, int wstatus);
}
