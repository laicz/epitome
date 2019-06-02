/**
 * Date:     2019/6/20:14
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_prediate;

import com.google.common.base.Function;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 2019/6/2  0:14
 * created by zhoumb
 */
public class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        List<T> collect = list.stream().filter(t -> p.test(t)).collect(Collectors.toList());
        return results;
    }

    @Test
    public void getPredicate(){
        Function<String, Boolean> isEmpty = String::isEmpty;
        System.out.println(isEmpty.apply("a"));

        Predicate<String> predicate = (String s) -> s.isEmpty();
        System.out.println(predicate.test("a"));
        Predicate<String> isEmpty3 = StringUtils::isEmpty;
        System.out.println(isEmpty3.test(""));

    }
}
