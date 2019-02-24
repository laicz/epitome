/**
 * Date:     2019/2/2317:36
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.aop.config;

import com.zhou.epitome.spring.aop.bean.Calculator;
import com.zhou.epitome.spring.aop.log.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 2019/2/23  17:36
 * created by zhoumb
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
