package com.bai.front.service.api;

import com.bai.front.dao.entity.ChatRecord;
import com.bai.front.service.model.ResultApi;

public interface ChatService {

    ResultApi<Boolean> saveInfo(ChatRecord chat);
}
