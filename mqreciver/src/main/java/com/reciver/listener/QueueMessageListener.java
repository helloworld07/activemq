package com.reciver.listener;

import com.alibaba.fastjson.JSON;
import com.reciver.model.Person;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zcy on 2018/6/19.
 */
public class QueueMessageListener implements MessageListener {
    //当收到消息后，自动调用该方法
    @Override
    public void onMessage(Message message) {

        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());

            Person fromJson = JSON.parseObject(tm.getText(), Person.class);
            System.out.println(fromJson.toString());

            //do something ...
        } catch (JMSException e){ e.printStackTrace();
        }
    }
}
