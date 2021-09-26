package com.lsy.cw.service.impl;

import com.lsy.cw.dao.WarnDao;
import com.lsy.cw.pojo.Warn;
import com.lsy.cw.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("warnService")
public class WarnServiceImpl implements WarnService {

    @Autowired
    private WarnDao warnDao;

    @Override
    public List<Warn> queryAllWarn() {
        return warnDao.queryAllWarn();
    }

    @Override
    public Warn queryWarnByWid(int wid) {
        return warnDao.queryWarnByWid(wid);
    }

    @Override
    public List<Warn> queryWarnByUid(int uid) {
        return warnDao.queryWarnByUid(uid);
    }

    @Override
    public List<Warn> queryWarnByStatus(int wstatus) {
        return warnDao.queryWarnByStatus(wstatus);
    }

    @Override
    public List<Warn> queryWarnByUidStatus(int uid, int wstatus) {
        return warnDao.queryWarnByUidStatus(uid, wstatus);
    }

    @Override
    public int addWarn(Warn warn) {
        return warnDao.addWarn(warn);
    }

    @Override
    public int deleteWarn(int wid) {
        return warnDao.deleteWarn(wid);
    }

    @Override
    public int updateWarnUid(int wid, int uid) {
        return warnDao.updateWarnUid(wid, uid);
    }

    @Override
    public int updateWarnContent(int wid, String wcontent) {
        return warnDao.updateWarnContent(wid, wcontent);
    }

    @Override
    public int updateWarnStatus(int wid, int wstatus) {
        return warnDao.updateWarnStatus(wid, wstatus);
    }
}
