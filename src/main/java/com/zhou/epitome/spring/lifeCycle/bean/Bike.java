/**
 * Date:     2019/2/2121:36
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.bean;

/**
 * 2019/2/21  21:36
 * created by zhoumb
 */
public class Bike {

    public Bike() {
        System.out.println("bike constructor ... ");
    }

    public void init() {
        System.out.println("bike init ... ");
    }

    public void destory(){
        System.out.println("bike destory ... ");
    }
}
