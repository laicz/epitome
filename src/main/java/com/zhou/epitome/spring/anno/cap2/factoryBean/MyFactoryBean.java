/**
 * Date:     2019/2/1923:13
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2.factoryBean;

import com.zhou.epitome.spring.anno.cap2.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * 2019/2/19  23:13
 * created by zhoumb
 */
public class MyFactoryBean implements FactoryBean<Monkey> {
    @Override
    public Monkey getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
