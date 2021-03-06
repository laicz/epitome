/**
 * Date:     2019/2/1921:58
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 2019/2/19  21:58
 * created by zhoumb
 */
public class WindowCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        return property.contains("Windows");
    }
}