/**
 * Date:     2019/2/1921:48
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno;

import com.zhou.epitome.spring.anno.config.Cap5Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * #FactoryBean  可以将实例Bean通过FactoryBean注入到容器中
 * #BeanFactory  可以从容器中获取实例化后的bean
 * 2019/2/19  21:48
 * created by zhoumb
 */
public class Cap5ConfigTest {
    @Test
    public void init(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap5Config.class);
    }
}
