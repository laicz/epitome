/**
 * Date:     2019/2/1920:26
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.anno.cap2.cust_filter;


import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 实现自定义的
 * 2019/2/19  20:26
 * created by zhoumb
 */
public class MyCustomeFilterType implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        metadataReaderFactory.getMetadataReader()
        return false;
    }
}
