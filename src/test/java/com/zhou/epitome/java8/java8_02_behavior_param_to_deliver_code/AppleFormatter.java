/**
 * Date:     2019/5/3123:50
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_02_behavior_param_to_deliver_code;

import com.zhou.epitome.java8.bean.Apple;

/**
 * 编写灵活的PrettyPrintApple方法
 * 2019/5/31  23:50
 * created by zhoumb
 */
public interface AppleFormatter {
    String accept(Apple apple);
}
