/**
 * Date:     2019/1/2523:13
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 2019/1/25  23:13
 * created by zhoumb
 */
@Component
public class ActiveMqListener {

    /**
     * 使用JmsListener注解
     * 通过destination 指定 监听的名字
     * containerFactory指定使用p2p还是pub/sub模式
     *
     * @param text
     */
    @JmsListener(destination = "queue_test", containerFactory = "queueListenerContainer")
    public void queueTest(String text) {
        System.out.println("接收消息: " +text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
