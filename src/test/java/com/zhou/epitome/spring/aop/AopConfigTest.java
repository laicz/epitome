/**
 * Date:     2019/2/2319:54
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.aop;

import com.zhou.epitome.spring.aop.bean.Calculator;
import com.zhou.epitome.spring.aop.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019/2/23  19:54
 * created by zhoumb
 */
public class AopConfigTest {
    @Test
    public void div() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");
        System.out.println(calculator.div(12, 3));
    }
}
