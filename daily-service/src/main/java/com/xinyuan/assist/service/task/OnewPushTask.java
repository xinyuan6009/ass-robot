/**
 * MelonKid.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xinyuan.assist.service.task;

import com.xinyuan.assist.service.msg.onew.OnewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author melonkid
 * @version $Id: NewsPushTask.java, v 0.1 2019年12月04日 10:23 melonkid Exp $
 */
@Component
public class OnewPushTask {

    @Autowired
    private OnewService onewService;

    @Scheduled(cron = "${job.dingtalk.news.schedule}")
    public void push(){
        onewService.push();
    }
}