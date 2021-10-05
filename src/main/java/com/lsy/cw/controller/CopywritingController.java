package com.lsy.cw.controller;

import com.lsy.cw.pojo.Copywriting;
import com.lsy.cw.service.CopywritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopywritingController {

    @Autowired
    private CopywritingService copywritingService;

    @RequestMapping("/initcwAll")
    public String queryAllCopywriting(){
        List<Copywriting> copywritings = copywritingService.queryAllCopyWriting();
        StringBuilder res = new StringBuilder();
        for(Copywriting cw : copywritings){
            res.append(copywritings.toString() + "\n");
        }
        return res.toString();
    }
}
