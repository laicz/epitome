/**
 * Date:     2019/3/1923:15
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2019/3/19  23:15
 * created by zhoumb
 */
@RestController
public class Hello2Controller {

    @GetMapping(value = "/hello2")
    public String hello(){
        return "hello2 ...";
    }
}
