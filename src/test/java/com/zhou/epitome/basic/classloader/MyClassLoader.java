/**
 * Date:     2019/4/1721:37
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.classloader;

/**
 * 2019/4/17  21:37
 * created by zhoumb
 */
public class MyClassLoader extends ClassLoader {
/*
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
*/

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }


}
