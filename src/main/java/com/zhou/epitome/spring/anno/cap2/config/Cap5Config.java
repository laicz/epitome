/**
 * Date:     2019/2/1921:45
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2.config;

import com.zhou.epitome.spring.anno.cap2.condition.LinuxCondition;
import com.zhou.epitome.spring.anno.cap2.condition.WindowCondition;
import com.zhou.epitome.spring.anno.cap2.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 2019/2/19  21:45
 * created by zhoumb
 */
@Configuration
public class Cap5Config {
    @Conditional(value = WindowCondition.class)
    @Bean("person")
    public Person person() {
        System.out.println("开始实例化.... person");
        return new Person("person", 20);
    }

    @Conditional(LinuxCondition.class)
    @Bean("lison")
    public Person lison() {
        System.out.println("开始实例化.... lison");
        return new Person("person", 20);
    }

    @Bean("james")
    public Person james() {
        System.out.println("开始实例化.... james");
        return new Person("person", 20);
    }
}
