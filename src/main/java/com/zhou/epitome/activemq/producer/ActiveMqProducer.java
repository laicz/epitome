/**
 * Date:     2019/1/2523:15
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 2019/1/25  23:15
 * created by zhoumb
 */
@Component
public class ActiveMqProducer {
    @Qualifier(value = "jmsQueueTemplate")
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendQueueTest(String text) {
        jmsTemplate.send("queue_test", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
