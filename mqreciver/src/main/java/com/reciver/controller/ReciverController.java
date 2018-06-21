package com.reciver.controller;

import com.reciver.reciver.ConsumerService;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by zcy on 2018/6/19.
 */
@Controller
public class ReciverController {

    @Autowired
    private ConsumerService consumer;

    //订阅者和队列模式需要修改此处demoTopicDestination/demoQueueDestination
    @Autowired
    @Qualifier("demoTopicDestination")
    private ActiveMQTopic demoTopicDestination;//通过@Qualifier修饰符来注入对应的bean

    //如果不需要监听器想手动去接收消息的方式
    @RequestMapping(value="/receive",method=RequestMethod.GET)
    public ModelAndView queue_receive() throws JMSException {
        System.out.println("------------receive message");
        ModelAndView mv = new ModelAndView();

        TextMessage tm = consumer.receive(demoTopicDestination);
        mv.addObject("textMessage", tm.getText());

        mv.setViewName("queue_receive");
        return mv;
    }
}
