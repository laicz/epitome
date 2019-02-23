/**
 * Date:     2019/2/2317:06
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.getBean;

import com.zhou.epitome.spring.getBean.config.LoadBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 加载Bean对象的
 * 2019/2/23  17:06
 * created by zhoumb
 */
public class LoadBeanConfigTest {

    @Test
    public void loadBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LoadBeanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("bird"));

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("bird.color"));
    }
}
