package com.xinyuan.assist.web;

import com.xinyuan.assist.service.msg.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/news")
    public String news(){
        newsService.push();
        return "/index.html";
    }
}
