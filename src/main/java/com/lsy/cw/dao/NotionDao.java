package com.lsy.cw.dao;

import com.lsy.cw.pojo.Notion;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface NotionDao {
    @Select("select * from notion")
    List<Notion> queryAllNotion();

    @Select("select * from notion where nid = #{nid}")
    Notion queryNotionById(int nid);

    @Select("select * from notion where ntype = #{ntype}")
    List<Notion> queryNotionByType(int ntype);

    @Insert("insert into notion (ncontext, ntime, ntype) values (#{ncontext}, #{ntime}, #{ntype})")
    @Options(useGeneratedKeys = true, keyProperty = "nid", keyColumn = "nid")
    int addNotion(Notion notion);

    @Delete("delete from notion where nid = #{nid}")
    int deleteNotion(int nid);

    @Update("update notion set ncontext = #{ncontext}, ntime = #{ntime}, ntype = #{ntype} where nid = #{nid}")
    int updateNotion(Notion notion);

    @Update("update notion set ntype = #{ntype}, ntime = #{ntime} where nid = #{nid}")
    int updateNotionType(int ntype, int nid, Date ntime);

    @Update("update notion set ncontext = #{ncontext}, ntime = #{ntime} where nid = #{nid}")
    int updateNotionContext(String ncontext, int nid, Date ntime);

}
