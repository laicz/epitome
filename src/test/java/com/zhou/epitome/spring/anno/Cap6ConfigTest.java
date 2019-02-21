/**
 * Date:     2019/2/1922:40
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno;

import com.zhou.epitome.spring.anno.config.Cap6Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/2/19  22:40
 * created by zhoumb
 */
public class Cap6ConfigTest {

    @Test
    public void importTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap6Config.class);
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        Object myFactoryBean2 = applicationContext.getBean("&myFactoryBean");
        System.out.println("------------------------------");
        System.out.println(myFactoryBean);
        System.out.println(myFactoryBean2);
        System.out.println("------------------------------");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
