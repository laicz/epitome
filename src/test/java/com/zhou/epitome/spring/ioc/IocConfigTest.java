/**
 * Date:     2019/2/2410:33
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.ioc;

import com.zhou.epitome.spring.ioc.config.IocConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/2/24  10:33
 * created by zhoumb
 */
public class IocConfigTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig.class);
        printBeanName(applicationContext);
        applicationContext.close();
    }

    private void printBeanName(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
