package com.xinyuan.assist.web;

import java.util.HashMap;
import java.util.Map;

import com.xinyuan.assist.comm.dingtalk.DtResponse;
import com.xinyuan.assist.service.api.onew.CibaOwRet;
import com.xinyuan.assist.service.api.onew.CibaService;
import com.xinyuan.assist.service.msg.onew.OnewService;
import com.xinyuan.assist.util.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/onew")
public class OnewordController {

    @Autowired
    private CibaService cibaService;

    @Autowired
    private OnewService onewService;

    @RequestMapping("/get")
    @ResponseBody
    public DtResponse get() {
        CibaOwRet ret = cibaService.get();
        Map<String, String> fields = ReflectUtil.objectToMap(ret);
        return DtResponse.success(fields);
    }

    @RequestMapping("/push")
    @ResponseBody
    public DtResponse push() {
        onewService.push();
        return DtResponse.success(null);
    }

}
