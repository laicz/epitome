/**
 * Date:     2019/4/139:44
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.reflect;

/**
 * 2019/4/13  9:44
 * created by zhoumb
 */
public class Robot {
    private String username;

    static {
        System.out.println("static code ");
    }

    public void sayHi(String content) {
        System.out.println(username + ": Hello " + content);
    }

    private String throwHi(String content) {
        return "Throw content" + content;
    }
}
