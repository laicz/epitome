/**
 * Date:     2019/6/20:39
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 2019/6/2  0:39
 * created by zhoumb
 */
public class FunctionTest {

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    @Test
    public void testMap() {
        List<Integer> map = map(Arrays.asList("dafasdfg", "fdgdshhfghghg", "etetrettrgdg"), s -> s.length());
        for (Integer integer : map) {
            System.out.println(integer);
        }
    }
}
