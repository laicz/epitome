/**
 * Date:     2019/2/1922:58
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2.importBeanDefinitionRegistrar;

import com.zhou.epitome.spring.anno.cap2.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 2019/2/19  22:58
 * created by zhoumb
 */
public class MyImportBeanDefinitionResigtrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               对象注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //利用注册来进行对象注册
        registry.registerBeanDefinition("pig", new RootBeanDefinition(Pig.class));
    }
}
