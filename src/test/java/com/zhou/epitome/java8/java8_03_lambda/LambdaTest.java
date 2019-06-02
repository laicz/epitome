/**
 * Date:     2019/6/122:41
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda;

import org.junit.Test;

/**
 * 2019/6/1  22:41
 * created by zhoumb
 */
public class LambdaTest {

    /**
     * 函数式接口
     * 只有一个抽象接口都是函数式接口
     */
    @Test
    public void functionInterface() throws InterruptedException {
        // () -> void 表示函数接口的参数列表为null，返回值也为void
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " print : Hello,Word ! ");
        new Thread(runnable).start();
        Thread.sleep(1000L);
    }

    @Test
    public void testProcess(){
        process(() -> System.out.println("lambda  .... "));
    }

    public void process(Runnable runnable){
        runnable.run();
    }

}
