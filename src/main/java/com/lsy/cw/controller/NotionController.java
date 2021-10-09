package com.lsy.cw.controller;

import com.lsy.cw.pojo.Notion;
import com.lsy.cw.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
