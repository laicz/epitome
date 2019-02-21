/**
 * Date:     2019/2/1920:26
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cust_filter;


import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 实现自定义的的TypeFilter,用于@ComponentScan使用
 * 2019/2/19  20:26
 * created by zhoumb
 */
public class MyCustomeFilterType implements TypeFilter {
    /**
     * 根据类的信息决定是否加载到spring 容器中
     *
     * @param metadataReader        读取当前正在扫描类的信息
     * @param metadataReaderFactory 可以获取到其它任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取类使用的注解
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的资源信息
        Resource resource = metadataReader.getResource();
        System.out.println("---------->" + classMetadata.getClassName());
        return classMetadata.getClassName().contains("Enable");
    }
}
