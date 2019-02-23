/**
 * Date:     2019/2/2317:03
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.getBean.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 2019/2/23  17:03
 * created by zhoumb
 */
public class Bird {

    @Value("James")
    private String name;
    @Value(value = "#{20 -1}")
    private Integer age;

    @Value(value = "${bird.color}")
    private String color;

    public Bird() {
    }

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Bird(String color) {
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
