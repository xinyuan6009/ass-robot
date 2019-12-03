package com.xinyuan.assist.web;

import java.util.HashMap;
import java.util.Map;

import com.xinyuan.assist.comm.dingtalk.DtResponse;
import com.xinyuan.assist.service.msg.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewService newService;

    @RequestMapping("/get")
    @ResponseBody
    public DtResponse get() {
        String news = newService.generateNews();
        Map<String, String> fields = new HashMap<>();
        fields.put("news", news);
        return DtResponse.success(fields);
    }
}
