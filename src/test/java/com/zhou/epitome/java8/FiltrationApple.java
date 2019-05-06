/**
 * Date:     2019/5/216:37
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2019/5/2  16:37
 * created by zhoumb
 */
public class FiltrationApple {


    @FunctionalInterface
    public interface AppleFilter {

        boolean filter(Apple apple);

    }

    public static List<Apple> findAppple(List<Apple> apples, AppleFilter filter) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (filter.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> greenApple = findGreenApple(Arrays.asList(new Apple("yellow", 20L), new Apple("green", 25L), new Apple("read", 16L)));
        for (Apple apple : greenApple) {
            System.out.println(apple);
        }

        System.out.println("----------------------------------------------------");
        List<Apple> list = Arrays.asList(new Apple("yellow", 20L), new Apple("green", 25L), new Apple("read", 16L));
        List<Apple> appleList = findAppple(list, apple -> apple.getColor().equals("green"));
        System.out.println(appleList);
    }
}
