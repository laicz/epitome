/**
 * Date:     2019/1/2522:42
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.config;

import com.zhou.epitome.EpitomeApplication;
import com.zhou.epitome.activemq.listener.ActiveMqListener;
import com.zhou.epitome.activemq.producer.ActiveMqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 2019/1/25  22:42
 * created by zhoumb
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EpitomeApplication.class)
public class JmsConfigTest {

    @Autowired
    private DefaultJmsListenerContainerFactory queueListenerContainer;
    @Autowired
    private DefaultJmsListenerContainerFactory topicListenerContainer;
    @Autowired
    private ActiveMqProducer producer;
    @Autowired
    private ActiveMqListener activeMqListener;

    @Test
    public void testLoadConfig() {
        System.out.println(queueListenerContainer);
        System.out.println(topicListenerContainer);
    }

    @Test
    public void testSendQueue() throws InterruptedException {
        new Thread(() -> {
            int count = 0;
            while (true) {
                long st = System.currentTimeMillis();
                count++;
                producer.sendQueueTest("test_queue_text" + count);
                System.out.println("发送消息: " + count + " 耗时 : " + (System.currentTimeMillis() - st) + " ms");
            }
        }).start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
