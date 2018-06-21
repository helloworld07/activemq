package com.zcy.service;

import com.alibaba.fastjson.JSON;
import com.zcy.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by zcy on 2018/6/19.
 */
@Service
public class ConsumerService {

    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 接收消息
     */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage)  jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + tm.getText());
            /*Gson gson = new Gson();*/
            Person fromJson = JSON.parseObject(tm.getText(), Person.class);
            System.out.println(fromJson.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return tm;

    }
}
