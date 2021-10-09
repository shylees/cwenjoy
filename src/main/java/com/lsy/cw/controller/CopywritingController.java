package com.lsy.cw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.cw.pojo.Copywriting;
import com.lsy.cw.service.CopywritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class CopywritingController {

    @Autowired
    private CopywritingService copywritingService;

    @RequestMapping("/initcwAll")
    public String queryAllCopywriting() throws JsonProcessingException {
        List<Copywriting> copywritings = copywritingService.queryAllCopyWriting();
        String str = new ObjectMapper().writeValueAsString(copywritings);
//        System.out.println(str);
        return str;
    }

    @RequestMapping("/initcwByType")
    public String queryCopywritingByType(int cwtype) throws Exception{
        List<Copywriting> copywritings = copywritingService.queryCopyWritingByCwtype(cwtype);
        return new ObjectMapper().writeValueAsString(copywritings);
    }

    @RequestMapping("/getcwbycwid")
    public String queryCopywritingByCwid(int cwid) throws Exception{
        Copywriting copywriting = copywritingService.queryCopyWritingByCwid(cwid);
        return new ObjectMapper().writeValueAsString(copywriting);
    }

    @RequestMapping("/getcwbyuid")
    public String queryCopywritingById(int uid) throws Exception{
        List<Copywriting> copywritings = copywritingService.queryCopyWritingByUid(uid);
        return new ObjectMapper().writeValueAsString(copywritings);
    }

    @PostMapping("/addcw")
    public int addCopywriting(@RequestBody Copywriting copywriting){
        System.out.println(copywriting.toString());
        int row = copywritingService.addCopyWriting(copywriting);
        return row;
    }

}
