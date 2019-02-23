/**
 * Date:     2019/2/2122:46
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.lifeCycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现InitializingBean和 DisposableBean
 * 2019/2/21  22:46
 * created by zhoumb
 */
public class Train implements InitializingBean,DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("train disposable destroy() ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("train initializing afterPropertiesSet() ... ");
    }
}
