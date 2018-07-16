package com.bai.front.service.api;

import com.bai.front.service.model.ChatVO;
import com.bai.front.service.model.ResultApi;

public interface ChatService {

    ResultApi<Boolean> saveInfo(ChatVO chat);
}
