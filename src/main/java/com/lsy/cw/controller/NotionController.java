package com.lsy.cw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.cw.pojo.Inform;
import com.lsy.cw.pojo.Notion;
import com.lsy.cw.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class NotionController {
    @Autowired
    private NotionService notionService;

    @PostMapping("addnotion")
    public int addNotion(@RequestBody Notion notion){
        int row = notionService.addNotion(notion);
        return row;
    }


    @RequestMapping("/queryallnotion")
    public String queryAllNotion() throws Exception{
        List<Notion> notions = notionService.queryAllNotion();
        return new ObjectMapper().writeValueAsString(notions);
    }
}
