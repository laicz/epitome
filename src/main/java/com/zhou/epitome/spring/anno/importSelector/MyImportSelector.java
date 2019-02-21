/**
 * Date:     2019/2/1922:46
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义ImportSelector
 * 2019/2/19  22:46
 * created by zhoumb
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回全类型数组，spring将会实例化该对象放入对象容器中
     * @param importingClassMetadata    Import注解的信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"Fish"};
    }
}
