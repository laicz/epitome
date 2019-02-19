/**
 * Date:     2019/2/1823:06
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 2019/2/18  23:06
 * created by zhoumb
 */
@Configuration
@Import(value = {Person.class})
public class BeanConfig {

    @Bean(value = "abcPerson")
    public Person person(){
        return new Person("",22);
    }
}
