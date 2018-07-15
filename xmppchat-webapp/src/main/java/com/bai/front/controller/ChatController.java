package com.bai.front.controller;

import com.bai.front.dao.entity.ChatRecord;
import com.bai.front.service.api.ChatService;
import com.bai.front.service.model.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/chat")
public class ChatController {

    @Autowired
    ChatService userInfoService;

    @RequestMapping(value="/send")
    @ResponseBody
    public ResultApi<Boolean> saveInfo(@RequestBody ChatRecord chat){
        return userInfoService.saveInfo(chat);
    }

}
