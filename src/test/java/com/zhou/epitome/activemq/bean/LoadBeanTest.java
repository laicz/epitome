/**
 * Date:     2019/2/1823:00
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.bean;

import com.zhou.epitome.bean.BeanConfig;
import com.zhou.epitome.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2019/2/18  23:00
 * created by zhoumb
 */
public class LoadBeanTest {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        System.out.println("----------------------");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }*/
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }
}
