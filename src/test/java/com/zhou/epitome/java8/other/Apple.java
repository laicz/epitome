/**
 * Date:     2019/5/216:35
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.java8.other;

/**
 * 2019/5/2  16:35
 * created by zhoumb
 */
public class Apple {
    private String color;
    private Long weight;

    public Apple(String color, Long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
