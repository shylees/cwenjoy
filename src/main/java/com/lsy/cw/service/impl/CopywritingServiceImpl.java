package com.lsy.cw.service.impl;

import com.lsy.cw.dao.CopywritingDao;
import com.lsy.cw.pojo.Copywriting;
import com.lsy.cw.service.CopywritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("copywritingService")
public class CopywritingServiceImpl implements CopywritingService {

    @Autowired
    private CopywritingDao copywritingDao;

    @Override
    public List<Copywriting> queryAllCopyWriting(){
        return copywritingDao.queryAllCopyWriting();
    }

    @Override
    public Copywriting queryCopyWritingByCwid(int cwid){
        return copywritingDao.queryCopyWritingByCwid(cwid);
    }

    @Override
    public List<Copywriting> queryCopyWritingByUid(int uid){
        return copywritingDao.queryCopyWritingByUid(uid);
    }

    @Override
    public List<Copywriting> queryCopyWritingByCwtype(int cwtype){
        return copywritingDao.queryCopyWritingByCwtype(cwtype);
    }

    @Override
    public int addCopyWriting(Copywriting copywriting){
        return copywritingDao.addCopyWriting(copywriting);
    }

    @Override
    public int deleteCopyWriting(int cwid){
        return copywritingDao.deleteCopyWriting(cwid);
    }

    @Override
    public int updateCopyWriting(Copywriting copywriting){
        return copywritingDao.updateCopyWriting(copywriting);
    }
}
