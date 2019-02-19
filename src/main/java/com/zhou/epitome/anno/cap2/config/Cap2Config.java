/**
 * Date:     2019/2/1823:18
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.anno.cap2.config;

import com.zhou.epitome.anno.cap2.anno.MyImport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2019/2/18  23:18
 * created by zhoumb
 */
@Configuration
/*//使用了includeFilters的注解，只会加载当前这个指定注解的类(需要设定userDefaultFilters=false)
@ComponentScan(basePackages = "com.zhou.epitome.anno.cap2", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyImport.class)}, useDefaultFilters = false)*/
@ComponentScan(basePackages = "com.zhou.epitome.anno.cap2"/*, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)}*/)
public class Cap2Config {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap2Config.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }
}
