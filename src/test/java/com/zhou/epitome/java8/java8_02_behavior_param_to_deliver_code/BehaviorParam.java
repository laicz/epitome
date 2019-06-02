/**
 * Date:     2019/5/3123:17
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_02_behavior_param_to_deliver_code;

import com.zhou.epitome.java8.bean.Apple;
import org.apache.ibatis.javassist.util.proxy.ProxyObjectInputStream;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.fusesource.hawtbuf.BufferInputStream;
import org.junit.Test;

import java.io.*;

/**
 * 2019/5/31  23:17
 * created by zhoumb
 */
public class BehaviorParam {

    @Test
    public void testBehaviorParam() throws IOException {
    }

    private class WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return false;
        }
    }

    private class ColorFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return false;
        }
    }

    private class FilterDecorator implements AppleFilter {
        private AppleFilter appleFilter;

        public FilterDecorator(AppleFilter appleFilter) {
            this.appleFilter = appleFilter;
        }

        @Override
        public boolean filter(Apple apple) {
            return this.appleFilter.filter(apple);
        }
    }
}
