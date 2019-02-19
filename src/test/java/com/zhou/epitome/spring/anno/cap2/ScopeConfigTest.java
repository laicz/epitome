/**
 * Date:     2019/2/1920:54
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2;

import com.zhou.epitome.spring.anno.cap2.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/2/19  20:54
 * created by zhoumb
 */
public class ScopeConfigTest {
    @Test
    public void singleTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
        Object person = applicationContext.getBean("person");
        Object person1 = applicationContext.getBean("person");
        System.out.println(person == person1);

        Object person11 = applicationContext.getBean("person1");
        Object person12 = applicationContext.getBean("person1");
        System.out.println(person11 == person12);

        Object showEnableService1 = applicationContext.getBean("showEnableService");
        Object showEnableService2 = applicationContext.getBean("showEnableService");
        System.out.println(showEnableService1 == showEnableService2);
    }
}
