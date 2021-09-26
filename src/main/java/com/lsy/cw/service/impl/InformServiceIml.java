package com.lsy.cw.service.impl;

import com.lsy.cw.dao.InformDao;
import com.lsy.cw.pojo.Inform;
import com.lsy.cw.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("informService")
public class InformServiceIml implements InformService {

    @Autowired
    private InformDao informDao;

    @Override
    public List<Inform> queryAllInform() {
        return informDao.queryAllInform();
    }

    @Override
    public List<Inform> queryInformByUid(int uid) {
        return informDao.queryInformByUid(uid);
    }

    @Override
    public Inform queryInformByInid(int inid) {
        return informDao.queryInformByInid(inid);
    }

    @Override
    public List<Inform> queryInformByStatus(int instatus) {
        return informDao.queryInformByStatus(instatus);
    }

    @Override
    public int addInform(Inform inform) {
        return informDao.addInform(inform);
    }

    @Override
    public int deleteInform(int inid) {
        return informDao.deleteInform(inid);
    }

    @Override
    public int deleteInformByStatus(int instatus) {
        return informDao.deleteInformByStatus(instatus);
    }

    @Override
    public int updateInform(Inform inform) {
        return informDao.updateInform(inform);
    }

    @Override
    public int updateInformStatus(int instatus, int inid) {
        return informDao.updateInformStatus(instatus, inid);
    }
}
