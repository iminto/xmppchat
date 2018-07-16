package com.bai.front.service.impl;

import com.bai.front.dao.entity.ChatRecord;
import com.bai.front.dao.mapper.ChatRecordMapper;
import com.bai.front.service.api.ChatService;
import com.bai.front.service.component.XmppConnUtil;
import com.bai.front.service.model.ChatVO;
import com.bai.front.service.model.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRecordMapper chatRecordMapper;

    @Override
    public ResultApi<Boolean> saveInfo(ChatVO chat) {
        ResultApi api=ResultApi.success();
        ChatRecord chatRecord=new ChatRecord();
        chatRecord.setToUser(chat.getToUser());
        chatRecord.setMsg(chat.getMsg());
        XmppConnUtil conn=new XmppConnUtil();
        try {
            conn.getConn();
            conn.sendMsg(chat.getToUser(),chat.getMsg());
            chatRecordMapper.insertSelective(chatRecord);
            api.setDataObj(chatRecord.getId());
            return api;
        } catch (Exception e) {
            return ResultApi.fail("保存聊天信息失败");
        }
    }
}
