package com.lsy.cw.dao;

import com.lsy.cw.pojo.Copywriting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CopywritingDao {

    @Select("select * from copywriting")
    List<Copywriting> queryAllCopyWriting();

    @Select("select * from copywriting where cwid = #{cwid}")
    Copywriting queryCopyWritingByCwid(int cwid);

    @Select("select * from copywriting where uid = #{uid}")
    List<Copywriting> queryCopyWritingByUid(int uid);

    @Select("select * from copywriting where cwtype = #{cwtype}")
    List<Copywriting> queryCopyWritingByCwtype(int cwtype);

    @Insert("insert into copywriting (uid, cwtext, cwtype, cwtime) values (#{uid}, #{cwtext}, #{cwtype}, #{cwtime})")
    @Options(useGeneratedKeys = true, keyProperty = "cwid", keyColumn = "cwid")
    int addCopyWriting(Copywriting copywriting);

    @Delete("delete from copywriting where cwid = #{cwid}")
    int deleteCopyWriting(int cwid);

    @Update("update copywriting set cwtext = #{cwtext}, cwtype = #{cwtype} where cwid = #{cwid}")
    int updateCopyWriting(Copywriting copywriting);


}
