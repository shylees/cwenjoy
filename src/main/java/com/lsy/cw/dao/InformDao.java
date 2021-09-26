package com.lsy.cw.dao;

import com.lsy.cw.pojo.Inform;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InformDao {
    @Select("select * from inform")
    List<Inform> queryAllInform();

    @Select("select * from inform where uid = #{uid}")
    List<Inform> queryInformByUid(int uid);

    @Select("select * from inform where inid = #{inid}")
    Inform queryInformByInid(int inid);

    @Select("select * from inform where instatus = #{instatus}")
    List<Inform> queryInformByStatus(int instatus);

    @Insert("insert into inform (ineduid, inuid, cwid, instatus) values (#{ineduid}, #{inuid}, #{cwid}, #{instatus})")
    @Options(useGeneratedKeys = true, keyProperty = "inid", keyColumn = "inid")
    int addInform(Inform inform);

    @Delete("delete from inform where inid = #{inid}")
    int deleteInform(int inid);

    @Delete("delete from inform where instatus = #{instatus}")
    int deleteInformByStatus(int instatus);

    @Update("update inform set ineduid = #{ineduid}, inuid = #{inuid}, cwid = #{cwid}, instatus = #{instatus} where inid = #{inid}")
    int updateInform(Inform inform);

    @Update("update inform set instatus = #{instatus} where inid = #{inid}")
    int updateInformStatus(int instatus, int inid);
}
