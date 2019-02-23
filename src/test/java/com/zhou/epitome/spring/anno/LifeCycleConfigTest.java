/**
 * Date:     2019/2/2121:41
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno;

import com.zhou.epitome.spring.lifeCycle.config.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/2/21  21:41
 * created by zhoumb
 */
public class LifeCycleConfigTest {
    @Test
    public void importBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        /*String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }*/
        System.out.println("IOC 容器启动完成");
        applicationContext.close();
    }
}
