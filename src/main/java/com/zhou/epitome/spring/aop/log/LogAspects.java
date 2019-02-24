/**
 * Date:     2019/2/2317:41
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 2019/2/23  17:41
 * created by zhoumb
 */
@Aspect
public class LogAspects {


    @Pointcut("execution(public int com.zhou.epitome.spring.aop.bean.Calculator.*(..))")
    public void pointCut() {

    }

    //    @Before(value = "execution(com.zhou.epitome.spring.aop.bean.Calculator.*(..))")
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("log start ...");
    }

    //    @After(value = "execution(com.zhou.epitome.spring.aop.bean.Calculator.*(..))")
    @After(value = "pointCut()")
    public void logEnd() {
        System.out.println("log end ... ");
    }

    //    @AfterReturning(value = "execution(com.zhou.epitome.spring.aop.bean.Calculator.*(..))")
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("log return ... result=" + result);
    }

    //    @AfterThrowing(value = "execution(com.zhou.epitome.spring.aop.bean.Calculator.*(..))")
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("log exception ... ");
        System.out.println(exception);
    }

    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("log around ... start");
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.asList(args));
        Object proceed = joinPoint.proceed();
        System.out.println("log around ... end");
        return proceed;
    }
}
