/**
 * Date:     2019/6/123:55
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda.java8_behavior;

import org.junit.Test;

import java.io.IOException;

/**
 * 2019/6/1  23:55
 * created by zhoumb
 */
public class FileProcessorTest {
    @Test
    public void testDoubleRead() throws IOException {
        System.out.println(FileProcessor.processFile(br -> br.readLine() + br.readLine()));
    }
}
