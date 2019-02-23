/**
 * Date:     2019/2/2311:07
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 2019/2/23  11:07
 * created by zhoumb
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return bean;
    }
}
