package com.lsy.cw.service;

import com.lsy.cw.pojo.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CollectService {
    List<Collect> queryAllCollect();

    List<Collect> queryCollectByUid(int uid);

    int addCollect(Collect collect);

    int deleteCollect(int uid, int cwid);

    int updataCollect(Collect collect);
}
