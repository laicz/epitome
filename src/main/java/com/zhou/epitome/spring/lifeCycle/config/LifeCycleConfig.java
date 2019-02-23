/**
 * Date:     2019/2/2121:37
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.config;

import com.zhou.epitome.spring.lifeCycle.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 2019/2/21  21:37
 * created by zhoumb
 */
@Configuration
//@Import(value = {Bike.class})
@ComponentScan(basePackages = "com.zhou.epitome.spring.lifeCycle")
public class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bike bike() {
        return new Bike();
    }
}
