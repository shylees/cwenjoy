package com.lsy.cw.service;

import com.lsy.cw.pojo.Copywriting;

import java.util.Date;
import java.util.List;

public interface CopywritingService {

    List<Copywriting> queryAllCopyWriting();

    Copywriting queryCopyWritingByCwid(int cwid);

    List<Copywriting> queryCopyWritingByUid(int uid);

    List<Copywriting> queryCopyWritingByCwtype(int cwtype);

    int addCopyWriting(Copywriting copywriting);

    int deleteCopyWriting(int cwid);

    int updateCopyWriting(Copywriting copywriting);
}
