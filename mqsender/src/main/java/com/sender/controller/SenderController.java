package com.sender.controller;

import com.alibaba.fastjson.JSON;
import com.sender.service.ProducerService;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zcy on 2018/6/19.
 */
@Controller
public class SenderController {

    @Autowired
    private ProducerService producer;

    //订阅者和队列模式需要修改此处demoTopicDestination/demoQueueDestination
    @Autowired
    @Qualifier("demoTopicDestination")
    private ActiveMQTopic demoTopicDestination;//通过@Qualifier修饰符来注入对应的bean
    //发送queue消息
    @RequestMapping(value="/send",method= RequestMethod.POST)
    public ModelAndView producer() {
        System.out.println("------------send to jms");
        com.alibaba.fastjson.JSONObject jsonObj = new com.alibaba.fastjson.JSONObject();
        jsonObj.put("name", "张三");
        jsonObj.put("sex", "男");
        jsonObj.put("age", 20);
        String resultjson= JSON.toJSONString(jsonObj);
        ModelAndView mv = null;
        producer.sendMessage(demoTopicDestination, resultjson);
        mv=new ModelAndView("send");
        return mv;
    }
}
