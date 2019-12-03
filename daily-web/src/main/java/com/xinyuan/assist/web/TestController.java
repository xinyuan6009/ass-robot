package com.xinyuan.assist.web;

import com.xinyuan.assist.service.msg.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private NewService newService;

    @RequestMapping("/news")
    public String news(){
        newService.push();
        return "/index.html";
    }
}
