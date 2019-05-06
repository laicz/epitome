/**
 * Date:     2019/4/1822:34
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.reference;

/**
 * 一个普通对象
 * 2019/4/18  22:34
 * created by zhoumb
 */
public class NormalObject {
    private String name;

    public NormalObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("normal object is finalize : " + name);
    }
}
