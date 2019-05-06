/**
 * Date:     2019/5/211:21
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.basic.lamada;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/5/2  11:21
 * created by zhoumb
 */
public class StreamTest {

    @Test
    public void testStreamIsNewThread() {
        System.out.println(Thread.currentThread().getName());
        List<Integer> stringList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            stringList.add(i);
        }
        stringList.parallelStream().forEach(str -> {
            System.out.println("当前线程" + Thread.currentThread().getName() + " : str =" + str);
        });
    }
}
