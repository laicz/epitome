/**
 * Date:     2019/4/3017:18
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 2019/4/30  17:18
 * created by zhoumb
 */
public class ThreadTest {

    @Test
    public void testSameMethod() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                sameMethod();
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(() -> {
            try {
                sameMethod();
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
        countDownLatch.await();
        System.out.println("全部执行结束 ...... ");
    }

    private void sameMethod() throws InterruptedException {
        System.out.println("当前线程" + Thread.currentThread().getName() + " 开始执行 ......  ");
        Thread.sleep(10000);
        System.out.println("当前线程" + Thread.currentThread().getName() + " 执行结束 ......  ");

    }
}
