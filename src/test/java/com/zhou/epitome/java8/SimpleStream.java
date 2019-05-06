/**
 * Date:     2019/5/317:17
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * 2019/5/3  17:17
 * created by zhoumb
 */
public class SimpleStream {

    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("牛排",1000,"肉类"));
        dishes.add(new Dish("香蕉",100,"水果"));
        dishes.add(new Dish("猪肉",900,"肉类"));
        dishes.add(new Dish("葡萄",50,"水果"));
        dishes.add(new Dish("娃娃菜",10,"蔬菜"));

        List<String> strings = Arrays.asList();
        strings.stream().collect(Collectors.toList());

        Map<String, List<Dish>> collect = dishes.stream().filter((Dish dish) -> dish.getCaluli() >= 10).collect(groupingBy(Dish::getCatagory));
        System.out.println(collect);
        dishes.forEach(dish -> {
            System.out.println(dish);
        });
    }

    public static List<String> filtgurationAndSort(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCaluli() < 300)
                .sorted(Comparator.comparing(Dish::getCaluli))
                .map(Dish::getName)
                .collect(toList());
    }

    static class Dish {
        private String name;
        private Integer caluli;
        private String catagory;

        public Dish(String name, Integer caluli, String catagory) {
            this.name = name;
            this.caluli = caluli;
            this.catagory = catagory;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCaluli() {
            return caluli;
        }

        public void setCaluli(Integer caluli) {
            this.caluli = caluli;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }
    }
}
