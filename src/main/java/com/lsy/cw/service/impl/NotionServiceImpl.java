package com.lsy.cw.service.impl;

import com.lsy.cw.dao.NotionDao;
import com.lsy.cw.pojo.Notion;
import com.lsy.cw.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("notionService")
public class NotionServiceImpl implements NotionService {

    @Autowired
    private NotionDao notionDao;

    @Override
    public List<Notion> queryAllNotion() {
        return notionDao.queryAllNotion();
    }

    @Override
    public Notion queryNotionById(int nid) {
        return notionDao.queryNotionById(nid);
    }

    @Override
    public List<Notion> queryNotionByType(int ntype) {
        return notionDao.queryNotionByType(ntype);
    }

    @Override
    public int addNotion(Notion notion) {
        return notionDao.addNotion(notion);
    }

    @Override
    public int deleteNotion(int nid) {
        return notionDao.deleteNotion(nid);
    }

    @Override
    public int updateNotion(Notion notion) {
        return notionDao.updateNotion(notion);
    }

    @Override
    public int updateNotionType(int ntype, int nid, Date ntime) {
        return notionDao.updateNotionType(ntype, nid, ntime);
    }

    @Override
    public int updateNotionContext(String ncontext, int nid, Date ntime) {
        return notionDao.updateNotionContext(ncontext, nid, ntime);
    }
}
