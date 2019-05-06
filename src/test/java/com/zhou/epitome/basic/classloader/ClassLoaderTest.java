/**
 * Date:     2019/4/1721:28
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.classloader;

import com.sun.org.apache.xml.internal.security.Init;
import org.junit.Test;

/**
 * 2019/4/17  21:28
 * created by zhoumb
 */
public class ClassLoaderTest {
    @Test
    public void classLoaderPath() {
        //打印ExtClassLoader加载类的路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //打印AppClassLoader加载类的路径
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void testInit() throws ClassNotFoundException {
//        Class<Init> initClass = Init.class;
//        Class<?> aClass = Class.forName("com.zhou.epitome.basic.classloader.InitClass");
        Class<?> aClass = Class.forName("com.zhou.epitome.basic.classloader.InitClass", true, this.getClass().getClassLoader());

    }
}
