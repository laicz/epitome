/**
 * Date:     2019/6/28:24
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_type_check;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;

/**
 * lambda返回的是一个函数式接口
 * 2019/6/2  8:24
 * created by zhoumb
 */
public class TypeCheck {

    /**
     * 同样的lambda，不同的函数式接口
     */
    public void sameLambdaAndNotSameInterface() {
        DoubleSupplier doubleSupplier = () -> 42;
        Callable<Integer> c = () -> 42;

        List<String> stringList = new ArrayList<>();

        Predicate<String> addPredicate = s -> stringList.add("s");
        Consumer<String> consumer = s -> stringList.add(s);
    }
}
