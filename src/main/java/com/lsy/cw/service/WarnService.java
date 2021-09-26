package com.lsy.cw.service;

import com.lsy.cw.pojo.Warn;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WarnService {
    List<Warn> queryAllWarn();

    Warn queryWarnByWid(int wid);

    List<Warn> queryWarnByUid(int uid);

    List<Warn> queryWarnByStatus(int wstatus);

    List<Warn> queryWarnByUidStatus(int uid, int wstatus);

    int addWarn(Warn warn);

    int deleteWarn(int wid);

    int updateWarnUid(int wid, int uid);

    int updateWarnContent(int wid, String wcontent);

    int updateWarnStatus(int wid, int wstatus);
}
