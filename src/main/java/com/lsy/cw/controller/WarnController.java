package com.lsy.cw.controller;

import com.lsy.cw.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",maxAge = 3600)
public class WarnController {
    @Autowired
    private WarnService warnService;
}
