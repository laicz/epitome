/**
 * Date:     2019/4/139:43
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2019/4/13  9:43
 * created by zhoumb
 */
public class ReflectTest {
    @Test
    public void reflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Robot> clazz = Robot.class;
        Robot robot = clazz.newInstance();
        Method sayHi = clazz.getMethod("sayHi", String.class);
        sayHi.invoke(robot, "rob");
        Field username = clazz.getDeclaredField("username");
        username.setAccessible(true);
        username.set(robot,"boni");
        sayHi.invoke(robot,"rob");
    }

    @Test
    public void reflectExtend() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<ViiRobot> viiRobotClass = ViiRobot.class;
        ViiRobot viiRobot = viiRobotClass.newInstance();
        Field username = viiRobotClass.getField("username");
        username.set(viiRobot,"vii robot");
        Method sayHi = viiRobotClass.getDeclaredMethod("sayHi", String.class);
        sayHi.invoke(viiRobot,"rob");
    }

    @Test
    public void loadDiffer() throws ClassNotFoundException {
        Class<Robot> robotClass = Robot.class;
        String name = robotClass.getName();
//        Class<?> aClass = Class.forName("com.zhou.epitome.reflect.Robot");
    }

    @Test
    public void allMethod(){
        Class<ViiRobot> viiRobotClass = ViiRobot.class;
        Method[] methods = viiRobotClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("-----------------------------");
        Method[] declaredMethods = viiRobotClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }
}
