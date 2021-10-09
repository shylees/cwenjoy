package com.lsy.cw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.cw.pojo.Inform;
import com.lsy.cw.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class InformController {
    @Autowired
    private InformService informService;

    @RequestMapping("/queryAllInform")
    public String queryAllInform() throws Exception{
        List<Inform> informs = informService.queryAllInform();
        return new ObjectMapper().writeValueAsString(informs);
    }

    @RequestMapping("/getallinformbystatusz")
    public String queryInformByStatus() throws Exception{
        List<Inform> informs = informService.queryInformByStatus(0);
        return new ObjectMapper().writeValueAsString(informs);
    }


    @PostMapping("/addinform")
    public int addInform(@RequestBody Inform inform){
        int row = informService.addInform(inform);
        return row;
    }

    @RequestMapping("updateinformsolvestatus")
    public int updateInformSolveStautes(Integer inid){
        int instatus =1;
        int row = informService.updateInformStatus(instatus,inid);
        return row;
    }


}
