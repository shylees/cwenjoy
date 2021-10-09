package com.lsy.cw.controller;

import com.lsy.cw.dao.CollectDao;
import com.lsy.cw.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class CollectController {
    @Autowired
    private CollectService collectService;



}
