package com.lsy.cw.service;

import com.lsy.cw.pojo.Notion;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface NotionService {
    List<Notion> queryAllNotion();

    Notion queryNotionById(int nid);

    List<Notion> queryNotionByType(int ntype);

    int addNotion(Notion notion);

    int deleteNotion(int nid);

    int updateNotion(Notion notion);

    int updateNotionType(int ntype, int nid, Date ntime);

    int updateNotionContext(String ncontext, int nid, Date ntime);

}
