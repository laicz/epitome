/**
 * Date:     2019/6/123:15
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_03_lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 利用lambda和行为参数化来让代码更为灵活
 * <p>
 * 2019/6/1  23:15
 * created by zhoumb
 */
public class ArroundExecution {

    public static String prcessFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }
}
