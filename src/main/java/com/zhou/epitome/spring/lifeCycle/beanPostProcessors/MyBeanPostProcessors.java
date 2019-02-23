/**
 * Date:     2019/2/2123:12
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 2019/2/21  23:12
 * created by zhoumb
 */
@Component
public class MyBeanPostProcessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("*************  beanClass=" + bean.getClass() + " -> beanName" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------------  beanClass=" + bean.getClass() + " -> beanName" + beanName);
        return bean;
    }
}
