package com.syning.service;


import com.syning.entity.Message;
import com.syning.entity.MessageExample;
import com.syning.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Transactional(readOnly = true)
    public List<Message> getMessageList() {
        List<Message> messageList = messageMapper.selectByExample(null);
        return messageList;
    }



    @Transactional(readOnly = true)
    public Message getMessageById(Integer mid) {
        // 设置条件
        MessageExample example = new MessageExample();
        example.createCriteria().andMidEqualTo(mid);

        // 查询
        List<Message> lst = messageMapper.selectByExample(example);

        // 如果集合为空，则数据库中没有数据
        if (lst != null && lst.size() > 0) {
            return lst.get(0);
        }

        return null;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addMessage(Message message) {
        return messageMapper.insert(message);
    }


    // 为消息设置回复
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int putReply(Message message) {

        // 根据主键设置回复，如果字段为空则不设置
        return messageMapper.updateByPrimaryKeySelective(message);
    }


    // 按照消息 mid 删除消息
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int delMessage(Integer mid) {
        // 根据主键删除数据
        return messageMapper.deleteByPrimaryKey(mid);
    }



}
