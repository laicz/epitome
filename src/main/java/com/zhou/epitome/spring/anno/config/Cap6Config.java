/**
 * Date:     2019/2/1922:07
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.config;

import com.zhou.epitome.spring.anno.factoryBean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 给容器注册组件的方式
 * ①：使用@Bean，导入第三方的类
 * ②：包扫描和组件的标注扫描
 * ③：Import，给容器快速导入一个组件
 * ④：ImportBeanDefinitionRegistrar
 * 2019/2/19  22:07
 * created by zhoumb
 */
@Configuration()
@ComponentScan(basePackages = "com.zhou.epitome.spring.anno")
//@Import(value = {Dog.class, MyImportSelector.class, MyImportBeanDefinitionResigtrar.class})
//使用import导入组件，bean的id默认全路径名
public class Cap6Config {

    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }
}
