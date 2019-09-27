package com.xinyuan.assist.web;

import com.xinyuan.assist.service.VisiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VisitController {

    @Autowired
    private VisiterService visiterService;

    @RequestMapping("/love")
    public String sayLove(int num){
        visiterService.visitCtLog();
        return "/"+num+"/index.html";
    }
}
