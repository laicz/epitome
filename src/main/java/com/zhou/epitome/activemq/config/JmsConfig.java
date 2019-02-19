/**
 * Date:     2019/1/2522:35
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.destination.DestinationResolver;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Session;

/**
 * 2019/1/25  22:35
 * created by zhoumb
 */
@Configuration
@EnableJms
public class JmsConfig {

    private final ObjectProvider<DestinationResolver> destinationResolver;
    private final ObjectProvider<MessageConverter> messageConverter;
    private final CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    public JmsConfig(ObjectProvider<DestinationResolver> destinationResolver, ObjectProvider<MessageConverter> messageConverter, CachingConnectionFactory cachingConnectionFactory) {
        this.destinationResolver = destinationResolver;
        this.messageConverter = messageConverter;
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    /**
     * p2p模式的 jmsTemplate
     *
     * @return
     */
    @Bean(name = "jmsQueueTemplate")
    public JmsTemplate jmsQueueTemplate() {
        //使用缓存池  优化连接工厂
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
        //设置发布类型  queue类型
        jmsTemplate.setPubSubDomain(Boolean.FALSE);

        //配置为true才能让设置 deliveryMode,priority,timeToLive 生效
        jmsTemplate.setExplicitQosEnabled(Boolean.TRUE);
        //设置消息持久化类型 DeliverMode.NON_PERSISTENT : 非持久化  DeliverMode_PERSISTENT : 持久化
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        //设施是否开启事务 默认是不开启事务
        //如果session带有事务，则事务提交成功，消息自动被签收，事务回滚，则消息会被再次消息
        //jmsTemplate.setSessionTransacted(true);

        //不带事务的session的签收方式，取决于session的配置
        //Session.AUTO_ACKNOWLEDGE  消息自动签收
        //Session.CLIENT_ACKNOWLEDGE需要客户端调动acknowledge方法来手动签收
        //Session.DUPS_OK_ACKNOWLEDGE不用签收，消息可能重复发送
        jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return jmsTemplate;
    }

    /**
     * pub/sub的订阅模式的 jmsTemplate
     *
     * @return
     */
    @Bean(name = "jmsTopicTemplate")
    public JmsTemplate jmsTopicTemplate() {
        //使用缓存池  优化连接工厂
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
        //设置发布类型  topic类型
        jmsTemplate.setPubSubDomain(Boolean.TRUE);

        //配置为true才能让设置 deliveryMode,priority,timeToLive 生效
        jmsTemplate.setExplicitQosEnabled(Boolean.TRUE);
        //设置消息持久化类型 DeliverMode.NON_PERSISTENT : 非持久化  DeliverMode_PERSISTENT : 持久化
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        //设施是否开启事务 默认是不开启事务
        //如果session带有事务，则事务提交成功，消息自动被签收，事务回滚，则消息会被再次消息
        //jmsTemplate.setSessionTransacted(true);

        //不带事务的session的签收方式，取决于session的配置
        //Session.AUTO_ACKNOWLEDGE  消息自动签收
        //Session.CLIENT_ACKNOWLEDGE需要客户端调动acknowledge方法来手动签收
        //Session.DUPS_OK_ACKNOWLEDGE不用签收，消息可能重复发送
        jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return jmsTemplate;
    }


    //topic模式的listenerContainer
    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        return defaultJmsListenerContainerFactory;
    }

    //queue模式的listenerContainer
    @Bean
    public JmsListenerContainerFactory queueListenerContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return defaultJmsListenerContainerFactory;
    }
}
