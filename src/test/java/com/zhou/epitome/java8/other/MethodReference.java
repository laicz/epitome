/**
 * Date:     2019/5/315:50
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.other;

import com.google.common.base.Function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 方法推导
 * 什么情况下可以使用方法推导
 * ①：静态方法
 * <p>
 * <p>
 * 2019/5/3  15:50
 * created by zhoumb
 */
public class MethodReference {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        userConsumer(consumer, "Hello,Ailis");

        System.out.println("--------------------------------");
        //use method reference
        userConsumer(System.out::println, "Hello,Method Reference");
        System.out.println("--------------------------------");
        List<Apple> list = Arrays.asList(new Apple("green", 110L), new Apple("red", 113L), new Apple("yellow", 109L));
        System.out.println(list);
        list.sort(((o1, o2) -> (int) (o1.getWeight() - o2.getWeight())));
        System.out.println(list);
        System.out.println("--------------------------------");
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        parseIntFunction.apply("111");
        parseIntFunction.apply("222");

        String str = "Hello World!";
        Function<Integer, Character> characterFunction = str::charAt;
        System.out.println(characterFunction.apply(1));
        System.out.println(characterFunction.apply(2));
        list.sort(Comparator.comparing(Apple::getColor));

        //function
        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
        //consumer
        Consumer<String> test = ConsumerTest::test;
        //predicate

    }

    public static class ConsumerTest {
        public static void test(String str) {
            System.out.println(str);
        }
    }

    public static class PredicateTest {
        public static boolean test(String string) {
            return false;
        }
    }

    private static <T> void userConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
