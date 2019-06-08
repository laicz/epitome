/**
 * Date:     2019/6/816:06
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.concurrent;

import org.junit.Test;

/**
 * 2019/6/8  16:06
 * created by zhoumb
 */
public class ShutdownHookTest {

    @Test
    public void testShutdownHook() {
        addShutdownHook();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动")).start();
        ShutdownHookTest.sleep();
        System.out.println("主线程执行完毕");
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("其他线程均已关闭，开始启动清理线程")));
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
