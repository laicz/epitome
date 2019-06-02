/**
 * Date:     2019/6/123:39
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_behavior;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 定义函数式接口来传递行为
 * 2019/6/1  23:39
 * created by zhoumb
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader reader) throws IOException;

}
