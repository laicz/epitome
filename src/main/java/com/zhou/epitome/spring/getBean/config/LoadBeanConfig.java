/**
 * Date:     2019/2/2317:05
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.getBean.config;

import com.zhou.epitome.spring.getBean.bean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 2019/2/23  17:05
 * created by zhoumb
 */
@Configuration
@PropertySource(value = "classpath:spring-my.properties")
public class LoadBeanConfig {

    @Bean
    public Bird bird() {
        return new Bird();
    }
}
