package com.lsy.cw.service.impl;

import com.lsy.cw.dao.CollectDao;
import com.lsy.cw.pojo.Collect;
import com.lsy.cw.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("collectService")
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;


    @Override
    public List<Collect> queryAllCollect() {
        return collectDao.queryAllCollect();
    }

    @Override
    public List<Collect> queryCollectByUid(int uid) {
        return collectDao.queryCollectByUid(uid);
    }

    @Override
    public int addCollect(Collect collect) {
        return collectDao.addCollect(collect);
    }

    @Override
    public int deleteCollect(int uid, int cwid) {
        return collectDao.deleteCollect(uid, cwid);
    }

    @Override
    public int updataCollect(Collect collect) {
        return collectDao.updataCollect(collect);
    }
}
