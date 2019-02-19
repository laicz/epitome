/**
 * Date:     2019/2/1019:52
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.activemq.base;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 实现callable接口的测试类
 * 2019/2/10  19:52
 * created by zhoumb
 */
public class CallableTest {
    public static void main(String[] args) throws Exception {
        CallableTest callableTest = new CallableTest();
        MyCallable myCallable = callableTest.new MyCallable();
        long st = System.currentTimeMillis();
        Future<String> future = Executors.newSingleThreadExecutor().submit(myCallable);
        callableTest.sleep(5000);
        System.out.println("执行异步线程，共耗时：" + (System.currentTimeMillis() - st));
        System.out.println(future.get() + " ， 共耗时：" + (System.currentTimeMillis() - st));
    }

    class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            sleep(3000);
            return "call able return result ";
        }
    }

    public void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
