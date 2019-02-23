/**
 * Date:     2019/2/2316:41
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 2019/2/23  16:41
 * created by zhoumb
 */
@Component
public class Plane implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
