/**
 * Date:     2019/5/3123:19
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.java8_02_behavior_param_to_deliver_code;

import com.zhou.epitome.java8.bean.Apple;

/**
 * 使用策略模式
 * 2019/5/31  23:19
 * created by zhoumb
 */
public interface AppleFilter {

    boolean filter(Apple apple);

}
