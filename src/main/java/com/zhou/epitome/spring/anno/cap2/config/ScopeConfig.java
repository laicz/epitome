/**
 * Date:     2019/2/1920:51
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2.config;

import com.zhou.epitome.spring.anno.cap2.anno.MyImport;
import com.zhou.epitome.spring.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 2019/2/19  20:51
 * created by zhoumb
 */
@Configuration
@ComponentScan(basePackages = "com.zhou.epitome.spring.anno.cap2", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyImport.class)})
public class ScopeConfig {

    @Bean
    public Person person() {
        return new Person();
    }

    @Bean(name = "person1")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person person1() {
        return new Person();
    }
}
