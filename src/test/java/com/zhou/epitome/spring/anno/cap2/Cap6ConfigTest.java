/**
 * Date:     2019/2/1922:40
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2;

import com.zhou.epitome.spring.anno.cap2.config.Cap6Config;
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
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
