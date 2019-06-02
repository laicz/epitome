/**
 * Date:     2019/5/3122:46
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.other;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * 在java8中，lambda和方法也作为一等公民
 * 2019/5/31  22:46
 * created by zhoumb
 */
public class FileTest {

    @Test
    public void testFile() {
        new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] files = new File(".").listFiles(File::isHidden);
    }
}
