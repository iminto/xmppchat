package com.bai.front.dao.mapper;

import com.bai.front.dao.entity.ChatRecord;

public interface ChatRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ChatRecord record);

    ChatRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatRecord record);
}