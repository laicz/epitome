/**
 * Date:     2019/2/2310:46
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用JSR250规范的postConstruct和preDestroy注解
 * 2019/2/23  10:46
 * created by zhoumb
 */
public class Jeep {

    @PostConstruct
    public void init() {
        System.out.println("jeep postConstruct注解 ... ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jeep preDestroy注解 ... ");
    }
}
