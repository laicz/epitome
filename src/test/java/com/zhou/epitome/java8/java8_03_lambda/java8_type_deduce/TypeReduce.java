/**
 * Date:     2019/6/223:13
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_type_deduce;

import org.junit.Test;

/**
 * 2019/6/2  23:13
 * created by zhoumb
 */
public class TypeReduce {

    /**
     * lambda表达式引用的局部变量必须是最终的(final)或是事实上最终的
     * 这是因为实例变量都存储在堆中，而局部变量则保存在栈上，
     */
    @Test
    public void reduce(){
        Integer portNumber = 1333247;
        Runnable r = () -> System.out.println(portNumber);
    }


}
