/**
 * MelonKid.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.xinyuan.assist.service.msg;

import com.xinyuan.assist.service.PushTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author melonkid
 * @version $Id: MsgAbstractService.java, v 0.1 2019年12月03日 17:29 melonkid Exp $
 */
@Component
public class MsgAbstractService {

    @Autowired
    protected PushTemplate pushTemplate;


}