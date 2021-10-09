package com.lsy.cw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.cw.dao.CollectDao;
import com.lsy.cw.pojo.Collect;
import com.lsy.cw.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping("/initcollectbyid")
    public String queryAllCollectById(int uid) throws JsonProcessingException {
        List<Collect> collects = collectService.queryCollectByUid(uid);
        return new ObjectMapper().writeValueAsString(collects);
    }

    @PostMapping("/addcollect")
    public int addCollect(@RequestBody Collect collect){
        int row = collectService.addCollect(collect);
        return row;
    }

    @PostMapping("/deletecollect")
    public int deleteCollect(@RequestBody Collect collect){
        int row = collectService.deleteCollect(collect.getUid(),collect.getCwid());
        return row;
    }


}
