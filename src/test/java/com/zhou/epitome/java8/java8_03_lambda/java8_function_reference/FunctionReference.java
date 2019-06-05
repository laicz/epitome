/**
 * Date:     2019/6/223:50
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_function_reference;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * 2019/6/2  23:50
 * created by zhoumb
 */
public class FunctionReference {

    @Test
    public void functionReference(){
        Predicate<String> isEmpty = StringUtils::isEmpty;
        Comparator<String> comparing = comparing(String::length);
        BiConsumer<File, String> fileStringBiConsumer = File::new;
    }
}
