/**
 * Date:     2019/6/123:42
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_behavior;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 定义一个接受函数式接口为参数的方法
 * 2019/6/1  23:42
 * created by zhoumb
 */
public class FileProcessor {

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\test_lambda.txt")))) {
            return processor.process(reader);
        }
    }

}
