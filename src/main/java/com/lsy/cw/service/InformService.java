package com.lsy.cw.service;

import com.lsy.cw.pojo.Inform;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InformService {
    List<Inform> queryAllInform();

    List<Inform> queryInformByUid(int uid);

    Inform queryInformByInid(int inid);

    List<Inform> queryInformByStatus(int instatus);

    int addInform(Inform inform);

    int deleteInform(int inid);

    int deleteInformByStatus(int instatus);

    int updateInform(Inform inform);

    int updateInformStatus(int instatus, int inid);
}
