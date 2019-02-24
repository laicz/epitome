/**
 * Date:     2019/2/2410:28
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2019/2/24  10:28
 * created by zhoumb
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("myBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry ... bean count=" + registry.getBeanDefinitionCount());
        registry.registerBeanDefinition("haha", new RootBeanDefinition(String.class));
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(AtomicInteger.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("111", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("myBeanDefinitionRegistryPostProcessor postProcessBeanFactory ... bean count=" + beanFactory.getBeanDefinitionCount());
    }
}
