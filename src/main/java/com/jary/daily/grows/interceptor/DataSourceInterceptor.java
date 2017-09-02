package com.jary.daily.grows.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/31 下午4:10
 */
@Aspect
@Component
@Order(0)
public class DataSourceInterceptor {


    @Pointcut("execution(* com.jary.daily.controller.*.*(..))")
    public void dataSourceSwitch(){
        System.out.println("数据源切换切入点");
    }

    @Before("dataSourceSwitch()")
    public void before(JoinPoint joinPoint){
        System.out.println("数据源切换之前所做操作");
    }

    @After("dataSourceSwitch()")
    public void after(JoinPoint joinPoint){
        System.out.println("数据源切换之后所做操作");
    }

}