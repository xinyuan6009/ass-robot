package com.xinyuan.assist.web;

import java.util.HashMap;
import java.util.Map;

import com.xinyuan.assist.comm.dingtalk.DtResponse;
import com.xinyuan.assist.service.msg.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/get")
    @ResponseBody
    public DtResponse get() {
        String news = newsService.generateNews();
        Map<String, String> fields = new HashMap<>();
        fields.put("news", news);
        return DtResponse.success(fields);
    }
}
