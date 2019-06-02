/**
 * Date:     2019/6/20:23
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_consumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * 2019/6/2  0:23
 * created by zhoumb
 */
public class ConsumerTest {

    /**
     * 方法的泛型需要在返回值之前定义泛型类型
     *
     * @param list
     * @param <T>
     */
    public static <T> void foreach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    @Test
    public void testForeach() {
        foreach(Arrays.asList(1, 2, 3, 4, 5), i -> System.out.println(i));

        Consumer<String> consumer = (String s) -> System.out.println(s);
        //consumer 在 accept的时候会将创建consumer的时候的行为执行
        consumer.accept(randomReturn());
    }

    public String randomReturn() {
        return String.valueOf(new Random().nextInt(1000));
    }

}
